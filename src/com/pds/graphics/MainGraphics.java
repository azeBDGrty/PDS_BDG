/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pds.graphics;


import com.pds.entities.SimulationPret;
import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Nodaro
 */
public class MainGraphics extends JPanel{
    
    

    public MainGraphics ( SimulationPret simLoan) {
        
        LineChart l = new LineChart(simLoan);
        PieChart p=new PieChart( simLoan);

        JPanel panelLineChart=l.createChartPanel();
        JPanel panelPieChart=p.createDemoPanel( );
        AmortisationTablePanel atp = new AmortisationTablePanel(simLoan);
        ParametresSimulation ps=new ParametresSimulation(simLoan);
                
        GridLayout gl=new GridLayout(2,0);
        BorderLayout gl2=new BorderLayout();
        gl2.setHgap(20);    //vertical space 
        JPanel main=new JPanel();
        JPanel main2=new JPanel();
        
        main.setLayout(gl);
        main2.setLayout(gl2);
        
        main.add(panelLineChart);
        main.add(panelPieChart);
        main2.add(ps, BorderLayout.NORTH);
        main2.add(atp, BorderLayout.SOUTH);
        
        this.add(main2);
        this.add(main);
        
        this.setLayout(new BorderLayout());
        this.add(main,BorderLayout.EAST);
        this.add(main2, BorderLayout.WEST);
        setSize(1330, 620);
        
        this.setVisible(true);
    }
    
  
}
