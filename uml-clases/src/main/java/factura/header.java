/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factura;

/**
 *
 * @author jose.guerra
 */
public class header {
    
    private int factura;
    private String DPI;
    private double montoTotal;
    
    
    public header(){
        setFactura(0);
        setDPI("");
        setMontoTotal(0.00);
    }
    
    /***
     * Encabezado de la factura
     * @param factura
     * @param DPI
     * @param montoTotal 
     */
    public header(int factura, String DPI, double montoTotal){
        setFactura(factura);
        setDPI(DPI);
        setMontoTotal(montoTotal);
    }    

    public int getFactura() {
        return factura;
    }

    public void setFactura(int factura) {
        this.factura = factura;
    }

    public String getDPI() {
        return DPI;
    }

    public void setDPI(String DPI) {
        this.DPI = DPI;
    }

    public double getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(double montoTotal) {
        this.montoTotal = montoTotal;
    }

    
    public void mostrarEncabezado(){
        System.out.println("Factura: "+factura+
                            ", DPI: "+DPI);
    }
    
    
    
    public void mostrarPieDePagina(){
        System.out.println("Monto total: "+montoTotal);
    }    

}
