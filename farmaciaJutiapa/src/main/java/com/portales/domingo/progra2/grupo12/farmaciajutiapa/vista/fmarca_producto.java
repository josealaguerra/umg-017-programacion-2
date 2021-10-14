/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.portales.domingo.progra2.grupo12.farmaciajutiapa.vista;

import com.portales.domingo.progra2.grupo12.farmaciajutiapa.controlador.Util;
import com.portales.domingo.progra2.grupo12.farmaciajutiapa.dao.marca_productoDAO;
import com.portales.domingo.progra2.grupo12.farmaciajutiapa.modelo.marca_producto;
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
public class fmarca_producto extends javax.swing.JFrame {
   
    private marca_productoDAO mpDAO = null;
    private marca_producto miMarcaProducto=null;
    private DefaultTableModel modelo=null;
    private int fila = 0;

    /**
     * Creates new form fmarca_producto
     */
    public fmarca_producto() {
        initComponents();
        
        //Permite cerrar la BD cuando se cierra la ventana
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent event) {
                if(mpDAO!=null)
                    mpDAO.cierra();
                    dispose();
                    System.exit(0);
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
        lblid_marca_producto = new javax.swing.JLabel();
        txtid_marca_producto = new javax.swing.JTextField();
        lblnombre_marca_producto = new javax.swing.JLabel();
        txtnombre_marca_producto = new javax.swing.JTextField();
        btnAgregar2 = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnNuevo = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaDatosMarcaProducto = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Mantenimiento Marca Producto");

        lblid_marca_producto.setText("Id marca producto");

        txtid_marca_producto.setEditable(false);

        lblnombre_marca_producto.setText("Nombre marca producto");

        btnAgregar2.setText("Agregar");
        btnAgregar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregar2ActionPerformed(evt);
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

        TablaDatosMarcaProducto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id Marca Producto", "Nombre Marca Producto"
            }
        ));
        TablaDatosMarcaProducto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaDatosMarcaProductoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TablaDatosMarcaProducto);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblid_marca_producto)
                            .addComponent(lblnombre_marca_producto))
                        .addGap(119, 119, 119)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtid_marca_producto, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
                            .addComponent(txtnombre_marca_producto)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnAgregar2)
                        .addGap(18, 18, 18)
                        .addComponent(btnModificar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEliminar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnNuevo)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 625, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblid_marca_producto)
                    .addComponent(txtid_marca_producto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtnombre_marca_producto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblnombre_marca_producto))
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregar2)
                    .addComponent(btnModificar)
                    .addComponent(btnEliminar)
                    .addComponent(btnNuevo))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(190, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregar2ActionPerformed
        agregar();

    }//GEN-LAST:event_btnAgregar2ActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        modificar();

    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        eliminar();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        limpiaCampos();
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void TablaDatosMarcaProductoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaDatosMarcaProductoMouseClicked
        try{
            fila = TablaDatosMarcaProducto.getSelectedRow();
            if(fila == -1){
                JOptionPane.showMessageDialog(null, "Marca producto no seleccionado");
            }else{
                String id=(String)TablaDatosMarcaProducto.getValueAt(fila,0).toString();
                String nombre=(String)TablaDatosMarcaProducto.getValueAt(fila,1);
                this.txtid_marca_producto.setText(id);
                this.txtnombre_marca_producto.setText(nombre);
            }
        }catch(Exception e){
            Util.printException("fmarca_producto.TablaDatosMarcaProductoMouseClicked", e);
        }         
    }//GEN-LAST:event_TablaDatosMarcaProductoMouseClicked

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
            java.util.logging.Logger.getLogger(fmarca_producto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(fmarca_producto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(fmarca_producto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(fmarca_producto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new fmarca_producto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TablaDatosMarcaProducto;
    private javax.swing.JButton btnAgregar2;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblid_marca_producto;
    private javax.swing.JLabel lblnombre_marca_producto;
    private javax.swing.JTextField txtid_marca_producto;
    private javax.swing.JTextField txtnombre_marca_producto;
    // End of variables declaration//GEN-END:variables


    private void limpiaCampos() {
        try{
            this.txtid_marca_producto.setText("");
            this.txtnombre_marca_producto.setText("");
        }catch(Exception e){
            Util.printException("fmarca_producto.limpiaCampos", e);
        }                
    }
    
    
    public void limpiaTabla(){
        int filaRestante=0;
        try{        
            for(int i=0;i<=TablaDatosMarcaProducto.getRowCount();i++){
                modelo.removeRow(i);
                i = i - 1;
                filaRestante=modelo.getRowCount();
                if(filaRestante==0){
                    break;
                }
            }
        }catch(Exception e){
            Util.printException("fmarca_producto.limpiaTabla", e);
        }        
    }

    private void llenaListado() {
        List<marca_producto> listaMarcaProd = null;
        
        try{
            mpDAO = new marca_productoDAO();
            listaMarcaProd = new ArrayList<>();
            listaMarcaProd = mpDAO.seleccionaTodo();

            Object[]pObj=new Object[2];

            modelo = (DefaultTableModel)TablaDatosMarcaProducto.getModel();

            for(marca_producto p:listaMarcaProd){
                pObj[0] = p.getId_marca_producto();
                pObj[1] = p.getNombre_marca_producto();
                modelo.addRow(pObj);
            }
            TablaDatosMarcaProducto.setModel(modelo);
        }catch(Exception e){
            Util.printException("fmarca_producto.llenaListado", e);
        }
    }

    
    
    private void agregar(){
        
        try{
            miMarcaProducto = new marca_producto(   Util.str2int(this.txtid_marca_producto.getText()),
                                                    this.txtnombre_marca_producto.getText());
            
            if ( mpDAO.inserta( miMarcaProducto ) ){
                JOptionPane.showMessageDialog(null, "Marca producto ingresado");
                limpiaTabla();
                limpiaCampos();
                llenaListado();
            }
        }catch(Exception e){
            Util.printException("fmarca_producto.agregar", e);
        }
    }
    
    private void modificar(){
        try{
            miMarcaProducto = new marca_producto(   Util.str2int(this.txtid_marca_producto.getText()),
                                                    this.txtnombre_marca_producto.getText());
            
            if ( mpDAO.actualiza( miMarcaProducto ) ){
                JOptionPane.showMessageDialog(null, "Marca producto actualizado");
                limpiaTabla();
                limpiaCampos();
                llenaListado();
            }
        }catch(Exception e){
            Util.printException("fmarca_producto.modificar", e);
        }
    }
    
    

    private void eliminar(){
        try{        
            fila = TablaDatosMarcaProducto.getSelectedRow();
            if(fila == -1){
                JOptionPane.showMessageDialog(null, "Debe seleccionar fila");
            }else{
                if ( mpDAO.elimina( Util.str2int((String)TablaDatosMarcaProducto.getValueAt(fila,0).toString()) ) ){
                    JOptionPane.showMessageDialog(null, "Marca producto eliminado");
                    limpiaTabla();
                    limpiaCampos();
                    llenaListado();
                }
            }
        }catch(Exception e){
            Util.printException("fmarca_producto.eliminar", e);
        }        
    }    
   
}
