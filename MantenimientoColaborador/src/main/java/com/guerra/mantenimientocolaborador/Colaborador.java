/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guerra.mantenimientocolaborador;

/**
 *
 * @author josea
 */
public class Colaborador extends Persona{
    private int numeroColaborador;
    private String nombreEmpresa;
    private double salario;
    private double bono;
    private double tasaIGSS=4.83;    
    
    
    Colaborador(){
        
    }
    
    public void limpiaColaborador(){
        setNumeroColaborador(0);
        setNombreEmpresa("");
        setSalario(0.00);
        setBono(0.00);
        setTasaIGSS(0.00);
    }
    

    public int getNumeroColaborador() {
        return numeroColaborador;
    }

    public void setNumeroColaborador(int numeroColaborador) {
        this.numeroColaborador = numeroColaborador;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public double getBono() {
        return bono;
    }

    public void setBono(double bono) {
        this.bono = bono;
    }

    public double getTasaIGSS() {
        return tasaIGSS;
    }

    public void setTasaIGSS(double tasaIGSS) {
        this.tasaIGSS = tasaIGSS;
    }

    String getColaboradorInfo() {
        return getPersonaInfo()+" "+
                "\n Numero colaborador: "+getNumeroColaborador()+
                "\n Nombre empresa: "+getNombreEmpresa()+                
                "\n Salario: "+getSalario()+
                "\n Bono: "+getBono();
    }


}
