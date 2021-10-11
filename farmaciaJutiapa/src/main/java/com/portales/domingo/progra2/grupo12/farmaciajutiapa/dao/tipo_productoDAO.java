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
public class tipo_productoDAO {

    private ConectaBD cbd = null;
    private static final String cnSQLTabla="tipo_producto";   
    private static final String cnSQLInserta=" INSERT INTO "+cnSQLTabla+" (nombre_tipo_producto) values (?)";
    private static final String cnSQLSeleccionaPorID=" SELECT id_tipo_producto, nombre_tipo_producto FROM "+cnSQLTabla+" WHERE id_tipo_producto = ? ";
    private static final String cnSQLSeleccionaTodo=" SELECT id_tipo_producto, nombre_tipo_producto FROM "+cnSQLTabla+"  ";
    private static final String cnSQLEliminaPorID=" delete FROM "+cnSQLTabla+" WHERE id_tipo_producto = ? ";
    private static final String cnSQLActualizaPorID=" update "+cnSQLTabla+" set nombre_tipo_producto= ? WHERE id_tipo_producto = ? ";

    /***
     * Constructor tipo_productoDAO
     * @throws Exception 
     */
    public tipo_productoDAO() throws Exception {
        cbd = new ConectaBD();
    }

    /***
     * Inserta un registro en la tabla tipo_producto
     * @param tipPro - objeto de la clase "tipo_producto"
     * @return verdadero, si inserto correctamente en la tabla tipo_producto
     */
    public boolean inserta(tipo_producto tipPro){
        boolean filaInsertada=false;
        PreparedStatement ps = null;
        try {
            ps = cbd.getConexion().prepareStatement(cnSQLInserta);
            ps.setString(1, tipPro.getNombre_tipo_producto());
            filaInsertada= ( ps.executeUpdate() >0) ;          
        } catch (SQLException ex) {
            Util.printSQLException("tipo_productoDAO.inserta", ex);
        } catch (Exception e) {
            Util.printException("tipo_productoDAO.inserta", e);
        }
        return filaInsertada;
    }
        
    /***
     * Selecciona todos los registros de la tabla tipo_producto
     * @return 
     */
    public List<tipo_producto> seleccionaTodo(){
        List<tipo_producto> listaTipo_pro=null;
        PreparedStatement ps = null;
        ResultSet rs=null;
        try {
            listaTipo_pro=new ArrayList<>();
            ps = cbd.getConexion().prepareStatement(cnSQLSeleccionaTodo);
            rs=ps.executeQuery();
            while(rs.next()){
                listaTipo_pro.add( new tipo_producto(     rs.getInt("id_tipo_producto"), 
                                                          rs.getString("nombre_tipo_producto")));
            }
        } catch (SQLException ex) {
            Util.printSQLException("tipo_productoDAO.seleccionaTodo", ex);
        } catch (Exception e) {
            Util.printException("tipo_productoDAO.seleccionaTodo", e);
        }
        return listaTipo_pro;       
    }
    
    /***
     * Selecciona un tipo_producto, según su ID
     * @param IDTipPro
     * @return 
     */
    public tipo_producto seleccionaPorID(int IDTipPro){
        tipo_producto nuevoTipoProd=null;
        PreparedStatement ps = null;
        ResultSet rs=null;
        try {
            ps = cbd.getConexion().prepareStatement(cnSQLSeleccionaPorID);
            ps.setInt(1, IDTipPro);
            rs=ps.executeQuery();
            while(rs.next()){
                nuevoTipoProd = new tipo_producto(  rs.getInt("id_tipo_producto"), 
                                                    rs.getString("nombre_tipo_producto") );
            }
        } catch (SQLException ex) {
            Util.printSQLException("tipo_productoDAO.seleccionaPorID", ex);
        } catch (Exception e) {
            Util.printException("tipo_productoDAO.seleccionaPorID", e);
        }
        return nuevoTipoProd;
    }
    
    /***
     * Elimina el tipo_producto con el ID enviado.
     * @param IDTipPro
     * @return 
     */    
    public boolean elimina(int IDTipPro){
        boolean filaEliminada=false;
        PreparedStatement ps = null;
        try {
            ps = cbd.getConexion().prepareStatement(cnSQLEliminaPorID);
            ps.setInt(1, IDTipPro);
            filaEliminada=( ps.executeUpdate() > 0);
        } catch (SQLException ex) {
            Util.printSQLException("tipo_productoDAO.elimina", ex);
        } catch (Exception e) {
            Util.printException("tipo_productoDAO.elimina", e);
        }
        return filaEliminada;
    }

    /***
     * Modifica la informacion del tipo_producto enviado por parametro.
     * @param tipPro
     * @return 
     */    
    public boolean actualiza(tipo_producto tipPro){
        boolean filaActualizada=false;
        PreparedStatement ps = null;
        try {
            ps = cbd.getConexion().prepareStatement(cnSQLActualizaPorID);
            ps.setString(1, tipPro.getNombre_tipo_producto());
            ps.setInt(2, tipPro.getId_tipo_producto());
            filaActualizada = ( ps.executeUpdate() > 0);
        } catch (SQLException ex) {
            Util.printSQLException("tipo_productoDAO.actualiza", ex);
        } catch (Exception e) {
            Util.printException("tipo_productoDAO.actualiza", e);
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
            Util.printException("tipo_productoDAO.cierra", e);
        }        
    }
  

}
