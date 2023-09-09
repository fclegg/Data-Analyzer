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
    ChartPanel chartPanel;

    public LineChartEx () {
        initUI();
    }

    private void initUI(){

        JFreeChart chart = createChart(new XYSeriesCollection(), "X Axis", "Y Axis");

        chartPanel = new ChartPanel(chart, 516, 384, 516, 384, 516*4, 384*4, true, true, true, true, true, true);
        chartPanel.setBorder(BorderFactory.createEmptyBorder(25, 15, 25, 15));
        add(chartPanel);
    }

    public void newChart(XYSeries series, String xAxisLabel, String yAxisLabel) {
        var dataset = new XYSeriesCollection();
        dataset.addSeries(series);

        chartPanel.setChart(createChart(dataset, xAxisLabel, yAxisLabel));
    }


    private JFreeChart createChart(XYDataset dataset, String xAxisLabel, String yAxisLabel) {

        JFreeChart chart = ChartFactory.createXYLineChart(
                yAxisLabel + " vs " + xAxisLabel,
                xAxisLabel,
                yAxisLabel,
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
        renderer.setSeriesShapesVisible(0, false);

        plot.setRangeGridlinesVisible(true);
        plot.setRangeGridlinePaint(Color.BLACK);

        plot.setDomainGridlinesVisible(true);
        plot.setDomainGridlinePaint(Color.BLACK);

        chart.getLegend().setFrame(BlockBorder.NONE);

        /*chart.setTitle(new TextTitle("Y per X",
                new Font("Serif", java.awt.Font.BOLD, 18)
            )
        );*/

        return chart;
    }
}