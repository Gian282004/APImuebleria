package com.muebleria.models;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table (name = "carrito")

public class Carrito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_carrito;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
     private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "id_mueble", nullable = false)
    private Mueble mueble;

    private Float precioTotal;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date fechaCarrito;

   ///constructor

    public Carrito(Integer id_carrito, Usuario usuario, Mueble mueble, Float precioTotal, Date fechaCarrito) {
        this.id_carrito = id_carrito;
        this.usuario = usuario;
        this.mueble = mueble;
        this.precioTotal = precioTotal;
        this.fechaCarrito = fechaCarrito;
    }
    public  Carrito()
    {

    }

    // Getters y Setters

    public long getId_carrito() {
        return id_carrito;
    }

    public void setId_carrito(Integer id_carrito) {
        this.id_carrito = id_carrito;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Mueble getMueble() {
        return mueble;
    }

    public void setMueble(Mueble mueble) {
        this.mueble = mueble;
    }

    public Float getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(Float precioTotal) {
        this.precioTotal = precioTotal;
    }

    public Date getFechaCarrito() {
        return fechaCarrito;
    }

    public void setFechaCarrito(Date fechaCarrito) {
        this.fechaCarrito = fechaCarrito;
    }
}
