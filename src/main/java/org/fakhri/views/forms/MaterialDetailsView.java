package org.fakhri.views.forms;


import org.fakhri.controllers.Controller;
import org.fakhri.controllers.MaterialViewController;
import org.fakhri.controllers.UnitChangeController;
import org.fakhri.entity.Material;
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

public class MaterialDetailsView implements DetailsView<Material>, DimensionUnitView {
    private JComboBox materialNameList;
    private JComboBox materialDimList;
    private JPanel materialDetailsPanel;
    private JComboBox materialUnitList;

    private Controller materialViewController;
    private Controller unitChangeController;

    public MaterialDetailsView() throws IOException {
        this.materialViewController =  new MaterialViewController(this);
        this.unitChangeController = new UnitChangeController(this);
        setControllers();
    }
    @Override
    public Material getSelectedItem() {
        return (Material) materialDimList.getSelectedItem();
    }

    @Override
    public void setSelectableItems(List<Material> gaskets) {
        materialDimList.setModel(new DefaultComboBoxModel(gaskets.toArray()));
    }

    public void setController(Controller controller) {
        this.materialViewController = controller;
    }

    @Override
    public void setUnit(DimensionUnit unit) {
        materialDimList.setRenderer(new MaterialRenderer(unit));
    }

    @Override
    public JComboBox getUnitList() { return materialUnitList; }

    @Override
    public void setControllers() {
        this.materialViewController.addDataAndListeners();
        this.unitChangeController.addDataAndListeners();
    }


    public JComboBox getMaterialNameList() {
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