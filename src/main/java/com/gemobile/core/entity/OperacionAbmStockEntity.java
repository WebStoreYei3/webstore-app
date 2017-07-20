package com.gemobile.core.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Table(name = "operacion_abm_stock", schema = "webstore", catalog = "")
public class OperacionAbmStockEntity {
    private Integer id;
    private Timestamp fOperacion;
    private BigDecimal dCantidad;
    private TipoOperacionEntity tipoOperacion;
    private StockEntity stock;
    private EmpleadoEntity empleado;

    @Id
    @Column(name = "ID", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "F_OPERACION", nullable = false)
    public Timestamp getfOperacion() {
        return fOperacion;
    }

    public void setfOperacion(Timestamp fOperacion) {
        this.fOperacion = fOperacion;
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

        OperacionAbmStockEntity that = (OperacionAbmStockEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (fOperacion != null ? !fOperacion.equals(that.fOperacion) : that.fOperacion != null) return false;
        if (dCantidad != null ? !dCantidad.equals(that.dCantidad) : that.dCantidad != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (fOperacion != null ? fOperacion.hashCode() : 0);
        result = 31 * result + (dCantidad != null ? dCantidad.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "I_ID_TIPO_OPERACION", referencedColumnName = "ID", nullable = false)
    public TipoOperacionEntity getTipoOperacion() {
        return tipoOperacion;
    }

    public void setTipoOperacion(TipoOperacionEntity tipoOperacion) {
        this.tipoOperacion = tipoOperacion;
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
    @JoinColumn(name = "I_ID_EMPLEADO", referencedColumnName = "ID", nullable = false)
    public EmpleadoEntity getEmpleado() {
        return empleado;
    }

    public void setEmpleado(EmpleadoEntity empleado) {
        this.empleado = empleado;
    }
}
