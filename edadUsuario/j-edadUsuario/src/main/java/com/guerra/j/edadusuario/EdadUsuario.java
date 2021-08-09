/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guerra.j.edadusuario;

import java.util.Scanner;

/**
 *
 * @author josealaguerra
 */
public class EdadUsuario {
    
    
    /***
     * Según tu edad, valida quien eres (niño, joven, adulto o tercera edad).
     * @param parameterAge
     * @return 
     */
    private static String whoYouAre(int parameterAge){
        if (parameterAge<=12){
            return "niño";
        }else if (parameterAge <=18){
            return "joven";        
        }else if (parameterAge <=60){
            return "adulto";        
        }else  if (parameterAge <=60){
            return "tercera edad";        
        }else
            return "indefinido";
    }

    
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
                System.out.println("Por favor ingresa tu edad entre 1 y 120 años ");
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

    
    /***
     * Solicita un entero valido entre 1 y 120.  E indica quien eres.
     * @param args 
     */
    public static void main(String[] args) {

        int enterYourAge=0;
        enterYourAge = getValidInt();
        System.out.println("Según tu edad: "+enterYourAge+", tu eres "+whoYouAre(enterYourAge));

    }
    
}
