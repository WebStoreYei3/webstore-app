package com.webstore.core.repository;

import com.webstore.core.entity.OrdenEntregaInvitadoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdenEntregaInvitadoRepository extends JpaRepository<OrdenEntregaInvitadoEntity,Integer> {
}
