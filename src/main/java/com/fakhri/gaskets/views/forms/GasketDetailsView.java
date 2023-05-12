package com.fakhri.gaskets.views.forms;

import com.fakhri.gaskets.controllers.Controller;
import com.fakhri.gaskets.controllers.GasketViewController;
import com.fakhri.gaskets.controllers.UnitViewController;
import com.fakhri.gaskets.entity.Gasket;
import com.fakhri.gaskets.entity.GasketType;
import com.fakhri.gaskets.views.DimensionUnit;
import com.fakhri.gaskets.views.DimensionUnitView;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JPanel;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.util.List;

public class GasketDetailsView implements DimensionUnitView {
    private JComboBox<String> classList;
    private JComboBox<GasketType> typeList;
    private JComboBox<Gasket> sizeList;
    private JComboBox<DimensionUnit> gasketUnitList;
    private JPanel gasketDetailsPanel;

    public GasketDetailsView() {
        setDetailsViewController(new GasketViewController(this));
        setUnitViewController(new UnitViewController(this));
    }

//    @Override
    public Gasket getSelectedGasket() {
        return (Gasket) sizeList.getSelectedItem();
    }

//    @Override
    public void setGaskets(List<Gasket> gaskets) {
        sizeList.setModel(new DefaultComboBoxModel<>(gaskets.toArray(new Gasket[0])));
    }

    public String getGasketClass() {
        return (String) classList.getSelectedItem();
    }

    public void setGasketClasses(List<String> classes) {
        classList.setModel(new DefaultComboBoxModel<>(classes.toArray(new String[0])));
    }

    public GasketType getGasketType(){
        return (GasketType) typeList.getSelectedItem();
    }

    public void setGasketTypes(GasketType []types) {
        typeList.setModel(new DefaultComboBoxModel<>(types));
    }

    public void setActionListener(ActionListener listener) {
        classList.addActionListener(listener);
        typeList.addActionListener(listener);
    }

//    @Override
    public void setDetailsViewController(Controller detailsViewController) {
        detailsViewController.addDataAndListeners();
    }

//    @Override
    public void setUnit(DimensionUnit unit) {
        sizeList.setRenderer(new GasketRenderer(unit));
    }

//    @Override
    public JComboBox getUnitList() {
        return gasketUnitList;
    }

//    @Override
    public void setUnitViewController(UnitViewController unitViewController) {
        unitViewController.addDataAndListeners();
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