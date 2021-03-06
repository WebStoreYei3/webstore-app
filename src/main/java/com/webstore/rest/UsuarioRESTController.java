package com.webstore.rest;

import com.webstore.core.business.UsuarioBusiness;
import com.webstore.rest.request.*;
import com.webstore.rest.response.ClienteLoginResponse;
import com.webstore.rest.response.EmpleadoLoginResponse;
import com.webstore.rest.response.RespuestaGeneralResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "usuario")
public class UsuarioRESTController {
    private UsuarioBusiness usuarioBusiness;

    @Autowired
    public UsuarioRESTController(
            UsuarioBusiness usuarioBusiness
    ){
        this.usuarioBusiness = usuarioBusiness;
    }

    @RequestMapping(value="/registrarse", method = RequestMethod.POST)
    public ClienteLoginResponse empleadoLogin(@RequestBody RegistrarseRequest request){
        return usuarioBusiness.registrarse(request);
    }

    @RequestMapping(value="/empleadoLogin", method = RequestMethod.POST)
    public EmpleadoLoginResponse empleadoLogin(@RequestBody LoginRequest request){
        return usuarioBusiness.empleadoLogin(request);
    }

    @RequestMapping(value="/clienteLogin", method = RequestMethod.POST)
    public ClienteLoginResponse clienteLogin(@RequestBody LoginRequest request){
        return usuarioBusiness.clienteLogin(request);
    }

    @RequestMapping (value="/clienteLogout", method = RequestMethod.POST)
    public void clienteLogout (@RequestBody LogoutRequest request) throws Exception {
        usuarioBusiness.clienteLogout(request);
    }

    @RequestMapping (value="/tiempoAgotado", method = RequestMethod.GET)
    public boolean tiempoAgotado (String id, String date) throws Exception {
        return usuarioBusiness.tiempoAgotado(id,date);
    }

    @RequestMapping (value="/solicitarMailContrasenia", method = RequestMethod.POST)
    public RespuestaGeneralResponse solicitarMailContrasenia (@RequestBody SolicitudContraseniaRequest request) throws Exception {
        return usuarioBusiness.solicitarMailContrasenia(request);
    }

    @RequestMapping (value="/setearNuevaContrasenia", method = RequestMethod.POST)
    public RespuestaGeneralResponse setearNuevaContrasenia (@RequestBody SetearNuevaContraseniaRequest request) throws Exception {
        return usuarioBusiness.setearNuevaContrasenia(request);
    }
}
