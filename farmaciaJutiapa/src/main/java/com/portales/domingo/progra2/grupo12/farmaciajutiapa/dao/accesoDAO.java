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
public class accesoDAO {
    private ConectaBD cbd = null;
    private static final String cnSQLTabla="acceso";   
    private static final String cnSQLInserta=" INSERT INTO "+cnSQLTabla+" (id_acceso, nombre_acceso, pagina_acceso) values (?, ?, ?)";
    private static final String cnSQLSeleccionaPorID=" SELECT id_acceso, nombre_acceso, pagina_acceso FROM "+cnSQLTabla+" WHERE id_acceso = ? ";
    private static final String cnSQLSeleccionaTodo=" SELECT id_acceso, nombre_acceso, pagina_acceso FROM "+cnSQLTabla+"  ";
    private static final String cnSQLEliminaPorID=" delete FROM "+cnSQLTabla+" WHERE id_acceso = ? ";
    private static final String cnSQLActualizaPorID=" update "+cnSQLTabla+" set nombre_acceso = ?, pagina_acceso = ? WHERE id_acceso = ? ";

    
    public accesoDAO() throws Exception {
        cbd = new ConectaBD();
    }

    
    public void inserta(acceso acc){
    
        PreparedStatement ps = null;
        try {
            ps = cbd.getConexion().prepareStatement(cnSQLInserta);
            ps.setInt(1, acc.getId_acceso());
            ps.setString(2, acc.getNombre_acceso());
            ps.setString(3, acc.getPagina_acceso());
          

            //rs=ps.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(personaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
        
    
    public List<acceso> seleccionaTodo(){
        List<acceso> listaAccesos=null;
        PreparedStatement ps = null;
        ResultSet rs=null;
        
        try {
            listaAccesos=new ArrayList<>();
            ps = cbd.getConexion().prepareStatement(cnSQLSeleccionaTodo);
            rs=ps.executeQuery();
            while(rs.next()){
                listaAccesos.add( new acceso(   rs.getInt("id_acceso"), 
                                                    rs.getString("nombre_acceso"), 
                                                    rs.getString("pagina_acceso")));
                                                    
            }
            
        } catch (Exception ex) {
            Logger.getLogger(personaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaAccesos;
       
    }
    
    
    public acceso seleccionaPorID(int IDAcceso){
        
        acceso nuevoAcceso=null;
        PreparedStatement ps = null;
        ResultSet rs=null;
        
        try {
            ps = cbd.getConexion().prepareStatement(cnSQLSeleccionaPorID);
            ps.setInt(1, IDAcceso);
            rs=ps.executeQuery();
            while(rs.next()){
                nuevoAcceso = new acceso(   rs.getInt("id_acceso"), 
                                                    rs.getString("nombre_acceso"), 
                                                    rs.getString("pagina_acceso"));
            }
            
        } catch (Exception ex) {
            Logger.getLogger(personaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return nuevoAcceso;
       
    }
    
    
    public boolean elimina(int IDAcceso){
        
        boolean filaEliminada=false;
        PreparedStatement ps = null;
        
        try {
            ps = cbd.getConexion().prepareStatement(cnSQLEliminaPorID);
            ps.setInt(1, IDAcceso);
            filaEliminada=( ps.executeUpdate() > 0);
            
        } catch (Exception ex) {
            Logger.getLogger(personaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return filaEliminada;
       
    }

    
    public boolean actualiza(acceso acc){
        boolean filaActualizada=false;
        PreparedStatement ps = null;
        try {
            ps = cbd.getConexion().prepareStatement(cnSQLActualizaPorID);
           
            ps.setString(1, acc.getNombre_acceso());
            ps.setString(2, acc.getPagina_acceso());  
            ps.setInt(3, acc.getId_acceso());
       
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
