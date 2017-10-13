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
import java.sql.SQLException;
import java.sql.Statement;
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
//            case 1:
//                return list.get(rowIndex). getName();
//            case 2:
//                return list.get(rowIndex). getPatronymic();
            case 1:
                return list.get(rowIndex). getTelephone();
            case 2:
                return list.get(rowIndex). getAddress();
            case 3:
                try {
                    Statement statement = c.createStatement();
                    ResultSet rs = statement.executeQuery("SELECT * FROM faculty "
                            + "where faculty_id=" + list.get(rowIndex).getFaculty_id() 
                            + ";");
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
    public String getColumnName(int column) {//оглавление колонок
        switch (column) {
            case 0:
                return "Фамилия";
//            case 1:
//                return "Имя";
//            case 2:
//                return "Отчество";
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
        Statement statement = c.createStatement();
        List<Teacher> teachers = new ArrayList<>();
            ResultSet rs = statement.executeQuery("SELECT * FROM Teacher");
            while (rs.next()) {
                Teacher item = new Teacher(rs.getInt("teacher_id"), rs.getString("surname"), 
                        rs.getString("telephone"),
                        rs.getString("address"),rs.getInt("faculty_id"));

                teachers.add(item);
            }
            return teachers;
    }
     public static Teacher selectTeacherById(Connection c, int teacher_id) throws SQLException{
    Statement statement = c.createStatement();
        ResultSet rs = statement.executeQuery("SELECT * FROM teacher WHERE teacher_id = "+teacher_id );
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
            Statement statement = c.createStatement();
            if (editItem == null) {
                statement.executeUpdate("insert into teacher "
                    + "(surname,telephone,address,faculty_id) "
                    + "values ('"
                    + Surname + "','" +Telephone+
                        "','"+Address+"','"+Faculty_id
                    + "');");
            } else {
                statement.executeUpdate("update teacher set surname='"
                    + Surname +  "',telephone='"+Telephone+
                     "',address='"+Address+ "',faculty_id="+Faculty_id+
                     " where teacher_id="
                    + editItem.getId() + ";");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(new JFrame(), ex.getMessage());
        }
    } 
    
    public void delete(int teacher_id){
        try {
                Statement statement = c.createStatement();
                statement.executeUpdate("delete from teacher where teacher_id="
                    + teacher_id + ";");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(new JFrame(), ex.getMessage());
            }
    }
    
}
