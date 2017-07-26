package com.webstore.rest;

import com.webstore.core.entity.UsuarioEntity;
import com.webstore.core.repository.UsuarioRepository;
import com.webstore.rest.request.LoginRequest;
import com.webstore.rest.response.LoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "usuario")
public class UsuarioRESTController {
    private UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioRESTController(
            UsuarioRepository usuarioRepository
    ){
        this.usuarioRepository = usuarioRepository;
    }

    @RequestMapping(value="/login", method = RequestMethod.POST)
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request){

        UsuarioEntity usuario = usuarioRepository.findByCUsuario(request.getUsuario());
        String nombre = null;


        if(usuario!=null){
            nombre = usuario.getcNombre();

            if(!StringUtils.isEmpty(request.getContrasenia())&&request.getContrasenia().equals(usuario.getcContrasenia())){
                return new ResponseEntity<LoginResponse>(new LoginResponse(usuario.getId().toString(),nombre,"","1"), HttpStatus.OK);
            }else{
                return new ResponseEntity<LoginResponse>(new LoginResponse("","","","3"), HttpStatus.OK);
            }
        }else{
            return new ResponseEntity<LoginResponse>(new LoginResponse("","","","2"), HttpStatus.OK);
        }
    }
}
