package com.muebleria.DTO;

import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import jakarta.validation.constraints.NotNull;


@Schema(description = "Payload para la creación de un usuario")
public class UsuarioRequest {
    @Schema(description = "Nombre completo del usuario", example = "Mai Prueba")
    @NotNull
    @Size(min = 3, max = 20, message = "El nombre del usuario debe tener entre 3 y 20 caracteres")
    private String nombre;

    @Schema(description = "Contraseña del usuario", example = "contraseña123")
    @NotNull
    @Hidden
    @Size(min = 8, max = 20, message = "la contrasenia del usuario debe tener entre 8 y 20 caracteres")
    private String contrasenia;
    @Schema(description = "Correo electrónico del usuario", example = "mai@example.com")
    @NotNull
    @Email
    private String email;
    @Schema(description = "Edad del usuario", example = "34")
    @NotNull
    @Min(18)
    @Max(99)
    private int edad;

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    public String getContrasenia() {
        return contrasenia;
    }


    public int getEdad() {
        return edad;
    }
}
