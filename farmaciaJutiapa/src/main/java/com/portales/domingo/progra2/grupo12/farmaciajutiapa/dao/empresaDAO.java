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
public class empresaDAO {

    private ConectaBD cbd = null;
    private static final String cnSQLTabla="empresa";   
    private static final String cnSQLInserta=" INSERT INTO "+cnSQLTabla+" (nit, razonSocial, fechaDeConstitucion) values (?, ?, ?)";
    private static final String cnSQLSeleccionaPorID=" SELECT id_empresa, nit, razonSocial, fechaDeConstitucion FROM "+cnSQLTabla+" WHERE id_empresa = ? ";
    private static final String cnSQLSeleccionaTodo=" SELECT id_empresa, nit, razonSocial, fechaDeConstitucion FROM "+cnSQLTabla+"  ";
    private static final String cnSQLEliminaPorID=" delete FROM "+cnSQLTabla+" WHERE id_empresa = ? ";
    private static final String cnSQLActualizaPorID=" update "+cnSQLTabla+" set nit = ?,razonSocial = ?, fechaDeConstitucion = ? WHERE id_empresa = ? ";
    private static final String cnSQLSeleccionaPorNombre=" SELECT id_empresa, nit, razonSocial, fechaDeConstitucion FROM "+cnSQLTabla+" WHERE razonSocial = ? ";  
    private static final String cnCbxDefaultSelectionEmpresa=" -- Selecciona empresa --";
    private static final String cnCbxEmpresa=" select razonSocial from empresa order by razonSocial ";
    

    /***
     * Constructor empresaDAO
     * @throws Exception 
     */
    public empresaDAO() throws Exception {
        cbd = new ConectaBD();
    }

    /***
     * Inserta un registro en la tabla empresa
     * @param em - objeto de la clase "empresa"
     * @return verdadero, si inserto correctamente en la tabla empresa
     */
    public boolean inserta(empresa em){
        boolean filaInsertada=false;
        PreparedStatement ps = null;
        try {
            ps = cbd.getConexion().prepareStatement(cnSQLInserta);
            ps.setString(1, em.getNit());
            ps.setString(2, em.getRazonSocial());
            ps.setDate(3, Util.utilDate2sqlDate(em.getFechaDeConstitucion()));
            filaInsertada= ( ps.executeUpdate() >0) ;          
        } catch (SQLException ex) {
            Util.printSQLException("empresaDAO.inserta", ex);
        } catch (Exception e) {
            Util.printException("empresaDAO.inserta", e);
        }
        return filaInsertada;
    }
        
    /***
     * Selecciona todos los registros de la tabla empresa
     * @return 
     */
    public List<empresa> seleccionaTodo(){
        List<empresa> listaEmpresa=null;
        PreparedStatement ps = null;
        ResultSet rs=null;
        
        try {
            listaEmpresa=new ArrayList<>();
            ps = cbd.getConexion().prepareStatement(cnSQLSeleccionaTodo);
            rs=ps.executeQuery();
            while(rs.next()){
                listaEmpresa.add( new empresa(  rs.getInt("id_empresa"), 
                                                rs.getString("nit"), 
                                                rs.getString("razonSocial"),
                                                rs.getDate("fechaDeConstitucion")));
            }
        } catch (SQLException ex) {
            Util.printSQLException("empresaDAO.seleccionaTodo", ex);
        } catch (Exception e) {
            Util.printException("empresaDAO.seleccionaTodo", e);
        }
        return listaEmpresa;
       
    }
    
    /***
     * Selecciona un empresa, según su ID
     * @param IDEmpresa
     * @return 
     */
    public empresa seleccionaPorID(int IDEmpresa){
        empresa nuevaEmpresa=null;
        PreparedStatement ps = null;
        ResultSet rs=null;
        
        try {
            ps = cbd.getConexion().prepareStatement(cnSQLSeleccionaPorID);
            ps.setInt(1, IDEmpresa);
            rs=ps.executeQuery();
            while(rs.next()){
                nuevaEmpresa = new empresa( rs.getInt("id_empresa"), 
                                            rs.getString("nit"), 
                                            rs.getString("razonSocial"),
                                            rs.getDate("fechaDeConstitucion"));
            }
        } catch (SQLException ex) {
            Util.printSQLException("empresaDAO.seleccionaPorID", ex);
        } catch (Exception e) {
            Util.printException("empresaDAO.seleccionaPorID", e);
        }
        return nuevaEmpresa;
    }
    
    /***
     * Elimina el empresa con el ID enviado.
     * @param IDEmpresa
     * @return 
     */    
    public boolean elimina(int IDEmpresa){
        boolean filaEliminada=false;
        PreparedStatement ps = null;
        
        try {
            ps = cbd.getConexion().prepareStatement(cnSQLEliminaPorID);
            ps.setInt(1, IDEmpresa);
            filaEliminada=( ps.executeUpdate() > 0);
        } catch (SQLException ex) {
            Util.printSQLException("empresaDAO.elimina", ex);
        } catch (Exception e) {
            Util.printException("empresaDAO.elimina", e);
        }
        return filaEliminada;
    }

    /***
     * Modifica la informacion del empresa enviado por parametro.
     * @param em
     * @return 
     */
    public boolean actualiza(empresa em){
        boolean filaActualizada=false;
        PreparedStatement ps = null;
        
        try {
            ps = cbd.getConexion().prepareStatement(cnSQLActualizaPorID);
            ps.setString(1, em.getNit());
            ps.setString(2, em.getRazonSocial());
            ps.setDate(3, Util.utilDate2sqlDate(em.getFechaDeConstitucion()));
            ps.setInt(4, em.getId_empresa());
            filaActualizada = ( ps.executeUpdate() > 0);
        } catch (SQLException ex) {
            Util.printSQLException("empresaDAO.actualiza", ex);
        } catch (Exception e) {
            Util.printException("empresaDAO.actualiza", e);
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
            Util.printException("empresaDAO.cierra", e);
        }        
    }

    public empresa getEmpresaByName(String nameEmpresa) {
        empresa nuevaEmpresa=null;
        PreparedStatement ps = null;
        ResultSet rs=null;
        
        try {
            ps = cbd.getConexion().prepareStatement(cnSQLSeleccionaPorNombre);
            ps.setString(1, nameEmpresa);
            rs=ps.executeQuery();
            while(rs.next()){
                nuevaEmpresa = new empresa( rs.getInt("id_empresa"), 
                                            rs.getString("nit"), 
                                            rs.getString("razonSocial"),
                                            rs.getDate("fechaDeConstitucion"));
            }
        } catch (SQLException ex) {
            Util.printSQLException("empresaDAO.getEmpresaByName", ex);
        } catch (Exception e) {
            Util.printException("empresaDAO.getEmpresaByName", e);
        }
        return nuevaEmpresa;
    }    
    
    
    public int getIDEmpresaByName(String nameEmpresa) {
        empresa nuevaEmpresa=null;
        int IDEmpresa=0;
        try {
            nuevaEmpresa = getEmpresaByName( nameEmpresa );
            IDEmpresa=nuevaEmpresa.getId_empresa();
        } catch (Exception e) {
            IDEmpresa=0;
            Util.printException("personaDAO.getIDEmpresaByName", e);
        }
        return IDEmpresa;
    }
    
    public static String getCbxDefaultSelectionEmpresa(){
        return cnCbxDefaultSelectionEmpresa;
    }

    
    public static String getCbxEmpresa(){
        return cnCbxEmpresa;
    }

    public int getIDEmpresaByName4Cbx(String empresaNombre) {
        int IDEmpresa=0;
        boolean encontreEmpresaPorNombre = false;
        PreparedStatement ps = null;
        ResultSet rs=null;
        try {
            ps = cbd.getConexion().prepareStatement(cnCbxEmpresa);
            ps.setString(1, empresaNombre);
            rs = ps.executeQuery();
            empresaNombre = empresaNombre.toString().trim().toUpperCase();
            while(rs.next()){
                IDEmpresa++;
                if (rs.getString("razonSocial").toString().trim().toUpperCase().equals( empresaNombre ) ){
                    encontreEmpresaPorNombre = true;
                    break;
                }
            }
            if(!encontreEmpresaPorNombre)
                IDEmpresa=0;
        } catch (SQLException ex) {
            Util.printSQLException("empresaDAO.getIDEmpresaByName4Cbx", ex);
        } catch (Exception e) {
            Util.printException("empresaDAO.getIDEmpresaByName4Cbx", e);
        }
        return IDEmpresa;
    }    
    
    
}
