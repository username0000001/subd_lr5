/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Prepodavatel;

import Entities.Prepodavatel;
import Entities.Facultet;
import Entities.Gruppa;
import Facultet.FacultetModel;
import Help.JTextFieldLimit;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.text.AbstractDocument;
/**
 *
 * @author user
 */
public class NewPrepodavatel extends javax.swing.JDialog {
    Connection c;
    Prepodavatel editItem;
    List<Facultet> list;
    
    /**
     * Creates new form NewPrepodavatel
     */
    public NewPrepodavatel(java.awt.Frame parent, boolean modal, Connection c) throws SQLException {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        this.c = c;

        ((AbstractDocument) telephone.getDocument()).setDocumentFilter(new JTextFieldLimit(30));//название полей в форме
//        ((AbstractDocument) name.getDocument()).setDocumentFilter(new JTextFieldLimit(30));
//        ((AbstractDocument) patronymic.getDocument()).setDocumentFilter(new JTextFieldLimit(30));
        ((AbstractDocument) adress.getDocument()).setDocumentFilter(new JTextFieldLimit(30));
        ((AbstractDocument) surname.getDocument()).setDocumentFilter(new JTextFieldLimit(30));
        
        list = new ArrayList<>();
        fid.setModel(new DefaultComboBoxModel(FacultetModel.selectFacultet(c).toArray()));
       
    }
 public NewPrepodavatel(java.awt.Frame parent, boolean modal, Connection c, Prepodavatel u) throws SQLException {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        this.c = c;
        editItem = u;

        ((AbstractDocument) telephone.getDocument()).setDocumentFilter(new JTextFieldLimit(30));//название полей в форме
//        ((AbstractDocument) name.getDocument()).setDocumentFilter(new JTextFieldLimit(30));
//        ((AbstractDocument) patronymic.getDocument()).setDocumentFilter(new JTextFieldLimit(30));
        ((AbstractDocument) adress.getDocument()).setDocumentFilter(new JTextFieldLimit(30));
        ((AbstractDocument) surname.getDocument()).setDocumentFilter(new JTextFieldLimit(30));
        list = new ArrayList<>();
        fid.setModel(new DefaultComboBoxModel(FacultetModel.selectFacultet(c).toArray()));
     
        fillFields();
    }
 
 private void fillFields() {//заполнение в форме нзавание полей в форме
        telephone.setText(editItem.getTelephone());
//        name.setText(editItem.getName());
//        patronymic.setText(editItem.getPatronymic());
        adress.setText(editItem.getAdress());
        surname.setText(editItem.getSurname());
         for (Facultet s : list) {
            if (s.getId() == editItem.getFacultetId()) {
                fid.setSelectedItem((s));
            }
        }
       
    }
 
 public boolean check() {
        if ("".equals(telephone.getText())) {
            JOptionPane.showMessageDialog(new JFrame(), "name cannot be empty");
            return false;
        }
        
        
        
        return true;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        telephone = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        fid = new javax.swing.JComboBox<>();
        jButtonOk1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        surname = new javax.swing.JTextField();
        adress = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        telephone.setToolTipText("");
        telephone.setName(""); // NOI18N

        jLabel6.setText("Факультет");

        fid.setToolTipText("");
        fid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fidActionPerformed(evt);
            }
        });

        jButtonOk1.setText("OK");
        jButtonOk1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOk1ActionPerformed(evt);
            }
        });

        jLabel3.setText("Фамилия");

        jLabel7.setText("Телефон");

        jLabel8.setText("Адрес");

        surname.setToolTipText("");
        surname.setName(""); // NOI18N

        adress.setToolTipText("");
        adress.setName(""); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonOk1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(surname)
                        .addComponent(adress)
                        .addComponent(telephone)
                        .addComponent(fid, 0, 191, Short.MAX_VALUE)))
                .addContainerGap(43, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(surname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(adress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)))
                    .addComponent(telephone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addComponent(jButtonOk1)
                .addContainerGap(38, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonOk1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOk1ActionPerformed

        if (!check()) {
            return;
        }
        try{
            PrepodavatelModel wm = new PrepodavatelModel(c);
            wm.insertOrUpdate(editItem, surname.getText(),telephone.getText(),
                   adress.getText(),
                ((Facultet) fid.getSelectedItem()).getId());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(new JFrame(), ex.getMessage());
            return;
        }
        dispose();
    }//GEN-LAST:event_jButtonOk1ActionPerformed

    private void fidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fidActionPerformed

    /**
     * @param args the command line arguments
     */
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField adress;
    private javax.swing.JComboBox<String> fid;
    private javax.swing.JButton jButtonOk1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JTextField surname;
    private javax.swing.JTextField telephone;
    // End of variables declaration//GEN-END:variables
}
