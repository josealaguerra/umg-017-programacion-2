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
public class ventaDAO {

    private ConectaBD cbd = null;
    private static final String cnSQLTabla="venta";   
    private static final String cnSQLInserta=" INSERT INTO "+cnSQLTabla+" (id_cliente, fecha_venta, numero_factura, monto_total) values (?, ?, ?, ?)";
    private static final String cnSQLSeleccionaPorID=" SELECT id_venta, id_cliente, fecha_venta, numero_factura, monto_total FROM "+cnSQLTabla+" WHERE id_venta = ? ";
    private static final String cnSQLSeleccionaTodo=" SELECT id_venta, id_cliente, fecha_venta, numero_factura, monto_total FROM "+cnSQLTabla+"  ";
    private static final String cnSQLEliminaPorID=" delete FROM "+cnSQLTabla+" WHERE id_venta = ? ";
    private static final String cnSQLActualizaPorID=" update "+cnSQLTabla+" set id_cliente= ?, fecha_venta= ?, numero_factura= ?, monto_total= ?  WHERE id_venta = ? ";

    
    public ventaDAO() throws Exception {
        cbd = new ConectaBD();
    }

    
    public void inserta(venta v){
    
        PreparedStatement ps = null;
        try {
            ps = cbd.getConexion().prepareStatement(cnSQLInserta);
            ps.setInt(1, v.getId_cliente());
            ps.setDate(2,Util.utilDate2sqlDate(v.getFecha_venta()));
            ps.setString(3, v.getNumero_factura());
            ps.setDouble(4, v.getMonto_total());
            ps.setInt(5, v.getId_venta());
           
        } catch (SQLException ex) {
            Logger.getLogger(personaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
        
    
    public List<venta> seleccionaTodo(){
        List<venta> listaVentas=null;
        venta nuevap=null;
        PreparedStatement ps = null;
        ResultSet rs=null;
        
        try {
            listaVentas=new ArrayList<>();
            ps = cbd.getConexion().prepareStatement(cnSQLSeleccionaTodo);
            rs=ps.executeQuery();
            while(rs.next()){
                listaVentas.add( new venta(     rs.getInt("id_venta"), 
                                                    rs.getInt("id_cliente"), 
                                                    rs.getDate("fecha_venta"), 
                                                    rs.getString("numero_factura"), 
                                                    rs.getDouble("monto_total")));
                                                    
            }
            
        } catch (Exception ex) {
            Logger.getLogger(personaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaVentas;
       
    }
    
    
    public venta seleccionaPorID(int IDVentas){
        
        venta nuevap=null;
        PreparedStatement ps = null;
        ResultSet rs=null;
        
        try {
            ps = cbd.getConexion().prepareStatement(cnSQLSeleccionaPorID);
            ps.setInt(1, IDVentas);
            rs=ps.executeQuery();
            while(rs.next()){
                nuevap = new venta(   rs.getInt("id_venta"), 
                                                    rs.getInt("id_cliente"), 
                                                    rs.getDate("fecha_venta"), 
                                                    rs.getString("numero_factura"), 
                                                    rs.getDouble("monto_total"));
            }
            
        } catch (Exception ex) {
            Logger.getLogger(personaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return nuevap;
       
    }
    
    
    public boolean elimina(int IDVentas){
        
        boolean filaEliminada=false;
        PreparedStatement ps = null;
        
        try {
            ps = cbd.getConexion().prepareStatement(cnSQLEliminaPorID);
            ps.setInt(1, IDVentas);
            filaEliminada=( ps.executeUpdate() > 0);
            
        } catch (Exception ex) {
            Logger.getLogger(personaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return filaEliminada;
       
    }

    
    public boolean actualiza(venta v){
        boolean filaActualizada=false;
        PreparedStatement ps = null;
        try {
            ps = cbd.getConexion().prepareStatement(cnSQLActualizaPorID);
            ps.setInt(1, v.getId_cliente());
            ps.setDate(2,Util.utilDate2sqlDate(v.getFecha_venta()));
            ps.setString(3, v.getNumero_factura());
            ps.setDouble(4, v.getMonto_total());
            ps.setInt(5, v.getId_venta());
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
