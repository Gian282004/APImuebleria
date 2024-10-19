package com.muebleria.DTO;

import com.muebleria.models.Mueble;
import com.muebleria.models.Usuario;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jdk.jfr.Description;

import java.time.LocalDate;
import java.util.Date;

public class CarritoRequest {
    @Schema
    @NotNull
    @Description("El dato debe ser de tipo Usuario")
    private Usuario usuario;

    @Schema
    @NotNull
    @Description("El dato debe ser de tipo mueble")
    private Mueble mueble;

    @Schema
    @NotNull
    private double precioFinal;

    @Schema
    @NotNull
    private LocalDate fechaCarrito;

    public  Usuario getUsuario() {
        return usuario;
    }

    public  Mueble getMueble() {
        return mueble;
    }


    public double getPrecioFinal() {
        return precioFinal;
    }

    public LocalDate getFechaCarrito() {
        return fechaCarrito;
    }
}
