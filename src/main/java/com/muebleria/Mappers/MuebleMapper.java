package com.muebleria.Mappers;

import com.muebleria.DTO.MuebleRequest;
import com.muebleria.entitys.MuebleEntity;
import com.muebleria.models.Categoria;
import com.muebleria.models.Imagen;
import com.muebleria.models.Mueble;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class MuebleMapper {
    private final CategoriaMapper categoriaMapper;
    private final ImagenMapper imagenMapper;
    @Autowired
    public MuebleMapper(CategoriaMapper categoriaMapper, ImagenMapper imagenMapper) {
        this.categoriaMapper=categoriaMapper;
        this.imagenMapper=imagenMapper;
    }

    public Mueble toModel(MuebleEntity entity) {
        if (entity == null) {
            return null;
        }
        Mueble mueble = new Mueble();
        mueble.setId(entity.getId());
        mueble.setNombre(entity.getNombre());
        mueble.setMedida(entity.getMedida());
        mueble.setDescripcion(entity.getDescripcion());
        mueble.setPrecio(entity.getPrecio());

        // Mapear categorías
        if (entity.getCategorias() != null) {
            mueble.setCategorias(entity.getCategorias().stream()
                    .map(categoriaMapper::toModel)
                    .collect(Collectors.toList()));
        }

        // Mapear imágenes
        if (entity.getImagenes() != null) {
            mueble.setImagenes(entity.getImagenes().stream()
                    .map(imagenMapper::toModel)
                    .collect(Collectors.toList()));
        }

        return mueble;
    }

    public Mueble toModel(MuebleRequest muebleRequest)
    {
        Mueble mueble=new Mueble(muebleRequest.getNombre(), muebleRequest.getMedida(), muebleRequest.getPrecio(), muebleRequest.getDescripcion(), muebleRequest.getImagenes(), muebleRequest.getCategorias());
        return mueble;
    }

    public MuebleEntity toEntity(Mueble mueble)
    {
        MuebleEntity muebleEntity=new MuebleEntity(mueble.getId(), mueble.getNombre(), mueble.getMedida(), mueble.getDescripcion(), mueble.getPrecio());
        return muebleEntity;
    }
}
