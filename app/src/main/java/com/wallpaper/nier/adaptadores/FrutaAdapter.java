package com.wallpaper.nier.adaptadores;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.wallpaper.nier.R;
import com.wallpaper.nier.entidades.Fruta;

import java.util.List;

public class FrutaAdapter extends RecyclerView.Adapter<FrutaAdapter.FrutaHolder>{

    List<Fruta> lsita;
    int layout;
    Fragment activity;

    public FrutaAdapter(List<Fruta> lsita, int layout, Fragment activity) {
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
        Fruta fruta = lsita.get(position);
        holder.txtneim.setText(fruta.getNeim());
        holder.txtid.setText(fruta.getId());
        holder.txturl.setText(fruta.getUrlimg());
        Glide
    }

    @Override
    public int getItemCount() {
        return lsita.size();
    }

    public class FrutaHolder extends RecyclerView.ViewHolder {
        TextView txtid,txturl,txtneim;

        public FrutaHolder(@NonNull View itemView) {
            super(itemView);
            txtid = itemView.findViewById(R.id.item_id);
            txturl = itemView.findViewById(R.id.item_url);
            txtneim = itemView.findViewById(R.id.item_neim);
        }
    }
}
