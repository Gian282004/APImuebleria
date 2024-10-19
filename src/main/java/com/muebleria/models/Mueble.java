package com.muebleria.models;

public class Mueble {
    private Integer id;
    private String medida;
    private double precio;
    private Integer stock;
    private String descripcion;

    public Mueble(Integer id, String  medida, double precio, Integer stock, String descripcion) {
        this.id = id;
        this.medida = medida;
        this.precio = precio;
        this.stock = stock;
        this.descripcion = descripcion;
    }
    public Mueble( String medida, double precio, Integer stock, String descripcion) {
        this.medida = medida;
        this.precio = precio;
        this.stock = stock;
        this.descripcion = descripcion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMedida() {
        return medida;
    }

    public void setMedida(String medida) {
        this.medida = medida;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Mueble{" +
                "id=" + id +
                ", medida=" + medida +
                ", precio=" + precio +
                ", stock=" + stock +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}
