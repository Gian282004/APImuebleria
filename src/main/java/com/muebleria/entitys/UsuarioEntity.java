package com.muebleria.entitys;

import jakarta.persistence.*;

@Entity
@Table (name = "usuarios")
public class UsuarioEntity {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id_usuario;

    @Column ( name = "nombre_usuario",  nullable = false,length = 40)
    private String nombre_usuario;

    @Column (length = 50,nullable = false)
    private String contrasenia;

    @Column (length = 60,nullable = false,unique = true)
    private String email;

    ///constructor
    public UsuarioEntity(Integer id_usuario, String nombre_usuario, String contrasenia, String email) {
        this.id_usuario = id_usuario;
        this.nombre_usuario = nombre_usuario;
        this.contrasenia = contrasenia;
        this.email = email;
    }
   public  UsuarioEntity()
   {

   }
    ///Getters y setters
    public Integer getId_usuario() {
        return id_usuario;
    }


    public String getNombreUsuario() {
        return nombre_usuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombre_usuario = nombre_usuario;
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
