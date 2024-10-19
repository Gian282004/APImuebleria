package com.muebleria.Repositories;

import com.muebleria.entitys.CarritoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarritoRepository extends JpaRepository<CarritoEntity, Integer> {
    // Métodos personalizados si es necesario
}