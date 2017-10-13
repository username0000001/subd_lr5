/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Report;

import Entities.Report;
import java.sql.Connection;
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
//                 try {
//                    Statement statement = c.createStatement();
//                    ResultSet rs = statement.executeQuery("SELECT * from report "
//                            + "where sid=" + list.get(rowIndex).getStudentId() 
//                            + ";");
//                    rs.next();
//                    s = rs.getString("familiya");
//                } catch (SQLException ex) {
//                    JOptionPane.showMessageDialog(new JFrame(), ex.getMessage());
//                }
//                return s;
//            case 1:
//                return list.get(rowIndex). getId(); 
//            case 1:
//                try {
//                    Statement statement = c.createStatement();
//                    ResultSet rs = statement.executeQuery("SELECT * from student "
//                            + "where sid=" + list.get(rowIndex).getStudentId() 
//                            + ";");
//                    rs.next();
//                    s = rs.getString("familiya");
//                } catch (SQLException ex) {
//                    JOptionPane.showMessageDialog(new JFrame(), ex.getMessage());
//                }
//                return s;
//                
//            case 2:
//                 try {
//                    Statement statement = c.createStatement();
//                    ResultSet rs = statement.executeQuery("SELECT * FROM Prepod_and_Disc2 "
//                            + "where id=" + list.get(rowIndex).getTeacher_DiscipleId() 
//                            + ";");
//                    rs.next();
//                    s = rs.getString("p_and_d");
//                } catch (SQLException ex) {
//                    JOptionPane.showMessageDialog(new JFrame(), ex.getMessage());
//                }
//                return s;
//          case 3:
//                return list.get(rowIndex). getData();
//          case 4:
//                return list.get(rowIndex). getId(); 
        }
        return null;
    }
    
   @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Факультет";
//                case 1:
//                return "oid";
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
    
    public Report getSelectesItem(int row) {//возвращает одну строку
        return list.get(row);
    }
    
    public static List<Report> selectReport(Connection c) throws SQLException{//запрос вывод таблицы
        Statement statement = c.createStatement();
        List<Report> reports = new ArrayList<>();
       
      // rs.next();
//            ResultSet rs = statement.executeQuery("create view report as\n" +
//"select F.name as Facultet, G.name as Group, S.familiya as Student, P.familiya as Teacher, D.name as discipline, O.data as Data, O.mark as mark\n" +
//"from Faculty F join groop G \n" +
//"ON F.fid=G.fid\n" +
//"join student S on\n" +
//"S.gid=G.id\n" +
//"join teacher P ON\n" +
//"P.fid=F.fid \n" +
//"join teacher_discipline PD on \n" +
//"PD.pid=P.pid\n" +
//"join discipline D on\n" +
//"D.id=PD.did \n" +
//"join Mark O ON\n" +
//"O.pdid=PD.pdid;");
            //rs.next();
            ResultSet rs = statement.executeQuery("SELECT * FROM Report");
            while (rs.next()) {
                Report item = new Report(rs.getString("faculty"), rs.getString("name_of_group"), 
                        rs.getString("student"),rs.getString("teacher"),rs.getString("discipline"),
                rs.getString("data"),rs.getString("mark"));

                reports.add(item);
                 //rs = statement.executeQuery("drop view Report"); 
               
            }
            return reports;
    }
    
//
//     public static Report selectReportById(Connection c, int oid) throws SQLException{
//    Statement statement = c.createStatement();
//        ResultSet rs = statement.executeQuery("SELECT * FROM Report WHERE oid = "+oid );
//        Report ocenka = null;
//        while (rs.next()) {
//           ocenka = new Report( rs.getInt("oid"), rs.getString("mark"), 
//                        rs.getString("data"),rs.getInt("sid"),rs.getInt("pdid")
//                    );
//        }
//        return ocenka;
//    }
//    public void insertOrUpdate(Report editItem,String Name,Integer StudentId,Integer Teacher_DiscipleId,
//            String Data)
//  {
//        try {
//            Statement statement = c.createStatement();
//            if (editItem == null) {
//                statement.executeUpdate("insert into Report "
//                    + "(mark,sid,pdid,data) "
//                    + "values ('"
//                    + Name + "','" +StudentId +"','" + Teacher_DiscipleId +"','"+Data+
//                     "');");
//            } else {
//                statement.executeUpdate("update Report set mark='"
//                    + Name + "',sid='"
//                    +  StudentId + "',pdid='"+Teacher_DiscipleId+ "',data='"+Data+
//                     " 'where oid="
//                    + editItem.getId() + ";");
//            }
//        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(new JFrame(), ex.getMessage());
//        }
//    } 
//    
//    public void delete(int oid){
//        try {
//                Statement statement = c.createStatement();
//                statement.executeUpdate("delete from ocenka where oid="
//                    + oid + ";");
//            } catch (SQLException ex) {
//                JOptionPane.showMessageDialog(new JFrame(), ex.getMessage());
//            }
    }
   
 
