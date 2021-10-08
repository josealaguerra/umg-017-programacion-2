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
public class compra_detalle {
    private int id_compra_detalle;
    private int id_compra;
    private int id_marca_producto;
    private int id_tipo_producto;
    private int id_producto;
    private double precio_unitario_compra ;
    private int cantidad ;

    public int getId_compra_detalle() {
        return id_compra_detalle;
    }

    public void setId_compra_detalle(int id_compra_detalle) {
        this.id_compra_detalle = id_compra_detalle;
    }

    public int getId_compra() {
        return id_compra;
    }

    public void setId_compra(int id_compra) {
        this.id_compra = id_compra;
    }

    public int getId_marca_producto() {
        return id_marca_producto;
    }

    public void setId_marca_producto(int id_marca_producto) {
        this.id_marca_producto = id_marca_producto;
    }

    public int getId_tipo_producto() {
        return id_tipo_producto;
    }

    public void setId_tipo_producto(int id_tipo_producto) {
        this.id_tipo_producto = id_tipo_producto;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public double getPrecio_unitario_compra() {
        return precio_unitario_compra;
    }

    public void setPrecio_unitario_compra(double precio_unitario_compra) {
        this.precio_unitario_compra = precio_unitario_compra;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public compra_detalle(int id_compra_detalle, int id_compra, int id_marca_producto, int id_tipo_producto, int id_producto, double precio_unitario_compra, int cantidad) {
        this.id_compra_detalle = id_compra_detalle;
        this.id_compra = id_compra;
        this.id_marca_producto = id_marca_producto;
        this.id_tipo_producto = id_tipo_producto;
        this.id_producto = id_producto;
        this.precio_unitario_compra = precio_unitario_compra;
        this.cantidad = cantidad;
    }
}
