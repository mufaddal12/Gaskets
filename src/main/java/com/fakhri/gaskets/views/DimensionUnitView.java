package com.fakhri.gaskets.views;

import com.fakhri.gaskets.controllers.UnitViewController;

import javax.swing.JComboBox;

public interface DimensionUnitView {
    void setUnit(DimensionUnit unit);
    JComboBox<DimensionUnit> getUnitList();
    void setUnitViewController(UnitViewController unitViewController);
}
