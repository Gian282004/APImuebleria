package com.muebleria.models;

import jakarta.persistence.*;

@Entity
@Table (name = "usuarios")
public class Usuario {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id_usuario;

    @Column ( name = "nombreUsuario",  nullable = false,length = 40)
    private String nombreUsuario;

    @Column (length = 50,nullable = false)
    private String contrasenia;

    @Column (length = 60,nullable = false,unique = true)
    private String email;

    ///constructor
    public Usuario(Integer id_usuario, String nombreUsuario, String contrasenia, String email) {
        this.id_usuario = id_usuario;
        this.nombreUsuario = nombreUsuario;
        this.contrasenia = contrasenia;
        this.email = email;
    }
   public  Usuario()
   {

   }
    ///Getters y setters
    public Integer getId_usuario() {
        return id_usuario;
    }


    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
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
}
