package org.example;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;

public class SplitPaneX extends JPanel implements ListSelectionListener {
    private JList list;
    private JLabel picture;
    private JSplitPane splitPane;

    private String[] datasets = {"Dataset 1", "Dataset 2", "Dataset 3", "Dataset 4"};

    public SplitPaneX() {
        list = new JList(datasets);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.setSelectedIndex(0);
        list.addListSelectionListener(this);

        JScrollPane listScrollPane = new JScrollPane(list);
        picture = new JLabel();

        JPanel graph = new LineChartEx();

        splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, listScrollPane, graph);

        Dimension listMinimumSize = new Dimension(200, 50);
        Dimension graphMinimumSize = new Dimension(500, 50);
        listScrollPane.setMinimumSize(listMinimumSize);
        picture.setMinimumSize(graphMinimumSize);


        splitPane.setPreferredSize(new Dimension(800, 500));
    }

    public void valueChanged(ListSelectionEvent e) {
        JList list = (JList)e.getSource();
        list.getSelectedIndex();
    }

    private void updateGraph(){

    }

    public /*static*/ void createAndShowGUI() {

        //Create and set up the window.
        JFrame frame = new JFrame("SplitPaneDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        SplitPaneX splitPane = new SplitPaneX();
        frame.getContentPane().add(splitPane.getSplitPane());

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

    public JSplitPane getSplitPane() {
        return splitPane;
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
