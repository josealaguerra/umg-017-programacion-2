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
public class compra {
    private int id_compra ;
    private int id_proveedor ;
    private Date fecha_compra ;
    private String numero_factura ;
    private double monto_total ;    

    public int getId_compra() {
        return id_compra;
    }

    public void setId_compra(int id_compra) {
        this.id_compra = id_compra;
    }

    public int getId_proveedor() {
        return id_proveedor;
    }

    public void setId_proveedor(int id_proveedor) {
        this.id_proveedor = id_proveedor;
    }

    public Date getFecha_compra() {
        return fecha_compra;
    }

    public void setFecha_compra(Date fecha_compra) {
        this.fecha_compra = fecha_compra;
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

    public compra(int id_compra, int id_proveedor, Date fecha_compra, String numero_factura, double monto_total) {
        this.id_compra = id_compra;
        this.id_proveedor = id_proveedor;
        this.fecha_compra = fecha_compra;
        this.numero_factura = numero_factura;
        this.monto_total = monto_total;
    }

}
