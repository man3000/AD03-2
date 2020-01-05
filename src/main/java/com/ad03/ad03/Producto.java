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
    String id;
    String descripcion;
    Float precio;
    int cantidad;

    Producto(String id, String descripcion, String precio, String cantidad) throws ErrorNumero{
        this.id = id;
        this.descripcion = descripcion;
        try {
            this.precio = Float.parseFloat(precio.replace(",", "."));
            this.cantidad = Integer.parseInt(cantidad);
        } catch (NumberFormatException e) {
            throw new ErrorNumero();
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
