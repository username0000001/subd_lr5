/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.awt.HeadlessException;
import Facultet.Facultets;
import Discipline.Disciplines;  
import Gruppa.Gruppas;
import Student.Students;
import Ocenka.Ocenkas;
import Vedomost.Vedomosts;
//import WriteOffReg.WtriteOffRegs;
import Prepodavatel.Prepodavatels;
import Prepodavatel_Discipline.Prepodavatel_Discipline_s;
//import Section.Sections;
//import Role.Roles;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Main extends javax.swing.JFrame {

    Connection connection = null;
    
    
    public Main() {
        initComponents();
        setLocationRelativeTo(null);
        NewConnection nc = new NewConnection(this, true);
        nc.setVisible(true);
        if (nc.ready) {
            connection = nc.getConnection();
        }
        try {
            if (connection != null) {
                DatabaseMetaData dmd = connection.getMetaData();
                String url = dmd.getURL();
                status.setText("Подключение к БД: " 
                        + url.substring(url.lastIndexOf("/") + 1));
            } else {
                status.setText("Нет подключений");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(new JFrame(), ex.getMessage());
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        status = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        Facultets = new javax.swing.JMenuItem();
        Disciplines = new javax.swing.JMenuItem();
        Groups = new javax.swing.JMenuItem();
        Prepodavatels = new javax.swing.JMenuItem();
        prepod_disc = new javax.swing.JMenuItem();
        students = new javax.swing.JMenuItem();
        mark = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        vedomost = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        status.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        status.setEnabled(false);

        jMenu1.setText("Подключение");

        jMenuItem1.setText("Новое подключение");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Отключиться");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem3.setText("Выход");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Сущности");

        Facultets.setText("Факультеты");
        Facultets.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FacultetsActionPerformed(evt);
            }
        });
        jMenu2.add(Facultets);

        Disciplines.setText("Дисциплины");
        Disciplines.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DisciplinesActionPerformed(evt);
            }
        });
        jMenu2.add(Disciplines);

        Groups.setText("Группы");
        Groups.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GroupsActionPerformed(evt);
            }
        });
        jMenu2.add(Groups);

        Prepodavatels.setText("Преподаватели");
        Prepodavatels.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PrepodavatelsActionPerformed(evt);
            }
        });
        jMenu2.add(Prepodavatels);

        prepod_disc.setText("Преподаватели и дисциплины");
        prepod_disc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prepod_discActionPerformed(evt);
            }
        });
        jMenu2.add(prepod_disc);

        students.setText("Студенты");
        students.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                studentsActionPerformed(evt);
            }
        });
        jMenu2.add(students);

        mark.setText("Оценки");
        mark.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                markActionPerformed(evt);
            }
        });
        jMenu2.add(mark);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Действия");

        vedomost.setText("Отчет об успеваемости");
        vedomost.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vedomostActionPerformed(evt);
            }
        });
        jMenu3.add(vedomost);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(status, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(243, 243, 243)
                .addComponent(status, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        NewConnection nc = new NewConnection(this, true);
        nc.setVisible(true);
        if (nc.ready) {
            connection = nc.getConnection();
        }
        try {
            if (connection != null) {
                DatabaseMetaData dmd = connection.getMetaData();
                String url = dmd.getURL();
                status.setText("Подключение к БД: "
                    + url.substring(url.lastIndexOf("/") + 1));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(new JFrame(), ex.getMessage());
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        try {
            connection.close();
            JOptionPane.showMessageDialog(new JFrame(), "Успех");
            connection = null;
            status.setText("Нет подкючений");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(new JFrame(), ex.getMessage());
        }
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        dispose();
        System.exit(0);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void FacultetsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FacultetsActionPerformed
        if (connection != null) {
            try {
                Facultets p = new Facultets(this, true, connection);
                p.setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(new JFrame(), "Нет подключений");
        }
    }//GEN-LAST:event_FacultetsActionPerformed

    private void DisciplinesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DisciplinesActionPerformed
        if (connection != null) {
            try {
                 Disciplines p = new  Disciplines(this, true, connection);
                p.setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(new JFrame(), "Нет подключений");
        }
    }//GEN-LAST:event_DisciplinesActionPerformed

    private void GroupsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GroupsActionPerformed
        if (connection != null) {
            try {
                Gruppas p = new Gruppas(this, true, connection);
                p.setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(new JFrame(), "Нет подключений");
        }
    }//GEN-LAST:event_GroupsActionPerformed

    private void PrepodavatelsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PrepodavatelsActionPerformed
        if (connection != null) {
            try {
                Prepodavatels r = new Prepodavatels(this, true, connection);
                r.setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(new JFrame(), "Нет подключений");
        }
    }//GEN-LAST:event_PrepodavatelsActionPerformed

    private void prepod_discActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prepod_discActionPerformed
        if (connection != null) {
            try {
                Prepodavatel_Discipline_s w = new Prepodavatel_Discipline_s(this, true, connection);
                w.setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(new JFrame(), "Нет подключений");
        }
    }//GEN-LAST:event_prepod_discActionPerformed

    private void vedomostActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vedomostActionPerformed
        if (connection != null) {
            try {
                Vedomosts w = new Vedomosts(this, true, connection);
                w.setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(new JFrame(), "Нет подключений");
        }
    }//GEN-LAST:event_vedomostActionPerformed

    private void studentsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_studentsActionPerformed
        // TODO add your handling code here:
        if (connection != null) {
            try {
                Students r = new Students(this, true, connection);
                r.setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(new JFrame(), "Нет подключений");
        }
    }//GEN-LAST:event_studentsActionPerformed

    private void markActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_markActionPerformed
        // TODO add your handling code here:
        if (connection != null) {
            try {
                Ocenkas r = new Ocenkas(this, true, connection);
                r.setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(new JFrame(), "Нет подключений");
        }
    }//GEN-LAST:event_markActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
      java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Disciplines;
    private javax.swing.JMenuItem Facultets;
    private javax.swing.JMenuItem Groups;
    private javax.swing.JMenuItem Prepodavatels;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem mark;
    private javax.swing.JMenuItem prepod_disc;
    private javax.swing.JTextField status;
    private javax.swing.JMenuItem students;
    private javax.swing.JMenuItem vedomost;
    // End of variables declaration//GEN-END:variables
}
