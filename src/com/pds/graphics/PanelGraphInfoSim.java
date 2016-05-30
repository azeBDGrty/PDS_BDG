/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pds.graphics;

import com.pds.entities.Client;
import com.pds.entities.SimulationPret;
import static com.pds.graphics.PieChart.createDataset;
import java.awt.Color;
import java.awt.Graphics;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DatasetUtilities;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

/**
 *
 * @author zouhairhajji
 */
public class PanelGraphInfoSim extends  ApplicationFrame {

    private JFreeChart barChart;
    private ChartPanel chartPanel;
    public PanelGraphInfoSim(String applicationTitle , String chartTitle, List<SimulationPret> simulations, Client client ){
        super( applicationTitle ); 
        this.barChart = ChartFactory.createBarChart(chartTitle, "Critère", "Score", createDataset(simulations, client), PlotOrientation.VERTICAL,  true, true, false);
        this.chartPanel = new ChartPanel( barChart );
        initComponents();
        setContentPane( chartPanel ); 
    }

    public ChartPanel getChartPanel() {
        return chartPanel;
    }

    
    public JPanel getPanel(){
        JPanel panel = new JPanel();
        panel.add(getChartPanel());
        return panel;
    }
    
    
    
    private CategoryDataset createDataset(  List<SimulationPret> simulations, Client client)
   {
       final DefaultCategoryDataset dataset = new DefaultCategoryDataset();
       int tMensualite = 1;
       int tDuree = 1;
       int tmTTPret = 1;
       
       for(SimulationPret sim : simulations){
           tMensualite += sim.getMensualite();
           tDuree += sim.getDureePret();
           tmTTPret += sim.getMensualite()*sim.getDureePret();
       }
       
       for(SimulationPret sim : simulations){
            dataset.addValue( sim.getMensualite()/100 , "Simulation "+sim.getIdSimPret(), "Mensualite par 100€" );        
            dataset.addValue( sim.getDureePret() , "Simulation "+sim.getIdSimPret() , "Durée en mois" );        
            dataset.addValue( sim.getTauxInteret(), "Simulation "+sim.getIdSimPret() , "Taux d'interet en %" );        
            dataset.addValue( sim.getMtPret()*sim.getDureePret()/10000 , "Simulation "+sim.getIdSimPret() , "Montant total par 10k €" );        
            dataset.addValue( sim.getTauxEndettement(client)*100 , "Simulation "+sim.getIdSimPret() , "Taux d'endettement en %" );   
       }       

      return dataset; 
   }

    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    public void chargerSimulation(List<SimulationPret> simulations){
        
    }
    
    
    
    public static void main( String[ ] args ) {
    
        JFrame frame = new JFrame();
        frame.setVisible(true);
        frame.setBounds(100, 100, 200, 200);
        
        JPanel panel1 = new JPanel(){
            @Override
            public void paint(Graphics g) {
                g.setColor(Color.blue);
                g.fillRect(0, 0, 100, 100);
            }
        };
        panel1.setBounds(100, 100, 100, 100);
        
        JPanel panel2 = new JPanel(){
            @Override
            public void paint(Graphics g) {
                g.setColor(Color.red);
                g.fillRect(0, 0, 100, 100);
            }
        };
        panel2.setBounds(0, 0, 100, 100);
        
        frame.getContentPane().add(panel1);
        frame.getContentPane().add(panel2);
        
        PanelGraphInfoSim chart = new PanelGraphInfoSim("Car Usage Statistics", "Which car do you like?",new LinkedList<>(), null );     
        chart.getPanel().setBounds(200, 200, 400, 400);
        
        
        frame.getContentPane().add(chart.getPanel());
        
        frame.repaint();
        
        frame.revalidate();
   }
    
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
