package com.muebleria.Controllers;

import com.muebleria.Services.VentaService;
import com.muebleria.models.Venta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ventas")
@CrossOrigin(origins = "*")
public class VentaController {

    @Autowired
    private VentaService ventaService;

    @GetMapping
    public List<Venta> listarVentas() {
        return ventaService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Venta> obtenerVentaPorId(@PathVariable Integer id) {
        Optional<Venta> venta = ventaService.obtenerPorId(id);
        if (venta.isPresent()) {
            return ResponseEntity.ok(venta.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Venta crearVenta(@RequestBody Venta venta) {
        return ventaService.guardar(venta);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Venta> actualizarVenta(@PathVariable Integer id, @RequestBody Venta detallesVenta) {
        Optional<Venta> ventaOpt = ventaService.obtenerPorId(id);
        if (ventaOpt.isPresent()) {
            Venta venta = ventaOpt.get();
            venta.setEstadoPedido(detallesVenta.getEstadoPedido());
            venta.setCarrito(detallesVenta.getCarrito());
            ventaService.guardar(venta);
            return ResponseEntity.ok(venta);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarVenta(@PathVariable Integer id) {
        Optional<Venta> ventaOpt = ventaService.obtenerPorId(id);
        if (ventaOpt.isPresent()) {
            ventaService.eliminar(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
