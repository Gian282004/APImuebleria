package com.muebleria.Mappers;

import com.muebleria.entitys.ImagenesEntity;
import com.muebleria.models.Imagen;
import org.springframework.stereotype.Component;

@Component
public class ImagenMapper {

    public Imagen toModel(ImagenesEntity imagenesEntity) {
        if (imagenesEntity == null) {
            return null;
        }
        return new Imagen(imagenesEntity.getId_imagen(), imagenesEntity.getImagenURL());
    }

    public ImagenesEntity toEntity(Imagen imagen) {
        if (imagen == null) {
            return null;
        }
        return new ImagenesEntity(imagen.getId(), null, imagen.getUrl()); // El mueble se asignará en la lógica de persistencia
    }
}