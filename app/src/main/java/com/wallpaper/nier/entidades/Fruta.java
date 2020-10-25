package com.wallpaper.nier.entidades;

public class Fruta {
    private String id;
    private String urlimg;

    public Fruta() {
    }

    public Fruta(String id, String urlimg) {
        this.id = id;
        this.urlimg = urlimg;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrlimg() {
        return urlimg;
    }

    public void setUrlimg(String urlimg) {
        this.urlimg = urlimg;
    }


}
