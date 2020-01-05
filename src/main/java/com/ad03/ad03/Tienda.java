/*
 * Clase Tienda
 */
package com.ad03.ad03;

import java.util.ArrayList;

/**
 *
 * @author Manuel Alejandro Álvarez Pérez
 */
public class Tienda {
    
    String nombre;
    String ciudad;
    ArrayList<Producto> Productos = new ArrayList<>();
    ArrayList<Empleado> Empleados = new ArrayList<>();

    Tienda(){}
    
    Tienda(String nombre, String ciudad) {
        this.nombre = nombre;
        this.ciudad = ciudad;
    }

    /**
     *
     * @return
     */
    public String getNombre() {
        return nombre;
    }

    /**
     *
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     *
     * @return
     */
    public ArrayList<Producto> getProductos() {
        return Productos;
    }

    /**
     *
     * @return
     */
    public ArrayList<Empleado> getEmpleados() {
        return Empleados;
    }

    /**
     *
     * @return
     */
    public String getCiudad() {
        return ciudad;
    }

    /**
     *
     * @param ciudad
     */
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
    
    /**
     *
     * @param p
     */
    public void addProducto(Producto p){
        this.Productos.add(p);
    }
    
    /**
     *
     * @param e
     */
    public void addEmpleado(Empleado e){
        this.Empleados.add(e);
    }
}
