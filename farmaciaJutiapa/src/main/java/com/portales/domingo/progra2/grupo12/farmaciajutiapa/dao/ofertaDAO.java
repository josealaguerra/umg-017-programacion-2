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
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author josea
 */
public class ofertaDAO {
    private ConectaBD cbd = null;
    private static final String cnSQLTabla="oferta";   
    private static final String cnSQLInserta=" INSERT INTO "+cnSQLTabla+" (id_marca_producto, id_tipo_producto, id_producto,porcentaje_descuento,fecha_inicio,fecha_final) values (?, ?, ?, ?, ?, ?)";
    private static final String cnSQLSeleccionaPorID=" SELECT id_oferta, id_marca_producto, id_tipo_producto, id_producto,porcentaje_descuento,fecha_inicio,fecha_final FROM "+cnSQLTabla+" WHERE id_oferta = ? ";
    private static final String cnSQLSeleccionaTodo=" SELECT id_oferta, id_marca_producto, id_tipo_producto, id_producto,porcentaje_descuento,fecha_inicio,fecha_final FROM "+cnSQLTabla+"  ";
    private static final String cnSQLEliminaPorID=" delete FROM "+cnSQLTabla+" WHERE id_oferta = ? ";
    private static final String cnSQLActualizaPorID=" update "+cnSQLTabla+" set id_oferta = ?, id_marca_producto = ?, id_tipo_producto = ?, id_producto = ?,porcentaje_descuento = ?, fecha_inicio = ?, fecha_final = ? WHERE id_oferta= ? ";

    /***
     * Constructor ofertaDAO
     * @throws Exception 
     */
    public ofertaDAO() throws Exception {
        cbd = new ConectaBD();
    }

    /***
     * Inserta un registro en la tabla oferta
     * @param paramOferta - objeto de la clase "oferta"
     * @return verdadero, si inserto correctamente en la tabla oferta
     */
    public boolean inserta(oferta paramOferta){
        boolean filaInsertada=false;
        PreparedStatement ps = null;
        try {
            ps = cbd.getConexion().prepareStatement(cnSQLInserta);
            ps.setInt(1, paramOferta.getId_marca_producto());
            ps.setInt(2, paramOferta.getId_tipo_producto());
            ps.setInt(3, paramOferta.getId_producto());
            ps.setDouble(4, paramOferta.getPorcentaje_descuento());
            ps.setDate(5, Util.utilDate2sqlDate( paramOferta.getFecha_inicio() ));
            ps.setDate(6, Util.utilDate2sqlDate( paramOferta.getFecha_final() ));
            filaInsertada= ( ps.executeUpdate() >0) ;          
        } catch (SQLException ex) {
            Util.printSQLException("ofertaDAO.inserta", ex);
        } catch (Exception e) {
            Util.printException("ofertaDAO.inserta", e);
        }
        return filaInsertada;
    }
        
    /***
     * Selecciona todos los registros de la tabla oferta
     * @return 
     */
    public List<oferta> seleccionaTodo(){
        List<oferta> listaOferta=null;
        PreparedStatement ps = null;
        ResultSet rs=null;
        
        try {
            listaOferta=new ArrayList<>();
            ps = cbd.getConexion().prepareStatement(cnSQLSeleccionaTodo);
            rs=ps.executeQuery();
            while(rs.next()){
                listaOferta.add( new oferta(       rs.getInt("id_oferta"),
                                                   rs.getInt(" id_marca_producto"), 
                                                   rs.getInt("id_tipo_producto"), 
                                                   rs.getInt("id_producto"), 
                                                   rs.getDouble("porcentaje_descuent"), 
                                                   rs.getDate("fecha_inicio"), 
                                                   rs.getDate("fecha_final")));
            }
        } catch (SQLException ex) {
            Util.printSQLException("ofertaDAO.seleccionaTodo", ex);
        } catch (Exception e) {
            Util.printException("ofertaDAO.seleccionaTodo", e);
        }
        return listaOferta;
       
    }
    
    /***
     * Selecciona un oferta, según su ID
     * @param IDOferta
     * @return 
     */
    public oferta seleccionaPorID(int IDOferta){
        oferta nuevaOferta=null;
        PreparedStatement ps = null;
        ResultSet rs=null;
        
        try {
            ps = cbd.getConexion().prepareStatement(cnSQLSeleccionaPorID);
            ps.setInt(1, IDOferta);
            rs=ps.executeQuery();
            while(rs.next()){
                nuevaOferta = new oferta(   rs.getInt("id_oferta"),
                                            rs.getInt(" id_marca_producto"), 
                                            rs.getInt("id_tipo_producto"), 
                                            rs.getInt("id_producto"), 
                                            rs.getDouble("porcentaje_descuent"), 
                                            rs.getDate("fecha_inicio"), 
                                            rs.getDate("fecha_final") );
            }
        } catch (SQLException ex) {
            Util.printSQLException("ofertaDAO.seleccionaPorID", ex);
        } catch (Exception e) {
            Util.printException("ofertaDAO.seleccionaPorID", e);
        }
        return nuevaOferta;
    }
    
    /***
     * Elimina el oferta con el ID enviado.
     * @param IDOferta
     * @return 
     */    
    public boolean elimina(int IDOferta){
        boolean filaEliminada=false;
        PreparedStatement ps = null;
        
        try {
            ps = cbd.getConexion().prepareStatement(cnSQLEliminaPorID);
            ps.setInt(1, IDOferta);
            filaEliminada=( ps.executeUpdate() > 0);
        } catch (SQLException ex) {
            Util.printSQLException("ofertaDAO.elimina", ex);
        } catch (Exception e) {
            Util.printException("ofertaDAO.elimina", e);
        }
        return filaEliminada;
       
    }

    /***
     * Modifica la informacion del oferta enviado por parametro.
     * @param paramOferta
     * @return 
     */
    public boolean actualiza(oferta paramOferta){
        boolean filaActualizada=false;
        PreparedStatement ps = null;
        try {
            ps = cbd.getConexion().prepareStatement(cnSQLActualizaPorID);
            ps.setInt(1, paramOferta.getId_marca_producto());
            ps.setInt(2, paramOferta.getId_tipo_producto());
            ps.setInt(3, paramOferta.getId_producto());
            ps.setDouble(4, paramOferta.getPorcentaje_descuento());
            ps.setDate(5,Util.utilDate2sqlDate(paramOferta.getFecha_inicio()));
            ps.setDate(6, Util.utilDate2sqlDate(paramOferta.getFecha_final()));
            ps.setInt(7, paramOferta.getId_oferta());       
            filaActualizada = ( ps.executeUpdate() > 0);            
       
        } catch (SQLException ex) {
            Util.printSQLException("ofertaDAO.actualiza", ex);
        } catch (Exception e) {
            Util.printException("ofertaDAO.actualiza", e);
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
            Util.printException("ofertaDAO.cierra", e);
        }        
    }

}
