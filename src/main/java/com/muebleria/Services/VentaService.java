package com.muebleria.Services;

import com.muebleria.Mappers.VentaMapper;
import com.muebleria.Repositories.VentaRepository;
import com.muebleria.entitys.VentaEntity;
import com.muebleria.models.Venta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VentaService {

    private final VentaRepository ventaRepository;
    private final VentaMapper ventaMapper;

    @Autowired
     public VentaService(VentaRepository ventaRepository, VentaMapper ventaMapper)
    {
        this.ventaRepository=ventaRepository;
        this.ventaMapper=ventaMapper;
    }




    public List<Venta> listarTodos() {
        return ventaRepository.findAll().stream()
                .map(ventaMapper::toModel) // Aplicar el mapeo a cada entidad
                .collect(Collectors.toList()); // Recoger los resultados en una lista
    }
    public Optional<Venta> obtenerPorId(Integer id) {
        Optional<VentaEntity> ventaEntityOptional = ventaRepository.findById(id);
        return ventaEntityOptional.map(ventaMapper::toModel); // Aplica toModel si existe
    }

    public Venta guardar(Venta venta) {
         VentaEntity entity=ventaRepository.save(ventaMapper.toEntity(venta));
         return ventaMapper.toModel(entity);
    }

    public void eliminar(Integer id) {
        ventaRepository.deleteById(id);
    }
}
