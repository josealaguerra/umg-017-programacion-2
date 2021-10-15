/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chinautla.sabado.sistemasoperativos.jag.totito;


import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import javax.swing.SwingUtilities;
import java.awt.event.MouseAdapter;

/**
 *
 * @author josea
 */
public class Boton extends JButton implements MouseListener{

    //Se inicializa el boton poniendole un lugar y tamaño
    public Boton( int xPosicion, int yPosition, int ancho, int alto ){ 

        setBounds(xPosicion, yPosition, ancho, alto);
        
        //Se agrega el action listener en este caso la misma clase
        //addActionListener( this );
        
        //Escucha las acciones del mouse
        addMouseListener( this );
    }
    
    //---------------------- Se asigna una el nombre del boton ---------------//
    public void setNombre( int f, int c ){
        setText( f + " , " + c );
    }


    @Override
    public void mouseClicked(MouseEvent me) {
        //System.out.println("Click");
        if(me.getButton() == MouseEvent.BUTTON1) {
            //this.setText( this.getText() + "Left");
            //System.out.println("Left Click!");
            //Se asigna el color de fondo azul
            setBackground(Color.GREEN);
            //Se asigna un color de letra color blanco
            setForeground(Color.BLUE);
            setIcon( new javax.swing.ImageIcon( getClass().getResource("busca1.jpg") ) ); // NOI18N
        }
        if(me.getButton() == MouseEvent.BUTTON2) {
            //this.setText( this.getText() + "Middle");
            System.out.println("Middle Click!");
        }
        if(me.getButton() == MouseEvent.BUTTON3) {
            //this.setText( this.getText() + "Right");
            //System.out.println("Right Click!");
            //Se asigna el color de fondo azul
            setBackground(Color.RED);
            //Se asigna un color de letra color blanco
            setForeground(Color.WHITE);
            setIcon( new javax.swing.ImageIcon( getClass().getResource("busca1.jpg") ) ); // NOI18N
        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println("Presionado");
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        System.out.println("Liberado");
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        System.out.println("Ingresado");
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
        System.out.println("Salida");
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
