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
public class clienteDAO {

    private ConectaBD cbd = null;
    private static final String cnSQLTabla="cliente";   
    private static final String cnSQLInserta=" INSERT INTO "+cnSQLTabla+" (id_empresa, id_persona) values (?, ?)";
    private static final String cnSQLSeleccionaPorID=" SELECT id_cliente, id_empresa, id_persona FROM "+cnSQLTabla+" WHERE id_persona = ? ";
    private static final String cnSQLSeleccionaTodo=" SELECT id_cliente, id_empresa, id_persona FROM "+cnSQLTabla+"  ";
    private static final String cnSQLEliminaPorID=" delete FROM "+cnSQLTabla+" WHERE id_cliente = ? ";
    private static final String cnSQLActualizaPorID=" update "+cnSQLTabla+" set id_empresa= ?, id_persona WHERE id_cliente = ? ";

    
    public clienteDAO() throws Exception {
        cbd = new ConectaBD();
    }

    
    public void inserta(cliente c){
    
        PreparedStatement ps = null;
        try {
            ps = cbd.getConexion().prepareStatement(cnSQLInserta);
            ps.setInt(1, c.getId_empresa());
            ps.setInt(2, c.getId_persona());
            ps.setInt(3, c.getId_cliente());
           
            //rs=ps.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(personaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
        
    
    public List<cliente> seleccionaTodo(){
        List<cliente> listaCliente=null;
        cliente nuevap=null;
        PreparedStatement ps = null;
        ResultSet rs=null;
        
        try {
            listaCliente=new ArrayList<>();
            ps = cbd.getConexion().prepareStatement(cnSQLSeleccionaTodo);
            rs=ps.executeQuery();
            while(rs.next()){
                listaCliente.add( new cliente(     rs.getInt("id_cliente"), 
                                                    rs.getInt("id_empresa"), 
                                                    rs.getInt("id_persona")));
                                                   
            }
            
        } catch (Exception ex) {
            Logger.getLogger(personaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaCliente;
       
    }
    
    
    public cliente seleccionaPorID(int IDCliente){
        
        cliente nuevap=null;
        PreparedStatement ps = null;
        ResultSet rs=null;
        
        try {
            ps = cbd.getConexion().prepareStatement(cnSQLSeleccionaPorID);
            ps.setInt(1, IDCliente);
            rs=ps.executeQuery();
            while(rs.next()){
                nuevap = new cliente(   rs.getInt("id_cliente"), 
                                                    rs.getInt("id_empresa"), 
                                                    rs.getInt("id_persona"));
            }
            
        } catch (Exception ex) {
            Logger.getLogger(personaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return nuevap;
       
    }
    
    
    public boolean elimina(int IDCliente){
        
        boolean filaEliminada=false;
        PreparedStatement ps = null;
        
        try {
            ps = cbd.getConexion().prepareStatement(cnSQLEliminaPorID);
            ps.setInt(1, IDCliente);
            filaEliminada=( ps.executeUpdate() > 0);
            
        } catch (Exception ex) {
            Logger.getLogger(personaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return filaEliminada;
       
    }

    
    public boolean actualiza(cliente c){
        boolean filaActualizada=false;
        PreparedStatement ps = null;
        try {
            ps = cbd.getConexion().prepareStatement(cnSQLActualizaPorID);
             ps.setInt(1, c.getId_empresa());
            ps.setInt(2, c.getId_persona());
            ps.setInt(3, c.getId_cliente());
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
