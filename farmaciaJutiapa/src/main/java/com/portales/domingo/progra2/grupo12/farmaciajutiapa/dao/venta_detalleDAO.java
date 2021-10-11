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
public class venta_detalleDAO {

    private ConectaBD cbd = null;
    private static final String cnSQLTabla="venta_detalle";   
    private static final String cnSQLInserta=" INSERT INTO "+cnSQLTabla+" (id_venta, id_marca_producto, id_tipo_producto, id_producto, precio_unitario_venta, cantidad) values (?, ?, ?, ?, ?, ?)";
    private static final String cnSQLSeleccionaPorID=" SELECT id_venta_detalle, id_venta, id_marca_producto, id_tipo_producto, id_producto, precio_unitario_venta, cantidad FROM "+cnSQLTabla+" WHERE id_venta_detalle = ? ";
    private static final String cnSQLSeleccionaTodo=" SELECT id_venta_detalle, id_venta, id_marca_producto, id_tipo_producto, id_producto, precio_unitario_venta, cantidad FROM "+cnSQLTabla+"  ";
    private static final String cnSQLEliminaPorID=" delete FROM "+cnSQLTabla+" WHERE id_venta_detalle = ? ";
    private static final String cnSQLActualizaPorID=" update "+cnSQLTabla+" set id_venta= ?,id_marca_producto= ?, id_tipo_producto= ?, id_producto= ?, precio_unitario_venta = ?, cantidad= ? WHERE id_venta_detalle = ? ";

    /***
     * Constructor venta_detalleDAO
     * @throws Exception 
     */
    public venta_detalleDAO() throws Exception {
        cbd = new ConectaBD();
    }

    /***
     * Inserta un registro en la tabla venta_detalle
     * @param vd - objeto de la clase "venta_detalle"
     * @return verdadero, si inserto correctamente en la tabla venta_detalle
     */
    public boolean inserta(venta_detalle vd){
        boolean filaInsertada=false;
        PreparedStatement ps = null;
        try {
            ps = cbd.getConexion().prepareStatement(cnSQLInserta);
            ps.setInt(1, vd.getId_venta());
            ps.setInt(2, vd.getId_marca_producto());
            ps.setInt(3, vd.getId_tipo_producto());
            ps.setInt(4, vd.getId_producto());
            ps.setDouble(5, vd.getPrecio_unitario_venta());
            ps.setInt(6, vd.getCantidad());
            filaInsertada= ( ps.executeUpdate() >0) ;          
        } catch (SQLException ex) {
            Util.printSQLException("accesoDAO.inserta", ex);
        } catch (Exception e) {
            Util.printException("accesoDAO.inserta", e);
        }
        return filaInsertada;
    }
        
    /***
     * Selecciona todos los registros de la tabla venta_detalle
     * @return 
     */
    public List<venta_detalle> seleccionaTodo(){
        List<venta_detalle> listaVentaD=null;
        venta_detalle nuevaVentaDet=null;
        PreparedStatement ps = null;
        ResultSet rs=null;
        
        try {
            listaVentaD=new ArrayList<>();
            ps = cbd.getConexion().prepareStatement(cnSQLSeleccionaTodo);
            rs=ps.executeQuery();
            while(rs.next()){
                listaVentaD.add( new venta_detalle( rs.getInt("id_venta_detalle"), 
                                                    rs.getInt("id_venta"), 
                                                    rs.getInt("id_marca_producto"), 
                                                    rs.getInt("id_tipo_producto"), 
                                                    rs.getInt("id_producto"), 
                                                    rs.getDouble("precio_unitario_venta"), 
                                                    rs.getInt("cantidad")));
                                                  
            }
        } catch (SQLException ex) {
            Util.printSQLException("accesoDAO.seleccionaTodo", ex);
        } catch (Exception e) {
            Util.printException("accesoDAO.seleccionaTodo", e);
        }
        return listaVentaD;
       
    }
    
    /***
     * Selecciona un venta_detalle, según su ID
     * @param IDVentaDetalle
     * @return 
     */
    public venta_detalle seleccionaPorID(int IDVentaDetalle){
        venta_detalle nuevaVentaDet=null;
        PreparedStatement ps = null;
        ResultSet rs=null;
        try {
            ps = cbd.getConexion().prepareStatement(cnSQLSeleccionaPorID);
            ps.setInt(1, IDVentaDetalle);
            rs=ps.executeQuery();
            while(rs.next()){
                nuevaVentaDet = new venta_detalle(  rs.getInt("id_venta_detalle"), 
                                                    rs.getInt("id_venta"), 
                                                    rs.getInt("id_marca_producto"), 
                                                    rs.getInt("id_tipo_producto"), 
                                                    rs.getInt("id_producto"), 
                                                    rs.getDouble("precio_unitario_venta"), 
                                                    rs.getInt("cantidad"));
            }
        } catch (SQLException ex) {
            Util.printSQLException("venta_detalleDAO.seleccionaPorID", ex);
        } catch (Exception e) {
            Util.printException("venta_detalleDAO.seleccionaPorID", e);
        }
        return nuevaVentaDet;
    }
    
    /***
     * Elimina el venta_detalle con el ID enviado.
     * @param IDVentaDetalle
     * @return 
     */
    public boolean elimina(int IDVentaDetalle){
        boolean filaEliminada=false;
        PreparedStatement ps = null;        
        try {
            ps = cbd.getConexion().prepareStatement(cnSQLEliminaPorID);
            ps.setInt(1, IDVentaDetalle);
            filaEliminada=( ps.executeUpdate() > 0);
        } catch (SQLException ex) {
            Util.printSQLException("venta_detalleDAO.elimina", ex);
        } catch (Exception e) {
            Util.printException("venta_detalleDAO.elimina", e);
        }
        return filaEliminada;       
    }

    /***
     * Modifica la informacion del venta_detalle enviado por parametro.
     * @param vd
     * @return 
     */
    public boolean actualiza(venta_detalle vd){
        boolean filaActualizada=false;
        PreparedStatement ps = null;
        try {
            ps = cbd.getConexion().prepareStatement(cnSQLActualizaPorID);
            ps.setInt(1, vd.getId_venta());
            ps.setInt(2, vd.getId_marca_producto());
            ps.setInt(3, vd.getId_tipo_producto());
            ps.setInt(4, vd.getId_producto());
            ps.setDouble(5, vd.getPrecio_unitario_venta());
            ps.setInt(6, vd.getCantidad());
            ps.setInt(7, vd.getId_venta_detalle());
            filaActualizada = ( ps.executeUpdate() > 0);       
        } catch (SQLException ex) {
            Util.printSQLException("venta_detalleDAO.actualiza", ex);
        } catch (Exception e) {
            Util.printException("venta_detalleDAO.actualiza", e);
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
            Util.printException("venta_detalleDAO.cierra", e);
        }        
    }

}
