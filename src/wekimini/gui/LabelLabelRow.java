/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wekimini.gui;

/**
 *
 * @author rebecca
 */
public class LabelLabelRow extends javax.swing.JPanel {

    public LabelLabelRow() {
        initComponents();
    }
    /**
     * Creates new form GUIInputRow
     */
    public LabelLabelRow(String name, String name2) {
        initComponents();
        labelName.setText(name);
        labelName2.setText(name2);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelName = new javax.swing.JLabel();
        labelName2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(32767, 25));
        setLayout(new java.awt.GridLayout(1, 0));

        labelName.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        labelName.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelName.setText("1. HID Inputs");
        add(labelName);

        labelName2.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        labelName2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelName2.setText("1. HID Inputs");
        add(labelName2);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel labelName;
    private javax.swing.JLabel labelName2;
    // End of variables declaration//GEN-END:variables
}
