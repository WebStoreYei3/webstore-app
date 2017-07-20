package com.gemobile.core.repository;

import com.gemobile.core.entity.OrdenMostradorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdenMostradorRepository extends JpaRepository<OrdenMostradorEntity,Integer> {
}
