/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guerra.uml.clases;

import java.util.Random;
import factura.detail;
import factura.header;

/**
 *
 * @author jose.guerra
 */
public class main {

    public static void main(String[] args) {
        
        Persona listadoDePersona[] = new Persona[5];
        
        listadoDePersona[0].setDPI("2512-2");
        listadoDePersona[0].setNOMBRE("ALFREDO");

        listadoDePersona[1].setDPI("3325-9");
        listadoDePersona[1].setNOMBRE("BORIS");
        
        listadoDePersona[2].setDPI("4439-1");
        listadoDePersona[2].setNOMBRE("CRISTIAN");        
        
        listadoDePersona[3].setDPI("5539-2");
        listadoDePersona[3].setNOMBRE("DANIEL");        
        
        listadoDePersona[4].setDPI("6639-3");
        listadoDePersona[4].setNOMBRE("EDSON");       
        
        Producto listadoDeProductos[] = new Producto[5];
        
        listadoDeProductos[0].setCodigo(100);
        listadoDeProductos[0].setNombre("SARTEN");

        listadoDeProductos[1].setCodigo(101);
        listadoDeProductos[1].setNombre("OLLA");
        
        listadoDeProductos[2].setCodigo(102);
        listadoDeProductos[2].setNombre("CUCHARA");        
        
        listadoDeProductos[3].setCodigo(103);
        listadoDeProductos[3].setNombre("TENEDOR");        
        
        listadoDeProductos[4].setCodigo(104);
        listadoDeProductos[4].setNombre("CUCHILLO");   
        
        int cantidad=0;
        double montoTotal=0.00;
        
        for (int numFactura = 0; numFactura < 5; numFactura++) {
            header h = new header(numFactura, listadoDePersona[numFactura].getDPI(), 0.00);
            h.mostrarEncabezado();
            for(int numProducto =0; numProducto<10; numProducto++){
                
                cantidad= (numProducto+1)*3;
                montoTotal=cantidad * listadoDeProductos[0].getPrecio_unitario();
            
                detail d = new detail(numFactura, cantidad, listadoDeProductos[numProducto].getCodigo(), 
                                        listadoDeProductos[numProducto].getNombre(),
                                        listadoDeProductos[numProducto].getPrecio_unitario(), 
                                        montoTotal);
                h.setMontoTotal(h.getMontoTotal() + montoTotal);
                d.mostrar();                
            }
            h.mostrarPieDePagina();
        }
    }
}
