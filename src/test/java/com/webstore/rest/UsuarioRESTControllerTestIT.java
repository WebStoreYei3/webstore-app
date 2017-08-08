package com.webstore.rest;

import com.webstore.Runner;
import com.webstore.rest.request.LoginRequest;
import com.webstore.rest.response.ClienteLoginResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.mock.http.MockHttpOutputMessage;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.Arrays;


import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
public class UsuarioRESTControllerTestIT {

    @LocalServerPort
    private int port;

    private HttpMessageConverter mappingJackson2HttpMessageConverter;

    TestRestTemplate restTemplate = new TestRestTemplate();

    HttpHeaders headers = new HttpHeaders();

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

    @Test
    public void clienteLoginTest() throws Exception {

        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsuario(usuario);
        loginRequest.setContrasenia(contrasenia);

        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<String>(this.json(loginRequest), headers);

        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/clienteLogin"),
                HttpMethod.POST, entity, String.class);

        ClienteLoginResponse clienteLoginResponse = new ClienteLoginResponse("4","strNumbreTest","0");
        String expected = this.json(clienteLoginResponse);

        JSONAssert.assertEquals(expected, response.getBody(), false);

    }

    private String createURLWithPort(String uri) {
        return "http://localhost:" + port + uri;
    }

    protected String json(Object o) throws IOException {
        MockHttpOutputMessage mockHttpOutputMessage = new MockHttpOutputMessage();
        this.mappingJackson2HttpMessageConverter.write(
                o, MediaType.APPLICATION_JSON, mockHttpOutputMessage);
        return mockHttpOutputMessage.getBodyAsString();
    }

}
