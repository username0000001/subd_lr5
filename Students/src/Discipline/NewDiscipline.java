/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Discipline;

import Entities.Discipline;
import Help.JTextFieldLimit;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.text.AbstractDocument;

public class NewDiscipline extends javax.swing.JDialog {

    Connection c;
    Discipline editItem;

    public NewDiscipline(java.awt.Frame parent, boolean modal, Connection c) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        this.c = c;

        ((AbstractDocument) name.getDocument()).setDocumentFilter(new JTextFieldLimit(30));
        ((AbstractDocument) number_of_hours.getDocument()).setDocumentFilter(new JTextFieldLimit(30));
       
    }

    public NewDiscipline(java.awt.Frame parent, boolean modal, Connection c, Discipline u) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        this.c = c;
        editItem = u;

        ((AbstractDocument) name.getDocument()).setDocumentFilter(new JTextFieldLimit(30));
        ((AbstractDocument) number_of_hours.getDocument()).setDocumentFilter(new JTextFieldLimit(30));
     
        fillFields();
    }

    private void fillFields() {
        name.setText(editItem.getName());
        number_of_hours.setText(editItem.getNumber_of_hours().toString());
       
    }

    public boolean check() {
        if ("".equals(name.getText())) {
            JOptionPane.showMessageDialog(new JFrame(), "name cannot be empty");
            return false;
        }
        if ("".equals(number_of_hours.getText())) {
            JOptionPane.showMessageDialog(new JFrame(), "Number_of_hours has wrong format");
            return false;
        }
        
        
        return true;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        number_of_hours = new javax.swing.JTextField();
        jButtonOk = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        name = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        number_of_hours.setToolTipText("");
        number_of_hours.setName(""); // NOI18N

        jButtonOk.setText("OK");
        jButtonOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOkActionPerformed(evt);
            }
        });

        jLabel1.setText("Название дисциплины");

        name.setToolTipText("");
        name.setName(""); // NOI18N

        jLabel2.setText("Количестов часов");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(name, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
                            .addComponent(number_of_hours)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(143, 143, 143)
                        .addComponent(jButtonOk)))
                .addContainerGap(65, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(number_of_hours, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButtonOk)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOkActionPerformed

        if (!check()) {
            return;
        }
        try {
            DisciplineModel wm = new DisciplineModel(c);
            wm.insertOrUpdate(editItem, name.getText(), Integer.parseInt(number_of_hours.getText()));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(new JFrame(), ex.getMessage());
            return;
        }
        dispose();
    }//GEN-LAST:event_jButtonOkActionPerformed

    /**
     * @param args the command line arguments
     */
   
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonOk;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField name;
    private javax.swing.JTextField number_of_hours;
    // End of variables declaration//GEN-END:variables
}
