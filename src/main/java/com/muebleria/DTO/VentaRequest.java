package com.muebleria.DTO;

import com.muebleria.models.Carrito;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jdk.jfr.Description;

public class VentaRequest {
    @Schema
    @NotNull
    @Description(" Pendiente, En proceso, Finalizado ")
    private String estadoPedido;
    @Schema
    @NotNull
    @Description(" El dato debe ser de tipo carrito ")
    private Carrito carrito;

    public @NotNull String getEstadoPedido() {
        return estadoPedido;
    }

    public @NotNull Carrito getCarrito() {
        return carrito;
    }

}
