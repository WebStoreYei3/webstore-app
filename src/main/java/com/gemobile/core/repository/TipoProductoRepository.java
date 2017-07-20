package com.gemobile.core.repository;

import com.gemobile.core.entity.TipoProductoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  TipoProductoRepository extends JpaRepository<TipoProductoEntity,Integer> {
}
