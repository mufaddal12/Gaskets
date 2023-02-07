package org.fakhri.controllers;

import org.fakhri.dao.MaterialDao;
import org.fakhri.views.forms.MaterialDetailsView;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import java.awt.event.ActionEvent;
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
        JComboBox materialNameList = materialDetailsView.getMaterialNameList();
        List<String> uniqueMaterials = materialDao.getAllUniqueMaterials();
        materialNameList.setModel(new DefaultComboBoxModel(uniqueMaterials.toArray()));
        materialDetailsView.setSelectableItems(materialDao.getMaterialsByKey(uniqueMaterials.get(0)));

        materialNameList.addActionListener(e -> {
            String selectedMaterial = (String) materialDetailsView.getMaterialNameList().getSelectedItem();
            materialDetailsView.setSelectableItems(materialDao.getMaterialsByKey(selectedMaterial));
        });
    }

}
