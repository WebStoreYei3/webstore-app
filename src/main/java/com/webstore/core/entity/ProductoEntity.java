package com.webstore.core.entity;

import javax.annotation.Generated;
import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "producto", schema = "webstore")
public class ProductoEntity {
    private Integer id;
    private String cCodigo;
    private String cNombre;
    private Integer iIdTipo;
    private Integer iIdSubtipo;
    private String cDescripcion;
    private Integer iIdProveedor;
    private String cMarca;
    private String cUnidad;
    private BigDecimal dCosto;
    private BigDecimal dPrecioPublico;
    private BigDecimal dPrecioMayoreo;
    private BigDecimal dCantidadMayoreo;
    private String cImagenes;

    public ProductoEntity() {
    }

    public ProductoEntity(
                            String cCodigo,
                            String cNombre,
                            Integer iIdTipo,
                            Integer iIdSubtipo,
                            String cDescripcion,
                            Integer iIdProveedor,
                            String cMarca,
                            String cUnidad,
                            BigDecimal dCosto,
                            BigDecimal dPrecioPublico,
                            BigDecimal dPrecioMayoreo,
                            BigDecimal dCantidadMayoreo,
                            String cImagenes) {
        this.cCodigo = cCodigo;
        this.cNombre = cNombre;
        this.iIdTipo = iIdTipo;
        this.iIdSubtipo = iIdSubtipo;
        this.cDescripcion = cDescripcion;
        this.iIdProveedor = iIdProveedor;
        this.cMarca = cMarca;
        this.cUnidad = cUnidad;
        this.dCosto = dCosto;
        this.dPrecioPublico = dPrecioPublico;
        this.dPrecioMayoreo = dPrecioMayoreo;
        this.dCantidadMayoreo = dCantidadMayoreo;
        this.cImagenes = cImagenes;
    }

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
    @Column(name = "C_NOMBRE", nullable = false, length = 45)
    public String getcNombre() {
        return cNombre;
    }

    public void setcNombre(String cNombre) {
        this.cNombre = cNombre;
    }

    @Basic
    @Column(name = "I_ID_TIPO", nullable = false)
    public Integer getiIdTipo() {
        return iIdTipo;
    }

    public void setiIdTipo(Integer iIdTipo) {
        this.iIdTipo = iIdTipo;
    }

    @Basic
    @Column(name = "I_ID_SUBTIPO", nullable = true)
    public Integer getiIdSubtipo() {
        return iIdSubtipo;
    }

    public void setiIdSubtipo(Integer iIdSubtipo) {
        this.iIdSubtipo = iIdSubtipo;
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
    @Column(name = "I_ID_PROVEEDOR", nullable = false)
    public Integer getiIdProveedor() {
        return iIdProveedor;
    }

    public void setiIdProveedor(Integer iIdProveedor) {
        this.iIdProveedor = iIdProveedor;
    }

    @Basic
    @Column(name = "C_MARCA", nullable = false, length = 50)
    public String getcMarca() {
        return cMarca;
    }

    public void setcMarca(String cMarca) {
        this.cMarca = cMarca;
    }

    @Basic
    @Column(name = "C_UNIDAD", nullable = false, length = 45)
    public String getcUnidad() {
        return cUnidad;
    }

    public void setcUnidad(String cUnidad) {
        this.cUnidad = cUnidad;
    }

    @Basic
    @Column(name = "D_COSTO", nullable = false, precision = 2)
    public BigDecimal getdCosto() {
        return dCosto;
    }

    public void setdCosto(BigDecimal dCosto) {
        this.dCosto = dCosto;
    }

    @Basic
    @Column(name = "D_PRECIO_PUBLICO", nullable = false, precision = 2)
    public BigDecimal getdPrecioPublico() {
        return dPrecioPublico;
    }

    public void setdPrecioPublico(BigDecimal dPrecioPublico) {
        this.dPrecioPublico = dPrecioPublico;
    }

    @Basic
    @Column(name = "D_PRECIO_MAYOREO", nullable = true, precision = 2)
    public BigDecimal getdPrecioMayoreo() {
        return dPrecioMayoreo;
    }

    public void setdPrecioMayoreo(BigDecimal dPrecioMayoreo) {
        this.dPrecioMayoreo = dPrecioMayoreo;
    }

    @Basic
    @Column(name = "D_CANTIDAD_MAYOREO", nullable = true, precision = 3)
    public BigDecimal getdCantidadMayoreo() {
        return dCantidadMayoreo;
    }

    public void setdCantidadMayoreo(BigDecimal dCantidadMayoreo) {
        this.dCantidadMayoreo = dCantidadMayoreo;
    }

    @Basic
    @Column(name = "C_IMAGENES", nullable = true, length = -1)
    public String getcImagenes() {
        return cImagenes;
    }

    public void setcImagenes(String cImagenes) {
        this.cImagenes = cImagenes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductoEntity that = (ProductoEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (cCodigo != null ? !cCodigo.equals(that.cCodigo) : that.cCodigo != null) return false;
        if (cNombre != null ? !cNombre.equals(that.cNombre) : that.cNombre != null) return false;
        if (iIdTipo != null ? !iIdTipo.equals(that.iIdTipo) : that.iIdTipo != null) return false;
        if (iIdSubtipo != null ? !iIdSubtipo.equals(that.iIdSubtipo) : that.iIdSubtipo != null) return false;
        if (cDescripcion != null ? !cDescripcion.equals(that.cDescripcion) : that.cDescripcion != null) return false;
        if (iIdProveedor != null ? !iIdProveedor.equals(that.iIdProveedor) : that.iIdProveedor != null) return false;
        if (cMarca != null ? !cMarca.equals(that.cMarca) : that.cMarca != null) return false;
        if (cUnidad != null ? !cUnidad.equals(that.cUnidad) : that.cUnidad != null) return false;
        if (dCosto != null ? !dCosto.equals(that.dCosto) : that.dCosto != null) return false;
        if (dPrecioPublico != null ? !dPrecioPublico.equals(that.dPrecioPublico) : that.dPrecioPublico != null)
            return false;
        if (dPrecioMayoreo != null ? !dPrecioMayoreo.equals(that.dPrecioMayoreo) : that.dPrecioMayoreo != null)
            return false;
        if (dCantidadMayoreo != null ? !dCantidadMayoreo.equals(that.dCantidadMayoreo) : that.dCantidadMayoreo != null)
            return false;
        if (cImagenes != null ? !cImagenes.equals(that.cImagenes) : that.cImagenes != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (cCodigo != null ? cCodigo.hashCode() : 0);
        result = 31 * result + (cNombre != null ? cNombre.hashCode() : 0);
        result = 31 * result + (iIdTipo != null ? iIdTipo.hashCode() : 0);
        result = 31 * result + (iIdSubtipo != null ? iIdSubtipo.hashCode() : 0);
        result = 31 * result + (cDescripcion != null ? cDescripcion.hashCode() : 0);
        result = 31 * result + (iIdProveedor != null ? iIdProveedor.hashCode() : 0);
        result = 31 * result + (cMarca != null ? cMarca.hashCode() : 0);
        result = 31 * result + (cUnidad != null ? cUnidad.hashCode() : 0);
        result = 31 * result + (dCosto != null ? dCosto.hashCode() : 0);
        result = 31 * result + (dPrecioPublico != null ? dPrecioPublico.hashCode() : 0);
        result = 31 * result + (dPrecioMayoreo != null ? dPrecioMayoreo.hashCode() : 0);
        result = 31 * result + (dCantidadMayoreo != null ? dCantidadMayoreo.hashCode() : 0);
        result = 31 * result + (cImagenes != null ? cImagenes.hashCode() : 0);
        return result;
    }

    public boolean hasSubTipo() {
        return this.getiIdSubtipo()!=null;
    }
}
