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
public class generoDAO {

    private ConectaBD cbd = null;
    private static final String cnSQLTabla="genero";   
    private static final String cnSQLInserta=" INSERT INTO "+cnSQLTabla+" (nombre_genero) values (?)";
    private static final String cnSQLSeleccionaPorID=" SELECT id_genero, nombre_genero FROM "+cnSQLTabla+" WHERE id_genero = ? ";
    private static final String cnSQLSeleccionaTodo=" SELECT id_genero, nombre_genero FROM "+cnSQLTabla+"  ";
    private static final String cnSQLEliminaPorID=" delete FROM "+cnSQLTabla+" WHERE id_genero = ? ";
    private static final String cnSQLActualizaPorID=" update "+cnSQLTabla+" set id_genero= ?, nombre_genero= ?  WHERE id_genero = ? ";

    /***
     * Constructor generoDAO
     * @throws Exception 
     */
    public generoDAO() throws Exception {
        cbd = new ConectaBD();
    }

    /***
     * Inserta un registro en la tabla genero
     * @param acc - objeto de la clase "genero"
     * @return verdadero, si inserto correctamente en la tabla genero
     */
    public boolean inserta(genero paramG){
        boolean filaInsertada=false;
        PreparedStatement ps = null;
        
        try {
            ps = cbd.getConexion().prepareStatement(cnSQLInserta);
            ps.setString(1, paramG.getNombre_genero());
            filaInsertada= ( ps.executeUpdate() >0) ;
        } catch (SQLException ex) {
            Util.printSQLException("generoDAO.inserta", ex);
        } catch (Exception e) {
            Util.printException("generoDAO.inserta", e);
        }
        return filaInsertada;        
    }
        
    /***
     * Selecciona todos los registros de la tabla genero
     * @return 
     */
    public List<genero> seleccionaTodo(){
        List<genero> listaGenero=null;
        PreparedStatement ps = null;
        ResultSet rs=null;
        
        try {
            listaGenero=new ArrayList<>();
            ps = cbd.getConexion().prepareStatement(cnSQLSeleccionaTodo);
            rs=ps.executeQuery();
            while(rs.next()){
                listaGenero.add( new genero(rs.getInt("id_genero"), 
                                            rs.getString("nombre_genero") )  );
                                                    
            }
        } catch (SQLException ex) {
            Util.printSQLException("generoDAO.seleccionaTodo", ex);
        } catch (Exception e) {
            Util.printException("generoDAO.seleccionaTodo", e);
        }
        return listaGenero;
       
    }
    
    /***
     * Selecciona un genero, según su ID
     * @param IDGenero
     * @return 
     */
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
        } catch (SQLException ex) {
            Util.printSQLException("generoDAO.seleccionaPorID", ex);
        } catch (Exception e) {
            Util.printException("generoDAO.seleccionaPorID", e);
        }
        return nuevap;
       
    }
    
    /***
     * Elimina el genero con el ID enviado.
     * @param IDGenero
     * @return 
     */
    public boolean elimina(int IDGenero){
        
        boolean filaEliminada=false;
        PreparedStatement ps = null;
        
        try {
            ps = cbd.getConexion().prepareStatement(cnSQLEliminaPorID);
            ps.setInt(1, IDGenero);
            filaEliminada=( ps.executeUpdate() > 0);
        } catch (SQLException ex) {
            Util.printSQLException("generoDAO.elimina", ex);
        } catch (Exception e) {
            Util.printException("generoDAO.elimina", e);
        }
        return filaEliminada;
       
    }

    /***
     * Modifica la informacion del genero enviado por parametro.
     * @param paramG
     * @return 
     */
    public boolean actualiza(genero paramG){
        boolean filaActualizada=false;
        PreparedStatement ps = null;
        try {
            ps = cbd.getConexion().prepareStatement(cnSQLActualizaPorID);
            ps.setString(1, paramG.getNombre_genero());
            ps.setInt(2, paramG.getId_genero());
            filaActualizada = ( ps.executeUpdate() > 0);            
        } catch (SQLException ex) {
            Util.printSQLException("generoDAO.actualiza", ex);
        } catch (Exception e) {
            Util.printException("generoDAO.actualiza", e);
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
            Util.printException("generoDAO.cierra", e);
        }        
    }

}
