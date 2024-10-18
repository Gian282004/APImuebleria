package com.muebleria.entitys;

import jakarta.persistence.*;

@Entity
@Table(name = "Ventas")
public class VentaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_pedido;

    @Column(length = 20, nullable = false)
    private String estadoPedido;

    @OneToOne
    @JoinColumn(name = "id_carrito", nullable = false)
    private CarritoEntity carrito;

    public VentaEntity(Integer id_pedido, String estadoPedido, CarritoEntity carrito) {
        this.id_pedido = id_pedido;
        this.estadoPedido = estadoPedido;
        this.carrito = carrito;
    }

    ///constructor
    public VentaEntity() {
        // Constructor por defecto necesario para Hibernate
    }


    // Getters y Setters

    public long getId_pedido() {
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

    public CarritoEntity getCarrito() {
        return carrito;
    }

    public void setCarrito(CarritoEntity carrito) {
        this.carrito = carrito;
    }
}
