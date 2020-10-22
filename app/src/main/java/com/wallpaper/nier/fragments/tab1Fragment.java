package com.wallpaper.nier.fragments;

import android.app.WallpaperManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.wallpaper.nier.R;
import com.wallpaper.nier.adaptadores.AdapterTab1;
import com.wallpaper.nier.entidades.Wallpapers;

import java.io.IOException;
import java.util.ArrayList;

public class tab1Fragment extends Fragment {

    AdapterTab1 adapterTab1;
    RecyclerView recyclerViewpalabras;
    ArrayList<Wallpapers> wpp_tab1s;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tab1, container, false);
        recyclerViewpalabras = view.findViewById(R.id.recyclerViewTab1);
        wpp_tab1s = new ArrayList<>();
        // Cargar la lista

        cargarLista();

        //mostrar datos

        mostrarData();

        return view;
    }

    public void cargarLista(){
        wpp_tab1s.add(new Wallpapers(R.drawable.wpp_1));
        wpp_tab1s.add(new Wallpapers(R.drawable.wpp_2));
        wpp_tab1s.add(new Wallpapers(R.drawable.wpp_3));
        wpp_tab1s.add(new Wallpapers(R.drawable.wpp_1));
        wpp_tab1s.add(new Wallpapers(R.drawable.wpp_2));
        wpp_tab1s.add(new Wallpapers(R.drawable.wpp_3));
        wpp_tab1s.add(new Wallpapers(R.drawable.wpp_1));
        wpp_tab1s.add(new Wallpapers(R.drawable.wpp_2));
        wpp_tab1s.add(new Wallpapers(R.drawable.wpp_3));
        wpp_tab1s.add(new Wallpapers(R.drawable.wpp_1));
        wpp_tab1s.add(new Wallpapers(R.drawable.wpp_2));
        wpp_tab1s.add(new Wallpapers(R.drawable.wpp_3));
        wpp_tab1s.add(new Wallpapers(R.drawable.wpp_1));
        wpp_tab1s.add(new Wallpapers(R.drawable.wpp_2));
        wpp_tab1s.add(new Wallpapers(R.drawable.wpp_3));
        wpp_tab1s.add(new Wallpapers(R.drawable.wpp_1));
        wpp_tab1s.add(new Wallpapers(R.drawable.wpp_2));
        wpp_tab1s.add(new Wallpapers(R.drawable.wpp_3));
        wpp_tab1s.add(new Wallpapers(R.drawable.wpp_1));
        wpp_tab1s.add(new Wallpapers(R.drawable.wpp_2));
        wpp_tab1s.add(new Wallpapers(R.drawable.wpp_3));
        wpp_tab1s.add(new Wallpapers(R.drawable.wpp_1));
        wpp_tab1s.add(new Wallpapers(R.drawable.wpp_2));
        wpp_tab1s.add(new Wallpapers(R.drawable.wpp_3));
        wpp_tab1s.add(new Wallpapers(R.drawable.wpp_1));
        wpp_tab1s.add(new Wallpapers(R.drawable.wpp_2));
        wpp_tab1s.add(new Wallpapers(R.drawable.wpp_3));
    }


    @RequiresApi(api = Build.VERSION_CODES.N)
    private void setWallpaperlock() {
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.wpp_1);
        WallpaperManager manager = WallpaperManager.getInstance(getContext());
        try{
            manager.setBitmap(bitmap,null, true,WallpaperManager.FLAG_LOCK);
        } catch (IOException e) {
            Toast.makeText(getContext(), "Error!", Toast.LENGTH_SHORT).show();
        }
    }

    private void setWallpaper() {
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.wpp_3);
        WallpaperManager manager = WallpaperManager.getInstance(getContext());
        try{
            manager.setBitmap(bitmap);
        } catch (IOException e) {
            Toast.makeText(getContext(), "Error!", Toast.LENGTH_SHORT).show();
        }
    }

    public void mostrarData(){
        recyclerViewpalabras.setLayoutManager(new GridLayoutManager(getContext(),3));
        adapterTab1 = new AdapterTab1(getContext(), wpp_tab1s);
        recyclerViewpalabras.setAdapter(adapterTab1);

        adapterTab1.setOnClickLister(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setWallpaper();
                Toast.makeText(getContext(),"Toast", Toast.LENGTH_LONG).show();
            }
        });
    }
}