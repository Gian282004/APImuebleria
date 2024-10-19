package com.muebleria.Controllers;

import com.muebleria.DTO.VentaRequest;
import com.muebleria.Mappers.VentaMapper;
import com.muebleria.Services.VentaService;
import com.muebleria.models.Venta;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ventas")
@CrossOrigin(origins = "*")
public class VentaController {

    private final VentaMapper ventaMapper;
    private final VentaService ventaService;
    @Autowired

    public VentaController(VentaService ventaService, VentaMapper ventaMapper)
    {
        this.ventaService=ventaService;
        this.ventaMapper=ventaMapper;
    }

    @GetMapping
    public List<Venta> listarVentas() {
        return ventaService.listarTodos();
    }

    @GetMapping("/{id}")
    public Optional<Venta> obtenerVentaPorId(@PathVariable Integer id) {

               //Esto deberia estar dentro de un if que confirme que exista, abajo se explica porque no se puede
        return  ventaService.obtenerPorId(id);


             //Aca se deberia devolver un not found pero se necesita que sea de tipo ResponseEntity y es Optional

    }

    @PostMapping
    public Venta crearVenta(@Valid @RequestBody VentaRequest venta) {

        return ventaService.guardar(ventaMapper.toModel(venta));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Venta> actualizarVenta(@PathVariable Integer id, @Valid @RequestBody VentaRequest detallesVenta) {
        Optional<Venta> ventaOpt = ventaService.obtenerPorId(id);
        if (ventaOpt.isPresent()) {
            Venta venta = ventaMapper.toModel(detallesVenta);
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
