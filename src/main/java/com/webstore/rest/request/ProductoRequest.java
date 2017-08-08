package com.webstore.rest.request;

import com.webstore.core.entity.ProductoEntity;

public class ProductoRequest {
    private String cCodigo;
    private String cNombre;
    private Integer iIdTipo;
    private Integer iIdSubtipo;
    private String cDescripcion;
    private Integer iIdProveedor;
    private String cMarca;
    private String cUnidad;

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

    public Integer getiIdTipo() {
        return iIdTipo;
    }

    public void setiIdTipo(Integer iIdTipo) {
        this.iIdTipo = iIdTipo;
    }

    public Integer getiIdSubtipo() {
        return iIdSubtipo;
    }

    public void setiIdSubtipo(Integer iIdSubtipo) {
        this.iIdSubtipo = iIdSubtipo;
    }

    public String getcDescripcion() {
        return cDescripcion;
    }

    public void setcDescripcion(String cDescripcion) {
        this.cDescripcion = cDescripcion;
    }

    public Integer getiIdProveedor() {
        return iIdProveedor;
    }

    public void setiIdProveedor(Integer iIdProveedor) {
        this.iIdProveedor = iIdProveedor;
    }

    public String getcMarca() {
        return cMarca;
    }

    public void setcMarca(String cMarca) {
        this.cMarca = cMarca;
    }

    public String getcUnidad() {
        return cUnidad;
    }

    public void setcUnidad(String cUnidad) {
        this.cUnidad = cUnidad;
    }
}
