package com.example.youdemo.bean;

import java.io.Serializable;

/**
 * author：  jcy
 * data：2020/4/16
 * time：10:33
 * description：
 */
public class VideoHistoryBean implements Serializable {
    public String cid;
    public String name;

    public VideoHistoryBean() {
    }

    public VideoHistoryBean(String cid, String name) {
        this.cid = cid;
        this.name = name;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
