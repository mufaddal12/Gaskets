package org.fakhri;

import javax.swing.*;
import java.util.Map;

public class Main {


    public static void main(String[] args) throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");

        JFrame frame = new JFrame();
        JPanel mainPanel = (new GasketsIndex()).getMainPanel();
        frame.add(mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(mainPanel.getPreferredSize());
//        frame.
        frame.setVisible(true);
        System.out.println("Hello world!");
    }
}