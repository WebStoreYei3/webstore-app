package com.webstore.rest.request;

import java.util.List;

public class PagoRequest {
    private String direccion;
    private List<FilaResumenCompraRequest> filas;
    private Integer usuarioId;
    private String nombre;
    private String apePat;
    private String apeMat;
    private String email;
    private String tel;
    private String numeroInt;
    private String instEspeciales;

    public Integer getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Integer usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public List<FilaResumenCompraRequest> getFilas() {
        return filas;
    }

    public void setFilas(List<FilaResumenCompraRequest> filas) {
        this.filas = filas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApePat() {
        return apePat;
    }

    public void setApePat(String apePat) {
        this.apePat = apePat;
    }

    public String getApeMat() {
        return apeMat;
    }

    public void setApeMat(String apeMat) {
        this.apeMat = apeMat;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getNumeroInt() {
        return numeroInt;
    }

    public void setNumeroInt(String numeroInt) {
        this.numeroInt = numeroInt;
    }

    public String getInstEspeciales() {
        return instEspeciales;
    }

    public void setInstEspeciales(String instEspeciales) {
        this.instEspeciales = instEspeciales;
    }
}
