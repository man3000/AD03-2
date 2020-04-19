/*
 * GUI para eliminar productos
 */
package com.ad03.ad03;

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
public class removeEmpleadosTiendas extends javax.swing.JDialog {

    HashMap<String, Integer> tiendasMap = new HashMap<>();
    HashMap<String, Integer> empleadosMap = new HashMap<>();

    /**
     * Creates new form removeProducto
     *
     * @param parent
     * @param modal
     */
    public removeEmpleadosTiendas(java.awt.Frame parent, boolean modal) {
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

        jLabel1 = new javax.swing.JLabel();
        jComboBoxTiendas = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jComboBoxEmpleados = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Eliminar Empleados de Tiendas");

        jLabel1.setText("Seleccione Tienda:");

        jComboBoxTiendas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxTiendasActionPerformed(evt);
            }
        });

        jLabel2.setText("Seleccione Empleado:");

        jComboBoxEmpleados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxEmpleadosActionPerformed(evt);
            }
        });

        jButton1.setText("Cancelar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Eliminar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(42, 42, 42)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jComboBoxTiendas, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBoxEmpleados, 0, 220, Short.MAX_VALUE))))
                .addGap(15, 15, 15))
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
                    .addComponent(jComboBoxEmpleados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addGap(15, 15, 15))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBoxTiendasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxTiendasActionPerformed
        fijarModeloEmpleados();

    }//GEN-LAST:event_jComboBoxTiendasActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        if (jComboBoxEmpleados.getItemCount() != 0 && jComboBoxTiendas.getItemCount() != 0) {
            String tien = (String) this.jComboBoxTiendas.getSelectedItem();
            String emp = (String) this.jComboBoxEmpleados.getSelectedItem();
            int idTienda = this.tiendasMap.get(tien);
            int idEmpleado = this.empleadosMap.get(emp);

            if (JOptionPane.showConfirmDialog(this, "¿Está seguro?", "Advertencia", JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION) {
                VentanaPrincipal.eliminarEmpleadoTienda(idTienda, idEmpleado);
                this.dispose();
            }
        } else {
            JOptionPane.showMessageDialog(this, "No existen tiendas o éstas no tienen empleados", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jComboBoxEmpleadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxEmpleadosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxEmpleadosActionPerformed

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
            java.util.logging.Logger.getLogger(removeEmpleadosTiendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(removeEmpleadosTiendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(removeEmpleadosTiendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(removeEmpleadosTiendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                removeEmpleadosTiendas dialog = new removeEmpleadosTiendas(new javax.swing.JFrame(), true);
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

        fijarModeloEmpleados();

    }

    /**
     * Con este método establecemos los elementos que se muestran en el
     * desplegable
     */
    public void fijarModeloEmpleados() {

        if (jComboBoxTiendas.getItemCount() != 0) {

            String i = (String) this.jComboBoxTiendas.getSelectedItem();
            int idTienda = this.tiendasMap.get(i);

            String sql = "SELECT * FROM Empleados WHERE idEmpleado IN (SELECT Empleados_idEmpleado FROM Tiendas_Empleados WHERE Tiendas_idTienda = ("
                    + idTienda + "))ORDER BY nombre ASC";

            ArrayList<String> cadena = new ArrayList<>();

            Connection con = VentanaPrincipal.connectDatabase();

            try {
                Statement statement = con.createStatement();
                ResultSet rs = statement.executeQuery(sql);

                while (rs.next()) {
                    this.empleadosMap.put(rs.getString("nombre") + " " + rs.getString("apellidos"), rs.getInt("idEmpleado"));
                    cadena.add(rs.getString("nombre") + " " + rs.getString("apellidos"));
                }
            } catch (SQLException ex) {
                Logger.getLogger(addTienda.class.getName()).log(Level.SEVERE, null, ex);
            }

            DefaultComboBoxModel model = new DefaultComboBoxModel(cadena.toArray());
            this.jComboBoxEmpleados.setModel(model);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBoxEmpleados;
    private javax.swing.JComboBox<String> jComboBoxTiendas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}