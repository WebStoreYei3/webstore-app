package com.webstore.core.repository;

import com.webstore.core.entity.OrdenEntregaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdenEntregaRepository extends JpaRepository<OrdenEntregaEntity,Integer> {
}
