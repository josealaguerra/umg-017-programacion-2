/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guerra.mantenimientocolaborador;

import java.text.SimpleDateFormat;  
import java.util.Date;


/**
 *
 * @author josea
 */
public class Persona {
    private String primerNombre="";
    private String segundoNombre="";
    private String tercerNombre="";
    private String primerApellido="";
    private String segundoApellido="";
    private String apellidoDeCasada="";
    private Date fechaNacimiento;
    private String genero="";
    private String estadoCivil="";

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }
    
    /***
     * Constructor default
     */
    public Persona(){
        limpiaPersona();
    }

    
    /***
     * Constructor con parametros obligatorios
     * @param paramPrimerNombre
     * @param paramSegundoNombre
     * @param paramFechaNacimiento 
     */
    public Persona(String paramPrimerNombre, String paramPrimerApellido, Date paramFechaNacimiento){
        limpiaPersona();
        setPrimerNombre( paramPrimerNombre );
        setPrimerApellido( paramPrimerApellido );
        setFechaNacimiento( paramFechaNacimiento );
    }
    
    /***
     * Constructor con parametros obligatorios
     * @param paramPrimerNombre
     * @param paramSegundoNombre
     * @param paramFechaNacimiento 
     */
    public Persona(String paramPrimerNombre, String paramPrimerApellido, String paramFechaNacimiento){
        limpiaPersona();
        setPrimerNombre( paramPrimerNombre );
        setPrimerApellido( paramPrimerApellido );
        setFechaNacimiento( paramFechaNacimiento );
    }    
    
    
    public void limpiaPersona(){
        setPrimerNombre("");
        setSegundoNombre("");
        setTercerNombre("");
        setPrimerApellido("");
        setSegundoApellido("");
        setApellidoDeCasada("");
        setFechaNacimiento( new Date());
    }
            
    
    public String getPrimerNombre() {
        return primerNombre;
    }

    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public String getSegundoNombre() {
        return segundoNombre;
    }

    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }

    public String getTercerNombre() {
        return tercerNombre;
    }

    public void setTercerNombre(String tercerNombre) {
        this.tercerNombre = tercerNombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public String getApellidoDeCasada() {
        return apellidoDeCasada;
    }

    public void setApellidoDeCasada(String apellidoDeCasada) {
        this.apellidoDeCasada = apellidoDeCasada;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    /***
     * Fecha de nacimiento
     * @param stringFechaNacimiento 
     */
    public void setFechaNacimiento(String stringFechaNacimiento) {
        Date fNac =null;
        SimpleDateFormat formatter = null;
        try{
            formatter = new SimpleDateFormat("dd/MM/yyyy");
            fNac = formatter.parse( stringFechaNacimiento );
        }catch(Exception e){
            System.out.println(e.toString());
                fNac =new Date();
        }finally{
            this.fechaNacimiento = fNac;
        }
    }
    
    /***
     * Formatea fecha a dia/mes/año
     * @param fecha
     * @return 
     */
    private String formateaFechaDDMMYYYY(Date fecha){
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
        return formatter.format(fecha);
    }

    /***
     * Información de persona
     * @return 
     */
    String getPersonaInfo() {
        return "Nombre: "+getPrimerNombre()+" "+
                getSegundoNombre()+" "+
                getTercerNombre()+" "+
                getPrimerApellido()+" "+
                getSegundoApellido()+" "+
                getApellidoDeCasada()+
                "\n Nacio: "+formateaFechaDDMMYYYY(getFechaNacimiento())+
                "\n Genero: "+getGenero()+
                "\n Estado civil: "+getEstadoCivil();

    }
    
}
