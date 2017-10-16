package com.example.user.myapplication;

import android.util.Log;

import com.example.user.myapplication.Controller.Constants;
import com.example.user.myapplication.Data.ImageVO;
import com.example.user.myapplication.Model.Model_Image;
import com.example.user.myapplication.Retrofit.RetrofitService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by user on 2017-10-03.
 */

public class DataManager {
    public List<Model_Image> tempList;
    public ImageVO repoList;
    public void loadData(){

        Retrofit client = new Retrofit.Builder().baseUrl(Constants.req_URL).addConverterFactory(GsonConverterFactory.create()).build();
        RetrofitService service = client.create(RetrofitService.class);

        Call<ImageVO> call = service.getImageData();
        call.enqueue(new Callback<ImageVO>() {
            @Override
            public void onResponse(Call<ImageVO> call, Response<ImageVO> response) {
                if(response.isSuccessful()){
                    repoList=response.body();
                    tempList=repoList.getList();
                    for(int i=0; i< tempList.size();i++){
                        String url= tempList.get(i).getUrl();
                        String id=tempList.get(i).getId();
                        String tip=tempList.get(i).getTip();
                        String likecount=tempList.get(i).getLikecount();
                        String view=tempList.get(i).getView();
                        Log.d("why???what id",tempList.get(i).getId().toString());
                        Log.d("why???",tempList.get(0).getUrl().toString());

                        BaseActivity.imageList.add(new Model_Image(url,id,tip,likecount,view));
                    }
                }
            }

            @Override
            public void onFailure(Call<ImageVO> call, Throwable t) {
                Log.d("cival","why??");
            }
        });
    }
}
