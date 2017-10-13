/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Prepodavatel;
import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;
import Entities.Prepodavatel;
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
public class PrepodavatelModel extends AbstractTableModel {
    
    List<Prepodavatel> list = new ArrayList<>();//создаем список факультетов
    
    Connection c;
    
    public PrepodavatelModel(Connection c) throws SQLException {
        super();
        this.c = c;
        list = selectPrepodavatel(c);
        rowsCount = list.size();
    }
    
       public void updateData() throws SQLException {
        list = new ArrayList<>();
        list = selectPrepodavatel(c);
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
                return list.get(rowIndex). getAdress();
            case 3:
                try {
                    Statement statement = c.createStatement();
                    ResultSet rs = statement.executeQuery("SELECT * FROM fakultet "
                            + "where fid=" + list.get(rowIndex).getFacultetId() 
                            + ";");
                    rs.next();
                    s = rs.getString("name");
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
                return "pid";
        }
        return null;
    }
    
    public Prepodavatel getSelectesItem(int row) {//возвращает одну строку
        return list.get(row);
    }
    
    public static List<Prepodavatel> selectPrepodavatel(Connection c) throws SQLException{//запрос вывод таблицы
        Statement statement = c.createStatement();
        List<Prepodavatel> prepodavatels = new ArrayList<>();
            ResultSet rs = statement.executeQuery("SELECT * FROM Prepodavatel");
            while (rs.next()) {
                Prepodavatel item = new Prepodavatel(rs.getInt("pid"), rs.getString("familiya"), 
                        rs.getString("telefon"),
                        rs.getString("adres"),rs.getInt("fid"));

                prepodavatels.add(item);
            }
            return prepodavatels;
    }
     public static Prepodavatel selectPrepodavatelById(Connection c, int pid) throws SQLException{
    Statement statement = c.createStatement();
        ResultSet rs = statement.executeQuery("SELECT * FROM Prepodavatel WHERE pid = "+pid );
        Prepodavatel prepodavatel = null;
        while (rs.next()) {
           prepodavatel = new Prepodavatel( rs.getInt("pid"), rs.getString("familiya"), 
                        rs.getString("telefon"),
                        rs.getString("adres"),rs.getInt("fid")
                    );
        }
        return prepodavatel;
    }
    public void insertOrUpdate(Prepodavatel editItem, String Surname,
            String Telephone, String Adress,Integer FacultetId) {
        try {
            Statement statement = c.createStatement();
            if (editItem == null) {
                statement.executeUpdate("insert into prepodavatel "
                    + "(familiya,telefon,adres,fid) "
                    + "values ('"
                    + Surname + "','" +Telephone+
                        "','"+Adress+"','"+FacultetId
                    + "');");
            } else {
                statement.executeUpdate("update prepodavatel set familiya='"
                    + Surname +  "',telefon='"+Telephone+
                     "',adres='"+Adress+ "',fid="+FacultetId+
                     " where pid="
                    + editItem.getId() + ";");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(new JFrame(), ex.getMessage());
        }
    } 
    
    public void delete(int pid){
        try {
                Statement statement = c.createStatement();
                statement.executeUpdate("delete from prepodavatel where pid="
                    + pid + ";");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(new JFrame(), ex.getMessage());
            }
    }
    
}
