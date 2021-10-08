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
public class acceso {
    private int id_acceso;
    private String nombre_acceso;
    private String pagina_acceso;

    public int getId_acceso() {
        return id_acceso;
    }

    public void setId_acceso(int id_acceso) {
        this.id_acceso = id_acceso;
    }

    public String getNombre_acceso() {
        return nombre_acceso;
    }

    public void setNombre_acceso(String nombre_acceso) {
        this.nombre_acceso = nombre_acceso;
    }

    public String getPagina_acceso() {
        return pagina_acceso;
    }

    public void setPagina_acceso(String pagina_acceso) {
        this.pagina_acceso = pagina_acceso;
    }

    public acceso(int id_acceso, String nombre_acceso, String pagina_acceso) {
        this.id_acceso = id_acceso;
        this.nombre_acceso = nombre_acceso;
        this.pagina_acceso = pagina_acceso;
    }
}
