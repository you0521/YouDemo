package com.example.youdemo.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.youdemo.R;
import com.example.youdemo.view.ChartView2;

public class ButtonFifteenActivity extends AppCompatActivity implements View.OnClickListener {

    private ChartView2 mCv;
    /**
     * genggai
     */
    private Button mBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button_fifteen);
        initView();
    }

    private void initView() {
        mCv = (ChartView2) findViewById(R.id.cv);
        mBtn = (Button) findViewById(R.id.btn);
        mBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.btn:
                int[] t = {32,5,9,11,15,20,30,15,5,1};
                mCv.setData(t);
                break;
        }
    }
}
