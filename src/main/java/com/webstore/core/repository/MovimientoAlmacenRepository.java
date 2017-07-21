package com.webstore.core.repository;

import com.webstore.core.entity.MovimientoAlmacenStockEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  MovimientoAlmacenRepository extends JpaRepository<MovimientoAlmacenStockEntity,Integer> {
}
