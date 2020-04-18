/*
 * Clase Producto
 */
package com.ad03.ad03;

import java.util.ArrayList;

/**
 *
 * @author Manuel Alejandro Álvarez Pérez
 */
class Producto {
    String nombre;
    String descripcion;
    Float precio;

    Producto(String nombre, String descripcion, String precio) throws ErrorNumero{
        this.nombre = nombre;
        this.descripcion = descripcion;
        try {
            this.precio = Float.parseFloat(precio.replace(",", "."));
        } catch (NumberFormatException e) {
            throw new ErrorNumero();
        }
    }

    public String getId() {
        return nombre;
    }

    public void setId(String id) {
        this.nombre = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Float getPrecio() {
        return precio;
    }

    public void setPrecio(Float precio) {
        this.precio = precio;
    }

}
