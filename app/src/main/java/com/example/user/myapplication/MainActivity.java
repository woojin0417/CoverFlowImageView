package com.example.user.myapplication;


import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;

import com.example.user.myapplication.Controller.CoverFlowAdapter;
import com.example.user.myapplication.Model.Model_Image;
import com.github.oliveiradev.image_zoom.lib.widget.ZoomAnimation;

import java.util.ArrayList;

import it.moondroid.coverflow.components.ui.containers.FeatureCoverFlow;

public class MainActivity extends AppCompatActivity {

    private FeatureCoverFlow mCoverFlow;
    private CoverFlowAdapter mAdapter;
    TextView idView;
    TextView countView;
    ArrayList<Model_Image> mData;
    String myAlbumID="KwakGee";
    private TextSwitcher switcher;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
      //  context=getApplication();
        mData=new ArrayList<>();
        idView=(TextView)findViewById(R.id.userID);

        idView.setText(myAlbumID+"의 앨범"); // 아이디

        for(int i=0; i< BaseActivity.imageList.size();i++){
            String id=BaseActivity.imageList.get(i).getId();
            //Log.d("what is id",BaseActivity.imageList.get(i).getID)
            String url= BaseActivity.imageList.get(i).getUrl();
            String tip= BaseActivity.imageList.get(i).getTip();
            String likecount=BaseActivity.imageList.get(i).getLikecount();
            String view=BaseActivity.imageList.get(i).getView();

            if(id.equals(myAlbumID)) {

                mData.add(new Model_Image(url,id,tip,likecount,view));

            }
        }
        String count=String.valueOf(mData.size());

        countView=(TextView)findViewById(R.id.count);
        countView.setText("게시글 수 : " + count + "   대표사진 : 0");

        switcher=(TextSwitcher)findViewById(R.id.text);
        switcher.setFactory(new ViewSwitcher.ViewFactory() {

            @Override
            public View makeView() {
                LayoutInflater inflater = LayoutInflater.from(MainActivity.this);
                TextView textView=(TextView) inflater.inflate(R.layout.item_text, null);
                return textView;
            }
        });
        Animation in = AnimationUtils.loadAnimation(this, R.anim.slide_in_top);
        Animation out = AnimationUtils.loadAnimation(this, R.anim.slide_out_bottom);
        switcher.setInAnimation(in);
        switcher.setOutAnimation(out);
        mAdapter = new CoverFlowAdapter(getApplicationContext(), mData);
        mCoverFlow = (FeatureCoverFlow) findViewById(R.id.coverflow);
        mCoverFlow.setAdapter(mAdapter);

        mCoverFlow.setOnScrollPositionListener(new FeatureCoverFlow.OnScrollPositionListener() {
            @Override
            public void onScrolledToPosition(int position) {
                switcher.setText("2017-09-21    "+ mData.get(position).getLikecount()+" likes"  );
            }

            @Override
            public void onScrolling() {
                switcher.setText("");
            }
        });

    }

}

