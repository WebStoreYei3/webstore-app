package com.webstore.rest;

import com.webstore.core.business.TipoProductoBusiness;
import com.webstore.rest.request.TipoProductoRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController (value = "tipoProducto")
public class TipoProductoRESTController {
    private TipoProductoBusiness tipoProductoBusiness;

    @Autowired
    public TipoProductoRESTController(
            TipoProductoBusiness tipoProductoBusiness
    ){
        this.tipoProductoBusiness = tipoProductoBusiness;
    }

    @RequestMapping (value = "/altaTipoProducto", method = RequestMethod.POST)
    public void  altaTipoProducto(@RequestBody TipoProductoRequest tipoProductoRequest){
                tipoProductoBusiness.altaTipoProducto(tipoProductoRequest);
    }
}
