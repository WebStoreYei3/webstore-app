package com.webstore.core.repository;

import com.webstore.core.entity.SubtipoProductoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  SubtipoProductoRepository extends JpaRepository<SubtipoProductoEntity,Integer> {
}
