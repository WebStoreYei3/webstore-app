package com.gemobile.core.entity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "orden_stock", schema = "webstore", catalog = "")
public class OrdenStockEntity {
    private Integer id;
    private Integer iIdStock;
    private BigDecimal dCantidad;
    private Integer iIdAlmacen;
    private Integer iIdOrdenEntrega;

    @Id
    @Column(name = "ID", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "I_ID_STOCK", nullable = false)
    public Integer getiIdStock() {
        return iIdStock;
    }

    public void setiIdStock(Integer iIdStock) {
        this.iIdStock = iIdStock;
    }

    @Basic
    @Column(name = "D_CANTIDAD", nullable = false, precision = 3)
    public BigDecimal getdCantidad() {
        return dCantidad;
    }

    public void setdCantidad(BigDecimal dCantidad) {
        this.dCantidad = dCantidad;
    }

    @Basic
    @Column(name = "I_ID_ALMACEN", nullable = true)
    public Integer getiIdAlmacen() {
        return iIdAlmacen;
    }

    public void setiIdAlmacen(Integer iIdAlmacen) {
        this.iIdAlmacen = iIdAlmacen;
    }

    @Basic
    @Column(name = "I_ID_ORDEN_ENTREGA", nullable = true)
    public Integer getiIdOrdenEntrega() {
        return iIdOrdenEntrega;
    }

    public void setiIdOrdenEntrega(Integer iIdOrdenEntrega) {
        this.iIdOrdenEntrega = iIdOrdenEntrega;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrdenStockEntity that = (OrdenStockEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (iIdStock != null ? !iIdStock.equals(that.iIdStock) : that.iIdStock != null) return false;
        if (dCantidad != null ? !dCantidad.equals(that.dCantidad) : that.dCantidad != null) return false;
        if (iIdAlmacen != null ? !iIdAlmacen.equals(that.iIdAlmacen) : that.iIdAlmacen != null) return false;
        if (iIdOrdenEntrega != null ? !iIdOrdenEntrega.equals(that.iIdOrdenEntrega) : that.iIdOrdenEntrega != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (iIdStock != null ? iIdStock.hashCode() : 0);
        result = 31 * result + (dCantidad != null ? dCantidad.hashCode() : 0);
        result = 31 * result + (iIdAlmacen != null ? iIdAlmacen.hashCode() : 0);
        result = 31 * result + (iIdOrdenEntrega != null ? iIdOrdenEntrega.hashCode() : 0);
        return result;
    }
}
