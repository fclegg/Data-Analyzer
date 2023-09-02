package org.example;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.block.BlockBorder;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javax.swing.*;
import java.awt.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class LineChartEx extends JPanel {
    public LineChartEx () {
        initUI();
    }

    private void initUI(){

        XYDataset dataset = createDataset();
        JFreeChart chart = createChart(dataset);

        ChartPanel chartPanel = new ChartPanel(chart, 516, 384, 516/4, 384/4, 516*2, 384*2, true, true, true, true, true, true);
        chartPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        //chartPanel.setBackground(Color.BLACK);
        add(chartPanel);

        //public ChartPanel(JFreeChart chart, int width, int height, int minimumDrawWidth, int minimumDrawHeight, int maximumDrawWidth, int maximumDrawHeight, boolean useBuffer, boolean properties, boolean save, boolean print, boolean zoom, boolean tooltips) {
        //    this(chart, width, height, minimumDrawWidth, minimumDrawHeight, maximumDrawWidth, maximumDrawHeight, useBuffer, properties, true, save, print, zoom, tooltips);

        //pack();
        //("Line Chart");
        //setLocationRelativeTo(null);
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private XYDataset createDataset(){
        var series1 = new XYSeries("Dataset1");
        series1.add(18, 567);
        series1.add(20, 612);
        series1.add(25, 800);
        series1.add(30, 980);
        series1.add(40, 1410);
        series1.add(50, 2350);

        var series2 = new XYSeries("Dataset2");
        series2.add(18, 530);
        series2.add(20, 580);
        series2.add(25, 740);
        series2.add(30, 901);
        series2.add(40, 1300);
        series2.add(50, 2219);

        var series3 = new XYSeries("Dataset3");
        series3.add(18, 530);
        series3.add(20, 530);
        series3.add(25, 530);
        series3.add(30, 530);
        series3.add(40, 530);
        series3.add(50, 530);

        var dataset = new XYSeriesCollection();
        dataset.addSeries(series1);
        dataset.addSeries(series2);
        //dataset.addSeries(series3);

        return dataset;
    }

    private JFreeChart createChart(XYDataset dataset) {

        JFreeChart chart = ChartFactory.createXYLineChart(
                "Y axis per X axis",
                "X axis",
                "Y axis",
                dataset,
                PlotOrientation.VERTICAL,
                true,
                true,
                false
        );

        XYPlot plot = chart.getXYPlot();

        var renderer = new XYLineAndShapeRenderer();

        plot.setRenderer(renderer);
        plot.setBackgroundPaint(Color.white);

        plot.setRangeGridlinesVisible(true);
        plot.setRangeGridlinePaint(Color.BLACK);

        plot.setDomainGridlinesVisible(true);
        plot.setDomainGridlinePaint(Color.BLACK);

        chart.getLegend().setFrame(BlockBorder.NONE);

        chart.setTitle(new TextTitle("Y per X",
                new Font("Serif", java.awt.Font.BOLD, 18)
            )
        );

        return chart;
    }
}