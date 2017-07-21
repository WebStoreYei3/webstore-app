package com.webstore.core.repository;

import com.webstore.core.entity.UsuarioInvitadoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  UsuarioInvitadoRepository extends JpaRepository<UsuarioInvitadoEntity,Integer> {
}
