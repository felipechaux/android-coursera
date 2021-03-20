package com.example.petagram;

public class Mascota {

    private String nombre;
    private String urlImage;
    private int huesitos;

    public Mascota(String nombre, String urlImage, int huesitos) {
        this.nombre = nombre;
        this.urlImage = urlImage;
        this.huesitos = huesitos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    public int getHuesitos() {
        return huesitos;
    }

    public void setHuesitos(int huesitos) {
        this.huesitos = huesitos;
    }
}
