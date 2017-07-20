package com.gemobile.core.repository;

import com.gemobile.core.entity.OrdenStockEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  OrdenStockRepository extends JpaRepository<OrdenStockEntity,Integer> {
}
