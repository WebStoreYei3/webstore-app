package com.webstore.rest;

import com.webstore.core.business.SubTipoProductoBusiness;
import com.webstore.rest.request.SubTipoProductoRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController (value = "subTipoProducto")
public class SubTipoProductoRESTController {
    private SubTipoProductoBusiness subTipoProductoBusiness;

    @Autowired
    public SubTipoProductoRESTController(
            SubTipoProductoBusiness subTipoProductoBusiness
    ){
        this.subTipoProductoBusiness = subTipoProductoBusiness;
    }

    @RequestMapping (value = "/altaSubTipoProducto", method = RequestMethod.POST)
    public void altaSubTipoProducto(@RequestBody SubTipoProductoRequest subTipoProductoRequest){
                subTipoProductoBusiness.altaSubTipoProduccion(subTipoProductoRequest);
    }
}
