package com.gemobile.core.entity;

import javax.persistence.*;

/**
 * Created by Oscar Rodriguez on 14/07/2017.
 */
@Entity
@Table(name = "stock", schema = "webstore", catalog = "")
public class StockEntity {
    private String cSku;
    private Integer iIdProducto;
    private Integer iIdAlmacen;
    private Integer iCantidadDisponible;
    private Integer iCantidadMinima;

    @Id
    @Column(name = "C_SKU", nullable = false, length = 50)
    public String getcSku() {
        return cSku;
    }

    public void setcSku(String cSku) {
        this.cSku = cSku;
    }

    @Basic
    @Column(name = "I_ID_PRODUCTO", nullable = false)
    public Integer getiIdProducto() {
        return iIdProducto;
    }

    public void setiIdProducto(Integer iIdProducto) {
        this.iIdProducto = iIdProducto;
    }

    @Basic
    @Column(name = "I_ID_ALMACEN", nullable = false)
    public Integer getiIdAlmacen() {
        return iIdAlmacen;
    }

    public void setiIdAlmacen(Integer iIdAlmacen) {
        this.iIdAlmacen = iIdAlmacen;
    }

    @Basic
    @Column(name = "I_CANTIDAD_DISPONIBLE", nullable = false)
    public Integer getiCantidadDisponible() {
        return iCantidadDisponible;
    }

    public void setiCantidadDisponible(Integer iCantidadDisponible) {
        this.iCantidadDisponible = iCantidadDisponible;
    }

    @Basic
    @Column(name = "I_CANTIDAD_MINIMA", nullable = false)
    public Integer getiCantidadMinima() {
        return iCantidadMinima;
    }

    public void setiCantidadMinima(Integer iCantidadMinima) {
        this.iCantidadMinima = iCantidadMinima;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StockEntity that = (StockEntity) o;

        if (cSku != null ? !cSku.equals(that.cSku) : that.cSku != null) return false;
        if (iIdProducto != null ? !iIdProducto.equals(that.iIdProducto) : that.iIdProducto != null) return false;
        if (iIdAlmacen != null ? !iIdAlmacen.equals(that.iIdAlmacen) : that.iIdAlmacen != null) return false;
        if (iCantidadDisponible != null ? !iCantidadDisponible.equals(that.iCantidadDisponible) : that.iCantidadDisponible != null)
            return false;
        if (iCantidadMinima != null ? !iCantidadMinima.equals(that.iCantidadMinima) : that.iCantidadMinima != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = cSku != null ? cSku.hashCode() : 0;
        result = 31 * result + (iIdProducto != null ? iIdProducto.hashCode() : 0);
        result = 31 * result + (iIdAlmacen != null ? iIdAlmacen.hashCode() : 0);
        result = 31 * result + (iCantidadDisponible != null ? iCantidadDisponible.hashCode() : 0);
        result = 31 * result + (iCantidadMinima != null ? iCantidadMinima.hashCode() : 0);
        return result;
    }
}
