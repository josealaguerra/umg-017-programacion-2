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
public class tipo_producto {
    private int id_tipo_producto;
    private String nombre_tipo_producto;

    public int getId_tipo_producto() {
        return id_tipo_producto;
    }

    public void setId_tipo_producto(int id_tipo_producto) {
        this.id_tipo_producto = id_tipo_producto;
    }

    public String getNombre_tipo_producto() {
        return nombre_tipo_producto;
    }

    public void setNombre_tipo_producto(String nombre_tipo_producto) {
        this.nombre_tipo_producto = nombre_tipo_producto;
    }

    public tipo_producto(int id_tipo_producto, String nombre_tipo_producto) {
        this.id_tipo_producto = id_tipo_producto;
        this.nombre_tipo_producto = nombre_tipo_producto;
    }
}
