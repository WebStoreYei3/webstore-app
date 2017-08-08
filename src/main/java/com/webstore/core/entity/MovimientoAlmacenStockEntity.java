package com.webstore.core.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "movimiento_almacen_stock", schema = "webstore", catalog = "")
public class MovimientoAlmacenStockEntity {
    private Integer id;
    private Timestamp fMovimiento;
    private String cSkuStock;
    private Integer iIdAlmacenOrigen;
    private Integer iIdAlmacenDestino;
    private Integer iIdEmpleado;

    @Id
    @GeneratedValue
    @Column(name = "ID", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "F_MOVIMIENTO", nullable = false)
    public Timestamp getfMovimiento() {
        return fMovimiento;
    }

    public void setfMovimiento(Timestamp fMovimiento) {
        this.fMovimiento = fMovimiento;
    }

    @Basic
    @Column(name = "C_SKU_STOCK", nullable = false, length = 50)
    public String getcSkuStock() {
        return cSkuStock;
    }

    public void setcSkuStock(String cSkuStock) {
        this.cSkuStock = cSkuStock;
    }

    @Basic
    @Column(name = "I_ID_ALMACEN_ORIGEN", nullable = false)
    public Integer getiIdAlmacenOrigen() {
        return iIdAlmacenOrigen;
    }

    public void setiIdAlmacenOrigen(Integer iIdAlmacenOrigen) {
        this.iIdAlmacenOrigen = iIdAlmacenOrigen;
    }

    @Basic
    @Column(name = "I_ID_ALMACEN_DESTINO", nullable = false)
    public Integer getiIdAlmacenDestino() {
        return iIdAlmacenDestino;
    }

    public void setiIdAlmacenDestino(Integer iIdAlmacenDestino) {
        this.iIdAlmacenDestino = iIdAlmacenDestino;
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

        MovimientoAlmacenStockEntity that = (MovimientoAlmacenStockEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (fMovimiento != null ? !fMovimiento.equals(that.fMovimiento) : that.fMovimiento != null) return false;
        if (cSkuStock != null ? !cSkuStock.equals(that.cSkuStock) : that.cSkuStock != null) return false;
        if (iIdAlmacenOrigen != null ? !iIdAlmacenOrigen.equals(that.iIdAlmacenOrigen) : that.iIdAlmacenOrigen != null)
            return false;
        if (iIdAlmacenDestino != null ? !iIdAlmacenDestino.equals(that.iIdAlmacenDestino) : that.iIdAlmacenDestino != null)
            return false;
        if (iIdEmpleado != null ? !iIdEmpleado.equals(that.iIdEmpleado) : that.iIdEmpleado != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (fMovimiento != null ? fMovimiento.hashCode() : 0);
        result = 31 * result + (cSkuStock != null ? cSkuStock.hashCode() : 0);
        result = 31 * result + (iIdAlmacenOrigen != null ? iIdAlmacenOrigen.hashCode() : 0);
        result = 31 * result + (iIdAlmacenDestino != null ? iIdAlmacenDestino.hashCode() : 0);
        result = 31 * result + (iIdEmpleado != null ? iIdEmpleado.hashCode() : 0);
        return result;
    }
}
