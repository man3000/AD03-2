/*
 * GUI de la ventana principal
 */
package com.ad03.ad03;

import com.ad03.db.ConectarDB;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.spi.DirStateFactory;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

/**
 *
 * @author Manuel Alejandro Álvarez Pérez
 */
public class VentanaPrincipal extends javax.swing.JFrame {

    //Variables estáticas
    static Empresa Empresa = new Empresa();

    static Provincias provincias = new Provincias();

    static ArrayList<Tienda> Tiendas = new ArrayList<>();
    static ArrayList<Cliente> Clientes = new ArrayList<>();
    static String nombre, ciudad;
    static Gson gson = new Gson();
    static String json;

    static ArrayList<String> titularesRSS = new ArrayList<>();

    static String comprobarTablas = "SELECT * FROM SQLITE_MASTER WHERE NAME=TBL_NAME";

    static final String[] entidades = {"Clientes", "Empleados", "Productos", "Provincias", "Tiendas", "Tiendas_Empleados", "Tiendas_Productos"};

    static String dir = System.getProperty("user.dir");
    static String sep = File.separator;
    static String nombre_db = "database.db";
    static String ruta_db = dir + sep + "src" + sep + "main" + sep + "java" + sep + "com" + sep + "ad03" + sep + "db" + sep + nombre_db;
    static String url_db = "jdbc:sqlite:" + ruta_db;
    static File archivo_db = new File(ruta_db);
    static final File dataJson = new File(dir + sep + "src" + sep + "main" + sep + "java" + sep + "com" + sep + "ad03" + sep + "db" + sep + "provincias.json");

    /**
     * Constructor principal que posiciona la ventana en el centro de la
     * pantalla
     *
     */
    public VentanaPrincipal() {
        initComponents();
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        int x = d.width / 2;
        int y = d.height / 2;
        this.setLocation(x - this.getWidth() / 2, y - this.getHeight() / 2);
        System.out.println(dataJson.getAbsolutePath());

        validarArchivoJson(dataJson);

        Connection con = connectDatabase();
        crearTablas(con);
        rellenarProvincias(con);

        desconnetDatabase(con);

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
        jMenuBar1 = new javax.swing.JMenuBar();
        archivoMenu = new javax.swing.JMenu();
        importar = new javax.swing.JMenuItem();
        copiaSeguridad = new javax.swing.JMenuItem();
        jMenuItemVerDatos = new javax.swing.JMenuItem();
        salir = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem_EliminarTienda = new javax.swing.JMenuItem();
        jMenuItemVerTiendas = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem_EliminarProductoTiendas = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        jMenuItem12 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema de Gestión");
        setLocation(new java.awt.Point(500, 500));
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("American Typewriter", 0, 48)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Gestión");
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(153, 255, 153), null));

        archivoMenu.setText("Archivo");

        importar.setText("Importar");
        importar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                importarActionPerformed(evt);
            }
        });
        archivoMenu.add(importar);

        copiaSeguridad.setText("Crear copia de seguridad");
        copiaSeguridad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                copiaSeguridadActionPerformed(evt);
            }
        });
        archivoMenu.add(copiaSeguridad);

        jMenuItemVerDatos.setText("Visualizar los datos");
        jMenuItemVerDatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemVerDatosActionPerformed(evt);
            }
        });
        archivoMenu.add(jMenuItemVerDatos);

        salir.setText("Salir");
        salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirActionPerformed(evt);
            }
        });
        archivoMenu.add(salir);

        jMenuBar1.add(archivoMenu);

        jMenu2.setText("Tienda");

        jMenuItem3.setText("Añadir");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem3);

        jMenuItem_EliminarTienda.setText("Eliminar Tienda");
        jMenuItem_EliminarTienda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_EliminarTiendaActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem_EliminarTienda);

        jMenuItemVerTiendas.setText("Ver Tiendas");
        jMenuItemVerTiendas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemVerTiendasActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItemVerTiendas);

        jMenuBar1.add(jMenu2);

        jMenu5.setText("Producto");

        jMenuItem5.setText("Añadir Producto");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem5);

        jMenuItem2.setText("Modificar Stock Producto");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem2);

        jMenuItem1.setText("Eliminar Producto");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem1);

        jMenuItem_EliminarProductoTiendas.setText("Eliminar Productos de Tiendas");
        jMenuItem_EliminarProductoTiendas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_EliminarProductoTiendasActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem_EliminarProductoTiendas);

        jMenuBar1.add(jMenu5);

        jMenu3.setText("Empleado");

        jMenuItem7.setText("Añadir");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem7);

        jMenuItem8.setText("Eliminar");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem8);

        jMenuBar1.add(jMenu3);

        jMenu4.setText("Cliente      ");

        jMenuItem9.setText("Añadir");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem9);

        jMenuItem10.setText("Eliminar");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem10);

        jMenuBar1.add(jMenu4);

        jMenu6.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jMenu6.setText("Titulares RSS");
        jMenu6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jMenu6.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jMenu6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu6ActionPerformed(evt);
            }
        });

        jMenuItem12.setText("Ver titulares El País");
        jMenuItem12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem12ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem12);

        jMenuBar1.add(jMenu6);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(122, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(122, 122, 122))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(61, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem_EliminarProductoTiendasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_EliminarProductoTiendasActionPerformed
        // TODO add your handling code here:

        removeProductosTiendas removeproductosTiendas = new removeProductosTiendas(this, true);
        removeproductosTiendas.setLocation(this.getLocation());
        removeproductosTiendas.fijarModeloTiendas();
        removeproductosTiendas.fijarModeloProductos();
        removeproductosTiendas.setVisible(true);


    }//GEN-LAST:event_jMenuItem_EliminarProductoTiendasActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
        addTienda addtienda = new addTienda(this, true);
        addtienda.fijarModelo();
        addtienda.setLocation(this.getLocation());
        addtienda.setVisible(true);


    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        // TODO add your handling code here:

        addProducto addproducto = new addProducto(this, true);
        addproducto.fijarModelo();
        addproducto.setLocation(this.getLocation());
        addproducto.setVisible(true);


    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void copiaSeguridadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_copiaSeguridadActionPerformed
        try {
            // TODO add your handling code here:
            File file = new File(dataJson.getPath() + ".backup");
            DataInputStream input = new DataInputStream(new FileInputStream(dataJson));
            DataOutputStream output = new DataOutputStream(new FileOutputStream(file));
            int i;
            while ((i = input.read()) != -1) {
                output.write(i);
            }
            input.close();
            output.close();
            JOptionPane.showMessageDialog(this, "Copia de seguridad creada con éxito");

        } catch (FileNotFoundException ex) {
            Logger.getLogger(VentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(VentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_copiaSeguridadActionPerformed

    private void salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirActionPerformed
        // TODO add your handling code here:
        int option = JOptionPane.showConfirmDialog(this, "¿Confirma que desea salir de la aplicación? ", "Confirmación", JOptionPane.YES_NO_OPTION);
        if (option == JOptionPane.YES_OPTION) {
            System.exit(0);
        }

    }//GEN-LAST:event_salirActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        // TODO add your handling code here:

        addEmpleado addempleado = new addEmpleado(this, true);
        addempleado.fijarModelo();
        addempleado.setLocation(this.getLocation());
        addempleado.setVisible(true);


    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        // TODO add your handling code here:
        addCliente addcliente = new addCliente(this, true);
        addcliente.setLocation(this.getLocation());
        addcliente.setVisible(true);
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void importarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_importarActionPerformed
        // TODO add your handling code here:
        JFileChooser chooser = new JFileChooser();
        int returnVal = chooser.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            validarArchivoJson(chooser.getSelectedFile());
            actualizarJson();
        }
    }//GEN-LAST:event_importarActionPerformed

    private void jMenuItem_EliminarTiendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_EliminarTiendaActionPerformed
        // TODO add your handling code here:

        removeTienda removetienda = new removeTienda(this, true);
        removetienda.fijarModelo();
        removetienda.setLocation(this.getLocation());
        removetienda.setVisible(true);

    }//GEN-LAST:event_jMenuItem_EliminarTiendaActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        // TODO add your handling code here:
        if (hayTiendas()) {
            removeEmpleado removeempleado = new removeEmpleado(this, true);
            removeempleado.fijarModelo();
            removeempleado.fijarModeloEmpleado();
            removeempleado.setLocation(this.getLocation());
            removeempleado.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "No existen tiendas");
        }

    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
        // TODO add your handling code here:
        removeCliente removecliente = new removeCliente(this, true);
        removecliente.setLocation(this.getLocation());
        removecliente.fijarModelo();
        removecliente.setVisible(true);
    }//GEN-LAST:event_jMenuItem10ActionPerformed

    private void jMenu6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu6ActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_jMenu6ActionPerformed

    private void jMenuItem12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem12ActionPerformed
        // TODO add your handling code here:
        TitularesRSS titularesrss = new TitularesRSS(this, true);
        titularesrss.escribirTitulares(titularesRSS);
        titularesrss.setLocation(this.getLocation());
        titularesrss.setVisible(true);
    }//GEN-LAST:event_jMenuItem12ActionPerformed

    private void jMenuItemVerDatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemVerDatosActionPerformed
        // TODO add your handling code here:
        Datos datos = new Datos(this, true);
        datos.setLocation(this.getLocation());
        datos.setVisible(true);

    }//GEN-LAST:event_jMenuItemVerDatosActionPerformed

    private void jMenuItemVerTiendasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemVerTiendasActionPerformed
        // TODO add your handling code here:


    }//GEN-LAST:event_jMenuItemVerTiendasActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        removeProducto removeproducto = new removeProducto(this, true);
        removeproducto.setLocation(this.getLocation());
        //removeproducto.fijarModeloTiendas();
        removeproducto.fijarModeloProductos();
        removeproducto.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        modifyProductosStock modifyproductosStock = new modifyProductosStock(this, true);
        modifyproductosStock.setLocation(this.getLocation());
        modifyproductosStock.fijarModeloTiendas();
        modifyproductosStock.fijarModeloProductos();
        modifyproductosStock.fijarStockProducto();
        modifyproductosStock.setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    /**
     * Con este método analizamos el archivo "data.json" y comprobamos que el
     * archivo sea un archivo json válido para nuestra aplicación
     */
    private void validarArchivoJson(File f) {
        File file = f;
        if (file.exists()) {
            try {

                BufferedReader input = new BufferedReader(new FileReader(file));

                StringBuilder injson = new StringBuilder("");

                String s;
                while ((s = input.readLine()) != null) {
                    injson.append(s);
                }
                VentanaPrincipal.provincias = gson.fromJson(injson.toString(), Provincias.class);

                if (Objects.isNull(VentanaPrincipal.provincias)) {
                    VentanaPrincipal.provincias = new Provincias();
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            } catch (JsonSyntaxException e) {

                /*
                int option;

                if (f.equals(dataJson)) {
                    option = JOptionPane.showConfirmDialog(this, "El archivo json.data no es válido ¿desea borarlo y crear uno vacío?", "Error archivo", JOptionPane.YES_NO_OPTION);

                    if (option == JOptionPane.YES_OPTION) {
                        file.delete();
                        File file2 = new File("data.json");
                        try {
                            file2.createNewFile();
                        } catch (IOException ex) {
                            Logger.getLogger(VentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } else {
                        System.exit(0);
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "El archivo seleccionado no es válido ", "Error archivo", JOptionPane.OK_OPTION);
                }
                 */
                System.out.println("Error al procesar el archivo provincias.json");
            }
        } else {
            JOptionPane.showConfirmDialog(this, "No se encuentra el archivo provincias.json por lo que se creará uno vacío");
        }
    }

    /**
     * Con este método actualizamos el archivo de trabajo "data.json"
     */
    public static void actualizarJson() {

        json = gson.toJson(Empresa);

        try {
            FileWriter escritura = new FileWriter(dataJson);
            escritura.write(json);
            escritura.close();
        } catch (IOException ex) {
            System.out.println("Error en la ruta");
        }

    }

    /**
     * Comprobamos si exixten tiendas en la empresa
     */
    private boolean hayTiendas() {
        if (Empresa.Tiendas.isEmpty()) {
            return false;
        } else {
            return true;
        }
    }

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
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaPrincipal().setVisible(true);
            }
        });

        try {
            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

            URL url = new URL("http://ep00.epimg.net/rss/elpais/portada.xml");

            InputStream stream = url.openStream();

            SAXParser saxParser = saxParserFactory.newSAXParser();

            Handler handler = new Handler();

            saxParser.parse(new InputSource(stream), handler);

            titularesRSS = handler.getTitulares();

        } catch (ParserConfigurationException | SAXException | IOException ex) {
            titularesRSS.add("Error en el XML o no existe conexión a Internet");
        }

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu archivoMenu;
    private javax.swing.JMenuItem copiaSeguridad;
    private javax.swing.JMenuItem importar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JMenuItem jMenuItemVerDatos;
    private javax.swing.JMenuItem jMenuItemVerTiendas;
    private javax.swing.JMenuItem jMenuItem_EliminarProductoTiendas;
    private javax.swing.JMenuItem jMenuItem_EliminarTienda;
    private javax.swing.JMenuItem salir;
    // End of variables declaration//GEN-END:variables

    public static Connection connectDatabase() {
        Connection connection = null;
        try {
            //Creamos a conexión a base de datos
            connection = DriverManager.getConnection(url_db);
            System.out.println("Conexión realizada con éxito");
            return connection;

        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return null;
        }
    }

    /*
    Este método desconectase dunha base de datos en SQLLite a que se lle pasa a conexión
     */
    private static void desconnetDatabase(Connection connection) {
        try {
            if (connection != null) {
                connection.close();
                System.out.println("Desconexión realizada con éxito");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /*
    Método que crea a tabla persona nunha base de datos persoa  
     */
    private static void crearTablas(Connection con) {
        try {
            String sql = "CREATE TABLE IF NOT EXISTS Provincias (\n"
                    + "  idProvincia INT NOT NULL,\n"
                    + "  nombre VARCHAR(45) NULL,\n"
                    + "  PRIMARY KEY (idProvincia));";

            Statement stmt = con.createStatement();
            stmt.execute(sql);

            sql = "CREATE TABLE IF NOT EXISTS Tiendas (\n"
                    + "  idTienda INT NOT NULL,\n"
                    + "  nombre VARCHAR(45) NULL,\n"
                    + "  ciudad VARCHAR(45) NULL,\n"
                    + "  Provincias_idProvincia INT NOT NULL,\n"
                    + "  PRIMARY KEY (idTienda),\n"
                    + "  CONSTRAINT fk_Tiendas_Provincias\n"
                    + "    FOREIGN KEY (Provincias_idProvincia)\n"
                    + "    REFERENCES Provincias (idProvincia)\n"
                    + "    ON DELETE CASCADE\n"
                    + "    ON UPDATE CASCADE);";

            stmt = con.createStatement();
            stmt.execute(sql);

            sql = "CREATE TABLE IF NOT EXISTS Productos (\n"
                    + "  idProducto INT NOT NULL,\n"
                    + "  nombre VARCHAR(45) NULL,\n"
                    + "  descripcion VARCHAR(45) NULL,\n"
                    + "  precio DECIMAL NULL DEFAULT 0,\n"
                    + "  PRIMARY KEY (idProducto));";

            stmt = con.createStatement();
            stmt.execute(sql);

            sql = "CREATE TABLE IF NOT EXISTS Empleados (\n"
                    + "  idEmpleado INT NOT NULL,\n"
                    + "  nombre VARCHAR(45) NULL,\n"
                    + "  apellidos VARCHAR(45) NULL,\n"
                    + "  PRIMARY KEY (idEmpleado));";

            stmt = con.createStatement();
            stmt.execute(sql);

            sql = "CREATE TABLE IF NOT EXISTS Clientes (\n"
                    + "  idCliente INT NOT NULL,\n"
                    + "  nombre VARCHAR(45) NULL,\n"
                    + "  apellidos VARCHAR(45) NULL,\n"
                    + "  email VARCHAR(45) NULL,\n"
                    + "  PRIMARY KEY (idCliente));";

            stmt = con.createStatement();
            stmt.execute(sql);

            sql = "CREATE TABLE IF NOT EXISTS Tiendas_Productos (\n"
                    + "  Tiendas_idTienda INT NOT NULL,\n"
                    + "  Productos_idProducto INT NOT NULL,\n"
                    + "  stock INT NULL,\n"
                    + "  PRIMARY KEY (Tiendas_idTienda, Productos_idProducto),\n"
                    + "  CONSTRAINT fk_TIENDAS_has_PRODUCTOS_TIENDAS\n"
                    + "    FOREIGN KEY (Tiendas_idTienda)\n"
                    + "    REFERENCES Tiendas (idTienda)\n"
                    + "    ON DELETE CASCADE\n"
                    + "    ON UPDATE CASCADE,\n"
                    + "  CONSTRAINT fk_TIENDAS_has_PRODUCTOS_PRODUCTOS1\n"
                    + "    FOREIGN KEY (Productos_idProducto)\n"
                    + "    REFERENCES Productos (idProducto)\n"
                    + "    ON DELETE CASCADE\n"
                    + "    ON UPDATE CASCADE);";

            stmt = con.createStatement();
            stmt.execute(sql);

            sql = "CREATE TABLE IF NOT EXISTS Tiendas_Empleados (\n"
                    + "  Tiendas_idTienda INT NOT NULL,\n"
                    + "  Empleados_idEmpleado INT NOT NULL,\n"
                    + "  horas_semanales INT NULL,\n"
                    + "  PRIMARY KEY (Tiendas_idTienda, Empleados_idEmpleado),\n"
                    + "  CONSTRAINT fk_TIENDAS_has_EMPLEADOS_TIENDAS1\n"
                    + "    FOREIGN KEY (Tiendas_idTienda)\n"
                    + "    REFERENCES Tiendas (idTienda)\n"
                    + "    ON DELETE CASCADE\n"
                    + "    ON UPDATE CASCADE,\n"
                    + "  CONSTRAINT fk_TIENDAS_has_EMPLEADOS_EMPLEADOS1\n"
                    + "    FOREIGN KEY (Empleados_idEmpleado)\n"
                    + "    REFERENCES Empleados (idEmpleado)\n"
                    + "    ON DELETE CASCADE\n"
                    + "    ON UPDATE CASCADE);";

            stmt = con.createStatement();
            stmt.execute(sql);

            System.out.println("Táboa persona creada con éxito");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    private void rellenarProvincias(Connection con) {

        for (Provincia prov : provincias.getProvincias()) {
            insertarProvincia(con, Integer.parseInt(prov.getId()), prov.getNome());
        }

    }

    private void insertarProvincia(Connection con, int idProvincia, String nombre) {
        String sql = "INSERT INTO Provincias(idProvincia,nombre) VALUES(?,?)";

        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setInt(1, idProvincia);
            pstmt.setString(2, nombre);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            if (e.getMessage().contains("SQLITE_CONSTRAINT")) {
                System.out.println("El registro ya esiste");
            } else {
                System.out.println(e.getMessage());
            }
        }
    }

    static void insertarCliente(String nom, String apel, String mail) {
        Connection con = connectDatabase();

        String sql = "INSERT INTO Clientes(nombre,apellidos,email) VALUES(?,?,?)";

        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setString(1, nom);
            pstmt.setString(2, apel);
            pstmt.setString(3, mail);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            if (e.getMessage().contains("SQLITE_CONSTRAINT")) {
                System.out.println("El registro ya esiste");
            } else {
                System.out.println(e.getMessage());
            }
        }

        desconnetDatabase(con);
    }

    static int insertarTienda(String nom, String ciud, String idProvincia) {
        Connection con = connectDatabase();
        int idInsertado = 0;
        String sql = "INSERT INTO Tiendas(nombre,ciudad,Provincias_idProvincia) VALUES(?,?,?)";

        try (PreparedStatement pstmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setString(1, nom);
            pstmt.setString(2, ciud);
            pstmt.setString(3, idProvincia);

            pstmt.executeUpdate();
            ResultSet rs = pstmt.getGeneratedKeys();

            idInsertado = (int) rs.getLong(1);

        } catch (SQLException e) {
            if (e.getMessage().contains("SQLITE_CONSTRAINT")) {
                System.out.println("El registro ya esiste");

            } else {
                System.out.println(e.getMessage());
            }
        }

        desconnetDatabase(con);
        return idInsertado;
    }

    static int insertarProducto(String nom, String desc, Float prec, int idTien, int can) {

        Connection con = connectDatabase();
        int idInsertado = 0;
        String sql = "INSERT INTO Productos(nombre,descripcion,precio) VALUES(?,?,?)";
        String sqlTablaUnion = "INSERT INTO Tiendas_Productos(Tiendas_idTienda,Productos_idProducto,stock) VALUES(?,?,?)";

        try {

            PreparedStatement pstmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            PreparedStatement pstmtUnion = con.prepareStatement(sqlTablaUnion);

            pstmt.setString(1, nom);
            pstmt.setString(2, desc);
            System.out.println(prec);
            pstmt.setFloat(3, prec);

            pstmt.executeUpdate();
            ResultSet rs = pstmt.getGeneratedKeys();
            idInsertado = (int) rs.getLong(1);

            pstmtUnion.setInt(1, idTien);
            pstmtUnion.setInt(2, idInsertado);
            pstmtUnion.setInt(3, can);
            pstmtUnion.executeUpdate();

        } catch (SQLException e) {
            if (e.getMessage().contains("SQLITE_CONSTRAINT")) {
                System.out.println("El registro ya esiste");

            } else {
                System.out.println(e.getMessage());
            }
        }

        desconnetDatabase(con);
        return idInsertado;
    }

    static int insertarEmpleado(String nom, String apel, int horas, int idTien) {
        Connection con = connectDatabase();
        int idInsertado = 0;
        String sql = "INSERT INTO Empleados(nombre,apellidos) VALUES(?,?)";
        String sqlTablaUnion = "INSERT INTO Tiendas_Empleados(Tiendas_idTienda,Empleados_idEmpleado,horas_semanales) VALUES(?,?,?)";

        try {

            PreparedStatement pstmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            PreparedStatement pstmtUnion = con.prepareStatement(sqlTablaUnion);

            pstmt.setString(1, nom);
            pstmt.setString(2, apel);

            pstmt.executeUpdate();
            ResultSet rs = pstmt.getGeneratedKeys();
            idInsertado = (int) rs.getLong(1);

            pstmtUnion.setInt(1, idTien);
            pstmtUnion.setInt(2, idInsertado);
            pstmtUnion.setInt(3, horas);
            pstmtUnion.executeUpdate();

        } catch (SQLException e) {
            if (e.getMessage().contains("SQLITE_CONSTRAINT")) {
                System.out.println("El registro ya esiste");

            } else {
                System.out.println(e.getMessage());
            }
        }

        desconnetDatabase(con);
        return idInsertado;
    }

    static void eliminarTienda(Integer idTienda) {
        Connection con = connectDatabase();

        String sql = "DELETE FROM Tiendas WHERE idTienda = (?);";

        try {

            PreparedStatement pstmt = con.prepareStatement(sql);

            pstmt.setInt(1, idTienda);

            pstmt.executeUpdate();

        } catch (SQLException e) {

            System.out.println(e.getMessage());

        }

        desconnetDatabase(con);
    }

    static void eliminarProductoTienda(int idTienda_eliminar, int idProducto_eliminar) {
        Connection con = connectDatabase();

        String sql = "DELETE FROM Tiendas_Productos WHERE Tiendas_idTienda = ("
                + idTienda_eliminar + ") AND Productos_idProducto = ("
                + idProducto_eliminar + ");";

        try {

            PreparedStatement pstmt = con.prepareStatement(sql);

            pstmt.executeUpdate();

        } catch (SQLException e) {

            System.out.println(e.getMessage());

        }

        desconnetDatabase(con);
    }

    static void eliminarProducto(int idProducto_eliminar) {
        Connection con = connectDatabase();

        String sql = "DELETE FROM Productos WHERE idProducto = "
                + idProducto_eliminar + ";";

        try {

            PreparedStatement pstmt = con.prepareStatement(sql);

            pstmt.executeUpdate();

        } catch (SQLException e) {

            System.out.println(e.getMessage());

        }

        desconnetDatabase(con);
    }

    static void eliminarCliente(int idClienteEliminar) {
        Connection con = connectDatabase();

        String sql = "DELETE FROM Clientes WHERE idCliente = "
                + idClienteEliminar + ";";

        try {

            PreparedStatement pstmt = con.prepareStatement(sql);

            pstmt.executeUpdate();

        } catch (SQLException e) {

            System.out.println(e.getMessage());

        }

        desconnetDatabase(con);
    }

}
