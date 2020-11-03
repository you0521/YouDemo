package com.example.youdemo.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.youdemo.R;
import com.example.youdemo.bean.MockResult;
import com.example.youdemo.greendao.StudentDaoUtil;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 使用GreenDao存储数据，相关操作，在project 与  app  的Gradle中添加相关依赖（已标出顺序）
 * 之后创建实体类，添加相关注解，重新构建项目（锤一下）之后会生成 DaoMaster 、 DaoSession 、
 * 相关实体类的Dao文件
 */

public class ButtonElevenActivity extends AppCompatActivity implements View.OnClickListener {

    /**
     * 插入
     */
    private Button mInsert;
    /**
     * 查询
     */
    private Button mCha;
    /**
     * 插入一条覆盖
     */
    private Button mCha1;
    /**
     * 指定key查询判空
     */
    private Button mCha2;
    /**
     * 看endtime
     */
    private Button mShowendtime;
    /**
     * 格式化小数点
     */
    private Button mGe;
    /**
     * 转化时间
     */
    private Button mChuo;
    private TextView mShow;

    private StudentDaoUtil mStudentDaoUtil;
    private Long mEnd_time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button_eleven);
        initView();
        mStudentDaoUtil = new StudentDaoUtil(this);
    }

    private void initView() {
        mInsert = (Button) findViewById(R.id.insert);
        mInsert.setOnClickListener(this);
        mCha = (Button) findViewById(R.id.cha);
        mCha.setOnClickListener(this);
        mCha1 = (Button) findViewById(R.id.cha1);
        mCha1.setOnClickListener(this);
        mCha2 = (Button) findViewById(R.id.cha2);
        mCha2.setOnClickListener(this);
        mShowendtime = (Button) findViewById(R.id.showendtime);
        mShowendtime.setOnClickListener(this);
        mGe = (Button) findViewById(R.id.ge);
        mGe.setOnClickListener(this);
        mChuo = (Button) findViewById(R.id.chuo);
        mChuo.setOnClickListener(this);
        mShow = (TextView) findViewById(R.id.show);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.insert:
                List<MockResult> list = new ArrayList<>();
                for (int i = 0; i < 5; i++) {
                    MockResult mockResult = new MockResult((long) i, "jiang" + i, 90 + i);
                    list.add(mockResult);
                }
                mStudentDaoUtil.insertMultStudent(list);
                break;
            case R.id.cha:
                List<MockResult> list1 = mStudentDaoUtil.queryAll();
                String s = "";
                for (int i = 0; i < list1.size(); i++) {
                    s = s + list1.get(i).toString();
                }
                mShow.setText(s);
                break;
            case R.id.cha1:
                MockResult mockResult = new MockResult((long) 3, "you", 90);
                mStudentDaoUtil.insertStudent(mockResult);
                break;
            case R.id.cha2:
                MockResult mockResult1 = mStudentDaoUtil.listOneStudent(6);
                if (mockResult1 != null) {
                    mShow.setText(mockResult1.toString());
                    mEnd_time = mockResult1.getId();
                }
                break;
            case R.id.showendtime:
                if (mEnd_time == null) {
                    mShow.setText("是null");
                }
                break;
            case R.id.ge:
                DecimalFormat df = new DecimalFormat("0.0");//格式化小数
                String num = df.format(98.8);//返回的是String类型
                mShow.setText(num);
                break;
            case R.id.chuo:
                Long timeStamp = System.currentTimeMillis();  //获取当前时间戳
                SimpleDateFormat sdf=new SimpleDateFormat("MM月dd日 HH:mm");
                String sd = sdf.format(timeStamp);
                String sd2 = sdf.format(new Date(timeStamp));
                String sd3 = sdf.format(timeStamp);
                mShow.setText("格式化结果：" + sd+"格式化结果：" + sd2+"格式化结果：" + sd3);
                break;
        }
    }
}
