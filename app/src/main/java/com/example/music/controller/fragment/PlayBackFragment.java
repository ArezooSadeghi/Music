package com.example.music.controller.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.music.R;
import com.example.music.model.Music;
import com.example.music.repository.MusicRepository;

import java.util.UUID;

public class PlayBackFragment extends Fragment {

    private ImageView mImageViewMusic;
    private TextView mTextViewTitle, mTextViewArtistName;
    private Music mMusic;
    private MusicRepository mRepository;
    private static final String ARGS_MUSIC_ID = "musicId";

    public static PlayBackFragment newInstance(UUID musicId) {
        PlayBackFragment fragment = new PlayBackFragment();
        Bundle args = new Bundle();
        args.putSerializable(ARGS_MUSIC_ID, musicId);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mRepository = MusicRepository.getInstance();

        UUID musicId = (UUID) getArguments().getSerializable(ARGS_MUSIC_ID);
        mMusic = mRepository.getMusic(musicId);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_play_back, container, false);

        findViews(view);
        initViews();

        return view;
    }

    private void findViews(View view) {
        mImageViewMusic = view.findViewById(R.id.img_music);
        mTextViewTitle = view.findViewById(R.id.txt_music_title);
        mTextViewArtistName = view.findViewById(R.id.txt_artist_name);
    }

    private void initViews() {
        mImageViewMusic.setImageBitmap(mMusic.getImage());
        mTextViewTitle.setText(mMusic.getTitle());
        mTextViewArtistName.setText(mMusic.getArtistName());
    }
}