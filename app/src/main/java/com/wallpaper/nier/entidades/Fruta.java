package com.wallpaper.nier.entidades;

public class Fruta {
    private String id;
    private String neim;
    private String urlimg;

    public Fruta() {
    }

    public Fruta(String id, String neim, String urlimg) {
        this.id = id;
        this.neim = neim;
        this.urlimg = urlimg;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNeim() {
        return neim;
    }

    public void setNeim(String neim) {
        this.neim = neim;
    }

    public String getUrlimg() {
        return urlimg;
    }

    public void setUrlimg(String urlimg) {
        this.urlimg = urlimg;
    }

    @Override
    public boolean equals(Object o) {
        return id.equals(((Fruta)o).id);
    }

}
