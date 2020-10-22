package com.wallpaper.nier.adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.wallpaper.nier.R;
import com.wallpaper.nier.entidades.Wpp_tab1;

import java.util.ArrayList;

public class AdapterTab1 extends RecyclerView.Adapter<AdapterTab1.ViewHolder> implements View.OnClickListener{

    LayoutInflater inflater;
    public ArrayList<Wpp_tab1> model;

    private View.OnClickListener listener;

    public AdapterTab1(Context context, ArrayList<Wpp_tab1> model){
         this.inflater = LayoutInflater.from(context);
         this.model = model;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.lista_grid, parent, false);
        view.setOnClickListener(this);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        int imagen = model.get(position).getImagenid();
        holder.imageView.setImageResource(imagen);
    }

    @Override
    public int getItemCount() {
        return model.size();
    }

    @Override
    public void onClick(View view) {
        if (listener != null){
            listener.onClick(view);
        }
    }

    public void setOnClickLister(View.OnClickListener lister) {
        this.listener = lister;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
            ImageView imageView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imagen_wpp);
        }
    }

    public void filtrar(ArrayList<Wpp_tab1> filtroPalabras){
        this.model = filtroPalabras;
        notifyDataSetChanged();
    }
}
