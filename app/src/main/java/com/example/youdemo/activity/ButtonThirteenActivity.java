package com.example.youdemo.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.youdemo.R;
import com.example.youdemo.bean.IMyServer;
import com.example.youdemo.bean.ImageBean;
import com.example.youdemo.bean.JokeBean;
import com.example.youdemo.bean.LoginBean;
import com.example.youdemo.bean.NewBean;
import com.example.youdemo.bean.ShanXiangBean;

import java.util.HashMap;
import java.util.Map;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ButtonThirteenActivity extends AppCompatActivity implements View.OnClickListener {

    /**
     * get不传参
     */
    private Button mBtnGet1;
    /**
     * get传参
     */
    private Button mBtnGet2;
    /**
     * get url拼接地址
     */
    private Button mBtnGet3;
    /**
     * get path
     */
    private Button mBtnGet4;
    /**
     * get header
     */
    private Button mBtnGet5;
    /**
     * get headers
     */
    private Button mBtnGet6;
    /**
     * post不传参
     */
    private Button mBtnPost1;
    /**
     * post传参
     */
    private Button mBtnPost2;
    /**
     * post url动态拼接
     */
    private Button mBtnPost3;
    /**
     * post Multipart
     */
    private Button mBtnPost4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button_thirteen);
        initView();
    }

    //get无参
    private void get1() {
        //第一步 创建retrofit
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(IMyServer.shanxiang)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        //第二步 创建接口
        IMyServer img = retrofit.create(IMyServer.class);
        //第三步 创建call对象
        Call<ShanXiangBean> call = img.getImageList();
        call.enqueue(new Callback<ShanXiangBean>() {
            @Override
            public void onResponse(Call<ShanXiangBean> call, Response<ShanXiangBean> response) {
//                ShanXiangBean result = response.body();
////                Log.i("result", result.toString());
                String s = response.body().toString();
                Log.i("result", s);
            }

            @Override
            public void onFailure(Call<ShanXiangBean> call, Throwable t) {
                Log.i("onFailure", t.getMessage());
            }
        });

    }

    //get动态传参 query
    private void get2() {
        //第一步 创建retrofit
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(IMyServer.base_url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        //第二步 创建接口
        IMyServer img = retrofit.create(IMyServer.class);
        //第三步 创建call对象
        Call<ImageBean> call = img.getImageList1("2");
        call.enqueue(new Callback<ImageBean>() {
            @Override
            public void onResponse(Call<ImageBean> call, Response<ImageBean> response) {
                ImageBean result = response.body();
                Log.i("result", result.toString());
            }

            @Override
            public void onFailure(Call<ImageBean> call, Throwable t) {
                Log.i("onFailure", t.getMessage());
            }
        });
    }

    //get动态传参 query
    private void get3() {
        //第一步 创建retrofit
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(IMyServer.base_url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        //第二步 创建接口
        IMyServer img = retrofit.create(IMyServer.class);
        //第三步 创建call对象
        Call<ImageBean> call = img.getImageList3("imagelist?", "1");
        call.enqueue(new Callback<ImageBean>() {
            @Override
            public void onResponse(Call<ImageBean> call, Response<ImageBean> response) {
                ImageBean result = response.body();
                Log.i("result", result.toString());
            }

            @Override
            public void onFailure(Call<ImageBean> call, Throwable t) {
                Log.i("onFailure", t.getMessage());
            }
        });
    }

    //get动态传参 path
    private void get4() {
        //第一步 创建retrofit
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(IMyServer.base_url1)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        //第二步 创建接口
        IMyServer myServer = retrofit.create(IMyServer.class);
        //第三步 创建call对象
        Call<NewBean> call = myServer.getNew(1);
        call.enqueue(new Callback<NewBean>() {
            @Override
            public void onResponse(Call<NewBean> call, Response<NewBean> response) {
                NewBean result = response.body();
                Log.i("result", result.toString());
            }

            @Override
            public void onFailure(Call<NewBean> call, Throwable t) {
                Log.i("onFailure", t.getMessage());
            }
        });
    }

    //get动态传参 header querymap
    private void get5() {
        //第一步 创建retrofit
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(IMyServer.base_url2)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        //第二步 创建接口
        IMyServer myServer = retrofit.create(IMyServer.class);
        Map<String, String> map = new HashMap<>();
        map.put("maxResult", "20");
        map.put("time", "2016-07-01");
        map.put("page", "1");
        //第三步 创建call对象
        Call<JokeBean> call = myServer.getJoke("APPCODE db33b75c89524a56ac94d6519e106a59", map);
        call.enqueue(new Callback<JokeBean>() {
            @Override
            public void onResponse(Call<JokeBean> call, Response<JokeBean> response) {
                JokeBean result = response.body();
                Log.i("result", result.toString());
            }

            @Override
            public void onFailure(Call<JokeBean> call, Throwable t) {
                Log.i("onFailure", t.getMessage());
            }
        });
    }

    //get动态传参 headers
    private void get6() {
        //第一步 创建retrofit
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(IMyServer.base_url2)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        //第二步 创建接口
        IMyServer myServer = retrofit.create(IMyServer.class);
        //第三步 创建call对象
        Call<JokeBean> call = myServer.getJoke1();
        call.enqueue(new Callback<JokeBean>() {
            @Override
            public void onResponse(Call<JokeBean> call, Response<JokeBean> response) {
                JokeBean result = response.body();
                Log.i("result", result.toString());
            }

            @Override
            public void onFailure(Call<JokeBean> call, Throwable t) {
                Log.i("onFailure", t.getMessage());
            }
        });
    }

    //post登录动态传参
    private void post1() {
        //第一步 创建retrofit
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(IMyServer.base_url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        //第二步 创建接口
        IMyServer log = retrofit.create(IMyServer.class);
        //第三步 创建call对象
        Call<LoginBean> call = log.login("zq", "123456");
        call.enqueue(new Callback<LoginBean>() {
            @Override
            public void onResponse(Call<LoginBean> call, Response<LoginBean> response) {
                LoginBean loginBean = response.body();
                Log.i("loginBean", loginBean.toString());
            }

            @Override
            public void onFailure(Call<LoginBean> call, Throwable t) {
                Log.i("onFailure", t.getMessage());
            }
        });
    }

    //post动态传参 HashMap
    private void post2() {
        //第一步 创建retrofit
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(IMyServer.base_url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        //第二步 创建接口
        IMyServer log = retrofit.create(IMyServer.class);
        Map<String, String> mapLogin = new HashMap<>();
        mapLogin.put("username", "zq");
        mapLogin.put("password", "123456");
        //第三步 创建call对象
        Call<LoginBean> call = log.login1(mapLogin);
        call.enqueue(new Callback<LoginBean>() {
            @Override
            public void onResponse(Call<LoginBean> call, Response<LoginBean> response) {
                LoginBean loginBean = response.body();
                Log.i("loginBean", loginBean.toString());
            }

            @Override
            public void onFailure(Call<LoginBean> call, Throwable t) {
                Log.i("onFailure", t.getMessage());
            }
        });
    }

    //post map
    private void post3() {
        //第一步 创建retrofit
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(IMyServer.base_url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        //第二步 创建接口
        IMyServer log = retrofit.create(IMyServer.class);
        Map<String, String> mapLogin = new HashMap<>();
        mapLogin.put("username", "zq");
        mapLogin.put("password", "123456");
        //第三步 创建call对象
        Call<LoginBean> call = log.login3("login", mapLogin);
        call.enqueue(new Callback<LoginBean>() {
            @Override
            public void onResponse(Call<LoginBean> call, Response<LoginBean> response) {
                LoginBean loginBean = response.body();
                Log.i("loginBean", loginBean.toString());
            }

            @Override
            public void onFailure(Call<LoginBean> call, Throwable t) {
                Log.i("onFailure", t.getMessage());
            }
        });
    }

    //post Multipart body Part
    private void post4() {
        //第一步 创建retrofit
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(IMyServer.base_url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        //第二步 创建接口
        IMyServer log = retrofit.create(IMyServer.class);
        RequestBody data_name = RequestBody.create(MediaType.parse("application/json"), "zq");
        RequestBody data_pw = RequestBody.create(MediaType.parse("application/json"), "123456");
        //第三步 创建call对象
        Call<LoginBean> call = log.sendLogin(data_name, data_pw);
        call.enqueue(new Callback<LoginBean>() {
            @Override
            public void onResponse(Call<LoginBean> call, Response<LoginBean> response) {
                LoginBean loginBean = response.body();
                Log.i("loginBean", loginBean.toString());
            }

            @Override
            public void onFailure(Call<LoginBean> call, Throwable t) {
                Log.i("onFailure", t.getMessage());
            }
        });

    }

    private void initView() {
        mBtnGet1 = (Button) findViewById(R.id.btn_get1);
        mBtnGet1.setOnClickListener(this);
        mBtnGet2 = (Button) findViewById(R.id.btn_get2);
        mBtnGet2.setOnClickListener(this);
        mBtnGet3 = (Button) findViewById(R.id.btn_get3);
        mBtnGet3.setOnClickListener(this);
        mBtnGet4 = (Button) findViewById(R.id.btn_get4);
        mBtnGet4.setOnClickListener(this);
        mBtnGet5 = (Button) findViewById(R.id.btn_get5);
        mBtnGet5.setOnClickListener(this);
        mBtnGet6 = (Button) findViewById(R.id.btn_get6);
        mBtnGet6.setOnClickListener(this);
        mBtnPost1 = (Button) findViewById(R.id.btn_post1);
        mBtnPost1.setOnClickListener(this);
        mBtnPost2 = (Button) findViewById(R.id.btn_post2);
        mBtnPost2.setOnClickListener(this);
        mBtnPost3 = (Button) findViewById(R.id.btn_post3);
        mBtnPost3.setOnClickListener(this);
        mBtnPost4 = (Button) findViewById(R.id.btn_post4);
        mBtnPost4.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.btn_get1:
                get1();
                break;
            case R.id.btn_get2:
                get2();
                break;
            case R.id.btn_get3:
                get3();
                break;
            case R.id.btn_get4:
                get4();
                break;
            case R.id.btn_get5:
                get5();
                break;
            case R.id.btn_get6:
                get6();
                break;
            case R.id.btn_post1:
                post1();
                break;
            case R.id.btn_post2:
                post2();
                break;
            case R.id.btn_post3:
                post3();
                break;
            case R.id.btn_post4:
                post4();
                break;
        }
    }
}
