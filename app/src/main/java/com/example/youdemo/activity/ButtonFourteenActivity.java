package com.example.youdemo.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.text.style.LeadingMarginSpan;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.youdemo.R;

public class ButtonFourteenActivity extends AppCompatActivity {

    private TextView mTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button_fourteen);
        initView();
        String s = "黑夜来临我趁人我自卑我真的很怕和哦每当黑夜来临的时候我总是很狼狈";
        String inc = "黑夜来临";
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(s);
        LeadingMarginSpan leadingMarginSpan = new LeadingMarginSpan.Standard(86, 0);
        spannableStringBuilder.setSpan(leadingMarginSpan, 0, 1, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        if (s.contains(inc)) {
            int i = s.indexOf(inc);
            spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#0099ee")), i, i+inc.length(), Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        }
        mTv.setText(spannableStringBuilder);
    }

    private void initView() {
        mTv = (TextView) findViewById(R.id.tv);
    }
}
