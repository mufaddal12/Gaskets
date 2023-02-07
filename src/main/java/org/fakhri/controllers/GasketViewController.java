package org.fakhri.controllers;

import org.fakhri.dao.GasketDao;
import org.fakhri.entity.GasketType;
import org.fakhri.views.forms.GasketDetailsView;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GasketViewController implements Controller {
    private GasketDetailsView gasketDetailsView;
    private GasketDao gasketDao;

    public GasketViewController(GasketDetailsView gasketDetailsView) {
        this(gasketDetailsView, GasketDao.getInstance());
    }

    public GasketViewController(GasketDetailsView gasketDetailsView, GasketDao gasketDao) {
        this.gasketDetailsView = gasketDetailsView;
        this.gasketDao = gasketDao;
    }

    @Override
    public void addDataAndListeners() {
        JComboBox classList = gasketDetailsView.getClassList();
        JComboBox typeList = gasketDetailsView.getTypeList();
        JComboBox sizeList = gasketDetailsView.getSizeList();

        classList.setModel(new DefaultComboBoxModel(gasketDao.getAllClasses().toArray()));
        typeList.setModel(new DefaultComboBoxModel(GasketType.values()));

        String gasketClass = (String) gasketDetailsView.getClassList().getSelectedItem();
        GasketType gasketType = (GasketType) gasketDetailsView.getTypeList().getSelectedItem();

        sizeList.setModel(new DefaultComboBoxModel(gasketDao.getAllByClassTypeAndSize(
                gasketClass, gasketType).toArray()));

        ActionListener actionListener = e -> {
            String gasketClass1 = (String) gasketDetailsView.getClassList().getSelectedItem();
            GasketType gasketType1 = (GasketType) gasketDetailsView.getTypeList().getSelectedItem();

            gasketDetailsView.setSelectableItems(gasketDao.getAllByClassTypeAndSize(
                    gasketClass1, gasketType1));
        };
        classList.addActionListener(actionListener);
        typeList.addActionListener(actionListener);
        sizeList.addActionListener(actionListener);
    }
}
