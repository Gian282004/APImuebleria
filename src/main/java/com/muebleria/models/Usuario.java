package com.muebleria.models;

public class Usuario {
    private Integer id;
    private String nombre;
    private String contrasenia;
    private String email;

    public Usuario(Integer id, String nombre, String contrasenia, String email) {
        this.id = id;
        this.nombre = nombre;
        this.contrasenia = contrasenia;
        this.email = email;
    }
    public Usuario(String nombre, String contrasenia, String email) {
        this.nombre = nombre;
        this.contrasenia = contrasenia;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", contrasenia='" + contrasenia + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
