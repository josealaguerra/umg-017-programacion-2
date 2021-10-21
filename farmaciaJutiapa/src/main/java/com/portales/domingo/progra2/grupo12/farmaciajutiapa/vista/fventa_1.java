/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.portales.domingo.progra2.grupo12.farmaciajutiapa.vista;

import com.portales.domingo.progra2.grupo12.farmaciajutiapa.controlador.Util;
import com.portales.domingo.progra2.grupo12.farmaciajutiapa.dao.ventaDAO;
import com.portales.domingo.progra2.grupo12.farmaciajutiapa.modelo.venta;
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
public class fventa_1 extends javax.swing.JFrame {
    
    private ventaDAO vDAO = null;
    private venta miVenta=null;
    private DefaultTableModel modelo=null;
    private int fila = 0;

    /**
     * Creates new form fventa
     */
    public fventa_1() {
        initComponents();
        
        //Permite cerrar la BD cuando se cierra la ventana
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent event) {
                if(vDAO!=null)
                    vDAO.cierra();
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

        lblid_venta = new javax.swing.JLabel();
        lblid_cliente = new javax.swing.JLabel();
        lblfecha_venta = new javax.swing.JLabel();
        lblnumero_factura = new javax.swing.JLabel();
        lblmonto_total = new javax.swing.JLabel();
        txtid_venta = new javax.swing.JTextField();
        txtid_cliente = new javax.swing.JTextField();
        txtnumero_factura = new javax.swing.JTextField();
        txtmonto_total = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaDatosVenta = new javax.swing.JTable();
        btnAgregar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnNuevo = new javax.swing.JButton();
        txtfecha_venta = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Mantenimiento de venta");

        lblid_venta.setText("Id Venta");

        lblid_cliente.setText("Id Cliente");

        lblfecha_venta.setText("Fecha Venta");

        lblnumero_factura.setText("Numero Factura");

        lblmonto_total.setText("Monto Total");

        txtid_venta.setEditable(false);

        TablaDatosVenta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id Venta", "Id Cliente", "Fecha Venta", "Numero Factura", "Monto Total"
            }
        ));
        TablaDatosVenta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaDatosVentaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TablaDatosVenta);

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

        txtfecha_venta.setDateFormatString("dd/MM/yyyy");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblmonto_total)
                        .addGap(38, 38, 38))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblid_cliente)
                            .addComponent(lblid_venta))
                        .addGap(48, 48, 48))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblfecha_venta)
                            .addComponent(lblnumero_factura))
                        .addGap(18, 18, 18)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtmonto_total)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnAgregar)
                        .addGap(18, 18, 18)
                        .addComponent(btnModificar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEliminar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnNuevo)
                        .addGap(22, 22, 22))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtid_venta)
                            .addComponent(txtid_cliente)
                            .addComponent(txtfecha_venta, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
                            .addComponent(txtnumero_factura))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 533, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblid_venta)
                    .addComponent(txtid_venta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblid_cliente)
                    .addComponent(txtid_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblfecha_venta)
                    .addComponent(txtfecha_venta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblnumero_factura)
                    .addComponent(txtnumero_factura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblmonto_total)
                            .addComponent(txtmonto_total, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAgregar)
                            .addComponent(btnModificar)
                            .addComponent(btnEliminar)
                            .addComponent(btnNuevo))))
                .addContainerGap(259, Short.MAX_VALUE))
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

    private void TablaDatosVentaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaDatosVentaMouseClicked
       try{
            fila = TablaDatosVenta.getSelectedRow();
            if(fila == -1){
                JOptionPane.showMessageDialog(null, "Venta no seleccionado");
            }else{
                String idVenta=(String)TablaDatosVenta.getValueAt(fila,0).toString();
                String idCliente=(String)TablaDatosVenta.getValueAt(fila,1).toString();
                Date fechaVenta=(Date)TablaDatosVenta.getValueAt(fila,2);
                String numeroFactura=(String)TablaDatosVenta.getValueAt(fila,3);
                String montoTotal=(String)TablaDatosVenta.getValueAt(fila,4);                
                this.txtid_venta.setText(idVenta);
                this.txtid_cliente.setText(idCliente);
                 //Fecha
                this.txtfecha_venta.setDate(fechaVenta);   
                this.txtnumero_factura.setText(numeroFactura);
                this.txtmonto_total.setText(montoTotal);
            }
        }catch(Exception e){
            Util.printException("fventa_1.TablaDatosAccesoMouseClicked", e);
        }      
    }//GEN-LAST:event_TablaDatosVentaMouseClicked

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
            java.util.logging.Logger.getLogger(fventa_1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(fventa_1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(fventa_1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(fventa_1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new fventa_1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TablaDatosVenta;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblfecha_venta;
    private javax.swing.JLabel lblid_cliente;
    private javax.swing.JLabel lblid_venta;
    private javax.swing.JLabel lblmonto_total;
    private javax.swing.JLabel lblnumero_factura;
    private com.toedter.calendar.JDateChooser txtfecha_venta;
    private javax.swing.JTextField txtid_cliente;
    private javax.swing.JTextField txtid_venta;
    private javax.swing.JTextField txtmonto_total;
    private javax.swing.JTextField txtnumero_factura;
    // End of variables declaration//GEN-END:variables


    private void limpiaCampos() {
        try{
            this.txtid_venta.setText("");
            this.txtid_cliente.setText("");
            this.txtfecha_venta.setDate(new Date());
            this.txtnumero_factura.setText("");
            this.txtmonto_total.setText("");
        }catch(Exception e){
            Util.printException("fventa_1.limpiaCampos", e);
        }                
    }
    
    
    public void limpiaTabla(){
        int filaRestante=0;
        try{
            if(TablaDatosVenta.getRowCount() > 0){
                for(int i=0;i<=TablaDatosVenta.getRowCount();i++){
                    modelo.removeRow(i);
                    i = i - 1;
                    filaRestante=modelo.getRowCount();
                    if(filaRestante==0){
                        break;
                    }
                }
            }
        }catch(Exception e){
            Util.printException("fventa_1.limpiaTabla", e);
        }        
    }

    private void llenaListado() {
        List<venta> listaVentas = null;
        
        try{
            vDAO = new ventaDAO();
            listaVentas = new ArrayList<>();
            listaVentas = vDAO.seleccionaTodo();

            Object[]pObj=new Object[5];

            modelo = (DefaultTableModel)TablaDatosVenta.getModel();

            for(venta p:listaVentas){
                pObj[0] = p.getId_venta();
                pObj[1] = p.getId_cliente();
                pObj[2] = p.getFecha_venta();
                pObj[3] = p.getNumero_factura();
                pObj[4] = p.getMonto_total();                
                modelo.addRow(pObj);
            }
            TablaDatosVenta.setModel(modelo);
        }catch(Exception e){
            Util.printException("fventa_1.llenaListado", e);
        }
    }

    
    
    private void agregar(){
        
        try{
            miVenta = new venta(Util.str2int( this.txtid_venta.getText() ),
                                Util.str2int( this.txtid_cliente.getText() ),
                                this.txtfecha_venta.getDate() ,
                                this.txtnumero_factura.getText(),
                                Util.str2double( this.txtmonto_total.getText() ) );

            if ( vDAO.inserta(miVenta) ){
                JOptionPane.showMessageDialog(null, "Venta ingresado");
                limpiaTabla();
                limpiaCampos();
                llenaListado();
            }
                    
            
        }catch(Exception e){
            Util.printException("fventa_1.agregar", e);
        }
    }
    
    private void modificar(){
        try{
            miVenta = new venta(Util.str2int( this.txtid_venta.getText() ),
                                Util.str2int( this.txtid_cliente.getText() ),
                                this.txtfecha_venta.getDate() ,
                                this.txtnumero_factura.getText(),
                                Util.str2double( this.txtmonto_total.getText() ) );
            
            if ( vDAO.actualiza(miVenta) ){
                JOptionPane.showMessageDialog(null, "Venta actualizado");
                limpiaTabla();
                limpiaCampos();
                llenaListado();
            }

        }catch(Exception e){
            Util.printException("fventa_1.modificar", e);
        }
    }
    
    

    private void eliminar(){
        try{        
            fila = TablaDatosVenta.getSelectedRow();
            if(fila == -1){
                JOptionPane.showMessageDialog(null, "Debe seleccionar fila");
            }else{
                if ( vDAO.elimina( Util.str2int((String)TablaDatosVenta.getValueAt(fila,0).toString()) ) ){
                    JOptionPane.showMessageDialog(null, "Venta eliminado");
                    limpiaTabla();
                    limpiaCampos();
                    llenaListado();
                }
            }
        }catch(Exception e){
            Util.printException("fventa_1.eliminar", e);
        }        
    }    
  
}
