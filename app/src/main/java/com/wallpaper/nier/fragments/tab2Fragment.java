package com.wallpaper.nier.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wallpaper.nier.R;
import com.wallpaper.nier.adaptadores.AdapterTab1;
import com.wallpaper.nier.entidades.Wpp_tab1;

import java.util.ArrayList;

public class tab2Fragment extends Fragment {

    AdapterTab1 adapterTab1;
    RecyclerView recyclerViewpalabras;
    ArrayList<Wpp_tab1> wpp_tab1s;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tab2, container, false);
        recyclerViewpalabras = view.findViewById(R.id.recyclerViewTab2);
        wpp_tab1s = new ArrayList<>();
        // Cargar la lista

        cargarLista();

        //mostrar datos

        mostrarData();

        return view;
    }

    public void cargarLista(){
        wpp_tab1s.add(new Wpp_tab1(R.drawable.wpp_1));
        wpp_tab1s.add(new Wpp_tab1(R.drawable.wpp_2));
        wpp_tab1s.add(new Wpp_tab1(R.drawable.wpp_3));
    }

    public void mostrarData(){
        recyclerViewpalabras.setLayoutManager(new GridLayoutManager(getContext(), 3));
        adapterTab1 = new AdapterTab1(getContext(), wpp_tab1s);
        recyclerViewpalabras.setAdapter(adapterTab1);
    }
}