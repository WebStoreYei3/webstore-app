package com.webstore.core.entity;

import javax.persistence.*;

@Entity
@Table(name = "empleado", schema = "webstore", catalog = "")
public class EmpleadoEntity {
    private Integer id;
    private String cCodigo;
    private Integer iIdRol;
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
    @Column(name = "C_CODIGO", nullable = false, length = 45)
    public String getcCodigo() {
        return cCodigo;
    }

    public void setcCodigo(String cCodigo) {
        this.cCodigo = cCodigo;
    }

    @Basic
    @Column(name = "I_ID_ROL", nullable = false)
    public Integer getiIdRol() {
        return iIdRol;
    }

    public void setiIdRol(Integer iIdRol) {
        this.iIdRol = iIdRol;
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

        EmpleadoEntity that = (EmpleadoEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (cCodigo != null ? !cCodigo.equals(that.cCodigo) : that.cCodigo != null) return false;
        if (iIdRol != null ? !iIdRol.equals(that.iIdRol) : that.iIdRol != null) return false;
        if (iIdUsuario != null ? !iIdUsuario.equals(that.iIdUsuario) : that.iIdUsuario != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (cCodigo != null ? cCodigo.hashCode() : 0);
        result = 31 * result + (iIdRol != null ? iIdRol.hashCode() : 0);
        result = 31 * result + (iIdUsuario != null ? iIdUsuario.hashCode() : 0);
        return result;
    }
}
