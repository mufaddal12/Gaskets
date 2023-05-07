package com.fakhri.gaskets.views.forms;


import com.fakhri.gaskets.controllers.Controller;
import com.fakhri.gaskets.controllers.MaterialViewController;
import com.fakhri.gaskets.controllers.UnitViewController;
import com.fakhri.gaskets.entity.Material;
import com.fakhri.gaskets.views.DetailsView;
import com.fakhri.gaskets.views.DimensionUnit;
import com.fakhri.gaskets.views.DimensionUnitView;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JPanel;
import java.awt.Component;
import java.util.List;

public class MaterialDetailsView implements DetailsView<Material>, DimensionUnitView {
    private JComboBox<String> materialNameList;
    private JComboBox<Material> materialDimList;
    private JComboBox<DimensionUnit> materialUnitList;
    private JPanel materialDetailsPanel;

    public MaterialDetailsView() {
        setDetailsViewController(new MaterialViewController(this));
        setUnitViewController(new UnitViewController(this));
    }
    @Override
    public Material getSelectedItem() {
        return (Material) materialDimList.getSelectedItem();
    }

    @Override
    public void setSelectableItems(List<Material> materials) {
        materialDimList.setModel(new DefaultComboBoxModel<> (materials.toArray(new Material[0])));
    }

    @Override
    public void setDetailsViewController(Controller detailsViewController) {
        detailsViewController.addDataAndListeners();
    }

    @Override
    public void setUnit(DimensionUnit unit) {
        materialDimList.setRenderer(new MaterialRenderer(unit));
    }

    @Override
    public JComboBox getUnitList() { return materialUnitList; }

    @Override
    public void setUnitViewController(UnitViewController unitViewController) {
        unitViewController.addDataAndListeners();
    }

    public JComboBox<String> getMaterialNameList() {
        return materialNameList;
    }
}

class MaterialRenderer extends DefaultListCellRenderer {

    private DimensionUnit dimensionUnit;

    public MaterialRenderer(DimensionUnit dimensionUnit) {
        this.dimensionUnit = dimensionUnit;
    }

    @Override
    public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        Material material = (Material) value;
        String widthString = String.valueOf(material.getWidth() / this.dimensionUnit.getFactor());
        String heightString = String.valueOf(material.getHeight() / this.dimensionUnit.getFactor());

        value = String.format("%s x %s (%s)", widthString, heightString, dimensionUnit.getKey());

        return super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus); //To change body of generated methods, choose Tools | Templates.

    }
}