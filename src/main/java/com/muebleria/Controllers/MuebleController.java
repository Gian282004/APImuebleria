package com.muebleria.Controllers;

import com.muebleria.Services.MuebleService;
import com.muebleria.models.Mueble;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/muebles")
@CrossOrigin(origins = "*") // Permitir solicitudes desde cualquier origen (configura según tus necesidades)
public class MuebleController {

    @Autowired
    private MuebleService muebleService;

    @GetMapping
    public List<Mueble> listarMuebles() {
        return muebleService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Mueble> obtenerMueblePorId(@PathVariable Integer id) {
        Optional<Mueble> mueble = muebleService.obtenerPorId(id);
        if (mueble.isPresent()) {
            return ResponseEntity.ok(mueble.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Mueble crearMueble(@RequestBody Mueble mueble) {
        return muebleService.guardar(mueble);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Mueble> actualizarMueble(@PathVariable Integer id, @RequestBody Mueble detallesMueble) {
        Optional<Mueble> muebleOpt = muebleService.obtenerPorId(id);
        if (muebleOpt.isPresent()) {
            Mueble mueble = muebleOpt.get();
            mueble.setMedida(detallesMueble.getMedida());
            mueble.setPrecio(detallesMueble.getPrecio());
            mueble.setStock(detallesMueble.getStock());
            mueble.setDescripcion(detallesMueble.getDescripcion());
            muebleService.guardar(mueble);
            return ResponseEntity.ok(mueble);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarMueble(@PathVariable Integer id) {
        Optional<Mueble> muebleOpt = muebleService.obtenerPorId(id);
        if (muebleOpt.isPresent()) {
            muebleService.eliminar(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}