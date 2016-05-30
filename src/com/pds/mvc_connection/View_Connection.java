/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pds.mvc_connection;

import com.pds.implobs.AbstractObservable;
import com.pds.implobs.IObserver;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Observer;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author zouhairhajji
 */

public class View_Connection extends javax.swing.JInternalFrame implements IObserver{

    private Controller_Connection controller;
    
    public View_Connection(Controller_Connection controller) {
        this.controller = controller;
        initComponents();
        this.bClear.addActionListener(new ClearListener());
        this.bSignIn.addActionListener(new SignInListener());
        
        this.iLogin.addKeyListener(new SignInKeyListener());
        this.iPassWord.addKeyListener(new SignInKeyListener());
        
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        iLogin = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        bClear = new javax.swing.JButton();
        bSignIn = new javax.swing.JButton();
        iPassWord = new javax.swing.JPasswordField();

        setClosable(true);
        setIconifiable(true);

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 36)); // NOI18N
        jLabel1.setText("Connection");

        iLogin.setText("Zouhair2");
        iLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iLoginActionPerformed(evt);
            }
        });

        jLabel2.setText("Login :");

        jLabel3.setText("Password :");

        bClear.setText("Clear");

        bSignIn.setText("Sign in");

        iPassWord.setText("12345");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(129, 129, 129)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(99, 99, 99)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(iLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(iPassWord, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(bClear, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(bSignIn, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(78, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(iLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(iPassWord, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bClear)
                    .addComponent(bSignIn))
                .addContainerGap(56, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void iLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iLoginActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_iLoginActionPerformed

    

    public JTextField getiLogin() {
        return iLogin;
    }

    
    
    
    
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bClear;
    private javax.swing.JButton bSignIn;
    private javax.swing.JTextField iLogin;
    private javax.swing.JPasswordField iPassWord;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables

    
    public class SignInListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            controller.seConnecter(iLogin.getText(), iPassWord.getText());
        }
    }
    
    public class ClearListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            iLogin.setText("");
            iPassWord.setText("");
        }
    }
    
    
    public class SignInKeyListener implements KeyListener{

        @Override
        public void keyTyped(KeyEvent e) {}

        @Override
        public void keyPressed(KeyEvent e) {
            switch(e.getKeyCode()){
                case KeyEvent.VK_ENTER:
                    controller.seConnecter(iLogin.getText(), iPassWord.getText());
                    break;
                default:
                    break;
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {}  
    }

    @Override
    public boolean update(AbstractObservable sender, String message, Object... data) {
        System.out.println(message);
        switch(message.toString().trim()){
            case "connectionAutorised" :
                this.controller.fermer(this);
                JOptionPane.showMessageDialog(this, "Vous êtes maintenant connecté");
                return true;
                
            case "connectionRefused" :
                JOptionPane.showMessageDialog(this, "La connexion est refusée");
                return true;
                
            case "connectionDone" :  
                JOptionPane.showMessageDialog(this, "La connexion est déjà établie");
                return true;
                
            default :
                return false;
        }
    }
    
    
    
}
