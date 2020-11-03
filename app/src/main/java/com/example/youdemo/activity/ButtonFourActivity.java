package com.example.youdemo.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.example.youdemo.R;

public class ButtonFourActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView mImg;
    /**
     * come
     */
    private Button mBtn;

    private String url = "http://ww1.sinaimg.cn/large/7a8aed7bjw1ezysj9ytj5j20f00m8wh0.jpg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button_four);
        initView();
    }

    private void initView() {
        mImg = (ImageView) findViewById(R.id.img);
        mBtn = (Button) findViewById(R.id.btn);
        mBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.btn:
                RequestOptions options = new RequestOptions()
                        //占位图
                        .placeholder(R.mipmap.place)
                        //网络不好时加载不出来时显示错误的
                        .error(R.mipmap.errorimage)
                        //不适用缓存
                        .diskCacheStrategy(DiskCacheStrategy.NONE);
                Glide.with(this)
                        .load(url)
                        .apply(options)
                        .into(mImg);
                break;
        }
    }
}
