/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pds.mvc_indicator;

import java.awt.BasicStroke;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.XYToolTipGenerator;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;

/**
 *
 * @author Poweriser
 */
public class lineChart2 extends ApplicationFrame {
    
    private static List<Integer> loanNumberList;
    private static List<Integer> simNumberList;    
    public lineChart2(List<Integer> loanNumberList,List<Integer> simNumberList) {
        super("Evolution du nombres de simulations / prêt");
       this.loanNumberList=loanNumberList;
       this.simNumberList=simNumberList;
    }
        
    
    
    public JPanel createChartPanel() {
        // creates a line chart object
        // returns the chart panel
        
        String chartTitle = "Evolution du nombres de simulations / prêt test";
        String xAxisLabel = "Temps";
        String yAxisLabel = "Quantité";
        
        XYDataset dataset = createDataset();
        
        JFreeChart chart = ChartFactory.createXYLineChart(chartTitle,
                xAxisLabel, yAxisLabel, dataset);
        
        XYPlot plot = chart.getXYPlot();
        ChartPanel chartpanel=new ChartPanel (chart);
        chartpanel.setInitialDelay(100);
        chartpanel.setDismissDelay(100);
        chartpanel.setReshowDelay(100);
        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
        
        // sets paint color for each series
        renderer.setSeriesPaint(0, Color.RED);
        renderer.setSeriesPaint(1, Color.GREEN);
        
        
        // sets thickness for series (using strokes)
        renderer.setSeriesStroke(0, new BasicStroke(2.0f));
        renderer.setSeriesStroke(1, new BasicStroke(2.0f));
        
        
        plot.setRenderer(renderer);
        plot.setBackgroundPaint(Color.WHITE);
        //plot.setRangeGridlinesVisible(true);
        plot.setRangeGridlinePaint(Color.BLACK);
        
        plot.setDomainGridlinesVisible(true);
        plot.setDomainGridlinePaint(Color.BLACK);
        XYToolTipGenerator xyToolTipGenerator =(XYDataset xyd, int i, int i1) -> {      //mouseover sur un point d'une courbe
            Number x1 = dataset.getX(i, i1);
            Number y1 = dataset.getY(i, i1);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(String.format("<html><p style='color:#0000ff;'>Serie: '%s'</p>", dataset.getSeriesKey(i)));
            stringBuilder.append(String.format("Mois:'%d'<br/>", x1.intValue()));
            stringBuilder.append(String.format("Montant:'%d'", y1.intValue()));
            stringBuilder.append("</html>");
            return stringBuilder.toString();
        };
        
        renderer.setBaseToolTipGenerator(xyToolTipGenerator);
        
        return new ChartPanel(chart);
    }
    
    
    
    private XYDataset createDataset() {
        // creates an XY dataset...
        // returns the dataset
        
        XYSeriesCollection dataset = new XYSeriesCollection();
        XYSeries series1 = new XYSeries("Prêt");
        XYSeries series2 = new XYSeries("Simulation");
        
        
        for (int i=0; i<12;i++){
            series1.add(i,loanNumberList.get(i) );
            series2.add(i, simNumberList.get(i));
            
            
        }

        dataset.addSeries(series1);
        dataset.addSeries(series2);
      
        
        return dataset;
    }
}
