package com.example.youdemo.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.youdemo.R;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class ButtonEighteenActivity extends AppCompatActivity implements View.OnClickListener {

    /**
     * 保留一位小数，不四舍五入
     */
    private Button mButtonEightTeenBtn1;
    private TextView mButtonEightTeenTv;
    /**
     * 类型转化问题
     */
    private Button mButtonEightTeenBtn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button_eighteen);
        initView();
    }

    private void initView() {
        mButtonEightTeenBtn1 = (Button) findViewById(R.id.button_eight_teen_btn1);
        mButtonEightTeenBtn1.setOnClickListener(this);
        mButtonEightTeenTv = (TextView) findViewById(R.id.button_eight_teen_tv);
        mButtonEightTeenBtn2 = (Button) findViewById(R.id.button_eight_teen_btn2);
        mButtonEightTeenBtn2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.button_eight_teen_btn1:
                DecimalFormat decimalFormat = new DecimalFormat("#0.#");//若需要进行补位，更改为“#0.0”
                //设置不进行四舍五入，默认是四舍五入的
                decimalFormat.setRoundingMode(RoundingMode.FLOOR);
                float f = (float) 80.96;
                mButtonEightTeenTv.setText(decimalFormat.format(f));
                break;
            case R.id.button_eight_teen_btn2:
                double v1 = Double.parseDouble("95.8");
                int v2 = (int) v1;
                mButtonEightTeenTv.setText(v2 + "is");
                break;
        }
    }
}
