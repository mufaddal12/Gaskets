package com.fakhri.gaskets.views;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;

public abstract class DimensionUnitView {
    public void updateUnit() {
           getUpdateableList().setRenderer(getCellRenderer(getSelectedUnit()));
    }
    public void setUnits(DimensionUnit []units) {
        getUnitList().setModel(new DefaultComboBoxModel<>(units));
    }
    public DimensionUnit getSelectedUnit() {
        return (DimensionUnit) getUnitList().getSelectedItem();
    }
    public void setUnitActionListener(ActionListener listener) {
        getUnitList().addActionListener(listener);
    }
    protected abstract JComboBox getUpdateableList();
    protected abstract DefaultListCellRenderer getCellRenderer(DimensionUnit unit);
    protected abstract JComboBox<DimensionUnit> getUnitList();
}
