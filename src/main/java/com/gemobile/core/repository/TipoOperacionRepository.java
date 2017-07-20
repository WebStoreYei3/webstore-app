package com.gemobile.core.repository;

import com.gemobile.core.entity.TipoOperacionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  TipoOperacionRepository extends JpaRepository<TipoOperacionEntity,Integer> {
}
