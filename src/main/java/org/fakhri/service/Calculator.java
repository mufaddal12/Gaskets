package org.fakhri.service;

import org.fakhri.entity.Gasket;
import org.fakhri.entity.Material;

public class Calculator {
    public static int calculate(Material material, Gasket gasket) {
        double width = material.getWidth();
        double height = material.getHeight();
        double outerDiameter = gasket.getOuterDiameter() + 25;
        int columns = (int) (width / outerDiameter);
        int rows = (int) (height / outerDiameter);
        return columns * rows;
    }
}
