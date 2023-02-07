package org.fakhri.views.forms;


import org.fakhri.controllers.Controller;
import org.fakhri.controllers.MaterialViewController;
import org.fakhri.entity.Material;
import org.fakhri.views.DetailsView;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import java.util.List;

public class MaterialDetailsView implements DetailsView<Material> {
    private JComboBox materialNameList;
    private JComboBox materialDimList;
    private JPanel materialDetailsPanel;
    private Controller materialViewController;

    public MaterialDetailsView() {
        setController(new MaterialViewController(this));
        materialViewController.addDataAndListeners();
    }

    @Override
    public Material getSelectedItem() {
        return (Material) materialDimList.getSelectedItem();
    }

    @Override
    public void setSelectableItems(List<Material> gaskets) {
        materialDimList.setModel(new DefaultComboBoxModel(gaskets.toArray()));
    }

    @Override
    public void setController(Controller controller) {
        this.materialViewController = controller;
    }

    public JComboBox getMaterialNameList() {
        return materialNameList;
    }

}