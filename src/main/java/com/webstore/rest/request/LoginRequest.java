package com.webstore.rest.request;

public class LoginRequest {
    String usuario;
    String contrasenia;
    String fUltSesion;

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getfUltSesion() {
        return fUltSesion;
    }

    public void setfUltSesion(String fUltSesion) {
        this.fUltSesion = fUltSesion;
    }
}
