/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.portales.domingo.progra2.grupo12.farmaciajutiapa.modelo;

import java.util.Date;

/**
 *
 * @author josea
 */
public class empresa {
    private int id_empresa;
    private String nit;
    private String razonSocial;
    private Date fechaDeConstitucion;

    public int getId_empresa() {
        return id_empresa;
    }

    public void setId_empresa(int id_empresa) {
        this.id_empresa = id_empresa;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public Date getFechaDeConstitucion() {
        return fechaDeConstitucion;
    }

    public void setFechaDeConstitucion(Date fechaDeConstitucion) {
        this.fechaDeConstitucion = fechaDeConstitucion;
    }

    public empresa(int id_empresa, String nit, String razonSocial, Date fechaDeConstitucion ) {
        this.id_empresa = id_empresa;
        this.nit = nit;
        this.razonSocial = razonSocial;
        this.fechaDeConstitucion= fechaDeConstitucion;
    }
    
    
    
}


