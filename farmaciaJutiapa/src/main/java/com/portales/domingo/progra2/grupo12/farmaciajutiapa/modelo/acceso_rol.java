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
public class acceso_rol {
    private int id_acceso_rol;
    private int id_acceso;
    private int id_rol;
    private String nombre_acceso;
    private String nombre_rol;

    public String getNombre_acceso() {
        return nombre_acceso;
    }

    public void setNombre_acceso(String nombre_acceso) {
        this.nombre_acceso = nombre_acceso;
    }

    public String getNombre_rol() {
        return nombre_rol;
    }

    public void setNombre_rol(String nombre_rol) {
        this.nombre_rol = nombre_rol;
    }

    public int getId_acceso_rol() {
        return id_acceso_rol;
    }

    public void setId_acceso_rol(int id_acceso_rol) {
        this.id_acceso_rol = id_acceso_rol;
    }

    public int getId_acceso() {
        return id_acceso;
    }

    public void setId_acceso(int id_acceso) {
        this.id_acceso = id_acceso;
    }

    public int getId_rol() {
        return id_rol;
    }

    public void setId_rol(int id_rol) {
        this.id_rol = id_rol;
    }

    public acceso_rol(int id_acceso_rol, int id_acceso, int id_rol) {
        this.id_acceso_rol = id_acceso_rol;
        this.id_acceso = id_acceso;
        this.id_rol = id_rol;
        this.nombre_acceso="";
        this.nombre_rol="";
    }
    
    public acceso_rol(int id_acceso_rol, int id_acceso, int id_rol, String nombre_acceso, String nombre_rol) {
        this.id_acceso_rol = id_acceso_rol;
        this.id_acceso = id_acceso;
        this.id_rol = id_rol;
        this.nombre_acceso = nombre_acceso;
        this.nombre_rol = nombre_rol;
    }    
}
