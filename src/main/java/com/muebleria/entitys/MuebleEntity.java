package com.muebleria.entitys;

import jakarta.persistence.*;

@Entity
@Table(name="Muebles")
public class MuebleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_producto;

    @Column ( length = 30, nullable = false)
    private String medida;

    @Column(nullable = false)
    private double precio;

    private Integer stock;

    @Column (columnDefinition = "TEXT")
    private String descripcion;

    ///constructor
    public MuebleEntity(Integer id_producto, String medida, double precio, Integer stock, String descripcion) {
        this.id_producto = id_producto;
        this.medida = medida;
        this.precio = precio;
        this.stock = stock;
        this.descripcion = descripcion;
    }
    public  MuebleEntity()
    {

    }
    ///Getters y Setters
    public long getId_producto() {
        return id_producto;
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
}
