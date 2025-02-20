package com.muebleria.models;

public class Payer{
    private Integer idPayer;
    private String name;
    private String email;
    private String phone;

    public Payer(Integer idPayer, String name, String email, String phone) {
        this.idPayer = idPayer;
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    // Getters y Setters
    public Integer getIdPayer() {
        return idPayer;
    }

    public void setIdPayer(Integer idPayer) {
        this.idPayer = idPayer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
