package com.muebleria.entitys;

import jakarta.persistence.*;

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
    private Integer unitPrice;

    @Column(name = "total_price", nullable = false)
    private Integer totalPrice;

    public ItemsEntity() {}

    public ItemsEntity(Integer id_item, String title, Integer quantity, Integer unitPrice, Integer totalPrice) {
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

    public Integer getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Integer unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Integer getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Integer totalPrice) {
        this.totalPrice = totalPrice;
    }
}
