package com.fakhri.gaskets;

import com.fakhri.gaskets.dao.impl.jdbcdaos.JdbcGasketDao;
import com.fakhri.gaskets.dao.impl.jdbcdaos.JdbcMaterialDao;
import com.fakhri.gaskets.dao.impl.jsondaos.JsonGasketDao;
import com.fakhri.gaskets.dao.impl.jsondaos.JsonMaterialDao;
import com.fakhri.gaskets.entity.GasketType;
import com.fakhri.gaskets.exceptions.ApplicationException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

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

    private static void materialDbSetup() {
        JdbcMaterialDao jdbcMaterialDao = JdbcMaterialDao.getInstance();
        if(!jdbcMaterialDao.getAllUniqueMaterials().isEmpty()) {
            return;
        }
        JsonMaterialDao jsonMaterialDao = JsonMaterialDao.getInstance();

        jsonMaterialDao.getAllUniqueMaterials()
            .forEach(materialName ->
                jsonMaterialDao.getMaterialsByName(materialName)
                    .forEach(jdbcMaterialDao::save)
            );
    }

    private static void gasketDbSetup() {
        JdbcGasketDao jdbcGasketDao = JdbcGasketDao.getInstance();
        if(!jdbcGasketDao.getAllClasses().isEmpty()) {
            return;
        }
        JsonGasketDao jsonGasketDao = JsonGasketDao.getInstance();

        for (GasketType gasketType : GasketType.values()) {
            jsonGasketDao.getAllClasses()
                .forEach(gasketClass ->
                    jsonGasketDao.getAllByClassAndType(gasketClass, gasketType)
                            .forEach(jdbcGasketDao::save)
                );
        }
    }

    public static void setup() {
        materialDbSetup();
        gasketDbSetup();
    }

    public static void main(String[] args) {
        setup();
        javax.swing.SwingUtilities.invokeLater(Main::createAndShowGUI);
    }
}