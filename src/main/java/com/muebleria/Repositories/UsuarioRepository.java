package com.muebleria.Repositories;

import com.muebleria.models.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    /// Método para encontrar usuario por email
    Usuario findByEmail(String email);
}
