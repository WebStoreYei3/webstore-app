package com.gemobile.core.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "empleado", schema = "webstore", catalog = "")
public class EmpleadoEntity {
    private Integer id;
    private String cCodigo;
    private String cNombre;
    private String cApepat;
    private String cApemat;
    private Collection<AlmacenEntity> almacenes;
    private RolEntity rol;

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
    @Column(name = "C_NOMBRE", nullable = false, length = 45)
    public String getcNombre() {
        return cNombre;
    }

    public void setcNombre(String cNombre) {
        this.cNombre = cNombre;
    }

    @Basic
    @Column(name = "C_APEPAT", nullable = false, length = 45)
    public String getcApepat() {
        return cApepat;
    }

    public void setcApepat(String cApepat) {
        this.cApepat = cApepat;
    }

    @Basic
    @Column(name = "C_APEMAT", nullable = true, length = 45)
    public String getcApemat() {
        return cApemat;
    }

    public void setcApemat(String cApemat) {
        this.cApemat = cApemat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EmpleadoEntity that = (EmpleadoEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (cCodigo != null ? !cCodigo.equals(that.cCodigo) : that.cCodigo != null) return false;
        if (cNombre != null ? !cNombre.equals(that.cNombre) : that.cNombre != null) return false;
        if (cApepat != null ? !cApepat.equals(that.cApepat) : that.cApepat != null) return false;
        if (cApemat != null ? !cApemat.equals(that.cApemat) : that.cApemat != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (cCodigo != null ? cCodigo.hashCode() : 0);
        result = 31 * result + (cNombre != null ? cNombre.hashCode() : 0);
        result = 31 * result + (cApepat != null ? cApepat.hashCode() : 0);
        result = 31 * result + (cApemat != null ? cApemat.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "empleadoResponsable")
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
}
