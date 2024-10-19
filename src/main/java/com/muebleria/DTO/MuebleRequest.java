package com.muebleria.DTO;

import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import org.springframework.format.annotation.NumberFormat;

public class MuebleRequest {

    @Schema(description = "Medida del mueble ", example = "50cm X 1.5mts")
    @NotNull
    @Size(min = 3, max = 30, message = "la medida  debe tener entre 3 y 30 caracteres")
    private String medida;
    @Schema(description = "Precio del mueble ", example = "$5000")
    @NotNull
    @Size(min = 1, max = 20, message = "El precio es obligatorio ")
    private double precio;
    @Schema(description = " Stock disponible", example = "20")
    @NotNull
    private Integer stock;
    @Schema(description = "Descripcion del mueble", example = "Silla para cocina de madera")
    @NotNull
    private String  descripcion;

    public  String getMedida() {
        return medida;
    }

    public  String getDescripcion() {
        return descripcion;
    }

    public  Integer getStock() {
        return stock;
    }


    public double getPrecio() {
        return precio;
    }
}
