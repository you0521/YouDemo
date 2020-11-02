package com.example.youdemo;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.youdemo.Activity.ButtonFiveActivity;
import com.example.youdemo.Activity.ButtonFourActivity;
import com.example.youdemo.Activity.ButtonOneActivity;
import com.example.youdemo.Activity.ButtonSixActivity;
import com.example.youdemo.Activity.ButtonThreeActivity;
import com.example.youdemo.Activity.ButtonTwoActivity;
import com.example.youdemo.Utils.IntentUtils;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    /**
     * 按钮整的挺好看
     */
    private Button mBtnOne;
    /**
     * 加载整的挺好看
     */
    private Button mBtnTwo;
    /**
     * 相机整的挺好看
     */
    private Button mBtnThree;
    /**
     * Glide整一下
     */
    private Button mBtnFour;
    /**
     * PopWindow
     */
    private Button mBtnFive;
    /**
     * SuperTextView文字挺好看
     */
    private Button mBtnSix;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mBtnOne = (Button) findViewById(R.id.btn_one);
        mBtnOne.setOnClickListener(this);
        mBtnTwo = (Button) findViewById(R.id.btn_two);
        mBtnTwo.setOnClickListener(this);
        mBtnThree = (Button) findViewById(R.id.btn_three);
        mBtnThree.setOnClickListener(this);
        mBtnFour = (Button) findViewById(R.id.btn_four);
        mBtnFour.setOnClickListener(this);
        mBtnFive = (Button) findViewById(R.id.btn_five);
        mBtnFive.setOnClickListener(this);
        mBtnSix = (Button) findViewById(R.id.btn_six);
        mBtnSix.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.btn_one:
                IntentUtils.startIntent(this, ButtonOneActivity.class);
                break;
            case R.id.btn_two:
                IntentUtils.startIntent(this, ButtonTwoActivity.class);
                break;
            case R.id.btn_three:
                IntentUtils.startIntent(this, ButtonThreeActivity.class);
                break;
            case R.id.btn_four:
                IntentUtils.startIntent(this, ButtonFourActivity.class);
                break;
            case R.id.btn_five:
                IntentUtils.startIntent(this, ButtonFiveActivity.class);
                break;
            case R.id.btn_six:
                IntentUtils.startIntent(this, ButtonSixActivity.class);
                break;
        }
    }
}