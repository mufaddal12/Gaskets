package org.fakhri.views.forms;

import org.fakhri.controllers.Controller;
import org.fakhri.controllers.GasketViewController;
import org.fakhri.controllers.UnitViewController;
import org.fakhri.entity.Gasket;
import org.fakhri.views.DetailsView;
import org.fakhri.views.DimensionUnit;
import org.fakhri.views.DimensionUnitView;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JPanel;
import java.awt.Component;
import java.io.IOException;
import java.util.List;

public class GasketDetailsView implements DetailsView<Gasket>, DimensionUnitView {
    private JComboBox classList;
    private JComboBox typeList;
    private JComboBox sizeList;
    private JPanel gasketDetailsPanel;
    private JComboBox gasketUnitList;

    public GasketDetailsView() throws IOException {
        setDetailsViewController(new GasketViewController(this));
        setUnitViewController(new UnitViewController(this));
    }

    @Override
    public Gasket getSelectedItem() {
        return (Gasket) sizeList.getSelectedItem();
    }

    @Override
    public void setSelectableItems(List<Gasket> gaskets) {
        sizeList.setModel(new DefaultComboBoxModel(gaskets.toArray()));
    }

    @Override
    public void setDetailsViewController(Controller detailsViewController) {
        detailsViewController.addDataAndListeners();
    }

    @Override
    public void setUnit(DimensionUnit unit) {
        sizeList.setRenderer(new GasketRenderer(unit));
    }

    @Override
    public JComboBox getUnitList() {
        return gasketUnitList;
    }

    @Override
    public void setUnitViewController(UnitViewController unitViewController) {
        unitViewController.addDataAndListeners();
    }

    public JComboBox getClassList() {
        return classList;
    }

    public JComboBox getTypeList() {
        return typeList;
    }
}

class GasketRenderer extends DefaultListCellRenderer {

    private DimensionUnit dimensionUnit;

    public GasketRenderer(DimensionUnit dimensionUnit) {
        this.dimensionUnit = dimensionUnit;
    }

    @Override
    public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {

        Gasket gasket = (Gasket) value;
        String innerDiameterString = String.valueOf(gasket.getInnerDiameter() / this.dimensionUnit.getFactor());
        String outerDiameterString = String.valueOf(gasket.getOuterDiameter() / this.dimensionUnit.getFactor());

        value = String.format("%s - %s x %s (%s)", gasket.getSize(), outerDiameterString, innerDiameterString, dimensionUnit.getKey());

        return super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus); //To change body of generated methods, choose Tools | Templates.

    }
}