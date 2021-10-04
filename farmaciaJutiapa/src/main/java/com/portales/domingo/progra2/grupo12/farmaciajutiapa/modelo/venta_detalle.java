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
public class venta_detalle {
    private int id_venta_detalle;
    private int id_venta;
    private int id_marca_producto;
    private int id_tipo_producto;
    private int id_producto;
    private double precio_unitario_venta ;
    private int cantidad ;

    public int getId_venta_detalle() {
        return id_venta_detalle;
    }

    public void setId_venta_detalle(int id_venta_detalle) {
        this.id_venta_detalle = id_venta_detalle;
    }

    public int getId_venta() {
        return id_venta;
    }

    public void setId_venta(int id_venta) {
        this.id_venta = id_venta;
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

    public double getPrecio_unitario_venta() {
        return precio_unitario_venta;
    }

    public void setPrecio_unitario_venta(double precio_unitario_venta) {
        this.precio_unitario_venta = precio_unitario_venta;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public venta_detalle(int id_venta_detalle, int id_venta, int id_marca_producto, int id_tipo_producto, int id_producto, double precio_unitario_venta, int cantidad) {
        this.id_venta_detalle = id_venta_detalle;
        this.id_venta = id_venta;
        this.id_marca_producto = id_marca_producto;
        this.id_tipo_producto = id_tipo_producto;
        this.id_producto = id_producto;
        this.precio_unitario_venta = precio_unitario_venta;
        this.cantidad = cantidad;
    }
}
