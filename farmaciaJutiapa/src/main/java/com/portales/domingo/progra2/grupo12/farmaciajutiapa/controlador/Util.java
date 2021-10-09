/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.portales.domingo.progra2.grupo12.farmaciajutiapa.controlador;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author josea
 */
public class Util {
    
     
     
     
    public static Date str2date(String sDate){
        Date nuevaFecha=null;
        
        try{
            nuevaFecha = new SimpleDateFormat().parse(sDate);
        }catch(Exception e){
            Util.printException("Util.str2date", e);
            nuevaFecha=new Date();
        }
        return nuevaFecha;
    }
    
    
    public static int str2int(String str){
        int nuevoInt = 0;
        
        try{
            nuevoInt = Integer.parseInt(str);
        }catch(Exception e){
            Util.printException("Util.str2int", e);
            nuevoInt = 0;
        }
        return nuevoInt;
        
    }
    
    
    public static java.sql.Date utilDate2sqlDate(java.util.Date utilDate) {

        java.sql.Date sqlDate=null;
        
        try{
            sqlDate = new java.sql.Date(utilDate.getTime());            
        }catch(Exception e){
            Util.printException("Util.str2int", e);
            sqlDate = new java.sql.Date(0);
        }
        
        return sqlDate;
    }
    
 
    public static void printSQLException(String msj, SQLException ex){
        System.out.println(msj+" | Mensaje: "+ex.getMessage()+", stack trace: "+ex.getStackTrace());
        Logger.getLogger(ConectaBD.class.getName()).log(Level.SEVERE, null, ex);        
        for(Throwable e:ex){
            if(e instanceof SQLException){
                e.printStackTrace(System.err);
                System.err.println("SQL State");
                
            }
                
        }
    }
    
    
    public static void printSQLException(SQLException ex){
        printSQLException("", ex);
    }
    
        

    public static void printException(String msj, Exception ex){
        System.out.println(msj+" | Mensaje: "+ex.getMessage()+", stack trace: "+ex.getStackTrace());
        Logger.getLogger(ConectaBD.class.getName()).log(Level.SEVERE, null, ex);        
    }
    
    
    public static void printException(Exception ex){
        printException("", ex);
    }
    
            
            
}
