/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pds.mvc_indicator;


import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JPanel;


public class MainGraphics2 extends JPanel{
 
Controller_Indicator controller;


    public MainGraphics2 (Controller_Indicator controller ) {
        this.controller = controller;
        
       panelPieChart p= new panelPieChart(this.controller);
       panelLineChart plc = new panelLineChart(controller);
       panelIndicatorTable pit = new panelIndicatorTable(controller);
                
        GridLayout gl=new GridLayout(2,0);
        BorderLayout gl2=new BorderLayout();
        gl2.setHgap(20);
        JPanel main=new JPanel();
        JPanel main2=new JPanel();
        
        main.setLayout(gl);
        main2.setLayout(gl2);
        
        //gl.setVgap(20); //20 pixels d'espace entre les lignes (V comme Vertical) 
        //gl.setHgap(20);     //20 pixels d'espace entre les colonnes

        //this.add(ps);
        //this.add(atp);
       
        main.add(p);
        main.add(plc);
        
        main2.add(pit, BorderLayout.SOUTH);
        
        this.add(main2);
        this.add(main);
        
        this.setLayout(new BorderLayout());
        this.add(main,BorderLayout.EAST);
        this.add(main2, BorderLayout.WEST);
        setSize(1330, 620);
        
        this.setVisible(true);
    }
    
  
}
