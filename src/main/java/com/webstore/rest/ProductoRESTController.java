package com.webstore.rest;

import com.webstore.core.business.ProductoBusiness;
import com.webstore.rest.request.ProductoRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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

}
