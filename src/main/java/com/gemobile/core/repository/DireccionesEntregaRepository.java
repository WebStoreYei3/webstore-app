package com.gemobile.core.repository;

import com.gemobile.core.entity.DireccionesEntregaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DireccionesEntregaRepository extends JpaRepository<DireccionesEntregaEntity,Integer> {
}
