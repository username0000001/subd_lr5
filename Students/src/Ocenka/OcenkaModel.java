/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ocenka;
import Entities.Ocenka;
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
public class OcenkaModel extends AbstractTableModel{
    List<Ocenka> list = new ArrayList<>();

    Connection c;
     public OcenkaModel(Connection c) throws SQLException {
        super();
        this.c = c;
        list = selectOcenka(c);
        rowsCount = list.size();
    }
    
       public void updateData() throws SQLException {
        list = new ArrayList<>();
        list = selectOcenka(c);
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
                return list.get(rowIndex).getName();
//            case 1:
//                return list.get(rowIndex). getId(); 
            case 1:
                try {
                    Statement statement = c.createStatement();
                    ResultSet rs = statement.executeQuery("SELECT * from student "
                            + "where sid=" + list.get(rowIndex).getStudentId() 
                            + ";");
                    rs.next();
                    s = rs.getString("familiya");
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(new JFrame(), ex.getMessage());
                }
                return s;
                
            case 2:
                 try {
                    Statement statement = c.createStatement();
                    ResultSet rs = statement.executeQuery("SELECT * FROM Prepod_and_Disc2 "
                            + "where id=" + list.get(rowIndex).getPrepodavatel_DiscipleId() 
                            + ";");
                    rs.next();
                    s = rs.getString("p_and_d");
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(new JFrame(), ex.getMessage());
                }
                return s;
          case 3:
                return list.get(rowIndex). getData();
          case 4:
                return list.get(rowIndex). getId(); 
        }
        return null;
    }
    
   @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Дата";
//                case 1:
//                return "oid";
            case 1:
                return "Студент";
            case 2:
                return "Дисциплина (преподаватель)";
            case 3:
                return "Оценка";
           
        }
        return null;
    }
    
    public Ocenka getSelectesItem(int row) {//возвращает одну строку
        return list.get(row);
    }
    
    public static List<Ocenka> selectOcenka(Connection c) throws SQLException{//запрос вывод таблицы
        Statement statement = c.createStatement();
        List<Ocenka> ocenkas = new ArrayList<>();
            ResultSet rs = statement.executeQuery("SELECT * FROM Ocenka");
            while (rs.next()) {
                Ocenka item = new Ocenka(rs.getInt("oid"), rs.getString("mark"), 
                        rs.getString("data"),rs.getInt("sid"),rs.getInt("pdid"));

                ocenkas.add(item);
            }
            return ocenkas;
    }
    

     public static Ocenka selectOcenkaById(Connection c, int oid) throws SQLException{
    Statement statement = c.createStatement();
        ResultSet rs = statement.executeQuery("SELECT * FROM Ocenka WHERE oid = "+oid );
        Ocenka ocenka = null;
        while (rs.next()) {
           ocenka = new Ocenka( rs.getInt("oid"), rs.getString("mark"), 
                        rs.getString("data"),rs.getInt("sid"),rs.getInt("pdid")
                    );
        }
        return ocenka;
    }
    public void insertOrUpdate(Ocenka editItem,String Name,Integer StudentId,Integer Prepodavatel_DiscipleId,
            String Data)
  {
        try {
            Statement statement = c.createStatement();
            if (editItem == null) {
                statement.executeUpdate("insert into Ocenka "
                    + "(mark,sid,pdid,data) "
                    + "values ('"
                    + Name + "','" +StudentId +"','" + Prepodavatel_DiscipleId +"','"+Data+
                     "');");
            } else {
                statement.executeUpdate("update Ocenka set mark='"
                    + Name + "',sid='"
                    +  StudentId + "',pdid='"+Prepodavatel_DiscipleId+ "',data='"+Data+
                     " 'where oid="
                    + editItem.getId() + ";");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(new JFrame(), ex.getMessage());
        }
    } 
    
    public void delete(int oid){
        try {
                Statement statement = c.createStatement();
                statement.executeUpdate("delete from ocenka where oid="
                    + oid + ";");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(new JFrame(), ex.getMessage());
            }
    }
    
    
}
