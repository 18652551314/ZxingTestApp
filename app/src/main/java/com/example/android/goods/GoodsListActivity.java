package com.example.android.goods;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.android.zxingtestapp.R;

import java.util.ArrayList;
import java.util.List;

public class GoodsListActivity extends AppCompatActivity {

    private RelativeLayout mRootRl;
    private RecyclerView mGoodsRecyclerView;
    private ImageView mCarImageView;
    private TextView mCountTv;

    private List<Bitmap> mBitmapList = new ArrayList<>();
    private PathMeasure mPathMeasure;
    private float[] mCurrentPosition = new float[2];
    private int mCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goods_list);
        initView();
        initData();
        GoodsAdapter goodsAdapter = new GoodsAdapter(mBitmapList);
        mGoodsRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mGoodsRecyclerView.setAdapter(goodsAdapter);
    }

    private void initView() {
        mGoodsRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mCarImageView = (ImageView) findViewById(R.id.imageview_shop_car);
        mCountTv = (TextView) findViewById(R.id.tv_count);
        mRootRl = (RelativeLayout) findViewById(R.id.rl_root);
    }

    private void initData() {
        mBitmapList.add(BitmapFactory.decodeResource(getResources(), R.drawable.clockone));
        mBitmapList.add(BitmapFactory.decodeResource(getResources(), R.drawable.time));
        mBitmapList.add(BitmapFactory.decodeResource(getResources(), R.drawable.digitalclock));
    }

    class GoodsAdapter extends RecyclerView.Adapter<GoodsViewHolder> {

        private List<Bitmap> mData;

        public GoodsAdapter(List<Bitmap> data) {
            mData = data;
        }

        @Override
        public GoodsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(GoodsListActivity.this)
                    .inflate(R.layout.rv_goods_item, parent, false);
            return new GoodsViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(final GoodsViewHolder holder, int position) {
            holder.ivGood.setImageBitmap(mData.get(position));
            holder.tvBuy.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    addGoodToCar(holder.ivGood);
                }
            });
        }

        @Override
        public int getItemCount() {
            return mData != null ? mData.size() : 0;
        }
    }

    private void addGoodToCar(ImageView imageView) {
        final ImageView view = new ImageView(GoodsListActivity.this);
        view.setImageDrawable(imageView.getDrawable());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(100, 100);
        mRootRl.addView(view, layoutParams);

        //二、计算动画开始/结束点的坐标的准备工作
        //得到父布局的起始点坐标（用于辅助计算动画开始/结束时的点的坐标）
        int[] parentLoc = new int[2];
        mRootRl.getLocationInWindow(parentLoc);

        //得到商品图片的坐标（用于计算动画开始的坐标）
        int startLoc[] = new int[2];
        imageView.getLocationInWindow(startLoc);

        //得到购物车图片的坐标(用于计算动画结束后的坐标)
        int endLoc[] = new int[2];
        mCarImageView.getLocationInWindow(endLoc);

        float startX = startLoc[0] - parentLoc[0] + imageView.getWidth() / 2;
        float startY = startLoc[1] - parentLoc[1] + imageView.getHeight() / 2;

        //商品掉落后的终点坐标：购物车起始点-父布局起始点+购物车图片的1/5
        float toX = endLoc[0] - parentLoc[0] + mCarImageView.getWidth() / 5;
        float toY = endLoc[1] - parentLoc[1];

        //开始绘制贝塞尔曲线
        Path path = new Path();
        path.moveTo(startX, startY);
        //使用二次萨贝尔曲线：注意第一个起始坐标越大，贝塞尔曲线的横向距离就会越大，一般按照下面的式子取即可
        path.quadTo((startX + toX) / 2, startY, toX, toY);
        mPathMeasure = new PathMeasure(path, false);

        //属性动画
        ValueAnimator valueAnimator = ValueAnimator.ofFloat(0, mPathMeasure.getLength());
        valueAnimator.setDuration(1000);
        valueAnimator.setInterpolator(new LinearInterpolator());
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float value = (float) animation.getAnimatedValue();
                mPathMeasure.getPosTan(value, mCurrentPosition, null);
                view.setTranslationX(mCurrentPosition[0]);
                view.setTranslationY(mCurrentPosition[1]);
            }
        });
        valueAnimator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                // 购物车的数量加1
                mCount++;
                mCountTv.setText(String.valueOf(mCount));
                // 把移动的图片imageview从父布局里移除
                mRootRl.removeView(view);

                //shopImg 开始一个放大动画
                Animation scaleAnim = AnimationUtils.loadAnimation(GoodsListActivity.this, R.anim.scale);
                mCarImageView.startAnimation(scaleAnim);
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
        valueAnimator.start();
    }

    class GoodsViewHolder extends RecyclerView.ViewHolder {

        private ImageView ivGood;
        private TextView tvBuy;

        public GoodsViewHolder(View itemView) {
            super(itemView);
            ivGood = (ImageView) itemView.findViewById(R.id.iv_goods);
            tvBuy = (TextView) itemView.findViewById(R.id.tv_buy);
        }
    }
}