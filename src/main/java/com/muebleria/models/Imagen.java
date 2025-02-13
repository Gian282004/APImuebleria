package com.muebleria.models;

public class Imagen {
    private int id;
    private String url;

    public Imagen(int id, String url) {
        this.id = id;
        this.url = url;
    }

    public Imagen(String url) {
        this.url = url;
    }

    //GETTERS Y SETTERS


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
