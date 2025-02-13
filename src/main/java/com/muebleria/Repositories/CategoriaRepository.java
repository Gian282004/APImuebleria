package com.muebleria.Repositories;

import com.muebleria.entitys.CategoriaEntity;
import com.muebleria.entitys.MuebleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<CategoriaEntity, Integer> {

    CategoriaEntity findByNombre(String nombre);
}
