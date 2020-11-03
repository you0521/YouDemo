package com.example.youdemo.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

/**
 * author：  jcy
 * data：2020/10/30
 * time：16:31
 * description：
 */
public class IntentUtils {

    public static void startIntent(Activity activity,Class<?> cls){
        Intent intent = new Intent(activity, cls);
        activity.startActivity(intent);
    }

    /**
     * 跳转
     *
     * @param mActivity
     * @return
     */
    public static void startIntent(Activity mActivity, Class<?> cls, Bundle bundle) {
        Intent mIntent = new Intent(mActivity, cls);
        mIntent.putExtras(bundle);
        mActivity.startActivity(mIntent);
    }

    /**
     * 跳转
     *
     * @param mContext
     * @return
     */
    public static void startIntent(Context mContext, Class<?> cls, Bundle bundle) {
        Intent mIntent = new Intent(mContext, cls);
        mIntent.putExtras(bundle);
        mIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
        mContext.startActivity(mIntent);
    }

    /**
     * 跳转
     *
     * @param mActivity
     * @return
     */
    public static void startIntentForResult(Activity mActivity, Class<?> cls, Bundle bundle, int requestCode) {
        Intent mIntent = new Intent(mActivity, cls);
        mIntent.putExtras(bundle);
        mActivity.startActivityForResult(mIntent, requestCode);
    }
}
