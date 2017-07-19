package com.gemobile.core.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "almacen", schema = "webstore", catalog = "")
public class AlmacenEntity {
    private Integer id;
    private String cDescripcion;
    private String cUbicacion;
    private String cTelefono1;
    private String cTelefono2;
    private EmpleadoEntity empleado;
    private Collection<StockEntity> stocks;

    @Id
    @Column(name = "ID", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "C_DESCRIPCION", nullable = false, length = 100)
    public String getcDescripcion() {
        return cDescripcion;
    }

    public void setcDescripcion(String cDescripcion) {
        this.cDescripcion = cDescripcion;
    }

    @Basic
    @Column(name = "C_UBICACION", nullable = false, length = 255)
    public String getcUbicacion() {
        return cUbicacion;
    }

    public void setcUbicacion(String cUbicacion) {
        this.cUbicacion = cUbicacion;
    }

    @Basic
    @Column(name = "C_TELEFONO1", nullable = false, length = 15)
    public String getcTelefono1() {
        return cTelefono1;
    }

    public void setcTelefono1(String cTelefono1) {
        this.cTelefono1 = cTelefono1;
    }

    @Basic
    @Column(name = "C_TELEFONO2", nullable = true, length = 15)
    public String getcTelefono2() {
        return cTelefono2;
    }

    public void setcTelefono2(String cTelefono2) {
        this.cTelefono2 = cTelefono2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AlmacenEntity that = (AlmacenEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (cDescripcion != null ? !cDescripcion.equals(that.cDescripcion) : that.cDescripcion != null) return false;
        if (cUbicacion != null ? !cUbicacion.equals(that.cUbicacion) : that.cUbicacion != null) return false;
        if (cTelefono1 != null ? !cTelefono1.equals(that.cTelefono1) : that.cTelefono1 != null) return false;
        if (cTelefono2 != null ? !cTelefono2.equals(that.cTelefono2) : that.cTelefono2 != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (cDescripcion != null ? cDescripcion.hashCode() : 0);
        result = 31 * result + (cUbicacion != null ? cUbicacion.hashCode() : 0);
        result = 31 * result + (cTelefono1 != null ? cTelefono1.hashCode() : 0);
        result = 31 * result + (cTelefono2 != null ? cTelefono2.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "I_ID_EMPL_RESPONSABLE", referencedColumnName = "ID", nullable = false)
    public EmpleadoEntity getEmpleado() {
        return empleado;
    }

    public void setEmpleado(EmpleadoEntity empleado) {
        this.empleado = empleado;
    }

    @OneToMany(mappedBy = "almacen")
    public Collection<StockEntity> getStocks() {
        return stocks;
    }

    public void setStocks(Collection<StockEntity> stocks) {
        this.stocks = stocks;
    }
}
