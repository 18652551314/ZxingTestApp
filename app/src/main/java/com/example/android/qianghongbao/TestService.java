package com.example.android.qianghongbao;

import android.accessibilityservice.AccessibilityService;
import android.app.KeyguardManager;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.PowerManager;
import android.support.annotation.RequiresApi;
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;

/**
 * Created by Android on 2018/3/7.
 */

public class TestService extends AccessibilityService {
    /**
     * 必须重写的方法：此方法用了接受系统发来的event。在你注册的event发生是被调用。在整个生命周期会被调用多次。
     */

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onAccessibilityEvent(AccessibilityEvent event) {
        //得到事件的包名。如果注册了多个应用的事件，可以在此做一个判断。
        String packageName = event.getPackageName().toString();
        //得到对应的事件类型，这里有很多很多种的事件类型，具体可以自行翻阅AccessibilityEvent类中的定义。
        int eventType = event.getEventType();
        //得到根的view节点。可以当做当前acitivity的视图看成是树状结构的（实际上也是~。~），而我们现在就得到了它的根节点。

        AccessibilityNodeInfo root = getRootInActiveWindow();
        //我们可以得到此节点的文字
        String rootText = root.getText().toString();
        //得到此节点的class
        String rootClass = root.getClass().toString();
        //得到子节点的和子节点总数
        root.getChild(root.getChildCount() - 1);

        //这两个方法如果找不到的话，都会报错。所以请做好对应的处理。
//        root.findAccessibilityNodeInfosByText("根据文本内容查找节点");
//        root.findAccessibilityNodeInfosByViewId("根据id查找节点，当然实际上很难知道id是多少~、~");

        //点击操作
        root.performAction(AccessibilityNodeInfo.ACTION_CLICK);
        //滑动操作
        root.performAction(AccessibilityNodeInfo.ACTION_SCROLL_BACKWARD);

        if (event.getEventType() == AccessibilityEvent.TYPE_NOTIFICATION_STATE_CHANGED) {
            /**
             * 解锁
             */
            wakeAndUnlock();

            //打开微信聊天页面
            openWeichaPage(event);
        }
    }

    /**
     * 回到系统桌面
     */
    private void back2Home() {
        Intent home = new Intent(Intent.ACTION_MAIN);
        home.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        home.addCategory(Intent.CATEGORY_HOME);
        startActivity(home);
    }

    private void openWeichaPage(AccessibilityEvent event) {
        if (event.getParcelableData() != null && event.getParcelableData() instanceof Notification) {
            //得到通知的对象
            Notification notification = (Notification) event.getParcelableData();
            // 得到通知栏的信息 //
            String content = notification.tickerText.toString();
            String name = content.substring(0, content.indexOf(":"));
            String scontent = content.substring(content.indexOf(":"), content.length());
            Log.d("mylog", "------openWeichaPage name: " + name + " content: " + scontent);
            // 打开通知栏的intent，即打开对应的聊天界面
            PendingIntent pendingIntent = notification.contentIntent;
            try {
                pendingIntent.send();
            } catch (PendingIntent.CanceledException e) {
                e.printStackTrace();
            }
        }


    }

    private void wakeAndUnlock() {
        //获取电源管理器对象
        PowerManager pm = (PowerManager) getSystemService(Context.POWER_SERVICE);
        //获取PowerManager.WakeLock对象，后面的参数|表示同时传入两个值，最后的是调试用的Tag
        PowerManager.WakeLock wl = pm.newWakeLock(PowerManager.ACQUIRE_CAUSES_WAKEUP | PowerManager.SCREEN_BRIGHT_WAKE_LOCK, "bright");
        //点亮屏幕
        wl.acquire(1000);
        //得到键盘锁管理器对象
        KeyguardManager km = (KeyguardManager) getSystemService(Context.KEYGUARD_SERVICE);
        KeyguardManager.KeyguardLock kl = km.newKeyguardLock("unLock");
        //解锁
        kl.disableKeyguard();

        //释放键盘管理器
        kl.reenableKeyguard();
    }

    /**
     * 必须重写的方法：系统要中断此service返回的响应时会调用。在整个生命周期会被调用多次。
     */

    @Override
    public void onInterrupt() {

    }

    /**
     * 当系统连接上你的服务时被调用
     */
    @Override
    protected void onServiceConnected() {
        super.onServiceConnected();
    }

    /**
     * 在系统要关闭此service时调用。
     */
    @Override
    public boolean onUnbind(Intent intent) {
        return super.onUnbind(intent);
    }

}
