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
public class compra_detalleDAO {

    private ConectaBD cbd = null;
    private static final String cnSQLTabla="compra_detalle";   
    private static final String cnSQLInserta=" INSERT INTO "+cnSQLTabla+" (id_compra, id_marca_producto, id_tipo_producto, id_producto, precio_unitario_compra, cantidad ) values ( ?, ?, ?, ?, ?, ?)";
    private static final String cnSQLSeleccionaPorID=" SELECT id_compra_detalle, id_compra, id_marca_producto, id_tipo_producto, id_producto, precio_unitario_compra, cantidad FROM "+cnSQLTabla+" WHERE id_compra_detalle = ? ";
    private static final String cnSQLSeleccionaTodo=" SELECT id_compra_detalle, id_compra, id_marca_producto, id_tipo_producto, id_producto, precio_unitario_compra, cantidad FROM "+cnSQLTabla+"  ";
    private static final String cnSQLEliminaPorID=" delete FROM "+cnSQLTabla+" WHERE id_compra_detalle = ? ";
    private static final String cnSQLActualizaPorID=" update "+cnSQLTabla+" set id_compra_detalle = ?, id_compra= ?, id_marca_producto= ?, id_tipo_producto= ?, id_producto= ?, precio_unitario_compra= ?, cantidad= ? WHERE id_compra_detalle = ? ";
    private static final String cnSQLSeleccionaTodoPorIDCompra=" SELECT id_compra_detalle, id_compra, id_marca_producto, id_tipo_producto, id_producto, precio_unitario_compra, cantidad FROM "+cnSQLTabla+" WHERE id_compra = ? ";

    /***
     * Constructor compra_detalleDAO
     * @throws Exception 
     */
    public compra_detalleDAO() throws Exception {
        cbd = new ConectaBD();
    }

    /***
     * Inserta un registro en la tabla compra_detalle
     * @param compraDet - objeto de la clase "compra_detalle"
     * @return verdadero, si inserto correctamente en la tabla compra_detalle
     */
    public boolean inserta(compra_detalle compraDet){
        boolean filaInsertada=false;
        PreparedStatement ps = null;
        try {
            ps = cbd.getConexion().prepareStatement(cnSQLInserta);  
            ps.setInt(1, compraDet.getId_compra());
            ps.setInt(2, compraDet.getId_marca_producto());
            ps.setDouble(3, compraDet.getId_tipo_producto());
            ps.setInt(4, compraDet.getId_producto());
            ps.setDouble(5, compraDet.getPrecio_unitario_compra());
            ps.setInt(6, compraDet.getCantidad());
            filaInsertada= ( ps.executeUpdate() >0) ;
        } catch (SQLException ex) {
            Util.printSQLException("compra_detalleDAO.inserta", ex);
        } catch (Exception e) {
            Util.printException("compra_detalleDAO.inserta", e);
        }
        return filaInsertada;
    }
        
    /***
     * Selecciona todos los registros de la tabla compra_detalle
     * @return 
     */    
    public List<compra_detalle> seleccionaTodo(int paramIDCompra){
        List<compra_detalle> listaCompraDet=null;
        PreparedStatement ps = null;
        ResultSet rs=null;
        
        try {
            listaCompraDet=new ArrayList<>();
            ps = cbd.getConexion().prepareStatement(cnSQLSeleccionaTodoPorIDCompra);
            ps.setInt(1, paramIDCompra);
            rs=ps.executeQuery();
            while(rs.next()){
                listaCompraDet.add( new compra_detalle( rs.getInt("id_compra_detalle"), 
                                                        rs.getInt("id_compra"), 
                                                        rs.getInt("id_marca_producto"), 
                                                        rs.getInt("id_tipo_producto"), 
                                                        rs.getInt("id_producto"), 
                                                        rs.getDouble("precio_unitario_compra"), 
                                                        rs.getInt("cantidad")));
                                                    
            }
            
        } catch (SQLException ex) {
            Util.printSQLException("compra_detalleDAO.seleccionaTodo", ex);
        } catch (Exception e) {
            Util.printException("compra_detalleDAO.seleccionaTodo", e);
        }
        return listaCompraDet;
    }
    
    /***
     * Selecciona un compra_detalle, según su ID
     * @param IDCompraDet
     * @return 
     */
    public compra_detalle seleccionaPorID(int IDCompraDet){
        compra_detalle nuevaCompraDet=null;
        PreparedStatement ps = null;
        ResultSet rs=null;
        
        try {
            ps = cbd.getConexion().prepareStatement(cnSQLSeleccionaPorID);
            ps.setInt(1, IDCompraDet);
            rs=ps.executeQuery();
            while(rs.next()){
                nuevaCompraDet = new compra_detalle(    rs.getInt("id_compra_detalle"), 
                                                        rs.getInt("id_compra"), 
                                                        rs.getInt("id_marca_producto"), 
                                                        rs.getInt("id_tipo_producto"), 
                                                        rs.getInt("id_producto"), 
                                                        rs.getDouble("precio_unitario_compra"), 
                                                        rs.getInt("cantidad "));
            }
            
        } catch (SQLException ex) {
            Util.printSQLException("compra_detalleDAO.seleccionaPorID", ex);
        } catch (Exception e) {
            Util.printException("compra_detalleDAO.seleccionaPorID", e);
        }
        return nuevaCompraDet;
       
    }
    
    /***
     * Elimina el compra_detalle con el ID enviado.
     * @param IDCompraDet
     * @return 
     */    
    public boolean elimina(int IDCompraDet){
        boolean filaEliminada=false;
        PreparedStatement ps = null;
        
        try {
            ps = cbd.getConexion().prepareStatement(cnSQLEliminaPorID);
            ps.setInt(1, IDCompraDet);
            filaEliminada=( ps.executeUpdate() > 0);
        } catch (SQLException ex) {
            Util.printSQLException("compra_detalleDAO.elimina", ex);
        } catch (Exception e) {
            Util.printException("compra_detalleDAO.elimina", e);
        }
        return filaEliminada;
       
    }

    /***
     * Modifica la informacion del compra_detalle enviado por parametro.
     * @param acc
     * @return 
     */    
    public boolean actualiza(compra_detalle compraDet){
        boolean filaActualizada=false;
        PreparedStatement ps = null;
        try {
            ps = cbd.getConexion().prepareStatement(cnSQLActualizaPorID);
           ps = cbd.getConexion().prepareStatement(cnSQLInserta);  
            ps.setInt(1, compraDet.getId_compra());
            ps.setInt(2, compraDet.getId_marca_producto());
            ps.setDouble(3, compraDet.getId_tipo_producto());
            ps.setInt(4, compraDet.getId_producto());
             ps.setDouble(5, compraDet.getPrecio_unitario_compra());
             ps.setInt(6, compraDet.getCantidad());
              ps.setInt(7, compraDet.getId_compra_detalle());
        } catch (SQLException ex) {
            Util.printSQLException("compra_detalleDAO.actualiza", ex);
        } catch (Exception e) {
            Util.printException("compra_detalleDAO.actualiza", e);
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
            Util.printException("compra_detalleDAO.cierra", e);
        }        
    }
 

}
