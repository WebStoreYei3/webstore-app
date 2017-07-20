package com.gemobile.core.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

@Entity
@Table(name = "orden_entrega", schema = "webstore", catalog = "")
public class OrdenEntregaEntity {
    private Integer id;
    private String cDireccionEntrega;
    private Timestamp fDespacho;
    private Timestamp fEstimadaEntrega;
    private Timestamp fRealEntrega;
    private Timestamp fAltaOrden;
    private AlmacenEntity almacen;
    private EmpleadoEntity empleado;
    private EstadoOrdenEntity estadoOrden;
    private UsuarioEntity usuarioByIIdUsuario;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrdenEntregaEntity that = (OrdenEntregaEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (cDireccionEntrega != null ? !cDireccionEntrega.equals(that.cDireccionEntrega) : that.cDireccionEntrega != null)
            return false;
        if (fDespacho != null ? !fDespacho.equals(that.fDespacho) : that.fDespacho != null) return false;
        if (fEstimadaEntrega != null ? !fEstimadaEntrega.equals(that.fEstimadaEntrega) : that.fEstimadaEntrega != null)
            return false;
        if (fRealEntrega != null ? !fRealEntrega.equals(that.fRealEntrega) : that.fRealEntrega != null) return false;
        if (fAltaOrden != null ? !fAltaOrden.equals(that.fAltaOrden) : that.fAltaOrden != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (cDireccionEntrega != null ? cDireccionEntrega.hashCode() : 0);
        result = 31 * result + (fDespacho != null ? fDespacho.hashCode() : 0);
        result = 31 * result + (fEstimadaEntrega != null ? fEstimadaEntrega.hashCode() : 0);
        result = 31 * result + (fRealEntrega != null ? fRealEntrega.hashCode() : 0);
        result = 31 * result + (fAltaOrden != null ? fAltaOrden.hashCode() : 0);
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
    @JoinColumn(name = "I_ID_EMPLEADO_ENTREGA", referencedColumnName = "ID", nullable = false)
    public EmpleadoEntity getEmpleado() {
        return empleado;
    }

    public void setEmpleado(EmpleadoEntity empleado) {
        this.empleado = empleado;
    }

    @ManyToOne
    @JoinColumn(name = "I_ID_ESTADO_ORDEN", referencedColumnName = "ID", nullable = false)
    public EstadoOrdenEntity getEstadoOrden() {
        return estadoOrden;
    }

    public void setEstadoOrden(EstadoOrdenEntity estadoOrden) {
        this.estadoOrden = estadoOrden;
    }

    @ManyToOne
    @JoinColumn(name = "I_ID_USUARIO", referencedColumnName = "ID", nullable = false)
    public UsuarioEntity getUsuarioByIIdUsuario() {
        return usuarioByIIdUsuario;
    }

    public void setUsuarioByIIdUsuario(UsuarioEntity usuarioByIIdUsuario) {
        this.usuarioByIIdUsuario = usuarioByIIdUsuario;
    }

    @OneToMany(mappedBy = "ordenEntrega")
    public Collection<OrdenStockEntity> getOrdenStocks() {
        return ordenStocks;
    }

    public void setOrdenStocks(Collection<OrdenStockEntity> ordenStocks) {
        this.ordenStocks = ordenStocks;
    }
}
