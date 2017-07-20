package com.gemobile.core.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "estado_orden", schema = "webstore", catalog = "")
public class EstadoOrdenEntity {
    private Integer id;
    private String cCodigo;
    private String cDescripcion;
    private Collection<OrdenEntregaEntity> ordenesEntrega;
    private Collection<OrdenEntregaInvitadoEntity> ordenesEntregaInvitado;

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

    @Basic
    @Column(name = "C_DESCRIPCION", nullable = false, length = 100)
    public String getcDescripcion() {
        return cDescripcion;
    }

    public void setcDescripcion(String cDescripcion) {
        this.cDescripcion = cDescripcion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EstadoOrdenEntity that = (EstadoOrdenEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (cCodigo != null ? !cCodigo.equals(that.cCodigo) : that.cCodigo != null) return false;
        if (cDescripcion != null ? !cDescripcion.equals(that.cDescripcion) : that.cDescripcion != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (cCodigo != null ? cCodigo.hashCode() : 0);
        result = 31 * result + (cDescripcion != null ? cDescripcion.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "estadoOrden")
    public Collection<OrdenEntregaEntity> getOrdenesEntrega() {
        return ordenesEntrega;
    }

    public void setOrdenesEntrega(Collection<OrdenEntregaEntity> ordenesEntrega) {
        this.ordenesEntrega = ordenesEntrega;
    }

    @OneToMany(mappedBy = "estadoOrden")
    public Collection<OrdenEntregaInvitadoEntity> getOrdenesEntregaInvitado() {
        return ordenesEntregaInvitado;
    }

    public void setOrdenesEntregaInvitado(Collection<OrdenEntregaInvitadoEntity> ordenesEntregaInvitado) {
        this.ordenesEntregaInvitado = ordenesEntregaInvitado;
    }
}
