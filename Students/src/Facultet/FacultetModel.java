
package Facultet;
import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;
import Entities.Facultet;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class FacultetModel extends AbstractTableModel {
    
    List<Facultet> list = new ArrayList<>();//создаем список факультетов
    
    Connection c;
    
    public FacultetModel(Connection c) throws SQLException {
        super();
        this.c = c;
        list = selectFacultet(c);
        rowsCount = list.size();
    }



    public void updateData() throws SQLException {
        list = new ArrayList<>();
        list = selectFacultet(c);
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
                return list.get(rowIndex).getName();
            case 1:
                return list.get(rowIndex). getDekan();
            
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
    
    public Facultet getSelectesItem(int row) {//возвращает одну строку
        return list.get(row);
    }
    
     public static List<Facultet> selectFacultet(Connection c) throws SQLException{//запрос вывод таблицы
        Statement statement = c.createStatement();
        List<Facultet> facultets = new ArrayList<>();
            ResultSet rs = statement.executeQuery("SELECT * FROM fakultet");
            while (rs.next()) {
                Facultet item = new Facultet(rs.getInt("fid"), rs.getString("Name"), 
                        rs.getString("Dekan"));

                facultets.add(item);
            }
            return facultets;
    }
     
     
    public static Facultet selectFacultetById(Connection c, int fid) throws SQLException{
    Statement statement = c.createStatement();
        ResultSet rs = statement.executeQuery("SELECT * FROM fakultet WHERE fid = "+fid );
        Facultet facultet = null;
        while (rs.next()) {
           facultet = new Facultet(rs.getInt("fid"), rs.getString("Name"), 
                    rs.getString("Dekan"));
        }
        return facultet;
    }
    
    
    public void insertOrUpdate(Facultet editItem, String Name, String Dekan) {
        try {
            Statement statement = c.createStatement();
            if (editItem == null) {
                statement.executeUpdate("insert into fakultet "
                    + "(Name,Dekan) "
                    + "values ('"
                    + Name + "','" + Dekan
                    +"');");
            } else {
                statement.executeUpdate("update fakultet set Name='"
                    + Name + "',Dekan='"
                    + Dekan + "' where fid="+editItem.getId()+";");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(new JFrame(), ex.getMessage());
        }
    }
    
    
    public void delete(int fid){
        try {
                Statement statement = c.createStatement();
                statement.executeUpdate("delete from fakultet where fid="
                    + fid + ";");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(new JFrame(), ex.getMessage());
            }
    }





    

    
}
