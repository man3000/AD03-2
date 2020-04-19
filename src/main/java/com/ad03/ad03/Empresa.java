/*
 * Clase Empresa
 */
package com.ad03.ad03;

import java.util.ArrayList;

/**
 *
 * @author Manuel Alejandro Álvarez Pérez
 */
public class Empresa {

    ArrayList<Tienda> Tiendas = new ArrayList<>();
    ArrayList<Cliente> Clientes = new ArrayList<>();

    /**
     *
     */
    public Empresa() {
    }

    /**
     *
     * @param t
     * @param c
     */
    public Empresa(ArrayList<Tienda> t, ArrayList<Cliente> c) {
        this.Tiendas = t;
        this.Clientes = c;
    }

    /**
     *
     * @return
     */
    public ArrayList<Tienda> getTiendas() {
        return Tiendas;
    }

    /**
     *
     * @return
     */
    public ArrayList<Cliente> getClientes() {
        return Clientes;
    }

    @Override
    public String toString() {
        return "Empresa";
    }

}
