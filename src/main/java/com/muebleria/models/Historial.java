package com.muebleria.models;

import java.sql.Date;
import java.util.List;

public class Historial {
    private Integer id;
    private Long paymentId;
    private String userId;
    private Integer amount;
    private String status;
    private Date dateApproved;
    private String paymentMethod;
    private String paymentType;
    private String dateCreated;
    private Payer payer;
    private List<Item> items;

    public Historial( Integer id, Long paymentId, String userId, Integer amount, String status, Date dateApproved, String paymentMethod, String paymentType, String dateCreated, Payer payer, List<Item> items) {
        this.id=id;
        this.paymentId = paymentId;
        this.userId = userId;
        this.amount = amount;
        this.status = status;
        this.dateApproved = dateApproved;
        this.paymentMethod = paymentMethod;
        this.paymentType = paymentType;
        this.dateCreated = dateCreated;
        this.payer = payer;
        this.items = items;
    }

    public Historial(Integer id, Long paymentId, String userId, Integer amount, String status, Date dateApproved, String paymentMethod, String paymentType, String dateCreated) {
        this.id = id;
        this.paymentId = paymentId;
        this.userId = userId;
        this.amount = amount;
        this.status = status;
        this.dateApproved = dateApproved;
        this.paymentMethod = paymentMethod;
        this.paymentType = paymentType;
        this.dateCreated = dateCreated;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    // Getters y Setters
    public Long getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Long paymentId) {
        this.paymentId = paymentId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getDateApproved() {
        return dateApproved;
    }

    public void setDateApproved(Date dateApproved) {
        this.dateApproved = dateApproved;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Payer getPayer() {
        return payer;
    }

    public void setPayer(Payer payer) {
        this.payer = payer;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}

