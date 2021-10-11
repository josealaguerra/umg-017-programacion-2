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

    /***
     * Constructor ventaDAO
     * @throws Exception 
     */
    public ventaDAO() throws Exception {
        cbd = new ConectaBD();
    }

    /***
     * Inserta un registro en la tabla venta
     * @param v - objeto de la clase "venta"
     * @return verdadero, si inserto correctamente en la tabla venta
     */
    public boolean inserta(venta v){
        boolean filaInsertada=false;
        PreparedStatement ps = null;
        try {
            ps = cbd.getConexion().prepareStatement(cnSQLInserta);
            ps.setInt(1, v.getId_cliente());
            ps.setDate(2,Util.utilDate2sqlDate(v.getFecha_venta()));
            ps.setString(3, v.getNumero_factura());
            ps.setDouble(4, v.getMonto_total());
            filaInsertada= ( ps.executeUpdate() >0) ;          
        } catch (SQLException ex) {
            Util.printSQLException("ventaDAO.inserta", ex);
        } catch (Exception e) {
            Util.printException("ventaDAO.inserta", e);
        } 
        return filaInsertada;
    }
        
    /***
     * Selecciona todos los registros de la tabla venta
     * @return 
     */
    public List<venta> seleccionaTodo(){
        List<venta> listaVentas=null;
        PreparedStatement ps = null;
        ResultSet rs=null;
        
        try {
            listaVentas=new ArrayList<>();
            ps = cbd.getConexion().prepareStatement(cnSQLSeleccionaTodo);
            rs=ps.executeQuery();
            while(rs.next()){
                listaVentas.add( new venta( rs.getInt("id_venta"), 
                                            rs.getInt("id_cliente"), 
                                            rs.getDate("fecha_venta"), 
                                            rs.getString("numero_factura"), 
                                            rs.getDouble("monto_total")));
                                                    
            }
        } catch (SQLException ex) {
            Util.printSQLException("ventaDAO.seleccionaTodo", ex);
        } catch (Exception e) {
            Util.printException("ventaDAO.seleccionaTodo", e);
        }
        return listaVentas;
       
    }
    
    /***
     * Selecciona un venta, según su ID
     * @param IDVentas
     * @return 
     */
    public venta seleccionaPorID(int IDVentas){
        venta nuevaVenta=null;
        PreparedStatement ps = null;
        ResultSet rs=null;
        try {
            ps = cbd.getConexion().prepareStatement(cnSQLSeleccionaPorID);
            ps.setInt(1, IDVentas);
            rs=ps.executeQuery();
            while(rs.next()){
                nuevaVenta = new venta(   rs.getInt("id_venta"), 
                                                    rs.getInt("id_cliente"), 
                                                    rs.getDate("fecha_venta"), 
                                                    rs.getString("numero_factura"), 
                                                    rs.getDouble("monto_total"));
            }
        } catch (SQLException ex) {
            Util.printSQLException("ventaDAO.seleccionaPorID", ex);
        } catch (Exception e) {
            Util.printException("ventaDAO.seleccionaPorID", e);
        }
        return nuevaVenta;
    }
    
    /***
     * Elimina el venta con el ID enviado.
     * @param IDVentas
     * @return 
     */
    public boolean elimina(int IDVentas){
        boolean filaEliminada=false;
        PreparedStatement ps = null;
        try {
            ps = cbd.getConexion().prepareStatement(cnSQLEliminaPorID);
            ps.setInt(1, IDVentas);
            filaEliminada=( ps.executeUpdate() > 0);
        } catch (SQLException ex) {
            Util.printSQLException("ventaDAO.elimina", ex);
        } catch (Exception e) {
            Util.printException("ventaDAO.elimina", e);
        }
        return filaEliminada;
    }

    /***
     * Modifica la informacion del venta enviado por parametro.
     * @param acc
     * @return 
     */
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
            filaActualizada = ( ps.executeUpdate() > 0);            
        } catch (SQLException ex) {
            Util.printSQLException("ventaDAO.actualiza", ex);
        } catch (Exception e) {
            Util.printException("ventaDAO.actualiza", e);
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
            Util.printException("ventaDAO.cierra", e);
        }        
    }
  

}
