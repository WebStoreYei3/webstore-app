package com.gemobile.core.repository;

import com.gemobile.core.entity.EmpleadoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  EmpleadoRepository extends JpaRepository<EmpleadoEntity,Integer> {
}
