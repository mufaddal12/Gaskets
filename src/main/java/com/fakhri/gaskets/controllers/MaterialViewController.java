package com.fakhri.gaskets.controllers;

import com.fakhri.gaskets.dao.MaterialDao;
import com.fakhri.gaskets.views.DimensionUnit;
import com.fakhri.gaskets.views.forms.MaterialDetailsView;

import java.awt.event.ActionListener;
import java.util.List;

public class MaterialViewController implements Controller {

    private MaterialDetailsView materialDetailsView;
    private MaterialDao materialDao;

    public MaterialViewController(MaterialDetailsView materialView) {
        this(materialView, MaterialDao.getInstance());
    }

    public MaterialViewController(MaterialDetailsView materialDetailsView, MaterialDao materialDao) {
        this.materialDetailsView = materialDetailsView;
        this.materialDao = materialDao;
    }

    @Override
    public void addDataAndListeners() {
        List<String> uniqueMaterials = materialDao.getAllUniqueMaterials();

        materialDetailsView.setMaterialNames(uniqueMaterials);
        materialDetailsView.setMaterials(materialDao.getMaterialsByName(uniqueMaterials.get(0)));
        materialDetailsView.setUnit(DimensionUnit.MM);

        materialDetailsView.setActionListener(getActionListener());
    }

    private ActionListener getActionListener() {
        return e -> {
            String selectedMaterial = materialDetailsView.getSelectedMaterialName();
            materialDetailsView.setMaterials(materialDao.getMaterialsByName(selectedMaterial));
        };
    }

}
