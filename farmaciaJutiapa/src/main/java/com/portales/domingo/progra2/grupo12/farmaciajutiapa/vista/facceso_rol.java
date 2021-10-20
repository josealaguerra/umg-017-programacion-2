/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.portales.domingo.progra2.grupo12.farmaciajutiapa.vista;

import com.portales.domingo.progra2.grupo12.farmaciajutiapa.controlador.ConectaBD;
import com.portales.domingo.progra2.grupo12.farmaciajutiapa.controlador.Util;
import com.portales.domingo.progra2.grupo12.farmaciajutiapa.dao.acceso_rolDAO;
import com.portales.domingo.progra2.grupo12.farmaciajutiapa.modelo.acceso_rol;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Edinson Ruano
 */
public class facceso_rol extends javax.swing.JFrame {
    
    private acceso_rolDAO arDAO = null;
    private acceso_rol miAccesoRol=null;
    private DefaultTableModel modelo=null;
    private int fila = 0;

    /**
     * Creates new form facceso_rol
     */
    public facceso_rol() throws Exception {
        initComponents();
        arDAO = new acceso_rolDAO();        
        
        //Permite cerrar la BD cuando se cierra la ventana
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent event) {
                if(arDAO!=null)
                    arDAO.cierra();
                    dispose();
            }
        });

        llenaListado();
        limpiaCampos();
        llenaComboBoxAcceso();
        llenaComboBoxRol();        
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
        lblid_acceso_rol = new javax.swing.JLabel();
        txtid_acceso_rol = new javax.swing.JTextField();
        lblid_acceso = new javax.swing.JLabel();
        lblid_rol = new javax.swing.JLabel();
        btnAgregar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnNuevo = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaDatosAccesoRol = new javax.swing.JTable();
        cbxId_acceso = new javax.swing.JComboBox<>();
        cbxId_rol = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Mantenimiento Acceso Rol");

        lblid_acceso_rol.setText("Id acceso rol");

        txtid_acceso_rol.setEditable(false);

        lblid_acceso.setText("Id acceso");

        lblid_rol.setText("Id rol");

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

        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        TablaDatosAccesoRol.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id Acceso Rol", "Id Acceso", "Id Rol"
            }
        ));
        TablaDatosAccesoRol.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaDatosAccesoRolMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TablaDatosAccesoRol);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblid_acceso_rol)
                            .addComponent(lblid_acceso)
                            .addComponent(lblid_rol))
                        .addGap(43, 43, 43)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(cbxId_acceso, 0, 151, Short.MAX_VALUE)
                            .addComponent(cbxId_rol, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtid_acceso_rol)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 546, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnAgregar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnModificar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEliminar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnNuevo)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblid_acceso_rol)
                    .addComponent(txtid_acceso_rol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblid_acceso)
                    .addComponent(cbxId_acceso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblid_rol)
                    .addComponent(cbxId_rol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregar)
                    .addComponent(btnModificar)
                    .addComponent(btnEliminar)
                    .addComponent(btnNuevo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(77, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 2, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 32, Short.MAX_VALUE))
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

    private void TablaDatosAccesoRolMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaDatosAccesoRolMouseClicked
        try{
            fila = TablaDatosAccesoRol.getSelectedRow();
            if(fila == -1){
                JOptionPane.showMessageDialog(null, "Acceso-Rol no seleccionado");
            }else{
                String idAccesoRol  = (String)TablaDatosAccesoRol.getValueAt(fila,0).toString();
                String nombreAcceso = (String)TablaDatosAccesoRol.getValueAt(fila,1).toString();
                String nombreRol    = (String)TablaDatosAccesoRol.getValueAt(fila,2).toString();
                int idAccesoCbx = arDAO.getAccesoSelectedByName4Cbx( nombreAcceso );
                int idRolCbx = arDAO.getRolSelectedByName4Cbx( nombreRol );
                this.txtid_acceso_rol.setText(idAccesoRol);
                this.cbxId_acceso.setSelectedIndex( idAccesoCbx );
                this.cbxId_rol.setSelectedIndex( idRolCbx );
            }
        }catch(Exception e){
            Util.printException("facceso_rol.TablaDatosAccesoRolMouseClicked", e);
        }
    }//GEN-LAST:event_TablaDatosAccesoRolMouseClicked

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
            java.util.logging.Logger.getLogger(facceso_rol.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(facceso_rol.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(facceso_rol.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(facceso_rol.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new facceso_rol().setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(facceso_rol.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TablaDatosAccesoRol;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JComboBox<String> cbxId_acceso;
    private javax.swing.JComboBox<String> cbxId_rol;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblid_acceso;
    private javax.swing.JLabel lblid_acceso_rol;
    private javax.swing.JLabel lblid_rol;
    private javax.swing.JTextField txtid_acceso_rol;
    // End of variables declaration//GEN-END:variables


    private void limpiaCampos() {
        try{
            this.txtid_acceso_rol.setText("");
            this.cbxId_acceso.setSelectedIndex(0);
            this.cbxId_rol.setSelectedIndex(0);
        }catch(Exception e){
            Util.printException("facceso_rol.limpiaCampos", e);
        }                
    }
    
    
    public void limpiaTabla(){
        int filaRestante=0;
        try{        
            for(int i=0;i<=TablaDatosAccesoRol.getRowCount();i++){
                modelo.removeRow(i);
                i = i - 1;
                filaRestante=modelo.getRowCount();
                if(filaRestante==0){
                    break;
                }
            }
        }catch(Exception e){
            Util.printException("facceso_rol.limpiaTabla", e);
        }        
    }

    private void llenaListado() {
        List<acceso_rol> listaAccesos = null;
        
        try{
            listaAccesos = new ArrayList<>();
            listaAccesos = arDAO.seleccionaTodoRelacionado();

            Object[]pObj=new Object[3];

            modelo = (DefaultTableModel)TablaDatosAccesoRol.getModel();

            for(acceso_rol p:listaAccesos){
                pObj[0] = p.getId_acceso_rol();
                pObj[1] = p.getNombre_acceso();
                pObj[2] = p.getNombre_rol();
                modelo.addRow(pObj);
            }
            TablaDatosAccesoRol.setModel(modelo);
        }catch(Exception e){
            Util.printException("facceso_rol.llenaListado", e);
        }
    }

    
    
    private void agregar(){
        
        try{
            miAccesoRol = new acceso_rol(   Util.str2int(this.txtid_acceso_rol.getText()),
                                            arDAO.getIDAccesoByCbxSelected( (String) this.cbxId_acceso.getSelectedItem() ),
                                            arDAO.getIDRolByCbxSelected( (String) this.cbxId_rol.getSelectedItem() ));
            
            if ( arDAO.inserta( miAccesoRol ) ){
                JOptionPane.showMessageDialog(null, "Acceso Rol ingresado");
                limpiaTabla();
                limpiaCampos();
                llenaListado();
            }

        }catch(Exception e){
            Util.printException("facceso_rol.agregar", e);
        }
    }
    
    private void modificar(){
        try{
            miAccesoRol = new acceso_rol(   Util.str2int(this.txtid_acceso_rol.getText()),
                                            arDAO.getIDAccesoByCbxSelected( (String) this.cbxId_acceso.getSelectedItem() ),
                                            arDAO.getIDRolByCbxSelected( (String) this.cbxId_rol.getSelectedItem() ));
            
            if ( arDAO.actualiza( miAccesoRol ) ){
                JOptionPane.showMessageDialog(null, "Acceso Rol actualizado");
                limpiaTabla();
                limpiaCampos();
                llenaListado();
            }

        }catch(Exception e){
            Util.printException("facceso_rol.modificar", e);
        }
    }
    
    

    private void eliminar(){
        try{        
            fila = TablaDatosAccesoRol.getSelectedRow();
            if(fila == -1){
                JOptionPane.showMessageDialog(null, "Debe seleccionar fila");
            }else{
                if ( arDAO.elimina( Util.str2int((String)TablaDatosAccesoRol.getValueAt(fila,0).toString()) ) ){
                    JOptionPane.showMessageDialog(null, "Acceso Rol eliminado");
                    limpiaTabla();
                    limpiaCampos();
                    llenaListado();
                }
            }
        }catch(Exception e){
            Util.printException("facceso_rol.eliminar", e);
        }        
    }    
    
    private void llenaComboBoxAcceso() {

        ConectaBD cbd = null;
        
        try{
            cbd = new ConectaBD();
            cbd.getData( arDAO.getAccesoOrdenadoSQL() );
            this.cbxId_acceso.removeAll();
            if(cbd.getRs().next()){
                do{
                    this.cbxId_acceso.addItem( cbd.getRs().getString( 1 ) );
                }while(cbd.getRs().next());
            }else
                throw new Exception("llenaComboBoxAcceso, tabla acceso vacia");
            
        }catch(Exception e){
            Util.printException("facceso_rol.llenaComboBoxAcceso", e);
        }

    }
    
    private void llenaComboBoxRol() {

        ConectaBD cbd = null;
        
        try{
            cbd = new ConectaBD();
            cbd.getData( arDAO.getRolOrdenadoSQL() );
            this.cbxId_rol.removeAll();
            if(cbd.getRs().next()){
                do{
                    this.cbxId_rol.addItem( cbd.getRs().getString( 1 ) );
                }while(cbd.getRs().next());
            }else
                throw new Exception("llenaComboBoxRol, tabla rol vacia");
            
        }catch(Exception e){
            Util.printException("facceso_rol.llenaComboBoxRol", e);
        }

    }    
}