package com.wallpaper.nier.adaptadores;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.wallpaper.nier.R;
import com.wallpaper.nier.entidades.Fruta2;

import java.util.List;

public class FrutaAdapter2 extends RecyclerView.Adapter<FrutaAdapter2.FrutaHolder> implements View.OnClickListener {

    List<Fruta2> lsita;
    int layout;
    Fragment activity;
    private View.OnClickListener listener;

    public FrutaAdapter2(List<Fruta2> lsita, int layout, Fragment activity) {
        this.lsita = lsita;
        this.layout = layout;
        this.activity = activity;
    }

    @NonNull
    @Override
    public FrutaHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(layout, parent, false);
        return new FrutaHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FrutaHolder holder, int position) {
        Fruta2 fruta2 = lsita.get(position);
        Glide.with(activity).load(fruta2.getUrlimg2()).into(holder.txturl);
    }

    @Override
    public int getItemCount() {
        return lsita.size();
    }

    @Override
    public void onClick(View v) {
        if (listener!= null){
            listener.onClick(v);
        }

    }

    public void setOnClickLister(View.OnClickListener lister) {
        this.listener = lister;
    }

    public static class FrutaHolder extends RecyclerView.ViewHolder {
        ImageView txturl;

        public FrutaHolder(@NonNull View itemView) {
            super(itemView);
            txturl = itemView.findViewById(R.id.item_url);
        }
    }
}
