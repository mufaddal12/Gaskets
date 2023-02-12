package org.fakhri.controllers;

import org.fakhri.views.DimensionUnit;
import org.fakhri.views.DimensionUnitView;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

public class UnitViewController implements Controller {

    private DimensionUnitView dimensionUnitView;

    public UnitViewController(DimensionUnitView dimensionUnitView) {
        this.dimensionUnitView = dimensionUnitView;
    }

    @Override
    public void addDataAndListeners() {
        JComboBox unitList = dimensionUnitView.getUnitList();
        unitList.setModel(new DefaultComboBoxModel(DimensionUnit.values()));
        dimensionUnitView.setUnit(DimensionUnit.MM);

        unitList.addActionListener(e -> {
            dimensionUnitView.setUnit((DimensionUnit) dimensionUnitView.getUnitList().getSelectedItem());
        });

    }
}
