/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ad03.ad03;

/**
 *
 * @author Manuel
 */
public class Provincia {
    
    String id;
    String nome;

    public Provincia(String id, String nome) {
        this.id = id;
        this.nome = nome;
    }
    
    

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    
    
}