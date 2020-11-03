package com.example.youdemo.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.youdemo.R;

public class ButtonTenActivity extends AppCompatActivity implements View.OnClickListener {

    /**
     * 1
     */
    private Button mButtonTenBtnOne;
    /**
     * 2
     */
    private Button mButtonTenBtnTwo;
    /**
     * 3
     */
    private Button mButtonTenBtnThree;
    private ConstraintLayout mButtonNineItemOne;
    private ConstraintLayout mButtonNineItemTwo;
    private ConstraintLayout mButtonNineItemThree;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button_ten);
        initView();
    }

    private void initView() {
        mButtonTenBtnOne = (Button) findViewById(R.id.button_ten_btn_one);
        mButtonTenBtnOne.setOnClickListener(this);
        mButtonTenBtnTwo = (Button) findViewById(R.id.button_ten_btn_two);
        mButtonTenBtnTwo.setOnClickListener(this);
        mButtonTenBtnThree = (Button) findViewById(R.id.button_ten_btn_three);
        mButtonTenBtnThree.setOnClickListener(this);
        mButtonNineItemOne = (ConstraintLayout) findViewById(R.id.button_nine_item_one);
        mButtonNineItemTwo = (ConstraintLayout) findViewById(R.id.button_nine_item_two);
        mButtonNineItemThree = (ConstraintLayout) findViewById(R.id.button_nine_item_three);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.button_ten_btn_one:
                mButtonNineItemOne.setVisibility(View.VISIBLE);
                mButtonNineItemTwo.setVisibility(View.GONE);
                mButtonNineItemThree.setVisibility(View.GONE);
                break;
            case R.id.button_ten_btn_two:
                mButtonNineItemOne.setVisibility(View.GONE);
                mButtonNineItemTwo.setVisibility(View.VISIBLE);
                mButtonNineItemThree.setVisibility(View.GONE);
                break;
            case R.id.button_ten_btn_three:
                mButtonNineItemOne.setVisibility(View.GONE);
                mButtonNineItemTwo.setVisibility(View.GONE);
                mButtonNineItemThree.setVisibility(View.VISIBLE);
                break;
        }
    }
}
