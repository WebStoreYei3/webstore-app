package com.webstore.core.business;

import com.webstore.core.entity.ProductoEntity;
import com.webstore.core.repository.ProductoRepository;
import com.webstore.rest.request.ProductoRequest;
import com.webstore.rest.response.ProductoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

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
        productoRepository.save(getProductoEntity(productoRequest));
    }

    public List<ProductoResponse> obtenerProductos(Integer cantidad){
        List<ProductoResponse> result = new ArrayList<ProductoResponse>();
        for(ProductoEntity productoEntity:productoRepository.findProductosLimit(cantidad)){
            result.add(getProductoResponse(productoEntity));
        }
        return result;
    }

    public static ProductoResponse getProductoResponse(ProductoEntity productoEntity){
        return new ProductoResponse(
                productoEntity.getId(),
                productoEntity.getcCodigo(),
                productoEntity.getcNombre(),
                productoEntity.getiIdTipo(),
                productoEntity.getiIdSubtipo(),
                productoEntity.getcDescripcion(),
                productoEntity.getiIdProveedor(),
                productoEntity.getcMarca(),
                productoEntity.getcUnidad(),
                productoEntity.getdCosto(),
                productoEntity.getdPrecioPublico(),
                productoEntity.getdPrecioMayoreo(),
                productoEntity.getdCantidadMayoreo(),
                productoEntity.getcImagenes()
        );
    }

    public static ProductoEntity getProductoEntity(ProductoRequest productoRequest){
        return new ProductoEntity(
                productoRequest.getcCodigo(),
                productoRequest.getcNombre(),
                productoRequest.getiIdTipo(),
                productoRequest.getiIdSubtipo(),
                productoRequest.getcDescripcion(),
                productoRequest.getiIdProveedor(),
                productoRequest.getcMarca(),
                productoRequest.getcUnidad(),
                productoRequest.getdCosto(),
                productoRequest.getdPrecioPublico(),
                productoRequest.getdPrecioMayoreo(),
                productoRequest.getdCantidadMayoreo(),
                productoRequest.getcImagenes()
        );
    }
}

