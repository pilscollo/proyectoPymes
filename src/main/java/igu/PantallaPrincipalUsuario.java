/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package igu;

import app.movimientos.appMov;
import app.productosProvedores.appPP;
import archivo.Archivo;
import colecciones.Libro;
import colecciones.Productos;
import colecciones.Provedores;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import excepciones.error;
import json.json;
import logica.clases.*;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Win10
 */
public class PantallaPrincipalUsuario extends javax.swing.JFrame {

    /**
     * Creates new form PantallaPrincipalUsuario
     */
    private appMov movimientos;
    private appPP stock;
    public PantallaPrincipalUsuario() {
        
        initComponents();
        this.movimientos = cargarAppMov();
        this.stock= cargarAppPP();

        this.setLocationRelativeTo(null);
    }
    public float caja()
    {
        return movimientos.monto();
    }
    public  void actualizarMovimientos(Movimiento mov)
    {
        
        movimientos.entrada(mov);
        json j= new json();
        Archivo.grabar(j.MovimientosarrayList(movimientos.listar()), "libro.bin");


    }


    public  void actualizarMovimientos()
    {
        json j= new json();
        Archivo.grabar(j.MovimientosarrayList(movimientos.listar()), "libro.bin");



    }
    public  void eliminarProducto(String nom)
    {
        System.out.println("holaaa");
        try {
            stock.eliminar(nom);
            actualizarProductos();
        } catch (error e) {
            e.printStackTrace();
        }
    }
    public Producto buscarProducto(String nom)
    {
        try {
            return stock.buscar(nom);
        } catch (error e) {
            e.printStackTrace();
        }
        return null;
    }
    public float montoCaja(int id)
    {

        float rta=0;
        if(movimientos.buscar(id)==null)
        {
            rta=-1;
        }else {rta= movimientos.buscar(id).getMonto();}
        return  rta;


    }
    public int tipo(int id)
    {
        int rta=0;
        if(movimientos.buscar(id)==null)
        {
            rta=-1;
        }else {rta= movimientos.buscar(id).getTipo();}
        return  rta;
    }
     public  void actualizarProductos()
    {

        json j= new json();
        Archivo.grabar(j.ProductoarrayList(stock.listarProductos()), "producto.bin");
        this.stock= cargarAppPP();

    }
    public  void actualizarProductos(String nombre, int cant)
    {

        try {
            stock.venta(nombre,cant);
        } catch (error e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,"error en la venta");
        }
        json j= new json();
        Archivo.grabar(j.ProductoarrayList(stock.listarProductos()), "producto.bin");
        this.stock= cargarAppPP();

    }
    public  void actualizarProductos(Producto pro)
    {
        try {
            stock.agregar(pro.getName(),pro.getProvedor().getNombre(),pro.getCantidadVentas(),pro.getCantidadStok(),pro.getCosto(),pro.getPorcentaje());
        } catch (error e) {
            JOptionPane.showMessageDialog(null,"error");
        }
        json j= new json();
        Archivo.grabar(j.ProductoarrayList(stock.listarProductos()), "producto.bin");
        this.stock= cargarAppPP();

    }
       public  void actualizarProvedores()
    {
        json j= new json();
        Archivo.grabar(j.ProvedoresarrayList(stock.listarProvedores()), "provedor.bin");
        this.stock= cargarAppPP();    
    }
    public  void actualizarProvedores(Provedoor pro)
    {
        try {
            stock.agregar(pro.getNombre());
        } catch (error e) {
            e.printStackTrace();
        }
        json j= new json();
        Archivo.grabar(j.ProvedoresarrayList(stock.listarProvedores()), "provedor.bin");
        this.stock= cargarAppPP();
    }
    public  void actualizarCaja(float monto)
    {
        json j= new json();
        Archivo.grabar(j.cajaAJson(new Caja(monto)), "caja.bin");
        this.movimientos = cargarAppMov();
    }
    public  appMov cargarAppMov()
    {
        String lib =Archivo.leer("libro.bin");
        String caj =Archivo.leer("caja.bin");
        appMov app=new appMov();
        
        
        json j= new json();
        JSONArray array;
        JSONObject obj;
        try {
            array = new JSONArray(lib);
            ArrayList<Movimiento> movimientos= new ArrayList<>();
            if(array.length()!= 0) {
                movimientos = j.arrayListMovimientos(array);
            }
            Libro l= new Libro(movimientos);
            Caja caja=null;
            if(caj.equals("[]"))
            {
                caja = new Caja(0);
            }else {
                caja = new Caja(new JSONArray(caj).getInt(0));
            }
            
            app= new appMov(caja,l);
            
            
        } catch (JSONException ex) {
            Logger.getLogger(PantallaPrincipalUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return app;
    }

    public Movimiento devolverMov(int id)
    {
        return movimientos.buscar(id);
    }
    public appPP cargarAppPP()
    {
        String prov= Archivo.leer("provedor.bin");
        String produc= Archivo.leer("producto.bin");
        
        appPP app= new appPP();
        json j= new json();
        JSONArray array1;
        JSONArray array2;
        try {
            array1 = new JSONArray(produc);
            Provedores prove = new Provedores();
            Productos prod = new Productos();
            if (array1.length() != 0) {
                prod = new Productos(j.arrayListProducto(array1));
            }

            array2 = new JSONArray(prov);

            if (array2.length() !=0) {
                prove = new Provedores(j.arrayListProvedores(array2));
            }
            app = new appPP(prove, prod);

            

        } catch (JSONException ex) {
            Logger.getLogger(PantallaPrincipalUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return app;
        
    }
    public void eliminarMovimiento(int id)
    {
        movimientos.eliminar(id);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        producto = new javax.swing.JButton();
        libro = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();

        jMenuItem1.setText("jMenuItem1");

        jMenu1.setText("jMenu1");

        jMenuItem2.setText("jMenuItem2");

        jLabel2.setText("jLabel2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        producto.setBackground(new java.awt.Color(55, 76, 71));
        producto.setForeground(new java.awt.Color(255, 255, 255));
        producto.setText("Productos");
        producto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productoActionPerformed(evt);
            }
        });
        getContentPane().add(producto, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, 110, 60));

        libro.setBackground(new java.awt.Color(55, 76, 71));
        libro.setForeground(new java.awt.Color(255, 255, 255));
        libro.setText("Libro Diario");
        libro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                libroActionPerformed(evt);
            }
        });
        getContentPane().add(libro, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 110, 60));

        jLabel5.setIcon(new javax.swing.ImageIcon("C:\\Users\\Win10\\Documents\\NetBeansProjects\\proyectojulita\\src\\main\\java\\im\\fondopantallausuario.png")); // NOI18N
        jLabel5.setText("jLabel5");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 140, 540));

        jButton5.setBackground(new java.awt.Color(105, 169, 115));
        jButton5.setIcon(new javax.swing.ImageIcon("C:\\Users\\Win10\\Documents\\NetBeansProjects\\proyectojulita\\src\\main\\java\\im\\cruz.png")); // NOI18N
        jButton5.setAlignmentY(0.0F);
        jButton5.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 10, 40, 40));

        jLabel6.setFont(new java.awt.Font("Yu Gothic UI Semibold", 2, 24)); // NOI18N
        jLabel6.setText("¡Bienvenido!");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 20, 220, 50));

        jLabel9.setText("Hola querido usuario...");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 120, -1, 20));

        jLabel11.setText("Este es una pequeña guia para el entendimiento de la aplica-");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 150, -1, 30));

        jLabel12.setText("ción");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 170, -1, 30));

        jLabel13.setText("Productos: gestion de stock y sugerencia de precio");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 230, -1, 30));

        jLabel14.setText("Libro Diario: registro de entradas y salidas (ventas y compras)");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 200, -1, 30));

        jLabel15.setText("el porcentaje de ganancias");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 290, -1, 30));

        jLabel16.setText("El precio del producto se calcula a partir del costo y ");
        getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 260, -1, 30));

        jLabel7.setBackground(new java.awt.Color(153, 255, 153));
        jLabel7.setIcon(new javax.swing.ImageIcon("C:\\Users\\Win10\\Documents\\NetBeansProjects\\proyectojulita\\src\\main\\java\\im\\fondopantallausuario.png")); // NOI18N
        jLabel7.setText("jLabel7");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 90, 420, 260));

        jLabel4.setIcon(new javax.swing.ImageIcon("C:\\Users\\Win10\\Documents\\NetBeansProjects\\proyectojulita\\src\\main\\java\\im\\fondopantallausuario (1).png")); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 710, 540));

        jLabel10.setText("Hola querido usuario... ");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 90, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public  int cantMovimientos()
    {
        return movimientos.listar().size();
    }



    private void libroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_libroActionPerformed
        // TODO add your handling code here:
        //pantalla libro
        this.movimientos = cargarAppMov();
        this.stock= cargarAppPP();
        libro li= new libro();
       this.setVisible(false);
        li.setVisible(true);
        javax.swing.JTable table= li.getTable();
        DefaultTableModel modelo= (DefaultTableModel)table.getModel();
       if(movimientos!=null)
        {
        javax.swing.JLabel aux= li.texto();
        
        aux.setText("Caja: " + String.valueOf(movimientos.monto()));
        ArrayList<Movimiento> mov= movimientos.listar();
        for(Movimiento m: mov)
        {
            if(m.getTipo()==1)
            {
               Ingreso i= (Ingreso)m;
               String[] st= {String.valueOf(i.getId()),i.getFecha().toString(),i.getDetalle(),"0",String.valueOf(i.getMonto())};
               modelo.addRow(st);
            }else
            {
               Egreso i= (Egreso)m;
               String[] st= {String.valueOf(i.getId()),i.getFecha().toString(),i.getDetalle(),String.valueOf(i.getMonto()),"0"};
               modelo.addRow(st);
            }
            
        }
        }
        li.setLocationRelativeTo(null);
        
    }//GEN-LAST:event_libroActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        System.exit(0);
        /*guardar productos y libro*/
    }//GEN-LAST:event_jButton5ActionPerformed

    private void productoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productoActionPerformed
        productosOfi li = new productosOfi();
        this.setVisible(false);
            this.stock = cargarAppPP();
            if (stock != null) {

                javax.swing.JTable table = li.tabla();
                DefaultTableModel model = (DefaultTableModel) table.getModel();
                ArrayList<Producto> productos = stock.productosMasVendidos();
                String[] st= new String[4];
                for (Producto p : productos) {
                    System.out.println(table.getColumnName(-1));
                    st = new String[]{ p.getName(),String.valueOf(p.getCantidadStok()), String.valueOf(p.getCantidadVentas()), String.valueOf(p.actualizarPrecio())};
                    model.addRow(st);
                    
                }
            }


            li.setVisible(true);

    }//GEN-LAST:event_productoActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JButton libro;
    private javax.swing.JButton producto;
    // End of variables declaration//GEN-END:variables
}
