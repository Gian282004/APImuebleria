package com.muebleria.Services;

import com.muebleria.Mappers.UsuarioMapper;
import com.muebleria.Repositories.UsuarioRepository;
import com.muebleria.entitys.UsuarioEntity;
import com.muebleria.models.Usuario;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Transactional
@Service
public class UsuarioService {


    private final UsuarioMapper usuarioMapper;
    private final UsuarioRepository usuarioRepository;
    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository, UsuarioMapper usuarioMapper)
    {
        this.usuarioRepository=usuarioRepository;
        this.usuarioMapper=usuarioMapper;
    }

    public List<Usuario> listarTodos() {
        return usuarioRepository.findAll().stream().
                map(usuarioMapper::toModel).
                collect(Collectors.toList());
    }

    public List<Usuario> listarPorUsername(String username) {
        Optional<UsuarioEntity> usuarioOpt = usuarioRepository.findByUsername(username);
        return usuarioOpt
                .map(usuario -> Collections.singletonList(usuarioMapper.toModel(usuario))) // Si el usuario se encuentra, se mapea y se envuelve en una lista
                .orElse(Collections.emptyList()); // Si no se encuentra, se devuelve una lista vacía
    }

    public Optional<Usuario> obtenerPorId(Integer id) {
        Optional<UsuarioEntity> usuarioEntityOptional = usuarioRepository.findById(id);
        return usuarioEntityOptional.map(usuarioMapper::toModel); //
    }

    public Usuario guardar(Usuario usuario) {

        UsuarioEntity entity=usuarioRepository.save(usuarioMapper.toentity(usuario));
        return usuarioMapper.toModel(entity);
    }

    public void eliminar(Integer id) {
        usuarioRepository.deleteById(id);
    }

    public Usuario encontrarPorEmail(String email) {
       UsuarioEntity entity= usuarioRepository.findByEmail(email);
       return usuarioMapper.toModel(entity);
    }
}