package com.webstore.rest;

import com.webstore.core.business.ProductoBusiness;
import com.webstore.core.business.ProveedorBusiness;
import com.webstore.rest.request.ProductoRequest;
import com.webstore.rest.request.ProveedorRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController (value = "proveedor")
public class ProveedorRESTController {
    private ProveedorBusiness proveedorBusiness;

    @Autowired
    public ProveedorRESTController(
            ProveedorBusiness proveedorBusiness
    ){
        this.proveedorBusiness = proveedorBusiness;
    }

    @RequestMapping (value = "/altaProveedor", method = RequestMethod.POST)
    public void altaProveedor(@RequestBody ProveedorRequest proveedorRequest){
                proveedorBusiness.altaProveedor(proveedorRequest);
    }
}
