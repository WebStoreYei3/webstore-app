package com.webstore.core.business;

import com.webstore.core.entity.EmpleadoEntity;
import com.webstore.core.entity.RolEntity;
import com.webstore.core.entity.UsuarioEntity;
import com.webstore.core.repository.EmpleadoRepository;
import com.webstore.core.repository.RolRepository;
import com.webstore.core.repository.UsuarioRepository;
import com.webstore.rest.request.LoginRequest;
import com.webstore.rest.request.LogoutRequest;
import com.webstore.rest.response.ClienteLoginResponse;
import com.webstore.rest.response.EmpleadoLoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

@Component
public class UsuarioBusiness {
    private UsuarioRepository usuarioRepository;
    private RolRepository rolRepository;
    private EmpleadoRepository empleadoRepository;

    @Autowired
    public UsuarioBusiness(
            UsuarioRepository usuarioRepository,
            RolRepository rolRepository,
            EmpleadoRepository empleadoRepository
    ){
        this.usuarioRepository = usuarioRepository;
        this.rolRepository = rolRepository;
        this.empleadoRepository = empleadoRepository;
    }

    public EmpleadoLoginResponse empleadoLogin(LoginRequest request){

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

    public ClienteLoginResponse clienteLogin( LoginRequest request){
        UsuarioEntity usuarioEntity = usuarioRepository.findByCUsuario(request.getUsuario());
        String nombre = null;

        if(usuarioEntity!=null){
            nombre = usuarioEntity.getcNombre();
            if(!StringUtils.isEmpty(request.getContrasenia())&&request.getContrasenia().equals(usuarioEntity.getcContrasenia())){
                usuarioEntity.setiIdEstadoUsuario(1);
                usuarioEntity.setfUltSesion(new Timestamp(System.currentTimeMillis()));
                usuarioRepository.save(usuarioEntity);
                return new ClienteLoginResponse(usuarioEntity.getId().toString(),nombre,"1");
            }else{
                return new ClienteLoginResponse("","","3");
            }
        }else{
            return new ClienteLoginResponse("","","2");
        }
    }

    public void clienteLogout ( LogoutRequest request) throws Exception {
        UsuarioEntity usuarioEntity = usuarioRepository.findOne(request.getId());
        if(usuarioEntity!=null) {
            usuarioEntity.setiIdEstadoUsuario(2);
            usuarioRepository.save(usuarioEntity);
        }
    }

    public boolean tiempoAgotado (String id, String date) throws Exception {
        UsuarioEntity usuarioEntity = usuarioRepository.findOne(new Integer(id));
        if(usuarioEntity!=null) {
            Date us = new Date(usuarioEntity.getfUltSesion().getTime());
            Date now = new Date((new Timestamp(new Long(date)).getTime()));
            Calendar usC = Calendar.getInstance();
            usC.setTime(us);
            Calendar nowC = Calendar.getInstance();
            nowC.setTime(now);
            usC.add(Calendar.MINUTE,30);
            if(usC.getTime().before(nowC.getTime())){
                return true;
            }
            else{
                return false;
            }
        }
        return true;
    }
}
