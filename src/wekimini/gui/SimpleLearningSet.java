/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package wekimini.gui;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import wekimini.OutputManager;
import wekimini.Path;
import wekimini.Wekinator;

/**
 *
 * @author fiebrink
 */
public class SimpleLearningSet extends javax.swing.JPanel {
    private Wekinator w;
    private List<Path> paths;
    private List<SimpleLearningRow> pathPanels;
    
    /**
     * Creates new form LearningSet1
     */
    public SimpleLearningSet() {
        initComponents();
    }
    
    public final void setup(Wekinator w, Path[] ps, String[] modelNames) {
        this.w = w;
        paths = new LinkedList<>();
        pathPanels = new LinkedList<>();
        paths.addAll(Arrays.asList(ps));
        addPathsToGUI();
        w.getOutputManager().addOutputGroupComputedListener(new OutputManager.OutputValueListener() {

            @Override
            public void update(double[] vals) {
                outputValuesComputed(vals);
            }
        });
        w.getOutputManager().addOutputValueReceivedListener(new OutputManager.OutputValueListener() {

            @Override
            public void update(double[] vals) {
                outputValuesReceived(vals);
            }
        });
    }
    
    public SimpleLearningSet(Wekinator w, Path[] ps, String[] modelNames) {
        initComponents();
        setup(w, ps, modelNames);
    }
    
    //TODO: check if this setValue here is resulting in duplicate call to learning manager value change
    //Assumes that ordering of outputs is never going to change; don't have to look up anything or refer to LearningManager.
    private void outputValuesComputed(double[] vals) {
        for (int i = 0; i < vals.length; i++) {
            pathPanels.get(i).setValue(vals[i]);
        }
    }
    
    //Called when new output values received via OSC (not via GUI, not computed)
    private void outputValuesReceived(double[] vals) {
        for (int i = 0; i < vals.length; i++) {
            pathPanels.get(i).setValueOnlyForDisplay(vals[i]);
        }
    }

    private void addPathsToGUI() {
        pathsPanel.removeAll();
        double[] currentValues = w.getOutputManager().getCurrentValues();
        for (int i = 0; i < paths.size(); i++) {
            SimpleLearningRow r = new SimpleLearningRow(w, paths.get(i));
            r.setValue(currentValues[i]);
            pathPanels.add(r);
            pathsPanel.add(r);
        }
        
        pathsPanel.revalidate();
        scrollPathsPanel.validate();
        repaint();  
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        selectAllCheckbox = new javax.swing.JCheckBox();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        buttonRandomize = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        buttonDeleteAllExamples = new javax.swing.JButton();
        buttonViewExamples = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        toggleRecordAll = new javax.swing.JToggleButton();
        toggleRunAll = new javax.swing.JToggleButton();
        jButton3 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        scrollPathsPanel = new javax.swing.JScrollPane();
        pathsPanel = new javax.swing.JPanel();
        simpleLearningRow3 = new wekimini.gui.SimpleLearningRow();
        simpleLearningRow4 = new wekimini.gui.SimpleLearningRow();
        simpleLearningRow9 = new wekimini.gui.SimpleLearningRow();
        simpleLearningRow10 = new wekimini.gui.SimpleLearningRow();
        simpleLearningRow11 = new wekimini.gui.SimpleLearningRow();

        setMinimumSize(new java.awt.Dimension(580, 0));
        setPreferredSize(new java.awt.Dimension(580, 348));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        selectAllCheckbox.setAlignmentX(0.5F);
        selectAllCheckbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectAllCheckboxActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Lucida Grande", 0, 9)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("select");

        jLabel6.setFont(new java.awt.Font("Lucida Grande", 0, 9)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("all");
        jLabel6.setAlignmentX(0.5F);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(selectAllCheckbox, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel5)
                .addGap(0, 0, 0)
                .addComponent(jLabel6)
                .addGap(0, 0, 0)
                .addComponent(selectAllCheckbox))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setText("Models");
        jLabel1.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 12, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(16, 16, 16))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setText("Values");
        jLabel2.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        buttonRandomize.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        buttonRandomize.setText("randomize");
        buttonRandomize.setSize(new java.awt.Dimension(97, 30));
        buttonRandomize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRandomizeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonRandomize, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(0, 10, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(34, 34, 34))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(buttonRandomize, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setText("Examples");
        jLabel3.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        buttonDeleteAllExamples.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wekimini/icons/x2.png"))); // NOI18N
        buttonDeleteAllExamples.setPreferredSize(new java.awt.Dimension(34, 34));
        buttonDeleteAllExamples.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDeleteAllExamplesActionPerformed(evt);
            }
        });

        buttonViewExamples.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wekimini/icons/mag2.png"))); // NOI18N
        buttonViewExamples.setMaximumSize(new java.awt.Dimension(30, 34));
        buttonViewExamples.setName(""); // NOI18N
        buttonViewExamples.setPreferredSize(new java.awt.Dimension(34, 34));
        buttonViewExamples.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonViewExamplesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 14, Short.MAX_VALUE))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(buttonViewExamples, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(buttonDeleteAllExamples, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel3)
                .addGap(0, 0, 0)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(buttonDeleteAllExamples, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonViewExamples, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0))
        );

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        jLabel4.setText("Configure");
        jLabel4.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        toggleRecordAll.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wekimini/icons/record1.png"))); // NOI18N
        toggleRecordAll.setSelected(true);
        toggleRecordAll.setPreferredSize(new java.awt.Dimension(30, 34));
        toggleRecordAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toggleRecordAllActionPerformed(evt);
            }
        });

        toggleRunAll.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wekimini/icons/play.png"))); // NOI18N
        toggleRunAll.setSelected(true);
        toggleRunAll.setPreferredSize(new java.awt.Dimension(30, 34));
        toggleRunAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toggleRunAllActionPerformed(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wekimini/icons/save2.png"))); // NOI18N
        jButton3.setMaximumSize(new java.awt.Dimension(30, 34));
        jButton3.setName(""); // NOI18N
        jButton3.setPreferredSize(new java.awt.Dimension(34, 34));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(toggleRecordAll, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(toggleRunAll, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jLabel4)
                .addGap(0, 0, 0)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(toggleRecordAll, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(toggleRunAll, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jSeparator1.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));

        scrollPathsPanel.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPathsPanel.setMaximumSize(new java.awt.Dimension(578, 32767));
        scrollPathsPanel.setMinimumSize(new java.awt.Dimension(578, 23));
        scrollPathsPanel.setPreferredSize(new java.awt.Dimension(588, 374));

        pathsPanel.setBackground(new java.awt.Color(255, 255, 255));
        pathsPanel.setLayout(new javax.swing.BoxLayout(pathsPanel, javax.swing.BoxLayout.Y_AXIS));

        simpleLearningRow3.setAlignmentY(0.5F);
        simpleLearningRow3.setMaximumSize(new java.awt.Dimension(568, 74));
        simpleLearningRow3.setMinimumSize(new java.awt.Dimension(568, 74));
        simpleLearningRow3.setPreferredSize(new java.awt.Dimension(568, 74));
        pathsPanel.add(simpleLearningRow3);

        simpleLearningRow4.setAlignmentY(0.5F);
        simpleLearningRow4.setMaximumSize(new java.awt.Dimension(568, 74));
        simpleLearningRow4.setMinimumSize(new java.awt.Dimension(568, 74));
        simpleLearningRow4.setPreferredSize(new java.awt.Dimension(568, 74));
        pathsPanel.add(simpleLearningRow4);

        simpleLearningRow9.setAlignmentY(0.5F);
        simpleLearningRow9.setMaximumSize(new java.awt.Dimension(568, 74));
        simpleLearningRow9.setMinimumSize(new java.awt.Dimension(568, 74));
        simpleLearningRow9.setPreferredSize(new java.awt.Dimension(568, 74));
        pathsPanel.add(simpleLearningRow9);

        simpleLearningRow10.setAlignmentY(0.5F);
        simpleLearningRow10.setMaximumSize(new java.awt.Dimension(568, 74));
        simpleLearningRow10.setMinimumSize(new java.awt.Dimension(568, 74));
        simpleLearningRow10.setPreferredSize(new java.awt.Dimension(568, 74));
        pathsPanel.add(simpleLearningRow10);

        simpleLearningRow11.setAlignmentY(0.5F);
        simpleLearningRow11.setMaximumSize(new java.awt.Dimension(568, 74));
        simpleLearningRow11.setMinimumSize(new java.awt.Dimension(568, 74));
        simpleLearningRow11.setPreferredSize(new java.awt.Dimension(568, 74));
        pathsPanel.add(simpleLearningRow11);

        scrollPathsPanel.setViewportView(pathsPanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(scrollPathsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 580, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(scrollPathsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 299, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void buttonRandomizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRandomizeActionPerformed
        w.getOutputManager().randomizeAllOutputs();
    }//GEN-LAST:event_buttonRandomizeActionPerformed

    private void toggleRunAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toggleRunAllActionPerformed
        boolean selected = toggleRunAll.isSelected();
        for (SimpleLearningRow r : pathPanels) {
           r.setRunEnabled(selected);
       } 
    }//GEN-LAST:event_toggleRunAllActionPerformed

    private void selectAllCheckboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectAllCheckboxActionPerformed
       boolean selected = selectAllCheckbox.isSelected();
        for (SimpleLearningRow r : pathPanels) {
           r.setSelected(selected);
       }
        
    }//GEN-LAST:event_selectAllCheckboxActionPerformed

    private void buttonViewExamplesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonViewExamplesActionPerformed
        w.getMainGUI().showExamplesViewer();
    }//GEN-LAST:event_buttonViewExamplesActionPerformed

    private void buttonDeleteAllExamplesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDeleteAllExamplesActionPerformed
        w.getLearningManager().deleteAllExamples();
    }//GEN-LAST:event_buttonDeleteAllExamplesActionPerformed

    private void toggleRecordAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toggleRecordAllActionPerformed
        boolean selected = toggleRecordAll.isSelected();
        for (SimpleLearningRow r : pathPanels) {
           r.setRecordEnabled(selected);
       }
    }//GEN-LAST:event_toggleRecordAllActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        System.out.println("ERROR: Save not implemented yet!");
    }//GEN-LAST:event_jButton3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonDeleteAllExamples;
    private javax.swing.JButton buttonRandomize;
    private javax.swing.JButton buttonViewExamples;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPanel pathsPanel;
    private javax.swing.JScrollPane scrollPathsPanel;
    private javax.swing.JCheckBox selectAllCheckbox;
    private wekimini.gui.SimpleLearningRow simpleLearningRow10;
    private wekimini.gui.SimpleLearningRow simpleLearningRow11;
    private wekimini.gui.SimpleLearningRow simpleLearningRow3;
    private wekimini.gui.SimpleLearningRow simpleLearningRow4;
    private wekimini.gui.SimpleLearningRow simpleLearningRow9;
    private javax.swing.JToggleButton toggleRecordAll;
    private javax.swing.JToggleButton toggleRunAll;
    // End of variables declaration//GEN-END:variables
}
