package com.webstore.core.repository;

import com.webstore.core.entity.ProveedorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  ProveedorRepository extends JpaRepository<ProveedorEntity,Integer> {
}
