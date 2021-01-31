package com.example.music.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.music.controller.fragment.AlbumFragment;
import com.example.music.controller.fragment.ArtistFragment;
import com.example.music.controller.fragment.MusicFragment;

public class PagerAdapter extends FragmentStateAdapter {
    private static final int NUMBER_OF_PAGES = 3;

    public PagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return MusicFragment.newInstance();
            case 1:
                return ArtistFragment.newInstance();
            case 2:
                return AlbumFragment.newInstance();
            default:
                return null;
        }
    }

    @Override
    public int getItemCount() {
        return NUMBER_OF_PAGES;
    }
}
