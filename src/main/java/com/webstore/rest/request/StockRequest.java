package com.webstore.rest.request;

import java.math.BigDecimal;

public class StockRequest {
    private Integer iIdProducto;
    private Integer iIdAlmacen;
    private BigDecimal dCantidadDisponible;
    private BigDecimal dCantidadMinima;
    private Integer iIdEmpleado;

    public Integer getiIdProducto() {
        return iIdProducto;
    }

    public void setiIdProducto(Integer iIdProducto) {
        this.iIdProducto = iIdProducto;
    }

    public Integer getiIdAlmacen() {
        return iIdAlmacen;
    }

    public void setiIdAlmacen(Integer iIdAlmacen) {
        this.iIdAlmacen = iIdAlmacen;
    }

    public BigDecimal getdCantidadDisponible() {
        return dCantidadDisponible;
    }

    public void setdCantidadDisponible(BigDecimal dCantidadDisponible) {
        this.dCantidadDisponible = dCantidadDisponible;
    }

    public BigDecimal getdCantidadMinima() {
        return dCantidadMinima;
    }

    public void setdCantidadMinima(BigDecimal dCantidadMinima) {
        this.dCantidadMinima = dCantidadMinima;
    }

    public Integer getiIdEmpleado() {
        return iIdEmpleado;
    }

    public void setiIdEmpleado(Integer iIdEmpleado) {
        this.iIdEmpleado = iIdEmpleado;
    }
}
