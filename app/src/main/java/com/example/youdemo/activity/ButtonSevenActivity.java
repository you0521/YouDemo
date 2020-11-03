package com.example.youdemo.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.youdemo.R;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ButtonSevenActivity extends AppCompatActivity implements View.OnClickListener {

    /**
     * huan
     */
    private Button mBtn;
    /**
     * 算
     */
    private Button mJisuan;
    /**
     * Hello World!
     */
    private TextView mTx;
    /**
     * 获取当前时间
     */
    private Button mGet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button_seven);
        initView();
    }

    private void initView() {
        mBtn = (Button) findViewById(R.id.btn);
        mBtn.setOnClickListener(this);
        mJisuan = (Button) findViewById(R.id.jisuan);
        mJisuan.setOnClickListener(this);
        mTx = (TextView) findViewById(R.id.tx);
        mGet = (Button) findViewById(R.id.get);
        mGet.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.btn:
                long time = 1592202650;
                String s = stampToDate(time);
                mTx.setText(s);
                break;
            case R.id.jisuan:
                DecimalFormat df = new DecimalFormat("00.0");//格式化小数
                String num = df.format((float) 9 / 57 * 100);//返回的是String类型
                mTx.setText(num + "%");
                break;
            case R.id.get:
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");// HH:mm:ss
                //获取当前时间
                Date date = new Date(System.currentTimeMillis());
                String format = simpleDateFormat.format(date);
                mTx.setText(format);
                break;
        }
    }

    /*
     * 将时间戳转换为时间
     * 需要什么格式填入即可："yyyy-MM-dd HH:mm:ss"  完成格式
     *          例如："HH:mm"   转化后只保留时分
     */
    public static String stampToDate(Long time) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time_Date = sdf.format(new Date(time * 1000));
        return time_Date;
    }
}
