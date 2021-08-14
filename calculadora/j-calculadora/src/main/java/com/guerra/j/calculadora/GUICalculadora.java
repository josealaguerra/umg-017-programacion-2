/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guerra.j.calculadora;

import javax.swing.JOptionPane;

/**
 *
 * @author josea
 */
public class GUICalculadora extends javax.swing.JFrame {

//Number
    private String cnN0="0";
    private String cnN1="1";
    private String cnN2="2";
    private String cnN3="3";
    private String cnN4="4";
    private String cnN5="5";
    private String cnN6="6";
    private String cnN7="7";
    private String cnN8="8";
    private String cnN9="9";
    //Signo
    private String cnPoint=".";
    private String cnInitialText="";    
    //Operaciones
    private String cnPlus="+";
    private String cnMinus="-";
    private String cnMultiply="*";
    private String cnDivide="/";
    //Temporales    
    private String operation="";
    private Double numero1=0.00;
    private Double numero2=0.00;
    

    /**
     * Creates new form GUICalculadora
     */
    public GUICalculadora() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jTxt = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jBtn7 = new javax.swing.JButton();
        jBtn8 = new javax.swing.JButton();
        jBtn9 = new javax.swing.JButton();
        jBtn6 = new javax.swing.JButton();
        jBtn5 = new javax.swing.JButton();
        jBtn4 = new javax.swing.JButton();
        jBtn3 = new javax.swing.JButton();
        jBtn2 = new javax.swing.JButton();
        jBtn1 = new javax.swing.JButton();
        jBtnPoint = new javax.swing.JButton();
        jBtn0 = new javax.swing.JButton();
        jBtnEqual = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jBtnPlus = new javax.swing.JButton();
        jBtnMinus = new javax.swing.JButton();
        jBtnMultiply = new javax.swing.JButton();
        jBtnDivide = new javax.swing.JButton();
        jBtnNew = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Calculadora");

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));

        jTxt.setEditable(false);
        jTxt.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 204, 204));

        jBtn7.setText("7");
        jBtn7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ActionPerformedGeneral(evt);
            }
        });

        jBtn8.setText("8");
        jBtn8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ActionPerformedGeneral(evt);
            }
        });

        jBtn9.setText("9");
        jBtn9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ActionPerformedGeneral(evt);
            }
        });

        jBtn6.setText("6");
        jBtn6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ActionPerformedGeneral(evt);
            }
        });

        jBtn5.setText("5");
        jBtn5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ActionPerformedGeneral(evt);
            }
        });

        jBtn4.setText("4");
        jBtn4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ActionPerformedGeneral(evt);
            }
        });

        jBtn3.setText("3");
        jBtn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ActionPerformedGeneral(evt);
            }
        });

        jBtn2.setText("2");
        jBtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ActionPerformedGeneral(evt);
            }
        });

        jBtn1.setText("1");
        jBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ActionPerformedGeneral(evt);
            }
        });

        jBtnPoint.setText(".");
        jBtnPoint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ActionPerformedGeneral(evt);
            }
        });

        jBtn0.setText("0");
        jBtn0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ActionPerformedGeneral(evt);
            }
        });

        jBtnEqual.setText("=");
        jBtnEqual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OperationsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jBtn0)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtnPoint)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jBtnEqual))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jBtn7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBtn8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBtn9))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jBtn4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBtn5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBtn6))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jBtn1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBtn2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBtn3)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtn7)
                    .addComponent(jBtn9)
                    .addComponent(jBtn8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtn4)
                    .addComponent(jBtn6)
                    .addComponent(jBtn5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtn1)
                    .addComponent(jBtn3)
                    .addComponent(jBtn2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtn0)
                    .addComponent(jBtnPoint)
                    .addComponent(jBtnEqual))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 204));

        jBtnPlus.setText("+");
        jBtnPlus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OperationsActionPerformed(evt);
            }
        });

        jBtnMinus.setText("-");
        jBtnMinus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OperationsActionPerformed(evt);
            }
        });

        jBtnMultiply.setText("*");
        jBtnMultiply.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OperationsActionPerformed(evt);
            }
        });

        jBtnDivide.setText("/");
        jBtnDivide.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OperationsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBtnPlus)
                    .addComponent(jBtnMinus)
                    .addComponent(jBtnMultiply)
                    .addComponent(jBtnDivide))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBtnPlus)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtnMinus)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtnMultiply)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtnDivide)
                .addContainerGap())
        );

        jBtnNew.setText("Nuevo calculo");
        jBtnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnNewActionPerformed(evt);
            }
        });

        jScrollPane1.setEnabled(false);

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setText("Pasos a realizar:\n1.) Ingresa un número valido\n2.) Selecciona una operación \n(suma, resta, multiplicación o división).\n3.) Ingresa un segundo número valido.\n4.) Presiona el boton Igual\n5.) Para un nuevo calculo debes \npresionar el boton NUEVO CALCULO.");
        jTextArea1.setWrapStyleWord(true);
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jBtnNew)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 372, Short.MAX_VALUE)
                .addGap(21, 21, 21))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jBtnNew)))
                .addGap(25, 25, 25))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    /***
     * Administra lo que hagan los botoenes del 0 al 9 y el punto
     * @param evt 
     */
    private void ActionPerformedGeneral(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ActionPerformedGeneral
        if( evt.getSource()==jBtn0){
            jTxt.setText( jTxt.getText() +cnN0 );
        }else if( evt.getSource()==jBtn1){
            jTxt.setText( jTxt.getText() +cnN1 );
        }else if( evt.getSource()==jBtn2){
            jTxt.setText( jTxt.getText() +cnN2 );
        }else if( evt.getSource()==jBtn3){
            jTxt.setText( jTxt.getText() +cnN3 );
        }else if( evt.getSource()==jBtn4){
            jTxt.setText( jTxt.getText() +cnN4 );
        }else if( evt.getSource()==jBtn5){
            jTxt.setText( jTxt.getText() +cnN5 );
        }else if( evt.getSource()==jBtn6){
            jTxt.setText( jTxt.getText() +cnN6 );
        }else if( evt.getSource()==jBtn7){
            jTxt.setText( jTxt.getText() +cnN7 );
        }else if( evt.getSource()==jBtn8){
            jTxt.setText( jTxt.getText() +cnN8 );
        }else if( evt.getSource()==jBtn9){
            jTxt.setText( jTxt.getText() +cnN9 );
        }else if( evt.getSource()==jBtnPoint){
            jTxt.setText( jTxt.getText() +cnPoint );
        }
    }//GEN-LAST:event_ActionPerformedGeneral

    
    /***
     * Administra lo que se hagan las diferentes operaciones
     * @param evt 
     */
    private void OperationsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OperationsActionPerformed
        
        if( evt.getSource()==jBtnEqual){
            
            String textoADesplegar="";

            try{
                numero2 = Double.parseDouble( jTxt.getText().toString() );
            }catch(Exception e){
                jTxt.setText(cnInitialText);
                operation = "";
                JOptionPane.showMessageDialog(null, "Error al convertir numero ingresado, vuelve a ingresrlo", "Numero invalido", JOptionPane.ERROR_MESSAGE);
            }

            Double resultado=0.00;
            if( operation.equals(cnPlus) ){
                resultado = numero1+numero2;
            }else if( operation.equals(cnMinus) ){
                resultado = numero1-numero2;
            }else if( operation.equals(cnMultiply) ){
                resultado = numero1*numero2;
            }else if( operation.equals(cnDivide) ){
                if(numero2==0){
                    textoADesplegar="Numero indefinido";
                }else{
                    resultado = numero1/numero2;
                }
                
            }
            if(textoADesplegar.equals(""))
                jTxt.setText( resultado.toString() );
            else
                jTxt.setText( textoADesplegar );
            
            inicializar();
            
        }else{
            if( evt.getSource()==jBtnPlus){
                operation = cnPlus;
            }else if( evt.getSource()==jBtnMinus){
                operation = cnMinus;
            }else if( evt.getSource()==jBtnMultiply){
                operation = cnMultiply;
            }else if( evt.getSource()==jBtnDivide){
                operation = cnDivide;
            }
            try{
                numero1 = Double.parseDouble( jTxt.getText().toString() );
                jTxt.setText(cnInitialText);
            }catch(Exception e){
                jTxt.setText(cnInitialText);
                operation = "";
                JOptionPane.showMessageDialog(null, "Error al convertir numero ingresado, vuelve a ingresrlo", "Numero invalido", JOptionPane.ERROR_MESSAGE);
            }
        }

    }//GEN-LAST:event_OperationsActionPerformed

    private void jBtnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnNewActionPerformed
        inicializar();
        jTxt.setText(cnInitialText);
    }//GEN-LAST:event_jBtnNewActionPerformed

    private void inicializar(){
        numero1=0.00;
        numero2=0.00;
        operation="";
        
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUICalculadora.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUICalculadora.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUICalculadora.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUICalculadora.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUICalculadora().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtn0;
    private javax.swing.JButton jBtn1;
    private javax.swing.JButton jBtn2;
    private javax.swing.JButton jBtn3;
    private javax.swing.JButton jBtn4;
    private javax.swing.JButton jBtn5;
    private javax.swing.JButton jBtn6;
    private javax.swing.JButton jBtn7;
    private javax.swing.JButton jBtn8;
    private javax.swing.JButton jBtn9;
    private javax.swing.JButton jBtnDivide;
    private javax.swing.JButton jBtnEqual;
    private javax.swing.JButton jBtnMinus;
    private javax.swing.JButton jBtnMultiply;
    private javax.swing.JButton jBtnNew;
    private javax.swing.JButton jBtnPlus;
    private javax.swing.JButton jBtnPoint;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTxt;
    // End of variables declaration//GEN-END:variables
}
