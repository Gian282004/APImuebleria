package com.muebleria.Repositories;

import com.muebleria.models.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VentaRepository extends JpaRepository<Venta, Integer> {
    // Métodos personalizados si es necesario
}