package com.webstore.core.repository;

import com.webstore.core.entity.TipoOperacionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  TipoOperacionRepository extends JpaRepository<TipoOperacionEntity,Integer> {
}
