/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Report;

import Entities.Report;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

public class ReportModel extends AbstractTableModel{
    List<Report> list = new ArrayList<>();

    Connection c;
        static final String selectStr = "SELECT * FROM Report";
     public ReportModel(Connection c) throws SQLException {
        super();
        this.c = c;
        list = selectReport(c);
        rowsCount = list.size();
    }
    
       public void updateData() throws SQLException {
        list = new ArrayList<>();
        list = selectReport(c);
        rowsCount = list.size();
    }
       int rowsCount = 5;
    int colCount = 7;
    
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
                return list.get(rowIndex). getFaculty();
            case 1:
                return list.get(rowIndex). getName_of_group();
            case 2:
                return list.get(rowIndex). getStudent();
            case 3:
                return list.get(rowIndex). getDiscipline();
             case 4:
                return list.get(rowIndex). getTeacher();
            case 5:
                return list.get(rowIndex). getData();
            case 6:
                return list.get(rowIndex). getMark();
 
        }
        return null;
    }
    
   @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Факультет";
            case 1:
                return "Группа";
            case 2:
                return "Студент";
            case 3:
                return "Преподаватель";
            case 4:
                return "Дисциплина";
            case 5:
                return "Дата";
            case 6:
                return "Оценка";
           
        }
        return null;
    }
    
    public Report getSelectesItem(int row) {
        return list.get(row);
    }
    
    public static List<Report> selectReport(Connection c) throws SQLException{
 
        List<Report> reports = new ArrayList<>();
       PreparedStatement statement = c.prepareStatement(selectStr);

            ResultSet rs = statement.executeQuery();
    
          
            while (rs.next()) {
                Report item = new Report(rs.getString("faculty"), rs.getString("name_of_group"), 
                        rs.getString("student"),rs.getString("teacher"),rs.getString("discipline"),
                rs.getString("data"),rs.getString("mark"));

                reports.add(item);
   
               
            }
            return reports;
    }
    

    }
   
 
