package org.fakhri.controllers;

import org.fakhri.dao.GasketDao;
import org.fakhri.entity.GasketType;
import org.fakhri.views.DimensionUnit;
import org.fakhri.views.forms.GasketDetailsView;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.io.IOException;

public class GasketViewController implements Controller {
    private GasketDetailsView gasketDetailsView;
    private GasketDao gasketDao;

    public GasketViewController(GasketDetailsView gasketDetailsView) throws IOException {
        this(gasketDetailsView, GasketDao.getInstance());
    }

    public GasketViewController(GasketDetailsView gasketDetailsView, GasketDao gasketDao) {
        this.gasketDetailsView = gasketDetailsView;
        this.gasketDao = gasketDao;
    }

    @Override
    public void addDataAndListeners() {
        JComboBox<String> classList = gasketDetailsView.getClassList();
        JComboBox<GasketType> typeList = gasketDetailsView.getTypeList();

        classList.setModel(new DefaultComboBoxModel<>( gasketDao.getAllClasses().toArray(new String[0])));
        typeList.setModel(new DefaultComboBoxModel<>(GasketType.values()));

        String gasketClass = (String) classList.getSelectedItem();
        GasketType gasketType = (GasketType) typeList.getSelectedItem();

        gasketDetailsView.setSelectableItems(gasketDao.getAllByClassTypeAndSize(gasketClass, gasketType));
        gasketDetailsView.setUnit(DimensionUnit.MM);

        ActionListener actionListener = e -> {
            String gasketClass1 = (String) gasketDetailsView.getClassList().getSelectedItem();
            GasketType gasketType1 = (GasketType) gasketDetailsView.getTypeList().getSelectedItem();

            gasketDetailsView.setSelectableItems(gasketDao.getAllByClassTypeAndSize(gasketClass1, gasketType1));
        };
        classList.addActionListener(actionListener);
        typeList.addActionListener(actionListener);
    }
}
