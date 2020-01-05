/*
 * Clase para controlar las excepciones de numeros mal formados
 */
package com.ad03.ad03;

/**
 *
 * @author Manuel Alejandro Álvarez Pérez
 */
public class ErrorNumero extends Exception{

    /**
     *
     */
    public ErrorNumero() {
    }

    /**
     *
     * @param message
     */
    public ErrorNumero(String message) {
        super(message);
    }
    
    
}
