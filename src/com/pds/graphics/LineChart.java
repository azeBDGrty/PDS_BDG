/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package com.pds.graphics;

import com.pds.entities.CalculPret;
import com.pds.entities.SimulationPret;
import com.pds.entities.Taux_directeur;
import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
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
 * @author Nodaro
 */
public class LineChart extends ApplicationFrame {
    
    private static CalculPret calculPret;
    private static SimulationPret simLoan;
    



    public LineChart( SimulationPret simulationLoan)  {
        super("Graphique d'amortissement");
        this.simLoan=simulationLoan;
    }
    
    public JPanel createChartPanel() {
        // creates a line chart object
        // returns the chart panel
        
        String chartTitle = "Graphique d'amortissement";
        String xAxisLabel = "Mensualités";
        String yAxisLabel = "Montant";
        
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
        renderer.setSeriesPaint(2, Color.YELLOW);
        
        // sets thickness for series (using strokes)
        renderer.setSeriesStroke(0, new BasicStroke(2.0f));
        renderer.setSeriesStroke(1, new BasicStroke(2.0f));
        renderer.setSeriesStroke(2, new BasicStroke(2.0f));
        
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
        List<Double> capAmorti=new ArrayList<>();
        List<Double> capRestant=new ArrayList<>();
        List<Double> evolutionInterets=new ArrayList<>();
        evolutionInterets=simLoan.calcEvolutionInterets();
        evolutionInterets.add(0,0d);
        capAmorti=simLoan.calcEvolutionCapAmmorti();
        capRestant=simLoan.calcCapRestant();
        capRestant.add(0, simLoan.getMtPret());
        XYSeriesCollection dataset = new XYSeriesCollection();
        XYSeries series1 = new XYSeries("Capital Remboursé");
        XYSeries series2 = new XYSeries("Reste dû");
        XYSeries series3 = new XYSeries("Interêts remboursés");
        
        for (int i=0; i<=simLoan.getDureePret();i++){
            series1.add(i,capAmorti.get(i) );
            series2.add(i, capRestant.get(i));
            series3.add(i, evolutionInterets.get(i));
            
        }

        dataset.addSeries(series1);
        dataset.addSeries(series2);
        dataset.addSeries(series3);
        
        return dataset;
    }
    
    
   
    
    
    
    
}

