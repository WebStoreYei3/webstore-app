package com.webstore.rest.request;

import java.sql.Timestamp;

public class MovimientoAlmacenStockRequest {
    private Timestamp fMovimiento;
    private String cSkuStock;
    private Integer iIdAlmacenOrigen;
    private Integer iIdAlmacenDestino;
    private Integer iIdEmpleado;

    public Timestamp getfMovimiento() {
        return fMovimiento;
    }

    public void setfMovimiento(Timestamp fMovimiento) {
        this.fMovimiento = fMovimiento;
    }

    public String getcSkuStock() {
        return cSkuStock;
    }

    public void setcSkuStock(String cSkuStock) {
        this.cSkuStock = cSkuStock;
    }

    public Integer getiIdAlmacenOrigen() {
        return iIdAlmacenOrigen;
    }

    public void setiIdAlmacenOrigen(Integer iIdAlmacenOrigen) {
        this.iIdAlmacenOrigen = iIdAlmacenOrigen;
    }

    public Integer getiIdAlmacenDestino() {
        return iIdAlmacenDestino;
    }

    public void setiIdAlmacenDestino(Integer iIdAlmacenDestino) {
        this.iIdAlmacenDestino = iIdAlmacenDestino;
    }

    public Integer getiIdEmpleado() {
        return iIdEmpleado;
    }

    public void setiIdEmpleado(Integer iIdEmpleado) {
        this.iIdEmpleado = iIdEmpleado;
    }
}
