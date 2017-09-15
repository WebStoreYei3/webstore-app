package com.webstore.core.repository;

import com.webstore.core.entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioEntity,Integer>{
    UsuarioEntity findByCUsuario(String cUsuario);
    UsuarioEntity findByCAndCMail(String cMail);
}
