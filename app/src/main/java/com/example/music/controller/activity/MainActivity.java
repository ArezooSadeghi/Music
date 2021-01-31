package com.example.music.controller.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.example.music.R;
import com.example.music.adapter.PagerAdapter;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity {

    private ViewPager2 mViewPager;
    private TabLayout mTabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViews();
        setViewPager();
        createTabLayoutMediator();
    }

    private void findViews() {
        mViewPager = findViewById(R.id.view_pager);
        mTabLayout = findViewById(R.id.tab_layout);
    }

    private void setViewPager() {
        PagerAdapter adapter = new PagerAdapter(this);
        mViewPager.setAdapter(adapter);
    }

    private void createTabLayoutMediator() {
        new TabLayoutMediator(mTabLayout, mViewPager, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                switch (position) {
                    case 0:
                        tab.setIcon(R.drawable.ic_music);
                        tab.setText(R.string.music_title);
                        return;
                    case 1:
                        tab.setIcon(R.drawable.ic_person);
                        tab.setText(R.string.artist_title);
                        return;
                    case 2:
                        tab.setIcon(R.drawable.ic_album);
                        tab.setText(R.string.album_title);
                        return;
                }
            }
        }).attach();
    }

    public static Intent newIntent(Context context) {
        return new Intent(context, MainActivity.class);
    }
}