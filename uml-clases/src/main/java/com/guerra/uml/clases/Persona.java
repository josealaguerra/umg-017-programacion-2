/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guerra.uml.clases;

/**
 *
 * @author josea
 */
public class Persona {
    private String DPI;
    private String NOMBRE;

    
    public Persona(){
        setDPI("");
        setNOMBRE("");
    }


    public Persona(String DPI, String NOMBRE){
        setDPI(DPI);
        setNOMBRE(NOMBRE);
    }


    public String getDPI() {
        return DPI;
    }

    public void setDPI(String DPI) {
        this.DPI = DPI;
    }

    public String getNOMBRE() {
        return NOMBRE;
    }

    public void setNOMBRE(String NOMBRE) {
        this.NOMBRE = NOMBRE;
    }
}
