/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.portales.domingo.progra2.grupo12.farmaciajutiapa.vista;

import com.portales.domingo.progra2.grupo12.farmaciajutiapa.controlador.ConectaBD;
import com.portales.domingo.progra2.grupo12.farmaciajutiapa.controlador.Util;
import com.portales.domingo.progra2.grupo12.farmaciajutiapa.dao.personaDAO;
import com.portales.domingo.progra2.grupo12.farmaciajutiapa.modelo.persona;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author josea
 */
public class fpersona extends javax.swing.JFrame {
    private personaDAO pDAO = null;
    private persona miPersona=null;
    private DefaultTableModel modelo=null;
    private int fila = 0;

    /**
     * Creates new form fpersona
     */
    public fpersona() {
        initComponents();
        llenaListado();
        limpiaCampos();
        llenaComboBoxGenero();
        llenaComboBoxEstadoCivil();

        //Permite cerrar la BD cuando se cierra la ventana
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent event) {
                if(pDAO!=null)
                    pDAO.cierra();
                    dispose();
            }
        });        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblid_persona = new javax.swing.JLabel();
        lblprimer_nombre = new javax.swing.JLabel();
        lblsegundo_nombre = new javax.swing.JLabel();
        lblprimer_apellido = new javax.swing.JLabel();
        txtid_persona = new javax.swing.JTextField();
        txtprimer_nombre = new javax.swing.JTextField();
        txtsegundo_nombre = new javax.swing.JTextField();
        txtprimer_apellido = new javax.swing.JTextField();
        lblsegundo_apellido = new javax.swing.JLabel();
        txtsegundo_apellido = new javax.swing.JTextField();
        lblid_genero = new javax.swing.JLabel();
        lblfecha_de_nacimiento = new javax.swing.JLabel();
        lblid_estado_civil = new javax.swing.JLabel();
        btnAgregar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        cbxid_genero = new javax.swing.JComboBox<>();
        cbxid_estado_civil = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaDatosPersona = new javax.swing.JTable();
        btnEliminar = new javax.swing.JButton();
        btnNuevo = new javax.swing.JButton();
        txtfecha_de_nacimiento = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Mantenimiento de persona");

        lblid_persona.setText("ID persona:");

        lblprimer_nombre.setText("primer_nombre");

        lblsegundo_nombre.setText("segundo_nombre:");

        lblprimer_apellido.setText("primer_apellido:");

        txtid_persona.setEditable(false);

        txtprimer_nombre.setText("jTextField2");

        txtsegundo_nombre.setText("jTextField3");

        txtprimer_apellido.setText("jTextField4");

        lblsegundo_apellido.setText("segundo_apellido:");

        txtsegundo_apellido.setText("jTextField5");

        lblid_genero.setText("id_genero:");

        lblfecha_de_nacimiento.setText("fecha_de_nacimiento:");

        lblid_estado_civil.setText("id_estado_civil:");

        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnModificar.setText("Modificar");
        btnModificar.setActionCommand("");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        TablaDatosPersona.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID persona", "Primer nombre", "Segundo nombre", "Primer apellido", "Segundo apellido", "Genero", "Fecha de nacimiento", "Estado civil"
            }
        ));
        TablaDatosPersona.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaDatosPersonaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TablaDatosPersona);
        if (TablaDatosPersona.getColumnModel().getColumnCount() > 0) {
            TablaDatosPersona.getColumnModel().getColumn(7).setMinWidth(50);
            TablaDatosPersona.getColumnModel().getColumn(7).setPreferredWidth(50);
            TablaDatosPersona.getColumnModel().getColumn(7).setMaxWidth(50);
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 810, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(141, Short.MAX_VALUE))
        );

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

        txtfecha_de_nacimiento.setDateFormatString("dd/MM/yyyy");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblprimer_apellido)
                            .addComponent(lblsegundo_nombre)
                            .addComponent(lblprimer_nombre)
                            .addComponent(lblid_persona))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtprimer_apellido, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
                            .addComponent(txtid_persona, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
                            .addComponent(txtprimer_nombre, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtsegundo_nombre, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblid_genero, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblsegundo_apellido, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblid_estado_civil, javax.swing.GroupLayout.Alignment.TRAILING)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(lblfecha_de_nacimiento)))
                        .addGap(47, 47, 47)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbxid_estado_civil, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbxid_genero, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtsegundo_apellido, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                            .addComponent(txtfecha_de_nacimiento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(btnAgregar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnModificar)
                        .addGap(18, 18, 18)
                        .addComponent(btnEliminar)
                        .addGap(18, 18, 18)
                        .addComponent(btnNuevo))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblid_persona)
                            .addComponent(txtid_persona, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblsegundo_apellido))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblprimer_nombre)
                            .addComponent(txtprimer_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblid_genero))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblsegundo_nombre)
                            .addComponent(txtsegundo_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblfecha_de_nacimiento))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblprimer_apellido)
                                .addComponent(txtprimer_apellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblid_estado_civil)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtsegundo_apellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cbxid_genero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtfecha_de_nacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cbxid_estado_civil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregar)
                    .addComponent(btnModificar)
                    .addComponent(btnEliminar)
                    .addComponent(btnNuevo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        agregar();
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void TablaDatosPersonaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaDatosPersonaMouseClicked
        try{    
            fila = TablaDatosPersona.getSelectedRow();
            if(fila == -1){
                JOptionPane.showMessageDialog(null, "Persona no seleccionada");
            }else{
                this.txtid_persona.setText((String)TablaDatosPersona.getValueAt(fila,0).toString());
                this.txtprimer_nombre.setText((String)TablaDatosPersona.getValueAt(fila,1));
                this.txtsegundo_nombre.setText((String)TablaDatosPersona.getValueAt(fila,2));
                this.txtprimer_apellido.setText((String)TablaDatosPersona.getValueAt(fila,3));
                this.txtsegundo_apellido.setText((String)TablaDatosPersona.getValueAt(fila,4));
                
                //Obtiene el verdadero ID
                int generoID = convertStr2Cbx((String)TablaDatosPersona.getValueAt(fila,5).toString(), 
                                                this.cbxid_genero.getItemCount() );
                this.cbxid_genero.setSelectedIndex( generoID );
                
                //Fecha
                Date fecha=(Date)TablaDatosPersona.getValueAt(fila,6);
                this.txtfecha_de_nacimiento.setDate(fecha);
                
                //Obtiene el verdadero ID
                int estadoCivilID = convertStr2Cbx( (String)TablaDatosPersona.getValueAt(fila,7).toString(), 
                                                    this.cbxid_estado_civil.getItemCount() );
                this.cbxid_estado_civil.setSelectedIndex( estadoCivilID );
            }
        }catch(Exception e){
            Util.printException("fpersona.TablaDatosPersonaMouseClicked", e);
        }        
    }//GEN-LAST:event_TablaDatosPersonaMouseClicked

    
    
    private int convertStr2Cbx(String cbxValue, int maxIDCbx){
        int newID = 0;
        int newMaxID = 0;

        try{            
            newID   = Util.str2int( cbxValue ) - 1;
            newMaxID= maxIDCbx - 1;
            if(newID < 0){
                newID = 0;
            }else if(newID >newMaxID){
                newID = newMaxID;
            }        
        }catch(Exception e){
            Util.printException("fpersona.TablaDatosPersonaMouseClicked", e);
        }                
        
        return newID;
    }
    
    
    
    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        modificar();
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        limpiaCampos();
    }//GEN-LAST:event_btnNuevoActionPerformed

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
            java.util.logging.Logger.getLogger(fpersona.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(fpersona.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(fpersona.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(fpersona.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new fpersona().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TablaDatosPersona;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JComboBox<String> cbxid_estado_civil;
    private javax.swing.JComboBox<String> cbxid_genero;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblfecha_de_nacimiento;
    private javax.swing.JLabel lblid_estado_civil;
    private javax.swing.JLabel lblid_genero;
    private javax.swing.JLabel lblid_persona;
    private javax.swing.JLabel lblprimer_apellido;
    private javax.swing.JLabel lblprimer_nombre;
    private javax.swing.JLabel lblsegundo_apellido;
    private javax.swing.JLabel lblsegundo_nombre;
    private com.toedter.calendar.JDateChooser txtfecha_de_nacimiento;
    private javax.swing.JTextField txtid_persona;
    private javax.swing.JTextField txtprimer_apellido;
    private javax.swing.JTextField txtprimer_nombre;
    private javax.swing.JTextField txtsegundo_apellido;
    private javax.swing.JTextField txtsegundo_nombre;
    // End of variables declaration//GEN-END:variables

    private void llenaComboBoxGenero() {

        ConectaBD cbd = null;
        
        try{
            cbd = new ConectaBD();
            cbd.getData(" select id_genero, nombre_genero from genero ");
            this.cbxid_genero.removeAll();
            if(cbd.getRs().next()){
                do{
                    this.cbxid_genero.addItem( cbd.getRs().getString(2) );
                }while(cbd.getRs().next());
            }else
                throw new Exception("llenaComboBoxGenero, tabla genero vacia");
            
        }catch(Exception e){
            Util.printException("fpersona.llenaComboBoxGenero", e);
        }

    }

    private void llenaComboBoxEstadoCivil() {
        
        ConectaBD cbd = null;
        
        try{
            cbd = new ConectaBD();
            cbd.getData(" select id_estado_civil, nombre_estado_civil from estado_civil ");
            this.cbxid_estado_civil.removeAll();
            if(cbd.getRs().next()){
                do{
                    this.cbxid_estado_civil.addItem( cbd.getRs().getString(2) );
                }while(cbd.getRs().next());
            }else
                throw new Exception("llenaComboBoxGenero, tabla genero vacia");
            
        }catch(Exception e){
            Util.printException("fpersona.llenaComboBoxEstadoCivil", e);
        }
    }

    private void limpiaCampos() {
        try{
            this.txtid_persona.setText("");
            this.txtprimer_nombre.setText("");
            this.txtsegundo_nombre.setText("");
            this.txtprimer_apellido.setText("");
            this.txtsegundo_apellido.setText("");
            this.txtfecha_de_nacimiento.setDate( new Date() );
        }catch(Exception e){
            Util.printException("fpersona.limpiaCampos", e);
        }                
    }
    
    
    public void limpiaTabla(){
        int filaRestante=0;        
        try{   
            if (TablaDatosPersona.getRowCount()> 0) {
                
            
            for(int i=0;i<=TablaDatosPersona.getRowCount();i++){
                modelo.removeRow(i);
                i = i - 1;
                filaRestante=modelo.getRowCount();
                if(filaRestante==0){
                    break;
                }                
            }
            }
        }catch(Exception e){
            Util.printException("fpersona.limpiaTabla", e);
        }        
    }

    private void llenaListado() {
        List<persona> listaPersona = null;
        
        try{
            pDAO = new personaDAO();
            listaPersona = new ArrayList<>();
            listaPersona = pDAO.seleccionaTodo();

            Object[]pObj=new Object[8];

            modelo = (DefaultTableModel)TablaDatosPersona.getModel();

            for(persona p:listaPersona){
                pObj[0] = p.getId_persona();
                pObj[1] = p.getPrimer_nombre();
                pObj[2] = p.getSegundo_nombre();
                pObj[3] = p.getPrimer_apellido();
                pObj[4] = p.getSegundo_apellido();
                pObj[5] = p.getId_genero();
                pObj[6] = p.getFecha_de_nacimiento();
                pObj[7] = p.getId_estado_civil();
                modelo.addRow(pObj);
            }
            TablaDatosPersona.setModel(modelo);
        }catch(Exception e){
            Util.printException("fpersona.llenaListado", e);
        }
    }

    
    
    private void agregar(){
        
        try{
            miPersona = new persona(Util.str2int(this.txtid_persona.getText()),
                                    this.txtprimer_nombre.getText(),
                                    this.txtsegundo_nombre.getText(),
                                    this.txtprimer_apellido.getText(),
                                    this.txtsegundo_apellido.getText(),
                                    Util.int2cbx( this.cbxid_genero.getSelectedIndex() ),
                                    this.txtfecha_de_nacimiento.getDate(),
                                    Util.int2cbx( this.cbxid_estado_civil.getSelectedIndex() ));
            
            if ( pDAO.inserta(miPersona) ){
                JOptionPane.showMessageDialog(null, "Usuario ingresado");
                limpiaTabla();
                limpiaCampos();
                llenaListado();
            }

        }catch(Exception e){
            Util.printException("fpersona.agregar", e);
        }
    }
    
    private void modificar(){
        try{
            miPersona = new persona(Util.str2int(this.txtid_persona.getText()),
                                    this.txtprimer_nombre.getText(),
                                    this.txtsegundo_nombre.getText(),
                                    this.txtprimer_apellido.getText(),
                                    this.txtsegundo_apellido.getText(),
                                    Util.int2cbx( this.cbxid_genero.getSelectedIndex() ),
                                    this.txtfecha_de_nacimiento.getDate(),
                                    Util.int2cbx( this.cbxid_estado_civil.getSelectedIndex() ) );
            
            if ( pDAO.actualiza(miPersona) ){
                 JOptionPane.showMessageDialog(null, "Persona actualizada");
                limpiaTabla();
                limpiaCampos();
                llenaListado();
            }

        }catch(Exception e){
            Util.printException("fpersona.modificar", e);
        }
    }
    
    

    private void eliminar(){
        try{        
            fila = TablaDatosPersona.getSelectedRow();
            if(fila == -1){
                JOptionPane.showMessageDialog(null, "Debe seleccionar fila");
            }else{
                if ( pDAO.elimina( Util.str2int((String)TablaDatosPersona.getValueAt(fila,0).toString()) ) ){
                    JOptionPane.showMessageDialog(null, "Persona eliminada");
                    limpiaTabla();
                    limpiaCampos();
                    llenaListado();
                }
            }
        }catch(Exception e){
            Util.printException("fpersona.eliminar", e);
        }        
    }    
    
}
