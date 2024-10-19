package com.muebleria.Controllers;


import com.muebleria.DTO.CarritoRequest;
import com.muebleria.Mappers.CarritoMapper;
import com.muebleria.Services.CarritoService;

import com.muebleria.models.Carrito;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/carrito")
@CrossOrigin(origins = "*")
public class CarritoController {


    private final CarritoService carritoService;
    private final CarritoMapper carritoMapper;

    @Autowired
    public CarritoController(CarritoService carritoService, CarritoMapper carritoMapper)
    {
        this.carritoService=carritoService;
        this.carritoMapper=carritoMapper;
    }


    @GetMapping
    public List<Carrito> listarCarritos() {
        return carritoService.listarTodos();
    }

    @GetMapping("/{id}")
    public Optional<Carrito> obtenerCarritoPorId(@PathVariable Integer id) {
        //Esto deberia estar dentro de un if que confirme que exista, abajo se explica porque no se puede
        return  carritoService.obtenerPorId(id);


        //Aca se deberia devolver un not found pero se necesita que sea de tipo ResponseEntity y es Optional
    }

    @PostMapping
    public Carrito crearCarrito(@Valid @RequestBody CarritoRequest carrito) {
        return carritoService.guardar(carritoMapper.ToModel(carrito));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Carrito> actualizarCarrito(@PathVariable Integer id, @Valid @RequestBody CarritoRequest detallesCarrito) {
        Optional<Carrito> carritoOpt = carritoService.obtenerPorId(id);
        if (carritoOpt.isPresent()) {
            Carrito carrito = carritoMapper.ToModel(detallesCarrito);
            carritoService.guardar(carrito);
            return ResponseEntity.ok(carrito);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCarrito(@PathVariable Integer id) {
        Optional<Carrito> carritoOpt = carritoService.obtenerPorId(id);
        if (carritoOpt.isPresent()) {
            carritoService.eliminar(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
