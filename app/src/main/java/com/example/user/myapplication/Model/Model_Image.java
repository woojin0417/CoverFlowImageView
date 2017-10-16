package com.example.user.myapplication.Model;

/**
 * Created by user on 2017-10-03.
 */

public class Model_Image {
    String url;
    String id;
    String tip;
    String likecount;
    String view;
    public Model_Image(){

    }
    public Model_Image(String url,String id, String tip, String likecount, String view)
    {
        this.url=url;
        this.id=id;
        this.tip=tip;
        this.likecount=likecount;
        this.view=view;
    }

    public String getId() {
        return id;
    }

    public String getUrl(){
        return url;

    }
    public String getTip(){
        return tip;
    }
    public String getLikecount(){
        return likecount;
    }
    public String getView(){
        return view;
    }
}
