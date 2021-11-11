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
    private static final String cnSQLActualizaPorID=" update "+cnSQLTabla+" set primer_nombre= ?, segundo_nombre= ?, primer_apellido= ?, segundo_apellido= ?, id_genero= ?, fecha_de_nacimiento= ?, id_estado_civil= ? WHERE id_persona = ? ";
    boolean actualizaSinFecha=false;
    private static final String cnSQLActualizaPorIDSinFecha=" update "+cnSQLTabla+" set primer_nombre= ?, segundo_nombre= ?, primer_apellido= ?, segundo_apellido= ?, id_genero= ?, id_estado_civil= ? WHERE id_persona = ? ";    
    private static final String cnSQLSeleccionaPorNombre=" SELECT id_persona, primer_nombre, segundo_nombre, primer_apellido, segundo_apellido, id_genero, fecha_de_nacimiento, id_estado_civil FROM "+cnSQLTabla+" WHERE concat(primer_nombre, \" \", segundo_nombre, \" \", primer_apellido, \" \", segundo_apellido) = ? ";    
    private static final String cnCbxDefaultSelectionPersona=" -- Selecciona persona --";
    private static final String cnCbxPersona=" select concat(primer_nombre, \" \", segundo_nombre, \" \", primer_apellido, \" \", segundo_apellido) as nombre_persona "
                                            + "from persona "
                                            + "order by primer_nombre, segundo_nombre, primer_apellido, segundo_apellido ";

    /***
     * Constructor personaDAO
     * @throws Exception 
     */    
    public personaDAO() throws Exception {
        cbd = new ConectaBD();
    }

    /***
     * Inserta un registro en la tabla persona
     * @param acc - objeto de la clase "acceso"
     * @return verdadero, si inserto correctamente en la tabla acceso
     */    
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
        
    /***
     * Selecciona todos los registros de la tabla persona
     * @return listado de personas
     */
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
                                                    rs.getDate("fecha_de_nacimiento"), 
                                                    rs.getInt("id_estado_civil") ) );
            }
            
        } catch (SQLException ex) {
            Util.printSQLException("personaDAO.seleccionaTodo", ex);
        } catch (Exception e) {
            Util.printException("personaDAO.seleccionaTodo", e);
        }
        return listaPersonas;
    }
    
    /***
     * Selecciona una persona, según su ID
     * @param IDAcceso
     * @return un objeto de persona
     */    
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
    
    /***
     * Elimina una persona según el ID enviado.
     * @param IDAcceso
     * @return verdadero si lo logro eliminar
     */
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

    /***
     * Modifica la informacion de la persona enviado por parametro.
     * @param acc
     * @return verdadero si modifico correctamente
     */
    public boolean actualiza(persona p){
        boolean filaActualizada=false;
        PreparedStatement ps = null;
        String SQLActualizaPersona="";
        try {
            if(actualizaSinFecha){
                SQLActualizaPersona = cnSQLActualizaPorIDSinFecha;
            }else{
                SQLActualizaPersona = cnSQLActualizaPorID;
            }
            ps = cbd.getConexion().prepareStatement( SQLActualizaPersona );
            ps.setString(1, p.getPrimer_nombre());
            ps.setString(2, p.getSegundo_nombre());
            ps.setString(3, p.getPrimer_apellido());
            ps.setString(4, p.getSegundo_apellido());
            ps.setInt(5, p.getId_genero());
            if(actualizaSinFecha){
                ps.setInt(6, p.getId_estado_civil());
                ps.setInt(7, p.getId_persona());
            }else{
                ps.setDate(6, Util.utilDate2sqlDate( p.getFecha_de_nacimiento() ));
                ps.setInt(7, p.getId_estado_civil());
                ps.setInt(8, p.getId_persona());
            }

            filaActualizada = ( ps.executeUpdate() > 0);
            
        }catch (SQLException ex) {
            Util.printSQLException("personaDAO.actualiza", ex);
        }catch (Exception e) {
            Util.printException("personaDAO.actualiza", e);
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
            Util.printException("personaDAO.cierra", e);
        }        
    }

    public persona getPersonaByName(String namePersona) {
        persona nuevap=null;
        PreparedStatement ps = null;
        ResultSet rs=null;
        try {
            ps = cbd.getConexion().prepareStatement(cnSQLSeleccionaPorNombre);
            ps.setString(1, namePersona);
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
            Util.printSQLException("personaDAO.getPersonaByName", ex);
        } catch (Exception e) {
            Util.printException("personaDAO.getPersonaByName", e);
        }
        return nuevap;
    }
    
    
    
    public int getIDPersonaByName(String namePersona) {
        persona nuevap=null;
        int IDPersona=0;
        try {
            nuevap = getPersonaByName( namePersona );
            IDPersona=nuevap.getId_persona();
        } catch (Exception e) {
            IDPersona=0;
            Util.printException("personaDAO.getIDPersonaByName", e);
        }
        return IDPersona;
    }

    
    public static String getCbxDefaultSelectionPersona() {
        return cnCbxDefaultSelectionPersona;
    }
    
    public static String getCbxPersona(){
        return cnCbxPersona;
    }

    public int getIDEmpresaByName4Cbx(String personaNombre) {
        int IDPersona=0;
        String nombreCompleto="";
        boolean encontreEmpresaPorNombre = false;
        PreparedStatement ps = null;
        ResultSet rs=null;

        try {
            ps = cbd.getConexion().prepareStatement(cnCbxPersona);
            rs=ps.executeQuery();
            while(rs.next()){
                IDPersona++;
                nombreCompleto = rs.getString("primer_nombre").toString() + " " + rs.getString("segundo_nombre").toString() + " " + rs.getString("primer_apellido").toString() + " " + rs.getString("segundo_apellido").toString();

                if( nombreCompleto.toString().trim().toUpperCase().equals(personaNombre.toString().trim().toUpperCase() ) ){
                    encontreEmpresaPorNombre = true;
                    break;
                }
            }
            if(!encontreEmpresaPorNombre)
                IDPersona=0;
            
        } catch (SQLException ex) {
            IDPersona=0;
            Util.printSQLException("personaDAO.seleccionaTodo", ex);
        } catch (Exception e) {
            IDPersona=0;
            Util.printException("personaDAO.seleccionaTodo", e);
        }
        return IDPersona;        
    }


    
}
    