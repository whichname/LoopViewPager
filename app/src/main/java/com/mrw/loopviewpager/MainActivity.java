package com.mrw.loopviewpager;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ViewPager vp;
    private ArrayList<String> urls = new ArrayList<>();
    private ViewPagerAdapter viewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        vp = (ViewPager) findViewById(R.id.vp);

        urls.add("http://seopic.699pic.com/photo/00005/5186.jpg_wh1200.jpg");
        urls.add("http://seopic.699pic.com/photo/50010/0719.jpg_wh1200.jpg");
        urls.add("http://seopic.699pic.com/photo/50009/9449.jpg_wh1200.jpg");
        urls.add("http://seopic.699pic.com/photo/50002/5923.jpg_wh1200.jpg");
        urls.add("http://seopic.699pic.com/photo/50001/9330.jpg_wh1200.jpg");
        urls.add("http://seopic.699pic.com/photo/50009/9191.jpg_wh1200.jpg");

        viewPagerAdapter = new ViewPagerAdapter(this,urls,vp);

    }


}
