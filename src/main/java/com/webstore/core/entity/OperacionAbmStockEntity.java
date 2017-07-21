package com.webstore.core.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Table(name = "operacion_abm_stock", schema = "webstore", catalog = "")
public class OperacionAbmStockEntity {
    private Integer id;
    private Integer iIdTipoOperacion;
    private Timestamp fOperacion;
    private Integer iIdStock;
    private BigDecimal dCantidad;
    private Integer iIdEmpleado;

    @Id
    @Column(name = "ID", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "I_ID_TIPO_OPERACION", nullable = false)
    public Integer getiIdTipoOperacion() {
        return iIdTipoOperacion;
    }

    public void setiIdTipoOperacion(Integer iIdTipoOperacion) {
        this.iIdTipoOperacion = iIdTipoOperacion;
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
    @Column(name = "I_ID_EMPLEADO", nullable = false)
    public Integer getiIdEmpleado() {
        return iIdEmpleado;
    }

    public void setiIdEmpleado(Integer iIdEmpleado) {
        this.iIdEmpleado = iIdEmpleado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OperacionAbmStockEntity that = (OperacionAbmStockEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (iIdTipoOperacion != null ? !iIdTipoOperacion.equals(that.iIdTipoOperacion) : that.iIdTipoOperacion != null)
            return false;
        if (fOperacion != null ? !fOperacion.equals(that.fOperacion) : that.fOperacion != null) return false;
        if (iIdStock != null ? !iIdStock.equals(that.iIdStock) : that.iIdStock != null) return false;
        if (dCantidad != null ? !dCantidad.equals(that.dCantidad) : that.dCantidad != null) return false;
        if (iIdEmpleado != null ? !iIdEmpleado.equals(that.iIdEmpleado) : that.iIdEmpleado != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (iIdTipoOperacion != null ? iIdTipoOperacion.hashCode() : 0);
        result = 31 * result + (fOperacion != null ? fOperacion.hashCode() : 0);
        result = 31 * result + (iIdStock != null ? iIdStock.hashCode() : 0);
        result = 31 * result + (dCantidad != null ? dCantidad.hashCode() : 0);
        result = 31 * result + (iIdEmpleado != null ? iIdEmpleado.hashCode() : 0);
        return result;
    }
}
