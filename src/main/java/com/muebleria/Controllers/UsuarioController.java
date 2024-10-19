package com.muebleria.Controllers;

import com.muebleria.DTO.UsuarioRequest;
import com.muebleria.Mappers.UsuarioMapper;
import com.muebleria.Services.UsuarioService;

import com.muebleria.models.Usuario;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {


    private final UsuarioService usuarioService;
    private final UsuarioMapper usuarioMapper;

    @Autowired
    public UsuarioController(UsuarioService usuarioService, UsuarioMapper usuarioMapper)
    {
        this.usuarioService=usuarioService;
        this.usuarioMapper=usuarioMapper;
    }

    @GetMapping
    public List<Usuario> listarUsuarios() {

        return usuarioService.listarTodos();
    }

    @GetMapping("/{id}")
    public Optional<Usuario> obtenerUsuarioPorId(@PathVariable Integer id) {
        //Esto deberia estar dentro de un if que confirme que exista, abajo se explica porque no se puede
        return  usuarioService.obtenerPorId(id);


        //Aca se deberia devolver un not found pero se necesita que sea de tipo ResponseEntity y es Optional
    }

    @PostMapping
    public ResponseEntity<Usuario> crearUsuario( @Valid  @RequestBody UsuarioRequest usuario) {
        try {
            Usuario Prueba=new Usuario("Gian", "GIAN1234", "Gian@gmail.com");
            Usuario usuarioGuardado = usuarioService.guardar(Prueba);
         return ResponseEntity.status(HttpStatus.CREATED).body(usuarioGuardado);
        } catch (Exception e) {
           throw e;
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<Usuario> actualizarUsuario(@PathVariable Integer id, @Valid  @RequestBody UsuarioRequest detallesUsuario) {
        Optional<Usuario> usuarioOpt = usuarioService.obtenerPorId(id);
        if (usuarioOpt.isPresent()) {
            Usuario usuario = usuarioMapper.toModel(detallesUsuario);
            usuarioService.guardar(usuario);
            return ResponseEntity.ok(usuario);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarUsuario(@PathVariable Integer id) {
        Optional<Usuario> usuarioOpt = usuarioService.obtenerPorId(id);
        if (usuarioOpt.isPresent()) {
            usuarioService.eliminar(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
