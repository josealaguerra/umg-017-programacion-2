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
public class marca_producto {
    private int id_marca_producto;
    private String nombre_marca_producto;    
   
    

    public int getId_marca_producto() {
        return id_marca_producto;
    }

    public void setId_marca_producto(int id_marca_producto) {
        this.id_marca_producto = id_marca_producto;
    }

    public String getNombre_marca_producto() {
        return nombre_marca_producto;
    }

    public void setNombre_marca_producto(String nombre_marca_producto) {
        this.nombre_marca_producto = nombre_marca_producto;
    }


 public marca_producto(int id_marca_producto, String nombre_marca_producto) {
        this.id_marca_producto = id_marca_producto;
        this.nombre_marca_producto = nombre_marca_producto;
}
}
