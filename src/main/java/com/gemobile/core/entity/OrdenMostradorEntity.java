package com.gemobile.core.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

@Entity
@Table(name = "orden_mostrador", schema = "webstore", catalog = "")
public class OrdenMostradorEntity {
    private Integer id;
    private Timestamp fAlta;
    private AlmacenEntity almacen;
    private EmpleadoEntity empleadoVenta;
    private EmpleadoEntity empleadoCaja;
    private Collection<OrdenStockEntity> ordenStocks;

    @Id
    @Column(name = "ID", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "F_ALTA", nullable = false)
    public Timestamp getfAlta() {
        return fAlta;
    }

    public void setfAlta(Timestamp fAlta) {
        this.fAlta = fAlta;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrdenMostradorEntity that = (OrdenMostradorEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (fAlta != null ? !fAlta.equals(that.fAlta) : that.fAlta != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (fAlta != null ? fAlta.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "I_ID_ALMACEN", referencedColumnName = "ID", nullable = false)
    public AlmacenEntity getAlmacen() {
        return almacen;
    }

    public void setAlmacen(AlmacenEntity almacen) {
        this.almacen = almacen;
    }

    @ManyToOne
    @JoinColumn(name = "I_ID_EMPLEADO_VENTA", referencedColumnName = "ID", nullable = false)
    public EmpleadoEntity getEmpleadoVenta() {
        return empleadoVenta;
    }

    public void setEmpleadoVenta(EmpleadoEntity empleadoVenta) {
        this.empleadoVenta = empleadoVenta;
    }

    @ManyToOne
    @JoinColumn(name = "I_ID_EMPLEADO_CAJA", referencedColumnName = "ID", nullable = false)
    public EmpleadoEntity getEmpleadoCaja() {
        return empleadoCaja;
    }

    public void setEmpleadoCaja(EmpleadoEntity empleadoCaja) {
        this.empleadoCaja = empleadoCaja;
    }

    @OneToMany(mappedBy = "ordenMostrador")
    public Collection<OrdenStockEntity> getOrdenStocks() {
        return ordenStocks;
    }

    public void setOrdenStocks(Collection<OrdenStockEntity> ordenStocks) {
        this.ordenStocks = ordenStocks;
    }
}
