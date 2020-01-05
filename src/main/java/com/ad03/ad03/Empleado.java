/*
 * Clase Producto
 */
package com.ad03.ad03;

/**
 *
 * @author Manuel Alejandro Álvarez Pérez
 */
class Empleado {
    String nombre;
    String apellidos;

    Empleado(String nombre, String apellidos) {
        this.nombre = nombre;
        this.apellidos = apellidos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    
}
