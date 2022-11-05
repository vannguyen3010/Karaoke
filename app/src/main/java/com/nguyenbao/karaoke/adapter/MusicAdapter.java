package com.nguyenbao.karaoke.adapter;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import com.nguyenbao.karaoke.R;
import com.nguyenbao.karaoke.model.Music;

import java.util.List;

/**
 * Created by NguyenBao on 12/25/2016.
 */

public class MusicAdapter extends ArrayAdapter<Music> {
    Activity context;
    int resource;
    List<Music> objects;

    public MusicAdapter(Activity context, int resource, List<Music> objects) {
        super(context, resource, objects);
        this.context=context;
        this.resource=resource;
        this.objects=objects;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = this.context.getLayoutInflater();
        View row = inflater.inflate(this.resource,null);
        TextView txtMa = (TextView) row.findViewById(R.id.txtMa);
        TextView txtTen = (TextView) row.findViewById(R.id.txtTen);
        TextView txtCasi = (TextView) row.findViewById(R.id.txtCasi);
        ImageButton btnLike = (ImageButton) row.findViewById(R.id.btnLike);
        ImageButton btnDisklike = (ImageButton) row.findViewById(R.id.btnDisklike);

        final Music music = this.objects.get(position);
        txtTen.setText(music.getTen());
        txtMa.setText(music.getMa());
        txtCasi.setText(music.getCasi());

        if (music.isThich()){
            btnLike.setVisibility(View.INVISIBLE);
            btnLike.setVisibility(View.GONE);
            btnDisklike.setVisibility(View.VISIBLE);
        } else {
            btnLike.setVisibility(View.VISIBLE);
            btnDisklike.setVisibility(View.INVISIBLE);
            btnDisklike.setVisibility(View.GONE);
        }

        btnLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xuLyThich(music);
            }
        });

        btnDisklike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xuLyBoThich(music);
            }
        });

        return row;
    }

    private void xuLyBoThich(Music music) {
        music.setThich(false);
    }

    private void xuLyThich(Music music) {
        music.setThich(true);
    }
}
