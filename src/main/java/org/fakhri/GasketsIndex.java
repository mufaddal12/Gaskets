/*
 * Created by JFormDesigner on Sun Feb 05 11:43:38 IST 2023
 */

package org.fakhri;

import org.fakhri.controllers.SubmitController;
import org.fakhri.views.forms.GasketDetailsView;
import org.fakhri.views.forms.MaterialDetailsView;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * @author hp
 */
public class GasketsIndex {
    private JPanel mainPanel;
    private JPanel bottomOutputPanel;
    private JLabel resultLabel;
    private JLabel outputLabel;
    private JPanel submitPanel;
    private JButton submitButton;
    private JPanel detailsListPanel;
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
