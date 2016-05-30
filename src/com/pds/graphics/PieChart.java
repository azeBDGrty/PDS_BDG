/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pds.graphics;

import com.pds.entities.SimulationPret;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.ApplicationFrame;

/**
 *
 * @author Nodaro
 */
public class PieChart extends ApplicationFrame{
    

    private static SimulationPret simPret;
    
    

    public PieChart( SimulationPret simulationPret) {
        super("Répartion des remboursements");
        simPret=simulationPret;
    }
    public static PieDataset createDataset( )  
   {
      
      double capitalPayes=simPret.calcSum(simPret.calcCapAmmort());
      double insurance=simPret.calcSumAssurance();
      double interests=simPret.calcSum(simPret.calcInterets());
      DefaultPieDataset dataset = new DefaultPieDataset( );
      dataset.setValue( "Capital" , capitalPayes );  
      dataset.setValue( "Interets" , interests);   
      dataset.setValue( "Assurance" , insurance );    
      return dataset;         
   }
   private static JFreeChart createChart( PieDataset dataset )
   {
      JFreeChart chart = ChartFactory.createPieChart(      
         "Répartion des remboursements",  // chart title 
         dataset,        // data    
         true,           // include legend   
         true, 
         false);

      return chart;
   }
   
  
   
   public static JPanel createDemoPanel( ) 
   {
      JFreeChart chart = createChart(createDataset( ) );  
      return new ChartPanel( chart ); 
   }

}
