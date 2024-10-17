package com.muebleria.Services;

import com.muebleria.Repositories.CarritoRepository;
import com.muebleria.models.Carrito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarritoService {

    @Autowired
    private CarritoRepository carritoRepository;

    public List<Carrito> listarTodos() {
        return carritoRepository.findAll();
    }

    public Optional<Carrito> obtenerPorId(Integer id) {
        return carritoRepository.findById(id);
    }

    public Carrito guardar(Carrito carrito) {
        return carritoRepository.save(carrito);
    }

    public void eliminar(Integer id) {
        carritoRepository.deleteById(id);
    }
}
