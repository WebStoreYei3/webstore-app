package com.gemobile.core.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "movimiento_almacen_stock", schema = "webstore", catalog = "")
public class MovimientoAlmacenStockEntity {
    private Integer id;
    private Timestamp fMovimiento;
    private StockEntity stock;
    private AlmacenEntity almacenOrigen;
    private AlmacenEntity almacenDestino;
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
    @Column(name = "F_MOVIMIENTO", nullable = false)
    public Timestamp getfMovimiento() {
        return fMovimiento;
    }

    public void setfMovimiento(Timestamp fMovimiento) {
        this.fMovimiento = fMovimiento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MovimientoAlmacenStockEntity that = (MovimientoAlmacenStockEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (fMovimiento != null ? !fMovimiento.equals(that.fMovimiento) : that.fMovimiento != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (fMovimiento != null ? fMovimiento.hashCode() : 0);
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
    @JoinColumn(name = "I_ID_ALMACEN_ORIGEN", referencedColumnName = "ID", nullable = false)
    public AlmacenEntity getAlmacenOrigen() {
        return almacenOrigen;
    }

    public void setAlmacenOrigen(AlmacenEntity almacenOrigen) {
        this.almacenOrigen = almacenOrigen;
    }

    @ManyToOne
    @JoinColumn(name = "I_ID_ALMACEN_DESTINO", referencedColumnName = "ID", nullable = false)
    public AlmacenEntity getAlmacenDestino() {
        return almacenDestino;
    }

    public void setAlmacenDestino(AlmacenEntity almacenDestino) {
        this.almacenDestino = almacenDestino;
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
