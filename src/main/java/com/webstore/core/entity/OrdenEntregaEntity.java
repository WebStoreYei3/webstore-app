package com.webstore.core.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "orden_entrega", schema = "webstore", catalog = "")
public class OrdenEntregaEntity {
    private Integer id;
    private Integer iIdAlmacen;
    private Integer iIdEmpleadoEntrega;
    private String cDireccionEntrega;
    private Timestamp fDespacho;
    private Timestamp fEstimadaEntrega;
    private Timestamp fRealEntrega;
    private Timestamp fAltaOrden;
    private Integer iIdEstadoOrden;
    private Integer iIdUsuario;

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
    @Column(name = "I_ID_ALMACEN", nullable = false)
    public Integer getiIdAlmacen() {
        return iIdAlmacen;
    }

    public void setiIdAlmacen(Integer iIdAlmacen) {
        this.iIdAlmacen = iIdAlmacen;
    }

    @Basic
    @Column(name = "I_ID_EMPLEADO_ENTREGA", nullable = false)
    public Integer getiIdEmpleadoEntrega() {
        return iIdEmpleadoEntrega;
    }

    public void setiIdEmpleadoEntrega(Integer iIdEmpleadoEntrega) {
        this.iIdEmpleadoEntrega = iIdEmpleadoEntrega;
    }

    @Basic
    @Column(name = "C_DIRECCION_ENTREGA", nullable = false, length = 255)
    public String getcDireccionEntrega() {
        return cDireccionEntrega;
    }

    public void setcDireccionEntrega(String cDireccionEntrega) {
        this.cDireccionEntrega = cDireccionEntrega;
    }

    @Basic
    @Column(name = "F_DESPACHO", nullable = false)
    public Timestamp getfDespacho() {
        return fDespacho;
    }

    public void setfDespacho(Timestamp fDespacho) {
        this.fDespacho = fDespacho;
    }

    @Basic
    @Column(name = "F_ESTIMADA_ENTREGA", nullable = false)
    public Timestamp getfEstimadaEntrega() {
        return fEstimadaEntrega;
    }

    public void setfEstimadaEntrega(Timestamp fEstimadaEntrega) {
        this.fEstimadaEntrega = fEstimadaEntrega;
    }

    @Basic
    @Column(name = "F_REAL_ENTREGA", nullable = false)
    public Timestamp getfRealEntrega() {
        return fRealEntrega;
    }

    public void setfRealEntrega(Timestamp fRealEntrega) {
        this.fRealEntrega = fRealEntrega;
    }

    @Basic
    @Column(name = "F_ALTA_ORDEN", nullable = false)
    public Timestamp getfAltaOrden() {
        return fAltaOrden;
    }

    public void setfAltaOrden(Timestamp fAltaOrden) {
        this.fAltaOrden = fAltaOrden;
    }

    @Basic
    @Column(name = "I_ID_ESTADO_ORDEN", nullable = false)
    public Integer getiIdEstadoOrden() {
        return iIdEstadoOrden;
    }

    public void setiIdEstadoOrden(Integer iIdEstadoOrden) {
        this.iIdEstadoOrden = iIdEstadoOrden;
    }

    @Basic
    @Column(name = "I_ID_USUARIO", nullable = false)
    public Integer getiIdUsuario() {
        return iIdUsuario;
    }

    public void setiIdUsuario(Integer iIdUsuario) {
        this.iIdUsuario = iIdUsuario;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrdenEntregaEntity that = (OrdenEntregaEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (iIdAlmacen != null ? !iIdAlmacen.equals(that.iIdAlmacen) : that.iIdAlmacen != null) return false;
        if (iIdEmpleadoEntrega != null ? !iIdEmpleadoEntrega.equals(that.iIdEmpleadoEntrega) : that.iIdEmpleadoEntrega != null)
            return false;
        if (cDireccionEntrega != null ? !cDireccionEntrega.equals(that.cDireccionEntrega) : that.cDireccionEntrega != null)
            return false;
        if (fDespacho != null ? !fDespacho.equals(that.fDespacho) : that.fDespacho != null) return false;
        if (fEstimadaEntrega != null ? !fEstimadaEntrega.equals(that.fEstimadaEntrega) : that.fEstimadaEntrega != null)
            return false;
        if (fRealEntrega != null ? !fRealEntrega.equals(that.fRealEntrega) : that.fRealEntrega != null) return false;
        if (fAltaOrden != null ? !fAltaOrden.equals(that.fAltaOrden) : that.fAltaOrden != null) return false;
        if (iIdEstadoOrden != null ? !iIdEstadoOrden.equals(that.iIdEstadoOrden) : that.iIdEstadoOrden != null)
            return false;
        if (iIdUsuario != null ? !iIdUsuario.equals(that.iIdUsuario) : that.iIdUsuario != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (iIdAlmacen != null ? iIdAlmacen.hashCode() : 0);
        result = 31 * result + (iIdEmpleadoEntrega != null ? iIdEmpleadoEntrega.hashCode() : 0);
        result = 31 * result + (cDireccionEntrega != null ? cDireccionEntrega.hashCode() : 0);
        result = 31 * result + (fDespacho != null ? fDespacho.hashCode() : 0);
        result = 31 * result + (fEstimadaEntrega != null ? fEstimadaEntrega.hashCode() : 0);
        result = 31 * result + (fRealEntrega != null ? fRealEntrega.hashCode() : 0);
        result = 31 * result + (fAltaOrden != null ? fAltaOrden.hashCode() : 0);
        result = 31 * result + (iIdEstadoOrden != null ? iIdEstadoOrden.hashCode() : 0);
        result = 31 * result + (iIdUsuario != null ? iIdUsuario.hashCode() : 0);
        return result;
    }
}
