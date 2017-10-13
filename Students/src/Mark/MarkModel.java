/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mark;

import Entities.Mark;
import java.sql.Connection;
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
                    Statement statement = c.createStatement();
                    ResultSet rs = statement.executeQuery("SELECT * from student "
                            + "where student_id=" + list.get(rowIndex).getStudent_id()
                            + ";");
                    rs.next();
                    s = rs.getString("surname");
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(new JFrame(), ex.getMessage());
                }
                return s;

            case 2:
                try {
                    Statement statement = c.createStatement();
                    ResultSet rs = statement.executeQuery("SELECT * FROM view_teacher_discipline "
                            + "where id=" + list.get(rowIndex).getTeacher_Discipline_id()
                            + ";");
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
        Statement statement = c.createStatement();
        List<Mark> marks = new ArrayList<>();
        ResultSet rs = statement.executeQuery("SELECT * FROM Mark");
        while (rs.next()) {
            Mark item = new Mark(rs.getInt("mark_id"), rs.getString("mark"),
                    rs.getString("data"), rs.getInt("student_id"), rs.getInt("teacher_discipline_id"));

            marks.add(item);
        }
        return marks;
    }

    public static Mark selectMarkById(Connection c, int mark_id) throws SQLException {
        Statement statement = c.createStatement();
        ResultSet rs = statement.executeQuery("SELECT * FROM Mark WHERE mark_id = " + mark_id);
        Mark mark = null;
        while (rs.next()) {
            mark = new Mark(rs.getInt("mark_id"), rs.getString("mark"),
                    rs.getString("data"), rs.getInt("student_id"), rs.getInt("teacher_discipline_id")
            );
        }
        return mark;

    }
 
public String constructStr(Mark editItem, String  Mark, int Student_id ,int Teacher_Discipline_id ,String Data) {
      String insertStr;
    if (editItem == null){
          insertStr = "insert into Mark "
            + "(mark,student_id,teacher_discipline_id,data) "
            + "values ('" + Mark + "','" + Student_id + "','" + Teacher_Discipline_id + "','" + Data
                        + "');";
    }
    else {
        insertStr="update Mark set mark='"
                        + Mark + "',student_id="
                        + Student_id + ",teacher_discipline_id='" + Teacher_Discipline_id + "',data='" + Data + " 'where mark_id="
                        + editItem.getId() + ";";
        
    }   
    return insertStr;
}

public String deleteStr(int Mark_id) {
      String deleteStr;
    
          deleteStr = "delete from mark where mark_id="
                    + Mark_id + ";";
          return deleteStr;
    }
    

    public void insertOrUpdate(Mark editItem, String Mark, Integer Student_id, Integer Teacher_Discipline_id,
            String Data) throws SQLException {
        try {
            Statement statement = c.createStatement();
            statement.executeUpdate(constructStr(editItem, Mark, Student_id, Teacher_Discipline_id, Data));
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(new JFrame(), ex.getMessage());
        }
    }

    public void delete(int mark_id) {
        try {
            Statement statement = c.createStatement();
            statement.executeUpdate(deleteStr(mark_id));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(new JFrame(), ex.getMessage());
        }
    }

}
