package com.example.fragment2;

import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends FragmentActivity implements View.OnClickListener{

    private MessageFragment messageFragment;
    private ContactsFragment contactsFragment;
    private NewsFragment newsFragment;
    private SettingFragment settingFragment;
    private View messageLayout;
    /**
     * 在Tab布局上显示消息图标的控件
     */
    private ImageView messageImage;

    /**
     * 在Tab布局上显示联系人图标的控件
     */
    private ImageView contactsImage;

    /**
     * 在Tab布局上显示动态图标的控件
     */
    private ImageView newsImage;

    /**
     * 在Tab布局上显示设置图标的控件
     */
    private ImageView settingImage;

    /**
     * 在Tab布局上显示消息标题的控件
     */
    private TextView messageText;

    /**
     * 在Tab布局上显示联系人标题的控件
     */
    private TextView contactsText;

    /**
     * 在Tab布局上显示动态标题的控件
     */
    private TextView newsText;

    /**
     * 在Tab布局上显示设置标题的控件
     */
    private TextView settingText;

    /**
     * 联系人界面布局
     */
    private View contactsLayout;

    /**
     * 动态界面布局
     */
    private View newsLayout;

    /**
     * 设置界面布局
     */
    private View settingLayout;

    //当前选中的项
    int currenttab=-1;

    ViewPager m_viewPager;
    private int currentPage = 0;
    List<Fragment> fragmentlist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("========MainActivity", "onCreate");
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        messageFragment = new MessageFragment();
        newsFragment = new NewsFragment();
        contactsFragment = new ContactsFragment();
        settingFragment = new SettingFragment();
        fragmentlist = new ArrayList<Fragment>();
        fragmentlist.add(messageFragment);
        fragmentlist.add(contactsFragment);
        fragmentlist.add(newsFragment);
        fragmentlist.add(settingFragment);
        iniViews();
        setTabSelection(currentPage);
    }


    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        Log.d("========MainActivity", "onConfigurationChanged");
        super.onConfigurationChanged(newConfig);
    }

    private void iniViews() {
        m_viewPager = (ViewPager) findViewById(R.id.content);

        messageLayout = findViewById(R.id.message_layout);
        newsLayout = findViewById(R.id.news_layout);
        settingLayout = findViewById(R.id.setting_layout);
        contactsLayout = findViewById(R.id.contacts_layout);
        messageImage = (ImageView) findViewById(R.id.message_image);
        contactsImage = (ImageView) findViewById(R.id.contacts_image);
        messageImage = (ImageView) findViewById(R.id.message_image);
        contactsImage = (ImageView) findViewById(R.id.contacts_image);
        newsImage = (ImageView) findViewById(R.id.news_image);
        settingImage = (ImageView) findViewById(R.id.setting_image);
        messageText = (TextView) findViewById(R.id.message_txt);
        contactsText = (TextView) findViewById(R.id.contacts_txt);
        newsText = (TextView) findViewById(R.id.news_txt);
        settingText = (TextView) findViewById(R.id.setting_txt);
        messageLayout.setOnClickListener(this);
        contactsLayout.setOnClickListener(this);
        newsLayout.setOnClickListener(this);
        settingLayout.setOnClickListener(this);
        m_viewPager.setAdapter(new MyFrageStatePagerAdapter(getSupportFragmentManager()));
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.message_layout:
                setTabSelection(0);
                changeView(0);
                break;
            case R.id.contacts_layout:
                setTabSelection(1);
                changeView(1);
                break;
            case R.id.news_layout:
                setTabSelection(2);
                changeView(2);
                break;
            case R.id.setting_layout:
                setTabSelection(3);
                changeView(3);
                break;
            default:
                break;
        }
    }

    private void setTabSelection(int index) {
        clearSelection();
        switch (index) {
            case 0:
                messageImage.setImageResource(R.drawable.message_selected);
                messageText.setTextColor(Color.WHITE);
                break;
            case 1:
                contactsImage.setImageResource(R.drawable.contacts_selected);
                contactsText.setTextColor(Color.WHITE);
                break;
            case 2:
                newsImage.setImageResource(R.drawable.news_selected);
                newsText.setTextColor(Color.WHITE);
                break;
            case 3:
                settingImage.setImageResource(R.drawable.setting_selected);
                settingText.setTextColor(Color.WHITE);
                break;
            default:
                settingImage.setImageResource(R.drawable.setting_selected);
                settingText.setTextColor(Color.WHITE);
                break;
        }
        getSupportFragmentManager().beginTransaction().commit();
    }

    private void clearSelection() {
        messageImage.setImageResource(R.drawable.message_unselected);
        messageText.setTextColor(Color.parseColor("#82858b"));
        contactsImage.setImageResource(R.drawable.contacts_unselected);
        contactsText.setTextColor(Color.parseColor("#82858b"));
        newsImage.setImageResource(R.drawable.news_unselected);
        newsText.setTextColor(Color.parseColor("#82858b"));
        settingImage.setImageResource(R.drawable.setting_unselected);
        settingText.setTextColor(Color.parseColor("#82858b"));
    }


    private void changeView(int desTab){
        m_viewPager.setCurrentItem(desTab);
    }

    private class MyFrageStatePagerAdapter extends FragmentStatePagerAdapter {

        public MyFrageStatePagerAdapter(android.support.v4.app.FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return fragmentlist.get(position);
        }

        @Override
        public int getCount() {
            return fragmentlist.size();
        }

        @Override
        public void finishUpdate(ViewGroup container) {
            super.finishUpdate(container);
            int currentItem=m_viewPager.getCurrentItem();
            if (currentItem==currenttab) return;
            setTabSelection(currentItem);
            currenttab=currentItem;
        }
    }
}

