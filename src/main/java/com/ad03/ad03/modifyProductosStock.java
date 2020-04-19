/*
 * GUI para eliminar productos
 */
package com.ad03.ad03;

import java.awt.Color;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Manuel
 */
public class modifyProductosStock extends javax.swing.JDialog {

    HashMap<String, Integer> tiendasMap = new HashMap<>();
    HashMap<String, Integer> productosMap = new HashMap<>();

    /**
     * Creates new form removeProducto
     *
     * @param parent
     * @param modal
     */
    public modifyProductosStock(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocation(parent.getLocation());
        fijarModeloTiendas();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jComboBoxTiendas = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jComboBoxProductos = new javax.swing.JComboBox<>();
        jButton_modificarStockProducto_cancelar = new javax.swing.JButton();
        jButton_modificarStockProducto_modificar = new javax.swing.JButton();
        jTextFieldStock = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Seleccione Tienda:");

        jComboBoxTiendas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxTiendasActionPerformed(evt);
            }
        });

        jLabel2.setText("Seleccione Producto:");

        jComboBoxProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxProductosActionPerformed(evt);
            }
        });

        jButton_modificarStockProducto_cancelar.setText("Cancelar");
        jButton_modificarStockProducto_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_modificarStockProducto_cancelarActionPerformed(evt);
            }
        });

        jButton_modificarStockProducto_modificar.setText("Modificar");
        jButton_modificarStockProducto_modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_modificarStockProducto_modificarActionPerformed(evt);
            }
        });

        jLabel3.setText("Stock:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton_modificarStockProducto_modificar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton_modificarStockProducto_cancelar))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addGap(214, 214, 214)
                            .addComponent(jTextFieldStock, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1)
                                .addComponent(jLabel2))
                            .addGap(42, 42, 42)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jComboBoxTiendas, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jComboBoxProductos, 0, 220, Short.MAX_VALUE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jComboBoxTiendas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jComboBoxProductos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_modificarStockProducto_cancelar)
                    .addComponent(jButton_modificarStockProducto_modificar))
                .addGap(26, 26, 26))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBoxTiendasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxTiendasActionPerformed
        // TODO add your handling code here:
        fijarModeloProductos();
    }//GEN-LAST:event_jComboBoxTiendasActionPerformed

    private void jButton_modificarStockProducto_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_modificarStockProducto_cancelarActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton_modificarStockProducto_cancelarActionPerformed

    private void jButton_modificarStockProducto_modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_modificarStockProducto_modificarActionPerformed
        // TODO add your handling code here:
        if (jComboBoxProductos.getItemCount() != 0 && jComboBoxTiendas.getItemCount() != 0) {
            String tien = (String) this.jComboBoxTiendas.getSelectedItem();
            String prod = (String) this.jComboBoxProductos.getSelectedItem();
            int idTienda_eliminar = this.tiendasMap.get(tien);
            int idProducto_eliminar = this.productosMap.get(prod);
            int stock;

            try {
                stock = Integer.parseInt(this.jTextFieldStock.getText());

                if (JOptionPane.showConfirmDialog(this, "¿Está seguro?", "Advertencia", JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION) {
                    VentanaPrincipal.insertarProductoTienda(idTienda_eliminar, idProducto_eliminar, stock);
                    this.dispose();
                }

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "El stock no está en el formato correcto", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "No existen tiendas o éstas no tienen productos", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton_modificarStockProducto_modificarActionPerformed

    private void jComboBoxProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxProductosActionPerformed
        fijarStockProducto();
    }//GEN-LAST:event_jComboBoxProductosActionPerformed

    /**
     * @param args the command line arguments
     */
    /**
     * Con este método establecemos los elementos que se muestran en el
     * desplegable
     */
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
            
            fijarModeloProductos();

        }

    }

    /**
     * Con este método establecemos los elementos que se muestran en el
     * desplegable
     */
    public void fijarModeloProductos() {

        if (jComboBoxTiendas.getItemCount() != 0) {
            
            String i = (String) this.jComboBoxTiendas.getSelectedItem();
            int idTienda = this.tiendasMap.get(i);
            
            String sql = "SELECT * FROM Productos WHERE idProducto IN (SELECT Productos_idProducto FROM Tiendas_Productos WHERE Tiendas_idTienda = ("
                    + idTienda + "))ORDER BY nombre ASC";
            
            ArrayList<String> cadena = new ArrayList<>();
            
            Connection con = VentanaPrincipal.connectDatabase();
            
            try {
                Statement statement = con.createStatement();
                ResultSet rs = statement.executeQuery(sql);
                
                while (rs.next()) {
                    this.productosMap.put(rs.getString("nombre"), rs.getInt("idProducto"));
                    cadena.add(rs.getString("nombre"));
                }
            } catch (SQLException ex) {
                Logger.getLogger(addTienda.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            DefaultComboBoxModel model = new DefaultComboBoxModel(cadena.toArray());
            this.jComboBoxProductos.setModel(model);
            
            if (jComboBoxProductos.getItemCount() == 0) {
                this.jTextFieldStock.setText("N/A");
            } else {
                fijarStockProducto();
            }
        }
    }

    public void fijarStockProducto() {

        if (jComboBoxProductos.getItemCount() != 0) {
            String tien = (String) this.jComboBoxTiendas.getSelectedItem();
            String prod = (String) this.jComboBoxProductos.getSelectedItem();
            
            int idTienda_modificar = this.tiendasMap.get(tien);
            int idProducto_modificar = this.productosMap.get(prod);
            String stock = "";
            String sql = "SELECT * FROM Tiendas_Productos WHERE Tiendas_idTienda = "
                    + idTienda_modificar + " AND Productos_idProducto = "
                    + idProducto_modificar + ";";
            
            Connection con = VentanaPrincipal.connectDatabase();
            
            try {
                Statement statement = con.createStatement();
                ResultSet rs = statement.executeQuery(sql);
                
                while (rs.next()) {
                    stock = Integer.toString(rs.getInt("stock"));
                }
            } catch (SQLException ex) {
                Logger.getLogger(addTienda.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            this.jTextFieldStock.setText(stock);
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_modificarStockProducto_cancelar;
    private javax.swing.JButton jButton_modificarStockProducto_modificar;
    private javax.swing.JComboBox<String> jComboBoxProductos;
    private javax.swing.JComboBox<String> jComboBoxTiendas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField jTextFieldStock;
    // End of variables declaration//GEN-END:variables

    public void deshabilitarCasillaStock() {
        this.jTextFieldStock.setEditable(false);
        this.jTextFieldStock.setBackground(Color.lightGray);
    }
}
