/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Faculty;

import Help.SizeSetter;
import java.awt.Frame;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

public class Faculties extends javax.swing.JDialog {

    Connection connection;
    FacultyModel model;
    SizeSetter columnWidth;
    
    public Faculties(java.awt.Frame parent, boolean modal, Connection c) throws SQLException {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        connection = c;
        model = new FacultyModel(connection);
        jTable1.setModel(model);
        jTable1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        columnWidth = new SizeSetter();
        columnWidth.resizeColumnWidth(jTable1);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonDELETE = new javax.swing.JButton();
        jButtonALTER = new javax.swing.JButton();
        jButtonADD = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jButtonDELETE.setText("DELETE");
        jButtonDELETE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDELETEActionPerformed(evt);
            }
        });

        jButtonALTER.setText("ATLER");
        jButtonALTER.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonALTERActionPerformed(evt);
            }
        });

        jButtonADD.setText("ADD");
        jButtonADD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonADDActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Title 1", "Title 2"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButtonADD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonALTER, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonDELETE, javax.swing.GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE))
                .addGap(209, 209, 209))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonADD)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonALTER)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonDELETE)
                .addContainerGap(54, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonDELETEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDELETEActionPerformed
        if (jTable1.getSelectedRow() >= 0) {
            model.delete(model.getSelectesItem(jTable1.getSelectedRow()).getId());
        }
        try {
            model.updateData();
        } catch (SQLException ex) {
            Logger.getLogger(Faculties.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((AbstractTableModel) jTable1.getModel()).fireTableDataChanged();
    }//GEN-LAST:event_jButtonDELETEActionPerformed

    private void jButtonALTERActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonALTERActionPerformed
        if (jTable1.getSelectedRow() >= 0) {
            NewFaculty np = new NewFaculty((Frame) this.getParent(), true,
                connection, model.getSelectesItem(jTable1.getSelectedRow()));
            np.setVisible(true);
            try {
                model.updateData();
            } catch (SQLException ex) {
                Logger.getLogger(Faculties.class.getName()).log(Level.SEVERE, null, ex);
            }
            ((AbstractTableModel) jTable1.getModel()).fireTableDataChanged();
        }
    }//GEN-LAST:event_jButtonALTERActionPerformed

    private void jButtonADDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonADDActionPerformed
        NewFaculty np = new NewFaculty((Frame) this.getParent(), true, connection);
        np.setVisible(true);
        try {
            model.updateData();
        } catch (SQLException ex) {
            Logger.getLogger(Faculties.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((AbstractTableModel) jTable1.getModel()).fireTableDataChanged();
    }//GEN-LAST:event_jButtonADDActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonADD;
    private javax.swing.JButton jButtonALTER;
    private javax.swing.JButton jButtonDELETE;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
