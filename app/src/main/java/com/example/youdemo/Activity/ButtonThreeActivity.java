package com.example.youdemo.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;

import com.example.youdemo.Camera.CameraFragment;
import com.example.youdemo.R;

public class ButtonThreeActivity extends AppCompatActivity {

    private FrameLayout mFrame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //去除title
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        //去掉Activity上面的状态栏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_button_three);
        setFragment();
//        if (hasPermission()) {
//            if (savedInstanceState == null) {
//                setFragment();
//            }
//        } else {
//            requestPermission();
//        }
        initView();
    }

    private void initView() {
        mFrame = (FrameLayout) findViewById(R.id.frame);
    }

//    private boolean hasPermission() {
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//            return checkSelfPermission(Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED;
//        } else {
//            return true;
//        }
//    }
//
//    private void requestPermission() {
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//            if (shouldShowRequestPermissionRationale(Manifest.permission.CAMERA)) {
//                Toast.makeText(MainActivity.this, "Camera permission are required for this demo", Toast.LENGTH_LONG).show();
//            }
//            requestPermissions(new String[]{Manifest.permission.CAMERA}, 1);
//        }
//    }

    private void setFragment() {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frame, CameraFragment.newInstance())
                .commitNowAllowingStateLoss();
    }

}
