package com.example.youdemo.bean;

import java.util.Map;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

public interface IMyServer {

    String base_url = "http://yun918.cn/study/public/index.php/";
    //https://gank.io/api/data/%E7%A6%8F%E5%88%A9/10/1
    String base_url1 = "https://gank.io/api/data/%E7%A6%8F%E5%88%A9/10/";
    //https://ali-joke.showapi.com/textJoke?maxResult=20&time=2016-07-01&page=1
    String base_url2 = "https://ali-joke.showapi.com/";
    String shanxiang = "http://pxbd.mold.com/api/mold/";


    //get 不传参
//    @GET("imagelist?uid=1")
//    Call<ImageBean> getImageList();
    @GET("moldlists")
    Call<ShanXiangBean> getImageList();

    //get query传参
    @GET("imagelist?")
    Call<ImageBean> getImageList1(@Query("uid") String uid);

    //String username,String password
    @POST("login")
    @FormUrlEncoded
    Call<LoginBean> login(@Field("username") String username, @Field("password") String pw);

    //String username,String password
    @POST("login")
    @FormUrlEncoded
    Call<LoginBean> login1(@FieldMap Map<String, String> map);

    //通过get url注解动态拼接
    @GET
    Call<ImageBean> getImageList3(@Url String url, @Query("uid") String uid);

    //通过post url注解动态拼接
    @POST
    @FormUrlEncoded
    Call<LoginBean> login3(@Url String url, @FieldMap Map<String, String> map);

    //path
    @GET("{page}")
    Call<NewBean> getNew(@Path("page") int page);

    //设置header , headers  接口和参数textJoke?maxResult=20&time=2016-07-01&page=1
    @GET("textJoke?")
    Call<JokeBean> getJoke(@Header("Authorization") String string, @QueryMap Map<String, String> map);

    //设置headers
    @Headers({"Authorization:APPCODE db33b75c89524a56ac94d6519e106a59","Content-Type:application/json; charset=utf-8"})
    @GET("textJoke?maxResult=20&time=2016-07-01&page=1")
    Call<JokeBean> getJoke1();

    //参数 String username,String password
    @Multipart
    @POST("login")
    Call<LoginBean> sendLogin(@Part("username") RequestBody username, @Part("password") RequestBody pw);


}
