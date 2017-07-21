package com.webstore.core.repository;

import com.webstore.core.entity.TipoProductoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  TipoProductoRepository extends JpaRepository<TipoProductoEntity,Integer> {
}
