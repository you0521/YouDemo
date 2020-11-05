package com.example.youdemo.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.youdemo.MainActivity;
import com.example.youdemo.R;
import com.example.youdemo.view.CustomPopWindow;

public class ButtonSixteenActivity extends AppCompatActivity implements View.OnClickListener {

    /**
     * 自定义popWindow
     */
    private Button mShare;
    private CustomPopWindow mPopwindow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button_sixteen);
        initView();
    }

    private void initView() {
        mShare = (Button) findViewById(R.id.share);
        mShare.setOnClickListener(this);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        float x = ev.getX();
        float y = ev.getY();
        Log.i("1233", "onTouchEvent: x::"+x+" y::"+y+" return value::"+super.dispatchTouchEvent(ev));
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        return super.onTouchEvent(event);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.share:
                mPopwindow = new CustomPopWindow(ButtonSixteenActivity.this, itemsOnClick);
                mPopwindow.showAtLocation(v,
                        Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 0);
                mPopwindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
                    @Override
                    public void onDismiss() {
                        mPopwindow.backgroundAlpha(ButtonSixteenActivity.this, 1f);
                    }
                });
                break;
            default:
                break;
        }
    }


    //为弹出窗口实现监听类
    private View.OnClickListener itemsOnClick = new View.OnClickListener() {

        public void onClick(View v) {
            mPopwindow.dismiss();
            switch (v.getId()) {
                case R.id.ll_wechat_share:
                    Toast.makeText(ButtonSixteenActivity.this, "微信好友", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.ll_wechat_zone:
                    Toast.makeText(ButtonSixteenActivity.this, "朋友圈", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.ll_qq_share:
                    Toast.makeText(ButtonSixteenActivity.this, "QQ好友", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.ll_qq_zone:
                    Toast.makeText(ButtonSixteenActivity.this, "QQ空间", Toast.LENGTH_SHORT).show();
                    break;
                default:
                    break;
            }
        }

    };
}
