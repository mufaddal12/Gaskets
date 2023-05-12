package com.fakhri.gaskets.views.forms;

import com.fakhri.gaskets.controllers.Controller;
import com.fakhri.gaskets.controllers.MaterialViewController;
import com.fakhri.gaskets.controllers.UnitViewController;
import com.fakhri.gaskets.entity.Material;
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

public class MaterialDetailsView extends DimensionUnitView {
    private JComboBox<String> materialNameList;
    private JComboBox<Material> materialDimList;
    private JComboBox<DimensionUnit> materialUnitList;
    private JPanel materialDetailsPanel;

    private UnitViewController unitViewController;

    public MaterialDetailsView() {
        setDetailsViewController(new MaterialViewController(this));
        this.unitViewController = new UnitViewController(this);
        this.unitViewController.addDataAndListeners();
    }
//    @Override
    public Material getSelectedMaterial() {
        return (Material) materialDimList.getSelectedItem();
    }

//    @Override
    public void setMaterials(List<Material> materials) {
        materialDimList.setModel(new DefaultComboBoxModel<> (materials.toArray(new Material[0])));
    }

    public String getSelectedMaterialName() {
        return (String) materialNameList.getSelectedItem();
    }

    public void setMaterialNames(List<String> materialNames) {
        materialNameList.setModel(new DefaultComboBoxModel<>(materialNames.toArray(new String[0])));
    }

    public void setActionListener(ActionListener listener) {
        materialNameList.addActionListener(listener);
    }

    @Override
    protected JComboBox getUpdateableList() {
        return materialDimList;
    }

    @Override
    protected DefaultListCellRenderer getCellRenderer(DimensionUnit unit) {
        return new MaterialRenderer(unit);
    }

    @Override
    protected JComboBox<DimensionUnit> getUnitList() {
        return materialUnitList;
    }

    //    @Override
    public void setDetailsViewController(Controller detailsViewController) {
        detailsViewController.addDataAndListeners();
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