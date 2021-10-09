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
public class rolDAO {

    private ConectaBD cbd = null;
    private static final String cnSQLTabla="rol";   
    private static final String cnSQLInserta=" INSERT INTO "+cnSQLTabla+" (nombre_rol) values (?)";
    private static final String cnSQLSeleccionaPorID=" SELECT id_rol, nombre_rol FROM "+cnSQLTabla+" WHERE id_rol = ? ";
    private static final String cnSQLSeleccionaTodo=" SELECT id_rol, nombre_rol FROM "+cnSQLTabla+"  ";
    private static final String cnSQLEliminaPorID=" delete FROM "+cnSQLTabla+" WHERE id_rol = ? ";
    private static final String cnSQLActualizaPorID=" update "+cnSQLTabla+" set nombre_rol= ? WHERE id_rol = ? ";

    
    public rolDAO() {
        cbd = new ConectaBD();
    }

    
    public void inserta(rol paramRol){
    
        PreparedStatement ps = null;
        try {
            ps = cbd.getConexion().prepareStatement(cnSQLInserta);
            ps.setString(1, paramRol.getNombre_rol());
            ps.setInt(2, paramRol.getId_rol());

            //rs=ps.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(personaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
        
    
    public List<rol> seleccionaTodo(){
        
        List<rol> listaRoles=null;
        PreparedStatement ps = null;
        ResultSet rs=null;
        
        try {
            listaRoles = new ArrayList<>();
            ps = cbd.getConexion().prepareStatement(cnSQLSeleccionaTodo);
            rs=ps.executeQuery();
            while(rs.next()){
                listaRoles.add( new rol( rs.getInt("id_rol"), rs.getString("nombre_rol") ) );
            }
            
        } catch (Exception ex) {
            Logger.getLogger(personaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaRoles;
       
    }
    
    
    public rol seleccionaPorID(int IDRol){
        
        rol nuevoRol=null;
        PreparedStatement ps = null;
        ResultSet rs=null;
        
        try {
            ps = cbd.getConexion().prepareStatement(cnSQLSeleccionaPorID);
            ps.setInt(1, IDRol);
            rs=ps.executeQuery();
            while(rs.next()){
                nuevoRol = new rol( rs.getInt("id_rol"), rs.getString("nombre_rol")  );
            }
            
        } catch (Exception ex) {
            Logger.getLogger(personaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return nuevoRol;
       
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

    
    public boolean actualiza(rol paramRol){
        boolean filaActualizada=false;
        PreparedStatement ps = null;
        try {
            ps = cbd.getConexion().prepareStatement(cnSQLActualizaPorID);
            ps.setString(1, paramRol.getNombre_rol());
            ps.setInt(2, paramRol.getId_rol());

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
