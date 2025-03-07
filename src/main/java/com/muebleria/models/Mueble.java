package com.muebleria.models;

import java.math.BigDecimal;
import java.util.List;

public class Mueble {
    private Integer id;
    private String nombre;
    private String medida;
    private BigDecimal precio;
    private String descripcion;


    private List<Imagen> imagenes;

    private List<Categoria> categorias;

    public Mueble(String nombre, String  medida, BigDecimal precio, String descripcion) {
        this.id = id;
        this.nombre=nombre;
        this.medida = medida;
        this.precio = precio;
        this.descripcion = descripcion;
    }




    public Mueble()
    {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMedida() {
        return medida;
    }

    public void setMedida(String medida) {
        this.medida = medida;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<Imagen> getImagenes() {
        return imagenes;
    }

    public void setImagenes(List<Imagen> imagenes) {
        this.imagenes = imagenes;
    }

    public List<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<Categoria> categorias) {
        this.categorias = categorias;
    }

    @Override
    public String toString() {
        return "Mueble{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", medida='" + medida + '\'' +
                ", precio=" + precio +
                ", descripcion='" + descripcion + '\'' +
                ", imagenes=" + imagenes +
                ", categorias=" + categorias +
                '}';
    }
}
