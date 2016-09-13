package com.mrw.loopviewpager;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/8/29.
 */
public class ViewPagerAdapter extends PagerAdapter implements ViewPager.OnPageChangeListener{

//    当前页面
    private int currentPosition = 0;

    private Context mContext;
    private ArrayList<ImageView> imageViews;
    private ViewPager mViewPager;

    public ViewPagerAdapter(Context context,ArrayList<String> datas,ViewPager viewPager) {
        mContext = context;
        imageViews = new ArrayList<>();
//        如果数据大于一条
        if(datas.size() > 1) {
//            添加最后一页到第一页
            datas.add(0,datas.get(datas.size()-1));
//            添加第一页(经过上行的添加已经是第二页了)到最后一页
            datas.add(datas.get(1));
        }
        for (String data:datas) {
            imageViews.add(getImageViews(data));
        }
        mViewPager = viewPager;
        viewPager.setAdapter(this);
        viewPager.addOnPageChangeListener(this);
        viewPager.setCurrentItem(1,false);
    }

    @Override
    public int getCount() {
        return imageViews.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(imageViews.get(position));
        return imageViews.get(position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(imageViews.get(position));
    }

    private ViewGroup.LayoutParams layoutParams;

    private ImageView getImageViews(String url) {
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        }
        ImageView imageView = new ImageView(mContext);
        imageView.setLayoutParams(layoutParams);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        ImageUtils.loadImage(mContext, url, imageView);
        return imageView;
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
    }

    @Override
    public void onPageSelected(int position) {
        currentPosition = position;
    }

    @Override
    public void onPageScrollStateChanged(int state) {
//        若viewpager滑动未停止，直接返回
        if (state != ViewPager.SCROLL_STATE_IDLE) return;
//        若当前为第一张，设置页面为倒数第二张
        if (currentPosition == 0) {
            mViewPager.setCurrentItem(imageViews.size()-2,false);
        } else if (currentPosition == imageViews.size()-1) {
//        若当前为倒数第一张，设置页面为第二张
            mViewPager.setCurrentItem(1,false);
        }
    }


}
