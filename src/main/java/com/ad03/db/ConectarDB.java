/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ad03.db;

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

    public ConectarDB() {
    }
    
    private Connection connect() {
        // SQLite connection string
        String url = "jdbc:sqlite:C:\\Users\\Manuel\\Documents\\NetBeansProjects\\AD03\\src\\main\\java\\com\\ad03\\db\\database.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
    
    public void selectAll(){
        String sql = "SELECT * FROM TIENDA";
        
        try (Connection conn = this.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
            
            // loop through the result set
            while (rs.next()) {
                System.out.println(rs.getInt("id") +  "\t" + 
                                   rs.getString("nombre") + "\t" +
                                   rs.getString("provincia") + "\t" +
                                   rs.getString("ciudad"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
