package com.webstore.rest.request;

public class ProveedorRequest {
    private String cCodigo;
    private String cNombre;
    private String cContacto;
    private String cUbicacion;

    public String getcCodigo() {
        return cCodigo;
    }

    public void setcCodigo(String cCodigo) {
        this.cCodigo = cCodigo;
    }

    public String getcNombre() {
        return cNombre;
    }

    public void setcNombre(String cNombre) {
        this.cNombre = cNombre;
    }

    public String getcContacto() {
        return cContacto;
    }

    public void setcContacto(String cContacto) {
        this.cContacto = cContacto;
    }

    public String getcUbicacion() {
        return cUbicacion;
    }

    public void setcUbicacion(String cUbicacion) {
        this.cUbicacion = cUbicacion;
    }
}
