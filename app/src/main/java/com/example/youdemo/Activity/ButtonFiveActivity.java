package com.example.youdemo.Activity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.youdemo.R;

public class ButtonFiveActivity extends AppCompatActivity implements View.OnClickListener {

    /**
     * 选择科目
     */
    private Button mMainButton;

    private PopupWindow mPopupWindow;
    private LinearLayout mMainLl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button_five);
        initView();
    }

    private void initView() {
        mMainButton = (Button) findViewById(R.id.main_button);
        mMainButton.setOnClickListener(this);
        mMainLl = (LinearLayout) findViewById(R.id.main_ll);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.main_button:
                showPop();
                break;
        }
    }

    private void showPop() {
        View view = LayoutInflater.from(ButtonFiveActivity.this).inflate(R.layout.pop_one, null);
        TextView tv1 = view.findViewById(R.id.p1_tx1);
        TextView tv2 = view.findViewById(R.id.p1_tx2);
        TextView tv3 = view.findViewById(R.id.p1_tx3);
        tv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ButtonFiveActivity.this, "恭喜", Toast.LENGTH_SHORT).show();
                mPopupWindow.dismiss();
            }
        });

        tv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ButtonFiveActivity.this, "恭喜", Toast.LENGTH_SHORT).show();
                mPopupWindow.dismiss();
            }
        });

        tv3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ButtonFiveActivity.this, "恭喜", Toast.LENGTH_SHORT).show();
                mPopupWindow.dismiss();
            }
        });

        //第一个参数是用于popupwindow中的view
        //第二个参数是popupwindow的宽度
        //第三个参数是popupwindwo的高度
        //第四个参数是popupwindow能否获取焦点
        mPopupWindow = new PopupWindow(view, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, true);
        //给popupwindow设置背景
        //popupWindow.setBackgroundDrawable(getDrawable(R.drawable.ic_launcher_background));
        //设置popupwindow能否响应外部的点击事件
        //popupWindow.setOutsideTouchable(false);
        //设置popupwindow能否响应点击事件
        mPopupWindow.setTouchable(true);
        mPopupWindow.showAtLocation(mMainLl, Gravity.BOTTOM, 0, 0);
        //相对某个控件的位置（正左下方），无偏移
        //showAsDropDown(View anchor)：
        //相对某个控件的位置，有偏移;xoff表示x轴的偏移，正值表示向左，负值表示向右；yoff表示相对y轴的偏移，正值是向下，负值是向上；
        //showAsDropDown(View anchor, int xoff, int yoff)：
        //相对于父控件的位置（例如正中央Gravity.CENTER，下方Gravity.BOTTOM等），可以设置偏移或无偏移
        //showAtLocation(View parent, int gravity, int x, int y)：
    }
}
