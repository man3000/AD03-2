/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ad03.ad03;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Manuel
 */
public class mostrarProductosTienda extends javax.swing.JDialog {

    DefaultTableModel modeloTabla;
    HashMap<String, Integer> tiendasMap = new HashMap<>();
    String[] titulosColumnas = {"idProducto", "Nombre", "Descripción", "Precio"};
    ArrayList<ArrayList<String>> elementosModelo = new ArrayList<>();

    /**
     * Creates new form verTiendas
     */
    public mostrarProductosTienda(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        fijarModeloTiendas();

        setLocation(parent.getLocation());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jComboBoxTiendas = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Mostrar Productos de Tiendas");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setText("Tienda:");

        jComboBoxTiendas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxTiendasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 552, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(31, 31, 31)
                        .addComponent(jComboBoxTiendas, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jComboBoxTiendas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 354, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBoxTiendasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxTiendasActionPerformed
        // TODO add your handling code here:
        fijarModeloTabla();
    }//GEN-LAST:event_jComboBoxTiendasActionPerformed

    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> jComboBoxTiendas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

    public void fijarModeloTiendas() {
        String sql = "SELECT * FROM Tiendas ORDER BY nombre ASC";

        ArrayList<String> cadena = new ArrayList<>();

        Connection con = VentanaPrincipal.connectDatabase();

        try {
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);

            while (rs.next()) {
                this.tiendasMap.put(rs.getString("nombre") + " - " + rs.getString("ciudad"), rs.getInt("idTienda"));
                cadena.add(rs.getString("nombre") + " - " + rs.getString("ciudad"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(addTienda.class.getName()).log(Level.SEVERE, null, ex);
        }

        DefaultComboBoxModel model = new DefaultComboBoxModel(cadena.toArray());
        this.jComboBoxTiendas.setModel(model);

        if (jComboBoxTiendas.getItemCount() != 0) {
            fijarModeloTabla();
        }
    }

    void fijarModeloTabla() {

        if (jComboBoxTiendas.getItemCount() != 0) {
            String elem = (String) this.jComboBoxTiendas.getSelectedItem();

            int idTiendaMostrar = this.tiendasMap.get(elem);
            System.out.println(idTiendaMostrar);

            String sql = "SELECT * FROM Productos WHERE idProducto IN (SELECT Productos_idProducto from Tiendas_Productos where Tiendas_idTienda = "
                    + idTiendaMostrar + ") ORDER BY idProducto ASC";

            ArrayList<String> aux = new ArrayList<>();
            Float tempFloat;
            Connection con = VentanaPrincipal.connectDatabase();

            try {
                Statement statement = con.createStatement();
                ResultSet rs = statement.executeQuery(sql);

                while (rs.next()) {
                    aux.add(Integer.toString(rs.getInt("idProducto")));
                    aux.add(rs.getString("nombre"));
                    aux.add(rs.getString("descripcion"));
                    tempFloat = rs.getFloat("precio");

                    DecimalFormat df = new DecimalFormat("####.##");
                    aux.add(df.format(tempFloat));

                    elementosModelo.add(aux);
                    aux = new ArrayList<>();
                }

                String[][] array = new String[elementosModelo.size()][];
                for (int i = 0; i < elementosModelo.size(); i++) {
                    ArrayList<String> row = elementosModelo.get(i);
                    array[i] = row.toArray(new String[row.size()]);
                }

                for (int i = 0; i < array.length; i++) {
                    for (int j = 0; j < array[i].length; j++) {
                        array[i][j] = elementosModelo.get(i).get(j);
                        System.out.println(elementosModelo.get(i).get(j));
                    }
                }

                this.modeloTabla = new DefaultTableModel(array, this.titulosColumnas);

                this.jTable1.setModel(modeloTabla);

                this.elementosModelo = new ArrayList<>();

            } catch (SQLException ex) {
                VentanaPrincipal.desconnetDatabase(con);
                Logger.getLogger(addTienda.class.getName()).log(Level.SEVERE, null, ex);
            }

            VentanaPrincipal.desconnetDatabase(con);
        }

    }
}
