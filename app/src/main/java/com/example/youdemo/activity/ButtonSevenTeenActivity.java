package com.example.youdemo.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.youdemo.R;
import com.example.youdemo.enumPage.RoleEnum;

public class ButtonSevenTeenActivity extends AppCompatActivity implements View.OnClickListener {

    /**
     * 获取枚举111
     */
    private Button mActivitySevenTeenBtnOne;
    /**
     * 获取枚举111
     */
    private Button mActivitySevenTeenBtnTwo;
    private TextView mActivitySevenTeenText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button_seven_teen);
        initView();
    }

    private void initView() {
        mActivitySevenTeenBtnOne = (Button) findViewById(R.id.activity_seven_teen_btn_one);
        mActivitySevenTeenBtnOne.setOnClickListener(this);
        mActivitySevenTeenBtnTwo = (Button) findViewById(R.id.activity_seven_teen_btn_two);
        mActivitySevenTeenBtnTwo.setOnClickListener(this);
        mActivitySevenTeenText = (TextView) findViewById(R.id.activity_seven_teen_text);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.activity_seven_teen_btn_one:
                String aadd = RoleEnum.valueOf("ONE").op();
                mActivitySevenTeenText.setText(aadd);
                break;
            case R.id.activity_seven_teen_btn_two:
                String op2 = RoleEnum.getRoleDnum(2).op();
                mActivitySevenTeenText.setText(op2);
                break;
        }
    }
}
