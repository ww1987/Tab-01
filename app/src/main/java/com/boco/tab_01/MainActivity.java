package com.boco.tab_01;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends Activity implements View.OnClickListener {



    private ViewPager mViewPager;
    private PagerAdapter mAdapter;
    private List<View> mViews = new ArrayList<View>();
    // TAB

    private LinearLayout mTabWeixin;
    private LinearLayout mTabFrd;
    private LinearLayout mTabAddress;
    private LinearLayout mTabSetting;

    private ImageButton mWeixinImg;
    private ImageButton mFrdImg;
    private ImageButton mAddressImg;
    private ImageButton mSettingImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        initEvent();
    }

    private void initEvent() {
        mTabWeixin.setOnClickListener(this);
        mTabFrd.setOnClickListener(this);
        mTabAddress.setOnClickListener(this);
        mTabSetting.setOnClickListener(this);

        mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i2) {


            }

            @Override
            public void onPageSelected(int i) {
                int currentItem = mViewPager.getCurrentItem();
                restImg();
                switch (currentItem){
                    case 0 :
                        mWeixinImg.setImageResource(R.drawable.tab_weixin_pressed);
                        break;
                    case 1 :
                        mFrdImg.setImageResource(R.drawable.tab_find_frd_pressed);
                        break;
                    case 2 :
                        mAddressImg.setImageResource(R.drawable.tab_address_pressed);
                        break;
                    case 3 :
                        mSettingImg.setImageResource(R.drawable.tab_settings_pressed);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
    }

    private void initView() {
        mViewPager = (ViewPager) findViewById(R.id.id_viewpager);
        // tabs
        mTabWeixin = (LinearLayout) findViewById(R.id.tab_weixin);
        mTabFrd = (LinearLayout) findViewById(R.id.tab_frd);
        mTabAddress = (LinearLayout) findViewById(R.id.tab_address);
        mTabSetting = (LinearLayout) findViewById(R.id.tab_settings);
        // ImageButton
        mWeixinImg = (ImageButton) findViewById(R.id.weixin_img);
        mFrdImg = (ImageButton) findViewById(R.id.frd_img);
        mAddressImg = (ImageButton) findViewById(R.id.address_img);
        mSettingImg = (ImageButton) findViewById(R.id.settings_img);

        LayoutInflater mInflater = LayoutInflater.from(this);
        View tab01 = mInflater.inflate(R.layout.tab01, null);
        View tab02 = mInflater.inflate(R.layout.tab02, null);
        View tab03 = mInflater.inflate(R.layout.tab03, null);
        View tab04 = mInflater.inflate(R.layout.tab04,null);
        mViews.add(tab01);
        mViews.add(tab02);
        mViews.add(tab03);
        mViews.add(tab04);

        mViewPager.setAdapter(new PagerAdapter() {

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                container.removeView(mViews.get(position));
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                View view = mViews.get(position);
                container.addView(view);
                return view;
            }

            @Override
            public int getCount() {
                return mViews.size();
            }

            @Override
            public boolean isViewFromObject(View view, Object o) {
                return view==o;
            }
        });


    }


    @Override
    public void onClick(View view) {
        restImg();
        switch (view.getId()){
            case R.id.tab_weixin :
                mViewPager.setCurrentItem(0);
                mWeixinImg.setImageResource(R.drawable.tab_weixin_pressed);
                break;
            case R.id.tab_frd :
                mViewPager.setCurrentItem(1);
                mFrdImg.setImageResource(R.drawable.tab_find_frd_pressed);
                break;
            case R.id.tab_address:
                mViewPager.setCurrentItem(2);
                mAddressImg.setImageResource(R.drawable.tab_address_pressed);
                break;
            case R.id.tab_settings :
                mViewPager.setCurrentItem(3);
                mSettingImg.setImageResource(R.drawable.tab_settings_pressed);
                break;
        }
    }

    private void restImg() {
        mWeixinImg.setImageResource(R.drawable.tab_weixin_normal);
        mFrdImg.setImageResource(R.drawable.tab_find_frd_normal);
        mAddressImg.setImageResource(R.drawable.tab_address_normal);
        mSettingImg.setImageResource(R.drawable.tab_settings_normal);
    }
}
