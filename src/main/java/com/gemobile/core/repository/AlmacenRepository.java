package com.gemobile.core.repository;

import com.gemobile.core.entity.AlmacenEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlmacenRepository extends JpaRepository<AlmacenEntity,Integer>{
}
