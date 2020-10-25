package com.wallpaper.nier.adaptadores;

import com.wallpaper.nier.entidades.Fruta2;

import java.util.ArrayList;
import java.util.List;

public class FrutaService2 {

    public static List<Fruta2> frutas= new ArrayList<>();

    public static void addFruta(Fruta2 fruta){
        frutas.add(fruta);
    }
}
