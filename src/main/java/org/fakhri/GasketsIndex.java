/*
 * Created by JFormDesigner on Sun Feb 05 11:43:38 IST 2023
 */

package org.fakhri;

import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author hp
 */
public class GasketsIndex extends JPanel {
    private JPanel mainPanel;
    private JPanel labelPanel;
    private JPanel listPanel;
    private JPanel bottomOutputPanel;
    private JLabel materialDimLabel;
    private JLabel materialNameLabel;
    private JComboBox mDimList;
    private JLabel classLabel;
    private JComboBox classList;
    private JComboBox sizeList;
    private JLabel sizeLabel;
    private JComboBox typeList;
    private JLabel typeLabel;
    private JPanel rightPaddingLabel;
    private JLabel resultLabel;
    private JLabel outputLabel;
    private JPanel submitPanel;
    private JButton submitButton;

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public GasketsIndex() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - unknown

        //======== this ========
        setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.TitledBorder(new javax.swing
        .border.EmptyBorder(0,0,0,0), "JF\u006frmDes\u0069gner \u0045valua\u0074ion",javax.swing.border.TitledBorder
        .CENTER,javax.swing.border.TitledBorder.BOTTOM,new java.awt.Font("D\u0069alog",java.
        awt.Font.BOLD,12),java.awt.Color.red), getBorder()))
        ; addPropertyChangeListener(new java.beans.PropertyChangeListener(){@Override public void propertyChange(java.beans.PropertyChangeEvent e
        ){if("\u0062order".equals(e.getPropertyName()))throw new RuntimeException();}})
        ;

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup()
                .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup()
                .addGap(0, 300, Short.MAX_VALUE)
        );
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }
    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - unknown
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
