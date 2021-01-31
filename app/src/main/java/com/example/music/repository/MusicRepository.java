package com.example.music.repository;

import com.example.music.model.Music;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class MusicRepository {

    public static MusicRepository sInstance;
    private List<Music> mMusics;

    private MusicRepository() {
        mMusics = new ArrayList<>();
    }

    public static MusicRepository getInstance() {
        if (sInstance == null) {
            sInstance = new MusicRepository();
        }
        return sInstance;
    }

    public List<Music> getMusics() {
        return mMusics;
    }

    public void setMusics(List<Music> musics) {
        mMusics = musics;
    }

    public void insertMusic(Music music) {
        mMusics.add(music);
    }

    public Music getMusic(UUID musicId) {
        for (Music music : mMusics) {
            if (music.getId().equals(musicId)) {
                return music;
            }
        }
        return null;
    }

    public void deleteMusic(UUID musicId) {
        for (Music music : mMusics) {
            if (music.getId().equals(musicId)) {
                mMusics.remove(music);
            }
        }
    }

    public void updateMusic(Music music) {
        Music oldMusic = getMusic(music.getId());
        oldMusic.setTitle(music.getTitle());
        oldMusic.setArtistName(music.getArtistName());
        oldMusic.setDuration(music.getDuration());
        oldMusic.setImage(music.getImage());
    }
}
