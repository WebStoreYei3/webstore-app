package com.webstore.core.repository;

import com.webstore.core.entity.OpinionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OpinionRepository extends JpaRepository<OpinionEntity,Integer>{
}
