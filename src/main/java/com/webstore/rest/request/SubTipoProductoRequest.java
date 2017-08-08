package com.webstore.rest.request;

public class SubTipoProductoRequest {
    private String cCodigo;
    private String cDescripcion;
    private Integer iIdTipoProducto;

    public String getcCodigo() {
        return cCodigo;
    }

    public void setcCodigo(String cCodigo) {
        this.cCodigo = cCodigo;
    }

    public String getcDescripcion() {
        return cDescripcion;
    }

    public void setcDescripcion(String cDescripcion) {
        this.cDescripcion = cDescripcion;
    }

    public Integer getiIdTipoProducto() {
        return iIdTipoProducto;
    }

    public void setiIdTipoProducto(Integer iIdTipoProducto) {
        this.iIdTipoProducto = iIdTipoProducto;
    }
}
