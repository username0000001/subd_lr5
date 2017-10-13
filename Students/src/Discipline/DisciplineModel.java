/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Discipline;

import Entities.Discipline;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

public class DisciplineModel extends AbstractTableModel {
    
    List<Discipline> list = new ArrayList<>();

    Connection c;
       
        static final String selectStr = "SELECT * FROM discipline";
        static final String selectStrById = "SELECT * FROM Discipline WHERE Discipline_id = ?";
        final String deleteStr="delete from Discipline where discipline_id=?";
        final String insertStr = "insert into Discipline (Discipline_name,Number_of_hours) values (?,?);";
        final String updateStr = "update Discipline set Discipline_name=?,Number_of_hours=? where discipline_id=?";
   
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
    
    int rowsCount;
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
        List<Discipline> disciplines = new ArrayList<>();
        PreparedStatement statement = c.prepareStatement(selectStr);
        ResultSet rs = statement.executeQuery();
        while (rs.next()) {
            Discipline item = new Discipline(rs.getInt("Discipline_id"), 
            rs.getString("Discipline_name"), 
            rs.getInt("Number_of_hours"));
            disciplines.add(item);
        }
        return disciplines;
    }
   
    public static Discipline selectDisciplineById(Connection c, int Discipline_id) throws SQLException{
        PreparedStatement statement = c.prepareStatement(selectStrById);
        statement.setInt(1, Discipline_id);
        ResultSet rs = statement.executeQuery();
        Discipline discipline = null;
        while (rs.next()) {
           discipline = new Discipline(rs.getInt("Discipline_id"), rs.getString("Discipline_name"), 
           rs.getInt("Number_of_hours"));
        }
        return discipline;
    }
   

    public void insertOrUpdate(Discipline editItem, String Discipline_name, Integer Number_of_hours) {
        try {
            if (editItem == null) {
                PreparedStatement statement = c.prepareStatement(insertStr);
                statement.setString(1, Discipline_name);
                statement.setInt(2, Number_of_hours);
                statement.execute(); 
            } else {
                PreparedStatement statement = c.prepareStatement(updateStr);
                statement.setString(1, Discipline_name);
                statement.setInt(2, Number_of_hours);
                statement.setInt(3, editItem.getId());
                statement.execute();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(new JFrame(), ex.getMessage());
        }
    } 
   
    public void delete(int Discipline_id){
        try {
            PreparedStatement statement = c.prepareStatement(deleteStr);
            statement.setInt(1, Discipline_id);
            statement.execute();   
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(new JFrame(), ex.getMessage());
            }
    }    
}
