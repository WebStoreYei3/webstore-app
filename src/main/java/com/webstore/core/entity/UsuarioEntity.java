package com.webstore.core.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "usuario", schema = "webstore", catalog = "")
public class UsuarioEntity {
    private Integer id;
    private String cNombre;
    private String cApepat;
    private String cApemat;
    private String cMail;
    private String cTelefono;
    private String cCelular;
    private String cDireccion1;
    private String cDireccion2;
    private Timestamp fMiembroDesde;
    private String cEstado;
    private Integer iIdEstadoUsuario;
    private Timestamp fUltSesion;
    private String cUsuario;
    private String cContrasenia;
    private String cConfirmado;

    @Id
    @GeneratedValue
    @Column(name = "ID")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "C_NOMBRE")
    public String getcNombre() {
        return cNombre;
    }

    public void setcNombre(String cNombre) {
        this.cNombre = cNombre;
    }

    @Basic
    @Column(name = "C_APEPAT")
    public String getcApepat() {
        return cApepat;
    }

    public void setcApepat(String cApepat) {
        this.cApepat = cApepat;
    }

    @Basic
    @Column(name = "C_APEMAT")
    public String getcApemat() {
        return cApemat;
    }

    public void setcApemat(String cApemat) {
        this.cApemat = cApemat;
    }

    @Basic
    @Column(name = "C_MAIL")
    public String getcMail() {
        return cMail;
    }

    public void setcMail(String cMail) {
        this.cMail = cMail;
    }

    @Basic
    @Column(name = "C_TELEFONO")
    public String getcTelefono() {
        return cTelefono;
    }

    public void setcTelefono(String cTelefono) {
        this.cTelefono = cTelefono;
    }

    @Basic
    @Column(name = "C_CELULAR")
    public String getcCelular() {
        return cCelular;
    }

    public void setcCelular(String cCelular) {
        this.cCelular = cCelular;
    }

    @Basic
    @Column(name = "C_DIRECCION1")
    public String getcDireccion1() {
        return cDireccion1;
    }

    public void setcDireccion1(String cDireccion1) {
        this.cDireccion1 = cDireccion1;
    }

    @Basic
    @Column(name = "C_DIRECCION2")
    public String getcDireccion2() {
        return cDireccion2;
    }

    public void setcDireccion2(String cDireccion2) {
        this.cDireccion2 = cDireccion2;
    }

    @Basic
    @Column(name = "F_MIEMBRO_DESDE")
    public Timestamp getfMiembroDesde() {
        return fMiembroDesde;
    }

    public void setfMiembroDesde(Timestamp fMiembroDesde) {
        this.fMiembroDesde = fMiembroDesde;
    }

    @Basic
    @Column(name = "C_ESTADO")
    public String getcEstado() {
        return cEstado;
    }

    public void setcEstado(String cEstado) {
        this.cEstado = cEstado;
    }

    @Basic
    @Column(name = "I_ID_ESTADO_USUARIO")
    public Integer getiIdEstadoUsuario() {
        return iIdEstadoUsuario;
    }

    public void setiIdEstadoUsuario(Integer iIdEstadoUsuario) {
        this.iIdEstadoUsuario = iIdEstadoUsuario;
    }

    @Basic
    @Column(name = "F_ULT_SESION")
    public Timestamp getfUltSesion() {
        return fUltSesion;
    }

    public void setfUltSesion(Timestamp fUltSesion) {
        this.fUltSesion = fUltSesion;
    }

    @Basic
    @Column(name = "C_USUARIO")
    public String getcUsuario() {
        return cUsuario;
    }

    public void setcUsuario(String cUsuario) {
        this.cUsuario = cUsuario;
    }

    @Basic
    @Column(name = "C_CONTRASENIA")
    public String getcContrasenia() {
        return cContrasenia;
    }

    public void setcContrasenia(String cContrasenia) {
        this.cContrasenia = cContrasenia;
    }

    @Basic
    @Column(name = "C_CONFIRMADO")
    public String getcConfirmado() {
        return cConfirmado;
    }

    public void setcConfirmado(String cConfirmado) {
        this.cConfirmado = cConfirmado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UsuarioEntity that = (UsuarioEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (cNombre != null ? !cNombre.equals(that.cNombre) : that.cNombre != null) return false;
        if (cApepat != null ? !cApepat.equals(that.cApepat) : that.cApepat != null) return false;
        if (cApemat != null ? !cApemat.equals(that.cApemat) : that.cApemat != null) return false;
        if (cMail != null ? !cMail.equals(that.cMail) : that.cMail != null) return false;
        if (cTelefono != null ? !cTelefono.equals(that.cTelefono) : that.cTelefono != null) return false;
        if (cCelular != null ? !cCelular.equals(that.cCelular) : that.cCelular != null) return false;
        if (cDireccion1 != null ? !cDireccion1.equals(that.cDireccion1) : that.cDireccion1 != null) return false;
        if (cDireccion2 != null ? !cDireccion2.equals(that.cDireccion2) : that.cDireccion2 != null) return false;
        if (fMiembroDesde != null ? !fMiembroDesde.equals(that.fMiembroDesde) : that.fMiembroDesde != null)
            return false;
        if (cEstado != null ? !cEstado.equals(that.cEstado) : that.cEstado != null) return false;
        if (iIdEstadoUsuario != null ? !iIdEstadoUsuario.equals(that.iIdEstadoUsuario) : that.iIdEstadoUsuario != null)
            return false;
        if (fUltSesion != null ? !fUltSesion.equals(that.fUltSesion) : that.fUltSesion != null) return false;
        if (cUsuario != null ? !cUsuario.equals(that.cUsuario) : that.cUsuario != null) return false;
        if (cContrasenia != null ? !cContrasenia.equals(that.cContrasenia) : that.cContrasenia != null) return false;
        if (cConfirmado != null ? !cConfirmado.equals(that.cConfirmado) : that.cConfirmado != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (cNombre != null ? cNombre.hashCode() : 0);
        result = 31 * result + (cApepat != null ? cApepat.hashCode() : 0);
        result = 31 * result + (cApemat != null ? cApemat.hashCode() : 0);
        result = 31 * result + (cMail != null ? cMail.hashCode() : 0);
        result = 31 * result + (cTelefono != null ? cTelefono.hashCode() : 0);
        result = 31 * result + (cCelular != null ? cCelular.hashCode() : 0);
        result = 31 * result + (cDireccion1 != null ? cDireccion1.hashCode() : 0);
        result = 31 * result + (cDireccion2 != null ? cDireccion2.hashCode() : 0);
        result = 31 * result + (fMiembroDesde != null ? fMiembroDesde.hashCode() : 0);
        result = 31 * result + (cEstado != null ? cEstado.hashCode() : 0);
        result = 31 * result + (iIdEstadoUsuario != null ? iIdEstadoUsuario.hashCode() : 0);
        result = 31 * result + (fUltSesion != null ? fUltSesion.hashCode() : 0);
        result = 31 * result + (cUsuario != null ? cUsuario.hashCode() : 0);
        result = 31 * result + (cContrasenia != null ? cContrasenia.hashCode() : 0);
        result = 31 * result + (cConfirmado != null ? cConfirmado.hashCode() : 0);
        return result;
    }
}
