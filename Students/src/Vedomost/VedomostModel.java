/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vedomost;

import Entities.Vedomost;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

public class VedomostModel extends AbstractTableModel{
    List<Vedomost> list = new ArrayList<>();

    Connection c;
     public VedomostModel(Connection c) throws SQLException {
        super();
        this.c = c;
        list = selectVedomost(c);
        rowsCount = list.size();
    }
    
       public void updateData() throws SQLException {
        list = new ArrayList<>();
        list = selectVedomost(c);
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
                return list.get(rowIndex). getFakultet();
            case 1:
                return list.get(rowIndex). getGroup();
            case 2:
                return list.get(rowIndex). getStudent();
            case 3:
                return list.get(rowIndex). getDiscipline();
             case 4:
                return list.get(rowIndex). getPrepodavatel();
            case 5:
                return list.get(rowIndex). getData();
            case 6:
                return list.get(rowIndex). getOcenka();
//                 try {
//                    Statement statement = c.createStatement();
//                    ResultSet rs = statement.executeQuery("SELECT * from vedomost "
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
//                            + "where id=" + list.get(rowIndex).getPrepodavatel_DiscipleId() 
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
    
    public Vedomost getSelectesItem(int row) {//возвращает одну строку
        return list.get(row);
    }
    
    public static List<Vedomost> selectVedomost(Connection c) throws SQLException{//запрос вывод таблицы
        Statement statement = c.createStatement();
        List<Vedomost> vedomosts = new ArrayList<>();
       
      // rs.next();
//            ResultSet rs = statement.executeQuery("create view vedomost as\n" +
//"select F.name as Facultet, G.name as Group, S.familiya as Student, P.familiya as Prepodavatel, D.name as discipline, O.data as Data, O.mark as mark\n" +
//"from Fakultet F join groop G \n" +
//"ON F.fid=G.fid\n" +
//"join student S on\n" +
//"S.gid=G.id\n" +
//"join prepodavatel P ON\n" +
//"P.fid=F.fid \n" +
//"join prepodavatel_discipline PD on \n" +
//"PD.pid=P.pid\n" +
//"join discipline D on\n" +
//"D.id=PD.did \n" +
//"join Ocenka O ON\n" +
//"O.pdid=PD.pdid;");
            //rs.next();
            ResultSet rs = statement.executeQuery("SELECT * FROM Vedomost1");
            while (rs.next()) {
                Vedomost item = new Vedomost(rs.getString("facultet"), rs.getString("group"), 
                        rs.getString("student"),rs.getString("prepodavatel"),rs.getString("discipline"),
                rs.getString("data"),rs.getString("mark"));

                vedomosts.add(item);
                 //rs = statement.executeQuery("drop view Vedomost"); 
               
            }
            return vedomosts;
    }
    
//
//     public static Vedomost selectVedomostById(Connection c, int oid) throws SQLException{
//    Statement statement = c.createStatement();
//        ResultSet rs = statement.executeQuery("SELECT * FROM Vedomost WHERE oid = "+oid );
//        Vedomost ocenka = null;
//        while (rs.next()) {
//           ocenka = new Vedomost( rs.getInt("oid"), rs.getString("mark"), 
//                        rs.getString("data"),rs.getInt("sid"),rs.getInt("pdid")
//                    );
//        }
//        return ocenka;
//    }
//    public void insertOrUpdate(Vedomost editItem,String Name,Integer StudentId,Integer Prepodavatel_DiscipleId,
//            String Data)
//  {
//        try {
//            Statement statement = c.createStatement();
//            if (editItem == null) {
//                statement.executeUpdate("insert into Vedomost "
//                    + "(mark,sid,pdid,data) "
//                    + "values ('"
//                    + Name + "','" +StudentId +"','" + Prepodavatel_DiscipleId +"','"+Data+
//                     "');");
//            } else {
//                statement.executeUpdate("update Vedomost set mark='"
//                    + Name + "',sid='"
//                    +  StudentId + "',pdid='"+Prepodavatel_DiscipleId+ "',data='"+Data+
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
   
 
