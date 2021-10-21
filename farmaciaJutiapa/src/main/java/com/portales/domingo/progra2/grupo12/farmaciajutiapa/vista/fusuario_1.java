/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.portales.domingo.progra2.grupo12.farmaciajutiapa.vista;

import com.portales.domingo.progra2.grupo12.farmaciajutiapa.controlador.Util;
import com.portales.domingo.progra2.grupo12.farmaciajutiapa.dao.usuarioDAO;
import com.portales.domingo.progra2.grupo12.farmaciajutiapa.modelo.usuario;
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
public class fusuario_1 extends javax.swing.JFrame {
    private usuarioDAO uDAO = null;
    private usuario miUsuario=null;
    private DefaultTableModel modelo=null;
    private int fila = 0;

    /**
     * Creates new form fusuario
     */
    public fusuario_1() {
        initComponents();
        
        //Permite cerrar la BD cuando se cierra la ventana
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent event) {
                if(uDAO!=null)
                    uDAO.cierra();
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
        lblid_compra = new javax.swing.JLabel();
        txtid_compra = new javax.swing.JTextField();
        lblid_proveedor = new javax.swing.JLabel();
        txtid_proveedor = new javax.swing.JTextField();
        lblfecha_compra = new javax.swing.JLabel();
        txtfecha_compra = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        lblnumero_facctura = new javax.swing.JLabel();
        txtnumero_factura = new javax.swing.JTextField();
        lblmonto_total = new javax.swing.JLabel();
        txtmonto_total = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        lblid_usuario = new javax.swing.JLabel();
        txtid_usuario = new javax.swing.JTextField();
        lblid_persona = new javax.swing.JLabel();
        txtid_persona = new javax.swing.JTextField();
        lblcontraseña = new javax.swing.JLabel();
        txtcontraseña = new javax.swing.JTextField();
        lblid_rol = new javax.swing.JLabel();
        txtid_rol = new javax.swing.JTextField();
        btnAgregar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnNuevo = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaDatosUsuario = new javax.swing.JTable();

        lblid_compra.setText("Id compra");

        lblid_proveedor.setText("Id proveedor");

        lblfecha_compra.setText("Fecha compra");

        jButton1.setText("jButton1");

        lblnumero_facctura.setText("Numero factura");

        lblmonto_total.setText("Monto total");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jButton1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblid_compra)
                            .addComponent(lblid_proveedor)
                            .addComponent(lblfecha_compra)
                            .addComponent(lblnumero_facctura)
                            .addComponent(lblmonto_total))
                        .addGap(72, 72, 72)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtid_compra, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
                            .addComponent(txtid_proveedor)
                            .addComponent(txtfecha_compra)
                            .addComponent(txtnumero_factura)
                            .addComponent(txtmonto_total))))
                .addContainerGap(128, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblid_compra)
                    .addComponent(txtid_compra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblid_proveedor)
                    .addComponent(txtid_proveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtfecha_compra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblfecha_compra))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblnumero_facctura)
                    .addComponent(txtnumero_factura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblmonto_total)
                    .addComponent(txtmonto_total, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49)
                .addComponent(jButton1)
                .addContainerGap(61, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Mantenimiento de usuario");

        lblid_usuario.setText("Id usuario");

        txtid_usuario.setEditable(false);

        lblid_persona.setText("Id persona");

        lblcontraseña.setText("Contraseña");

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

        TablaDatosUsuario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id Usuario", "Id Persona", "Contraseña", "Id rol"
            }
        ));
        TablaDatosUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaDatosUsuarioMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TablaDatosUsuario);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblid_usuario)
                            .addComponent(lblid_persona)
                            .addComponent(lblcontraseña)
                            .addComponent(lblid_rol))
                        .addGap(72, 72, 72)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtid_usuario, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
                            .addComponent(txtid_persona)
                            .addComponent(txtcontraseña)
                            .addComponent(txtid_rol)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnAgregar)
                        .addGap(18, 18, 18)
                        .addComponent(btnModificar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEliminar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnNuevo)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 98, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblid_usuario)
                    .addComponent(txtid_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblid_persona)
                    .addComponent(txtid_persona, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtcontraseña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblcontraseña))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblid_rol)
                    .addComponent(txtid_rol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregar)
                    .addComponent(btnModificar)
                    .addComponent(btnEliminar)
                    .addComponent(btnNuevo))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(152, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(34, 34, 34))
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

    private void TablaDatosUsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaDatosUsuarioMouseClicked
        try{
            fila = TablaDatosUsuario.getSelectedRow();
            if(fila == -1){
                JOptionPane.showMessageDialog(null, "Usuario no seleccionado");
            }else{
                String idUsuario=(String)TablaDatosUsuario.getValueAt(fila,0).toString();
                String idPersona=(String)TablaDatosUsuario.getValueAt(fila,1);
                String contrasenia=(String)TablaDatosUsuario.getValueAt(fila,2);
                String idRol=(String)TablaDatosUsuario.getValueAt(fila,3);
                this.txtid_usuario.setText(idUsuario);
                this.txtid_persona.setText(idPersona);
                this.txtcontraseña.setText(contrasenia);
                this.txtid_rol.setText(idRol);
            }
        }catch(Exception e){
            Util.printException("fusuario_1.TablaDatosAccesoMouseClicked", e);
        }
    }//GEN-LAST:event_TablaDatosUsuarioMouseClicked

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
            java.util.logging.Logger.getLogger(fusuario_1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(fusuario_1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(fusuario_1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(fusuario_1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new fusuario_1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TablaDatosUsuario;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblcontraseña;
    private javax.swing.JLabel lblfecha_compra;
    private javax.swing.JLabel lblid_compra;
    private javax.swing.JLabel lblid_persona;
    private javax.swing.JLabel lblid_proveedor;
    private javax.swing.JLabel lblid_rol;
    private javax.swing.JLabel lblid_usuario;
    private javax.swing.JLabel lblmonto_total;
    private javax.swing.JLabel lblnumero_facctura;
    private javax.swing.JTextField txtcontraseña;
    private javax.swing.JTextField txtfecha_compra;
    private javax.swing.JTextField txtid_compra;
    private javax.swing.JTextField txtid_persona;
    private javax.swing.JTextField txtid_proveedor;
    private javax.swing.JTextField txtid_rol;
    private javax.swing.JTextField txtid_usuario;
    private javax.swing.JTextField txtmonto_total;
    private javax.swing.JTextField txtnumero_factura;
    // End of variables declaration//GEN-END:variables


    private void limpiaCampos() {
        try{
            this.txtid_usuario.setText("");
            this.txtid_persona.setText("");
            this.txtcontraseña.setText("");
            this.txtid_rol.setText("");
        }catch(Exception e){
            Util.printException("fusuario_1.limpiaCampos", e);
        }                
    }
    
    
    public void limpiaTabla(){
        int filaRestante=0;
        try{
            if(TablaDatosUsuario.getRowCount() > 0){
                for(int i=0;i<=TablaDatosUsuario.getRowCount();i++){
                    modelo.removeRow(i);
                    i = i - 1;
                    filaRestante=modelo.getRowCount();
                    if(filaRestante==0){
                        break;
                    }
                }
            }
        }catch(Exception e){
            Util.printException("fusuario_1.limpiaTabla", e);
        }        
    }

    private void llenaListado() {
        List<usuario> listaUsuarios = null;
        
        try{
            uDAO = new usuarioDAO();
            listaUsuarios = new ArrayList<>();
            listaUsuarios = uDAO.seleccionaTodo();

            Object[]pObj=new Object[4];

            modelo = (DefaultTableModel)TablaDatosUsuario.getModel();

            for(usuario p:listaUsuarios){
                pObj[0] = p.getId_usuario();
                pObj[1] = p.getId_persona();
                pObj[2] = p.getContraseña();
                pObj[3] = p.getId_rol();
                modelo.addRow(pObj);
            }
            TablaDatosUsuario.setModel(modelo);
        }catch(Exception e){
            Util.printException("fusuario_1.llenaListado", e);
        }
    }

    
    
    private void agregar(){
        
        try{
            miUsuario = new usuario(Util.str2int(this.txtid_usuario.getText()),
                                    Util.str2int(this.txtid_persona.getText()),
                                    this.txtcontraseña.getText(),
                                    Util.str2int(this.txtid_rol.getText()) );
            
            if ( uDAO.inserta(miUsuario) ){
                JOptionPane.showMessageDialog(null, "Usuario ingresado");
                limpiaTabla();
                limpiaCampos();
                llenaListado();
            }
                    
            
        }catch(Exception e){
            Util.printException("fusuario_1.agregar", e);
        }
    }
    
    private void modificar(){
        try{
            miUsuario = new usuario(Util.str2int(this.txtid_usuario.getText()),
                                    Util.str2int(this.txtid_persona.getText()),
                                    this.txtcontraseña.getText(),
                                    Util.str2int(this.txtid_rol.getText()) );
            
            if ( uDAO.actualiza(miUsuario) ){
                JOptionPane.showMessageDialog(null, "Usuario actualizado");
                limpiaTabla();
                limpiaCampos();
                llenaListado();
            }

        }catch(Exception e){
            Util.printException("fusuario_1.modificar", e);
        }
    }
    
    

    private void eliminar(){
        try{        
            fila = TablaDatosUsuario.getSelectedRow();
            if(fila == -1){
                JOptionPane.showMessageDialog(null, "Debe seleccionar fila");
            }else{
                if ( uDAO.elimina( Util.str2int((String)TablaDatosUsuario.getValueAt(fila,0).toString()) ) ){
                    JOptionPane.showMessageDialog(null, "Usuario eliminado");
                    limpiaTabla();
                    limpiaCampos();
                    llenaListado();
                }
            }
        }catch(Exception e){
            Util.printException("fusuario_1.eliminar", e);
        }        
    }    
 
}
