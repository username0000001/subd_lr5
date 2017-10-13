/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Group;

import Entities.Group;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

public class GroupModel extends AbstractTableModel {
    
    List<Group> list = new ArrayList<>();

    Connection c;
        final String deleteStr = "delete from gro_up where group_id=?";
        final String insertStr = "insert into gro_up (group_name,faculty_id) values (?,?)";
        final String updateStr = "update gro_up set group_name=?,faculty_id=? where group_id=?";
        final static String selectStr="SELECT * FROM gro_up";
        static final String selectByIdStr = "SELECT * FROM gro_up WHERE group_id =?;";
        final String selectFaculty="SELECT * FROM faculty where faculty_id=?";
    
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
                    PreparedStatement statement = c.prepareStatement(selectFaculty);
                    statement.setInt(1, list.get(rowIndex).getFacultyId());
                    ResultSet rs = statement.executeQuery();
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
        PreparedStatement statement = c.prepareStatement(selectStr);
        ResultSet rs = statement.executeQuery();
        List<Group> groups = new ArrayList<>(); 
        while (rs.next()) {
            Group item = new Group(rs.getInt("group_id"), rs.getString("group_name"),
            rs.getInt("faculty_id"));
            groups.add(item);
            }
        return groups;
    }

    public static Group selectGroupById(Connection c, int group_id) throws SQLException{
        PreparedStatement statement = c.prepareStatement(selectByIdStr);
        statement.setInt(1, group_id);
        ResultSet rs = statement.executeQuery();
        Group group = null;
            while (rs.next()) {
            group = new Group( rs.getInt("group_id"), rs.getString("group_name"),
            rs.getInt("faculty_id"));
            }
        return group;
    }
 
    public void insertOrUpdate(Group editItem, String group_name, Integer faculty_id) {
        try {
            if (editItem == null) {
                PreparedStatement statement = c.prepareStatement(insertStr);
                statement.setString(1, group_name);
                statement.setInt(2, faculty_id);
                statement.execute();    
            } else {
                PreparedStatement statement = c.prepareStatement(updateStr);
                statement.setString(1, group_name);
                statement.setInt(2, faculty_id);
                statement.setInt(3, editItem.getId());
                statement.execute();   
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(new JFrame(), ex.getMessage());
        }
    } 
    
    public void delete(int group_id){
        try {   
            PreparedStatement statement = c.prepareStatement(deleteStr);
            statement.setInt(1, group_id);
            statement.execute();    
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(new JFrame(), ex.getMessage());
            }
    }   
}
