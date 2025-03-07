package com.muebleria.Repositories;



import com.muebleria.entitys.MuebleEntity;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MuebleRepository extends JpaRepository<MuebleEntity, Integer> {
    @EntityGraph(attributePaths = {"imagenes", "categorias"})
    Optional<MuebleEntity> findById(Integer id);


}
