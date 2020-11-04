package com.wallpaper.nier.adaptadores;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.wallpaper.nier.R;
import com.wallpaper.nier.Vista;
import com.wallpaper.nier.entidades.Fruta;

import java.util.List;

public class FrutaAdapter extends RecyclerView.Adapter<FrutaAdapter.FrutaHolder>{

    List<Fruta> lsita;
    int layout;
    Fragment activity;
    Context context;

    public FrutaAdapter(List<Fruta> lsita, int layout, Fragment activity, Context context) {
        this.lsita = lsita;
        this.layout = layout;
        this.activity = activity;
        this.context = context;
    }

    @NonNull
    @Override
    public FrutaHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(layout, parent, false);
        return new FrutaHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FrutaHolder holder, final int position) {
        Fruta fruta = lsita.get(position);
        Glide.with(activity).load(fruta.getUrlimg()).into(holder.txturl);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fruta fruta2 = lsita.get(position);
                Intent intent = new Intent(v.getContext(), Vista.class);
                intent.putExtra("ItemKey", fruta2.getUrlimg());
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return lsita.size();
    }

    public static class FrutaHolder extends RecyclerView.ViewHolder {
        ImageView txturl;

        public FrutaHolder(@NonNull View itemView) {
            super(itemView);
            txturl = itemView.findViewById(R.id.item_url);
        }
    }
}
