package com.gemobile.core.entity;

import javax.persistence.*;

/**
 * Created by Oscar Rodriguez on 14/07/2017.
 */
@Entity
@Table(name = "producto", schema = "webstore", catalog = "")
public class ProductoEntity {
    private Integer id;
    private String cCodigo;
    private String cNombre;
    private String cTipo;
    private String cDescripcion;

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
    @Column(name = "C_TIPO", nullable = false, length = 45)
    public String getcTipo() {
        return cTipo;
    }

    public void setcTipo(String cTipo) {
        this.cTipo = cTipo;
    }

    @Basic
    @Column(name = "C_DESCRIPCION", nullable = false, length = 255)
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

        ProductoEntity that = (ProductoEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (cCodigo != null ? !cCodigo.equals(that.cCodigo) : that.cCodigo != null) return false;
        if (cNombre != null ? !cNombre.equals(that.cNombre) : that.cNombre != null) return false;
        if (cTipo != null ? !cTipo.equals(that.cTipo) : that.cTipo != null) return false;
        if (cDescripcion != null ? !cDescripcion.equals(that.cDescripcion) : that.cDescripcion != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (cCodigo != null ? cCodigo.hashCode() : 0);
        result = 31 * result + (cNombre != null ? cNombre.hashCode() : 0);
        result = 31 * result + (cTipo != null ? cTipo.hashCode() : 0);
        result = 31 * result + (cDescripcion != null ? cDescripcion.hashCode() : 0);
        return result;
    }
}
