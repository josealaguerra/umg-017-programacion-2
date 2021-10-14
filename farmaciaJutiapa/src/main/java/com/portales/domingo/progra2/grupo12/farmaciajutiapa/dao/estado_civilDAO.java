/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.portales.domingo.progra2.grupo12.farmaciajutiapa.dao;

import com.portales.domingo.progra2.grupo12.farmaciajutiapa.modelo.*;
import com.portales.domingo.progra2.grupo12.farmaciajutiapa.controlador.ConectaBD;
import com.portales.domingo.progra2.grupo12.farmaciajutiapa.controlador.Util;
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
    private static final String cnSQLActualizaPorID=" update "+cnSQLTabla+" set abreviatura_estado_civil = ?, nombre_estado_civil = ? WHERE id_estado_civil = ? ";

    /***
     * Constructor estado_civilDAO
     * @throws Exception 
     */
    public estado_civilDAO() throws Exception {
        cbd = new ConectaBD();
    }

    /***
     * Inserta un registro en la tabla estado_civil
     * @param paramEC - objeto de la clase "estado_civil"
     * @return verdadero, si inserto correctamente en la tabla estado_civil
     */
    public boolean inserta(estado_civil paramEC){
        boolean filaInsertada=false;
        PreparedStatement ps = null;
        try {
            ps = cbd.getConexion().prepareStatement(cnSQLInserta);
            ps.setString(1, paramEC.getAbreviatura_estado_civil());
            ps.setString(2, paramEC.getNombre_estado_civil());
            filaInsertada= ( ps.executeUpdate() >0) ;          
        } catch (SQLException ex) {
            Util.printSQLException("estado_civilDAO.inserta", ex);
        } catch (Exception e) {
            Util.printException("estado_civilDAO.inserta", e);
        }
        return filaInsertada;
    }
        
    /***
     * Selecciona todos los registros de la tabla estado_civil
     * @return 
     */
    public List<estado_civil> seleccionaTodo(){
        List<estado_civil> listadoEstadoCivil=null;
        PreparedStatement ps = null;
        ResultSet rs=null;
        
        try {
            listadoEstadoCivil=new ArrayList<>();
            ps = cbd.getConexion().prepareStatement(cnSQLSeleccionaTodo);
            rs = ps.executeQuery();
            while(rs.next()){
                listadoEstadoCivil.add( new estado_civil(   rs.getInt("id_estado_civil"), 
                                                            rs.getString("abreviatura_estado_civil"),
                                                            rs.getString("nombre_estado_civil")));
            }
        } catch (SQLException ex) {
            Util.printSQLException("estado_civilDAO.seleccionaTodo", ex);
        } catch (Exception e) {
            Util.printException("estado_civilDAO.seleccionaTodo", e);
        }
        return listadoEstadoCivil;
    }
    
    /***
     * Selecciona un estado_civil, según su ID
     * @param IDEstadoCivil
     * @return 
     */
    public estado_civil seleccionaPorID(int IDEstadoCivil){
        estado_civil nuevoEstadoCivil=null;
        PreparedStatement ps = null;
        ResultSet rs=null;
        
        try {
            ps = cbd.getConexion().prepareStatement(cnSQLSeleccionaPorID);
            ps.setInt(1, IDEstadoCivil);
            rs=ps.executeQuery();
            while(rs.next()){
                nuevoEstadoCivil = new estado_civil(    rs.getInt("id_estado_civil"), 
                                                        rs.getString("abreviatura_estado_civil"),
                                                        rs.getString("nombre_estado_civil"));
            }
        } catch (SQLException ex) {
            Util.printSQLException("estado_civilDAO.seleccionaPorID", ex);
        } catch (Exception e) {
            Util.printException("estado_civilDAO.seleccionaPorID", e);
        }
        return nuevoEstadoCivil;
    }
    
    /***
     * Elimina el estado_civil con el ID enviado.
     * @param IDEstadoCivil
     * @return 
     */    
    public boolean elimina(int IDEstadoCivil){
        boolean filaEliminada=false;
        PreparedStatement ps = null;
        
        try {
            ps = cbd.getConexion().prepareStatement(cnSQLEliminaPorID);
            ps.setInt(1, IDEstadoCivil);
            filaEliminada=( ps.executeUpdate() > 0);
        } catch (SQLException ex) {
            Util.printSQLException("estado_civilDAO.elimina", ex);
        } catch (Exception e) {
            Util.printException("estado_civilDAO.elimina", e);
        }
        return filaEliminada;
    }

    /***
     * Modifica la informacion del estado_civil enviado por parametro.
     * @param paramEC
     * @return 
     */
    public boolean actualiza(estado_civil paramEC){
        boolean filaActualizada=false;
        PreparedStatement ps = null;
        try {
            ps = cbd.getConexion().prepareStatement(cnSQLActualizaPorID);
            ps.setString(1, paramEC.getAbreviatura_estado_civil());
            ps.setString(2, paramEC.getNombre_estado_civil());
            ps.setInt(3, paramEC.getId_estado_civil()); 
            filaActualizada = ( ps.executeUpdate() > 0);
        } catch (SQLException ex) {
            Util.printSQLException("estado_civilDAO.actualiza", ex);
        } catch (Exception e) {
            Util.printException("estado_civilDAO.actualiza", e);
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
            Util.printException("estado_civilDAO.cierra", e);
        }        
    }

}
