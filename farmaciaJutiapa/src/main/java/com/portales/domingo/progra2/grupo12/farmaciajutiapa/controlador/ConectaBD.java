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
            Class.forName("com.mysql.jdbc.Driver");  
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/sonoo","root","root");  
        }catch(Exception e){ 
            System.out.println(e);
        }  
    }  

    
    public ResultSet getData(String sqlStatement){

        ResultSet obteinData=null;
        try{  
            stmt = conexion.createStatement();  
            rs = stmt.executeQuery( sqlStatement );  
            while(rs.next())  
            System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));  

        }catch(SQLException e){ 
            System.out.println(e);
        }  

        return obteinData;

    }


    public void closeDB(){
        try {      
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConectaBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    
}


