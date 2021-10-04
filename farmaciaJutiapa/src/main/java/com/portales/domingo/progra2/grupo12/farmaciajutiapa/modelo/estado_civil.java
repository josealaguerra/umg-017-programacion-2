/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.portales.domingo.progra2.grupo12.farmaciajutiapa.modelo;

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

    public estado_civil(int id_estado_civil, String abreviatura_estado_civil, String nombre_estado_civil) {
        this.id_estado_civil = id_estado_civil;
        this.abreviatura_estado_civil = abreviatura_estado_civil;
        this.nombre_estado_civil = nombre_estado_civil;
    }

}
