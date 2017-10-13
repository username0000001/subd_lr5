/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Discipline;

import Entities.Discipline;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

public class DisciplineModel extends AbstractTableModel {
    
    List<Discipline> list = new ArrayList<>();

    Connection c;
    
    public DisciplineModel(Connection c) throws SQLException {
        super();
        this.c = c;
        list = selectDiscipline(c);
        rowsCount = list.size();
    }

    public void updateData() throws SQLException {
        list = new ArrayList<>();
        list = selectDiscipline(c);
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
        switch (columnIndex) {
            case 0:
                return list.get(rowIndex).getDiscipline_name();
            case 1:
                return list.get(rowIndex).getNumber_of_hours();
          
        }
        return null;
    }
    
    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Название дисциплины";
            case 1:
                return "Количество часов";
           
        }
        return null;
    }

    public Discipline getSelectesItem(int row) {
        return list.get(row);
    }

    public static List<Discipline> selectDiscipline(Connection c) throws SQLException{
        Statement statement = c.createStatement();
        List<Discipline> disciplines = new ArrayList<>();
            ResultSet rs = statement.executeQuery("SELECT * FROM discipline");
            while (rs.next()) {
                Discipline item = new Discipline(rs.getInt("Discipline_id"), rs.getString("Discipline_name"), 
                        rs.getInt("Number_of_hours"));

                disciplines.add(item);
            }
            return disciplines;
    }
    
    public static Discipline selectDisciplineById(Connection c, int Discipline_id) throws SQLException{
    Statement statement = c.createStatement();
        ResultSet rs = statement.executeQuery("SELECT * FROM Discipline WHERE Discipline_id = "+Discipline_id );
        Discipline discipline = null;
        while (rs.next()) {
           discipline = new Discipline(rs.getInt("Discipline_id"), rs.getString("Discipline_name"), 
                    rs.getInt("Number_of_hours"));
        }
        return discipline;
    }
    public void insertOrUpdate(Discipline editItem, String Discipline_name, Integer Number_of_hours) {
        try {
            Statement statement = c.createStatement();
            if (editItem == null) {
                statement.executeUpdate("insert into Discipline "
                    + "(Discipline_name,Number_of_hours) "
                    + "values ('"
                    + Discipline_name + "','" + Number_of_hours
                    + "');");
            } else {
                statement.executeUpdate("update Discipline set Discipline_name='"
                    + Discipline_name + "',Number_of_hours="
                    + Number_of_hours +
                     " where discipline_id="
                    + editItem.getId() + ";");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(new JFrame(), ex.getMessage());
        }
    } 
    
    public void delete(int Discipline_id){
        try {
                Statement statement = c.createStatement();
                statement.executeUpdate("delete from Discipline where discipline_id="
                    + Discipline_id + ";");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(new JFrame(), ex.getMessage());
            }
    }
    
}
