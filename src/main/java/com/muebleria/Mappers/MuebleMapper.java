package com.muebleria.Mappers;

import com.muebleria.DTO.MuebleRequest;
import com.muebleria.entitys.MuebleEntity;
import com.muebleria.models.Mueble;
import org.springframework.stereotype.Component;

@Component
public class MuebleMapper {

    public Mueble toModel(MuebleEntity muebleEntity)
    {
        Mueble mueble=new Mueble(muebleEntity.getId(), muebleEntity.getNombre(), muebleEntity.getMedida(), muebleEntity.getPrecio(), muebleEntity.getDescripcion());
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
