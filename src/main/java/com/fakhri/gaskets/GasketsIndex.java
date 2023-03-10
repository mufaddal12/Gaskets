package com.fakhri.gaskets;

import com.fakhri.gaskets.views.forms.GasketDetailsView;
import com.fakhri.gaskets.views.forms.MaterialDetailsView;
import com.fakhri.gaskets.controllers.SubmitController;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * @author hp
 */
public class GasketsIndex {
    private JPanel mainPanel;
    private JLabel outputLabel;
    private JButton submitButton;
    private MaterialDetailsView materialDetailsView;
    private GasketDetailsView gasketDetailsView;
    private SubmitController submitController;
    public JPanel getMainPanel() {
        return mainPanel;
    }

    public GasketsIndex() {
        submitController = new SubmitController(materialDetailsView, gasketDetailsView, submitButton, outputLabel);
        submitController.addDataAndListeners();
    }

}
