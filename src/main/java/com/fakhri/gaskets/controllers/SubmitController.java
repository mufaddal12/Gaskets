package com.fakhri.gaskets.controllers;

import com.fakhri.gaskets.entity.Gasket;
import com.fakhri.gaskets.entity.Material;
import com.fakhri.gaskets.service.Calculator;
import com.fakhri.gaskets.views.forms.GasketDetailsView;
import com.fakhri.gaskets.views.forms.MaterialDetailsView;

import javax.swing.JButton;
import javax.swing.JLabel;

public class SubmitController implements Controller{

    private MaterialDetailsView materialDetailsView;
    private GasketDetailsView gasketDetailsView;

    private JLabel outputLabel;
    private JButton submitButton;

    public SubmitController(MaterialDetailsView materialDetailsView, GasketDetailsView gasketDetailsView, JButton submitButton, JLabel outputLabel) {
        this.materialDetailsView = materialDetailsView;
        this.gasketDetailsView = gasketDetailsView;
        this.outputLabel = outputLabel;
        this.submitButton = submitButton;
    }

    @Override
    public void addDataAndListeners() {
        submitButton.addActionListener(e ->{
            Material material = materialDetailsView.getSelectedMaterial();
            Gasket gasket = gasketDetailsView.getSelectedGasket();
            outputLabel.setText(String.valueOf(Calculator.calculate(material, gasket)));
        });
    }
}
