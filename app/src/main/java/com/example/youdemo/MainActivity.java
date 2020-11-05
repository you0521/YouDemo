package com.example.youdemo;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.youdemo.activity.ButtonEightActivity;
import com.example.youdemo.activity.ButtonElevenActivity;
import com.example.youdemo.activity.ButtonFifteenActivity;
import com.example.youdemo.activity.ButtonFiveActivity;
import com.example.youdemo.activity.ButtonFourActivity;
import com.example.youdemo.activity.ButtonFourteenActivity;
import com.example.youdemo.activity.ButtonNineActivity;
import com.example.youdemo.activity.ButtonOneActivity;
import com.example.youdemo.activity.ButtonSevenActivity;
import com.example.youdemo.activity.ButtonSixActivity;
import com.example.youdemo.activity.ButtonSixteenActivity;
import com.example.youdemo.activity.ButtonTenActivity;
import com.example.youdemo.activity.ButtonThirteenActivity;
import com.example.youdemo.activity.ButtonThreeActivity;
import com.example.youdemo.activity.ButtonTwelveActivity;
import com.example.youdemo.activity.ButtonTwoActivity;
import com.example.youdemo.utils.IntentUtils;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    /**
     * 按钮整的挺好看
     */
    private Button mBtnOne;
    /**
     * 加载整的挺好看
     */
    private Button mBtnTwo;
    /**
     * 相机整的挺好看
     */
    private Button mBtnThree;
    /**
     * Glide整一下
     */
    private Button mBtnFour;
    /**
     * PopWindow
     */
    private Button mBtnFive;
    /**
     * SuperTextView文字挺好看
     */
    private Button mBtnSix;
    /**
     * 时间、小数点转化
     */
    private Button mBtnSeven;
    /**
     * 确认弹窗Dialog
     */
    private Button mBtnEight;
    /**
     * 本地存储记录
     */
    private Button mBtnNine;
    /**
     * 绝对布局
     */
    private Button mBtnTen;
    /**
     * GreenDao
     */
    private Button mBtnEleven;
    /**
     * RatingBar
     */
    private Button mBtnTwelve;
    /**
     * Retrofit请求
     */
    private Button mBtnThirteen;
    /**
     * tab
     */
    private Button mBtnFourteen;
    /**
     * 柱状图
     */
    private Button mBtnFifteen;
    /**
     * 分享弹窗
     */
    private Button mBtnSixteen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mBtnOne = (Button) findViewById(R.id.btn_one);
        mBtnOne.setOnClickListener(this);
        mBtnTwo = (Button) findViewById(R.id.btn_two);
        mBtnTwo.setOnClickListener(this);
        mBtnThree = (Button) findViewById(R.id.btn_three);
        mBtnThree.setOnClickListener(this);
        mBtnFour = (Button) findViewById(R.id.btn_four);
        mBtnFour.setOnClickListener(this);
        mBtnFive = (Button) findViewById(R.id.btn_five);
        mBtnFive.setOnClickListener(this);
        mBtnSix = (Button) findViewById(R.id.btn_six);
        mBtnSix.setOnClickListener(this);
        mBtnSeven = (Button) findViewById(R.id.btn_seven);
        mBtnSeven.setOnClickListener(this);
        mBtnEight = (Button) findViewById(R.id.btn_eight);
        mBtnEight.setOnClickListener(this);
        mBtnNine = (Button) findViewById(R.id.btn_nine);
        mBtnNine.setOnClickListener(this);
        mBtnTen = (Button) findViewById(R.id.btn_ten);
        mBtnTen.setOnClickListener(this);
        mBtnEleven = (Button) findViewById(R.id.btn_eleven);
        mBtnEleven.setOnClickListener(this);
        mBtnTwelve = (Button) findViewById(R.id.btn_twelve);
        mBtnTwelve.setOnClickListener(this);
        mBtnThirteen = (Button) findViewById(R.id.btn_thirteen);
        mBtnThirteen.setOnClickListener(this);
        mBtnFourteen = (Button) findViewById(R.id.btn_fourteen);
        mBtnFourteen.setOnClickListener(this);
        mBtnFifteen = (Button) findViewById(R.id.btn_fifteen);
        mBtnFifteen.setOnClickListener(this);
        mBtnSixteen = (Button) findViewById(R.id.btn_sixteen);
        mBtnSixteen.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.btn_one:
                IntentUtils.startIntent(this, ButtonOneActivity.class);
                break;
            case R.id.btn_two:
                IntentUtils.startIntent(this, ButtonTwoActivity.class);
                break;
            case R.id.btn_three:
                IntentUtils.startIntent(this, ButtonThreeActivity.class);
                break;
            case R.id.btn_four:
                IntentUtils.startIntent(this, ButtonFourActivity.class);
                break;
            case R.id.btn_five:
                IntentUtils.startIntent(this, ButtonFiveActivity.class);
                break;
            case R.id.btn_six:
                IntentUtils.startIntent(this, ButtonSixActivity.class);
                break;
            case R.id.btn_seven:
                IntentUtils.startIntent(this, ButtonSevenActivity.class);
                break;
            case R.id.btn_eight:
                IntentUtils.startIntent(this, ButtonEightActivity.class);
                break;
            case R.id.btn_nine:
                IntentUtils.startIntent(this, ButtonNineActivity.class);
                break;
            case R.id.btn_ten:
                IntentUtils.startIntent(this, ButtonTenActivity.class);
                break;
            case R.id.btn_eleven:
                IntentUtils.startIntent(this, ButtonElevenActivity.class);
                break;
            case R.id.btn_twelve:
                IntentUtils.startIntent(this, ButtonTwelveActivity.class);
                break;
            case R.id.btn_thirteen:
                IntentUtils.startIntent(this, ButtonThirteenActivity.class);
                break;
            case R.id.btn_fourteen:
                IntentUtils.startIntent(this, ButtonFourteenActivity.class);
                break;
            case R.id.btn_fifteen:
                IntentUtils.startIntent(this, ButtonFifteenActivity.class);
                break;
            case R.id.btn_sixteen:
                IntentUtils.startIntent(this, ButtonSixteenActivity.class);
                break;
        }
    }
}
