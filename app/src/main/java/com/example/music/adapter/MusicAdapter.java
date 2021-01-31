package com.example.music.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.music.R;
import com.example.music.controller.activity.PlayBackContainerActivity;
import com.example.music.model.Music;

import java.util.List;

public class MusicAdapter extends RecyclerView.Adapter<MusicAdapter.MusicHolder> {
    private Context mContext;
    private List<Music> mMusics;

    public MusicAdapter(Context context, List<Music> musics) {
        mContext = context;
        mMusics = musics;
    }

    @NonNull
    @Override
    public MusicHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MusicHolder(LayoutInflater.from(mContext).inflate(
                R.layout.music_adapter_item,
                parent,
                false));
    }

    @Override
    public void onBindViewHolder(@NonNull MusicHolder holder, int position) {
        holder.bindMusic(mMusics.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mContext.startActivity(PlayBackContainerActivity.newIntent(mContext, mMusics.get(position).getId()));
            }
        });
    }

    @Override
    public int getItemCount() {
        return mMusics.size();
    }


    public class MusicHolder extends RecyclerView.ViewHolder {
        private ImageView mImageViewMusic;
        private TextView mTextViewTitle, mTextViewArtistName;

        public MusicHolder(@NonNull View itemView) {
            super(itemView);
            mImageViewMusic = itemView.findViewById(R.id.img_music);
            mTextViewTitle = itemView.findViewById(R.id.txt_music_title);
            mTextViewArtistName = itemView.findViewById(R.id.txt_artist_name);
        }

        public void bindMusic(Music music) {
            mImageViewMusic.setImageBitmap(music.getImage());
            mTextViewTitle.setText(music.getTitle());
            mTextViewArtistName.setText(music.getArtistName());
        }
    }
}
