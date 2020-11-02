package com.example.youdemo.Activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.youdemo.R;
import com.example.youdemo.SuperTextView.SuperTextView;

public class ButtonSixActivity extends AppCompatActivity implements View.OnClickListener {

    private SuperTextView mSuperTextView;
    /**
     * Normal
     */
    private Button mBtn1;
    /**
     * Typewriting
     */
    private Button mBtn2;
    /**
     * ChangeColor
     */
    private Button mBtn3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button_six);
        initView();
        mSuperTextView.setDynamicText("莫听穿林打叶声，何妨吟啸且徐行。\n竹杖芒鞋轻胜马，谁怕？一蓑烟雨任平生。");
        mSuperTextView.setOnDynamicListener(new SuperTextView.OnDynamicListener() {
            @Override
            public void onChange(int position) {
                Log.i("Jenly","onChange：" + position);
            }

            @Override
            public void onCompile() {
                Log.i("Jenly","onCompile");
            }
        });
    }

    private void initView() {
        mSuperTextView = (SuperTextView) findViewById(R.id.superTextView);
        mBtn1 = (Button) findViewById(R.id.btn1);
        mBtn1.setOnClickListener(this);
        mBtn2 = (Button) findViewById(R.id.btn2);
        mBtn2.setOnClickListener(this);
        mBtn3 = (Button) findViewById(R.id.btn3);
        mBtn3.setOnClickListener(this);
    }

    private void clickByDynamicStyle(SuperTextView.DynamicStyle style){
        mSuperTextView.setDynamicStyle(style);
        mSuperTextView.start();

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.btn1:
                clickByDynamicStyle(SuperTextView.DynamicStyle.NORMAL);
                break;
            case R.id.btn2:
                clickByDynamicStyle(SuperTextView.DynamicStyle.TYPEWRITING);
                break;
            case R.id.btn3:
                clickByDynamicStyle(SuperTextView.DynamicStyle.CHANGE_COLOR);
                break;
        }
    }
}
