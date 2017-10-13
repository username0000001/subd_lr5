/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Group;

import Entities.Group;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

public class GroupModel extends AbstractTableModel {
    
    List<Group> list = new ArrayList<>();

    Connection c;
    
    public GroupModel(Connection c) throws SQLException {
        super();
        this.c = c;
        list = selectGroup(c);
        rowsCount = list.size();
    }

    public void updateData() throws SQLException {
        list = new ArrayList<>();
        list = selectGroup(c);
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
                    ResultSet rs = statement.executeQuery("SELECT * FROM faculty "
                            + "where faculty_id=" + list.get(rowIndex).getFacultyId() 
                            + ";");
                    rs.next();
                    s = rs.getString("faculty_name");
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

    public Group getSelectesItem(int row) {
        return list.get(row);
    }

    public static List<Group> selectGroup(Connection c) throws SQLException{
        Statement statement = c.createStatement();
        List<Group> groups = new ArrayList<>();
            ResultSet rs = statement.executeQuery("SELECT * FROM gro_up");
            while (rs.next()) {
                Group item = new Group(rs.getInt("group_id"), rs.getString("group_name"),rs.getInt("faculty_id")
                        );

                groups.add(item);
            }
            return groups;
    }
    
    public static Group selectGroupById(Connection c, int group_id) throws SQLException{
    Statement statement = c.createStatement();
        ResultSet rs = statement.executeQuery("SELECT * FROM gro_up WHERE group_id = "+group_id );
        Group group = null;
        while (rs.next()) {
           group = new Group( rs.getInt("group_id"), rs.getString("group_name"),rs.getInt("faculty_id")
                    );
        }
        return group;
    }
    public void insertOrUpdate(Group editItem, String group_name, Integer faculty_id) {
        try {
            Statement statement = c.createStatement();
            if (editItem == null) {
                statement.executeUpdate("insert into gro_up "
                    + "(group_name,faculty_id) "
                    + "values ('"
                    + group_name + "','" + faculty_id
                    + "');");
            } else {
                statement.executeUpdate("update gro_up set group_name='"
                    + group_name + "',faculty_id="
                    + faculty_id +
                     " where group_id="
                    + editItem.getId() + ";");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(new JFrame(), ex.getMessage());
        }
    } 
    
    public void delete(int group_id){
        try {
                Statement statement = c.createStatement();
                statement.executeUpdate("delete from gro_up where group_id="
                    + group_id + ";");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(new JFrame(), ex.getMessage());
            }
    }
    
}
