package com.muebleria.entitys;

import jakarta.persistence.*;

import java.sql.Date;
import java.time.LocalDate;

@Entity
@Table (name = "carrito")

public class CarritoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_carrito;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
     private UsuarioEntity usuario;

    @ManyToOne
    @JoinColumn(name = "id_producto", nullable = false)
    private MuebleEntity mueble;

    private double precioTotal;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private LocalDate fechaCarrito;

   ///constructor

    public CarritoEntity(Integer id_carrito, UsuarioEntity usuario, MuebleEntity mueble, double precioTotal, LocalDate fechaCarrito) {
        this.id_carrito = id_carrito;
        this.usuario = usuario;
        this.mueble = mueble;
        this.precioTotal = precioTotal;
        this.fechaCarrito = fechaCarrito;
    }
    public  CarritoEntity()
    {

    }

    // Getters y Setters

    public long getId_carrito() {
        return id_carrito;
    }

    public void setId_carrito(Integer id_carrito) {
        this.id_carrito = id_carrito;
    }

    public UsuarioEntity getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioEntity usuario) {
        this.usuario = usuario;
    }

    public MuebleEntity getMueble() {
        return mueble;
    }

    public void setMueble(MuebleEntity mueble) {
        this.mueble = mueble;
    }

    public double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(Float precioTotal) {
        this.precioTotal = precioTotal;
    }

    public LocalDate getFechaCarrito() {
        return fechaCarrito;
    }

    public void setFechaCarrito(LocalDate fechaCarrito) {
        this.fechaCarrito = fechaCarrito;
    }
}
