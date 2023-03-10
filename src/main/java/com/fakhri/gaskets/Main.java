package com.fakhri.gaskets;

import com.fakhri.gaskets.dao.impl.JdbcMaterialDao;
import com.fakhri.gaskets.entity.Material;
import com.fakhri.gaskets.dao.impl.JsonMaterialDao;
import com.fakhri.gaskets.exceptions.ApplicationException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import java.io.IOException;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class Main {

    public static void createAndShowGUI() {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException |
                 UnsupportedLookAndFeelException e) {
            throw new ApplicationException(e);
        }

        JFrame frame = new JFrame();
        JPanel mainPanel = (new GasketsIndex()).getMainPanel();
        frame.add(mainPanel);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setSize(mainPanel.getPreferredSize());
        frame.setVisible(true);
    }

    public static void setup() throws IOException {
        JdbcMaterialDao jdbcMaterialDao = JdbcMaterialDao.getInstance();
        if(!jdbcMaterialDao.getAllUniqueMaterials().isEmpty()) {
            return;
        }
        JsonMaterialDao jsonMaterialDao = JsonMaterialDao.getInstance();
        for(String materialName : jsonMaterialDao.getAllUniqueMaterials()) {
            for(Material material : jsonMaterialDao.getMaterialsByName(materialName)) {
                jdbcMaterialDao.save(material);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        setup();
        javax.swing.SwingUtilities.invokeLater(Main::createAndShowGUI);
    }
}