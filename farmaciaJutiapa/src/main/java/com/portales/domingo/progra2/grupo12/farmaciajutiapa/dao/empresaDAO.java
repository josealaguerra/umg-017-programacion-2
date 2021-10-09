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
    private static final String cnSQLActualizaPorID=" update "+cnSQLTabla+" set id_empresa = ?, nit = ?,razonSocial = ?, fechaDeConstitucion = ? WHERE id_empresa = ? ";

    
    public empresaDAO() throws Exception {
        cbd = new ConectaBD();
    }

    
    public void inserta(empresa em){
    
        PreparedStatement ps = null;
        try {
            ps = cbd.getConexion().prepareStatement(cnSQLInserta);
            ps.setString(1, em.getNit());
            ps.setString(2, em.getRazonSocial());
            ps.setDate(3, Util.utilDate2sqlDate(em.getFechaDeConstitucion()));
            ps.setInt(1, em.getId_empresa());
            

            //rs=ps.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(personaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
        
    
    public List<empresa> seleccionaTodo(){
        List<empresa> listaEmpresa=null;
        PreparedStatement ps = null;
        ResultSet rs=null;
        
        try {
            listaEmpresa=new ArrayList<>();
            ps = cbd.getConexion().prepareStatement(cnSQLSeleccionaTodo);
            rs=ps.executeQuery();
            while(rs.next()){
                listaEmpresa.add( new empresa(   rs.getInt("id_empresa"), 
                                                    rs.getString("nit"), 
                                                    rs.getString("razonSocial"),
                                                    rs.getDate("fechaDeConstitucion")));
                                                   
            }
            
        } catch (Exception ex) {
            Logger.getLogger(personaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaEmpresa;
       
    }
    
    
    public empresa seleccionaPorID(int IDEmpresa){
        
        empresa nuevoProd=null;
        PreparedStatement ps = null;
        ResultSet rs=null;
        
        try {
            ps = cbd.getConexion().prepareStatement(cnSQLSeleccionaPorID);
            ps.setInt(1, IDEmpresa);
            rs=ps.executeQuery();
            while(rs.next()){
                nuevoProd = new empresa(   rs.getInt("id_empresa"), 
                                                    rs.getString("nit"), 
                                                    rs.getString("razonSocial"),
                                                    rs.getDate("fechaDeConstitucion"));
            }
            
        } catch (Exception ex) {
            Logger.getLogger(personaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return nuevoProd;
       
    }
    
    
    public boolean elimina(int IDEmpresa){
        
        boolean filaEliminada=false;
        PreparedStatement ps = null;
        
        try {
            ps = cbd.getConexion().prepareStatement(cnSQLEliminaPorID);
            ps.setInt(1, IDEmpresa);
            filaEliminada=( ps.executeUpdate() > 0);
            
        } catch (Exception ex) {
            Logger.getLogger(personaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return filaEliminada;
       
    }

    
    public boolean actualiza(empresa em){
        boolean filaActualizada=false;
        PreparedStatement ps = null;
        try {
            ps = cbd.getConexion().prepareStatement(cnSQLActualizaPorID);
             ps.setString(1, em.getNit());
            ps.setString(2, em.getRazonSocial());
            ps.setDate(3, Util.utilDate2sqlDate(em.getFechaDeConstitucion()));
            ps.setInt(1, em.getId_empresa());        
       
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
