package com.gemobile.core.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "subtipo_producto", schema = "webstore", catalog = "")
public class SubtipoProductoEntity {
    private Integer id;
    private String cCodigo;
    private String cDescripcion;
    private Collection<ProductoEntity> productos;
    private TipoProductoEntity tipoProducto;

    @Id
    @Column(name = "ID", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "C_CODIGO", nullable = false, length = 50)
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

        SubtipoProductoEntity that = (SubtipoProductoEntity) o;

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

    @OneToMany(mappedBy = "subtipoProducto")
    public Collection<ProductoEntity> getProductos() {
        return productos;
    }

    public void setProductos(Collection<ProductoEntity> productos) {
        this.productos = productos;
    }

    @ManyToOne
    @JoinColumn(name = "I_ID_TIPO_PRODUCTO", referencedColumnName = "ID", nullable = false)
    public TipoProductoEntity getTipoProducto() {
        return tipoProducto;
    }

    public void setTipoProducto(TipoProductoEntity tipoProducto) {
        this.tipoProducto = tipoProducto;
    }
}
