package com.example.music.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.media.MediaMetadataRetriever;
import android.net.Uri;

import com.example.music.R;
import com.example.music.model.Music;

import java.util.ArrayList;
import java.util.List;

public class ExtractMetadata {

    public static List<Music> getMusicInformation(Context context) {
        List<Music> musics = new ArrayList<>();
        int[] mMusicIds = new int[]{
                R.raw.khabeto_didam,
                R.raw.man_ye_divoonam,
                R.raw.khoshhalam,
                R.raw.faghat_boro,
                R.raw.del_nakan,
                R.raw.basame,
                R.raw.ashegham_karde,
                R.raw.akhmato_va_kon
        };

        MediaMetadataRetriever metadataRetriever = new MediaMetadataRetriever();

        for (int i = 0; i < mMusicIds.length; i++) {
            Uri mediaPath = Uri.parse("android.resource://" + context.getPackageName() + "/" + mMusicIds[i]);
            metadataRetriever.setDataSource(context, mediaPath);

            String title = metadataRetriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_TITLE);
            if (title == null) {
                title = context.getResources().getString(R.string.no_title);
            }
            String artistName = metadataRetriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_ARTIST);
            if (artistName == null) {
                artistName = context.getResources().getString(R.string.no_artist_name);
            }
            String duration = metadataRetriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_DURATION);

            byte[] artBytes = metadataRetriever.getEmbeddedPicture();
            Bitmap image = ((BitmapDrawable) context.getResources().getDrawable(R.drawable.image_test)).getBitmap();
            if (artBytes != null) {
                image = BitmapFactory.decodeByteArray(artBytes, 0, artBytes.length);
            }

            Music music = new Music(title, artistName, duration, image);
            musics.add(music);
        }
        return musics;
    }
}

