/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vod;

/**
 *
 * @author Krystian
 */
import vod.Produkt;
import java.awt.ComponentOrientation;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.SwingUtilities;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
 
/**
 *
 * @author Krystian
 */
public class ProduktInfo extends ApplicationFrame implements ActionListener{
    
    JButton button = new JButton("ZAMKNIJ");

 
    XYDataset dataset;
 
    int x,y;
 
    /**
     *
     * @param produkt
     * tworzy wykres
     */
    public ProduktInfo(Produkt produkt) {
    super(produkt.getNazwa());
 
    dataset = createDataset(produkt.getObejrzenia());
    JFreeChart chart = createChart(dataset);
    
    
  
    JLabel nazwa = new JLabel(produkt.getNazwa());
    JLabel cena = new JLabel(String.valueOf(produkt.getCena()));
    JLabel ocena = new JLabel(String.valueOf(produkt.getOcena()));
    
    
    ChartPanel chartPanel = new ChartPanel(chart);

    chartPanel.setPreferredSize(new java.awt.Dimension(750, 400));
    setContentPane(chartPanel);
    chartPanel.add(button);
    chartPanel.add(nazwa);
    chartPanel.add(cena);
    chartPanel.add(ocena);
    button.addActionListener(this);
    
    }
    
    /**
     *
     * @param a
     * używa listy
     * @return
     * zwraca dataset do wykresu
     */
    public XYDataset createDataset(ArrayList a) {
    XYSeries series1 = new XYSeries("First");
    series1.add(x, y);  // te zmienne chcę modyfikować
    
    for(int i = 0;i<a.size();i++){
        series1.add(i, (double) ((Integer)a.get(i)).intValue());
    }
 
    XYSeriesCollection dataset = new XYSeriesCollection();
    dataset.addSeries(series1);
    return dataset;
    }
 
    private JFreeChart createChart(XYDataset dataset) {
    JFreeChart chart = ChartFactory.createXYLineChart(
        "   ", 
        "Dni", 
        "Obejrzenia", 
        dataset, 
        PlotOrientation.VERTICAL,
        true, 
        true, 
        false 
        );
 
    return chart;
    }

    /**
     *
     * @param e
     * klikniecie guzikiem
     */
    public void buttonactionPerformed(ActionEvent e) {
        this.setVisible(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.setVisible(false);
    }
 
    
    
    }
