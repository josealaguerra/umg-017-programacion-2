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
public class alias {
    private int id_alias;
    private String alias;
    private String pass;    

    public alias() {
        this.id_alias = 0;
        this.alias = "";
        this.pass = "";
    }        
    
    
    public alias(String alias, String pass) {
        this.id_alias = 0;        
        this.alias = alias;
        this.pass = pass;
    }     
    

    public alias(int id_alias, String alias, String pass) {
        this.id_alias = id_alias;
        this.alias = alias;
        this.pass = pass;
    }    

    public int getId_alias() {
        return id_alias;
    }

    public void setId_alias(int id_alias) {
        this.id_alias = id_alias;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

}
