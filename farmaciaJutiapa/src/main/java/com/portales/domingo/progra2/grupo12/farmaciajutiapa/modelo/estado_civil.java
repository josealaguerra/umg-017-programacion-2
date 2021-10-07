/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.portales.domingo.progra2.grupo12.farmaciajutiapa.modelo;

import com.portales.domingo.progra2.grupo12.farmaciajutiapa.controlador.ConectaBD;
import java.sql.ResultSet;
import java.util.Vector;

/**
 *
 * @author josea
 */
public class estado_civil {
    private int id_estado_civil;
    private String abreviatura_estado_civil;
    private String nombre_estado_civil;    

    public int getId_estado_civil() {
        return id_estado_civil;
    }

    public void setId_estado_civil(int id_estado_civil) {
        this.id_estado_civil = id_estado_civil;
    }

    public String getAbreviatura_estado_civil() {
        return abreviatura_estado_civil;
    }

    public void setAbreviatura_estado_civil(String abreviatura_estado_civil) {
        this.abreviatura_estado_civil = abreviatura_estado_civil;
    }

    public String getNombre_estado_civil() {
        return nombre_estado_civil;
    }

    public void setNombre_estado_civil(String nombre_estado_civil) {
        this.nombre_estado_civil = nombre_estado_civil;
    }

    public estado_civil() {
        this.id_estado_civil = 0;
        this.abreviatura_estado_civil = "";
        this.nombre_estado_civil = "";
    }        
    
    public estado_civil(int id_estado_civil, String nombre_estado_civil) {
        this.id_estado_civil = id_estado_civil;
        this.abreviatura_estado_civil = "";
        this.nombre_estado_civil = nombre_estado_civil;
    }        

    public estado_civil(int id_estado_civil, String abreviatura_estado_civil, String nombre_estado_civil) {
        this.id_estado_civil = id_estado_civil;
        this.abreviatura_estado_civil = abreviatura_estado_civil;
        this.nombre_estado_civil = nombre_estado_civil;
    }    
    
    public Vector<estado_civil> getListEstadoCivil(){
        Vector<estado_civil> lec =null;
        ResultSet rset=null;
        ConectaBD cbd = null;
        try{
            cbd = new ConectaBD();
            
            lec = new Vector<estado_civil>();
            rset = cbd.getData(" select id_estado_civil, nombre_estado_civil from estado_civil ");

            rset.beforeFirst();
            if(rset.next()){
                do{
                    estado_civil ec = new estado_civil(rset.getInt(1), rset.getString(2));
                    lec.addElement(ec);
                }while(rset.next());
                return lec;
            }else
                return null;
            
        }catch(Exception e){
            System.out.println(e.getMessage());
        }

        return lec;
    }

}
