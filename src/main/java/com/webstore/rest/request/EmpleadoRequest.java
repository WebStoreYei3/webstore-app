package com.webstore.rest.request;

public class EmpleadoRequest {
    private Integer id;
    private String cCodigo;
    private Integer iIdRol;
    private Integer iIdUsuario;

    public String getcCodigo() {
        return cCodigo;
    }

    public void setcCodigo(String cCodigo) {
        this.cCodigo = cCodigo;
    }

    public Integer getiIdRol() {
        return iIdRol;
    }

    public void setiIdRol(Integer iIdRol) {
        this.iIdRol = iIdRol;
    }

    public Integer getiIdUsuario() {
        return iIdUsuario;
    }

    public void setiIdUsuario(Integer iIdUsuario) {
        this.iIdUsuario = iIdUsuario;
    }
}
