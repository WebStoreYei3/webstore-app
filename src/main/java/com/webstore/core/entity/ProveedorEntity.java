package com.webstore.core.entity;

import javax.persistence.*;

@Entity
@Table(name = "proveedor", schema = "webstore", catalog = "")
public class ProveedorEntity {
    private Integer id;
    private String cCodigo;
    private String cNombre;
    private String cContacto;
    private String cUbicacion;

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
    @Column(name = "C_NOMBRE", nullable = false, length = 100)
    public String getcNombre() {
        return cNombre;
    }

    public void setcNombre(String cNombre) {
        this.cNombre = cNombre;
    }

    @Basic
    @Column(name = "C_CONTACTO", nullable = false, length = 20)
    public String getcContacto() {
        return cContacto;
    }

    public void setcContacto(String cContacto) {
        this.cContacto = cContacto;
    }

    @Basic
    @Column(name = "C_UBICACION", nullable = true, length = 255)
    public String getcUbicacion() {
        return cUbicacion;
    }

    public void setcUbicacion(String cUbicacion) {
        this.cUbicacion = cUbicacion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProveedorEntity that = (ProveedorEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (cCodigo != null ? !cCodigo.equals(that.cCodigo) : that.cCodigo != null) return false;
        if (cNombre != null ? !cNombre.equals(that.cNombre) : that.cNombre != null) return false;
        if (cContacto != null ? !cContacto.equals(that.cContacto) : that.cContacto != null) return false;
        if (cUbicacion != null ? !cUbicacion.equals(that.cUbicacion) : that.cUbicacion != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (cCodigo != null ? cCodigo.hashCode() : 0);
        result = 31 * result + (cNombre != null ? cNombre.hashCode() : 0);
        result = 31 * result + (cContacto != null ? cContacto.hashCode() : 0);
        result = 31 * result + (cUbicacion != null ? cUbicacion.hashCode() : 0);
        return result;
    }
}
