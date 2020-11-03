package com.example.youdemo.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.youdemo.R;
import com.example.youdemo.adapter.ButtonNineRcvAdapter;
import com.example.youdemo.bean.VideoHistoryBean;
import com.example.youdemo.utils.FileCacheUtils;

import java.util.ArrayList;

public class ButtonNineActivity extends AppCompatActivity implements View.OnClickListener {

    /**
     * 请输入要存入的内容
     */
    private EditText mBtnNineEdit;
    /**
     * 存储
     */
    private Button mBtnNineBtn;
    private RecyclerView mBtnNineRcv;
    private ButtonNineRcvAdapter mButtonNineRcvAdapter;
    /**
     * 查询
     */
    private Button mBtnNineSe;
    private FileCacheUtils mYou_demo;
    /**
     * 清空
     */
    private Button mBtnNineClear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button_nine);
        initView();
        mYou_demo = new FileCacheUtils(this, "you_demo");
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mBtnNineRcv.setLayoutManager(linearLayoutManager);
        mButtonNineRcvAdapter = new ButtonNineRcvAdapter(R.layout.button_nine_item, new ArrayList<VideoHistoryBean>());
        mBtnNineRcv.setAdapter(mButtonNineRcvAdapter);
    }

    private void initView() {
        mBtnNineEdit = (EditText) findViewById(R.id.btn_nine_edit);
        mBtnNineBtn = (Button) findViewById(R.id.btn_nine_btn);
        mBtnNineBtn.setOnClickListener(this);
        mBtnNineRcv = (RecyclerView) findViewById(R.id.btn_nine_rcv);
        mBtnNineSe = (Button) findViewById(R.id.btn_nine_se);
        mBtnNineSe.setOnClickListener(this);
        mBtnNineClear = (Button) findViewById(R.id.btn_nine_clear);
        mBtnNineClear.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.btn_nine_btn:
                VideoHistoryBean videoHistoryBean = new VideoHistoryBean(mBtnNineEdit.getText().toString(), mBtnNineEdit.getText().toString());
                mYou_demo.updateVideoHistory(videoHistoryBean);
                break;
            case R.id.btn_nine_se:
                if (mYou_demo.getVideoHistoryFromLocal() != null) {
                    mButtonNineRcvAdapter.replaceData(mYou_demo.getVideoHistoryFromLocal());
                }
                break;
            case R.id.btn_nine_clear:
                mYou_demo.clearHistory();
                mButtonNineRcvAdapter.notifyDataSetChanged();
                break;
        }
    }
}
