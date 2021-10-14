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
public class marca_productoDAO {
    private ConectaBD cbd = null;
    private static final String cnSQLTabla="marca_producto";   
    private static final String cnSQLInserta=" INSERT INTO "+cnSQLTabla+" (nombre_marca_producto) values (?)";
    private static final String cnSQLSeleccionaPorID=" SELECT id_marca_producto, nombre_marca_producto FROM "+cnSQLTabla+" WHERE id_marca_producto = ? ";
    private static final String cnSQLSeleccionaTodo=" SELECT id_marca_producto, nombre_marca_producto FROM "+cnSQLTabla+"  ";
    private static final String cnSQLEliminaPorID=" delete FROM "+cnSQLTabla+" WHERE id_marca_producto = ? ";
    private static final String cnSQLActualizaPorID=" update "+cnSQLTabla+" set nombre_marca_producto = ? WHERE id_marca_producto = ? ";

    /***
     * Constructor marca_productoDAO
     * @throws Exception 
     */
    public marca_productoDAO() throws Exception {
        cbd = new ConectaBD();
    }

    /***
     * Inserta un registro en la tabla marca_producto
     * @param acc - objeto de la clase "marca_producto"
     * @return verdadero, si inserto correctamente en la tabla marca_producto
     */
    public boolean inserta(marca_producto paramMarcaProd){
        boolean filaInsertada=false;
        PreparedStatement ps = null;
        try {
            ps = cbd.getConexion().prepareStatement(cnSQLInserta);
            ps.setString(1, paramMarcaProd.getNombre_marca_producto());
            filaInsertada= ( ps.executeUpdate() >0) ;          
        } catch (SQLException ex) {
            Util.printSQLException("marca_productoDAO.inserta", ex);
        } catch (Exception e) {
            Util.printException("marca_productoDAO.inserta", e);
        }
        return filaInsertada;
    }
        
    /***
     * Selecciona todos los registros de la tabla marca_producto
     * @return 
     */
    public List<marca_producto> seleccionaTodo(){
        List<marca_producto> listaMarProducto=null;
        PreparedStatement ps = null;
        ResultSet rs=null;
        
        try {
            listaMarProducto=new ArrayList<>();
            ps = cbd.getConexion().prepareStatement(cnSQLSeleccionaTodo);
            rs=ps.executeQuery();
            while(rs.next()){
                listaMarProducto.add( new marca_producto(   rs.getInt("id_marca_producto"), 
                                                            rs.getString("nombre_marca_producto")) ); 
            }
        } catch (SQLException ex) {
            Util.printSQLException("marca_productoDAO.seleccionaTodo", ex);
        } catch (Exception e) {
            Util.printException("marca_productoDAO.seleccionaTodo", e);
        }
        return listaMarProducto;
       
    }
    
    /***
     * Selecciona un marca_producto, según su ID
     * @param IDMarcaProduc
     * @return 
     */
    public marca_producto seleccionaPorID(int IDMarcaProduc){
        marca_producto nuevaMarcaProd=null;
        PreparedStatement ps = null;
        ResultSet rs=null;
        
        try {
            ps = cbd.getConexion().prepareStatement(cnSQLSeleccionaPorID);
            ps.setInt(1, IDMarcaProduc);
            rs=ps.executeQuery();
            while(rs.next()){
                nuevaMarcaProd = new marca_producto(    rs.getInt("id_marca_producto"), 
                                                        rs.getString("nombre_marca_producto") );
            }
        } catch (SQLException ex) {
            Util.printSQLException("marca_productoDAO.seleccionaPorID", ex);
        } catch (Exception e) {
            Util.printException("marca_productoDAO.seleccionaPorID", e);
        }
        return nuevaMarcaProd;
    }
    
    /***
     * Elimina el marca_producto con el ID enviado.
     * @param IDMarcaProduc
     * @return 
     */
    public boolean elimina(int IDMarcaProduc){
        boolean filaEliminada=false;
        PreparedStatement ps = null;
        
        try {
            ps = cbd.getConexion().prepareStatement(cnSQLEliminaPorID);
            ps.setInt(1, IDMarcaProduc);
            filaEliminada=( ps.executeUpdate() > 0);
        } catch (SQLException ex) {
            Util.printSQLException("marca_productoDAO.elimina", ex);
        } catch (Exception e) {
            Util.printException("marca_productoDAO.elimina", e);
        }
        return filaEliminada;       
    }

    /***
     * Modifica la informacion del marca_producto enviado por parametro.
     * @param paramMarcaProd
     * @return 
     */
    public boolean actualiza(marca_producto paramMarcaProd){
        boolean filaActualizada=false;
        PreparedStatement ps = null;
        
        try {
            ps = cbd.getConexion().prepareStatement(cnSQLActualizaPorID);
            ps.setString(1, paramMarcaProd.getNombre_marca_producto());
            ps.setInt(2, paramMarcaProd.getId_marca_producto());
            filaActualizada = ( ps.executeUpdate() > 0);            
        } catch (SQLException ex) {
            Util.printSQLException("marca_productoDAO.actualiza", ex);
        } catch (Exception e) {
            Util.printException("marca_productoDAO.actualiza", e);
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
            Util.printException("marca_productoDAO.cierra", e);
        }        
    }

}
