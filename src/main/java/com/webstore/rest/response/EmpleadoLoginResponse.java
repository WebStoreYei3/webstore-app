package com.webstore.rest.response;

/**
 * Created by oscar on 27/10/2016.
 */
public class EmpleadoLoginResponse {
    public String id;
    public String nombre;
    public String rol;
    public String correcto;

    public EmpleadoLoginResponse(String id, String nombre, String rol, String correcto) {
        this.id = id;
        this.nombre = nombre;
        this.rol = rol;
        this.correcto = correcto;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getCorrecto() {
        return correcto;
    }

    public void setCorrecto(String correcto) {
        this.correcto = correcto;
    }
}
