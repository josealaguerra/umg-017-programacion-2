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
public class usuarioDAO {

    private ConectaBD cbd = null;
    private static final String cnSQLTabla="usuario";   
    private static final String cnSQLInserta=" INSERT INTO "+cnSQLTabla+" (id_persona, contraseña, id_rol) values (?, ?, ?)";
    private static final String cnSQLSeleccionaPorID=" SELECT id_usuario, id_persona, contraseña, id_rol FROM "+cnSQLTabla+" WHERE id_usuario = ? ";
    private static final String cnSQLSeleccionaTodo=" SELECT id_usuario, id_persona, contraseña, id_rol FROM "+cnSQLTabla+"  ";
    private static final String cnSQLEliminaPorID=" delete FROM "+cnSQLTabla+" WHERE id_usuario = ? ";
    private static final String cnSQLActualizaPorID=" update "+cnSQLTabla+" set id_persona= ?, contraseña= ?, id_rol= ? WHERE id_usuario = ? ";

    
    public usuarioDAO() throws Exception {
        cbd = new ConectaBD();
    }

    
    public void inserta(usuario us){
    
        PreparedStatement ps = null;
        try {
            ps = cbd.getConexion().prepareStatement(cnSQLInserta);
            ps.setInt(1, us.getId_persona());
            ps.setString(2, us.getContraseña());
            ps.setInt(3, us.getId_rol());
            ps.setInt(4, us.getId_usuario());
            
        } catch (SQLException ex) {
            Logger.getLogger(personaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
        
    
    public List<usuario> seleccionaTodo(){
        List<usuario> listaUsuario=null;
        usuario nuevap=null;
        PreparedStatement ps = null;
        ResultSet rs=null;
        
        try {
            listaUsuario=new ArrayList<>();
            ps = cbd.getConexion().prepareStatement(cnSQLSeleccionaTodo);
            rs=ps.executeQuery();
            while(rs.next()){
                listaUsuario.add( new usuario(     rs.getInt("id_usuario"), 
                                                    rs.getInt("id_persona"), 
                                                    rs.getString("contraseña"), 
                                                    rs.getInt("id_rol")));
                                                    
            }
            
        } catch (Exception ex) {
            Logger.getLogger(personaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaUsuario;
       
    }
    
    
    public usuario seleccionaPorID(int IDUsuario){
        
        usuario nuevap=null;
        PreparedStatement ps = null;
        ResultSet rs=null;
        
        try {
            ps = cbd.getConexion().prepareStatement(cnSQLSeleccionaPorID);
            ps.setInt(1, IDUsuario);
            rs=ps.executeQuery();
            while(rs.next()){
                nuevap = new usuario(   rs.getInt("id_usuario"), 
                                                    rs.getInt("id_persona"), 
                                                    rs.getString("contraseña"), 
                                                    rs.getInt("id_rol"));
            }
            
        } catch (Exception ex) {
            Logger.getLogger(personaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return nuevap;
       
    }
    
    
    public boolean elimina(int IDUsuario){
        
        boolean filaEliminada=false;
        PreparedStatement ps = null;
        
        try {
            ps = cbd.getConexion().prepareStatement(cnSQLEliminaPorID);
            ps.setInt(1, IDUsuario);
            filaEliminada=( ps.executeUpdate() > 0);
            
        } catch (Exception ex) {
            Logger.getLogger(personaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return filaEliminada;
       
    }

    
    public boolean actualiza(usuario us){
        boolean filaActualizada=false;
        PreparedStatement ps = null;
        try {
            ps.setInt(1, us.getId_persona());
            ps.setString(2, us.getContraseña());
            ps.setInt(3, us.getId_rol());
            ps.setInt(4, us.getId_usuario());
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
