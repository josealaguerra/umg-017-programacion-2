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
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

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

    
    public compraDAO() throws Exception {
        cbd = new ConectaBD();
    }

    
    public void inserta(compra com){
    
        PreparedStatement ps = null;
        try {
            ps = cbd.getConexion().prepareStatement(cnSQLInserta);
            ps.setInt(1, com.getId_proveedor());
            ps.setDate(2, Util.utilDate2sqlDate(com.getFecha_compra())); 
            ps.setString(3, com.getNumero_factura());
            ps.setDouble(4, com.getMonto_total());
            ps.setInt(5, com.getId_compra());
//           
        } catch (SQLException ex) {
            Logger.getLogger(personaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
        
    
    public List<compra> seleccionaTodo(){
        List<compra> listaCompra=null;
        compra nuevap=null;
        PreparedStatement ps = null;
        ResultSet rs=null;
        
        try {
            listaCompra=new ArrayList<>();
            ps = cbd.getConexion().prepareStatement(cnSQLSeleccionaTodo);
            rs=ps.executeQuery();
            while(rs.next()){
                listaCompra.add( new compra(     rs.getInt("id_compra"), 
                                                    rs.getInt("id_proveedor"), 
                                                    rs.getDate("fecha_compra"), 
                                                    rs.getString("numero_factura"), 
                                                    rs.getDouble("monto_total")));
                                                    
            }
            
        } catch (Exception ex) {
            Logger.getLogger(personaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaCompra;
       
    }
    
    
    public compra seleccionaPorID(int IDCompra){
        
        compra nuevap=null;
        PreparedStatement ps = null;
        ResultSet rs=null;
        
        try {
            ps = cbd.getConexion().prepareStatement(cnSQLSeleccionaPorID);
            ps.setInt(1, IDCompra);
            rs=ps.executeQuery();
            while(rs.next()){
                nuevap = new compra(   rs.getInt("id_compra"), 
                                                    rs.getInt("id_proveedor"), 
                                                    rs.getDate("fecha_compra"), 
                                                    rs.getString("numero_factura"), 
                                                    rs.getDouble("monto_total"));
            }
            
        } catch (Exception ex) {
            Logger.getLogger(personaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return nuevap;
       
    }
    
    
    public boolean elimina(int IDCompra){
        
        boolean filaEliminada=false;
        PreparedStatement ps = null;
        
        try {
            ps = cbd.getConexion().prepareStatement(cnSQLEliminaPorID);
            ps.setInt(1, IDCompra);
            filaEliminada=( ps.executeUpdate() > 0);
            
        } catch (Exception ex) {
            Logger.getLogger(personaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return filaEliminada;
       
    }

    
    public boolean actualiza(compra com){
        boolean filaActualizada=false;
        PreparedStatement ps = null;
        try {
           ps.setInt(1, com.getId_proveedor());
            ps.setDate(2, Util.utilDate2sqlDate(com.getFecha_compra())); 
            ps.setString(3, com.getNumero_factura());
            ps.setDouble(4, com.getMonto_total());
            ps.setInt(5, com.getId_compra());
        } catch (SQLException ex) {
            Logger.getLogger(personaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return filaActualizada;
       
    }

    
    private void printSQLException(SQLException ex){
        for(Throwable e:ex){
            if(e instanceof SQLException){
                e.printStackTrace(System.err);
                System.err.println("SQL State");
                
            }
                
        }
    }
    

}
