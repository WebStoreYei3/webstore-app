package com.webstore.core.business;

import com.webstore.core.entity.RolEntity;
import com.webstore.core.repository.RolRepository;
import com.webstore.rest.request.RolRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RolBusiness {
    private RolRepository rolRepository;

    @Autowired
    public RolBusiness(
            RolRepository rolRepository
    ) {
        this.rolRepository = rolRepository;
    }

    public void altaRol(RolRequest rolRequest){
        RolEntity rolEntity = new RolEntity();
        rolEntity.setcCodigo(rolRequest.getcCodigo());
        rolEntity.setcDescripcion(rolRequest.getcDescripcion());
        rolRepository.save(rolEntity);
    }
}
