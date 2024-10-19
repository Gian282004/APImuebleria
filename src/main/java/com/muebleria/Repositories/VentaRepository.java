package com.muebleria.Repositories;

import com.muebleria.entitys.VentaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VentaRepository extends JpaRepository<VentaEntity, Integer> {
    // Métodos personalizados si es necesario
}