package org.fakhri.views.forms;


import org.fakhri.controllers.Controller;
import org.fakhri.controllers.GasketViewController;
import org.fakhri.entity.Gasket;
import org.fakhri.views.DetailsView;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import java.util.List;

public class GasketDetailsView implements DetailsView<Gasket> {
    private JComboBox classList;
    private JComboBox typeList;
    private JComboBox sizeList;
    private JPanel gasketDetailsPanel;
    private Controller gasketViewController;

    public GasketDetailsView() {
        setController(new GasketViewController(this));
        gasketViewController.addDataAndListeners();
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
    public void setController(Controller controller) {
        this.gasketViewController = controller;
    }

    public JComboBox getClassList() {
        return classList;
    }

    public JComboBox getTypeList() {
        return typeList;
    }

    public JComboBox getSizeList() {
        return sizeList;
    }
}
