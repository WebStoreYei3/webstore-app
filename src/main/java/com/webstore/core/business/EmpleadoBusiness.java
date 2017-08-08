package com.webstore.core.business;

import com.webstore.core.entity.EmpleadoEntity;
import com.webstore.core.repository.EmpleadoRepository;
import com.webstore.core.repository.RolRepository;
import com.webstore.core.repository.UsuarioRepository;
import com.webstore.rest.request.EmpleadoRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmpleadoBusiness {
    private EmpleadoRepository empleadoRepository;
    private RolRepository rolRepository;
    private UsuarioRepository usuarioRepository;

    @Autowired
    public EmpleadoBusiness(
            EmpleadoRepository empleadoRepository,
            RolRepository rolRepository,
            UsuarioRepository usuarioRepository
    ) {
        this.empleadoRepository = empleadoRepository;
        this.rolRepository = rolRepository;
        this.usuarioRepository = usuarioRepository;
    }

    public void altaEmpleado(EmpleadoRequest empleadoRequest) throws Exception {
        if(!rolRepository.exists(empleadoRequest.getiIdRol())){
            throw new Exception("No existe el rol solicitado");
        }
        if(!usuarioRepository.exists(empleadoRequest.getiIdUsuario())){
            throw new Exception("No existe el usuario solicitado");
        }
        EmpleadoEntity empleadoEntity = new EmpleadoEntity();
        empleadoEntity.setcCodigo(empleadoRequest.getcCodigo());
        empleadoEntity.setiIdRol(empleadoRequest.getiIdRol());
        empleadoEntity.setiIdUsuario(empleadoRequest.getiIdUsuario());
        empleadoRepository.save(empleadoEntity);
    }
}
