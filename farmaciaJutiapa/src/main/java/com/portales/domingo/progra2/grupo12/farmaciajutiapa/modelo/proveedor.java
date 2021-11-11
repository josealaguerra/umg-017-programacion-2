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
public class proveedor {
    private int id_proveedor;
    private int id_empresa;
    private int id_persona;
    private String nombreEmpresa;
    private String nombrePersona;

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public String getNombrePersona() {
        return nombrePersona;
    }

    public void setNombrePersona(String nombrePersona) {
        this.nombrePersona = nombrePersona;
    }

    public int getId_proveedor() {
        return id_proveedor;
    }

    public void setId_proveedor(int id_proveedor) {
        this.id_proveedor = id_proveedor;
    }

    public int getId_empresa() {
        return id_empresa;
    }

    public void setId_empresa(int id_empresa) {
        this.id_empresa = id_empresa;
    }

    public int getId_persona() {
        return id_persona;
    }

    public void setId_persona(int id_persona) {
        this.id_persona = id_persona;
    }

    public proveedor(int id_proveedor, int id_empresa, String nombreEmpresa, int id_persona, String nombrePersona) {
        this.id_proveedor = id_proveedor;
        this.id_empresa = id_empresa;
        this.id_persona = id_persona;
        this.nombreEmpresa=nombreEmpresa;
        this.nombrePersona=nombrePersona;
    }
    
    
}
