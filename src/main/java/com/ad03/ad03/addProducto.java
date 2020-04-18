/*
 * GUI para añadir productos
 */
package com.ad03.ad03;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
/**
 *
 * @author Manuel Alejandro Álvarez Pérez
 */
public class addProducto extends javax.swing.JDialog {

    
    private HashMap<String,Integer> tiendasMap = new HashMap<>();
    
    /**
     * Creates new form addProducto
     * @param parent
     * @param modal
     */
    public addProducto(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        nombre_producto = new javax.swing.JTextField();
        precio = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        descripcion = new javax.swing.JTextArea();
        jButton_addProductoCancelar = new javax.swing.JButton();
        jButton_addProductoOK = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Nuevo Producto");

        jLabel2.setText("Nombre:");

        jLabel3.setText("Precio:");

        jLabel5.setText("Descripción:");

        nombre_producto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombre_productoActionPerformed(evt);
            }
        });

        descripcion.setColumns(20);
        descripcion.setRows(5);
        jScrollPane1.setViewportView(descripcion);

        jButton_addProductoCancelar.setText("Cancelar");
        jButton_addProductoCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_addProductoCancelarActionPerformed(evt);
            }
        });

        jButton_addProductoOK.setText("OK");
        jButton_addProductoOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_addProductoOKActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nombre_producto, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(precio, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(23, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton_addProductoOK)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton_addProductoCancelar)
                        .addGap(15, 15, 15))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nombre_producto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(precio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_addProductoCancelar)
                    .addComponent(jButton_addProductoOK))
                .addGap(15, 15, 15))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_addProductoOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_addProductoOKActionPerformed
        // TODO add your handling code here:
        //String i = (String)this.jComboBox1.getSelectedItem();
        
        
        if (this.nombre_producto.getText().equals("") || 
                this.precio.getText().equals("")  || 
                this.descripcion.getText().equals("")){
            JOptionPane.showMessageDialog(this, "Se deben rellenar todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
        
            try {
                Producto p = new Producto(this.nombre_producto.getText(),this.descripcion.getText(),this.precio.getText());
                
                String nom = this.nombre_producto.getText();
                String desc = this.descripcion.getText();
                Float prec = Float.parseFloat(this.precio.getText());
                VentanaPrincipal.insertarProducto(nom, desc, prec);
                
                this.dispose();
            } catch (ErrorNumero | NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "El ID, precio y/o la cantidad no están en el formato correcto", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_jButton_addProductoOKActionPerformed

    private void jButton_addProductoCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_addProductoCancelarActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton_addProductoCancelarActionPerformed

    private void nombre_productoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombre_productoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nombre_productoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(addProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(addProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(addProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(addProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                addProducto dialog = new addProducto(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
        
        
    }
    
    /**
     * Con este método establecemos los elementos que se muestran en el desplegable
     */
    /*public void fijarModelo(){
    String sql = "SELECT * FROM Tiendas ORDER BY nombre ASC";
    
    ArrayList<String> cadena = new ArrayList<>();
    
    Connection con = VentanaPrincipal.connectDatabase();
    
    try {
    Statement statement = con.createStatement();
    ResultSet rs = statement.executeQuery(sql);
    
    while (rs.next()) {
    this.tiendasMap.put(rs.getString("nombre")+ " - " + rs.getString("ciudad"), rs.getInt("idTienda"));
    cadena.add(rs.getString("nombre")+ " - " + rs.getString("ciudad"));
    }
    } catch (SQLException ex) {
    Logger.getLogger(addTienda.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    
    DefaultComboBoxModel model = new DefaultComboBoxModel(cadena.toArray());
    this.jComboBox1.setModel(model);
    }*/

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea descripcion;
    private javax.swing.JButton jButton_addProductoCancelar;
    private javax.swing.JButton jButton_addProductoOK;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nombre_producto;
    private javax.swing.JTextField precio;
    // End of variables declaration//GEN-END:variables
}
