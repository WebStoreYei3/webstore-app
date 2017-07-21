package com.webstore.core.entity;

import javax.persistence.*;

@Entity
@Table(name = "direcciones_entrega", schema = "webstore", catalog = "")
public class DireccionesEntregaEntity {
    private Integer id;
    private String cDireccion;
    private String cEntreCalles;
    private Integer iIdUsuario;

    @Id
    @Column(name = "ID", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "C_DIRECCION", nullable = false, length = 255)
    public String getcDireccion() {
        return cDireccion;
    }

    public void setcDireccion(String cDireccion) {
        this.cDireccion = cDireccion;
    }

    @Basic
    @Column(name = "C_ENTRE_CALLES", nullable = false, length = 255)
    public String getcEntreCalles() {
        return cEntreCalles;
    }

    public void setcEntreCalles(String cEntreCalles) {
        this.cEntreCalles = cEntreCalles;
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

        DireccionesEntregaEntity that = (DireccionesEntregaEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (cDireccion != null ? !cDireccion.equals(that.cDireccion) : that.cDireccion != null) return false;
        if (cEntreCalles != null ? !cEntreCalles.equals(that.cEntreCalles) : that.cEntreCalles != null) return false;
        if (iIdUsuario != null ? !iIdUsuario.equals(that.iIdUsuario) : that.iIdUsuario != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (cDireccion != null ? cDireccion.hashCode() : 0);
        result = 31 * result + (cEntreCalles != null ? cEntreCalles.hashCode() : 0);
        result = 31 * result + (iIdUsuario != null ? iIdUsuario.hashCode() : 0);
        return result;
    }
}
