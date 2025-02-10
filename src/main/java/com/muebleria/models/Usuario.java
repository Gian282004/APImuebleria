package com.muebleria.models;

public class Usuario {
    private Integer id;
    private String username;
    private String contrasenia;
    private String nombre;
    private String email;
    private String phone;

    public Usuario(Integer id, String username, String contrasenia, String nombre, String email, String phone) {
        this.id = id;
        this.username = username;
        this.contrasenia = contrasenia;
        this.nombre=nombre;
        this.email = email;
        this.phone=phone;
    }
    public Usuario(String username, String contrasenia, String nombre, String email, String phone) {
        this.username = username;
        this.contrasenia = contrasenia;
        this.nombre=nombre;
        this.email = email;
        this.phone=phone;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", contrasenia='" + contrasenia + '\'' +
                ", nombre='" + nombre + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
