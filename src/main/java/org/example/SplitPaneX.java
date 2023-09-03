package org.example;

import org.jfree.data.xy.XYDataItem;
import org.jfree.data.xy.XYSeries;

import javax.sound.sampled.Line;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.filechooser.FileFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class SplitPaneX /*extends JFrame*/ implements ListSelectionListener, ActionListener {
    private JList list;
    private JSplitPane splitPane;
    private Container pane = new Container();
    private LineChartEx graph = new LineChartEx();
    private File logFile;

    private String[] datasets = {"Dataset 1", "Dataset 2", "Dataset 3", "Dataset 4"};
    private double[] dataset1X = {0, 5, 10, 15, 20, 25, 30, 35};
    private double[] dataset1Y = {203,462,285,357,441,451,542,500};

    public SplitPaneX() {
        list = new JList();
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.setSelectedIndex(0);
        list.addListSelectionListener(this);

        JScrollPane listScrollPane = new JScrollPane(list);
        JButton button = new JButton("Import File");
        button.setBackground(Color.WHITE);
        button.addActionListener(this);

        LayoutManager layout = new BorderLayout();
        pane.setLayout(layout);

        pane.add(listScrollPane, BorderLayout.CENTER);
        pane.add(button, BorderLayout.PAGE_START);

        splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, pane, graph);

        Dimension listMinimumSize = new Dimension(160, 50);
        Dimension listPreferredSize = new Dimension(200, 50);
        Dimension graphMinimumSize = new Dimension(500, 50);
        listScrollPane.setMinimumSize(listMinimumSize);
        listScrollPane.setPreferredSize(listPreferredSize);
        graph.setMinimumSize(graphMinimumSize);


        splitPane.setPreferredSize(new Dimension(800, 500));


        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

    public void valueChanged(ListSelectionEvent e) {
        JList list = (JList)e.getSource();
        //updateGraph(list.getSelectedIndex(), );
    }

    private void updateGraph(int listIndex, double[] xValues, double[] yValues, String yAxisLabel){
        graph.newChart(xValues, yValues, "Time", yAxisLabel);
    }

    public /*static*/ void createAndShowGUI() {

        //Create and set up the window.
        JFrame frame = new JFrame("SplitPaneDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.getContentPane().add(splitPane);

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        JFileChooser fc = new JFileChooser();

        FileFilter txtFilefilter = new FileFilter()
        {
            public boolean accept(File file) {
                if (file.getName().endsWith(".txt") || Files.isDirectory(Path.of(file.getPath()))) {
                    return true;
                }
                return false;
            }
            public String getDescription(){
                return ".txt";
            }
        };

        fc.setFileFilter(txtFilefilter);
        int returnVal = fc.showOpenDialog(list);

        logFile = fc.getSelectedFile();
            populateList();
    }

    public void populateList() {
        try {
            Scanner scanner = new Scanner(logFile);
            String log = scanner.next();
            String[] dataPoints = log.split(";");

            HashMap<String, XYSeries> categories = new HashMap<String, XYSeries>();


            for (int i = 0; i < dataPoints.length; i++) {
                String[] items = dataPoints[i].split(",");
                categories.put(items[0], null);
            }

            list.setListData(categories.keySet().toArray());

        } catch(FileNotFoundException e) {
            System.out.println("File not found bitch");
            e.printStackTrace();
        }
    }

    /*
    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
    */

}
