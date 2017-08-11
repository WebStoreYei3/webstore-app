package com.webstore.core.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Timestamp;

@Entity
@Table(name = "opinion", schema = "webstore", catalog = "")
public class OpinionEntity {
    private Integer id;
    private Integer iIdUsuario;
    private Integer iIdProducto;
    private String cOpinion;
    private Integer iPuntuacion;
    private Timestamp fAlta;

    @Basic
    @Column(name = "ID", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "I_ID_USUARIO", nullable = false)
    public Integer getiIdUsuario() {
        return iIdUsuario;
    }

    public void setiIdUsuario(Integer iIdUsuario) {
        this.iIdUsuario = iIdUsuario;
    }

    @Basic
    @Column(name = "I_ID_PRODUCTO", nullable = false)
    public Integer getiIdProducto() {
        return iIdProducto;
    }

    public void setiIdProducto(Integer iIdProducto) {
        this.iIdProducto = iIdProducto;
    }

    @Basic
    @Column(name = "C_OPINION", nullable = false, length = -1)
    public String getcOpinion() {
        return cOpinion;
    }

    public void setcOpinion(String cOpinion) {
        this.cOpinion = cOpinion;
    }

    @Basic
    @Column(name = "I_PUNTUACION", nullable = false)
    public Integer getiPuntuacion() {
        return iPuntuacion;
    }

    public void setiPuntuacion(Integer iPuntuacion) {
        this.iPuntuacion = iPuntuacion;
    }

    @Basic
    @Column(name = "F_ALTA", nullable = true)
    public Timestamp getfAlta() {
        return fAlta;
    }

    public void setfAlta(Timestamp fAlta) {
        this.fAlta = fAlta;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OpinionEntity that = (OpinionEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (iIdUsuario != null ? !iIdUsuario.equals(that.iIdUsuario) : that.iIdUsuario != null) return false;
        if (iIdProducto != null ? !iIdProducto.equals(that.iIdProducto) : that.iIdProducto != null) return false;
        if (cOpinion != null ? !cOpinion.equals(that.cOpinion) : that.cOpinion != null) return false;
        if (iPuntuacion != null ? !iPuntuacion.equals(that.iPuntuacion) : that.iPuntuacion != null) return false;
        if (fAlta != null ? !fAlta.equals(that.fAlta) : that.fAlta != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (iIdUsuario != null ? iIdUsuario.hashCode() : 0);
        result = 31 * result + (iIdProducto != null ? iIdProducto.hashCode() : 0);
        result = 31 * result + (cOpinion != null ? cOpinion.hashCode() : 0);
        result = 31 * result + (iPuntuacion != null ? iPuntuacion.hashCode() : 0);
        result = 31 * result + (fAlta != null ? fAlta.hashCode() : 0);
        return result;
    }
}
