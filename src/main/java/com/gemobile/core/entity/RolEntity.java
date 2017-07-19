package com.gemobile.core.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "rol", schema = "webstore", catalog = "")
public class RolEntity {
    private Integer id;
    private String cCodigo;
    private String cDescripcion;
    private String estado;
    private Collection<EmpleadoEntity> empleados;

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
    @Column(name = "C_DESCRIPCION", nullable = false, length = 255)
    public String getcDescripcion() {
        return cDescripcion;
    }

    public void setcDescripcion(String cDescripcion) {
        this.cDescripcion = cDescripcion;
    }

    @Basic
    @Column(name = "ESTADO", nullable = false, length = 45)
    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RolEntity rolEntity = (RolEntity) o;

        if (id != null ? !id.equals(rolEntity.id) : rolEntity.id != null) return false;
        if (cCodigo != null ? !cCodigo.equals(rolEntity.cCodigo) : rolEntity.cCodigo != null) return false;
        if (cDescripcion != null ? !cDescripcion.equals(rolEntity.cDescripcion) : rolEntity.cDescripcion != null)
            return false;
        if (estado != null ? !estado.equals(rolEntity.estado) : rolEntity.estado != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (cCodigo != null ? cCodigo.hashCode() : 0);
        result = 31 * result + (cDescripcion != null ? cDescripcion.hashCode() : 0);
        result = 31 * result + (estado != null ? estado.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "rol")
    public Collection<EmpleadoEntity> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(Collection<EmpleadoEntity> empleados) {
        this.empleados = empleados;
    }
}