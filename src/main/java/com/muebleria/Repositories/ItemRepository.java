package com.muebleria.Repositories;

import com.muebleria.entitys.HistorialEntity;
import com.muebleria.entitys.ItemsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<ItemsEntity, Integer> {

    List<ItemsEntity> findByHistorial(HistorialEntity historial);
}
