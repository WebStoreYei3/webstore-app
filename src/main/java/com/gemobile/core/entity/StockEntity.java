package com.gemobile.core.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Collection;

@Entity
@Table(name = "stock", schema = "webstore", catalog = "")
public class StockEntity {
    private String cSku;
    private BigDecimal dCantidadDisponible;
    private BigDecimal dCantidadMinima;
    private Collection<MovimientoAlmacenStockEntity> movimientosAlmacenStock;
    private Collection<OperacionAbmStockEntity> operacionesABM;
    private Collection<OrdenStockEntity> ordenesStock;
    private ProductoEntity producto;
    private AlmacenEntity almacen;

    @Id
    @Column(name = "C_SKU", nullable = false, length = 50)
    public String getcSku() {
        return cSku;
    }

    public void setcSku(String cSku) {
        this.cSku = cSku;
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
        if (dCantidadDisponible != null ? !dCantidadDisponible.equals(that.dCantidadDisponible) : that.dCantidadDisponible != null)
            return false;
        if (dCantidadMinima != null ? !dCantidadMinima.equals(that.dCantidadMinima) : that.dCantidadMinima != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = cSku != null ? cSku.hashCode() : 0;
        result = 31 * result + (dCantidadDisponible != null ? dCantidadDisponible.hashCode() : 0);
        result = 31 * result + (dCantidadMinima != null ? dCantidadMinima.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "stock")
    public Collection<MovimientoAlmacenStockEntity> getMovimientosAlmacenStock() {
        return movimientosAlmacenStock;
    }

    public void setMovimientosAlmacenStock(Collection<MovimientoAlmacenStockEntity> movimientosAlmacenStock) {
        this.movimientosAlmacenStock = movimientosAlmacenStock;
    }

    @OneToMany(mappedBy = "stock")
    public Collection<OperacionAbmStockEntity> getOperacionesABM() {
        return operacionesABM;
    }

    public void setOperacionesABM(Collection<OperacionAbmStockEntity> operacionesABM) {
        this.operacionesABM = operacionesABM;
    }

    @OneToMany(mappedBy = "stock")
    public Collection<OrdenStockEntity> getOrdenesStock() {
        return ordenesStock;
    }

    public void setOrdenesStock(Collection<OrdenStockEntity> ordenesStock) {
        this.ordenesStock = ordenesStock;
    }

    @OneToOne
    @JoinColumn(name = "I_ID_PRODUCTO", referencedColumnName = "ID", nullable = false)
    public ProductoEntity getProducto() {
        return producto;
    }

    public void setProducto(ProductoEntity producto) {
        this.producto = producto;
    }

    @ManyToOne
    @JoinColumn(name = "I_ID_ALMACEN", referencedColumnName = "ID", nullable = false)
    public AlmacenEntity getAlmacen() {
        return almacen;
    }

    public void setAlmacen(AlmacenEntity almacen) {
        this.almacen = almacen;
    }
}
