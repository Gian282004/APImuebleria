package com.muebleria.Repositories;


import com.muebleria.models.Mueble;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MuebleRepository extends JpaRepository<Mueble, Integer> {
    // Puedes agregar métodos personalizados si es necesario
}
