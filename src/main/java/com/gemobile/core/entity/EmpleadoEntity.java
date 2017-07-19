package com.gemobile.core.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "empleado", schema = "webstore", catalog = "")
public class EmpleadoEntity {
    private Integer id;
    private String cCodigo;
    private Collection<AlmacenEntity> almacenes;
    private RolEntity rol;
    private UsuarioEntity usuario;

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

    @OneToMany(mappedBy = "empleado")
    public Collection<AlmacenEntity> getAlmacenes() {
        return almacenes;
    }

    public void setAlmacenes(Collection<AlmacenEntity> almacenes) {
        this.almacenes = almacenes;
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
}
