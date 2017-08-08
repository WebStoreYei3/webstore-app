package com.webstore.core.business;

import com.webstore.core.entity.ProveedorEntity;
import com.webstore.core.repository.ProveedorRepository;
import com.webstore.rest.request.ProveedorRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProveedorBusiness {
    ProveedorRepository proveedorRepository;

    @Autowired
    public  ProveedorBusiness(
            ProveedorRepository proveedorRepository
    ){
        this.proveedorRepository = proveedorRepository;
    }

    public void altaProveedor(ProveedorRequest proveedorRequest){
        ProveedorEntity proveedorEntity = new ProveedorEntity();
        proveedorEntity.setcCodigo(proveedorRequest.getcCodigo());
        proveedorEntity.setcContacto(proveedorRequest.getcContacto());
        proveedorEntity.setcNombre(proveedorRequest.getcNombre());
        proveedorEntity.setcUbicacion(proveedorRequest.getcUbicacion());
        proveedorRepository.save(proveedorEntity);
    }
}
