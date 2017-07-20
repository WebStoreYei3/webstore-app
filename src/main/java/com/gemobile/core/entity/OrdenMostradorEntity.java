package com.gemobile.core.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "orden_mostrador", schema = "webstore", catalog = "")
public class OrdenMostradorEntity {
    private Integer id;
    private Integer iIdAlmacen;
    private Integer iIdEmpleadoVenta;
    private Integer iIdEmpleadoCaja;
    private Timestamp fAlta;

    @Id
    @Column(name = "ID", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
    @Column(name = "I_ID_EMPLEADO_VENTA", nullable = false)
    public Integer getiIdEmpleadoVenta() {
        return iIdEmpleadoVenta;
    }

    public void setiIdEmpleadoVenta(Integer iIdEmpleadoVenta) {
        this.iIdEmpleadoVenta = iIdEmpleadoVenta;
    }

    @Basic
    @Column(name = "I_ID_EMPLEADO_CAJA", nullable = false)
    public Integer getiIdEmpleadoCaja() {
        return iIdEmpleadoCaja;
    }

    public void setiIdEmpleadoCaja(Integer iIdEmpleadoCaja) {
        this.iIdEmpleadoCaja = iIdEmpleadoCaja;
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
        if (iIdAlmacen != null ? !iIdAlmacen.equals(that.iIdAlmacen) : that.iIdAlmacen != null) return false;
        if (iIdEmpleadoVenta != null ? !iIdEmpleadoVenta.equals(that.iIdEmpleadoVenta) : that.iIdEmpleadoVenta != null)
            return false;
        if (iIdEmpleadoCaja != null ? !iIdEmpleadoCaja.equals(that.iIdEmpleadoCaja) : that.iIdEmpleadoCaja != null)
            return false;
        if (fAlta != null ? !fAlta.equals(that.fAlta) : that.fAlta != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (iIdAlmacen != null ? iIdAlmacen.hashCode() : 0);
        result = 31 * result + (iIdEmpleadoVenta != null ? iIdEmpleadoVenta.hashCode() : 0);
        result = 31 * result + (iIdEmpleadoCaja != null ? iIdEmpleadoCaja.hashCode() : 0);
        result = 31 * result + (fAlta != null ? fAlta.hashCode() : 0);
        return result;
    }
}
