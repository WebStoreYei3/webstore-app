package com.webstore.rest;

import com.webstore.core.business.ProductoBusiness;
import com.webstore.rest.request.ProductoRequest;
import com.webstore.rest.response.ProductoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController (value = "producto")
public class ProductoRESTController {
    private ProductoBusiness productoBusiness;

    @Autowired
    public ProductoRESTController(
            ProductoBusiness productoBusiness
    ){
        this.productoBusiness = productoBusiness;
    }

    @RequestMapping (value="/altaProducto", method = RequestMethod.POST)
    public void altaProducto(@RequestBody ProductoRequest productoRequest){
        productoBusiness.altaProducto(productoRequest);
    }

    @RequestMapping (value="/obtenerProductos", method = RequestMethod.GET)
    public List<ProductoResponse> obtenerProductos(Integer cantidad){
        return productoBusiness.obtenerProductos(cantidad);
    }

    @RequestMapping (value="/buscarProductos", method = RequestMethod.GET)
    public List<ProductoResponse> buscarProductos(String cadena){
        return productoBusiness.buscarProductos(cadena);
    }

    @RequestMapping (value="/obtenerProductoById", method = RequestMethod.GET)
    public ProductoResponse obtenerProductoById(Integer id){
        return productoBusiness.obtenerProductoById(id);
    }

}
