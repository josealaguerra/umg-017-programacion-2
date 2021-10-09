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
public class generoDAO {

    private ConectaBD cbd = null;
    private static final String cnSQLTabla="genero";   
    private static final String cnSQLInserta=" INSERT INTO "+cnSQLTabla+" (nombre_genero) values (?)";
    private static final String cnSQLSeleccionaPorID=" SELECT id_genero, nombre_genero FROM "+cnSQLTabla+" WHERE id_genero = ? ";
    private static final String cnSQLSeleccionaTodo=" SELECT id_genero, nombre_genero FROM "+cnSQLTabla+"  ";
    private static final String cnSQLEliminaPorID=" delete FROM "+cnSQLTabla+" WHERE id_genero = ? ";
    private static final String cnSQLActualizaPorID=" update "+cnSQLTabla+" set id_genero= ?, nombre_genero= ?  WHERE id_genero = ? ";

    
    public generoDAO() throws Exception {
        cbd = new ConectaBD();
    }

    
    public void inserta(genero p){
    
        PreparedStatement ps = null;
        try {
            ps = cbd.getConexion().prepareStatement(cnSQLInserta);
            ps.setString(1, p.getNombre_genero());
            ps.setInt(2, p.getId_genero());
            
        } catch (SQLException ex) {
            Logger.getLogger(generoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
        
    
    public List<genero> seleccionaTodo(){
        List<genero> listaGenero=null;
        genero nuevap=null;
        PreparedStatement ps = null;
        ResultSet rs=null;
        
        try {
            listaGenero=new ArrayList<>();
            ps = cbd.getConexion().prepareStatement(cnSQLSeleccionaTodo);
            rs=ps.executeQuery();
            while(rs.next()){
                listaGenero.add( new genero(     rs.getInt("id_genero"), 
                                                    rs.getString("nombre_genero")));
                                                    
            }
            
        } catch (Exception ex) {
            Logger.getLogger(generoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaGenero;
       
    }
    
    
    public genero seleccionaPorID(int IDGenero){
        
        genero nuevap=null;
        PreparedStatement ps = null;
        ResultSet rs=null;
        
        try {
            ps = cbd.getConexion().prepareStatement(cnSQLSeleccionaPorID);
            ps.setInt(1, IDGenero);
            rs=ps.executeQuery();
            while(rs.next()){
                nuevap = new genero(    rs.getInt("id_genero"), 
                                                    rs.getString("nombre_genero"));
            }
            
        } catch (Exception ex) {
            Logger.getLogger(generoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return nuevap;
       
    }
    
    
    public boolean elimina(int IDGenero){
        
        boolean filaEliminada=false;
        PreparedStatement ps = null;
        
        try {
            ps = cbd.getConexion().prepareStatement(cnSQLEliminaPorID);
            ps.setInt(1, IDGenero);
            filaEliminada=( ps.executeUpdate() > 0);
            
        } catch (Exception ex) {
            Logger.getLogger(generoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return filaEliminada;
       
    }

    
    public boolean actualiza(genero p){
        boolean filaActualizada=false;
        PreparedStatement ps = null;
        try {
             ps.setString(1, p.getNombre_genero());
            ps.setInt(2, p.getId_genero());
            
        } catch (SQLException ex) {
            Logger.getLogger(generoDAO.class.getName()).log(Level.SEVERE, null, ex);
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
