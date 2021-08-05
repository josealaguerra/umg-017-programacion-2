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
public class detail {
    
    private int factura;
    private int cantidad;
    private int codigo;
    private String nombrecodigo;
    private double monto_unitario;
    private double monto_total;    

    public detail(){
        setFactura(0);
        setCantidad(0);
        setCodigo(0);
        setNombrecodigo("");
        setMonto_unitario(0.00);
        setMonto_total(0.00);
    }
    
    /***
     * Detalle de la factura
     * @param factura
     * @param cantidad
     * @param codigo
     * @param nombrecodigo
     * @param monto_unitario
     * @param monto_total 
     */
    public detail(int factura, int cantidad, int codigo, 
                    String nombrecodigo, 
                    double monto_unitario, 
                    double monto_total){
        setFactura(factura);
        setCantidad(cantidad);
        setCodigo(codigo);
        setNombrecodigo(nombrecodigo);
        setMonto_unitario(monto_unitario);
        setMonto_total(monto_total);
    }    

    public int getFactura() {
        return factura;
    }

    public void setFactura(int factura) {
        this.factura = factura;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombrecodigo() {
        return nombrecodigo;
    }

    public void setNombrecodigo(String nombrecodigo) {
        this.nombrecodigo = nombrecodigo;
    }

    public double getMonto_unitario() {
        return monto_unitario;
    }

    public void setMonto_unitario(double monto_unitario) {
        this.monto_unitario = monto_unitario;
    }

    public double getMonto_total() {
        return monto_total;
    }

    public void setMonto_total(double monto_total) {
        this.monto_total = monto_total;
    }

    
    public void mostrar(){
        System.out.println("Factura: "+factura +
                            ", cantidad: "+cantidad +
                            ", codigo: "+codigo +
                            ", nombre codigo: "+nombrecodigo +
                            ", monto unitario: "+monto_unitario +
                            ", monto total: "+monto_total);            
    }

}
