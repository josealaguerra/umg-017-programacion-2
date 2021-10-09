/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.portales.domingo.progra2.grupo12.farmaciajutiapa.dao;

import com.portales.domingo.progra2.grupo12.farmaciajutiapa.modelo.*;
import com.portales.domingo.progra2.grupo12.farmaciajutiapa.controlador.ConectaBD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author josea
 */
public class estado_civilDAO {
    private ConectaBD cbd = null;
    private static final String cnSQLTabla="estado_civil";   
    private static final String cnSQLInserta=" INSERT INTO "+cnSQLTabla+" (abreviatura_estado_civil,nombre_estado_civil) values (?,?)";
    private static final String cnSQLSeleccionaPorID=" SELECT id_estado_civil,abreviatura_estado_civil,nombre_estado_civil FROM "+cnSQLTabla+" WHERE id_estado_civil = ? ";
    private static final String cnSQLSeleccionaTodo=" SELECT id_estado_civil,abreviatura_estado_civil,nombre_estado_civil FROM "+cnSQLTabla+"  ";
    private static final String cnSQLEliminaPorID=" delete FROM "+cnSQLTabla+" WHERE id_estado_civil = ? ";
    private static final String cnSQLActualizaPorID=" update "+cnSQLTabla+" set id_estado_civil = ?, abreviatura_estado_civil = ?, nombre_estado_civil = ? WHERE id_estado_civil = ? ";

    
    public estado_civilDAO() throws Exception {
        cbd = new ConectaBD();
    }

    
    public void inserta(estado_civil estado){
    
        PreparedStatement ps = null;
        try {
            ps = cbd.getConexion().prepareStatement(cnSQLInserta);
            ps.setString(1, estado.getAbreviatura_estado_civil());
            ps.setString(1, estado.getNombre_estado_civil());
            ps.setInt(2, estado.getId_estado_civil());
            

            //rs=ps.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(personaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
        
    
    public List<estado_civil> seleccionaTodo(){
        List<estado_civil> listadoEstadoCivil=null;
        PreparedStatement ps = null;
        ResultSet rs=null;
        
        try {
            listadoEstadoCivil=new ArrayList<>();
            ps = cbd.getConexion().prepareStatement(cnSQLSeleccionaTodo);
            rs=ps.executeQuery();
            while(rs.next()){
                listadoEstadoCivil.add( new estado_civil(   rs.getInt("id_estado_civil"), 
                                                    rs.getString("abreviatura_estado_civil"),
                                                    rs.getString("nombre_estado_civil")));
            }
            
        } catch (Exception ex) {
            Logger.getLogger(personaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listadoEstadoCivil;
       
    }
    
    
    public estado_civil seleccionaPorID(int IDEstadoCivil){
        
        estado_civil nuevoProd=null;
        PreparedStatement ps = null;
        ResultSet rs=null;
        
        try {
            ps = cbd.getConexion().prepareStatement(cnSQLSeleccionaPorID);
            ps.setInt(1, IDEstadoCivil);
            rs=ps.executeQuery();
            while(rs.next()){
                nuevoProd = new estado_civil(   rs.getInt("id_estado_civil"), 
                                                    rs.getString("abreviatura_estado_civil"),
                                                    rs.getString("nombre_estado_civil"));
            }
            
        } catch (Exception ex) {
            Logger.getLogger(personaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return nuevoProd;
       
    }
    
    
    public boolean elimina(int IDEstadoCivil){
        
        boolean filaEliminada=false;
        PreparedStatement ps = null;
        
        try {
            ps = cbd.getConexion().prepareStatement(cnSQLEliminaPorID);
            ps.setInt(1, IDEstadoCivil);
            filaEliminada=( ps.executeUpdate() > 0);
            
        } catch (Exception ex) {
            Logger.getLogger(personaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return filaEliminada;
       
    }

    
    public boolean actualiza(estado_civil estado){
        boolean filaActualizada=false;
        PreparedStatement ps = null;
        try {
            ps = cbd.getConexion().prepareStatement(cnSQLActualizaPorID);
           ps.setString(1, estado.getAbreviatura_estado_civil());
            ps.setString(1, estado.getNombre_estado_civil());
            ps.setInt(2, estado.getId_estado_civil());           
       
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
