package com.example.youdemo.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.youdemo.R;
import com.example.youdemo.view.RatingBar;

public class ButtonTwelveActivity extends AppCompatActivity {

    private RatingBar mRb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button_twelve);
        initView();

//        ratingBar.setClickable(true);//设置可否点击
//        ratingBar.setStar(0f);//设置显示的星星个数
//        ratingBar.setStepSize(RatingBar.StepSize.Full);//设置每次点击增加一颗星还是半颗星
//        ratingBar.setOnRatingChangeListener(new RatingBar.OnRatingChangeListener() {
//            @Override
//            public void onRatingChange(float ratingCount) {//点击星星变化后选中的个数
//                Log.d("RatingBar","RatingBar-Count="+ratingCount);
//            }
//        });
    }

    private void initView() {
        mRb = (RatingBar) findViewById(R.id.rb);
    }
}
