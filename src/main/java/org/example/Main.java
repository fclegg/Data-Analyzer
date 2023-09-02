package org.example;

import javax.swing.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main extends JFrame {
    public static void main(String[] args) {
        /*
        EventQueue.invokeLater(() -> {
            var ex = new SplitPane();
            ex.setVisible(true);
        }); */

        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            SplitPaneX window = new SplitPaneX();
            public void run() {
                window.createAndShowGUI();
            }
        });
    }
}