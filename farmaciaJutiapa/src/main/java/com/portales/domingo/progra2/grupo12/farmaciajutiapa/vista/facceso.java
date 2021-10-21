/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.portales.domingo.progra2.grupo12.farmaciajutiapa.vista;

import com.portales.domingo.progra2.grupo12.farmaciajutiapa.controlador.Util;
import com.portales.domingo.progra2.grupo12.farmaciajutiapa.dao.accesoDAO;
import com.portales.domingo.progra2.grupo12.farmaciajutiapa.modelo.acceso;
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
public class facceso extends javax.swing.JFrame {
    
    private accesoDAO aDAO = null;
    private acceso miAcceso=null;
    private DefaultTableModel modelo=null;
    private int fila = 0;

    /**
     * Creates new form facceso
     */
    public facceso() {
        initComponents();
        
        //Permite cerrar la BD cuando se cierra la ventana
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent event) {
                if(aDAO!=null)
                    aDAO.cierra();
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

        jButton2 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        lblId_acceso = new javax.swing.JLabel();
        txtid_acceso = new javax.swing.JTextField();
        lblnombre_acceso = new javax.swing.JLabel();
        txtnombre_acceso = new javax.swing.JTextField();
        lblpagina_acceso = new javax.swing.JLabel();
        txtpagina_acceso = new javax.swing.JTextField();
        btnAgregar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnNuevo = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaDatosAcceso = new javax.swing.JTable();

        jButton2.setText("jButton2");

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Mantenimiento  Acceso");

        lblId_acceso.setText("Id Acceso");

        txtid_acceso.setEditable(false);

        lblnombre_acceso.setText("Nombre Acceso");

        lblpagina_acceso.setText("Pagina Acceso");

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

        TablaDatosAcceso.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Acceso", "Nombre Acceso", "Pagina Acceso"
            }
        ));
        TablaDatosAcceso.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaDatosAccesoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TablaDatosAcceso);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 412, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnAgregar)
                        .addGap(18, 18, 18)
                        .addComponent(btnModificar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEliminar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnNuevo))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblnombre_acceso)
                                    .addComponent(lblId_acceso))
                                .addGap(85, 85, 85))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(lblpagina_acceso)
                                .addGap(90, 90, 90)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtnombre_acceso, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
                            .addComponent(txtid_acceso)
                            .addComponent(txtpagina_acceso))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblId_acceso)
                    .addComponent(txtid_acceso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblnombre_acceso)
                    .addComponent(txtnombre_acceso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblpagina_acceso)
                    .addComponent(txtpagina_acceso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregar)
                    .addComponent(btnModificar)
                    .addComponent(btnEliminar)
                    .addComponent(btnNuevo))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        limpiaCampos();
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void TablaDatosAccesoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaDatosAccesoMouseClicked
        try{
            fila = TablaDatosAcceso.getSelectedRow();
            if(fila == -1){
                JOptionPane.showMessageDialog(null, "Acceso no seleccionado");
            }else{
                String id=(String)TablaDatosAcceso.getValueAt(fila,0).toString();
                String nombre=(String)TablaDatosAcceso.getValueAt(fila,1);
                String pagina=(String)TablaDatosAcceso.getValueAt(fila,2);
                this.txtid_acceso.setText(id);
                this.txtnombre_acceso.setText(nombre);
                this.txtpagina_acceso.setText(pagina);
            }
        }catch(Exception e){
            Util.printException("facceso.TablaDatosAccesoMouseClicked", e);
        }                        
    }//GEN-LAST:event_TablaDatosAccesoMouseClicked

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        eliminar();
    }//GEN-LAST:event_btnEliminarActionPerformed


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
            java.util.logging.Logger.getLogger(facceso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(facceso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(facceso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(facceso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new facceso().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TablaDatosAcceso;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton jButton2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblId_acceso;
    private javax.swing.JLabel lblnombre_acceso;
    private javax.swing.JLabel lblpagina_acceso;
    private javax.swing.JTextField txtid_acceso;
    private javax.swing.JTextField txtnombre_acceso;
    private javax.swing.JTextField txtpagina_acceso;
    // End of variables declaration//GEN-END:variables


    private void limpiaCampos() {
        try{
            this.txtid_acceso.setText("");
            this.txtnombre_acceso.setText("");
            this.txtpagina_acceso.setText("");

        }catch(Exception e){
            Util.printException("facceso.limpiaCampos", e);
        }                
    }
    
    
    public void limpiaTabla(){
        int filaRestante=0;
        try{
            if( TablaDatosAcceso.getRowCount() > 0 ){
                for(int i=0;i<=TablaDatosAcceso.getRowCount();i++){
                    modelo.removeRow(i);
                    i = i - 1;
                    filaRestante=modelo.getRowCount();
                    if(filaRestante==0){
                        break;
                    }
                }
            }
        }catch(Exception e){
            Util.printException("facceso.limpiaTabla", e);
        }        
    }

    private void llenaListado() {
        List<acceso> listaAccesos = null;
        
        try{
            aDAO = new accesoDAO();
            listaAccesos = new ArrayList<>();
            listaAccesos = aDAO.seleccionaTodo();

            Object[]pObj=new Object[3];

            modelo = (DefaultTableModel)TablaDatosAcceso.getModel();

            for(acceso p:listaAccesos){
                pObj[0] = p.getId_acceso();
                pObj[1] = p.getNombre_acceso();
                pObj[2] = p.getPagina_acceso();
                modelo.addRow(pObj);
            }
            TablaDatosAcceso.setModel(modelo);
        }catch(Exception e){
            Util.printException("facceso.llenaListado", e);
        }
    }

    
    
    private void agregar(){
        
        try{
            miAcceso = new acceso(  Util.str2int(this.txtid_acceso.getText()),
                                    this.txtnombre_acceso.getText(),
                                    this.txtpagina_acceso.getText() );
            
            if ( aDAO.inserta(miAcceso) ){
                JOptionPane.showMessageDialog(null, "Acceso ingresado");
                limpiaTabla();
                limpiaCampos();
                llenaListado();
            }
                    
            
        }catch(Exception e){
            Util.printException("facceso.agregar", e);
        }
    }
    
    private void modificar(){
        try{
            miAcceso = new acceso(  Util.str2int(this.txtid_acceso.getText()),
                                    this.txtnombre_acceso.getText(),
                                    this.txtpagina_acceso.getText() );
            
            if ( aDAO.actualiza(miAcceso) ){
                JOptionPane.showMessageDialog(null, "Acceso actualizado");
                limpiaTabla();
                limpiaCampos();
                llenaListado();
            }

        }catch(Exception e){
            Util.printException("facceso.modificar", e);
        }
    }
    
    

    private void eliminar(){
        try{        
            fila = TablaDatosAcceso.getSelectedRow();
            if(fila == -1){
                JOptionPane.showMessageDialog(null, "Debe seleccionar fila");
            }else{
                if ( aDAO.elimina( Util.str2int((String)TablaDatosAcceso.getValueAt(fila,0).toString()) ) ){
                    JOptionPane.showMessageDialog(null, "Acceso eliminado");
                    limpiaTabla();
                    limpiaCampos();
                    llenaListado();
                }
            }
        }catch(Exception e){
            Util.printException("facceso.eliminar", e);
        }        
    }    
    
}
