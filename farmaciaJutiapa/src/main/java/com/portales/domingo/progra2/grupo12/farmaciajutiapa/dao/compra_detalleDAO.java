/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.portales.domingo.progra2.grupo12.farmaciajutiapa.dao;

import com.portales.domingo.progra2.grupo12.farmaciajutiapa.controlador.ConectaBD;
import com.portales.domingo.progra2.grupo12.farmaciajutiapa.modelo.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author josea
 */
public class compra_detalleDAO {

    private ConectaBD cbd = null;
    private static final String cnSQLTabla="compra_detalle";   
    private static final String cnSQLInserta=" INSERT INTO "+cnSQLTabla+" (id_compra, id_marca_producto, id_tipo_producto, id_producto, precio_unitario_compra, cantidad ) values ( ?, ?, ?, ?, ?, ?)";
    private static final String cnSQLSeleccionaPorID=" SELECT id_compra_detalle, id_compra, id_marca_producto, id_tipo_producto, id_producto, precio_unitario_compra, cantidad FROM "+cnSQLTabla+" WHERE id_compra_detalle = ? ";
    private static final String cnSQLSeleccionaTodo=" SELECT id_compra_detalle, id_compra, id_marca_producto, id_tipo_producto, id_producto, precio_unitario_compra, cantidad FROM "+cnSQLTabla+"  ";
    private static final String cnSQLEliminaPorID=" delete FROM "+cnSQLTabla+" WHERE id_compra_detalle = ? ";
    private static final String cnSQLActualizaPorID=" update "+cnSQLTabla+" set id_compra_detalle = ?, id_compra= ?, id_marca_producto= ?, id_tipo_producto= ?, id_producto= ?, precio_unitario_compra= ?, cantidad= ? WHERE id_compra_detalle = ? ";

    
    public compra_detalleDAO() throws Exception {
        cbd = new ConectaBD();
    }

    
    public void inserta(compra_detalle comDe){
    
        PreparedStatement ps = null;
        try {
            ps = cbd.getConexion().prepareStatement(cnSQLInserta);  
            ps.setInt(1, comDe.getId_compra());
            ps.setInt(2, comDe.getId_marca_producto());
            ps.setDouble(3, comDe.getId_tipo_producto());
            ps.setInt(4, comDe.getId_producto());
             ps.setDouble(5, comDe.getPrecio_unitario_compra());
             ps.setInt(6, comDe.getCantidad());
              ps.setInt(7, comDe.getId_compra_detalle());
            
        } catch (SQLException ex) {
            Logger.getLogger(personaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
        
    
    public List<compra_detalle> seleccionaTodo(){
        List<compra_detalle> listaCompraD=null;
        compra_detalle nuevap=null;
        PreparedStatement ps = null;
        ResultSet rs=null;
        
        try {
            listaCompraD=new ArrayList<>();
            ps = cbd.getConexion().prepareStatement(cnSQLSeleccionaTodo);
            rs=ps.executeQuery();
            while(rs.next()){
                listaCompraD.add( new compra_detalle(     rs.getInt("id_compra_detalle"), 
                                                    rs.getInt("id_compra"), 
                                                    rs.getInt("id_marca_producto"), 
                                                    rs.getInt("id_tipo_producto"), 
                                                    rs.getInt("id_producto"), 
                                                    rs.getDouble("precio_unitario_compra"), 
                                                    rs.getInt("cantidad ")));
                                                    
            }
            
        } catch (Exception ex) {
            Logger.getLogger(personaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaCompraD;
       
    }
    
    
    public compra_detalle seleccionaPorID(int IDCompraD){
        
        compra_detalle nuevap=null;
        PreparedStatement ps = null;
        ResultSet rs=null;
        
        try {
            ps = cbd.getConexion().prepareStatement(cnSQLSeleccionaPorID);
            ps.setInt(1, IDCompraD);
            rs=ps.executeQuery();
            while(rs.next()){
                nuevap = new compra_detalle(    rs.getInt("id_compra_detalle"), 
                                                    rs.getInt("id_compra"), 
                                                    rs.getInt("id_marca_producto"), 
                                                    rs.getInt("id_tipo_producto"), 
                                                    rs.getInt("id_producto"), 
                                                    rs.getDouble("precio_unitario_compra"), 
                                                    rs.getInt("cantidad "));
            }
            
        } catch (Exception ex) {
            Logger.getLogger(personaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return nuevap;
       
    }
    
    
    public boolean elimina(int IDCompraD){
        
        boolean filaEliminada=false;
        PreparedStatement ps = null;
        
        try {
            ps = cbd.getConexion().prepareStatement(cnSQLEliminaPorID);
            ps.setInt(1, IDCompraD);
            filaEliminada=( ps.executeUpdate() > 0);
            
        } catch (Exception ex) {
            Logger.getLogger(personaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return filaEliminada;
       
    }

    
    public boolean actualiza(compra_detalle comDe){
        boolean filaActualizada=false;
        PreparedStatement ps = null;
        try {
            ps = cbd.getConexion().prepareStatement(cnSQLActualizaPorID);
           ps = cbd.getConexion().prepareStatement(cnSQLInserta);  
            ps.setInt(1, comDe.getId_compra());
            ps.setInt(2, comDe.getId_marca_producto());
            ps.setDouble(3, comDe.getId_tipo_producto());
            ps.setInt(4, comDe.getId_producto());
             ps.setDouble(5, comDe.getPrecio_unitario_compra());
             ps.setInt(6, comDe.getCantidad());
              ps.setInt(7, comDe.getId_compra_detalle());
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
