package com.fakhri.gaskets.controllers;

import com.fakhri.gaskets.views.DimensionUnit;
import com.fakhri.gaskets.views.DimensionUnitView;

public class UnitViewController implements Controller {

    private DimensionUnitView dimensionUnitView;

    public UnitViewController(DimensionUnitView dimensionUnitView) {
        this.dimensionUnitView = dimensionUnitView;
    }

    @Override
    public void addDataAndListeners() {
        dimensionUnitView.setUnits(DimensionUnit.values());
        dimensionUnitView.updateUnit();

        dimensionUnitView.setUnitActionListener(e -> dimensionUnitView.updateUnit());

    }
}
