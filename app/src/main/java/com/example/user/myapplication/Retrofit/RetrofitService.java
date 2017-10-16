package com.example.user.myapplication.Retrofit;

import com.example.user.myapplication.Data.ImageVO;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by user on 2017-10-03.
 */

public interface RetrofitService {
    @GET("/upload")
    Call<ImageVO> getImageData();
}
