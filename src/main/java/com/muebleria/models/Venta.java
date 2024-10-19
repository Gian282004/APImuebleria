package com.muebleria.models;



public class Venta {

    private Integer id_pedido;


    private String estadoPedido;

    private Carrito carrito;

    public Venta(Integer id_pedido, String estadoPedido, Carrito carrito) {
        this.id_pedido = id_pedido;
        this.estadoPedido = estadoPedido;
        this.carrito = carrito;
    }

    public Venta(Integer id_pedido, String estadoPedido) {
        this.id_pedido = id_pedido;
        this.estadoPedido = estadoPedido;
    }
    public Venta( String estadoPedido, Carrito carrito) {
        this.estadoPedido = estadoPedido;
        this.carrito = carrito;
    }

    public Integer getId_pedido() {
        return id_pedido;
    }

    public void setId_pedido(Integer id_pedido) {
        this.id_pedido = id_pedido;
    }

    public String getEstadoPedido() {
        return estadoPedido;
    }

    public void setEstadoPedido(String estadoPedido) {
        this.estadoPedido = estadoPedido;
    }

    public Carrito getCarrito() {
        return carrito;
    }

    public void setCarrito(Carrito carrito) {
        this.carrito = carrito;
    }
}
