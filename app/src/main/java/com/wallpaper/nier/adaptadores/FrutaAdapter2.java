package com.wallpaper.nier.adaptadores;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.wallpaper.nier.R;
import com.wallpaper.nier.Vista;
import com.wallpaper.nier.entidades.Fruta2;

import java.util.List;

public class FrutaAdapter2 extends RecyclerView.Adapter<FrutaAdapter2.FrutaHolder>{

    List<Fruta2> lsita;
    int layout;
    Fragment activity;
    private Context context;

    public FrutaAdapter2(List<Fruta2> lsita, int layout, Fragment activity, Context context) {
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
        final Fruta2 fruta2 = lsita.get(position);
        Glide.with(activity).load(fruta2.getUrlimg2()).into(holder.txturl);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Fruta2 fruta2 = lsita.get(position);
                    Intent intent = new Intent(v.getContext(), Vista.class);
                    intent.putExtra("ItemKey", fruta2.getUrlimg2());
                    context.startActivity(intent);
                }catch(Exception e) {
                    Toast.makeText(v.getContext(), "Error, vuelve a pulsar.", Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return lsita.size();
    }

    public static class FrutaHolder extends RecyclerView.ViewHolder {
        ImageView txturl;

        public FrutaHolder(@NonNull final View itemView) {
            super(itemView);
            txturl = itemView.findViewById(R.id.item_url);
        }
    }
}
