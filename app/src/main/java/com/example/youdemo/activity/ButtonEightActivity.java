package com.example.youdemo.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.youdemo.R;
import com.example.youdemo.dialog.CustomDialog;

public class ButtonEightActivity extends AppCompatActivity implements View.OnClickListener {

    /**
     * 只有确认按钮
     */
    private Button mEightOne;
    /**
     * 确认和取消按钮，取消无事件
     */
    private Button mEightTwo;
    /**
     * 都有，并且都有点击时事件
     */
    private Button mEightThree;

    private CustomDialog mDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button_eight);
        initView();
    }

    private void initView() {
        mEightOne = (Button) findViewById(R.id.eight_one);
        mEightOne.setOnClickListener(this);
        mEightTwo = (Button) findViewById(R.id.eight_two);
        mEightTwo.setOnClickListener(this);
        mEightThree = (Button) findViewById(R.id.eight_three);
        mEightThree.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.eight_one:
                mDialog=new CustomDialog(this, "温馨提示", "确定要退出我们可爱的App吗?", "确定",new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mDialog.dismiss();
                        Toast.makeText(ButtonEightActivity.this,"退出了--伤心",Toast.LENGTH_LONG).show();
                    }
                });
                break;
            case R.id.eight_two:
                mDialog = new CustomDialog(this, "温馨提示", "确定要退出我们可爱的App吗?", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        mDialog.dismiss();
                        Toast.makeText(ButtonEightActivity.this,"退出了--伤心",Toast.LENGTH_LONG).show();
                    }
                },"确认","取消");
                break;
            case R.id.eight_three:
                mDialog = new CustomDialog(this, "温馨提示", "确定要退出我们可爱的App吗", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        mDialog.dismiss();
                        Toast.makeText(ButtonEightActivity.this,"退出了--伤心",Toast.LENGTH_LONG).show();
                    }
                }, new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        mDialog.dismiss();
                        Toast.makeText(ButtonEightActivity.this,"取消了 -- 开心",Toast.LENGTH_LONG).show();
                    }
                },"确认","取消");
                break;
        }
        mDialog.setCanotBackPress();
        mDialog.setCanceledOnTouchOutside(false);
        mDialog.show();
    }
}
