/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.portales.domingo.progra2.grupo12.farmaciajutiapa.vista;

import com.portales.domingo.progra2.grupo12.farmaciajutiapa.controlador.Util;
import com.portales.domingo.progra2.grupo12.farmaciajutiapa.dao.empresaDAO;
import com.portales.domingo.progra2.grupo12.farmaciajutiapa.modelo.empresa;
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
public class fempresa_1 extends javax.swing.JFrame {
    private empresaDAO eDAO = null;
    private empresa miEmpresa=null;
    private DefaultTableModel modelo=null;
    private int fila = 0;

    /**
     * Creates new form fempresa
     */
    public fempresa_1() {
        initComponents();
        
        //Permite cerrar la BD cuando se cierra la ventana
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent event) {
                if(eDAO!=null)
                    eDAO.cierra();
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
        lblid_empresa = new javax.swing.JLabel();
        txtid_empresa = new javax.swing.JTextField();
        lblnit = new javax.swing.JLabel();
        txtnit = new javax.swing.JTextField();
        lblrazon_social = new javax.swing.JLabel();
        txtrazon_social = new javax.swing.JTextField();
        lblfecha_constitucion = new javax.swing.JLabel();
        txtfecha_constitucion = new javax.swing.JTextField();
        btnAgregar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnNuevo = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaDatosEmpresa = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Mantenimiento Empresa");

        lblid_empresa.setText("Id empresa");

        txtid_empresa.setEditable(false);

        lblnit.setText("Nit");

        lblrazon_social.setText("Razon social");

        lblfecha_constitucion.setText("Fecha de constirucion");

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

        TablaDatosEmpresa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id empresa", "Nit", "Razon Social", "Fecha de Constitución"
            }
        ));
        TablaDatosEmpresa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaDatosEmpresaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TablaDatosEmpresa);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblid_empresa)
                            .addComponent(lblnit)
                            .addComponent(lblrazon_social)
                            .addComponent(lblfecha_constitucion))
                        .addGap(72, 72, 72)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtid_empresa, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
                            .addComponent(txtnit)
                            .addComponent(txtrazon_social)
                            .addComponent(txtfecha_constitucion)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(btnAgregar)
                        .addGap(18, 18, 18)
                        .addComponent(btnModificar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEliminar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnNuevo))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 714, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblid_empresa)
                    .addComponent(txtid_empresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblnit)
                    .addComponent(txtnit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtrazon_social, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblrazon_social))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblfecha_constitucion)
                    .addComponent(txtfecha_constitucion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregar)
                    .addComponent(btnModificar)
                    .addComponent(btnEliminar)
                    .addComponent(btnNuevo))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(210, Short.MAX_VALUE))
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

    private void TablaDatosEmpresaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaDatosEmpresaMouseClicked
        try{
                fila = TablaDatosEmpresa.getSelectedRow();
            if(fila == -1){
                JOptionPane.showMessageDialog(null, "Empresa no seleccionado");
            }else{
                String id_empresa=(String)TablaDatosEmpresa.getValueAt(fila,0).toString();
                String nit=(String)TablaDatosEmpresa.getValueAt(fila,1);
                String razonSocial=(String)TablaDatosEmpresa.getValueAt(fila,2);
                String fechaDeConstitucion=(String)TablaDatosEmpresa.getValueAt(fila,3);
                this.txtid_empresa.setText(id_empresa);
                this.txtnit.setText(nit);
                this.txtrazon_social.setText(razonSocial);
                this.txtfecha_constitucion.setText(fechaDeConstitucion);
            }
        }catch(Exception e){
            Util.printException("fempresa_1.TablaDatosEmpresaMouseClicked", e);
        }                  
    }//GEN-LAST:event_TablaDatosEmpresaMouseClicked

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
            java.util.logging.Logger.getLogger(fempresa_1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(fempresa_1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(fempresa_1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(fempresa_1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new fempresa_1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TablaDatosEmpresa;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblfecha_constitucion;
    private javax.swing.JLabel lblid_empresa;
    private javax.swing.JLabel lblnit;
    private javax.swing.JLabel lblrazon_social;
    private javax.swing.JTextField txtfecha_constitucion;
    private javax.swing.JTextField txtid_empresa;
    private javax.swing.JTextField txtnit;
    private javax.swing.JTextField txtrazon_social;
    // End of variables declaration//GEN-END:variables


    private void limpiaCampos() {
        try{
            this.txtid_empresa.setText("");
            this.txtnit.setText("");
            this.txtrazon_social.setText("");
            this.txtfecha_constitucion.setText("");
        }catch(Exception e){
            Util.printException("fempresa_1.limpiaCampos", e);
        }                
    }
    
    
    public void limpiaTabla(){
        int filaRestante=0;
        try{        
            for(int i=0;i<=TablaDatosEmpresa.getRowCount();i++){
                modelo.removeRow(i);
                i = i - 1;
                filaRestante=modelo.getRowCount();
                if(filaRestante==0){
                    break;
                }
            }
        }catch(Exception e){
            Util.printException("fempresa_1.limpiaTabla", e);
        }        
    }

    private void llenaListado() {
        List<empresa> listaEmpresa = null;
        
        try{
            eDAO = new empresaDAO();
            listaEmpresa = new ArrayList<>();
            listaEmpresa = eDAO.seleccionaTodo();

            Object[]pObj=new Object[4];

            modelo = (DefaultTableModel)TablaDatosEmpresa.getModel();

            for(empresa p:listaEmpresa){
                pObj[0] = p.getId_empresa();
                pObj[1] = p.getNit();
                pObj[2] = p.getRazonSocial();
                pObj[3] = p.getFechaDeConstitucion();
                modelo.addRow(pObj);
            }
            TablaDatosEmpresa.setModel(modelo);
        }catch(Exception e){
            Util.printException("fempresa_1.llenaListado", e);
        }
    }

    
    
    private void agregar(){
        
        try{
            miEmpresa = new empresa(Util.str2int( this.txtid_empresa.getText() ),
                                    this.txtnit.getText(),
                                    this.txtrazon_social.getText(),
                                    Util.str2date(this.txtfecha_constitucion.getText()) );
            
            if ( eDAO.inserta( miEmpresa ) ){
                JOptionPane.showMessageDialog(null, "Empresa ingresado");
                limpiaTabla();
                limpiaCampos();
                llenaListado();
            }
                    
            
        }catch(Exception e){
            Util.printException("fempresa_1.agregar", e);
        }
    }
    
    private void modificar(){
        try{
            miEmpresa = new empresa(Util.str2int( this.txtid_empresa.getText() ),
                                    this.txtnit.getText(),
                                    this.txtrazon_social.getText(),
                                    Util.str2date(this.txtfecha_constitucion.getText()) );
            
            if ( eDAO.actualiza(miEmpresa) ){
                JOptionPane.showMessageDialog(null, "Empresa actualizado");
                limpiaTabla();
                limpiaCampos();
                llenaListado();
            }

        }catch(Exception e){
            Util.printException("fempresa_1.modificar", e);
        }
    }
    
    

    private void eliminar(){
        try{        
            fila = TablaDatosEmpresa.getSelectedRow();
            if(fila == -1){
                JOptionPane.showMessageDialog(null, "Debe seleccionar fila");
            }else{
                if ( eDAO.elimina( Util.str2int((String)TablaDatosEmpresa.getValueAt(fila,0).toString()) ) ){
                    JOptionPane.showMessageDialog(null, "Empresa eliminado");
                    limpiaTabla();
                    limpiaCampos();
                    llenaListado();
                }
            }
        }catch(Exception e){
            Util.printException("fempresa_1.eliminar", e);
        }        
    }    
   
}
