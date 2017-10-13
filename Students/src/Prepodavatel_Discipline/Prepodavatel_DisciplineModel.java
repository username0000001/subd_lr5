/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Prepodavatel_Discipline;
import Entities.Prepodavatel_Discipline;
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
public class Prepodavatel_DisciplineModel extends AbstractTableModel{
    List<Prepodavatel_Discipline> list = new ArrayList<>();

    Connection c;
     public Prepodavatel_DisciplineModel(Connection c) throws SQLException {
        super();
        this.c = c;
        list = selectPrepodavatel_Discipline(c);
        rowsCount = list.size();
    }

    public void updateData() throws SQLException {
        list = new ArrayList<>();
        list = selectPrepodavatel_Discipline(c);
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
                try {
                    Statement statement = c.createStatement();
                    ResultSet rs = statement.executeQuery("SELECT * from prepodavatel "
                            + "where pid=" + list.get(rowIndex).getPrepodavatelId() 
                            + ";");
                    rs.next();
                    s = rs.getString("familiya");
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(new JFrame(), ex.getMessage());
                }
                return s;
                
            case 1:
                 try {
                    Statement statement = c.createStatement();
                    ResultSet rs = statement.executeQuery("SELECT * FROM discipline "
                            + "where id=" + list.get(rowIndex).getDisciplineId() 
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
                return "Преподаватель";
            case 1:
                return "Дисциплина";
            
           
        }
        return null;
    }

    public Prepodavatel_Discipline getSelectesItem(int row) {
        return list.get(row);
    }
    
    public static List<Prepodavatel_Discipline> selectPrepodavatel_Discipline(Connection c) throws SQLException{
        Statement statement = c.createStatement();
        List<Prepodavatel_Discipline> prepodavatel_Disciplines = new ArrayList<>();
            ResultSet rs = statement.executeQuery("SELECT * FROM Prepodavatel_Discipline");
            while (rs.next()) {
                Prepodavatel_Discipline item = new Prepodavatel_Discipline(rs.getInt("pdid"), rs.getInt("pid"),rs.getInt("did")
                        );

                prepodavatel_Disciplines.add(item);
            }
            return prepodavatel_Disciplines;
    }
    
   
    
    public static Prepodavatel_Discipline selectGruppaById(Connection c, int id) throws SQLException{
    Statement statement = c.createStatement();
        ResultSet rs = statement.executeQuery("SELECT * FROM Prepodavatel_Discipline WHERE pdid = "+id );
        Prepodavatel_Discipline prepodavatel_Discipline = null;
        while (rs.next()) {
           prepodavatel_Discipline = new Prepodavatel_Discipline( rs.getInt("pdid"), rs.getInt("pid"),rs.getInt("did")
                    );
        }
        return prepodavatel_Discipline;
    }
    public void insertOrUpdate(Prepodavatel_Discipline editItem, Integer PrepodavatelId, Integer DisciplineId) {
        try {
            Statement statement = c.createStatement();
            if (editItem == null) {
                statement.executeUpdate("insert into Prepodavatel_Discipline "
                    + "(pid,did) "
                    + "values ('"
                    + PrepodavatelId + "','" + DisciplineId
                    + "');");
            } else {
                statement.executeUpdate("update Prepodavatel_Discipline set pid='"
                    + PrepodavatelId + "',did="
                    + DisciplineId +
                     " where pdid="
                    + editItem.getId() + ";");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(new JFrame(), ex.getMessage());
        }
    } 
    
    public void delete(int id){
        try {
                Statement statement = c.createStatement();
                statement.executeUpdate("delete from Prepodavatel_Discipline where pdid="
                    + id + ";");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(new JFrame(), ex.getMessage());
            }
    }
}
