package com.webstore.core.repository;

import com.webstore.core.entity.ProductoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoRepository extends JpaRepository<ProductoEntity,Integer> {
    @Query(value = "SELECT * FROM webstore.producto LIMIT ?1", nativeQuery = true)
    List<ProductoEntity> findProductosLimit(Integer limit);
}
