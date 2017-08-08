package com.webstore.core.business;

import com.webstore.core.entity.ProductoEntity;
import com.webstore.core.entity.StockEntity;
import com.webstore.core.repository.ProductoRepository;
import com.webstore.core.repository.StockRepository;
import com.webstore.rest.request.ProductoRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductoBusiness{
    private ProductoRepository productoRepository;

    @Autowired
    public ProductoBusiness(
            ProductoRepository productoRepository
    )
    {
        this.productoRepository = productoRepository;
    }

    public void altaProducto(ProductoRequest productoRequest){
        ProductoEntity productoEntity = new ProductoEntity();
        productoEntity.setcCodigo(productoRequest.getcCodigo());
        productoEntity.setcDescripcion(productoRequest.getcDescripcion());
        productoEntity.setcMarca(productoRequest.getcMarca());
        productoEntity.setcNombre(productoRequest.getcNombre());
        productoEntity.setcUnidad(productoRequest.getcUnidad());
        productoEntity.setiIdProveedor(productoRequest.getiIdProveedor());
        productoEntity.setiIdSubtipo(productoRequest.getiIdSubtipo());
        productoEntity.setiIdTipo(productoRequest.getiIdTipo());
        productoRepository.save(productoEntity);
    }
}

