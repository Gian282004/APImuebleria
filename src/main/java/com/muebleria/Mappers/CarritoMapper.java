package com.muebleria.Mappers;

import com.muebleria.DTO.CarritoRequest;
import com.muebleria.entitys.CarritoEntity;
import com.muebleria.models.Carrito;
import com.muebleria.models.Mueble;
import com.muebleria.models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CarritoMapper {
    private final UsuarioMapper usuarioMapper;
    private final MuebleMapper muebleMapper;

    @Autowired
    public CarritoMapper(UsuarioMapper usuarioMapper, MuebleMapper muebleMapper)
    {
        this.usuarioMapper=usuarioMapper;
        this.muebleMapper=muebleMapper;
    }

    public Carrito toModel(CarritoEntity carritoEntity)
    {

        Carrito carrito=new Carrito((int)carritoEntity.getId_carrito(), carritoEntity.getPrecioTotal(), carritoEntity.getFechaCarrito());
        //Aca hay que averiguar como hacer el diseño del modelo Carrito para poder asignarle el usuario
        Usuario user= usuarioMapper.toModel(carritoEntity.getUsuario());
        carrito.setUsuarioCarrito(user);
        Mueble mueble= muebleMapper.toModel(carritoEntity.getMueble());
        carrito.setMuebleCarrito(mueble);
        return carrito;
    }

    public Carrito ToModel(CarritoRequest carritoRequest)
    {
        Carrito carrito=new Carrito(carritoRequest.getUsuario(), carritoRequest.getMueble(), carritoRequest.getPrecioFinal(), carritoRequest.getFechaCarrito());
        return carrito;

    }

    public CarritoEntity toEntity(Carrito carrito)
    {
        CarritoEntity carritoEntity=new CarritoEntity(carrito.getId(), usuarioMapper.toentity(carrito.getUsuarioCarrito()), muebleMapper.toEntity(carrito.getMuebleCarrito()), carrito.getPrecioFinal(), carrito.getFechaCarrito());
        return carritoEntity;
    }
}
