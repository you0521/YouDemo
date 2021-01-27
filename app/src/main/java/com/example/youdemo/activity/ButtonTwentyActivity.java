package com.example.youdemo.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.example.youdemo.R;
import com.example.youdemo.view.ObservableScrollView;

public class ButtonTwentyActivity extends AppCompatActivity implements ObservableScrollView.ScrollViewListener {

    private LinearLayout mActivityTwentyTitle;
    private ImageView mActivityTwentyImg;
    private ObservableScrollView mActivityTwentyScroll;
    private int mHeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button_twenty);
        initView();
    }

    @Override
    public void onScrollChanged(ObservableScrollView scrollView, int x, int y, int oldx, int oldy) {

        Log.i("TAG", "y--->" + y + "    height-->" + mHeight);
        if (y <= mHeight) {
            float scale = (float) y / mHeight;
            float alpha = (255 * scale);
            Log.i("TAG", "alpha--->" + alpha);

            //layout全部透明
            //layoutHead.setAlpha(scale);

            //只是layout背景透明(仿知乎滑动效果)
            if (alpha >= 0) {
                mActivityTwentyTitle.setBackgroundColor(Color.argb((int) alpha, 0b11001100, 0b0, 0b11111111));
                //mActivityTwentyTitle.setBackgroundColor(alpha, 0b11001100, 0b0, 0b11111111);
                //将颜色转为RGB颜色值
                int color = getResources().getColor(R.color.color_14c7de);
                int red = (color & 0xff0000) >> 16;
                int green = (color & 0x00ff00) >> 8;
                int blue = (color & 0x0000ff);
                mActivityTwentyTitle.setBackgroundColor(Color.argb((int) alpha, red, green, blue));
            }
        }
    }

    private void initView() {
        mActivityTwentyTitle = (LinearLayout) findViewById(R.id.activity_twenty_title);
        mActivityTwentyImg = (ImageView) findViewById(R.id.activity_twenty_img);
        mActivityTwentyScroll = (ObservableScrollView) findViewById(R.id.activity_twenty_scroll);

        ViewTreeObserver viewTreeObserver = mActivityTwentyImg.getViewTreeObserver();
        viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                mActivityTwentyImg.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                mHeight = mActivityTwentyImg.getHeight();
                mActivityTwentyScroll.setScrollViewListener(ButtonTwentyActivity.this);

            }
        });
    }
}
