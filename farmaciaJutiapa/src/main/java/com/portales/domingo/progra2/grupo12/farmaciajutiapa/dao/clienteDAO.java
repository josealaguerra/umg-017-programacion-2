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
public class clienteDAO {

    private ConectaBD cbd = null;
    private static final String cnSQLTabla="cliente";   
    private static final String cnSQLInserta=" INSERT INTO "+cnSQLTabla+" (id_empresa, id_persona) values (?, ?)";
    private static final String cnSQLSeleccionaPorID=" SELECT id_cliente, id_empresa, id_persona FROM "+cnSQLTabla+" WHERE id_persona = ? ";
    private static final String cnSQLSeleccionaTodo=" SELECT id_cliente, id_empresa, id_persona FROM "+cnSQLTabla+"  ";
    private static final String cnSQLEliminaPorID=" delete FROM "+cnSQLTabla+" WHERE id_cliente = ? ";
    private static final String cnSQLActualizaPorID=" update "+cnSQLTabla+" set id_empresa= ?, id_persona WHERE id_cliente = ? ";

    /***
     * Constructor clienteDAO
     * @throws Exception 
     */
    public clienteDAO() throws Exception {
        cbd = new ConectaBD();
    }

    /***
     * Inserta un registro en la tabla cliente
     * @param c - objeto de la clase "cliente"
     * @return verdadero, si inserto correctamente en la tabla cliente
     */
    public boolean inserta(cliente c){
        boolean filaInsertada=false;
        PreparedStatement ps = null;
        try {
            ps = cbd.getConexion().prepareStatement(cnSQLInserta);
            ps.setInt(1, c.getId_empresa());
            ps.setInt(2, c.getId_persona());
            filaInsertada= ( ps.executeUpdate() >0) ;          
        } catch (SQLException ex) {
            Util.printSQLException("clienteDAO.inserta", ex);
        } catch (Exception e) {
            Util.printException("clienteDAO.inserta", e);
        }
        return filaInsertada;
    }
        
    /***
     * Selecciona todos los registros de la tabla cliente
     * @return 
     */
    public List<cliente> seleccionaTodo(){
        List<cliente> listaCliente=null;
        cliente nuevoCliente=null;
        PreparedStatement ps = null;
        ResultSet rs=null;
        
        try {
            listaCliente=new ArrayList<>();
            ps = cbd.getConexion().prepareStatement(cnSQLSeleccionaTodo);
            rs=ps.executeQuery();
            while(rs.next()){
                listaCliente.add( new cliente(  rs.getInt("id_cliente"), 
                                                rs.getInt("id_empresa"), 
                                                rs.getInt("id_persona")) );
                                                   
            }
            
        } catch (SQLException ex) {
            Util.printSQLException("clienteDAO.seleccionaTodo", ex);
        } catch (Exception e) {
            Util.printException("clienteDAO.seleccionaTodo", e);
        }
        return listaCliente;
       
    }
    
    /***
     * Selecciona un cliente, según su ID
     * @param IDCliente
     * @return 
     */
    public cliente seleccionaPorID(int IDCliente){
        
        cliente nuevoCliente=null;
        PreparedStatement ps = null;
        ResultSet rs=null;
        
        try {
            ps = cbd.getConexion().prepareStatement(cnSQLSeleccionaPorID);
            ps.setInt(1, IDCliente);
            rs=ps.executeQuery();
            while(rs.next()){
                nuevoCliente = new cliente( rs.getInt("id_cliente"), 
                                            rs.getInt("id_empresa"), 
                                            rs.getInt("id_persona") );
            }
            
        } catch (SQLException ex) {
            Util.printSQLException("clienteDAO.seleccionaPorID", ex);
        } catch (Exception e) {
            Util.printException("clienteDAO.seleccionaPorID", e);
        }
        return nuevoCliente;
       
    }
    
    
    /***
     * Elimina el cliente con el ID enviado.
     * @param IDCliente
     * @return 
     */
    public boolean elimina(int IDCliente){
        boolean filaEliminada=false;
        PreparedStatement ps = null;
        
        try {
            ps = cbd.getConexion().prepareStatement(cnSQLEliminaPorID);
            ps.setInt(1, IDCliente);
            filaEliminada=( ps.executeUpdate() > 0);
            
        } catch (SQLException ex) {
            Util.printSQLException("clienteDAO.elimina", ex);
        } catch (Exception e) {
            Util.printException("clienteDAO.elimina", e);
        }
        return filaEliminada;
       
    }

    /***
     * Modifica la informacion del cliente enviado por parametro.
     * @param c
     * @return 
     */
    public boolean actualiza(cliente c){
        boolean filaActualizada=false;
        PreparedStatement ps = null;
        try {
            ps = cbd.getConexion().prepareStatement(cnSQLActualizaPorID);
             ps.setInt(1, c.getId_empresa());
            ps.setInt(2, c.getId_persona());
            ps.setInt(3, c.getId_cliente());
        } catch (SQLException ex) {
            Logger.getLogger(personaDAO.class.getName()).log(Level.SEVERE, null, ex);
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
            Util.printException("clienteDAO.cierra", e);
        }        
    }

}
