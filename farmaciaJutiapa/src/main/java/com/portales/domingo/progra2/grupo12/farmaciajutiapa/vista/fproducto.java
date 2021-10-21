/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.portales.domingo.progra2.grupo12.farmaciajutiapa.vista;

import com.portales.domingo.progra2.grupo12.farmaciajutiapa.controlador.Util;
import com.portales.domingo.progra2.grupo12.farmaciajutiapa.dao.productoDAO;
import com.portales.domingo.progra2.grupo12.farmaciajutiapa.modelo.producto;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Edinson Ruano
 */
public class fproducto extends javax.swing.JFrame {
    private productoDAO pDAO = null;
    private producto miProducto=null;
    private DefaultTableModel modelo=null;
    private int fila = 0;

    /**
     * Creates new form fproducto
     */
    public fproducto() {
        initComponents();
        
        //Permite cerrar la BD cuando se cierra la ventana
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent event) {
                if(pDAO!=null)
                    pDAO.cierra();
                    dispose();
            }
        });

        llenaListado();
        limpiaCampos();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblid_producto = new javax.swing.JLabel();
        txtid_producto = new javax.swing.JTextField();
        lblnombre_producto = new javax.swing.JLabel();
        txtnombre_producto = new javax.swing.JTextField();
        lblid_tipo_producto = new javax.swing.JLabel();
        txtid_tipo_producto = new javax.swing.JTextField();
        lblid_marca_producto = new javax.swing.JLabel();
        txtidmarca_producto = new javax.swing.JTextField();
        btnAgregar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnNuevo = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaDatosProducto = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Mantenimiento de producto");

        lblid_producto.setText("Id producto");

        txtid_producto.setEditable(false);

        lblnombre_producto.setText("Nombre producto");

        lblid_tipo_producto.setText("Id tipo producto ");

        lblid_marca_producto.setText("Id marca producto");

        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        TablaDatosProducto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                " Id Producto", "Nombre Producto", "Id Tipo Producto", "Id Marca Producto"
            }
        ));
        TablaDatosProducto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaDatosProductoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TablaDatosProducto);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblid_producto)
                                    .addComponent(lblnombre_producto)
                                    .addComponent(lblid_tipo_producto)
                                    .addComponent(lblid_marca_producto))
                                .addGap(72, 72, 72)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtid_producto, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
                                    .addComponent(txtnombre_producto)
                                    .addComponent(txtid_tipo_producto)
                                    .addComponent(txtidmarca_producto)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnAgregar)
                                .addGap(18, 18, 18)
                                .addComponent(btnModificar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnEliminar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnNuevo))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 687, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblid_producto)
                    .addComponent(txtid_producto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblnombre_producto)
                    .addComponent(txtnombre_producto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtid_tipo_producto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblid_tipo_producto))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblid_marca_producto)
                    .addComponent(txtidmarca_producto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregar)
                    .addComponent(btnModificar)
                    .addComponent(btnEliminar)
                    .addComponent(btnNuevo))
                .addGap(27, 27, 27)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(206, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        agregar();
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        modificar();

    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        eliminar();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        limpiaCampos();
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void TablaDatosProductoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaDatosProductoMouseClicked
        try{
            fila = TablaDatosProducto.getSelectedRow();
            if(fila == -1){
                JOptionPane.showMessageDialog(null, "Producto no seleccionado");
            }else{
                String id=(String)TablaDatosProducto.getValueAt(fila,0).toString();
                String nombre=(String)TablaDatosProducto.getValueAt(fila,1);
                String idTipoProd=(String)TablaDatosProducto.getValueAt(fila,2).toString();
                String idMarcaProd=(String)TablaDatosProducto.getValueAt(fila,3).toString();                
                this.txtid_producto.setText(id);
                this.txtnombre_producto.setText(nombre);
                this.txtid_tipo_producto.setText(idTipoProd);
                this.txtidmarca_producto.setText(idMarcaProd);                
            }
        }catch(Exception e){
            Util.printException("fproducto.TablaDatosProductoMouseClicked", e);
        }  
    }//GEN-LAST:event_TablaDatosProductoMouseClicked

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
            java.util.logging.Logger.getLogger(fproducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(fproducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(fproducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(fproducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new fproducto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TablaDatosProducto;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblid_marca_producto;
    private javax.swing.JLabel lblid_producto;
    private javax.swing.JLabel lblid_tipo_producto;
    private javax.swing.JLabel lblnombre_producto;
    private javax.swing.JTextField txtid_producto;
    private javax.swing.JTextField txtid_tipo_producto;
    private javax.swing.JTextField txtidmarca_producto;
    private javax.swing.JTextField txtnombre_producto;
    // End of variables declaration//GEN-END:variables


    private void limpiaCampos() {
        try{
            this.txtid_producto.setText("");
            this.txtnombre_producto.setText("");
            this.txtid_tipo_producto.setText("");
            this.txtidmarca_producto.setText("");
        }catch(Exception e){
            Util.printException("fproducto.limpiaCampos", e);
        }                
    }
    
    
    public void limpiaTabla(){
        int filaRestante=0;
        try{        
            for(int i=0;i<=TablaDatosProducto.getRowCount();i++){
                modelo.removeRow(i);
                i = i - 1;
                filaRestante=modelo.getRowCount();
                if(filaRestante==0){
                    break;
                }
            }
        }catch(Exception e){
            Util.printException("fproducto.limpiaTabla", e);
        }        
    }

    private void llenaListado() {
        List<producto> listaProducto = null;
        
        try{
            pDAO = new productoDAO();
            listaProducto = new ArrayList<>();
            listaProducto = pDAO.seleccionaTodo();

            Object[]pObj=new Object[4];

            modelo = (DefaultTableModel)TablaDatosProducto.getModel();

            for(producto p:listaProducto){
                pObj[0] = p.getId_producto();
                pObj[1] = p.getNombre_producto();
                pObj[2] = p.getId_tipo_producto();
                pObj[3] = p.getId_marca_producto();
                modelo.addRow(pObj);
            }
            TablaDatosProducto.setModel(modelo);
        }catch(Exception e){
            Util.printException("fproducto.llenaListado", e);
        }
    }

    
    
    private void agregar(){
        
        try{
            miProducto = new producto(  Util.str2int( this.txtid_producto.getText()),
                                        this.txtnombre_producto.getText(),
                                        Util.str2int( this.txtid_tipo_producto.getText()),
                                        Util.str2int( this.txtidmarca_producto.getText()) );

            if ( pDAO.inserta(miProducto) ){
                JOptionPane.showMessageDialog(null, "Producto ingresado");
                limpiaTabla();
                limpiaCampos();
                llenaListado();
            }
                    
            
        }catch(Exception e){
            Util.printException("fproducto.agregar", e);
        }
    }
    
    private void modificar(){
        try{
            miProducto = new producto(  Util.str2int( this.txtid_producto.getText() ),
                                        this.txtnombre_producto.getText(),
                                        Util.str2int( this.txtid_tipo_producto.getText() ),
                                        Util.str2int( this.txtidmarca_producto.getText() ) );
            
            if ( pDAO.actualiza(miProducto) ){
                JOptionPane.showMessageDialog(null, "Producto actualizado");
                limpiaTabla();
                limpiaCampos();
                llenaListado();
            }

        }catch(Exception e){
            Util.printException("fproducto.modificar", e);
        }
    }
    
    

    private void eliminar(){
        try{        
            fila = TablaDatosProducto.getSelectedRow();
            if(fila == -1){
                JOptionPane.showMessageDialog(null, "Debe seleccionar fila");
            }else{
                if ( pDAO.elimina( Util.str2int((String)TablaDatosProducto.getValueAt(fila,0).toString()) ) ){
                    JOptionPane.showMessageDialog(null, "Producto eliminado");
                    limpiaTabla();
                    limpiaCampos();
                    llenaListado();
                }
            }
        }catch(Exception e){
            Util.printException("fproducto.eliminar", e);
        }        
    }    
 
}
