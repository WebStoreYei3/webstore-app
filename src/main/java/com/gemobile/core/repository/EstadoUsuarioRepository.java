package com.gemobile.core.repository;

import com.gemobile.core.entity.EstadoUsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  EstadoUsuarioRepository extends JpaRepository<EstadoUsuarioEntity,Integer> {
}
