package com.muebleria.Services;

import com.muebleria.Mappers.CarritoMapper;
import com.muebleria.Mappers.VentaMapper;
import com.muebleria.Repositories.CarritoRepository;
import com.muebleria.Repositories.VentaRepository;
import com.muebleria.entitys.CarritoEntity;
import com.muebleria.entitys.VentaEntity;
import com.muebleria.models.Carrito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CarritoService {

    @Autowired
    private final CarritoRepository carritoRepository;
    private final CarritoMapper carritoMapper;
    @Autowired
    public CarritoService(CarritoRepository carritoRepository, CarritoMapper carritoMapper)
    {
        this.carritoRepository=carritoRepository;
        this.carritoMapper=carritoMapper;
    }

    public List<Carrito> listarTodos() {
        return carritoRepository.findAll().stream()
                .map(carritoMapper::toModel) // Aplicar el mapeo a cada entidad
                .collect(Collectors.toList()); // Recoger los resultados en una lista
    }

    public Optional<Carrito> obtenerPorId(Integer id) {
        Optional<CarritoEntity> CarritoEntity=carritoRepository.findById(id);
        return CarritoEntity.map(carritoMapper::toModel);
    }

    public Carrito guardar(Carrito carrito) {
        CarritoEntity entity=carritoRepository.save(carritoMapper.toEntity(carrito));
        return carritoMapper.toModel(entity);
    }

    public void eliminar(Integer id) {
        carritoRepository.deleteById(id);
    }
}
