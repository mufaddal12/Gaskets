package org.fakhri.views;

import org.fakhri.controllers.UnitViewController;

import javax.swing.JComboBox;

public interface DimensionUnitView {
    void setUnit(DimensionUnit unit);
    JComboBox<DimensionUnit> getUnitList();
    void setUnitViewController(UnitViewController unitViewController);
}
