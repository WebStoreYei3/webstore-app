package com.gemobile.core.entity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "stock", schema = "webstore", catalog = "")
public class StockEntity {
    private String cSku;
    private Integer iIdProducto;
    private Integer iIdAlmacen;
    private BigDecimal dCantidadDisponible;
    private BigDecimal dCantidadMinima;

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
    @Column(name = "D_CANTIDAD_DISPONIBLE", nullable = false, precision = 3)
    public BigDecimal getdCantidadDisponible() {
        return dCantidadDisponible;
    }

    public void setdCantidadDisponible(BigDecimal dCantidadDisponible) {
        this.dCantidadDisponible = dCantidadDisponible;
    }

    @Basic
    @Column(name = "D_CANTIDAD_MINIMA", nullable = false, precision = 3)
    public BigDecimal getdCantidadMinima() {
        return dCantidadMinima;
    }

    public void setdCantidadMinima(BigDecimal dCantidadMinima) {
        this.dCantidadMinima = dCantidadMinima;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StockEntity that = (StockEntity) o;

        if (cSku != null ? !cSku.equals(that.cSku) : that.cSku != null) return false;
        if (iIdProducto != null ? !iIdProducto.equals(that.iIdProducto) : that.iIdProducto != null) return false;
        if (iIdAlmacen != null ? !iIdAlmacen.equals(that.iIdAlmacen) : that.iIdAlmacen != null) return false;
        if (dCantidadDisponible != null ? !dCantidadDisponible.equals(that.dCantidadDisponible) : that.dCantidadDisponible != null)
            return false;
        if (dCantidadMinima != null ? !dCantidadMinima.equals(that.dCantidadMinima) : that.dCantidadMinima != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = cSku != null ? cSku.hashCode() : 0;
        result = 31 * result + (iIdProducto != null ? iIdProducto.hashCode() : 0);
        result = 31 * result + (iIdAlmacen != null ? iIdAlmacen.hashCode() : 0);
        result = 31 * result + (dCantidadDisponible != null ? dCantidadDisponible.hashCode() : 0);
        result = 31 * result + (dCantidadMinima != null ? dCantidadMinima.hashCode() : 0);
        return result;
    }
}
