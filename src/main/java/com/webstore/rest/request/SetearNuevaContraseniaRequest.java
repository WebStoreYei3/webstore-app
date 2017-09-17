package com.webstore.rest.request;

public class SetearNuevaContraseniaRequest {
    String key;
    String nuevaContrasenia;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getNuevaContrasenia() {
        return nuevaContrasenia;
    }

    public void setNuevaContrasenia(String nuevaContrasenia) {
        this.nuevaContrasenia = nuevaContrasenia;
    }
}
