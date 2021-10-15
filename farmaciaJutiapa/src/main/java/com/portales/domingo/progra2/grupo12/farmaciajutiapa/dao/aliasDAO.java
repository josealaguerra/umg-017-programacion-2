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

/**
 *
 * @author josealaguerra
 */
public class aliasDAO {
    private ConectaBD cbd = null;
    private static final String cnSQLTabla="alias";   
    private static final String cnSQLInserta=" INSERT INTO "+cnSQLTabla+" (alias,pass) values (?,?)";
    private static final String cnSQLSeleccionaPorID=" SELECT id_alias, alias, pass FROM "+cnSQLTabla+" WHERE id_alias = ? ";
    private static final String cnSQLSeleccionaTodo=" SELECT id_alias, alias, pass FROM "+cnSQLTabla+"  ";
    private static final String cnSQLEliminaPorID=" delete FROM "+cnSQLTabla+" WHERE id_alias = ? ";
    private static final String cnSQLActualizaPorID=" update "+cnSQLTabla+" set alias = ?, pass = ? WHERE id_alias = ? ";

    /***
     * Constructor aliasDAO
     * @throws Exception 
     */
    public aliasDAO() throws Exception {
        cbd = new ConectaBD();
    }

    /***
     * Inserta un registro en la tabla alias
     * @param paramAlias - objeto de la clase "alias"
     * @return verdadero, si inserto correctamente en la tabla alias
     */
    public boolean inserta(alias paramAlias){
        boolean filaInsertada=false;
        PreparedStatement ps = null;
        try {
            ps = cbd.getConexion().prepareStatement(cnSQLInserta);
            ps.setString(1, paramAlias.getAlias());
            ps.setString(2, paramAlias.getPass());
            filaInsertada= ( ps.executeUpdate() >0) ;          
        } catch (SQLException ex) {
            Util.printSQLException("aliasDAO.inserta", ex);
        } catch (Exception e) {
            Util.printException("aliasDAO.inserta", e);
        }
        return filaInsertada;
    }
        
    /***
     * Selecciona todos los registros de la tabla alias
     * @return 
     */
    public List<alias> seleccionaTodo(){
        List<alias> listadoAlias=null;
        PreparedStatement ps = null;
        ResultSet rs=null;
        
        try {
            listadoAlias=new ArrayList<>();
            ps = cbd.getConexion().prepareStatement(cnSQLSeleccionaTodo);
            rs = ps.executeQuery();
            while(rs.next()){
                listadoAlias.add( new alias(rs.getInt("id_alias"), 
                                            rs.getString("alias"),
                                            rs.getString("pass")));
            }
        } catch (SQLException ex) {
            Util.printSQLException("aliasDAO.seleccionaTodo", ex);
        } catch (Exception e) {
            Util.printException("aliasDAO.seleccionaTodo", e);
        }
        return listadoAlias;
    }
    
    /***
     * Selecciona un alias, según su ID
     * @param IDAlias
     * @return 
     */
    public alias seleccionaPorID(int IDAlias){
        alias nuevoAlias=null;
        PreparedStatement ps = null;
        ResultSet rs=null;
        
        try {
            ps = cbd.getConexion().prepareStatement(cnSQLSeleccionaPorID);
            ps.setInt(1, IDAlias);
            rs=ps.executeQuery();
            while(rs.next()){
                nuevoAlias = new alias( rs.getInt("id_alias"), 
                                        rs.getString("alias"),
                                        rs.getString("pass"));
            }
        } catch (SQLException ex) {
            Util.printSQLException("aliasDAO.seleccionaPorID", ex);
        } catch (Exception e) {
            Util.printException("aliasDAO.seleccionaPorID", e);
        }
        return nuevoAlias;
    }
    
    /***
     * Elimina el alias con el ID enviado.
     * @param IDAlias
     * @return 
     */    
    public boolean elimina(int IDAlias){
        boolean filaEliminada=false;
        PreparedStatement ps = null;
        
        try {
            ps = cbd.getConexion().prepareStatement(cnSQLEliminaPorID);
            ps.setInt(1, IDAlias);
            filaEliminada=( ps.executeUpdate() > 0);
        } catch (SQLException ex) {
            Util.printSQLException("aliasDAO.elimina", ex);
        } catch (Exception e) {
            Util.printException("aliasDAO.elimina", e);
        }
        return filaEliminada;
    }

    /***
     * Modifica la informacion del alias enviado por parametro.
     * @param paramAlias
     * @return 
     */
    public boolean actualiza(alias paramAlias){
        boolean filaActualizada=false;
        PreparedStatement ps = null;
        try {
            ps = cbd.getConexion().prepareStatement(cnSQLActualizaPorID);
            ps.setString(1, paramAlias.getAlias());
            ps.setString(2, paramAlias.getPass());
            ps.setInt(3, paramAlias.getId_alias()); 
            filaActualizada = ( ps.executeUpdate() > 0);
        } catch (SQLException ex) {
            Util.printSQLException("aliasDAO.actualiza", ex);
        } catch (Exception e) {
            Util.printException("aliasDAO.actualiza", e);
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
            Util.printException("aliasDAO.cierra", e);
        }        
    }

}
