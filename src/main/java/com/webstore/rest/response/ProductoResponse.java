package com.webstore.rest.response;

import java.math.BigDecimal;

public class ProductoResponse {
    private Integer id;
    private String cCodigo;
    private String cNombre;
    private Integer iIdTipo;
    private Integer iIdSubtipo;
    private String cDescripcion;
    private Integer iIdProveedor;
    private String cMarca;
    private String cUnidad;
    private BigDecimal dCosto;
    private BigDecimal dPrecioPublico;
    private BigDecimal dPrecioMayoreo;
    private BigDecimal dCantidadMayoreo;
    private String cImagenes;

    public ProductoResponse(Integer id,
                            String cCodigo,
                            String cNombre,
                            Integer iIdTipo,
                            Integer iIdSubtipo,
                            String cDescripcion,
                            Integer iIdProveedor,
                            String cMarca,
                            String cUnidad,
                            BigDecimal dCosto,
                            BigDecimal dPrecioPublico,
                            BigDecimal dPrecioMayoreo,
                            BigDecimal dCantidadMayoreo,
                            String cImagenes) {
        this.id = id;
        this.cCodigo = cCodigo;
        this.cNombre = cNombre;
        this.iIdTipo = iIdTipo;
        this.iIdSubtipo = iIdSubtipo;
        this.cDescripcion = cDescripcion;
        this.iIdProveedor = iIdProveedor;
        this.cMarca = cMarca;
        this.cUnidad = cUnidad;
        this.dCosto = dCosto;
        this.dPrecioPublico = dPrecioPublico;
        this.dPrecioMayoreo = dPrecioMayoreo;
        this.dCantidadMayoreo = dCantidadMayoreo;
        this.cImagenes = cImagenes;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public BigDecimal getdCosto() {
        return dCosto;
    }

    public void setdCosto(BigDecimal dCosto) {
        this.dCosto = dCosto;
    }

    public BigDecimal getdPrecioPublico() {
        return dPrecioPublico;
    }

    public void setdPrecioPublico(BigDecimal dPrecioPublico) {
        this.dPrecioPublico = dPrecioPublico;
    }

    public BigDecimal getdPrecioMayoreo() {
        return dPrecioMayoreo;
    }

    public void setdPrecioMayoreo(BigDecimal dPrecioMayoreo) {
        this.dPrecioMayoreo = dPrecioMayoreo;
    }

    public BigDecimal getdCantidadMayoreo() {
        return dCantidadMayoreo;
    }

    public void setdCantidadMayoreo(BigDecimal dCantidadMayoreo) {
        this.dCantidadMayoreo = dCantidadMayoreo;
    }

    public String getcImagenes() {
        return cImagenes;
    }

    public void setcImagenes(String cImagenes) {
        this.cImagenes = cImagenes;
    }

}
