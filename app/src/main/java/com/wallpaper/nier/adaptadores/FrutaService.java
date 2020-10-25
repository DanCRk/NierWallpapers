package com.wallpaper.nier.adaptadores;

import com.wallpaper.nier.entidades.Fruta;

import java.util.ArrayList;
import java.util.List;

public class FrutaService {

    public static List<Fruta> frutas= new ArrayList<>();

    public static void addFruta(Fruta fruta){
        frutas.add(fruta);
    }
}
