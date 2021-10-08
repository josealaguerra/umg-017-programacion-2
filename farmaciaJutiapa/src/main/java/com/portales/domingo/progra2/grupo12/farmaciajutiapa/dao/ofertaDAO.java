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
public class oferta {
    private int id_oferta;
    private int id_marca_producto;
    private int id_tipo_producto;
    private int id_producto;
    private double porcentaje_descuento;
    private Date fecha_inicio;
    private Date fecha_final;    

    public oferta(int id_oferta, int id_marca_producto, int id_tipo_producto, int id_producto, double porcentaje_descuento, Date fecha_inicio, Date fecha_final) {
        this.id_oferta = id_oferta;
        this.id_marca_producto = id_marca_producto;
        this.id_tipo_producto = id_tipo_producto;
        this.id_producto = id_producto;
        this.porcentaje_descuento = porcentaje_descuento;
        this.fecha_inicio = fecha_inicio;
        this.fecha_final = fecha_final;
    }

    public int getId_oferta() {
        return id_oferta;
    }

    public void setId_oferta(int id_oferta) {
        this.id_oferta = id_oferta;
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

    public double getPorcentaje_descuento() {
        return porcentaje_descuento;
    }

    public void setPorcentaje_descuento(double porcentaje_descuento) {
        this.porcentaje_descuento = porcentaje_descuento;
    }

    public Date getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(Date fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public Date getFecha_final() {
        return fecha_final;
    }

    public void setFecha_final(Date fecha_final) {
        this.fecha_final = fecha_final;
    }

}
