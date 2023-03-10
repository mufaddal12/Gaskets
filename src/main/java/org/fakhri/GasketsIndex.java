package org.fakhri;

import org.fakhri.views.forms.GasketDetailsView;
import org.fakhri.views.forms.MaterialDetailsView;
import org.fakhri.controllers.SubmitController;

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
