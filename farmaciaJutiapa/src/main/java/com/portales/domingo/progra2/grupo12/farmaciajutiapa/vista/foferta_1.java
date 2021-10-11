/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.portales.domingo.progra2.grupo12.farmaciajutiapa.vista;

import com.portales.domingo.progra2.grupo12.farmaciajutiapa.controlador.Util;
import com.portales.domingo.progra2.grupo12.farmaciajutiapa.dao.ofertaDAO;
import com.portales.domingo.progra2.grupo12.farmaciajutiapa.modelo.oferta;
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
public class foferta_1 extends javax.swing.JFrame {
    
    private ofertaDAO oDAO = null;
    private oferta miOferta=null;
    private DefaultTableModel modelo=null;
    private int fila = 0;

    /**
     * Creates new form foferta
     */
    public foferta_1() {
        initComponents();
        
        //Permite cerrar la BD cuando se cierra la ventana
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent event) {
                if(oDAO!=null)
                    oDAO.cierra();
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
        lblid_oferta = new javax.swing.JLabel();
        txtid_oferta = new javax.swing.JTextField();
        lblid_marca_producto_oferta = new javax.swing.JLabel();
        txtid_marca_producto_oferta = new javax.swing.JTextField();
        lblid_tipo_producto_oferta = new javax.swing.JLabel();
        txtid_tipo_producto_oferta = new javax.swing.JTextField();
        lblid_producto_oferta = new javax.swing.JLabel();
        txtid_producto_oferta = new javax.swing.JTextField();
        lblporcentaje_descuento = new javax.swing.JLabel();
        txtporcentaje_descuento = new javax.swing.JTextField();
        lblfecha_inicio = new javax.swing.JLabel();
        txtfecha_inicio = new javax.swing.JTextField();
        lblfecha_final = new javax.swing.JLabel();
        txtfecha_final = new javax.swing.JTextField();
        btnAgregar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnNuevo = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaDatosOferta = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblid_oferta.setText("Id oferta ");

        lblid_marca_producto_oferta.setText("Id marca producto");

        lblid_tipo_producto_oferta.setText("Id tipo producto");

        lblid_producto_oferta.setText("Id producto");

        lblporcentaje_descuento.setText("Porcentaje descuento");

        lblfecha_inicio.setText("Fecha inicio");

        txtfecha_inicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtfecha_inicioActionPerformed(evt);
            }
        });

        lblfecha_final.setText("Fecha final");

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

        TablaDatosOferta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id Oferta", "Id Marca Producto", "Id Tipo Producto", "Id Producto", "Porcentaje Descuento", "Fecha Inicio", "Fecha Final"
            }
        ));
        TablaDatosOferta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaDatosOfertaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TablaDatosOferta);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblid_oferta)
                            .addComponent(lblid_marca_producto_oferta)
                            .addComponent(lblid_tipo_producto_oferta)
                            .addComponent(lblid_producto_oferta)
                            .addComponent(lblporcentaje_descuento))
                        .addGap(72, 72, 72)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtid_oferta, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
                            .addComponent(txtid_marca_producto_oferta)
                            .addComponent(txtid_tipo_producto_oferta)
                            .addComponent(txtid_producto_oferta)
                            .addComponent(txtporcentaje_descuento)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblfecha_inicio)
                            .addComponent(lblfecha_final))
                        .addGap(119, 119, 119)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtfecha_inicio, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtfecha_final, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnAgregar)
                        .addGap(18, 18, 18)
                        .addComponent(btnModificar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEliminar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnNuevo)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 666, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblid_oferta)
                    .addComponent(txtid_oferta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgregar)
                    .addComponent(btnModificar)
                    .addComponent(btnEliminar)
                    .addComponent(btnNuevo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblid_marca_producto_oferta)
                    .addComponent(txtid_marca_producto_oferta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtid_tipo_producto_oferta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblid_tipo_producto_oferta))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblid_producto_oferta)
                            .addComponent(txtid_producto_oferta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblporcentaje_descuento)
                            .addComponent(txtporcentaje_descuento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblfecha_inicio)
                            .addComponent(txtfecha_inicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblfecha_final)
                            .addComponent(txtfecha_final, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(142, Short.MAX_VALUE))
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

    private void txtfecha_inicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtfecha_inicioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtfecha_inicioActionPerformed

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

    private void TablaDatosOfertaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaDatosOfertaMouseClicked
        try{
            fila = TablaDatosOferta.getSelectedRow();
            if(fila == -1){
                JOptionPane.showMessageDialog(null, "Oferta no seleccionada");
            }else{
                String idOferta=(String)TablaDatosOferta.getValueAt(fila,0).toString();
                String idMarcaProducto=(String)TablaDatosOferta.getValueAt(fila,1).toString();
                String idTipoProducto=(String)TablaDatosOferta.getValueAt(fila,2).toString();
                String idProducto=(String)TablaDatosOferta.getValueAt(fila,3).toString();
                String PorcentajeDescuento=(String)TablaDatosOferta.getValueAt(fila,4);
                String fechaInicio=(String)TablaDatosOferta.getValueAt(fila,5);
                String fechaFinal=(String)TablaDatosOferta.getValueAt(fila,6);                
                this.txtid_oferta.setText(idOferta);
                this.txtid_marca_producto_oferta.setText(idMarcaProducto);
                this.txtid_tipo_producto_oferta.setText(idTipoProducto);
                this.txtid_producto_oferta.setText(idProducto);
                this.txtporcentaje_descuento.setText(PorcentajeDescuento);
                this.txtfecha_inicio.setText(fechaInicio);
                this.txtfecha_final.setText(fechaFinal);
            }
        }catch(Exception e){
            Util.printException("foferta_1.TablaDatosAccesoMouseClicked", e);
        }  
    }//GEN-LAST:event_TablaDatosOfertaMouseClicked

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
            java.util.logging.Logger.getLogger(foferta_1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(foferta_1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(foferta_1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(foferta_1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new foferta_1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TablaDatosOferta;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblfecha_final;
    private javax.swing.JLabel lblfecha_inicio;
    private javax.swing.JLabel lblid_marca_producto_oferta;
    private javax.swing.JLabel lblid_oferta;
    private javax.swing.JLabel lblid_producto_oferta;
    private javax.swing.JLabel lblid_tipo_producto_oferta;
    private javax.swing.JLabel lblporcentaje_descuento;
    private javax.swing.JTextField txtfecha_final;
    private javax.swing.JTextField txtfecha_inicio;
    private javax.swing.JTextField txtid_marca_producto_oferta;
    private javax.swing.JTextField txtid_oferta;
    private javax.swing.JTextField txtid_producto_oferta;
    private javax.swing.JTextField txtid_tipo_producto_oferta;
    private javax.swing.JTextField txtporcentaje_descuento;
    // End of variables declaration//GEN-END:variables


    private void limpiaCampos() {
        try{
            this.txtid_oferta.setText("");
            this.txtid_marca_producto_oferta.setText("");
            this.txtid_tipo_producto_oferta.setText("");
            this.txtid_producto_oferta.setText("");
            this.txtporcentaje_descuento.setText("");
            this.txtfecha_inicio.setText("");
            this.txtfecha_final.setText("");
        }catch(Exception e){
            Util.printException("foferta_1.limpiaCampos", e);
        }                
    }
    
    
    public void limpiaTabla(){
        int filaRestante=0;
        try{        
            for(int i=0;i<=TablaDatosOferta.getRowCount();i++){
                modelo.removeRow(i);
                i = i - 1;
                filaRestante=modelo.getRowCount();
                if(filaRestante==0){
                    break;
                }
            }
        }catch(Exception e){
            Util.printException("foferta_1.limpiaTabla", e);
        }        
    }

    private void llenaListado() {
        List<oferta> listaOfertas = null;
        
        try{
            oDAO = new ofertaDAO();
            listaOfertas = new ArrayList<>();
            listaOfertas = oDAO.seleccionaTodo();

            Object[]pObj=new Object[7];

            modelo = (DefaultTableModel)TablaDatosOferta.getModel();

            for(oferta p:listaOfertas){
                pObj[0] = p.getId_oferta();
                pObj[1] = p.getId_marca_producto();
                pObj[2] = p.getId_tipo_producto();
                pObj[3] = p.getId_producto();
                pObj[4] = p.getPorcentaje_descuento();
                pObj[5] = p.getFecha_inicio();
                pObj[6] = p.getFecha_final();
                modelo.addRow(pObj);
            }
            TablaDatosOferta.setModel(modelo);
        }catch(Exception e){
            Util.printException("foferta_1.llenaListado", e);
        }
    }

    
    
    private void agregar(){
        
        try{
            miOferta = new oferta(  Util.str2int( this.txtid_oferta.getText() ),
                                    Util.str2int( this.txtid_marca_producto_oferta.getText() ),
                                    Util.str2int( this.txtid_tipo_producto_oferta.getText() ),
                                    Util.str2int( this.txtid_producto_oferta.getText() ),
                                    Util.str2double( this.txtporcentaje_descuento.getText() ),
                                    Util.str2date( this.txtfecha_inicio.getText() ),
                                    Util.str2date( this.txtfecha_final.getText() )  );
            
            if ( oDAO.inserta(miOferta) ){
                JOptionPane.showMessageDialog(null, "Oferta ingresada");
                limpiaTabla();
                limpiaCampos();
                llenaListado();
            }
                    
            
        }catch(Exception e){
            Util.printException("foferta_1.agregar", e);
        }
    }
    
    private void modificar(){
        try{
            miOferta = new oferta(  Util.str2int( this.txtid_oferta.getText() ),
                                    Util.str2int( this.txtid_marca_producto_oferta.getText() ),
                                    Util.str2int( this.txtid_tipo_producto_oferta.getText() ),
                                    Util.str2int( this.txtid_producto_oferta.getText() ),
                                    Util.str2double( this.txtporcentaje_descuento.getText() ),
                                    Util.str2date( this.txtfecha_inicio.getText() ),
                                    Util.str2date( this.txtfecha_final.getText() )  );
            
            if ( oDAO.actualiza(miOferta) ){
                JOptionPane.showMessageDialog(null, "Oferta actualizada");
                limpiaTabla();
                limpiaCampos();
                llenaListado();
            }

        }catch(Exception e){
            Util.printException("foferta_1.modificar", e);
        }
    }
    
    

    private void eliminar(){
        try{        
            fila = TablaDatosOferta.getSelectedRow();
            if(fila == -1){
                JOptionPane.showMessageDialog(null, "Debe seleccionar fila");
            }else{
                if ( oDAO.elimina( Util.str2int((String)TablaDatosOferta.getValueAt(fila,0).toString()) ) ){
                    JOptionPane.showMessageDialog(null, "Oferta eliminada");
                    limpiaTabla();
                    limpiaCampos();
                    llenaListado();
                }
            }
        }catch(Exception e){
            Util.printException("foferta_1.eliminar", e);
        }        
    }    
 
}
