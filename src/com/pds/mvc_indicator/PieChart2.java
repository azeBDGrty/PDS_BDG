/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pds.mvc_indicator;


import java.util.List;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.ApplicationFrame;


public class PieChart2 extends ApplicationFrame{
    
  
    private static List<Integer> resultats;
    PieChart2(List<Integer> resultats) {
            super("Répartition des clients par tranche d'âge pour un type de prêt");
        this.resultats=resultats;
        //setContentPane(createDemoPanel( ));
        //this.setSize( 560 , 367 );    
      //RefineryUtilities.centerFrameOnScreen( this);    
      //this.setVisible( true ); 
    }
    
    public static PieDataset createDataset( )  
   {
      
      DefaultPieDataset dataset = new DefaultPieDataset( );
    //  if(resultats.get(0) != 0)
      dataset.setValue( "18 - 25" , resultats.get(0) );
           // if(resultats.get(1) != 0)
      dataset.setValue( "26 - 40" , resultats.get(1));   
               //   if(resultats.get(2) != 0)
      dataset.setValue( "41 - 65" , resultats.get(2) );    
                  //      if(resultats.get(3) != 0)
      dataset.setValue( "66 et plus" , resultats.get(3) );    

      return dataset;         
   }
   private static JFreeChart createChart( PieDataset dataset )
   {
      JFreeChart chart = ChartFactory.createPieChart(      
         "Répartition des clients par tranche d'âge pour un type de prêt",  // chart title 
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
