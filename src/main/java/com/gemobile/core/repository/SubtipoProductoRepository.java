package com.gemobile.core.repository;

import com.gemobile.core.entity.SubtipoProductoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  SubtipoProductoRepository extends JpaRepository<SubtipoProductoEntity,Integer> {
}
