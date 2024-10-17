package com.muebleria.Repositories;

import com.muebleria.models.Carrito;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarritoRepository extends JpaRepository<Carrito, Integer> {
    // Métodos personalizados si es necesario
}