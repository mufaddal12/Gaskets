package org.fakhri;

import org.fakhri.dao.impl.JdbcMaterialDao;
import org.fakhri.entity.Material;
import org.fakhri.dao.impl.JsonMaterialDao;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import java.io.IOException;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class Main {

    public static void createAndShowGUI() throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");

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

        javax.swing.SwingUtilities.invokeLater(() -> {
            try {
                createAndShowGUI();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
    }
}