package com.muebleria.Repositories;

import com.muebleria.entitys.PayerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PayerRepository  extends JpaRepository<PayerEntity, Integer> {

    Optional<PayerEntity> findById(Integer id);
}
