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
public class marca_productoDAO {
    private ConectaBD cbd = null;
    private static final String cnSQLTabla="producto";   
    private static final String cnSQLInserta=" INSERT INTO "+cnSQLTabla+" (id_producto, nombre_producto, id_tipo_producto, id_marca_producto) values (?, ?, ?, ?, ?, ?, ?)";
    private static final String cnSQLSeleccionaPorID=" SELECT id_producto, nombre_producto, id_tipo_producto, id_marca_producto FROM "+cnSQLTabla+" WHERE id_producto = ? ";
    private static final String cnSQLSeleccionaTodo=" SELECT id_producto, nombre_producto, id_tipo_producto, id_marca_producto FROM "+cnSQLTabla+"  ";
    private static final String cnSQLEliminaPorID=" delete FROM "+cnSQLTabla+" WHERE id_producto = ? ";
    private static final String cnSQLActualizaPorID=" update "+cnSQLTabla+" set nombre_producto = ?, id_tipo_producto = ?, id_marca_producto = ? WHERE id_producto = ? ";

    
    public marca_productoDAO() throws Exception {
        cbd = new ConectaBD();
    }

    
    public void inserta(producto prod){
    
        PreparedStatement ps = null;
        try {
            ps = cbd.getConexion().prepareStatement(cnSQLInserta);
            ps.setInt(1, prod.getId_producto());
            ps.setString(2, prod.getNombre_producto());
            ps.setInt(3, prod.getId_tipo_producto());
            ps.setInt(4, prod.getId_marca_producto());

            //rs=ps.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(personaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
        
    
    public List<producto> seleccionaTodo(){
        List<producto> listaProductos=null;
        PreparedStatement ps = null;
        ResultSet rs=null;
        
        try {
            listaProductos=new ArrayList<>();
            ps = cbd.getConexion().prepareStatement(cnSQLSeleccionaTodo);
            rs=ps.executeQuery();
            while(rs.next()){
                listaProductos.add( new producto(   rs.getInt("id_producto"), 
                                                    rs.getString("nombre_producto"), 
                                                    rs.getInt("id_tipo_producto"), 
                                                    rs.getInt("id_marca_producto") ));
            }
            
        } catch (Exception ex) {
            Logger.getLogger(personaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaProductos;
       
    }
    
    
    public producto seleccionaPorID(int IDProducto){
        
        producto nuevoProd=null;
        PreparedStatement ps = null;
        ResultSet rs=null;
        
        try {
            ps = cbd.getConexion().prepareStatement(cnSQLSeleccionaPorID);
            ps.setInt(1, IDProducto);
            rs=ps.executeQuery();
            while(rs.next()){
                nuevoProd = new producto(   rs.getInt("id_producto"), 
                                            rs.getString("nombre_producto"), 
                                            rs.getInt("id_tipo_producto"), 
                                            rs.getInt("id_marca_producto") );
            }
            
        } catch (Exception ex) {
            Logger.getLogger(personaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return nuevoProd;
       
    }
    
    
    public boolean elimina(int IDProducto){
        
        boolean filaEliminada=false;
        PreparedStatement ps = null;
        
        try {
            ps = cbd.getConexion().prepareStatement(cnSQLEliminaPorID);
            ps.setInt(1, IDProducto);
            filaEliminada=( ps.executeUpdate() > 0);
            
        } catch (Exception ex) {
            Logger.getLogger(personaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return filaEliminada;
       
    }

    
    public boolean actualiza(producto prod){
        boolean filaActualizada=false;
        PreparedStatement ps = null;
        try {
            ps = cbd.getConexion().prepareStatement(cnSQLActualizaPorID);
            ps.setString(1, prod.getNombre_producto());
            ps.setInt(2, prod.getId_tipo_producto());
            ps.setInt(3, prod.getId_marca_producto());
            ps.setInt(4, prod.getId_producto());            
       
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
