
package Faculty;
import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;
import Entities.Faculty;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class FacultyModel extends AbstractTableModel {
    
    List<Faculty> list = new ArrayList<>();//создаем список факультетов
    
    Connection c;
    
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
        Statement statement = c.createStatement();
        List<Faculty> facultets = new ArrayList<>();
            ResultSet rs = statement.executeQuery("SELECT * FROM Faculty");
            while (rs.next()) {
                Faculty item = new Faculty(rs.getInt("faculty_id"), rs.getString("Faculty_name"), 
                        rs.getString("Dean"));

                facultets.add(item);
            }
            return facultets;
    }
     
     
    public static Faculty selectFacultyById(Connection c, int faculty_id) throws SQLException{
    Statement statement = c.createStatement();
        ResultSet rs = statement.executeQuery("SELECT * FROM Faculty WHERE faculty_id = "+faculty_id );
        Faculty facultet = null;
        while (rs.next()) {
           facultet = new Faculty(rs.getInt("faculty_id"), rs.getString("Faculty_name"), 
                    rs.getString("Dean"));
        }
        return facultet;
    }
    
    
    public void insertOrUpdate(Faculty editItem, String Faculty_name, String Dean) {
        try {
            Statement statement = c.createStatement();
            if (editItem == null) {
                statement.executeUpdate("insert into Faculty "
                    + "(Faculty_name,Dean) "
                    + "values ('"
                    + Faculty_name + "','" + Dean
                    +"');");
            } else {
                statement.executeUpdate("update Faculty set Faculty_name='"
                    + Faculty_name + "',Dean='"
                    + Dean + "' where faculty_id="+editItem.getId()+";");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(new JFrame(), ex.getMessage());
        }
    }
    
    
    public void delete(int faculty_id){
        try {
                Statement statement = c.createStatement();
                statement.executeUpdate("delete from Faculty where faculty_id="
                    + faculty_id + ";");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(new JFrame(), ex.getMessage());
            }
    }





    

    
}
