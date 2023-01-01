/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package igu;

import archivo.Archivo;
import colecciones.Productos;
import java.util.ArrayList;
import javax.swing.ComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.event.ListDataListener;

import logica.clases.Movimiento;
import logica.clases.Producto;
import java.lang.String;
import java.time.LocalDate;
import java.time.Month;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import logica.clases.Ingreso;

/**
 *
 * @author Win10
 */
public class FormularioIngreso extends javax.swing.JFrame {

    /**
     * Creates new form FormularioIngreso
     */
    private Productos productos;

    public FormularioIngreso() {
        initComponents();

        this.setLocationRelativeTo(null);

    }

    public FormularioIngreso(Movimiento mov) {
        initComponents();


        this.ano.setText(String.valueOf(mov.getFecha().getYear()));
        this.mes.setText(String.valueOf(mov.getFecha().getMonthValue()));
        this.dia.setText(String.valueOf(mov.getFecha().getDayOfMonth()));

        Ingreso ing=(Ingreso)mov;
        this.cant.setText(String.valueOf(ing.getCantidad()));
        this.setLocationRelativeTo(null);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton5 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        dia = new javax.swing.JTextField();
        mes = new javax.swing.JTextField();
        ano = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        pro = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        cant = new javax.swing.JTextField();
        enviar = new javax.swing.JToggleButton();
        salir = new javax.swing.JButton();

        jButton5.setBackground(new java.awt.Color(204, 204, 255));
        jButton5.setAlignmentY(0.0F);
        jButton5.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));

        dia.setText("dia");

        mes.setText("mes");
        mes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mesActionPerformed(evt);
            }
        });

        ano.setText("año");
        ano.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                anoActionPerformed(evt);
            }
        });

        jLabel1.setText("Fecha");

        jLabel2.setText("Producto: ");

        pro.setModel(getLista());

        jLabel3.setText("cantidad:");

        cant.setText("cantidad");

        enviar.setBackground(new java.awt.Color(204, 153, 255));
        enviar.setForeground(new java.awt.Color(255, 255, 255));
        enviar.setText("enviar");
        enviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enviarActionPerformed(evt);
            }
        });

        salir.setBackground(new java.awt.Color(153, 153, 255));
        salir.setIcon(new javax.swing.ImageIcon("C:\\Users\\Win10\\Documents\\NetBeansProjects\\proyectojulita\\src\\main\\java\\im\\cruz.png")); // NOI18N
        salir.setAlignmentY(0.0F);
        salir.setMargin(new java.awt.Insets(0, 0, 0, 0));
        salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dia, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(mes, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(5, 5, 5))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(70, 70, 70)))
                        .addComponent(ano, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(salir, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(enviar, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(pro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(37, 37, 37)
                                .addComponent(jLabel3)))
                        .addGap(18, 18, 18)
                        .addComponent(cant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 54, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(dia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(mes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(ano, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1))
                    .addComponent(salir, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(cant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                .addComponent(enviar)
                .addGap(24, 24, 24))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
       this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
       this.setVisible(false);
        PantallaPrincipalUsuario panta= new PantallaPrincipalUsuario();
        panta.setVisible(true);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirActionPerformed
       this.setVisible(false);
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        PantallaPrincipalUsuario panta= new PantallaPrincipalUsuario();
        panta.setVisible(true);
    }//GEN-LAST:event_salirActionPerformed

    private void enviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enviarActionPerformed
        
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        try
        {
            int di= Integer.valueOf(this.dia.getText());
            int me= Integer.valueOf(this.mes.getText());
            int an= Integer.valueOf(this.ano.getText());
            int can= Integer.valueOf(this.cant.getText());
            Producto pr = productos.buscar((String) this.pro.getSelectedItem());
            System.out.print(pr.getCantidadStok());
            if(can>0 &&  can<=pr.getCantidadStok())
            {
            this.setVisible(false);
            if(di>0 && di<32 && me>0 && me<13 && an>1990 && an<2024)
            {
                if(me==2&& an%4==0)
                {
                    if(di>28)
                    {
                       JOptionPane.showMessageDialog(null, "error con fecha");
                    }else
                    {
                        enviarIngreso(di,me,an,can, pr);
                    }
                    
                    
                }else if(me==2)
                {
                    if(di>28)
                        {
                            JOptionPane.showMessageDialog(null, "error con fecha");
                        }else
                        {
                            enviarIngreso(di,me,an,can,pr);
                        }
                }
                else
                {
                    enviarIngreso(di,me,an,can,pr);
                }
            }
            else
            {
                JOptionPane.showMessageDialog(null, "error con fecha");
            }
            }
             else
            {
                JOptionPane.showMessageDialog(null, "error con cantidad");
            }
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "error");
            System.out.println(e);
        }
    }//GEN-LAST:event_enviarActionPerformed


    public void enviarIngreso(int di,int me,int an, int can, Producto produc )
    {
        PantallaPrincipalUsuario panta = new PantallaPrincipalUsuario();

            Ingreso ing = new Ingreso(panta.cantMovimientos() + 1, LocalDate.of(an, me, di), can, produc);

            if (ing.getMonto() > 0) {

                panta.actualizarProductos(ing.getProducto().getName(),can);
                panta.actualizarMovimientos(ing);
                panta.actualizarCaja(panta.caja());


            } else {
                JOptionPane.showMessageDialog(null, "error con el monto");
            }
            panta.setVisible(true);
    }
    private void anoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_anoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_anoActionPerformed

    private void mesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mesActionPerformed

    public void salir()
    {
        this.setVisible(false);
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        libro l= new libro();
        l.setVisible(true);
        
    }
   public javax.swing.ComboBoxModel<java.lang.String> getLista()
    {
        PantallaPrincipalUsuario u= new PantallaPrincipalUsuario();
        productos= new Productos(u.cargarAppPP().listarProductos());


        
         try
         {
         String[] catalogo =new String[productos.getLista().size()];
         int i=0;
        
         for(Producto p: productos.getLista())
         {
             if(p.isEstado())
             {
                 System.out.println(productos.getLista().size());
                 catalogo[i]= p.getName();
                 
                 i++;
             }
         }
        JComboBox<String> n= new JComboBox<String>(catalogo);
       
        this.pro=n;
         }catch(Exception e)
         {
             System.out.print(e.getMessage());
         }
        return pro.getModel();
    }
    /**
     * @param args the command line arguments
     */
  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ano;
    private javax.swing.JTextField cant;
    private javax.swing.JTextField dia;
    private javax.swing.JToggleButton enviar;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField mes;
    private javax.swing.JComboBox<String> pro;
    private javax.swing.JButton salir;
    // End of variables declaration//GEN-END:variables


}
