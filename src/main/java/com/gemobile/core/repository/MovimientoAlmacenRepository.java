package com.gemobile.core.repository;

import com.gemobile.core.entity.MovimientoAlmacenStockEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  MovimientoAlmacenRepository extends JpaRepository<MovimientoAlmacenStockEntity,Integer> {
}
