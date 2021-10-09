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
public class acceso_rolDAO {
    private ConectaBD cbd = null;
    private static final String cnSQLTabla="acceso_rol";   
    private static final String cnSQLInserta=" INSERT INTO "+cnSQLTabla+" (id_acceso, id_rol) values (?, ?)";
    private static final String cnSQLSeleccionaPorID=" SELECT id_acceso_rol, id_acceso, id_rol FROM "+cnSQLTabla+" WHERE id_acceso_rol = ? ";
    private static final String cnSQLSeleccionaTodo=" SELECT id_acceso_rol, id_acceso, id_rol FROM "+cnSQLTabla+"  ";
    private static final String cnSQLEliminaPorID=" delete FROM "+cnSQLTabla+" WHERE id_acceso_rol = ? ";
    private static final String cnSQLActualizaPorID=" update "+cnSQLTabla+" set id_acceso = ?, id_rol = ? WHERE id_acceso_rol = ? ";

    
    public acceso_rolDAO() throws Exception {
        cbd = new ConectaBD();
    }

    
    public void inserta(acceso_rol accRol){
    
        PreparedStatement ps = null;
        try {
            ps = cbd.getConexion().prepareStatement(cnSQLInserta);
            ps.setInt(1, accRol.getId_acceso());
            ps.setInt(2, accRol.getId_rol());
            ps.setInt(3, accRol.getId_acceso_rol());
            

            //rs=ps.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(personaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
        
    
    public List<acceso_rol> seleccionaTodo(){
        List<acceso_rol> listadoRol=null;
        PreparedStatement ps = null;
        ResultSet rs=null;
        
        try {
            listadoRol=new ArrayList<>();
            ps = cbd.getConexion().prepareStatement(cnSQLSeleccionaTodo);
            rs=ps.executeQuery();
            while(rs.next()){
                listadoRol.add( new acceso_rol(   rs.getInt("id_acceso_rol"), 
                                                    rs.getInt("id_acceso"), 
                                                    rs.getInt("id_rol")));
                                                   
            }
            
        } catch (Exception ex) {
            Logger.getLogger(personaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listadoRol;
       
    }
    
    
    public acceso_rol seleccionaPorID(int IDRol){
        
        acceso_rol nuevoProd=null;
        PreparedStatement ps = null;
        ResultSet rs=null;
        
        try {
            ps = cbd.getConexion().prepareStatement(cnSQLSeleccionaPorID);
            ps.setInt(1, IDRol);
            rs=ps.executeQuery();
            while(rs.next()){
                nuevoProd = new acceso_rol(   rs.getInt("id_acceso_rol"), 
                                                    rs.getInt("id_acceso"), 
                                                    rs.getInt("id_rol"));
            }
            
        } catch (Exception ex) {
            Logger.getLogger(personaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return nuevoProd;
       
    }
    
    
    public boolean elimina(int IDRol){
        
        boolean filaEliminada=false;
        PreparedStatement ps = null;
        
        try {
            ps = cbd.getConexion().prepareStatement(cnSQLEliminaPorID);
            ps.setInt(1, IDRol);
            filaEliminada=( ps.executeUpdate() > 0);
            
        } catch (Exception ex) {
            Logger.getLogger(personaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return filaEliminada;
       
    }

    
    public boolean actualiza(acceso_rol accRol){
        boolean filaActualizada=false;
        PreparedStatement ps = null;
        try {
            ps = cbd.getConexion().prepareStatement(cnSQLActualizaPorID);
             ps.setInt(1, accRol.getId_acceso());
            ps.setInt(2, accRol.getId_rol());
            ps.setInt(3, accRol.getId_acceso_rol());          
       
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
