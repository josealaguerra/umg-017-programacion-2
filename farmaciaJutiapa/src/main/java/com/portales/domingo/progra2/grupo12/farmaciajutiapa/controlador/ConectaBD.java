/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.portales.domingo.progra2.grupo12.farmaciajutiapa.controlador;


import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author josea
 */
public class ConectaBD {
    private Connection conexion=null;
    private Statement stmt=null;
    private ResultSet rs=null;
    
    public ConectaBD(){
        try{  
            Class.forName("com.mysql.cj.jdbc.Driver");  
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/bd_farmacia_jutiapa","farmacia","jutiapa");  
        }catch(Exception e){ 
            System.out.println(e);
        }  
    }  

    
    public void getData(String sqlStatement){

        try{
            stmt = conexion.createStatement();
            rs = stmt.executeQuery( sqlStatement );

        }catch(SQLException e){ 
            System.out.println(e);
        }  

    }

    public Connection getConexion() {
        return conexion;
    }

    public void setConexion(Connection conexion) {
        this.conexion = conexion;
    }

    public Statement getStmt() {
        return stmt;
    }

    public void setStmt(Statement stmt) {
        this.stmt = stmt;
    }

    public ResultSet getRs() {
        return rs;
    }

    public void setRs(ResultSet rs) {
        this.rs = rs;
    }


    public void closeDB(){
        try {      
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConectaBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    
}


