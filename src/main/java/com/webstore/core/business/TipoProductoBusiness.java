package com.webstore.core.business;

import com.webstore.core.entity.TipoProductoEntity;
import com.webstore.core.repository.ProductoRepository;
import com.webstore.core.repository.TipoProductoRepository;
import com.webstore.rest.request.ProductoRequest;
import com.webstore.rest.request.TipoProductoRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TipoProductoBusiness {
    private TipoProductoRepository tipoProductoRepository;

    @Autowired
    public TipoProductoBusiness(
            TipoProductoRepository tipoProductoRepository
    ){
        this.tipoProductoRepository = tipoProductoRepository;
    }

    public void altaTipoProducto(TipoProductoRequest tipoProductoRequest){
                TipoProductoEntity tipoProductoEntity = new TipoProductoEntity();
                tipoProductoEntity.setcCodigo(tipoProductoRequest.getcCodigo());
                tipoProductoEntity.setcDescripcion(tipoProductoRequest.getcDescripcion());
                tipoProductoRepository.save(tipoProductoEntity);
    }

}
