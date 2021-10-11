/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.portales.domingo.progra2.grupo12.farmaciajutiapa.dao;

import com.portales.domingo.progra2.grupo12.farmaciajutiapa.controlador.ConectaBD;
import com.portales.domingo.progra2.grupo12.farmaciajutiapa.controlador.Util;
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

    /***
     * Constructor usuarioDAO
     * @throws Exception 
     */
    public usuarioDAO() throws Exception {
        cbd = new ConectaBD();
    }

    /***
     * Inserta un registro en la tabla usuario
     * @param us - objeto de la clase "usuario"
     * @return verdadero, si inserto correctamente en la tabla usuario
     */
    public boolean inserta(usuario us){
        boolean filaInsertada=false;
        PreparedStatement ps = null;
        try {
            ps = cbd.getConexion().prepareStatement(cnSQLInserta);
            ps.setInt(1, us.getId_persona());
            ps.setString(2, us.getContraseña());
            ps.setInt(3, us.getId_rol());
            filaInsertada= ( ps.executeUpdate() >0) ;          
        } catch (SQLException ex) {
            Util.printSQLException("usuarioDAO.inserta", ex);
        } catch (Exception e) {
            Util.printException("usuarioDAO.inserta", e);
        }
        return filaInsertada;
    }
        
    /***
     * Selecciona todos los registros de la tabla usuario
     * @return 
     */
    public List<usuario> seleccionaTodo(){
        List<usuario> listaUsuario=null;
        PreparedStatement ps = null;
        ResultSet rs=null;
        try {
            listaUsuario = new ArrayList<>();
            ps = cbd.getConexion().prepareStatement(cnSQLSeleccionaTodo);
            rs = ps.executeQuery();
            while(rs.next()){
                listaUsuario.add( new usuario(  rs.getInt("id_usuario"), 
                                                rs.getInt("id_persona"), 
                                                rs.getString("contraseña"), 
                                                rs.getInt("id_rol")));
            }
        } catch (SQLException ex) {
            Util.printSQLException("usuarioDAO.seleccionaTodo", ex);
        } catch (Exception e) {
            Util.printException("usuarioDAO.seleccionaTodo", e);
        }
        return listaUsuario;
    }
    
    /***
     * Selecciona un usuario, según su ID
     * @param IDUsuario
     * @return 
     */
    public usuario seleccionaPorID(int IDUsuario){
        usuario nuevoUsuario=null;
        PreparedStatement ps = null;
        ResultSet rs=null;
        try {
            ps = cbd.getConexion().prepareStatement(cnSQLSeleccionaPorID);
            ps.setInt(1, IDUsuario);
            rs=ps.executeQuery();
            while(rs.next()){
                nuevoUsuario = new usuario( rs.getInt("id_usuario"), 
                                            rs.getInt("id_persona"), 
                                            rs.getString("contraseña"), 
                                            rs.getInt("id_rol") );
            }
        } catch (SQLException ex) {
            Util.printSQLException("usuarioDAO.seleccionaPorID", ex);
        } catch (Exception e) {
            Util.printException("usuarioDAO.seleccionaPorID", e);
        }
        return nuevoUsuario;
    }
    
    /***
     * Elimina el usuario con el ID enviado.
     * @param IDUsuario
     * @return 
     */
    public boolean elimina(int IDUsuario){
        boolean filaEliminada=false;
        PreparedStatement ps = null;
        try {
            ps = cbd.getConexion().prepareStatement(cnSQLEliminaPorID);
            ps.setInt(1, IDUsuario);
            filaEliminada=( ps.executeUpdate() > 0);
        } catch (SQLException ex) {
            Util.printSQLException("usuarioDAO.elimina", ex);
        } catch (Exception e) {
            Util.printException("usuarioDAO.elimina", e);
        }
        return filaEliminada;
       
    }

    /***
     * Modifica la informacion del usuario enviado por parametro.
     * @param us
     * @return 
     */
    public boolean actualiza(usuario us){
        boolean filaActualizada=false;
        PreparedStatement ps = null;
        try {
            ps.setInt(1, us.getId_persona());
            ps.setString(2, us.getContraseña());
            ps.setInt(3, us.getId_rol());
            ps.setInt(4, us.getId_usuario());
            filaActualizada = ( ps.executeUpdate() > 0);
        } catch (SQLException ex) {
            Util.printSQLException("usuarioDAO.actualiza", ex);
        } catch (Exception e) {
            Util.printException("usuarioDAO.actualiza", e);
        }
        return filaActualizada;
    }

    

    /***
     * Cierra las conexiones a BD
     */
    public void cierra() {
        try {
            if(cbd!=null)
                cbd.closeDB();
        } catch (Exception e) {
            Util.printException("usuarioDAO.cierra", e);
        }        
    }


}
