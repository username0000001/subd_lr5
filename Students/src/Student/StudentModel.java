/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Student;
import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;
import Entities.Student;
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
public class StudentModel extends AbstractTableModel {
    
    List<Student> list = new ArrayList<>();//создаем список факультетов
    
    Connection c;
    
    public StudentModel(Connection c) throws SQLException {
        super();
        this.c = c;
        list = selectStudent(c);
        rowsCount = list.size();
    }
    
       public void updateData() throws SQLException {
        list = new ArrayList<>();
        list = selectStudent(c);
        rowsCount = list.size();
    }
       int rowsCount = 5;
    int colCount = 5;
    
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
        String s="";
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
                return list.get(rowIndex). getTelephone_of_parents(); 
            
            case 4: try {
                    Statement statement = c.createStatement();
                    ResultSet rs = statement.executeQuery("SELECT * from gro_up "
                            + "where group_id=" + list.get(rowIndex).getGroup_id() 
                            + ";");
                    rs.next();
                    s = rs.getString("group_name");
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(new JFrame(), ex.getMessage());
                }
                return s;
            case 5:
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
                return "Телефон родителей";
            case 4:
                return "Группа";
            case 5:
                return "student_id";
        }
        return null;
    }
    
    public Student getSelectesItem(int row) {//возвращает одну строку
        return list.get(row);
    }
    
    public static List<Student> selectStudent(Connection c) throws SQLException{//запрос вывод таблицы
        Statement statement = c.createStatement();
        List<Student> students = new ArrayList<>();
            ResultSet rs = statement.executeQuery("SELECT * FROM Student");
            while (rs.next()) {
                Student item = new Student(rs.getInt("student_id"), rs.getString("surname"), 
                        rs.getString("telephon"),
                        rs.getString("address"),rs.getString("phonenumber_of_parents"),rs.getInt("group_id"));

                students.add(item);
            }
            return students;
    }
     public static Student selectStudentById(Connection c, int student_id) throws SQLException{
    Statement statement = c.createStatement();
        ResultSet rs = statement.executeQuery("SELECT * FROM Student WHERE student_id = "+student_id );
        Student student = null;
        while (rs.next()) {
           student = new Student( rs.getInt("student_id"), rs.getString("surname"), 
                        rs.getString("telephon"),
                        rs.getString("address"),rs.getString("phonenumber_of_parents"),rs.getInt("group_id")
                    );
        }
        return student;
    }
    public void insertOrUpdate(Student editItem, String Surname,
            String Telephone, String Address, String Telephone_of_parents, Integer Group_id) {
        try {
            Statement statement = c.createStatement();
            if (editItem == null) {
                statement.executeUpdate("insert into Student "
                    + "(surname,telephon,address,phonenumber_of_parents,group_id) "
                    + "values ('"
                    + Surname + "','" +Telephone+
                        "','"+Address+"','"+Telephone_of_parents+"','"+Group_id
                    + "');");
            } else {
                statement.executeUpdate("update student set surname='"
                    + Surname +  "',telephon='"+Telephone+
                     "',address='"+Address+ "',phonenumber_of_parents='"+Telephone_of_parents+"',group_id="+Group_id+
                     " where student_id="
                    + editItem.getId() + ";");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(new JFrame(), ex.getMessage());
        }
    } 
    
    public void delete(int student_id){
        try {
                Statement statement = c.createStatement();
                statement.executeUpdate("delete from student where student_id="
                    + student_id + ";");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(new JFrame(), ex.getMessage());
            }
    }
    
}
