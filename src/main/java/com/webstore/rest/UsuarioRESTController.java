package com.webstore.rest;

import com.webstore.core.entity.EmpleadoEntity;
import com.webstore.core.entity.RolEntity;
import com.webstore.core.entity.UsuarioEntity;
import com.webstore.core.repository.EmpleadoRepository;
import com.webstore.core.repository.RolRepository;
import com.webstore.core.repository.UsuarioRepository;
import com.webstore.rest.request.LoginRequest;
import com.webstore.rest.response.ClienteLoginResponse;
import com.webstore.rest.response.EmpleadoLoginResponse;
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
    private RolRepository rolRepository;
    private EmpleadoRepository empleadoRepository;

    @Autowired
    public UsuarioRESTController(
            UsuarioRepository usuarioRepository,
            RolRepository rolRepository,
            EmpleadoRepository empleadoRepository
    ){
        this.usuarioRepository = usuarioRepository;
        this.rolRepository = rolRepository;
        this.empleadoRepository = empleadoRepository;
    }

    @RequestMapping(value="/empleadoLogin", method = RequestMethod.POST)
    public EmpleadoLoginResponse empleadoLogin(@RequestBody LoginRequest request){

        UsuarioEntity usuarioEntity = usuarioRepository.findByCUsuario(request.getUsuario());
        EmpleadoEntity empleadoEntity = empleadoRepository.findByIIdUsuario(usuarioEntity.getId());
        RolEntity rolEntity = rolRepository.findOne(empleadoEntity.getiIdRol());
        String nombre = null;

        if(usuarioEntity!=null){
            nombre = usuarioEntity.getcNombre();
            if(!StringUtils.isEmpty(request.getContrasenia())&&request.getContrasenia().equals(usuarioEntity.getcContrasenia())){
                return new EmpleadoLoginResponse(usuarioEntity.getId().toString(),nombre,rolEntity.getId().toString(),"1");
            }else{
                return new EmpleadoLoginResponse("","","","3");
            }
        }else{
            return new EmpleadoLoginResponse("","","","2");
        }
    }

    @RequestMapping(value="/clienteLogin", method = RequestMethod.POST)
    public ClienteLoginResponse clienteLogin(@RequestBody LoginRequest request){

        UsuarioEntity usuarioEntity = usuarioRepository.findByCUsuario(request.getUsuario());
        String nombre = null;

        if(usuarioEntity!=null){
            nombre = usuarioEntity.getcNombre();
            if(!StringUtils.isEmpty(request.getContrasenia())&&request.getContrasenia().equals(usuarioEntity.getcContrasenia())){
                return new ClienteLoginResponse(usuarioEntity.getId().toString(),nombre);
            }else{
                return new ClienteLoginResponse("","");
            }
        }else{
            return new ClienteLoginResponse("","");
        }
    }


}
