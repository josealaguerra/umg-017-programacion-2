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
public class venta {
    private int id_venta;
    private int id_cliente;
    private Date fecha_venta;
    private String numero_factura;
    private double monto_total;

    public int getId_venta() {
        return id_venta;
    }

    public void setId_venta(int id_venta) {
        this.id_venta = id_venta;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public Date getFecha_venta() {
        return fecha_venta;
    }

    public void setFecha_venta(Date fecha_venta) {
        this.fecha_venta = fecha_venta;
    }

    public String getNumero_factura() {
        return numero_factura;
    }

    public void setNumero_factura(String numero_factura) {
        this.numero_factura = numero_factura;
    }

    public double getMonto_total() {
        return monto_total;
    }

    public void setMonto_total(double monto_total) {
        this.monto_total = monto_total;
    }

    public venta(int id_venta, int id_cliente, Date fecha_venta, String numero_factura, double monto_total) {
        this.id_venta = id_venta;
        this.id_cliente = id_cliente;
        this.fecha_venta = fecha_venta;
        this.numero_factura = numero_factura;
        this.monto_total = monto_total;
    }
    
    
}




