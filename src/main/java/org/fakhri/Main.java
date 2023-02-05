package org.fakhri;

import javax.swing.*;
import java.util.Map;

public class Main {

    private static Map<Fields, Object> fieldsListMap;

    public static void main(String[] args) {
//        Window window = new Window();
//        addButtons(window);
        JFrame frame = new JFrame();
        JPanel mainPanel = (new GasketsIndex()).getMainPanel();
        frame.add(mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(mainPanel.getSize());

        frame.setVisible(true);
//        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
//        window.add(panel);
//        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        window.setVisible(true);
        System.out.println("Hello world!");
    }

    private static void makeFrame() {
        JFrame frame = new JFrame();

        GroupLayout layout = new GroupLayout(frame.getContentPane());

    }

//    private static void addButtons(Window window) {
//
//        JPanel panel = new JPanel(new SpringLayout());
//
//        fieldsListMap = new HashMap<>();
//
//        for(Fields field : Fields.values()) {
//            JLabel label = new JLabel(field.getValue() + ": ", JLabel.TRAILING);
//            panel.add(label);
//            String s1[] = { "Jalpaigurisssss", "Mumbai"};
//            JComboBox list = new JComboBox(s1);
////            JTextField textField = new JTextField(10);
//            label.setLabelFor(list);
//            panel.add(list);
////            fieldsListMap.put(field, new)
//        }
//        makeCompactGrid(panel, Fields.values().length, 2,6, 6,6, 6);
//        panel.setOpaque(true);
//        window.setContentPane(panel);
//        window.pack();
//    }
}