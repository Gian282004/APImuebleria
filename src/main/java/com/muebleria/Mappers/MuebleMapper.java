package com.muebleria.Mappers;

import com.muebleria.DTO.MuebleRequest;
import com.muebleria.entitys.MuebleEntity;
import com.muebleria.models.Mueble;
import org.springframework.stereotype.Component;

@Component
public class MuebleMapper {

    public Mueble toModel(MuebleEntity muebleEntity)
    {
        Mueble mueble=new Mueble((int) muebleEntity.getId_producto(), muebleEntity.getMedida(), muebleEntity.getPrecio(), muebleEntity.getStock(), muebleEntity.getDescripcion());
        return mueble;
    }

    public Mueble toModel(MuebleRequest muebleRequest)
    {
        Mueble mueble=new Mueble(muebleRequest.getMedida(), muebleRequest.getPrecio(), muebleRequest.getStock(), muebleRequest.getDescripcion());
        return mueble;
    }

    public MuebleEntity toEntity(Mueble mueble)
    {
        MuebleEntity muebleEntity=new MuebleEntity(mueble.getId(), mueble.getMedida(), mueble.getPrecio(), mueble.getStock(), mueble.getDescripcion());
        return muebleEntity;
    }
}
