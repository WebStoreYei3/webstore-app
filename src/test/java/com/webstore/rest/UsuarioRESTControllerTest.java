package com.webstore.rest;

import com.webstore.Runner;
import com.webstore.core.entity.UsuarioEntity;
import com.webstore.core.repository.EmpleadoRepository;
import com.webstore.core.repository.UsuarioRepository;
import com.webstore.rest.request.LoginRequest;
import com.webstore.rest.response.ClienteLoginResponse;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.mock.http.MockHttpOutputMessage;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import java.io.IOException;
import java.nio.charset.Charset;
import java.sql.Timestamp;
import java.util.Arrays;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Runner.class)
@WebAppConfiguration
public class UsuarioRESTControllerTest {
    private MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype(),
            Charset.forName("utf8"));

    private MockMvc mockMvc;

    private HttpMessageConverter mappingJackson2HttpMessageConverter;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private EmpleadoRepository empleadoRepository;

    @Autowired
    private WebApplicationContext webApplicationContext;


    private UsuarioEntity usuarioEntity;

    private String nombre = "strNumbreTest";

    private String usuario = "strUsuarioTest";

    private String contrasenia = "strContraseniaTest";

    @Autowired
    void setConverters(HttpMessageConverter<?>[] converters) {

        this.mappingJackson2HttpMessageConverter = Arrays.asList(converters).stream()
                .filter(hmc -> hmc instanceof MappingJackson2HttpMessageConverter)
                .findAny()
                .orElse(null);

        assertNotNull("the JSON message converter must not be null",
                this.mappingJackson2HttpMessageConverter);
    }

    @Before
    public void setup() throws Exception {
        this.mockMvc = webAppContextSetup(webApplicationContext).build();

        this.usuarioRepository.deleteAllInBatch();
        this.empleadoRepository.deleteAllInBatch();

        this.usuarioEntity = usuarioRepository.save(new UsuarioEntity(2,
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
                .andExpect(jsonPath("$.id", is("2")))
                .andExpect(jsonPath("$.nombre", is(nombre)));
    }

    protected String json(Object o) throws IOException {
        MockHttpOutputMessage mockHttpOutputMessage = new MockHttpOutputMessage();
        this.mappingJackson2HttpMessageConverter.write(
                o, MediaType.APPLICATION_JSON, mockHttpOutputMessage);
        return mockHttpOutputMessage.getBodyAsString();
    }


}
