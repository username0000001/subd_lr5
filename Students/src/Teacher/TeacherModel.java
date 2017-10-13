/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Teacher;
import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;
import Entities.Teacher;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
/**
 *
 * @author user
 */
public class TeacherModel extends AbstractTableModel {
    
    List<Teacher> list = new ArrayList<>();//создаем список факультетов
    
    Connection c;
    final  static String selectStr = "SELECT * FROM Teacher;";
    final String selectFaculty = "SELECT * FROM faculty where faculty_id=?;";
    final  static String selectStrById = "SELECT * FROM teacher WHERE teacher_id =?";
    final String insertStr = "insert into teacher (surname,telephone,address,faculty_id) values (?,?,?,?)";
    final String updateStr = "update teacher set surname=?,telephone=?,address=?,faculty_id=? where teacher_id=?";
    final String deleteStr = "delete from teacher where teacher_id=?"+";";
    
    public TeacherModel(Connection c) throws SQLException {
        super();
        this.c = c;
        list = selectTeacher(c);
        rowsCount = list.size();
    }
    
    public void updateData() throws SQLException {
        list = new ArrayList<>();
        list = selectTeacher(c);
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
    public Object getValueAt(int rowIndex, int columnIndex) { //заполнение таблиц
        String s = "";
        switch (columnIndex) {
            case 0:
                return list.get(rowIndex).getSurname();
            case 1:
                return list.get(rowIndex). getTelephone();
            case 2:
                return list.get(rowIndex). getAddress();
            case 3:
                try { 
                    PreparedStatement statement = c.prepareStatement(selectFaculty);
                    statement.setInt(1, list.get(rowIndex).getFaculty_id());
                    ResultSet rs = statement.executeQuery();
                    rs.next();
                    s = rs.getString("faculty_name");
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(new JFrame(), ex.getMessage());
                }
                return s;  
            case 4:
                return list.get(rowIndex). getId();      
        }
        return null;
    }
    
     @Override
        public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Фамилия";
            case 1:
                return "Телефон";
            case 2:
                return "Адрес";   
            case 3:
                return "Факультет";
            case 4:
                return "teacher_id";
        }
        return null;
    }
    
    public Teacher getSelectesItem(int row) {//возвращает одну строку
        return list.get(row);
    }
    
    public static List<Teacher> selectTeacher(Connection c) throws SQLException{//запрос вывод таблицы    
        List<Teacher> teachers = new ArrayList<>();
        PreparedStatement statement = c.prepareStatement(selectStr);
        ResultSet rs = statement.executeQuery();
        while (rs.next()) {
                Teacher item = new Teacher(rs.getInt("teacher_id"), rs.getString("surname"), 
                rs.getString("telephone"),
                rs.getString("address"),rs.getInt("faculty_id"));
                teachers.add(item);
            }
            return teachers;
    }
     public static Teacher selectTeacherById(Connection c, int teacher_id) throws SQLException{
        PreparedStatement statement = c.prepareStatement(selectStrById);
        statement.setInt(1, teacher_id);      
        ResultSet rs = statement.executeQuery();
        Teacher teacher = null;
        while (rs.next()) {
           teacher = new Teacher( rs.getInt("teacher_id"), rs.getString("surname"), 
                        rs.getString("telephone"),
                        rs.getString("address"),rs.getInt("faculty_id")
                    );
        }
        return teacher;
    }
     
    public void insertOrUpdate(Teacher editItem, String Surname,
            String Telephone, String Address,Integer Faculty_id) {
        try {
          if (editItem == null) {
                PreparedStatement statement = c.prepareStatement(insertStr);
                statement.setString(1, Surname);
                statement.setInt(2, Integer.parseInt(Telephone));
                statement.setString(3, Address);
                statement.setInt(4, Faculty_id); 
                statement.execute(); 
            } else {
               PreparedStatement statement = c.prepareStatement(updateStr);
                statement.setString(1, Surname);
                statement.setInt(2, Integer.parseInt(Telephone));
                statement.setString(3, Address);
                statement.setInt(4, Faculty_id);
                statement.setInt(5, editItem.getId());
                statement.execute();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(new JFrame(), ex.getMessage());
        }
    } 

    public void delete(int teacher_id){
        try {
                PreparedStatement statement = c.prepareStatement(deleteStr);
                statement.setInt(1, teacher_id);
                statement.execute();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(new JFrame(), ex.getMessage());
            }
    }
    
}
