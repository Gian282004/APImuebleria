package com.muebleria.Mappers;

import com.muebleria.entitys.ImagenesEntity;
import com.muebleria.models.Imagen;
import org.springframework.stereotype.Component;

@Component
public class ImagenMapper {


        // Convierte ImagenesEntity a modelo Imagen
        public Imagen toModel(ImagenesEntity entity) {
            if (entity == null) {
                return null;
            }

            Imagen imagen = new Imagen();
            imagen.setId(entity.getId_imagen());  // 🔥 Agregar esta línea para mapear el ID
            imagen.setUrl(entity.getImagenURL());
            return imagen;
        }

        // Convierte el modelo Imagen a ImagenesEntity para persistencia
        public ImagenesEntity toEntity(Imagen imagen) {
            if (imagen == null) {
                return null;
            }
            // El campo 'mueble' se asignará en la lógica de persistencia
            return new ImagenesEntity(imagen.getId(), null, imagen.getUrl());
        }
    }
