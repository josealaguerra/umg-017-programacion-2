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
public class acceso_rolDAO {
    private ConectaBD cbd = null;
    private static final String cnSQLTabla="acceso_rol";   
    private static final String cnSQLInserta=" INSERT INTO "+cnSQLTabla+" (id_acceso, id_rol) values (?, ?)";
    private static final String cnSQLSeleccionaPorID=" SELECT id_acceso_rol, id_acceso, id_rol FROM "+cnSQLTabla+" WHERE id_acceso_rol = ? ";
    private static final String cnSQLSeleccionaTodo=" SELECT id_acceso_rol, id_acceso, id_rol FROM "+cnSQLTabla+"  ";
    private static final String cnSQLEliminaPorID=" delete FROM "+cnSQLTabla+" WHERE id_acceso_rol = ? ";
    private static final String cnSQLActualizaPorID=" update "+cnSQLTabla+" set id_acceso = ?, id_rol = ? WHERE id_acceso_rol = ? ";
    private static final String cnSQLSeleccionaTodoRelacionado=   " SELECT ar.id_acceso_rol as id_acceso_rol, "
                                                                + "ar.id_acceso as id_acceso, a.nombre_acceso as nombre_acceso, "
                                                                + "ar.id_rol as id_rol, r.nombre_rol as nombre_rol  "
                                                                + "FROM acceso_rol ar "
                                                                + "join acceso a on ar.id_acceso=a.id_acceso "
                                                                + "join rol r on ar.id_acceso=r.id_rol "
                                                                + "order by a.nombre_acceso, r.nombre_rol ";

    /***
     * Constructor acceso_rolDAO
     * @throws Exception 
     */
    public acceso_rolDAO() throws Exception {
        cbd = new ConectaBD();
    }

    /***
     * Inserta un registro en la tabla acceso_rol
     * @param acc - objeto de la clase "acceso_rol"
     * @return verdadero, si inserto correctamente en la tabla acceso_rol
     */
    public boolean inserta(acceso_rol accRol){
        boolean filaInsertada=false;
        PreparedStatement ps = null;
        try {
            ps = cbd.getConexion().prepareStatement(cnSQLInserta);
            ps.setInt(1, accRol.getId_acceso());
            ps.setInt(2, accRol.getId_rol());
            filaInsertada= ( ps.executeUpdate() >0) ;          
        } catch (SQLException ex) {
            Util.printSQLException("acceso_rolDAO.inserta", ex);
        } catch (Exception e) {
            Util.printException("acceso_rolDAO.inserta", e);
        }
        return filaInsertada; 
    }
        
    /***
     * Selecciona todos los registros de la tabla acceso_rol
     * @return 
     */
    public List<acceso_rol> seleccionaTodo(){
        List<acceso_rol> listadoAccesoRol=null;
        PreparedStatement ps = null;
        ResultSet rs=null;
        
        try {
            listadoAccesoRol=new ArrayList<>();
            ps = cbd.getConexion().prepareStatement(cnSQLSeleccionaTodo);
            rs=ps.executeQuery();
            while(rs.next()){
                listadoAccesoRol.add( new acceso_rol(   rs.getInt("id_acceso_rol"), 
                                                        rs.getInt("id_acceso"), 
                                                        rs.getInt("id_rol")) );
            }
            
        } catch (SQLException ex) {
            Util.printSQLException("acceso_rolDAO.seleccionaTodo", ex);
        } catch (Exception e) {
            Util.printException("acceso_rolDAO.seleccionaTodo", e);
        }
        return listadoAccesoRol;
       
    }
    
    /***
     * Selecciona todos los registros de la tabla acceso_rol
     * @return 
     */
    public List<acceso_rol> seleccionaTodoRelacionado(){
        List<acceso_rol> listadoAccesoRol=null;
        PreparedStatement ps = null;
        ResultSet rs=null;
        
        try {
            listadoAccesoRol=new ArrayList<>();
            ps = cbd.getConexion().prepareStatement(cnSQLSeleccionaTodoRelacionado);
            rs=ps.executeQuery();
            while(rs.next()){
                listadoAccesoRol.add( new acceso_rol(   rs.getInt("id_acceso_rol"),
                                                        rs.getInt("id_acceso"), 
                                                        rs.getInt("id_rol"), 
                                                        rs.getString("nombre_acceso"), 
                                                        rs.getString("nombre_rol")) );
            }
            
        } catch (SQLException ex) {
            Util.printSQLException("acceso_rolDAO.seleccionaTodo", ex);
        } catch (Exception e) {
            Util.printException("acceso_rolDAO.seleccionaTodo", e);
        }
        return listadoAccesoRol;
    }    
    
    
    /***
     * Selecciona un acceso_rol, según su ID
     * @param IDAccesoRol
     * @return 
     */
    public acceso_rol seleccionaPorID(int IDAccesoRol){
        acceso_rol nuevoAccesoRol=null;
        PreparedStatement ps = null;
        ResultSet rs=null;
        
        try {
            ps = cbd.getConexion().prepareStatement(cnSQLSeleccionaPorID);
            ps.setInt(1, IDAccesoRol);
            rs=ps.executeQuery();
            while(rs.next()){
                nuevoAccesoRol = new acceso_rol(rs.getInt("id_acceso_rol"), 
                                                rs.getInt("id_acceso"), 
                                                rs.getInt("id_rol") );
            }
            
        } catch (SQLException ex) {
            Util.printSQLException("acceso_rolDAO.seleccionaPorID", ex);
        } catch (Exception e) {
            Util.printException("acceso_rolDAO.seleccionaPorID", e);
        }
        return nuevoAccesoRol;
    }
    
    /***
     * Elimina el acceso_rol con el ID enviado.
     * @param IDAccesoRol
     * @return 
     */
    public boolean elimina(int IDAccesoRol){
        boolean filaEliminada=false;
        PreparedStatement ps = null;
        
        try {
            ps = cbd.getConexion().prepareStatement(cnSQLEliminaPorID);
            ps.setInt(1, IDAccesoRol);
            filaEliminada=( ps.executeUpdate() > 0);
        } catch (SQLException ex) {
            Util.printSQLException("acceso_rolDAO.elimina", ex);
        } catch (Exception e) {
            Util.printException("acceso_rolDAO.elimina", e);
        }
        return filaEliminada;
    }

    /***
     * Modifica la informacion del acceso_rol enviado por parametro.
     * @param accRol
     * @return 
     */
    public boolean actualiza(acceso_rol accRol){
        boolean filaActualizada=false;
        PreparedStatement ps = null;
        try {
            ps = cbd.getConexion().prepareStatement(cnSQLActualizaPorID);
            ps.setInt(1, accRol.getId_acceso());
            ps.setInt(2, accRol.getId_rol());
            ps.setInt(3, accRol.getId_acceso_rol());
            filaActualizada = ( ps.executeUpdate() > 0);
        } catch (SQLException ex) {
            Util.printSQLException("acceso_rolDAO.actualiza", ex);
        } catch (Exception e) {
            Util.printException("acceso_rolDAO.actualiza", e);
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
            Util.printException("acceso_rolDAO.cierra", e);
        }        
    }

     /***
     * Busca el ID Acceso por el nombre
     * @param nombreAcceso
     * @return 
     */
    public int getAccesoSelectedByName(String nombreAcceso){
        int nuevoIDAcceso=0;
        PreparedStatement ps = null;
        ResultSet rs=null;
        boolean encontro=false;
        
        try {
            ps = cbd.getConexion().prepareStatement( getAccesoOrdenadoSQL() );
            rs=ps.executeQuery();
            while(rs.next()){
                nuevoIDAcceso++;
                if ( rs.getString("nombre_acceso").toString().trim().equals( nombreAcceso ) ){
                    encontro=true;
                    break;
                }
            }
        } catch (SQLException ex) {
            Util.printSQLException("acceso_rolDAO.getAccesoSelectedByName", ex);
        } catch (Exception e) {
            Util.printException("acceso_rolDAO.getAccesoSelectedByName", e);
        }finally{
            if(!encontro){
                nuevoIDAcceso=0;
            }
        }
        return nuevoIDAcceso;        
    }
    
    
 /***
     * Busca el ID Acceso por el nombre para un combobox (resta 1)
     * @param nombreAcceso
     * @return 
     */
    public int getAccesoSelectedByName4Cbx(String nombreAcceso){
        int nuevoIDAcceso=0;
        try {
            nuevoIDAcceso = getAccesoSelectedByName(nombreAcceso);
            if( nuevoIDAcceso > 0 ){
                nuevoIDAcceso--;
            }
        } catch (Exception e) {
            Util.printException("acceso_rolDAO.getAccesoSelectedByName4Cbx", e);
        }
        return nuevoIDAcceso;
    }    
    
    
     /***
     * Busca el ID Acceso por el nombre
     * @param nombreRol
     * @return 
     */
    public int getRolSelectedByName(String nombreRol){
        int nuevoIDRol=0;
        PreparedStatement ps = null;
        ResultSet rs=null;
        boolean encontro=false;
        
        try {
            ps = cbd.getConexion().prepareStatement( getRolOrdenadoSQL() );
            rs = ps.executeQuery();
            while(rs.next()){
                nuevoIDRol++;
                if ( rs.getString("nombre_rol").toString().trim().equals( nombreRol ) ){
                    encontro=true;
                    break;
                }
            }
        } catch (SQLException ex) {
            Util.printSQLException("acceso_rolDAO.getRolSelectedByName", ex);
        } catch (Exception e) {
            Util.printException("acceso_rolDAO.getRolSelectedByName", e);
        }finally{
            if(!encontro){
                nuevoIDRol=0;
            }
        }
        return nuevoIDRol; 
    }    
    
    

    
     /***
     * Busca el ID Acceso por el nombre
     * @param nombreRol
     * @return 
     */
    public int getRolSelectedByName4Cbx(String nombreRol){
        int nuevoIDRol = 0;
        try {
            nuevoIDRol = getRolSelectedByName( nombreRol );
            if(nuevoIDRol > 0){
                nuevoIDRol--;
            }
        } catch (Exception e) {
            Util.printException("acceso_rolDAO.getRolSelectedByName4Cbx", e);
        }
        return nuevoIDRol;
    }        

    public String getAccesoOrdenadoSQL() {
        return accesoDAO.getAccesoOrdenadoSQL();
    }

    public String getRolOrdenadoSQL() {
        return rolDAO.getRolOrdenadoSQL();
    }
    


    public int getIDAccesoByCbxSelected(String nombreRol){
        int nuevoIDAcceso = 0;
        accesoDAO aDAO = null;
        acceso aObj = null;
        
        try {
            aDAO = new accesoDAO();
            aObj = aDAO.seleccionaPorNombre( nombreRol );
            nuevoIDAcceso = aObj.getId_acceso();
        } catch (SQLException ex) {
            Util.printSQLException("acceso_rolDAO.getIDAccesoByCbxSelected", ex);
        } catch (Exception e) {
            Util.printException("acceso_rolDAO.getIDAccesoByCbxSelected", e);
        }
        return nuevoIDAcceso;
    }

    
    public int getIDRolByCbxSelected(String nombreRol) {
        int nuevoIDRol = 0;
        rolDAO aDAO = null;
        rol aObj = null;
        
        try {
            aDAO = new rolDAO();
            aObj = aDAO.seleccionaPorNombre( nombreRol );
            nuevoIDRol = aObj.getId_rol();
        } catch (SQLException ex) {
            Util.printSQLException("acceso_rolDAO.getIDRolByCbxSelected", ex);
        } catch (Exception e) {
            Util.printException("acceso_rolDAO.getIDRolByCbxSelected", e);
        }
        return nuevoIDRol;
    }

    
}
