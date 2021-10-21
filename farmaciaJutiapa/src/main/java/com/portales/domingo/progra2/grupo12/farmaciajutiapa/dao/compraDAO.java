/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.portales.domingo.progra2.grupo12.farmaciajutiapa.dao;

import com.portales.domingo.progra2.grupo12.farmaciajutiapa.controlador.ConectaBD;
import com.portales.domingo.progra2.grupo12.farmaciajutiapa.controlador.Util;
import com.portales.domingo.progra2.grupo12.farmaciajutiapa.modelo.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author josea
 */
public class compraDAO {

    private ConectaBD cbd = null;
    private static final String cnSQLTabla="compra";   
    private static final String cnSQLInserta=" INSERT INTO "+cnSQLTabla+" (id_proveedor, fecha_compra, numero_factura, monto_total) values (?, ?, ?, ?)";
    private static final String cnSQLSeleccionaPorID=" SELECT id_compra, id_proveedor, fecha_compra, numero_factura, monto_total FROM "+cnSQLTabla+" WHERE id_cliente = ? ";
    private static final String cnSQLSeleccionaTodo=" SELECT id_compra, id_proveedor, fecha_compra, numero_factura, monto_total FROM "+cnSQLTabla+"  ";
    private static final String cnSQLEliminaPorID=" delete FROM "+cnSQLTabla+" WHERE id_persona = ? ";
    private static final String cnSQLActualizaPorID=" update "+cnSQLTabla+" set id_compra= ?, id_proveedor= ?, fecha_compra= ?, numero_factura= ?, monto_total= ? WHERE id_compra = ? ";

    /***
     * Constructor compraDAO
     * @throws Exception 
     */    
    public compraDAO() throws Exception {
        cbd = new ConectaBD();
    }

     /***
     * Inserta un registro en la tabla acceso
     * @param acc - objeto de la clase "acceso"
     * @return verdadero, si inserto correctamente en la tabla acceso
     */   
    public boolean inserta(compra com){
        boolean filaInsertada=false;
        PreparedStatement ps = null;
        try {
            if ( validaCampos(com) ){
                ps = cbd.getConexion().prepareStatement(cnSQLInserta);
                ps.setInt(1, com.getId_proveedor());
                ps.setDate(2, Util.utilDate2sqlDate(com.getFecha_compra())); 
                ps.setString(3, com.getNumero_factura());
                ps.setDouble(4, com.getMonto_total());
                filaInsertada= ( ps.executeUpdate() >0) ;
            }
        } catch (SQLException ex) {
            Util.printSQLException("compraDAO.inserta", ex);
        } catch (Exception e) {
            Util.printException("compraDAO.inserta", e);
        }
        return filaInsertada;
    }
        
    /***
     * Selecciona todos los registros de la tabla acceso
     * @return 
     */
    public List<compra> seleccionaTodo(){
        List<compra> listaCompra=null;
        PreparedStatement ps = null;
        ResultSet rs=null;
        
        try {
            listaCompra=new ArrayList<>();
            ps = cbd.getConexion().prepareStatement(cnSQLSeleccionaTodo);
            rs=ps.executeQuery();
            while(rs.next()){
                listaCompra.add( new compra(    rs.getInt("id_compra"), 
                                                rs.getInt("id_proveedor"), 
                                                rs.getDate("fecha_compra"), 
                                                rs.getString("numero_factura"), 
                                                rs.getDouble("monto_total")));
            }
        } catch (SQLException ex) {
            Util.printSQLException("compraDAO.seleccionaTodo", ex);
        } catch (Exception e) {
            Util.printException("compraDAO.seleccionaTodo", e);
        }
        return listaCompra;
       
    }
    
    /***
     * Selecciona un acceso, según su ID
     * @param IDAcceso
     * @return 
     */    
    public compra seleccionaPorID(int IDCompra){
        compra nuevaCompra=null;
        PreparedStatement ps = null;
        ResultSet rs=null;
        
        try {
            ps = cbd.getConexion().prepareStatement(cnSQLSeleccionaPorID);
            ps.setInt(1, IDCompra);
            rs=ps.executeQuery();
            while(rs.next()){
                nuevaCompra = new compra(   rs.getInt("id_compra"), 
                                            rs.getInt("id_proveedor"), 
                                            rs.getDate("fecha_compra"), 
                                            rs.getString("numero_factura"), 
                                            rs.getDouble("monto_total"));
            }
        } catch (SQLException ex) {
            Util.printSQLException("compraDAO.seleccionaPorID", ex);
        } catch (Exception e) {
            Util.printException("compraDAO.seleccionaPorID", e);
        }
        return nuevaCompra;
       
    }
    
    
    /***
     * Elimina el acceso con el ID enviado.
     * @param IDAcceso
     * @return 
     */    
    public boolean elimina(int IDCompra){
        boolean filaEliminada=false;
        PreparedStatement ps = null;
        
        try {
            ps = cbd.getConexion().prepareStatement(cnSQLEliminaPorID);
            ps.setInt(1, IDCompra);
            filaEliminada=( ps.executeUpdate() > 0);
            
        } catch (SQLException ex) {
            Util.printSQLException("compraDAO.elimina", ex);
        } catch (Exception e) {
            Util.printException("compraDAO.elimina", e);
        }
        return filaEliminada;
       
    }

    /***
     * Modifica la informacion del acceso enviado por parametro.
     * @param acc
     * @return 
     */
    public boolean actualiza(compra com){
        boolean filaActualizada=false;
        PreparedStatement ps = null;
        try {
            if ( validaCampos(com) ){
                ps.setInt(1, com.getId_proveedor());
                ps.setDate(2, Util.utilDate2sqlDate(com.getFecha_compra()));
                ps.setString(3, com.getNumero_factura());
                ps.setDouble(4, com.getMonto_total());
                ps.setInt(5, com.getId_compra());
            }            
        } catch (SQLException ex) {
            Util.printSQLException("compraDAO.actualiza", ex);
        } catch (Exception e) {
            Util.printException("compraDAO.actualiza", e);
        }
        
        return filaActualizada;
       
    }

    /***
     * Cierra las conexiones a BD
     */
    public void cierra() {
        try {
            if(cbd!=null)
                cbd.closeDB();
        } catch (Exception e) {
            Util.printException("compraDAO.cierra", e);
        }        
    }
  

    public boolean validaCampos(compra com) {
        boolean camposValidos=false;
        try {
            if( com.getId_proveedor() <= 0 ) {
                JOptionPane.showMessageDialog(null, "PROVEEDOR no debe ir vacio o a cero");
            }/*else if( com.getFecha_compra() <= 0 ) {
                JOptionPane.showMessageDialog(null, "FECHA DE COMPRA no debe ir vacio o a cero");
            }*/else if( com.getNumero_factura().toString().trim().equals("") ) {
                JOptionPane.showMessageDialog(null, "NUMERO FACTURA no debe ir vacio o a cero");
            }else if( com.getMonto_total() <= 0 ) {
                JOptionPane.showMessageDialog(null, "MONTO TOTAL no debe ir vacio o a cero");
            }else 
                camposValidos = true;

        } catch (Exception e) {
            Util.printException("compraDAO.validaCampos", e);
        }
        return camposValidos;
    }
}
