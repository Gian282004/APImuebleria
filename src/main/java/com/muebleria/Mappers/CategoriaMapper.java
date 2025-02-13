package com.muebleria.Mappers;

import com.muebleria.entitys.CategoriaEntity;
import com.muebleria.models.Categoria;
import org.springframework.stereotype.Component;

@Component
public class CategoriaMapper {

    public Categoria toModel(CategoriaEntity categoriaEntity) {
        if (categoriaEntity == null) {
            return null;
        }
        return new Categoria(categoriaEntity.getId(), categoriaEntity.getNombre());
    }

    public CategoriaEntity toEntity(Categoria categoria) {
        if (categoria == null) {
            return null;
        }
        return new CategoriaEntity(categoria.getId(), categoria.getNombre());
    }
}
