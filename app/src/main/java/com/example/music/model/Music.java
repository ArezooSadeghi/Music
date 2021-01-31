package com.example.music.model;

import android.graphics.Bitmap;

import java.util.UUID;

public class Music {

    private UUID mId;
    private String mTitle;
    private String mArtistName;
    private String mDuration;
    private Bitmap mImage;

    public Music(String title, String artistName, String duration, Bitmap image) {
        mId = UUID.randomUUID();
        mTitle = title;
        mArtistName = artistName;
        mDuration = duration;
        mImage = image;
    }

    public UUID getId() {
        return mId;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public String getArtistName() {
        return mArtistName;
    }

    public void setArtistName(String artistName) {
        mArtistName = artistName;
    }

    public String getDuration() {
        return mDuration;
    }

    public void setDuration(String duration) {
        mDuration = duration;
    }

    public Bitmap getImage() {
        return mImage;
    }

    public void setImage(Bitmap image) {
        mImage = image;
    }
}
