/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.portales.domingo.progra2.grupo12.farmaciajutiapa.modelo;

import java.util.Date;
import java.util.List;
import java.util.Vector;

/**
 *
 * @author josea
 */
public class persona {
    private int id_persona;
    private String primer_nombre;
    private String segundo_nombre;
    private String primer_apellido;
    private String segundo_apellido;
    private int id_genero;
    private Date fecha_de_nacimiento;
    private int id_estado_civil;    

    public int getId_persona() {
        return id_persona;
    }

    public void setId_persona(int id_persona) {
        this.id_persona = id_persona;
    }

    public String getPrimer_nombre() {
        return primer_nombre;
    }

    public void setPrimer_nombre(String primer_nombre) {
        this.primer_nombre = primer_nombre;
    }

    public String getSegundo_nombre() {
        return segundo_nombre;
    }

    public void setSegundo_nombre(String segundo_nombre) {
        this.segundo_nombre = segundo_nombre;
    }

    public String getPrimer_apellido() {
        return primer_apellido;
    }

    public void setPrimer_apellido(String primer_apellido) {
        this.primer_apellido = primer_apellido;
    }

    public String getSegundo_apellido() {
        return segundo_apellido;
    }

    public void setSegundo_apellido(String segundo_apellido) {
        this.segundo_apellido = segundo_apellido;
    }

    public int getId_genero() {
        return id_genero;
    }

    public void setId_genero(int id_genero) {
        this.id_genero = id_genero;
    }

    public Date getFecha_de_nacimiento() {
        return fecha_de_nacimiento;
    }

    public void setFecha_de_nacimiento(Date fecha_de_nacimiento) {
        this.fecha_de_nacimiento = fecha_de_nacimiento;
    }

    public int getId_estado_civil() {
        return id_estado_civil;
    }

    public void setId_estado_civil(int id_estado_civil) {
        this.id_estado_civil = id_estado_civil;
    }

    
    public persona(){
        limpia();
    }
    


    public void limpia(){
        this.id_persona = 0;
        this.primer_nombre = "";
        this.segundo_nombre = "";
        this.primer_apellido = "";
        this.segundo_apellido = "";
        this.id_genero = 0;
        this.fecha_de_nacimiento = null;
        this.id_estado_civil = 0;
    }

    
    
    public persona(int id_persona, String primer_nombre, String segundo_nombre, String primer_apellido, String segundo_apellido, int id_genero, Date fecha_de_nacimiento, int id_estado_civil) {
        this.id_persona = id_persona;
        this.primer_nombre = primer_nombre;
        this.segundo_nombre = segundo_nombre;
        this.primer_apellido = primer_apellido;
        this.segundo_apellido = segundo_apellido;
        this.id_genero = id_genero;
        this.fecha_de_nacimiento = fecha_de_nacimiento;
        this.id_estado_civil = id_estado_civil;
    }

    public Vector<estado_civil> getListEstadoCivil(){
        Vector<estado_civil> lec = null;
        estado_civil ec = new estado_civil();
        lec = ec.getListEstadoCivil();
        return lec;
    }

    public List<genero> getListGenero(){
        Vector<genero> lec = null;
        genero ec = new genero();
        lec = ec.getListGenero();
        return lec;    
    }
    
}
