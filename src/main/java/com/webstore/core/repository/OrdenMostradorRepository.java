package com.webstore.core.repository;

import com.webstore.core.entity.OrdenMostradorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdenMostradorRepository extends JpaRepository<OrdenMostradorEntity,Integer> {
}
