/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Teacher_Discipline;
import Entities.Teacher_Discipline;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
/**
 *
 * @author user
 */
public class Teacher_DisciplineModel extends AbstractTableModel{
    List<Teacher_Discipline> list = new ArrayList<>();

    Connection c;
    final String deleteStr = "delete from Teacher_Discipline where teacher_discipline_id=?";
    final String selectTeacher="SELECT * from teacher where teacher_id=?";
    final String selectDiscipline="SELECT * FROM discipline where discipline_id=?";
    final String insertStr = "insert into Teacher_Discipline (teacher_id,discipline_id) values (?,?);";
    final String updateStr = "update Teacher_Discipline set teacher_id=?,discipline_id=? where teacher_discipline_id=?";
    static final String selectStr = "SELECT * FROM Teacher_Discipline"; 
    static final String selectByIdStr = "SELECT * FROM Teacher_Discipline WHERE teacher_discipline_id  =?;"; 
     
    public Teacher_DisciplineModel(Connection c) throws SQLException {
        super();
        this.c = c;
        list = selectTeacher_Discipline(c);
        rowsCount = list.size();
    }

    public void updateData() throws SQLException {
        list = new ArrayList<>();
        list = selectTeacher_Discipline(c);
        rowsCount = list.size();
    }
    
    int rowsCount = 5;
    int colCount = 2;
    
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
                try {
                    PreparedStatement statement = c.prepareStatement(selectTeacher);
                    statement.setInt(1, list.get(rowIndex).getTeacher_id());
                    ResultSet rs = statement.executeQuery();
                    rs.next();
                    s = rs.getString("surname");
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(new JFrame(), ex.getMessage());
                }
                return s;               
            case 1:
                 try {
                    PreparedStatement statement = c.prepareStatement(selectDiscipline);
                    statement.setInt(1, list.get(rowIndex).getDiscipline_id());
                    ResultSet rs = statement.executeQuery();
                    rs.next(); 
                    s = rs.getString("discipline_name");
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(new JFrame(), ex.getMessage());
                }
                return s;   
        }
        return null;
    }
    
    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Преподаватель";
            case 1:
                return "Дисциплина";   
        }
        return null;
    }

    public Teacher_Discipline getSelectesItem(int row) {
        return list.get(row);
    }
    
    public static List<Teacher_Discipline> selectTeacher_Discipline(Connection c) throws SQLException{
        List<Teacher_Discipline> teacher_Disciplines = new ArrayList<>();
        PreparedStatement statement = c.prepareStatement(selectStr);
        ResultSet rs = statement.executeQuery(); 
            while (rs.next()) {
            Teacher_Discipline item = new Teacher_Discipline(rs.getInt("teacher_discipline_id"), rs.getInt("teacher_id"),rs.getInt("discipline_id"));
            teacher_Disciplines.add(item);
        }
            return teacher_Disciplines;
    }

    public static Teacher_Discipline selectGruppaById(Connection c, int id) throws SQLException{
        PreparedStatement statement = c.prepareStatement(selectByIdStr);
        statement.setInt(1, id);
        ResultSet rs = statement.executeQuery();
        Teacher_Discipline teacher_Discipline = null;
        while (rs.next()) {
           teacher_Discipline = new Teacher_Discipline( rs.getInt("teacher_discipline_id"), rs.getInt("teacher_id"),rs.getInt("discipline_id")
                    );
        }
        return teacher_Discipline;
    }
      
    public void insertOrUpdate(Teacher_Discipline editItem, Integer Teacher_id, Integer Discipline_id) {
        try {
            if (editItem == null) {
                PreparedStatement statement = c.prepareStatement(insertStr);
                statement.setInt(1, Teacher_id);
                statement.setInt(2, Discipline_id);
                statement.execute();   
            } else {
                PreparedStatement statement = c.prepareStatement(updateStr);
                statement.setInt(1, Teacher_id);
                statement.setInt(2, Discipline_id);
                statement.setInt(3, editItem.getId());
                statement.execute();      
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(new JFrame(), ex.getMessage());
        }
    } 
   
    public void delete(int teacher_discipline_id){
        try {
            PreparedStatement statement = c.prepareStatement(deleteStr);
            statement.setInt(1, teacher_discipline_id);
            statement.execute();   
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(new JFrame(), ex.getMessage());
            }
    }
}
