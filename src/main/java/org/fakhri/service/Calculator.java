package org.fakhri.service;

import org.fakhri.config.PropertiesLoader;
import org.fakhri.entity.Gasket;
import org.fakhri.entity.Material;

import java.util.Properties;

public class Calculator {
    private Calculator() {}
    public static int calculate(Material material, Gasket gasket) {
        Properties properties = PropertiesLoader.loadProperties();
        double offset = Double.parseDouble(properties.getProperty("calculator.offset"));

        double columns = material.getWidth() / gasket.getOuterDiameter();
        double rows = material.getHeight() / gasket.getOuterDiameter();
        int floorColumns = (int) columns;
        int floorRows = (int) rows;

        if((columns - floorColumns) <= offset){
            floorColumns--;
        }
        if((rows - floorRows) <= offset) {
            floorRows--;
        }
        return floorColumns * floorRows;
    }
}
