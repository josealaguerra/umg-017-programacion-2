/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guerra.j.tablamultiplicar;

import java.util.Scanner;

/**
 *
 * @author josealaguerra
 */
public class TablaMultiplicar {
    
    
    
    
    /***
     * Obtiene un numero valido entre 1 y 120
     * @return 
     */
    private static int getValidInt(){
        int intValid = 0;
        boolean isIntValid = false;
        Scanner myAge = null;
        
        try{
            while(!isIntValid){
                System.out.println("Por favor ingresa un número");
                try{
                    myAge = new Scanner(System.in);
                    intValid = myAge.nextInt();
                }catch(Exception ei){
                    System.out.println("Excepción: "+ei.toString());
                    intValid = 0;
                }
                if((intValid>=1) && (intValid<=120)){
                    isIntValid = true;
                    break;
                }
            }
            
        }catch(Exception e){
            System.out.println("Excepción: "+e.toString());
        }

        return intValid;
    }

    
    
    
    public static void main(String[] args) {
        
        int numberRequest = getValidInt();
        int numeroPromedioFinal = 1;
        for(numeroPromedioFinal = 1; numeroPromedioFinal <= 10; numeroPromedioFinal++){
            System.out.println(numeroPromedioFinal+" x "+numberRequest+" = "+numeroPromedioFinal*numberRequest);
        }
        
        numeroPromedioFinal=1;
        while (numeroPromedioFinal <= 10){
            System.out.println(numeroPromedioFinal+" x "+numberRequest+" = "+numeroPromedioFinal*numberRequest);
            numeroPromedioFinal++;
        }
        
    }
    
}
