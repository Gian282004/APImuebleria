package com.muebleria.Repositories;



import com.muebleria.entitys.MuebleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MuebleRepository extends JpaRepository<MuebleEntity, Integer> {
    // Puedes agregar métodos personalizados si es necesario
    @Query("SELECT DISTINCT m FROM MuebleEntity m " +
            "INNER JOIN FETCH m.imagenes i " +
            "WHERE m.id = :id")
    Optional<MuebleEntity> findByIdWithImages(@Param("id") Integer id);

    Optional<MuebleEntity> findById(Integer id);
}
