package com.muebleria.Mappers;

import com.muebleria.DTO.VentaRequest;
import com.muebleria.entitys.CarritoEntity;
import com.muebleria.entitys.VentaEntity;
import com.muebleria.models.Carrito;
import com.muebleria.models.Mueble;
import com.muebleria.models.Usuario;
import com.muebleria.models.Venta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class VentaMapper {

   private final  CarritoMapper carritoMapper;

    @Autowired
    public VentaMapper(CarritoMapper carritoMapper)
    {
        this.carritoMapper=carritoMapper;

    }

    public Venta toModel(VentaEntity ventaEntity)
    {
        Venta venta=new Venta((int)ventaEntity.getId_pedido(), ventaEntity.getEstadoPedido());
        Carrito carrito=carritoMapper.toModel(ventaEntity.getCarrito());
        venta.setCarrito(carrito);
        return venta;
    }

    public Venta toModel(VentaRequest ventaRequest)
    {
        Venta venta=new Venta(ventaRequest.getEstadoPedido(), ventaRequest.getCarrito());
        return venta;
    }

    public VentaEntity toEntity(Venta venta)
    {
        VentaEntity ventaEntity=new VentaEntity(venta.getId_pedido(), venta.getEstadoPedido(), carritoMapper.toEntity(venta.getCarrito()));
        return ventaEntity;
    }
}
