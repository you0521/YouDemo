package com.example.youdemo.activity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import androidx.appcompat.app.AppCompatActivity;

import com.example.youdemo.R;

public class ButtonTwentyOneActivity extends AppCompatActivity implements View.OnClickListener {

    private View mAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button_twenty_one);
        initView();

    }

    private void initView() {
        mAnimation = (View) findViewById(R.id.animation);
        mAnimation.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.animation:
                //android:duration	setDuration(long)
                // 动画持续时间，毫秒为单位
                //android:ShareInterpolator	setInterpolator(Interpolator)
                // 设定插值器（指定的动画效果，譬如回弹等）
                //android:fillAfter	setFillAfter(boolean)
                // 控件动画结束时是否保持动画最后的状态
                //android:fillBefore	setFillBefore(boolean)
                // 控件动画结束时是否还原到开始动画前的状态
                //android:repeatMode	setRepeatMode(int)
                // 重复类型有两个值，reverse表示倒序回放，restart表示从头播放
                //android:startOffset	setStartOffset(long)<span class="Apple-tab-span" style="white-space:pre"></span>
                // 调用start函数之后等待开始运行的时间，单位为毫秒
                Animation animation = AnimationUtils.loadAnimation(ButtonTwentyOneActivity.this, R.anim.donghua_anim);
                //动画结束后停留在当前位置
                animation.setFillAfter(true);
                mAnimation.startAnimation(animation);
                break;
        }
    }
}
