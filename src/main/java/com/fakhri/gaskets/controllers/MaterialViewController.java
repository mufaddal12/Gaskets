package com.fakhri.gaskets.controllers;

import com.fakhri.gaskets.dao.MaterialDao;
import com.fakhri.gaskets.views.DimensionUnit;
import com.fakhri.gaskets.views.forms.MaterialDetailsView;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import java.io.IOException;
import java.util.List;

public class MaterialViewController implements Controller {

    private MaterialDetailsView materialDetailsView;
    private MaterialDao materialDao;

    public MaterialViewController(MaterialDetailsView materialView) throws IOException {
        this(materialView, MaterialDao.getInstance());
    }

    public MaterialViewController(MaterialDetailsView materialDetailsView, MaterialDao materialDao) {
        this.materialDetailsView = materialDetailsView;
        this.materialDao = materialDao;
    }

    @Override
    public void addDataAndListeners() {
        JComboBox<String> materialNameList = materialDetailsView.getMaterialNameList();
        List<String> uniqueMaterials = materialDao.getAllUniqueMaterials();
        materialNameList.setModel(new DefaultComboBoxModel<>(uniqueMaterials.toArray(new String[0])));

        materialDetailsView.setSelectableItems(materialDao.getMaterialsByName(uniqueMaterials.get(0)));
        materialDetailsView.setUnit(DimensionUnit.MM);

        materialNameList.addActionListener(e -> {
            String selectedMaterial = (String) materialDetailsView.getMaterialNameList().getSelectedItem();
            materialDetailsView.setSelectableItems(materialDao.getMaterialsByName(selectedMaterial));
        });
    }

}
