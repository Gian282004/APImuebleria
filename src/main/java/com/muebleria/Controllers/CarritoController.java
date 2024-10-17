package com.muebleria.Controllers;


import com.muebleria.Services.CarritoService;
import com.muebleria.models.Carrito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/carrito")
@CrossOrigin(origins = "*")
public class CarritoController {

    @Autowired
    private CarritoService carritoService;

    @GetMapping
    public List<Carrito> listarCarritos() {
        return carritoService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Carrito> obtenerCarritoPorId(@PathVariable Integer id) {
        Optional<Carrito> carrito = carritoService.obtenerPorId(id);
        if (carrito.isPresent()) {
            return ResponseEntity.ok(carrito.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Carrito crearCarrito(@RequestBody Carrito carrito) {
        return carritoService.guardar(carrito);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Carrito> actualizarCarrito(@PathVariable Integer id, @RequestBody Carrito detallesCarrito) {
        Optional<Carrito> carritoOpt = carritoService.obtenerPorId(id);
        if (carritoOpt.isPresent()) {
            Carrito carrito = carritoOpt.get();
            carrito.setUsuario(detallesCarrito.getUsuario());
            carrito.setMueble(detallesCarrito.getMueble());
            carrito.setPrecioTotal(detallesCarrito.getPrecioTotal());
            carrito.setFechaCarrito(detallesCarrito.getFechaCarrito());
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
