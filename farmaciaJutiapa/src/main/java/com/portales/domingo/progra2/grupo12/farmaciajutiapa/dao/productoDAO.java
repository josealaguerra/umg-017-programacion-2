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
public class productoDAO {
    
    private ConectaBD cbd = null;
    private static final String cnSQLTabla="producto";   
    private static final String cnSQLInserta=" INSERT INTO "+cnSQLTabla+" (nombre_producto, id_tipo_producto, id_marca_producto) values (?, ?, ?)";
    private static final String cnSQLSeleccionaPorID=" SELECT id_producto, nombre_producto, id_tipo_producto, id_marca_producto FROM "+cnSQLTabla+" WHERE id_producto = ? ";
    private static final String cnSQLSeleccionaTodo=" SELECT id_producto, nombre_producto, id_tipo_producto, id_marca_producto FROM "+cnSQLTabla+"  ";
    private static final String cnSQLEliminaPorID=" delete FROM "+cnSQLTabla+" WHERE id_producto = ? ";
    private static final String cnSQLActualizaPorID=" update "+cnSQLTabla+" set  nombre_producto = ?, id_tipo_producto = ?, id_marca_producto = ? WHERE id_producto = ? ";

    /***
     * Constructor productoDAO
     * @throws Exception 
     */
    public productoDAO() throws Exception {
        cbd = new ConectaBD();
    }


    /***
     * Inserta un registro en la tabla producto
     * @param acc - objeto de la clase "producto"
     * @return verdadero, si inserto correctamente en la tabla producto
     */
    public boolean inserta(producto prod){
        boolean filaInsertada=false;
        PreparedStatement ps = null;
        try {
            ps = cbd.getConexion().prepareStatement(cnSQLInserta);
            ps.setString(1, prod.getNombre_producto());
            ps.setInt(2, prod.getId_tipo_producto());
            ps.setInt(3, prod.getId_marca_producto());
            filaInsertada= ( ps.executeUpdate() >0) ;          
        } catch (SQLException ex) {
            Util.printSQLException("productoDAO.inserta", ex);
        } catch (Exception e) {
            Util.printException("productoDAO.inserta", e);
        }
        return filaInsertada;
    }
        
    /***
     * Selecciona todos los registros de la tabla producto
     * @return 
     */
    public List<producto> seleccionaTodo(){
        List<producto> listaProductos=null;
        PreparedStatement ps = null;
        ResultSet rs=null;
        try {
            listaProductos=new ArrayList<>();
            ps = cbd.getConexion().prepareStatement(cnSQLSeleccionaTodo);
            rs=ps.executeQuery();
            while(rs.next()){
                listaProductos.add( new producto(   rs.getInt("id_producto"), 
                                                    rs.getString("nombre_producto"), 
                                                    rs.getInt("id_tipo_producto"), 
                                                    rs.getInt("id_marca_producto") ));
            }
        } catch (SQLException ex) {
            Util.printSQLException("productoDAO.seleccionaTodo", ex);
        } catch (Exception e) {
            Util.printException("productoDAO.seleccionaTodo", e);
        }
        return listaProductos;
    }
    
    /***
     * Selecciona un producto, según su ID
     * @param IDProducto
     * @return 
     */
    public producto seleccionaPorID(int IDProducto){
        producto nuevoProd=null;
        PreparedStatement ps = null;
        ResultSet rs=null;
        try {
            ps = cbd.getConexion().prepareStatement(cnSQLSeleccionaPorID);
            ps.setInt(1, IDProducto);
            rs=ps.executeQuery();
            while(rs.next()){
                nuevoProd = new producto(   rs.getInt("id_producto"), 
                                            rs.getString("nombre_producto"), 
                                            rs.getInt("id_tipo_producto"), 
                                            rs.getInt("id_marca_producto") );
            }
        } catch (SQLException ex) {
            Util.printSQLException("productoDAO.seleccionaPorID", ex);
        } catch (Exception e) {
            Util.printException("productoDAO.seleccionaPorID", e);
        }
        return nuevoProd;       
    }
    
    /***
     * Elimina el producto con el ID enviado.
     * @param IDProducto
     * @return 
     */
    public boolean elimina(int IDProducto){
        boolean filaEliminada=false;
        PreparedStatement ps = null;
        try {
            ps = cbd.getConexion().prepareStatement(cnSQLEliminaPorID);
            ps.setInt(1, IDProducto);
            filaEliminada=( ps.executeUpdate() > 0);
        } catch (SQLException ex) {
            Util.printSQLException("productoDAO.elimina", ex);
        } catch (Exception e) {
            Util.printException("productoDAO.elimina", e);
        }
        return filaEliminada;       
    }

    /***
     * Modifica la informacion del producto enviado por parametro.
     * @param prod
     * @return 
     */
    public boolean actualiza(producto prod){
        boolean filaActualizada=false;
        PreparedStatement ps = null;
        try {
            ps = cbd.getConexion().prepareStatement(cnSQLActualizaPorID);
            ps.setString(1, prod.getNombre_producto());
            ps.setInt(2, prod.getId_tipo_producto());
            ps.setInt(3, prod.getId_marca_producto());
            ps.setInt(4, prod.getId_producto());        
            filaActualizada = ( ps.executeUpdate() > 0);            
       
        } catch (SQLException ex) {
            Util.printSQLException("productoDAO.actualiza", ex);
        } catch (Exception e) {
            Util.printException("productoDAO.actualiza", e);
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
            Util.printException("productoDAO.cierra", e);
        }        
    }
        
}
