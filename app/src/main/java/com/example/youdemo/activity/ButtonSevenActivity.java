package com.example.youdemo.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.youdemo.R;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ButtonSevenActivity extends AppCompatActivity implements View.OnClickListener {

    /**
     * huan
     */
    private Button mBtn;
    /**
     * Hello World!
     */
    private TextView mTx;
    /**
     * 获取当前时间
     */
    private Button mGet;
    /**
     * 毫秒转为时间点形式
     */
    private Button mSevenBtnTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button_seven);
        initView();
    }

    private void initView() {
        mBtn = (Button) findViewById(R.id.btn);
        mBtn.setOnClickListener(this);
        mTx = (TextView) findViewById(R.id.tx);
        mGet = (Button) findViewById(R.id.get);
        mGet.setOnClickListener(this);
        mSevenBtnTime = (Button) findViewById(R.id.seven_btn_time);
        mSevenBtnTime.setOnClickListener(this);
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
            case R.id.get:
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");// HH:mm:ss
                //获取当前时间
                Date date = new Date(System.currentTimeMillis());
                String format = simpleDateFormat.format(date);
                mTx.setText(format);
                break;
            case R.id.seven_btn_time:
                String minuteSecond = getMinuteSecond(150000000);
                mTx.setText(minuteSecond);
                break;
        }
    }

    /**
     * 将毫秒数换算成 时间 00:00 形式
     */
    public static String getMinuteSecond(long time) {
        int ss = 1000;
        int mi = ss * 60;
        int hh = mi * 60;
        int dd = hh * 24;

        long day = time / dd;
        long hour = (time - day * dd) / hh;
        long minute = (time - day * dd - hour * hh) / mi;
        long second = (time - day * dd - hour * hh - minute * mi) / ss;

        StringBuffer stringBuffer = new StringBuffer();

        if (day > 0) {
            stringBuffer.append(day + "天");
        }
        if (hour > 0) {
            stringBuffer.append(hour + ":");
        }

        String strMinute = minute < 10 ? "0" + minute : "" + minute;
        String strSecond = second < 10 ? "0" + second : "" + second;
        stringBuffer.append(strMinute + ":" + strSecond);
        return stringBuffer.toString();
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
