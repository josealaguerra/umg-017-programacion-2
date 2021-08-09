/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guerra.j.notaalumno;

import java.util.Scanner;

/**
 *
 * @author josealaguerra
 */
public class NotaAlumno {

    private static int notaGanadora=61;
    
    
    
    /***
     * 
     * @param parameterNumberRequest
     * @return 
     */
    private static int getValidInt(int parameterNumberRequest){
        int doubleValid=0;
        boolean isValidDouble=false;
        Scanner myGrade = null;
        
        try{
            while(!isValidDouble){
                System.out.println("Por favor ingresa tu nota #"+(parameterNumberRequest+1)+" entre 0 y 100 puntos ");
                try{
                    myGrade = new Scanner(System.in);
                    doubleValid = myGrade.nextInt();
                }catch(Exception ei){
                    System.out.println("Error al ingresar nota.  Excepción: "+ei.toString());
                    doubleValid = 0;
                }
                if((doubleValid>=0) && (doubleValid<=100)){
                    isValidDouble = true;
                    break;
                }
            }
            
        }catch(Exception e){
            System.out.println("Excepción: "+e.toString());
        }

        return doubleValid;
    }
    
    
    /***
     * 
     * @param args 
     */
    public static void main(String[] args) {

        double resultado=0.00;
        
        int numberRequest=0;
        while(numberRequest<3){
            resultado+=getValidInt(numberRequest);
            numberRequest++;
        }
        
        resultado=resultado/3;
        System.out.println("Su nota promedio final es: "+resultado);
        if (resultado >= notaGanadora)
            System.out.println("Usted gano el curso !!!");
        else
            System.out.println("Usted perdio el curso !!! Debera volver a llevarlo el proximo año !!!");
    }    
    
    
}
