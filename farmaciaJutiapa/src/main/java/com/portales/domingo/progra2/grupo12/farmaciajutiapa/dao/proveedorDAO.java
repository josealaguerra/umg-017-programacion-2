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
public class proveedorDAO {

    private ConectaBD cbd = null;
    private static final String cnSQLTabla="proveedor";   
    private static final String cnSQLInserta=" INSERT INTO "+cnSQLTabla+" (id_empresa,id_persona) values (?, ?)";
    private static final String cnSQLSeleccionaPorID=" SELECT id_proveedor, id_empresa,id_persona FROM "+cnSQLTabla+" WHERE id_proveedor = ? ";
    private static final String cnSQLSeleccionaTodo=" SELECT id_proveedor, id_empresa,id_persona FROM "+cnSQLTabla+"  ";
    private static final String cnSQLEliminaPorID=" delete FROM "+cnSQLTabla+" WHERE id_proveedor = ? ";
    private static final String cnSQLActualizaPorID=" update "+cnSQLTabla+" set id_proveedor= ?, id_empresa= ?, id_persona= ? WHERE id_proveedor = ? ";

    /***
     * Constructor proveedorDAO
     * @throws Exception 
     */
    public proveedorDAO() throws Exception {
        cbd = new ConectaBD();
    }

    /***
     * Inserta un registro en la tabla proveedor
     * @param prov - objeto de la clase "proveedor"
     * @return verdadero, si inserto correctamente en la tabla proveedor
     */
    public boolean inserta(proveedor prov){
        boolean filaInsertada=false;
        PreparedStatement ps = null;
        try {
            ps = cbd.getConexion().prepareStatement(cnSQLInserta);
            ps.setInt(1, prov.getId_empresa());
            ps.setInt(2, prov.getId_persona());
            filaInsertada= ( ps.executeUpdate() >0) ;          
        } catch (SQLException ex) {
            Util.printSQLException("proveedorDAO.inserta", ex);
        } catch (Exception e) {
            Util.printException("proveedorDAO.inserta", e);
        }
        return filaInsertada;
    }
        
    /***
     * Selecciona todos los registros de la tabla proveedor
     * @return 
     */
    public List<proveedor> seleccionaTodo(){
        List<proveedor> listaProveedor=null;
        PreparedStatement ps = null;
        ResultSet rs=null;        
        try {
            listaProveedor=new ArrayList<>();
            ps = cbd.getConexion().prepareStatement(cnSQLSeleccionaTodo);
            rs=ps.executeQuery();
            while(rs.next()){
                listaProveedor.add( new proveedor(  rs.getInt("id_proveedor"), 
                                                    rs.getInt("id_empresa"), 
                                                    rs.getInt("id_persona")));
                                                   
            }           
        } catch (SQLException ex) {
            Util.printSQLException("proveedorDAO.seleccionaTodo", ex);
        } catch (Exception e) {
            Util.printException("proveedorDAO.seleccionaTodo", e);
        }
        return listaProveedor;       
    }
    
    /***
     * Selecciona un proveedor, según su ID
     * @param IDProveedor
     * @return 
     */
    public proveedor seleccionaPorID(int IDProveedor){
        proveedor nuevoProveedor=null;
        PreparedStatement ps = null;
        ResultSet rs=null;        
        try {
            ps = cbd.getConexion().prepareStatement(cnSQLSeleccionaPorID);
            ps.setInt(1, IDProveedor);
            rs=ps.executeQuery();
            while(rs.next()){
                nuevoProveedor = new proveedor( rs.getInt("id_proveedor"), 
                                                rs.getInt("id_empresa"), 
                                                rs.getInt("id_persona"));
            }
        } catch (SQLException ex) {
            Util.printSQLException("proveedorDAO.seleccionaPorID", ex);
        } catch (Exception e) {
            Util.printException("proveedorDAO.seleccionaPorID", e);
        }
        return nuevoProveedor;       
    }
    
    /***
     * Elimina el proveedor con el ID enviado.
     * @param IDProveedor
     * @return 
     */
    public boolean elimina(int IDProveedor){
        boolean filaEliminada=false;
        PreparedStatement ps = null;
        try {
            ps = cbd.getConexion().prepareStatement(cnSQLEliminaPorID);
            ps.setInt(1, IDProveedor);
            filaEliminada=( ps.executeUpdate() > 0);
        } catch (SQLException ex) {
            Util.printSQLException("proveedorDAO.elimina", ex);
        } catch (Exception e) {
            Util.printException("proveedorDAO.elimina", e);
        }
        return filaEliminada;
       
    }

    /***
     * Modifica la informacion del proveedor enviado por parametro.
     * @param prov
     * @return 
     */
    public boolean actualiza(proveedor prov){
        boolean filaActualizada=false;
        PreparedStatement ps = null;
        try {
            ps = cbd.getConexion().prepareStatement(cnSQLActualizaPorID);
            ps.setInt(1, prov.getId_empresa());
            ps.setInt(2, prov.getId_persona());
            ps.setInt(3, prov.getId_proveedor());
            filaActualizada = ( ps.executeUpdate() > 0);            
        } catch (SQLException ex) {
            Util.printSQLException("proveedorDAO.actualiza", ex);
        } catch (Exception e) {
            Util.printException("proveedorDAO.actualiza", e);
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
            Util.printException("proveedorDAO.cierra", e);
        }        
    }
  

}
