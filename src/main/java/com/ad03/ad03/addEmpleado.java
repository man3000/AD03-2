/*
 * GUI para añadir empleados
 */
package com.ad03.ad03;

import javax.swing.JOptionPane;

/**
 *
 * @author Manuel Alejandro Álvarez Pérez
 */
public class addEmpleado extends javax.swing.JDialog {

    /**
     * Creates new form addEmpleado
     *
     * @param parent
     * @param modal
     */
    public addEmpleado(java.awt.Frame parent, boolean modal) {
        super(parent, modal);

        initComponents();
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

        jLabel2 = new javax.swing.JLabel();
        nombre_empleado = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        apellidos_empleados = new javax.swing.JTextField();
        jButton_addEmpleado_Cancelar = new javax.swing.JButton();
        jButton_addEmpleado_OK = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Nuevo empleado");

        jLabel2.setText("Nombre:");

        jLabel3.setText("Apellidos:");

        jButton_addEmpleado_Cancelar.setText("Cancelar");
        jButton_addEmpleado_Cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_addEmpleado_CancelarActionPerformed(evt);
            }
        });

        jButton_addEmpleado_OK.setText("OK");
        jButton_addEmpleado_OK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_addEmpleado_OKActionPerformed(evt);
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
                        .addComponent(jButton_addEmpleado_OK)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton_addEmpleado_Cancelar))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(72, 72, 72)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(nombre_empleado, javax.swing.GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE)
                            .addComponent(apellidos_empleados))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(nombre_empleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(apellidos_empleados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_addEmpleado_Cancelar)
                    .addComponent(jButton_addEmpleado_OK))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_addEmpleado_OKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_addEmpleado_OKActionPerformed

        if (this.nombre_empleado.getText().equals("")
                || this.apellidos_empleados.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Se deben rellenar todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
        } else {

            try {

                String nom = this.nombre_empleado.getText();
                String apel = this.apellidos_empleados.getText();

                VentanaPrincipal.insertarEmpleado(nom, apel);

                this.dispose();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "El nombre y/o los apellidos no están en el formato correcto", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_jButton_addEmpleado_OKActionPerformed

    private void jButton_addEmpleado_CancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_addEmpleado_CancelarActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton_addEmpleado_CancelarActionPerformed

    /**
     * @param args the command line arguments
     */
    /**
     * Con este método establecemos los elementos que se muestran en el
     * desplegable
     */
    /*public void fijarModelo() {
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
    this.jComboBox1.setModel(model);
    }*/
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField apellidos_empleados;
    private javax.swing.JButton jButton_addEmpleado_Cancelar;
    private javax.swing.JButton jButton_addEmpleado_OK;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField nombre_empleado;
    // End of variables declaration//GEN-END:variables
}
