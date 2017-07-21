package com.webstore.core.repository;

import com.webstore.core.entity.OrdenStockEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  OrdenStockRepository extends JpaRepository<OrdenStockEntity,Integer> {
}
