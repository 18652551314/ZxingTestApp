package com.example.android.surface;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * Created by Android on 2018/3/27.
 */

public class MySurfaceView extends SurfaceView implements SurfaceHolder.Callback, Runnable {
    /**
     * 初始化Surface
     */
    private SurfaceHolder mHolder;
    private Canvas mCanvas;//绘图的画布
    private boolean mIsDrawing;//控制绘画线程的标志位

    private void initView() {
        mHolder = getHolder();//获取SurfaceHolder对象
        mHolder.addCallback(this);//注册SurfaceHolder的回调方法
        setFocusable(true);
        setFocusableInTouchMode(true);
        this.setKeepScreenOn(true);
    }


    /**
     * 构造方法
     */
    public MySurfaceView(Context context) {
        super(context);
        initView();
    }

    public MySurfaceView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public MySurfaceView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public MySurfaceView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }


    /**SurfaceHplder.CallBack接口*/
    /**
     * Surface生命周期
     */

    /**
     * 通过SurfaceHolder对象的lockCanvans()方法，我们可以获取当前的Canvas绘图对象。接下来的操作就和自定义View中的绘图操作一样了。
     * 需要注意的是这里获取到的Canvas对象还是继续上次的Canvas对象，而不是一个新的对象。因此，之前的绘图操作都会被保留，如果需要擦除，
     * 则可以在绘制前，通过drawColor()方法来进行清屏操作。
     * 绘制的时候，在surfaceCreated()方法中开启子线程进行绘制，而子线程使用一个while(mIsDrawing)的循环来不停的进行绘制，
     * 在绘制的逻辑中通过lockCanvas()方法获取Canvas对象进行绘制，通过unlockCanvasAndPost(mCanvas)方法对画布内容进行提交
     */
    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        mIsDrawing = true;
        new Thread(this).start();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        mIsDrawing = false;
    }

    /**
     * Runnable接口
     */
    /**
     * 这里说一个优化的地方，这就是在run方法中。
     * <p>
     * 在我们的draw()方法每一次更新所耗费的时间是不确定的。举个例子 比如第一次循环draw() 耗费了1000毫秒 ，
     * 第二次循环draw() 耗时2000毫秒。很明显这样就会造成运行刷新时间时快时慢,可能出现卡顿现象。为此最好保
     * 证每次刷新的时间是相同的，这样可以保证整体画面过渡流畅。
     */
    @Override
    public void run() {
        while (mIsDrawing) {
            draw();
        }
//        while (mIsRunning) {
//
//            /**取得更新之前的时间**/
//            long startTime = System.currentTimeMillis();
//
//            /**在这里加上线程安全锁**/
//            synchronized (mSurfaceHolder) {
//                /**拿到当前画布 然后锁定**/
//                mCanvas =mSurfaceHolder.lockCanvas();
//                draw();
//                /**绘制结束后解锁显示在屏幕上**/
//                mSurfaceHolder.unlockCanvasAndPost(mCanvas);
//            }
//
//            /**取得更新结束的时间**/
//            long endTime = System.currentTimeMillis();
//
//            /**计算出一次更新的毫秒数**/
//            int diffTime  = (int)(endTime - startTime);
//
//            /**确保每次更新时间为30帧**/
//            while(diffTime <=TIME_IN_FRAME) {
//                diffTime = (int)(System.currentTimeMillis() - startTime);
//                /**线程等待**/
//                Thread.yield();
//            }
//
//        }
    }

    //绘图操作
    private void draw() {
        try {
            mCanvas = mHolder.lockCanvas();
            // draw sth绘制过程
        } catch (Exception e) {
        } finally {
            if (mCanvas != null)
                mHolder.unlockCanvasAndPost(mCanvas);//保证每次都将绘图的内容提交
        }
    }
}

