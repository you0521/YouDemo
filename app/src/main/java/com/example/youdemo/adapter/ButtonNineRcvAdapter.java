package com.example.youdemo.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.youdemo.R;
import com.example.youdemo.bean.VideoHistoryBean;

import java.util.List;

/**
 * author：  jcy
 * data：2020/11/3
 * time：9:45
 * description：
 */
public class ButtonNineRcvAdapter extends BaseQuickAdapter<VideoHistoryBean, BaseViewHolder> {

    public ButtonNineRcvAdapter(int layoutResId, @Nullable List<VideoHistoryBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, VideoHistoryBean item) {
        helper.setText(R.id.button_nine_item_tv,item.getName());
    }
}
