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
public class venta_detalleDAO {

    private ConectaBD cbd = null;
    private static final String cnSQLTabla="venta_detalle";   
    private static final String cnSQLInserta=" INSERT INTO "+cnSQLTabla+" (id_venta, id_marca_producto, id_tipo_producto, id_producto, precio_unitario_venta, cantidad) values (?, ?, ?, ?, ?, ?)";
    private static final String cnSQLSeleccionaPorID=" SELECT id_venta_detalle, id_venta, id_marca_producto, id_tipo_producto, id_producto, precio_unitario_venta, cantidad FROM "+cnSQLTabla+" WHERE id_venta_detalle = ? ";
    private static final String cnSQLSeleccionaTodo=" SELECT id_venta_detalle, id_venta, id_marca_producto, id_tipo_producto, id_producto, precio_unitario_venta, cantidad FROM "+cnSQLTabla+"  ";
    private static final String cnSQLEliminaPorID=" delete FROM "+cnSQLTabla+" WHERE id_venta_detalle = ? ";
    private static final String cnSQLActualizaPorID=" update "+cnSQLTabla+" set id_venta= ?,id_marca_producto= ?, id_tipo_producto= ?, id_producto= ?, precio_unitario_venta = ?, cantidad= ? WHERE id_venta_detalle = ? ";

    
    public venta_detalleDAO() throws Exception {
        cbd = new ConectaBD();
    }

    
    public void inserta(venta_detalle vd){
    
        PreparedStatement ps = null;
        try {
            ps = cbd.getConexion().prepareStatement(cnSQLInserta);
            ps.setInt(1, vd.getId_venta());
            ps.setInt(2, vd.getId_marca_producto());
            ps.setInt(3, vd.getId_tipo_producto());
            ps.setInt(4, vd.getId_producto());
            ps.setDouble(5, vd.getPrecio_unitario_venta());
            ps.setInt(6, vd.getCantidad());
            ps.setInt(7, vd.getId_venta_detalle());
            //rs=ps.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(personaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
        
    
    public List<venta_detalle> seleccionaTodo(){
        List<venta_detalle> listaVentaD=null;
        venta_detalle nuevap=null;
        PreparedStatement ps = null;
        ResultSet rs=null;
        
        try {
            listaVentaD=new ArrayList<>();
            ps = cbd.getConexion().prepareStatement(cnSQLSeleccionaTodo);
            rs=ps.executeQuery();
            while(rs.next()){
                listaVentaD.add( new venta_detalle( rs.getInt("id_venta_detalle"), 
                                                    rs.getInt("id_venta"), 
                                                    rs.getInt("id_marca_producto"), 
                                                    rs.getInt("id_tipo_producto"), 
                                                    rs.getInt("id_producto"), 
                                                    rs.getDouble("precio_unitario_venta"), 
                                                    rs.getInt("cantidad")));
                                                  
            }
            
        } catch (Exception ex) {
            Logger.getLogger(personaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaVentaD;
       
    }
    
    
    public venta_detalle seleccionaPorID(int IDVentaDetalle){
        
        venta_detalle nuevap=null;
        PreparedStatement ps = null;
        ResultSet rs=null;
        
        try {
            ps = cbd.getConexion().prepareStatement(cnSQLSeleccionaPorID);
            ps.setInt(1, IDVentaDetalle);
            rs=ps.executeQuery();
            while(rs.next()){
                nuevap = new venta_detalle(         rs.getInt("id_venta_detalle"), 
                                                    rs.getInt("id_venta"), 
                                                    rs.getInt("id_marca_producto"), 
                                                    rs.getInt("id_tipo_producto"), 
                                                    rs.getInt("id_producto"), 
                                                    rs.getDouble("precio_unitario_venta"), 
                                                    rs.getInt("cantidad"));
            }
            
        } catch (Exception ex) {
            Logger.getLogger(personaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return nuevap;
       
    }
    
    
    public boolean elimina(int IDVentaDetalle){
        
        boolean filaEliminada=false;
        PreparedStatement ps = null;
        
        try {
            ps = cbd.getConexion().prepareStatement(cnSQLEliminaPorID);
            ps.setInt(1, IDVentaDetalle);
            filaEliminada=( ps.executeUpdate() > 0);
            
        } catch (Exception ex) {
            Logger.getLogger(personaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return filaEliminada;
       
    }

    
    public boolean actualiza(venta_detalle vd){
        boolean filaActualizada=false;
        PreparedStatement ps = null;
        try {
            ps = cbd.getConexion().prepareStatement(cnSQLActualizaPorID);
          ps.setInt(1, vd.getId_venta());
            ps.setInt(2, vd.getId_marca_producto());
            ps.setInt(3, vd.getId_tipo_producto());
            ps.setInt(4, vd.getId_producto());
            ps.setDouble(5, vd.getPrecio_unitario_venta());
            ps.setInt(6, vd.getCantidad());
            ps.setInt(7, vd.getId_venta_detalle());
            
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
