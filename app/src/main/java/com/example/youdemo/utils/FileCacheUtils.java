package com.example.youdemo.utils;

import android.content.Context;

import com.example.youdemo.bean.VideoHistoryBean;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;

/**
 * author：  jcy
 * data：2020/4/16
 * time：10:32
 * description： 本地存储实体类，存储指定数量，如果新增的数量超过存储的总数，那么将删除最早存储的数据
 * 适用于：最近观看记录  、  搜索记录  等
 */
public class FileCacheUtils {

    private static Context mContext;
    private static String mString;

    public FileCacheUtils(Context context, String string) {
        this.mContext = context;
        this.mString = string;

    }

    public LinkedList<VideoHistoryBean> getVideoHistoryFromLocal() {
        LinkedList<VideoHistoryBean> list = null;
        String filePath = mContext.getFilesDir().getAbsolutePath() + File.separator + mString + "_cachae.txt";
        File file = new File(filePath);
        ObjectInputStream oi = null;
        if (file.exists()) {
            try {
                oi = new ObjectInputStream(new FileInputStream(filePath));
                list = (LinkedList<VideoHistoryBean>) oi.readObject();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } finally {
                if (null != oi) {
                    try {
                        oi.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
            }
        }
        return list;
    }

    // 存储历史观看记录
    public boolean updateVideoHistory(VideoHistoryBean bean) {
        boolean isSuccess = false;
        LinkedList<VideoHistoryBean> list = getVideoHistoryFromLocal();
        ObjectOutputStream oo = null;
        if (list != null) {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).cid.equals(bean.cid)) {
                    list.remove(i);
                    break;
                }
            }
            if (list.size() > 50)
                list.removeLast();
        } else {
            list = new LinkedList<>();
        }
        list.addFirst(bean);
        String filePath = mContext.getFilesDir().getAbsolutePath() + File.separator + mString + "_cachae.txt";
        try {
            FileOutputStream outputStream = new FileOutputStream(filePath);
            oo = new ObjectOutputStream(outputStream);
            oo.writeObject(list);
            isSuccess = true;
        } catch (IOException e) {
            isSuccess = false;
        } finally {
            try {
                if (null != oo) {
                    oo.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return isSuccess;
        }
    }

    public boolean clearHistory() {
        boolean isSuccess = false;
        LinkedList<VideoHistoryBean> list = getVideoHistoryFromLocal();
        ObjectOutputStream oo = null;
        list.clear();
        String filePath = mContext.getFilesDir().getAbsolutePath() + File.separator + mString + "_cachae.txt";
        try {
            FileOutputStream outputStream = new FileOutputStream(filePath);
            oo = new ObjectOutputStream(outputStream);
            oo.writeObject(list);
            isSuccess = true;
        } catch (IOException e) {
            isSuccess = false;
        } finally {
            try {
                if (null != oo) {
                    oo.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return isSuccess;
        }
    }
}
