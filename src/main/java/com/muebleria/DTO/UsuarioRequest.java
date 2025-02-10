package com.muebleria.DTO;

import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.*;
import jakarta.validation.constraints.NotNull;


@Schema(description = "Payload para la creación de un usuario")
public class UsuarioRequest {
    @Schema(description = "username del usuario", example = "Gian")
    @NotNull
    @Size(min = 3, max = 20, message = "El nombre del usuario debe tener entre 3 y 20 caracteres")
    private String username;
    @Schema(description = "Contraseña del usuario", example = "contraseña123")
    @NotNull
    @Size(min = 8, max = 20, message = "la contrasenia del usuario debe tener entre 8 y 20 caracteres")
    private String contrasenia;
    @Schema(description = "nombre del usuario", example = "Gian Luka Fernandez")
    @NotNull
    private String nombre;
    @Schema(description = "Correo electrónico del usuario", example = "prueba@example.com")
    @Email
    private String email;
    @Schema(description = "telefono del usuario", example = "22345654634")
    @NotNull
    private String phone;


    public @NotNull @Size(min = 3, max = 20, message = "El nombre del usuario debe tener entre 3 y 20 caracteres") String getUsername() {
        return username;
    }

    public void setUsername(@NotNull @Size(min = 3, max = 20, message = "El nombre del usuario debe tener entre 3 y 20 caracteres") String username) {
        this.username = username;
    }

    public @NotNull @Size(min = 8, max = 20, message = "la contrasenia del usuario debe tener entre 8 y 20 caracteres") String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(@NotNull @Size(min = 8, max = 20, message = "la contrasenia del usuario debe tener entre 8 y 20 caracteres") String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public @NotNull String getNombre() {
        return nombre;
    }

    public void setNombre(@NotNull String nombre) {
        this.nombre = nombre;
    }

    public @Email String getEmail() {
        return email;
    }

    public void setEmail(@Email String email) {
        this.email = email;
    }

    public @NotNull String getPhone() {
        return phone;
    }

    public void setPhone(@NotNull String phone) {
        this.phone = phone;
    }
}
