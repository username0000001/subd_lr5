
package Faculty;
import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;
import Entities.Faculty;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class FacultyModel extends AbstractTableModel {
    
    List<Faculty> list = new ArrayList<>();//создаем список факультетов
    
    Connection c;
         final String deleteStr="delete from Faculty where faculty_id=?";
         static final String selectStr = "SELECT * FROM Faculty";
         static final String selectStrById = "SELECT * FROM Faculty WHERE faculty_id =?";
             final String insertStr = "insert into Faculty (Faculty_name,Dean) values (?,?)";
final String updateStr = "update Faculty set Faculty_name=?,Dean=? where faculty_id=?";
    
    public FacultyModel(Connection c) throws SQLException {
        super();
        this.c = c;
        list = selectFaculty(c);
        rowsCount = list.size();
    }



    public void updateData() throws SQLException {
        list = new ArrayList<>();
        list = selectFaculty(c);
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
    public Object getValueAt(int rowIndex, int columnIndex) { //заполнение таблиц
        
        switch (columnIndex) {
            case 0:
                return list.get(rowIndex).getFaculty_name();
            case 1:
                return list.get(rowIndex). getDean();
            
        }
        return null;
    }
    
    
    @Override
    public String getColumnName(int column) {//оглавление колонок
        switch (column) {
            case 0:
                return "Название факультета";
            case 1:
                return "Декан Факультета";
        }
        return null;
    }
    
    public Faculty getSelectesItem(int row) {//возвращает одну строку
        return list.get(row);
    }
    
     public static List<Faculty> selectFaculty(Connection c) throws SQLException{//запрос вывод таблицы
    
        List<Faculty> faculties = new ArrayList<>();
        PreparedStatement statement = c.prepareStatement(selectStr);

            ResultSet rs = statement.executeQuery();
           
            while (rs.next()) {
                Faculty item = new Faculty(rs.getInt("faculty_id"), rs.getString("Faculty_name"), 
                        rs.getString("Dean"));

                faculties.add(item);
            }
            return faculties;
    }
     
      
    public static Faculty selectFacultyById(Connection c, int faculty_id) throws SQLException{
  PreparedStatement statement = c.prepareStatement(selectStrById);
        statement.setInt(1, faculty_id);
        ResultSet rs = statement.executeQuery();
        
        Faculty facultet = null;
        while (rs.next()) {
           facultet = new Faculty(rs.getInt("faculty_id"), rs.getString("Faculty_name"), 
                    rs.getString("Dean"));
        }
        return facultet;
    }

    
    public void insertOrUpdate(Faculty editItem, String Faculty_name, String Dean) {
        try {
            if (editItem == null) {
                PreparedStatement statement = c.prepareStatement(insertStr);
                statement.setString(1, Faculty_name);
                statement.setString(2, Dean);
                statement.execute(); 
            } else {
                
                PreparedStatement statement = c.prepareStatement(updateStr);
                statement.setString(1, Faculty_name);
                statement.setString(2, Dean);
                 statement.setInt(3, editItem.getId());
                statement.execute(); 
                
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(new JFrame(), ex.getMessage());
        }
    }
    

    public void delete(int faculty_id){
        try {
                 PreparedStatement statement = c.prepareStatement(deleteStr);
                statement.setInt(1, faculty_id);
                statement.execute();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(new JFrame(), ex.getMessage());
            }
    }





    

    
}
