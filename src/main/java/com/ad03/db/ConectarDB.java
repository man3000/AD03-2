/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ad03.db;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Manuel
 */
public class ConectarDB {
    
    private final String comprobarTablas = "SELECT * FROM SQLITE_MASTER WHERE NAME=TBL_NAME";
    
    private final String[] entidades = {"Clientes","Empleados","Productos","Provincias","Tiendas","Tiendas_Empleados","Tiendas_Productos"};

    private String dir;
    private String sep;
    private String  archivo_db;
    
    public ConectarDB() {
        
        this.dir = System.getProperty("user.dir");
        System.out.println("El archivo de trabajo es: "+dir);
        this.sep = File.separator;
        this.archivo_db = dir+sep+"src"+sep+"main"+sep+"java"+sep+"com"+sep+"ad03"+sep+"db"+sep+"database.db";
    }
    
    private Connection connect() {
        // SQLite connection string
        
        
        
        String url = "jdbc:sqlite:"+archivo_db;
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
    
    private boolean contieneEntidad(String entidad){
        for (String e : entidades) {
            if (e.equals(entidad)) {
                return true;                
            }
        }
        return false;
    }
    
    public boolean inicializarDB(){
        
        String sql = "SELECT * FROM SQLITE_MASTER WHERE NAME=TBL_NAME ORDER BY NAME ASC";
        
        File archivo = new File(archivo_db);
        if (!archivo.exists()) {
            return false;
        }
        
        
        try (Connection conn = this.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
            
            // loop through the result set
            while (rs.next()) {
                System.out.println("mirando la entidad "+rs.getString("name"));
                if (!contieneEntidad(rs.getString("name"))) {
                    return false;
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return true;
    }
}
