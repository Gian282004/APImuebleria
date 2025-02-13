package com.muebleria.Repositories;

import com.muebleria.entitys.ImagenesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImagenRepository extends JpaRepository<ImagenesEntity, Integer> {
}
