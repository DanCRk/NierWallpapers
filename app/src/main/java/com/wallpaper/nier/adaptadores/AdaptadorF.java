package com.wallpaper.nier.adaptadores;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.wallpaper.nier.R;
import com.wallpaper.nier.entidades.Wallpapers;

import java.util.List;


public class AdaptadorF extends RecyclerView.Adapter<AdaptadorF.ImagenesviewHolder>{

    List<Wallpapers> wpps;

    public AdaptadorF(List<Wallpapers> wpps) {
        this.wpps = wpps;
    }

    @NonNull
    @Override
    public ImagenesviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_grid,parent, false);
        return new ImagenesviewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ImagenesviewHolder holder, int position) {
        Wallpapers wallpapers = wpps.get(position);
        holder.wppver.setImageResource(wallpapers.getImagenid());
    }

    @Override
    public int getItemCount() {
        return wpps.size();
    }

    public static class ImagenesviewHolder extends RecyclerView.ViewHolder{

        ImageView wppver;

        public ImagenesviewHolder(@NonNull View itemView) {
            super(itemView);
            wppver = itemView.findViewById(R.id.imagen_wpp);
        }
    }
}
