/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Prepod_and_Disc;
import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;
import Entities.Prepod_and_Disc;
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
public class Prepod_and_DiscModel {
    
    List<Prepod_and_Disc> list = new ArrayList<>();//создаем список факультетов
    
    Connection c;
    
    public Prepod_and_DiscModel(Connection c) throws SQLException {
        super();
        this.c = c;
        list = selectPrepod_and_Disc(c);
        //rowsCount = list.size();
    }
    public static List<Prepod_and_Disc> selectPrepod_and_Disc(Connection c) throws SQLException{//запрос вывод таблицы
        Statement statement = c.createStatement();
        List<Prepod_and_Disc> pds = new ArrayList<>();
            ResultSet rs = statement.executeQuery("SELECT * FROM Prepod_and_Disc2");
            while (rs.next()) {
                Prepod_and_Disc item = new Prepod_and_Disc(rs.getInt("id"), rs.getString("p_and_d")
                        );

                pds.add(item);
            }
            return pds;
    }
    
}
