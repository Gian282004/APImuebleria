package com.muebleria.entitys;

import jakarta.persistence.*;

import java.math.BigDecimal;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Entity
@Table(name = "items")
public class ItemsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_item;
    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @Column(name = "unit_price", nullable = false)
    private BigDecimal unitPrice;

    @Column(name = "total_price", nullable = false)
    private BigDecimal totalPrice;

    @ManyToOne
    @JoinColumn(name = "historial_id", nullable = false)
    private HistorialEntity historial;

    public ItemsEntity() {}

    public ItemsEntity(Integer id_item, String title, Integer quantity, BigDecimal unitPrice, BigDecimal totalPrice) {
       this.id_item=id_item;
        this.title = title;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.totalPrice = totalPrice;
    }

    public Integer getId_item() {
        return id_item;
    }

    public void setId_item(Integer id_item) {
        this.id_item = id_item;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public HistorialEntity getHistorial() {
        return historial;
    }

    public void setHistorial(HistorialEntity historial) {
        this.historial = historial;
    }
}
