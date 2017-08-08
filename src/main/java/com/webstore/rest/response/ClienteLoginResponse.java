package com.webstore.rest.response;

public class ClienteLoginResponse {
    private String id;
    private String nombre;
    private String error;

    public ClienteLoginResponse(String id, String nombre, String error) {
        this.id = id;
        this.nombre = nombre;
        this.error = error;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
