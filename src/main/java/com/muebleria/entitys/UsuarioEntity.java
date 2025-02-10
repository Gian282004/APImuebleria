package com.muebleria.entitys;

import jakarta.persistence.*;

@Entity
@Table (name = "usuarios")
public class UsuarioEntity {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column ( name = "username",  nullable = false,length = 40)
    private String username;

    @Column (length = 50,nullable = false)
    private String contrasenia;

    @Column ( name = "nombre",  nullable = false,length = 40)
    private String nombre;

    @Column (length = 60,unique = true)
    private String email;

    @Column (length = 60)
    private String phone;

    ///constructor
    public UsuarioEntity(Integer id, String username, String contrasenia, String nombre, String email, String phone ) {
        this.id= id;
        this.username = username;
        this.contrasenia = contrasenia;
        this.nombre=nombre;
        this.email = email;
        this.phone=phone;
    }

    public UsuarioEntity(String username, String contrasenia, String nombre, String email, String phone ) {
        this.username = username;
        this.contrasenia = contrasenia;
        this.nombre=nombre;
        this.email = email;
        this.phone=phone;
    }
   public  UsuarioEntity()
   {

   }
    ///Getters y setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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
