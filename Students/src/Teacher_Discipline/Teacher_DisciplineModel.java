/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Teacher_Discipline;
import Entities.Teacher_Discipline;
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
public class Teacher_DisciplineModel extends AbstractTableModel{
    List<Teacher_Discipline> list = new ArrayList<>();

    Connection c;
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
                    Statement statement = c.createStatement();
                    ResultSet rs = statement.executeQuery("SELECT * from teacher "
                            + "where teacher_id=" + list.get(rowIndex).getTeacher_id() 
                            + ";");
                    rs.next();
                    s = rs.getString("surname");
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(new JFrame(), ex.getMessage());
                }
                return s;
                
            case 1:
                 try {
                    Statement statement = c.createStatement();
                    ResultSet rs = statement.executeQuery("SELECT * FROM discipline "
                            + "where discipline_id=" + list.get(rowIndex).getDiscipline_id() 
                            + ";");
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
        Statement statement = c.createStatement();
        List<Teacher_Discipline> teacher_Disciplines = new ArrayList<>();
            ResultSet rs = statement.executeQuery("SELECT * FROM Teacher_Discipline");
            while (rs.next()) {
                
//                System.out.println(rs.getInt(1)+ " " +rs.getInt(2)+ " " +rs.getInt(3));
                Teacher_Discipline item = new Teacher_Discipline(rs.getInt("teacher_discipline_id"), rs.getInt("teacher_id"),rs.getInt("discipline_id")
                        );

                teacher_Disciplines.add(item);
            }
            return teacher_Disciplines;
    }
    
   
    
    public static Teacher_Discipline selectGruppaById(Connection c, int id) throws SQLException{
    Statement statement = c.createStatement();
        ResultSet rs = statement.executeQuery("SELECT * FROM Teacher_Discipline WHERE teacher_discipline_id = "+id );
        Teacher_Discipline teacher_Discipline = null;
        while (rs.next()) {
           teacher_Discipline = new Teacher_Discipline( rs.getInt("teacher_discipline_id"), rs.getInt("teacher_id"),rs.getInt("discipline_id")
                    );
        }
        return teacher_Discipline;
    }
    public void insertOrUpdate(Teacher_Discipline editItem, Integer Teacher_id, Integer Discipline_id) {
        try {
            Statement statement = c.createStatement();
            if (editItem == null) {
                statement.executeUpdate("insert into Teacher_Discipline "
                    + "(teacher_id,discipline_id) "
                    + "values ('"
                    + Teacher_id + "','" + Discipline_id
                    + "');");
            } else {
                statement.executeUpdate("update Teacher_Discipline set teacher_id='"
                    + Teacher_id + "',discipline_id="
                    + Discipline_id +
                     " where teacher_discipline_id="
                    + editItem.getId() + ";");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(new JFrame(), ex.getMessage());
        }
    } 
    
    public void delete(int teacher_discipline_id){
        try {
                Statement statement = c.createStatement();
                statement.executeUpdate("delete from Teacher_Discipline where teacher_discipline_id="
                    + teacher_discipline_id + ";");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(new JFrame(), ex.getMessage());
            }
    }
}
