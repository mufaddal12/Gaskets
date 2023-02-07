package org.fakhri.controllers;

import org.fakhri.entity.Gasket;
import org.fakhri.entity.Material;
import org.fakhri.service.Calculator;
import org.fakhri.views.forms.GasketDetailsView;
import org.fakhri.views.forms.MaterialDetailsView;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

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
            Material material = materialDetailsView.getSelectedItem();
            Gasket gasket = gasketDetailsView.getSelectedItem();
            System.out.println(material);
            System.out.println(gasket);
            outputLabel.setText(String.valueOf(Calculator.calculate(material, gasket)));

        });
    }
}
