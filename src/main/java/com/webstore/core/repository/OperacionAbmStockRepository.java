package com.webstore.core.repository;

import com.webstore.core.entity.OperacionAbmStockEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  OperacionAbmStockRepository extends JpaRepository<OperacionAbmStockEntity,Integer> {
}
