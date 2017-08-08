package com.webstore.core.business;

import com.webstore.core.entity.SubtipoProductoEntity;
import com.webstore.core.repository.SubtipoProductoRepository;
import com.webstore.rest.request.SubTipoProductoRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SubTipoProductoBusiness {
    SubtipoProductoRepository subtipoProductoRepository;

    @Autowired
    public SubTipoProductoBusiness(
            SubtipoProductoRepository subtipoProductoRepository
    ){
        this.subtipoProductoRepository = subtipoProductoRepository;
    }

    public void altaSubTipoProduccion(SubTipoProductoRequest subTipoProductoRequest){
        SubtipoProductoEntity subtipoProductoEntity = new SubtipoProductoEntity();
        subtipoProductoEntity.setcCodigo(subTipoProductoRequest.getcCodigo());
        subtipoProductoEntity.setcDescripcion(subTipoProductoRequest.getcDescripcion());
        subtipoProductoEntity.setiIdTipoProducto(subTipoProductoRequest.getiIdTipoProducto());
        subtipoProductoRepository.save(subtipoProductoEntity);
    }

}
