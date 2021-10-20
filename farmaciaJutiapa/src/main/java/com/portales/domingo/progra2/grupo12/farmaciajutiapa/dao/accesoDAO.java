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
public class accesoDAO {

    private ConectaBD cbd = null;
    private static final String cnSQLTabla="acceso";   
    private static final String cnSQLInserta=" INSERT INTO "+cnSQLTabla+" (nombre_acceso, pagina_acceso) values (?, ?)";
    private static final String cnSQLSeleccionaPorID=" SELECT id_acceso, nombre_acceso, pagina_acceso FROM "+cnSQLTabla+" WHERE id_acceso = ? order by nombre_acceso ";
    private static final String cnSQLSeleccionaTodo=" SELECT id_acceso, nombre_acceso, pagina_acceso FROM "+cnSQLTabla+" order by nombre_acceso ";
    private static final String cnSQLEliminaPorID=" delete FROM "+cnSQLTabla+" WHERE id_acceso = ? ";
    private static final String cnSQLActualizaPorID=" update "+cnSQLTabla+" set nombre_acceso = ?, pagina_acceso = ? WHERE id_acceso = ? ";
    private static final String cnSQLSeleccionaPorNombre=" SELECT id_acceso, nombre_acceso, pagina_acceso FROM "+cnSQLTabla+" WHERE nombre_acceso = ? ";    
    private static final String cnSQLOrdenadoPorNombre=" select nombre_acceso from "+cnSQLTabla+" order by nombre_acceso  ";

    /***
     * Constructor accesoDAO
     * @throws Exception 
     */
    public accesoDAO() throws Exception {
        cbd = new ConectaBD();
    }
    
    
    public static String getAccesoOrdenadoSQL() {
        return cnSQLOrdenadoPorNombre;
    }    

    /***
     * Inserta un registro en la tabla acceso
     * @param acc - objeto de la clase "acceso"
     * @return verdadero, si inserto correctamente en la tabla acceso
     */
    public boolean inserta(acceso acc){
        boolean filaInsertada=false;
        PreparedStatement ps = null;
        
        try {
            ps = cbd.getConexion().prepareStatement(cnSQLInserta);
            ps.setString(1, acc.getNombre_acceso());
            ps.setString(2, acc.getPagina_acceso());
            filaInsertada= ( ps.executeUpdate() >0) ;          
        } catch (SQLException ex) {
            Util.printSQLException("accesoDAO.inserta", ex);
        } catch (Exception e) {
            Util.printException("accesoDAO.inserta", e);
        }
        return filaInsertada;
    }
        
    /***
     * Selecciona todos los registros de la tabla acceso
     * @return 
     */
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
        } catch (SQLException ex) {
            Util.printSQLException("accesoDAO.seleccionaTodo", ex);
        } catch (Exception e) {
            Util.printException("accesoDAO.seleccionaTodo", e);
        }
        return listaAccesos;
    }
    
    /***
     * Selecciona un acceso, según su ID
     * @param IDAcceso
     * @return 
     */
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
        } catch (SQLException ex) {
            Util.printSQLException("accesoDAO.seleccionaPorID", ex);
        } catch (Exception e) {
            Util.printException("accesoDAO.seleccionaPorID", e);
        }
        return nuevoAcceso;
    }
    
    /***
     * Elimina el acceso con el ID enviado.
     * @param IDAcceso
     * @return 
     */
    public boolean elimina(int IDAcceso){
        boolean filaEliminada=false;
        PreparedStatement ps = null;
        
        try {
            ps = cbd.getConexion().prepareStatement(cnSQLEliminaPorID);
            ps.setInt(1, IDAcceso);
            filaEliminada=( ps.executeUpdate() > 0);
            
        } catch (SQLException ex) {
            Util.printSQLException("accesoDAO.elimina", ex);
        } catch (Exception e) {
            Util.printException("accesoDAO.elimina", e);
        }
        return filaEliminada;
    }

    /***
     * Modifica la informacion del acceso enviado por parametro.
     * @param acc
     * @return 
     */
    public boolean actualiza(acceso acc){
        boolean filaActualizada=false;
        PreparedStatement ps = null;
        try {
            ps = cbd.getConexion().prepareStatement(cnSQLActualizaPorID);
            ps.setString(1, acc.getNombre_acceso());
            ps.setString(2, acc.getPagina_acceso());  
            ps.setInt(3, acc.getId_acceso());
            filaActualizada = ( ps.executeUpdate() > 0);            
       
        } catch (SQLException ex) {
            Util.printSQLException("accesoDAO.actualiza", ex);
        } catch (Exception e) {
            Util.printException("accesoDAO.actualiza", e);
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
            Util.printException("accesoDAO.cierra", e);
        }        
    }

    public acceso getAccesoByNombre(String nombreAcceso) {
        acceso nuevoAcceso=null;
        PreparedStatement ps = null;
        ResultSet rs=null;
        
        try {
            ps = cbd.getConexion().prepareStatement(cnSQLSeleccionaPorNombre);
            ps.setString(1, nombreAcceso);
            rs=ps.executeQuery();
            while(rs.next()){
                nuevoAcceso = new acceso(   rs.getInt("id_acceso"), 
                                            rs.getString("nombre_acceso"), 
                                            rs.getString("pagina_acceso"));
            }
        } catch (SQLException ex) {
            Util.printSQLException("accesoDAO.seleccionaPorID", ex);
        } catch (Exception e) {
            Util.printException("accesoDAO.seleccionaPorID", e);
        }
        return nuevoAcceso;
    }
    

    public acceso seleccionaPorNombre(String nombreRol) {
        acceso nuevoAcceso=null;
        
        try {
            nuevoAcceso = getAccesoByNombre( nombreRol );
        } catch (Exception e) {
            Util.printException("accesoDAO.seleccionaPorNombre", e);
        }
        return nuevoAcceso;
    }

}
