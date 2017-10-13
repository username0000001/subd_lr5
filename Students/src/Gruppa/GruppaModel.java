/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gruppa;

import Entities.Gruppa;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

public class GruppaModel extends AbstractTableModel {
    
    List<Gruppa> list = new ArrayList<>();

    Connection c;
    
    public GruppaModel(Connection c) throws SQLException {
        super();
        this.c = c;
        list = selectGruppa(c);
        rowsCount = list.size();
    }

    public void updateData() throws SQLException {
        list = new ArrayList<>();
        list = selectGruppa(c);
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
        String s = "";
        switch (columnIndex) {
            case 0:
                return list.get(rowIndex).getName();
            case 1:
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
          
        }
        return null;
    }
    
    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Название группы";
            case 1:
                return "Факультет";
            
           
        }
        return null;
    }

    public Gruppa getSelectesItem(int row) {
        return list.get(row);
    }

    public static List<Gruppa> selectGruppa(Connection c) throws SQLException{
        Statement statement = c.createStatement();
        List<Gruppa> gruppas = new ArrayList<>();
            ResultSet rs = statement.executeQuery("SELECT * FROM groop");
            while (rs.next()) {
                Gruppa item = new Gruppa(rs.getInt("id"), rs.getString("name"),rs.getInt("fid")
                        );

                gruppas.add(item);
            }
            return gruppas;
    }
    
    public static Gruppa selectGruppaById(Connection c, int id) throws SQLException{
    Statement statement = c.createStatement();
        ResultSet rs = statement.executeQuery("SELECT * FROM groop WHERE id = "+id );
        Gruppa gruppa = null;
        while (rs.next()) {
           gruppa = new Gruppa( rs.getInt("id"), rs.getString("name"),rs.getInt("fid")
                    );
        }
        return gruppa;
    }
    public void insertOrUpdate(Gruppa editItem, String name, Integer fid) {
        try {
            Statement statement = c.createStatement();
            if (editItem == null) {
                statement.executeUpdate("insert into groop "
                    + "(name,fid) "
                    + "values ('"
                    + name + "','" + fid
                    + "');");
            } else {
                statement.executeUpdate("update groop set name='"
                    + name + "',fid="
                    + fid +
                     " where ID="
                    + editItem.getId() + ";");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(new JFrame(), ex.getMessage());
        }
    } 
    
    public void delete(int id){
        try {
                Statement statement = c.createStatement();
                statement.executeUpdate("delete from groop where ID="
                    + id + ";");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(new JFrame(), ex.getMessage());
            }
    }
    
}
