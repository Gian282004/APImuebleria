package com.muebleria.Controllers;

import com.muebleria.DTO.MuebleRequest;
import com.muebleria.Mappers.MuebleMapper;
import com.muebleria.Services.MuebleService;

import com.muebleria.models.Categoria;
import com.muebleria.models.Imagen;
import com.muebleria.models.Mueble;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/muebles")
@CrossOrigin(origins = "*") // Permitir solicitudes desde El front En pruebas (configurar según  necesidades)
public class MuebleController {

    @Autowired
    private final MuebleService muebleService;
    private final MuebleMapper muebleMapper;

    public MuebleController(MuebleService muebleService, MuebleMapper muebleMapper)
    {
        this.muebleService=muebleService;
        this.muebleMapper=muebleMapper;
    }

    @GetMapping
    public List<Mueble> listarMuebles() {
        return muebleService.listarTodos();
    }


    @GetMapping("/{id}")
    public ResponseEntity<Mueble> obtenerMueblePorId(@PathVariable Integer id) {

        Optional<Mueble> optionalMueble = muebleService.obtenerPorId(id);

        if (optionalMueble.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        Mueble mueble = optionalMueble.get();

        // Forzar la carga de imágenes y categoría
        Hibernate.initialize(mueble.getImagenes());
        Hibernate.initialize(mueble.getCategorias());

        return ResponseEntity.ok(mueble);
    }

   /* @GetMapping("/{id}")
    public Optional<Mueble> obtenerMueblePorId(@PathVariable Integer id) {
        //Esto deberia estar dentro de un if que confirme que exista, abajo se explica porque no se puede
        return  muebleService.obtenerPorId(id);


        //Aca se deberia devolver un not found pero se necesita que sea de tipo ResponseEntity y es Optional
    }
*/

    @PostMapping
    public ResponseEntity<Mueble> crearMueble(@Valid @RequestBody MuebleRequest mueblerequest) {
        try {
            Mueble mueble = muebleService.guardar(muebleMapper.toModel(mueblerequest));
            return ResponseEntity.ok(mueble);
        } catch (Exception e) {
            // Manejo de la excepción y respuesta adecuada
            e.printStackTrace();  // Esto debería ir en un log real en producción
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }





    @PutMapping("/{id}")
    public ResponseEntity<Mueble> actualizarMueble(@PathVariable Integer id, @Valid @RequestBody MuebleRequest detallesMueble) {
        Optional<Mueble> muebleOpt = muebleService.obtenerPorId(id);
        if (muebleOpt.isPresent()) {
            Mueble mueble = muebleMapper.toModel(detallesMueble);
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