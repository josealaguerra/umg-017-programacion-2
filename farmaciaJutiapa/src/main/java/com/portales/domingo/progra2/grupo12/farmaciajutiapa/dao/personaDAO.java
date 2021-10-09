/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.portales.domingo.progra2.grupo12.farmaciajutiapa.dao;

import com.portales.domingo.progra2.grupo12.farmaciajutiapa.controlador.ConectaBD;
import com.portales.domingo.progra2.grupo12.farmaciajutiapa.controlador.Util;
import com.portales.domingo.progra2.grupo12.farmaciajutiapa.modelo.persona;
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
public class personaDAO {

    private ConectaBD cbd = null;
    private static final String cnSQLTabla="persona";   
    private static final String cnSQLInserta=" INSERT INTO "+cnSQLTabla+" (primer_nombre, segundo_nombre, primer_apellido, segundo_apellido, id_genero, fecha_de_nacimiento, id_estado_civil) values (?, ?, ?, ?, ?, ?, ?)";
    private static final String cnSQLSeleccionaPorID=" SELECT id_persona, primer_nombre, segundo_nombre, primer_apellido, segundo_apellido, id_genero, fecha_de_nacimiento, id_estado_civil FROM "+cnSQLTabla+" WHERE id_persona = ? ";
    private static final String cnSQLSeleccionaTodo=" SELECT id_persona, primer_nombre, segundo_nombre, primer_apellido, segundo_apellido, id_genero, fecha_de_nacimiento, id_estado_civil FROM "+cnSQLTabla;
    private static final String cnSQLEliminaPorID=" delete FROM "+cnSQLTabla+" WHERE id_persona = ? ";
    private static final String cnSQLActualizaPorID=" update "+cnSQLTabla+" set id_persona= ?, primer_nombre= ?, segundo_nombre= ?, primer_apellido= ?, segundo_apellido= ?, id_genero= ?, fecha_de_nacimiento= ?, id_estado_civil= ? WHERE id_persona = ? ";

    
    public personaDAO() {
        cbd = new ConectaBD();
    }

    
    public boolean inserta(persona p){
        boolean filaInsertada=false;
    
        PreparedStatement ps = null;
        try {
            ps = cbd.getConexion().prepareStatement(cnSQLInserta);
            ps.setString(1, p.getPrimer_nombre());
            ps.setString(2, p.getSegundo_nombre());
            ps.setString(3, p.getPrimer_apellido());
            ps.setString(4, p.getSegundo_apellido());
            ps.setInt(5, p.getId_genero() );
            ps.setDate(6, Util.utilDate2sqlDate( p.getFecha_de_nacimiento() )) ;
            ps.setInt(7, p.getId_estado_civil()  );
            filaInsertada= ( ps.executeUpdate() >0) ;
        } catch (SQLException ex) {
            Util.printSQLException("personaDAO.inserta", ex);
        } catch (Exception e) {
            Util.printException("personaDAO.inserta", e);
        }
        return filaInsertada;
        
    }
        
    
    public List<persona> seleccionaTodo(){
        List<persona> listaPersonas=null;
        persona nuevap=null;
        PreparedStatement ps = null;
        ResultSet rs=null;
        
        try {
            listaPersonas=new ArrayList<>();
            ps = cbd.getConexion().prepareStatement(cnSQLSeleccionaTodo);
            rs=ps.executeQuery();
            while(rs.next()){
                listaPersonas.add( new persona(     rs.getInt("id_persona"), 
                                                    rs.getString("primer_nombre"), 
                                                    rs.getString("segundo_nombre"), 
                                                    rs.getString("primer_apellido"), 
                                                    rs.getString("segundo_apellido"), 
                                                    rs.getInt("id_genero"), 
                                                    rs.getDate("Date fecha_de_nacimiento"), 
                                                    rs.getInt("id_estado_civil") ) );
            }
            
        } catch (SQLException ex) {
            Util.printSQLException("personaDAO.seleccionaTodo", ex);
        } catch (Exception e) {
            Util.printException("personaDAO.seleccionaTodo", e);
        }
        return listaPersonas;
       
    }
    
    
    public persona seleccionaPorID(int IDPersona){
        
        persona nuevap=null;
        PreparedStatement ps = null;
        ResultSet rs=null;
        
        try {
            ps = cbd.getConexion().prepareStatement(cnSQLSeleccionaPorID);
            ps.setInt(1, IDPersona);
            rs=ps.executeQuery();
            while(rs.next()){
                nuevap = new persona(   rs.getInt("id_persona"), 
                                        rs.getString("primer_nombre"), 
                                        rs.getString("segundo_nombre"), 
                                        rs.getString("primer_apellido"), 
                                        rs.getString("segundo_apellido"), 
                                        rs.getInt("id_genero"), 
                                        rs.getDate("Date fecha_de_nacimiento"), 
                                        rs.getInt("id_estado_civil") );
            }
            
        } catch (SQLException ex) {
            Util.printSQLException("personaDAO.seleccionaPorID", ex);
        } catch (Exception e) {
            Util.printException("personaDAO.seleccionaPorID", e);
        }
        return nuevap;
       
    }
    
    
    public boolean elimina(int IDPersona){
        
        boolean filaEliminada=false;
        PreparedStatement ps = null;
        
        try {
            ps = cbd.getConexion().prepareStatement(cnSQLEliminaPorID);
            ps.setInt(1, IDPersona);
            filaEliminada=( ps.executeUpdate() > 0);
            
        }catch (SQLException ex) {
            Util.printSQLException("personaDAO.elimina", ex);
        }catch (Exception e) {
            Util.printException("personaDAO.elimina", e);
        }
        return filaEliminada;
       
    }

    
    public boolean actualiza(persona p){
        boolean filaActualizada=false;
        PreparedStatement ps = null;
        try {
            ps = cbd.getConexion().prepareStatement(cnSQLActualizaPorID);
            ps.setString(1, p.getPrimer_nombre());
            ps.setString(2, p.getSegundo_nombre());
            ps.setString(3, p.getPrimer_apellido());
            ps.setString(4, p.getSegundo_apellido());
            ps.setInt(5, p.getId_genero());
            //ps.setDate(6, p.getFecha_de_nacimientoPS());
            ps.setInt(7, p.getId_estado_civil());
            ps.setInt(8, p.getId_persona());
            filaActualizada = ( ps.executeUpdate() > 0);
            
        }catch (SQLException ex) {
            Util.printSQLException("personaDAO.actualiza", ex);
        }catch (Exception e) {
            Util.printException("personaDAO.actualiza", e);
        }
        
        return filaActualizada;
       
    }

   
    
}
    