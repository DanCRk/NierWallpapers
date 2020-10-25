package com.wallpaper.nier.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.wallpaper.nier.adaptadores.FrutaService;
import com.wallpaper.nier.R;
import com.wallpaper.nier.adaptadores.FrutaAdapter;
import com.wallpaper.nier.entidades.Fruta;

public class tab2Fragment extends Fragment {


    RecyclerView recyclerView;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tab2, container, false);
        recyclerView = view.findViewById(R.id.recyclerViewTab2);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 3));

        FrutaAdapter frutaAdapter = new FrutaAdapter(FrutaService.frutas, R.layout.item, getParentFragment());

        recyclerView.setAdapter(frutaAdapter);

        cargarDatos();

        return view;
    }

    public void cargarDatos(){
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference reference = database.getReference("Nier");
        reference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                Fruta fruta = snapshot.getValue(Fruta.class);

                fruta.setId(snapshot.getKey());

                FrutaService.addFruta(fruta);

                recyclerView.getAdapter().notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }



}