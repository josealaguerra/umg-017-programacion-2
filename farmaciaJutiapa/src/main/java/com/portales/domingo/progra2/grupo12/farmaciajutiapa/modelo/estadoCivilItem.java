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
public class estadoCivilItem {
    
    private int idEstadoCivilItem;
    private String nombreEstadoCivilItem;            

    public estadoCivilItem(int idEstadoCivilItem, String nombreEstadoCivilItem) {
        this.idEstadoCivilItem = idEstadoCivilItem;
        this.nombreEstadoCivilItem = nombreEstadoCivilItem;
    }

    public int getIdEstadoCivilItem() {
        return idEstadoCivilItem;
    }

    public void setIdEstadoCivilItem(int idEstadoCivilItem) {
        this.idEstadoCivilItem = idEstadoCivilItem;
    }

    public String getNombreEstadoCivilItem() {
        return nombreEstadoCivilItem;
    }

    public void setNombreEstadoCivilItem(String nombreEstadoCivilItem) {
        this.nombreEstadoCivilItem = nombreEstadoCivilItem;
    }

}
