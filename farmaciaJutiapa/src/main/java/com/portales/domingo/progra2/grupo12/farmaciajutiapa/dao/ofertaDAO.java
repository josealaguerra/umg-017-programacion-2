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


    public ofertaDAO() throws Exception {
        cbd = new ConectaBD();
    }

    
    public void inserta(oferta of){
    
        PreparedStatement ps = null;
        try {
            ps = cbd.getConexion().prepareStatement(cnSQLInserta);
            ps.setInt(1, of.getId_marca_producto());
            ps.setInt(2, of.getId_tipo_producto());
            ps.setInt(3, of.getId_producto());
            ps.setDouble(4, of.getPorcentaje_descuento());
            ps.setDate(5,Util.utilDate2sqlDate(of.getFecha_inicio()));
            ps.setDate(6, Util.utilDate2sqlDate(of.getFecha_final()));
            ps.setInt(7, of.getId_oferta());

            //rs=ps.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(personaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
        
    
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
            
        } catch (Exception ex) {
            Logger.getLogger(personaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaOferta;
       
    }
    
    
    public oferta seleccionaPorID(int IDOferta){
        
        oferta nuevoProd=null;
        PreparedStatement ps = null;
        ResultSet rs=null;
        
        try {
            ps = cbd.getConexion().prepareStatement(cnSQLSeleccionaPorID);
            ps.setInt(1, IDOferta);
            rs=ps.executeQuery();
            while(rs.next()){
                nuevoProd = new oferta(            rs.getInt("id_oferta"),
                                                   rs.getInt(" id_marca_producto"), 
                                                   rs.getInt("id_tipo_producto"), 
                                                   rs.getInt("id_producto"), 
                                                   rs.getDouble("porcentaje_descuent"), 
                                                   rs.getDate("fecha_inicio"), 
                                                   rs.getDate("fecha_final"));
            }
            
        } catch (Exception ex) {
            Logger.getLogger(personaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return nuevoProd;
       
    }
    
    
    public boolean elimina(int IDOferta){
        
        boolean filaEliminada=false;
        PreparedStatement ps = null;
        
        try {
            ps = cbd.getConexion().prepareStatement(cnSQLEliminaPorID);
            ps.setInt(1, IDOferta);
            filaEliminada=( ps.executeUpdate() > 0);
            
        } catch (Exception ex) {
            Logger.getLogger(personaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return filaEliminada;
       
    }

    
    public boolean actualiza(oferta of){
        boolean filaActualizada=false;
        PreparedStatement ps = null;
        try {
             ps = cbd.getConexion().prepareStatement(cnSQLInserta);
            ps.setInt(1, of.getId_marca_producto());
            ps.setInt(2, of.getId_tipo_producto());
            ps.setInt(3, of.getId_producto());
            ps.setDouble(4, of.getPorcentaje_descuento());
            ps.setDate(5,Util.utilDate2sqlDate(of.getFecha_inicio()));
            ps.setDate(6, Util.utilDate2sqlDate(of.getFecha_final()));
            ps.setInt(7, of.getId_oferta());       
       
        } catch (SQLException ex) {
            Logger.getLogger(personaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return filaActualizada;
       
    }

    
    private void printSQLException(SQLException ex){
        for(Throwable e:ex){
            if(e instanceof SQLException){
                e.printStackTrace(System.err);
                System.err.println("SQL State");
                
            }
                
        }
    }

}
