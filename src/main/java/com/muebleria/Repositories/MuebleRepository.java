package com.muebleria.Repositories;



import com.muebleria.entitys.MuebleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MuebleRepository extends JpaRepository<MuebleEntity, Integer> {
    // Puedes agregar métodos personalizados si es necesario
}
