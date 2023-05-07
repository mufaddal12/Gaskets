package com.fakhri.gaskets.service;

import com.fakhri.gaskets.config.PropertiesLoader;
import com.fakhri.gaskets.entity.Material;
import com.fakhri.gaskets.entity.Gasket;

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
