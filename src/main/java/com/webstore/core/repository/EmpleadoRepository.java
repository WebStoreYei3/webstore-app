package com.webstore.core.repository;

import com.webstore.core.entity.EmpleadoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  EmpleadoRepository extends JpaRepository<EmpleadoEntity,Integer> {
}
