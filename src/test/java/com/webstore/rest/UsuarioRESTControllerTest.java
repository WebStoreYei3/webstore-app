package com.webstore.rest;

import com.webstore.WebstoreUnitTest;
import com.webstore.core.entity.UsuarioEntity;
import com.webstore.core.repository.EmpleadoRepository;
import com.webstore.core.repository.UsuarioRepository;
import com.webstore.rest.request.LoginRequest;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.util.ReflectionTestUtils;

import java.sql.Timestamp;

import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;
//Linea necesaria para Test unitario
@RunWith(SpringRunner.class)
public class UsuarioRESTControllerTest extends WebstoreUnitTest {

    private UsuarioRepository usuarioRepository;
    private EmpleadoRepository empleadoRepository;

    @Autowired
    private UsuarioRESTController usuarioRESTController;

    private String nombre = "strNumbreTest";

    private String usuario = "strUsuarioTest";

    private String contrasenia = "strContraseniaTest";

    @Before
    public void setup() throws Exception {
        //Linea necesaria en todos los test
        this.mockMvc = webAppContextSetup(webApplicationContext).build();

        this.usuarioRepository = Mockito.mock(UsuarioRepository.class);

        when(usuarioRepository.findByCUsuario(usuario)).thenReturn(new UsuarioEntity(3,
                nombre,
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                new Timestamp(System.currentTimeMillis()),
                "",
                new Integer(1),
                usuario,
                contrasenia));

        ReflectionTestUtils.setField(usuarioRESTController, "usuarioRepository", usuarioRepository);
    }

    @Test
    public void clienteLogin() throws Exception {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsuario(usuario);
        loginRequest.setContrasenia(contrasenia);
        mockMvc.perform(post("/clienteLogin")
                .content(this.json(loginRequest))
                .contentType(contentType))
                .andExpect(content().contentType(contentType))
                .andExpect(jsonPath("$.id", is("3")))
                .andExpect(jsonPath("$.nombre", is(nombre)));
        System.out.println("Terminado");
    }
}
