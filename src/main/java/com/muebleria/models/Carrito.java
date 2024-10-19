package com.muebleria.models;

import java.time.LocalDate;
import java.util.Date;

public class Carrito {
    private Integer id;
    private Usuario usuarioCarrito;
    private Mueble muebleCarrito;
    private double precioFinal;
    private LocalDate fechaCarrito;

    public Carrito(Integer id, Usuario usuarioCarrito, Mueble muebleCarrito, double precioFinal, LocalDate fechaCarrito) {
        this.id = id;
        this.usuarioCarrito = usuarioCarrito;
        this.muebleCarrito = muebleCarrito;
        this.precioFinal = precioFinal;
        this.fechaCarrito=fechaCarrito;
    }

    public Carrito( Usuario usuarioCarrito, Mueble muebleCarrito, double precioFinal, LocalDate fechaCarrito) {
        this.usuarioCarrito = usuarioCarrito;
        this.muebleCarrito = muebleCarrito;
        this.precioFinal = precioFinal;
        this.fechaCarrito=fechaCarrito;
    }
    public Carrito(Integer id, double precioFinal, LocalDate fechaCarrito)
    {
        this.id=id;
        this.precioFinal=precioFinal;
        this.fechaCarrito=fechaCarrito;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Usuario getUsuarioCarrito() {
        return usuarioCarrito;
    }

    public void setUsuarioCarrito(Usuario usuarioCarrito) {
        this.usuarioCarrito = usuarioCarrito;
    }

    public Mueble getMuebleCarrito() {
        return muebleCarrito;
    }

    public void setMuebleCarrito(Mueble muebleCarrito) {
        this.muebleCarrito = muebleCarrito;
    }

    public double getPrecioFinal() {
        return precioFinal;
    }

    public void setPrecioFinal(double precioFinal) {
        this.precioFinal = precioFinal;
    }

    public LocalDate getFechaCarrito() {
        return fechaCarrito;
    }

    public void setFechaCarrito(LocalDate fechaCarrito) {
        this.fechaCarrito = fechaCarrito;
    }

    @Override
    public String toString() {
        return "Carrito{" +
                "id=" + id +
                ", usuarioCarrito=" + usuarioCarrito +
                ", muebleCarrito=" + muebleCarrito +
                ", precioFinal=" + precioFinal +
                ", fechaCarrito=" + fechaCarrito +
                '}';
    }
}
