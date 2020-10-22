package com.wallpaper.nier.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.FirebaseDatabase;
import com.wallpaper.nier.R;
import com.wallpaper.nier.entidades.Wallpapers;

import java.util.ArrayList;
import java.util.List;

public class tab3Fragment extends Fragment {

    RecyclerView recyclerView;
    List<Wallpapers> wallpapers;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tab3, container, false);
        recyclerView = view.findViewById(R.id.recyclerViewTab3);

        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),3));

        wallpapers = new ArrayList<>();

        FirebaseDatabase database = FirebaseDatabase.getInstance();



        return view;
    }



}