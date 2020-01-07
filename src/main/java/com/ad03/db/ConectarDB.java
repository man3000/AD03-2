/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ad03.db;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Manuel
 */
public class ConectarDB {

    private final String comprobarTablas = "SELECT * FROM SQLITE_MASTER WHERE NAME=TBL_NAME";

    private final String[] entidades = {"Clientes", "Empleados", "Productos", "Provincias", "Tiendas", "Tiendas_Empleados", "Tiendas_Productos"};

    private String dir;
    private String sep;
    private String ruta_db;
    private String url_db;
    private File archivo_db;

    public ConectarDB() {

        this.dir = System.getProperty("user.dir");
        this.sep = File.separator;
        this.ruta_db = dir + sep + "src" + sep + "main" + sep + "java" + sep + "com" + sep + "ad03" + sep + "db" + sep + "database.db";
        this.url_db = "jdbc:sqlite:" + archivo_db;
        this.archivo_db = new File(ruta_db);

        System.out.println("El archivo de trabajo es: " + dir);
    }

    public File getArchivo_db() {
        return archivo_db;
    }

    public String getRuta_db() {
        return ruta_db;
    }

    public String getUrl_db() {
        return url_db;
    }

    // Obtenemos el conector de la base de datos
    public Connection connectDatabase() {

        Connection connection = null;
        try {
            //Creamos a conexión a base de datos
            connection = DriverManager.getConnection(this.url_db);
            System.out.println("Conexión realizada con éxito");
            return connection;

        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return null;
        }
    }

    public void disconnectDatabase(Connection connection) {
        try {
            if (connection != null) {
                connection.close();
                System.out.println("Desconexión realizada con éxito");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    //Comprobar si las entidades estan el Array que tenemos
    private boolean contieneEntidad(String entidad) {
        for (String e : entidades) {
            //System.out.println(e);
            if (e.equals(entidad)) {
                return true;
            }
        }
        return false;
    }

    //Método para comprobar si la base de datos contiene todas las entidades que necesitamos
    public boolean comprobarDB() {

        String sql = "SELECT * FROM SQLITE_MASTER WHERE NAME=TBL_NAME ORDER BY NAME ASC";

        File archivo = this.archivo_db;
        if (!archivo.exists()) {
            return false;
        }
        Connection conn = this.connectDatabase();
        try {

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                System.out.println(rs.getString("name"));
                if (!contieneEntidad(rs.getString("name"))) {
                    conn.close();
                    return false;
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    //Inicializa el fichero de bases de datos, si no existe lo creamos
    public void inicializarDB() {
        try {
            File arch = this.archivo_db;
            if (arch.exists()) {
                arch.delete();
                System.out.println("Archivo eliminado");
            } else {
                arch.createNewFile();
                System.out.println("Archivo creado");
            }
        } catch (IOException ex) {
            Logger.getLogger(ConectarDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        /*
            Connection connection = connectDatabase();
            if (connection != null) {
                DatabaseMetaData meta = connection.getMetaData();
                System.out.println("La base de datos fue creada");

                String sql = "CREATE TABLE IF NOT EXISTS Provincias (\n"
                        + "  idProvincia INT NOT NULL,\n"
                        + "  nombre VARCHAR(45) NULL,\n"
                        + "  PRIMARY KEY (idProvincia));";

                Statement stmt = connection.createStatement();
                stmt.execute(sql);
                connection.close();
                System.out.println("La tabla fue creada");

            }

        } catch (IOException ex) {
            Logger.getLogger(ConectarDB.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ConectarDB.class.getName()).log(Level.SEVERE, null, ex);
        }
         */
    }
    
        
    public void insertarProvincias(Connection con) {
        try {
            String sql = "CREATE TABLE IF NOT EXISTS Provincias (\n"
                    + "  idProvincia INT NOT NULL,\n"
                    + "  nombre VARCHAR(45) NULL,\n"
                    + "  PRIMARY KEY (idProvincia));";

            Statement stmt = con.createStatement();
            stmt.execute(sql);
            System.out.println("Tabla provincias creada con éxito");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}
