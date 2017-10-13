/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.awt.HeadlessException;
import Faculty.Faculties;
import Discipline.Disciplines;  
import Group.Groups;
import Student.Students;
import Mark.Marks;
import Report.Reports;
//import WriteOffReg.WtriteOffRegs;
import Teacher.Teachers;
import Teacher_Discipline.Teacher_Disciplines;
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
        Faculties = new javax.swing.JMenuItem();
        Disciplines = new javax.swing.JMenuItem();
        Groups = new javax.swing.JMenuItem();
        Teachers = new javax.swing.JMenuItem();
        Teachers_Disciplines = new javax.swing.JMenuItem();
        students = new javax.swing.JMenuItem();
        marks = new javax.swing.JMenuItem();
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

        Faculties.setText("Факультеты");
        Faculties.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FacultiesActionPerformed(evt);
            }
        });
        jMenu2.add(Faculties);

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

        Teachers.setText("Преподаватели");
        Teachers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TeachersActionPerformed(evt);
            }
        });
        jMenu2.add(Teachers);

        Teachers_Disciplines.setText("Преподаватели и дисциплины");
        Teachers_Disciplines.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Teachers_DisciplinesActionPerformed(evt);
            }
        });
        jMenu2.add(Teachers_Disciplines);

        students.setText("Студенты");
        students.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                studentsActionPerformed(evt);
            }
        });
        jMenu2.add(students);

        marks.setText("Оценки");
        marks.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                marksActionPerformed(evt);
            }
        });
        jMenu2.add(marks);

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

    private void FacultiesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FacultiesActionPerformed
        if (connection != null) {
            try {
                Faculties p = new Faculties(this, true, connection);
                p.setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(new JFrame(), "Нет подключений");
        }
    }//GEN-LAST:event_FacultiesActionPerformed

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
                Groups p = new Groups(this, true, connection);
                p.setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(new JFrame(), "Нет подключений");
        }
    }//GEN-LAST:event_GroupsActionPerformed

    private void TeachersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TeachersActionPerformed
        if (connection != null) {
            try {
                Teachers r = new Teachers(this, true, connection);
                r.setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(new JFrame(), "Нет подключений");
        }
    }//GEN-LAST:event_TeachersActionPerformed

    private void Teachers_DisciplinesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Teachers_DisciplinesActionPerformed
        if (connection != null) {
            try {
                Teacher_Disciplines w = new Teacher_Disciplines(this, true, connection);
                w.setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(new JFrame(), "Нет подключений");
        }
    }//GEN-LAST:event_Teachers_DisciplinesActionPerformed

    private void vedomostActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vedomostActionPerformed
        if (connection != null) {
            try {
                Reports w = new Reports(this, true, connection);
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

    private void marksActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_marksActionPerformed
        // TODO add your handling code here:
        if (connection != null) {
            try {
                Marks r = new Marks(this, true, connection);
                r.setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(new JFrame(), "Нет подключений");
        }
    }//GEN-LAST:event_marksActionPerformed

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
    private javax.swing.JMenuItem Faculties;
    private javax.swing.JMenuItem Groups;
    private javax.swing.JMenuItem Teachers;
    private javax.swing.JMenuItem Teachers_Disciplines;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem marks;
    private javax.swing.JTextField status;
    private javax.swing.JMenuItem students;
    private javax.swing.JMenuItem vedomost;
    // End of variables declaration//GEN-END:variables
}
