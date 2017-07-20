package com.gemobile.core.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "empleado", schema = "webstore", catalog = "")
public class EmpleadoEntity {
    private Integer id;
    private String cCodigo;
    private Collection<AlmacenEntity> almacenesACargo;
    private RolEntity rol;
    private UsuarioEntity usuario;
    private Collection<MovimientoAlmacenStockEntity> movimientosAlmacenStock;
    private Collection<OperacionAbmStockEntity> operacionAbm;
    private Collection<OrdenEntregaEntity> ordenesEntrega;
    private Collection<OrdenEntregaInvitadoEntity> ordenesEntregaInvitado;
    private Collection<OrdenMostradorEntity> ordenesMostradorVenta;
    private Collection<OrdenMostradorEntity> ordenesMostradorCaja;

    @Id
    @Column(name = "ID", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "C_CODIGO", nullable = false, length = 45)
    public String getcCodigo() {
        return cCodigo;
    }

    public void setcCodigo(String cCodigo) {
        this.cCodigo = cCodigo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EmpleadoEntity that = (EmpleadoEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (cCodigo != null ? !cCodigo.equals(that.cCodigo) : that.cCodigo != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (cCodigo != null ? cCodigo.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "empleadoResponsable")
    public Collection<AlmacenEntity> getAlmacenesACargo() {
        return almacenesACargo;
    }

    public void setAlmacenesACargo(Collection<AlmacenEntity> almacenesACargo) {
        this.almacenesACargo = almacenesACargo;
    }

    @ManyToOne
    @JoinColumn(name = "I_ID_ROL", referencedColumnName = "ID", nullable = false)
    public RolEntity getRol() {
        return rol;
    }

    public void setRol(RolEntity rol) {
        this.rol = rol;
    }

    @OneToOne
    @JoinColumn(name = "I_ID_USUARIO", referencedColumnName = "ID", nullable = false)
    public UsuarioEntity getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioEntity usuario) {
        this.usuario = usuario;
    }

    @OneToMany(mappedBy = "empleado")
    public Collection<MovimientoAlmacenStockEntity> getMovimientosAlmacenStock() {
        return movimientosAlmacenStock;
    }

    public void setMovimientosAlmacenStock(Collection<MovimientoAlmacenStockEntity> movimientosAlmacenStock) {
        this.movimientosAlmacenStock = movimientosAlmacenStock;
    }

    @OneToMany(mappedBy = "empleado")
    public Collection<OperacionAbmStockEntity> getOperacionAbm() {
        return operacionAbm;
    }

    public void setOperacionAbm(Collection<OperacionAbmStockEntity> operacionAbm) {
        this.operacionAbm = operacionAbm;
    }

    @OneToMany(mappedBy = "empleado")
    public Collection<OrdenEntregaEntity> getOrdenesEntrega() {
        return ordenesEntrega;
    }

    public void setOrdenesEntrega(Collection<OrdenEntregaEntity> ordenesEntrega) {
        this.ordenesEntrega = ordenesEntrega;
    }

    @OneToMany(mappedBy = "empleadoEntrega")
    public Collection<OrdenEntregaInvitadoEntity> getOrdenesEntregaInvitado() {
        return ordenesEntregaInvitado;
    }

    public void setOrdenesEntregaInvitado(Collection<OrdenEntregaInvitadoEntity> ordenesEntregaInvitado) {
        this.ordenesEntregaInvitado = ordenesEntregaInvitado;
    }

    @OneToMany(mappedBy = "empleadoVenta")
    public Collection<OrdenMostradorEntity> getOrdenesMostradorVenta() {
        return ordenesMostradorVenta;
    }

    public void setOrdenesMostradorVenta(Collection<OrdenMostradorEntity> ordenesMostradorVenta) {
        this.ordenesMostradorVenta = ordenesMostradorVenta;
    }

    @OneToMany(mappedBy = "empleadoCaja")
    public Collection<OrdenMostradorEntity> getOrdenesMostradorCaja() {
        return ordenesMostradorCaja;
    }

    public void setOrdenesMostradorCaja(Collection<OrdenMostradorEntity> ordenesMostradorCaja) {
        this.ordenesMostradorCaja = ordenesMostradorCaja;
    }
}
