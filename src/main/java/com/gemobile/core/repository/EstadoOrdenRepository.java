package com.gemobile.core.repository;

import com.gemobile.core.entity.EstadoOrdenEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  EstadoOrdenRepository extends JpaRepository<EstadoOrdenEntity,Integer> {
}
