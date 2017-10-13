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
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
    final String deleteStr = "delete from student where student_id=?"+";";
    static final String selectStr = "SELECT * FROM Student";
    static final String selectByIdStr = "SELECT * FROM Student WHERE student_id =?;";
    final String insertStr = "insert into Student (surname,telephon,address,phonenumber_of_parents,group_id) "
    + "values (?,?,?,?,?)";
    final String updateStr = "update student set surname=?,telephon=?,address=?,"
    + "phonenumber_of_parents=?,group_id=? where student_id=?;";
    final String selectGroup="SELECT * from gro_up where group_id=?";
    
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
            case 1:
                return list.get(rowIndex). getTelephone();
            case 2:
                return list.get(rowIndex). getAddress();
            case 3:
                return list.get(rowIndex). getTelephone_of_parents(); 
            case 4: try {
                    PreparedStatement statement = c.prepareStatement(selectGroup);
                    statement.setInt(1, list.get(rowIndex).getGroup_id());
                    ResultSet rs = statement.executeQuery();
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
    
    public Student getSelectesItem(int row) {
        return list.get(row);
    }
    
    public static List<Student> selectStudent(Connection c) throws SQLException{
        List<Student> students = new ArrayList<>();
        PreparedStatement statement = c.prepareStatement(selectStr);
        ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Student item = new Student(rs.getInt("student_id"), rs.getString("surname"), 
                rs.getString("telephon"),
                rs.getString("address"),rs.getString("phonenumber_of_parents"),rs.getInt("group_id"));
                students.add(item);
            }
            return students;
    }
    
     public static Student selectStudentById(Connection c, int student_id) throws SQLException{
        PreparedStatement statement = c.prepareStatement(selectByIdStr);
        statement.setInt(1, student_id);
        ResultSet rs = statement.executeQuery();
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
            
            if (editItem == null) {
                PreparedStatement statement = c.prepareStatement(insertStr);
                statement.setString(1, Surname);
                statement.setInt(2, Integer.parseInt(Telephone));
                statement.setString(3, Address);
                statement.setInt(4, Integer.parseInt(Telephone_of_parents));
                statement.setInt(5, Group_id);
                
                statement.execute();                
            } else {
                PreparedStatement statement = c.prepareStatement(updateStr);
                statement.setString(1, Surname);
                statement.setInt(2, Integer.parseInt(Telephone));
                statement.setString(3, Address);
                statement.setInt(4, Integer.parseInt(Telephone_of_parents));
                statement.setInt(5, Group_id);
                statement.setInt(6, editItem.getId());
                
                statement.execute();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(new JFrame(), ex.getMessage());
        }
    } 
         
    public void delete(int student_id){
        try {
                PreparedStatement statement = c.prepareStatement(deleteStr);
                statement.setInt(1, student_id);
                statement.execute();
      
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(new JFrame(), ex.getMessage());
            }
    }
    
}
