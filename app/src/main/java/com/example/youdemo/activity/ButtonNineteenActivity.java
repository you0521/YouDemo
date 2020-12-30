package com.example.youdemo.activity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.youdemo.R;

public class ButtonNineteenActivity extends AppCompatActivity implements View.OnClickListener {

    /**
     * 跳转应用商店
     */
    private Button mNineteenBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button_nineteen);
        initView();
    }

    private void initView() {
        mNineteenBtn = (Button) findViewById(R.id.nineteen_btn);
        mNineteenBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.nineteen_btn:
                goAppShop(this,"com.shanxiang.wangxiao","");
                break;
        }
    }

    /**
     * 去应用商城
     * @param context
     * @param myAppPkg 当前app包名
     * @param shopPkg   指定应用商城包名
     */
    public static void goAppShop(Context context, String myAppPkg, String shopPkg) {
        if (TextUtils.isEmpty(myAppPkg)) {
            return;
        }

        try {
            Uri uri = Uri.parse("market://details?id=" + myAppPkg);
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            if (!TextUtils.isEmpty(shopPkg)) {
                intent.setPackage(shopPkg);
            }
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        } catch (Exception e) {
            // 如果没有该应用商店，则显示系统弹出的应用商店列表供用户选择
            goAppShop(context, myAppPkg, "");
        }
    }
}
