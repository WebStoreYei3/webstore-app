package com.gemobile.core.repository;

import com.gemobile.core.entity.OrdenEntregaInvitadoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  OrdenEntregaInvitado extends JpaRepository<OrdenEntregaInvitadoEntity,Integer> {
}
