package com.muebleria.DTO;

import com.muebleria.models.Categoria;
import com.muebleria.models.Imagen;
import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import org.springframework.format.annotation.NumberFormat;

import java.math.BigDecimal;
import java.util.List;

@Schema(description = "Payload para la creación de un usuario")
public class MuebleRequest {

    @Schema(description = "nombre del mueble", example = "Silla de madera")
    @NotNull
    private String  nombre;
    @Schema(description = "Medida del mueble ", example = "50cm X 1.5mts")
    @NotNull
    @Size(min = 3, max = 30, message = "la medida  debe tener entre 3 y 30 caracteres")
    private String medida;
    @Schema(description = "Precio del mueble ", example = "$5000")
    @NotNull
    @Size(min = 1, max = 20, message = "El precio es obligatorio ")
    private BigDecimal precio;
    @Schema(description = "Descripcion del mueble", example = "Silla para cocina de madera excelente para vos")
    @NotNull
    private String  descripcion;

    private List<Imagen> imagenes;
    private List<Categoria>categorias;


    public  String getMedida() {
        return medida;
    }

    public  String getDescripcion() {
        return descripcion;
    }

    public @NotNull String getNombre() {
        return nombre;
    }

    public void setNombre(@NotNull String nombre) {
        this.nombre = nombre;
    }

    public List<Imagen> getImagenes() {
        return imagenes;
    }

    public void setImagenes(List<Imagen> imagenes) {
        this.imagenes = imagenes;
    }

    public List<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<Categoria> categorias) {
        this.categorias = categorias;
    }

    public BigDecimal getPrecio() {
        return precio;
    }
}
