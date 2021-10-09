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
public class tipo_productoDAO {

    private ConectaBD cbd = null;
    private static final String cnSQLTabla="tipo_producto";   
    private static final String cnSQLInserta=" INSERT INTO "+cnSQLTabla+" (nombre_tipo_producto) values (?)";
    private static final String cnSQLSeleccionaPorID=" SELECT id_tipo_producto, nombre_tipo_producto FROM "+cnSQLTabla+" WHERE id_tipo_producto = ? ";
    private static final String cnSQLSeleccionaTodo=" SELECT id_tipo_producto, nombre_tipo_producto FROM "+cnSQLTabla+"  ";
    private static final String cnSQLEliminaPorID=" delete FROM "+cnSQLTabla+" WHERE id_tipo_producto = ? ";
    private static final String cnSQLActualizaPorID=" update "+cnSQLTabla+" set nombre_tipo_producto= ? WHERE id_tipo_producto = ? ";

    
    public tipo_productoDAO() throws Exception {
        cbd = new ConectaBD();
    }

    
    public void inserta(tipo_producto tipPro){
    
        PreparedStatement ps = null;
        try {
            ps = cbd.getConexion().prepareStatement(cnSQLInserta);
            ps.setString(1, tipPro.getNombre_tipo_producto());
            ps.setInt(2, tipPro.getId_tipo_producto());
            
        } catch (SQLException ex) {
            Logger.getLogger(personaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
        
    
    public List<tipo_producto> seleccionaTodo(){
        List<tipo_producto> listaTipo_pro=null;
        tipo_producto nuevap=null;
        PreparedStatement ps = null;
        ResultSet rs=null;
        
        try {
            listaTipo_pro=new ArrayList<>();
            ps = cbd.getConexion().prepareStatement(cnSQLSeleccionaTodo);
            rs=ps.executeQuery();
            while(rs.next()){
                listaTipo_pro.add( new tipo_producto(     rs.getInt("id_tipo_producto"), 
                                                          rs.getString("nombre_tipo_producto")));
                                                    
            }
            
        } catch (Exception ex) {
            Logger.getLogger(personaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaTipo_pro;
       
    }
    
    
    public tipo_producto seleccionaPorID(int IDTipPro){
        
        tipo_producto nuevap=null;
        PreparedStatement ps = null;
        ResultSet rs=null;
        
        try {
            ps = cbd.getConexion().prepareStatement(cnSQLSeleccionaPorID);
            ps.setInt(1, IDTipPro);
            rs=ps.executeQuery();
            while(rs.next()){
                nuevap = new tipo_producto(   rs.getInt("id_tipo_producto"), 
                                              rs.getString("nombre_tipo_producto"));
            }
            
        } catch (Exception ex) {
            Logger.getLogger(personaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return nuevap;
       
    }
    
    
    public boolean elimina(int IDTipPro){
        
        boolean filaEliminada=false;
        PreparedStatement ps = null;
        
        try {
            ps = cbd.getConexion().prepareStatement(cnSQLEliminaPorID);
            ps.setInt(1, IDTipPro);
            filaEliminada=( ps.executeUpdate() > 0);
            
        } catch (Exception ex) {
            Logger.getLogger(personaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return filaEliminada;
       
    }

    
    public boolean actualiza(tipo_producto tipPro){
        boolean filaActualizada=false;
        PreparedStatement ps = null;
        try {
            ps = cbd.getConexion().prepareStatement(cnSQLActualizaPorID);
            ps.setString(1, tipPro.getNombre_tipo_producto());
            ps.setInt(2, tipPro.getId_tipo_producto());
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
