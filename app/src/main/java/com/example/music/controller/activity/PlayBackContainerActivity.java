package com.example.music.controller.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import com.example.music.controller.fragment.PlayBackFragment;

import java.util.UUID;

public class PlayBackContainerActivity extends SingleFragmentActivity {

    private static final String EXTRA_MUSIC_ID = "com.example.music.musicId";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public Fragment createFragment() {
        Intent intent = getIntent();
        UUID musicId = (UUID) intent.getSerializableExtra(EXTRA_MUSIC_ID);
        return PlayBackFragment.newInstance(musicId);
    }

    public static Intent newIntent(Context context, UUID musicId) {
        Intent intent = new Intent(context, PlayBackContainerActivity.class);
        intent.putExtra(EXTRA_MUSIC_ID, musicId);
        return intent;
    }
}