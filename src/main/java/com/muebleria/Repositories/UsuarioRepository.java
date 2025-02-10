package com.muebleria.Repositories;

import com.muebleria.entitys.UsuarioEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Integer> {
    /// Método para encontrar usuario por email
    UsuarioEntity findByEmail(String email);
    Optional<UsuarioEntity> findByUsername(String username);

}
