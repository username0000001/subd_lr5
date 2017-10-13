/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mark;

import Entities.Mark;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author user
 */
public class MarkModel extends AbstractTableModel {

    List<Mark> list = new ArrayList<>();

    Connection c;
    final String deleteStr = "delete from mark where mark_id=?";
    final String selectStudent="SELECT * from student where student_id=?";
final String selectView="SELECT * FROM view_teacher_discipline where id=?";
  static final String selectStr = "SELECT * FROM Mark";
  final String insertStr = "insert into Mark (mark,student_id,teacher_discipline_id,data) values (?,?,?,?)";
     final String updateStr = "update Mark set mark=?,student_id=?,teacher_discipline_id=?,data=? where mark_id=?";
      static final String selectByIdStr = "SELECT * FROM Mark WHERE mark_id =?;";

    public MarkModel(Connection c) throws SQLException {
        super();
        this.c = c;
        list = selectMark(c);
        rowsCount = list.size();
    }

    public void updateData() throws SQLException {
        list = new ArrayList<>();
        list = selectMark(c);
        rowsCount = list.size();
    }
    int rowsCount = 5;
    int colCount = 4;

    @Override
    public int getRowCount() {
        return rowsCount;
    }

    @Override
    public int getColumnCount() {
        return colCount;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        String s = "";
        switch (columnIndex) {
            case 0:
                return list.get(rowIndex).getData();
//            case 1:
//                return list.get(rowIndex). getId(); 
            case 1:
                try {
                    PreparedStatement statement = c.prepareStatement(selectStudent);
                    statement.setInt(1, list.get(rowIndex).getStudent_id());
                    ResultSet rs = statement.executeQuery();
                    
                    rs.next();
                    s = rs.getString("surname");
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(new JFrame(), ex.getMessage());
                }
                return s;

            case 2:
                try {
                    PreparedStatement statement = c.prepareStatement(selectView);
                    statement.setInt(1, list.get(rowIndex).getTeacher_Discipline_id());
                    ResultSet rs = statement.executeQuery();
                    rs.next();
                    s = rs.getString("Discipline_Teacher");
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(new JFrame(), ex.getMessage());
                }
                return s;
            case 3:
                return list.get(rowIndex).getMark();
            case 4:
                return list.get(rowIndex).getId();
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Дата";
//                case 1:
//                return "mark_id";
            case 1:
                return "Студент";
            case 2:
                return "Дисциплина (преподаватель)";
            case 3:
                return "Оценка";

        }
        return null;
    }

    public Mark getSelectesItem(int row) {//возвращает одну строку
        return list.get(row);
    }

  

    
    public static List<Mark> selectMark(Connection c) throws SQLException {//запрос вывод таблицы

        List<Mark> marks = new ArrayList<>();
         PreparedStatement statement = c.prepareStatement(selectStr);
         ResultSet rs = statement.executeQuery();
        
        while (rs.next()) {
            Mark item = new Mark(rs.getInt("mark_id"), rs.getString("mark"),
                    rs.getString("data"), rs.getInt("student_id"), rs.getInt("teacher_discipline_id"));

            marks.add(item);
        }
        return marks;
    }
   
    public static Mark selectMarkById(Connection c, int mark_id) throws SQLException {

        PreparedStatement statement = c.prepareStatement(selectByIdStr);
                statement.setInt(1, mark_id);
        ResultSet rs = statement.executeQuery();
        
        Mark mark = null;
        while (rs.next()) {
            mark = new Mark(rs.getInt("mark_id"), rs.getString("mark"),
                    rs.getString("data"), rs.getInt("student_id"), rs.getInt("teacher_discipline_id")
            );
        }
        return mark;

    }
 




    

    public void insertOrUpdate(Mark editItem, String Mark, Integer Student_id, Integer Teacher_Discipline_id,
            String Data) throws SQLException {
        try {
            if (editItem == null) {
                PreparedStatement statement = c.prepareStatement(insertStr);
                statement.setString(1, Mark);
                statement.setInt(2, Student_id);
                statement.setInt(3, Teacher_Discipline_id);
                statement.setString(4, Data);
                
                statement.execute();   
            }
            else {
                PreparedStatement statement = c.prepareStatement(updateStr);
                   statement.setString(1, Mark);
                statement.setInt(2, Student_id);
                statement.setInt(3, Teacher_Discipline_id);
                 statement.setString(4, Data);
                statement.setInt(5, editItem.getId());
  
                
                statement.execute();
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(new JFrame(), ex.getMessage());
        }
    }

    public void delete(int mark_id) {
        try {
            PreparedStatement statement = c.prepareStatement(deleteStr);
                statement.setInt(1, mark_id);
                statement.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(new JFrame(), ex.getMessage());
        }
    }

}
