package com.gemobile.core.entity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "orden_stock", schema = "webstore", catalog = "")
public class OrdenStockEntity {
    private Integer id;
    private BigDecimal dCantidad;
    private StockEntity stock;
    private OrdenMostradorEntity ordenMostrador;
    private OrdenEntregaEntity ordenEntrega;

    @Id
    @Column(name = "ID", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "D_CANTIDAD", nullable = false, precision = 3)
    public BigDecimal getdCantidad() {
        return dCantidad;
    }

    public void setdCantidad(BigDecimal dCantidad) {
        this.dCantidad = dCantidad;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrdenStockEntity that = (OrdenStockEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (dCantidad != null ? !dCantidad.equals(that.dCantidad) : that.dCantidad != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (dCantidad != null ? dCantidad.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "I_ID_STOCK", referencedColumnName = "I_ID_PRODUCTO", nullable = false)
    public StockEntity getStock() {
        return stock;
    }

    public void setStock(StockEntity stock) {
        this.stock = stock;
    }

    @ManyToOne
    @JoinColumn(name = "I_ID_ALMACEN", referencedColumnName = "ID")
    public OrdenMostradorEntity getOrdenMostrador() {
        return ordenMostrador;
    }

    public void setOrdenMostrador(OrdenMostradorEntity ordenMostrador) {
        this.ordenMostrador = ordenMostrador;
    }

    @ManyToOne
    @JoinColumn(name = "I_ID_ORDEN_ENTREGA", referencedColumnName = "ID")
    public OrdenEntregaEntity getOrdenEntrega() {
        return ordenEntrega;
    }

    public void setOrdenEntrega(OrdenEntregaEntity ordenEntrega) {
        this.ordenEntrega = ordenEntrega;
    }
}
