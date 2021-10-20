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
    private static final String cnSQLSeleccionaPorNombre=" SELECT id_rol, nombre_rol FROM "+cnSQLTabla+" WHERE nombre_rol = ? ";    
    private static final String cnSQLOrdenadoPorNombre=" select nombre_rol from "+cnSQLTabla+" order by nombre_rol  ";    

    /***
     * Constructor rolDAO
     * @throws Exception 
     */
    public rolDAO() throws Exception {
        cbd = new ConectaBD();
    }

    public static String getRolOrdenadoSQL() {
        return cnSQLOrdenadoPorNombre;
    }    
    
    
    
    /***
     * Inserta un registro en la tabla rol
     * @param paramRol - objeto de la clase "rol"
     * @return verdadero, si inserto correctamente en la tabla rol
     */
    public boolean inserta(rol paramRol){
        boolean filaInsertada=false;    
        PreparedStatement ps = null;
        try {
            ps = cbd.getConexion().prepareStatement(cnSQLInserta);
            ps.setString(1, paramRol.getNombre_rol());
            filaInsertada= ( ps.executeUpdate() >0) ;          
        } catch (SQLException ex) {
            Util.printSQLException("rolDAO.inserta", ex);
        } catch (Exception e) {
            Util.printException("rolDAO.inserta", e);
        }
        return filaInsertada;
    }
        
    /***
     * Selecciona todos los registros de la tabla rol
     * @return 
     */
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
        } catch (SQLException ex) {
            Util.printSQLException("rolDAO.seleccionaTodo", ex);
        } catch (Exception e) {
            Util.printException("rolDAO.seleccionaTodo", e);
        }
        return listaRoles;     
    }
    
    /***
     * Selecciona un rol, según su ID
     * @param IDRol
     * @return 
     */
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
        } catch (SQLException ex) {
            Util.printSQLException("rolDAO.seleccionaPorID", ex);
        } catch (Exception e) {
            Util.printException("rolDAO.seleccionaPorID", e);
        }
        return nuevoRol;
       
    }
    
    /***
     * Elimina el rol con el ID enviado.
     * @param IDRol
     * @return 
     */
    public boolean elimina(int IDRol){
        boolean filaEliminada=false;
        PreparedStatement ps = null;        
        try {
            ps = cbd.getConexion().prepareStatement(cnSQLEliminaPorID);
            ps.setInt(1, IDRol);
            filaEliminada=( ps.executeUpdate() > 0);
        } catch (SQLException ex) {
            Util.printSQLException("rolDAO.elimina", ex);
        } catch (Exception e) {
            Util.printException("rolDAO.elimina", e);
        }
        return filaEliminada;       
    }

    /***
     * Modifica la informacion del rol enviado por parametro.
     * @param paramRol
     * @return 
     */
    public boolean actualiza(rol paramRol){
        boolean filaActualizada=false;
        PreparedStatement ps = null;
        try {
            ps = cbd.getConexion().prepareStatement(cnSQLActualizaPorID);
            ps.setString(1, paramRol.getNombre_rol());
            ps.setInt(2, paramRol.getId_rol());
            filaActualizada = ( ps.executeUpdate() > 0);
        } catch (SQLException ex) {
            Util.printSQLException("rolDAO.actualiza", ex);
        } catch (Exception e) {
            Util.printException("rolDAO.actualiza", e);
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
            Util.printException("rolDAO.cierra", e);
        }        
    }

    public rol getRolByNombre(String nombreRol) {
        rol nuevoRol=null;
        PreparedStatement ps = null;
        ResultSet rs=null;
        
        try {
            ps = cbd.getConexion().prepareStatement(cnSQLSeleccionaPorNombre);
            ps.setString(1, nombreRol);
            rs=ps.executeQuery();
            while(rs.next()){
                nuevoRol = new rol( rs.getInt("id_rol"), rs.getString("nombre_rol")  );
            }
        } catch (SQLException ex) {
            Util.printSQLException("rolDAO.getRolByNombre", ex);
        } catch (Exception e) {
            Util.printException("rolDAO.getRolByNombre", e);
        }
        return nuevoRol;
    }
  

}
