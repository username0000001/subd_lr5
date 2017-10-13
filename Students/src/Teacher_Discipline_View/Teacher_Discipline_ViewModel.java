/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Teacher_Discipline_View;
import java.util.ArrayList;
import java.util.List;
import Entities.Teacher_Discipline_View;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author user
 */
public class Teacher_Discipline_ViewModel {
    
    List<Teacher_Discipline_View> list = new ArrayList<>();
    Connection c;
    static final String selectStr = "SELECT * FROM view_teacher_discipline";
    
    public Teacher_Discipline_ViewModel(Connection c) throws SQLException {
        super();
        this.c = c;
        list = selectTeacher_Discipline_View(c);
    }

    public static List<Teacher_Discipline_View> selectTeacher_Discipline_View(Connection c) throws SQLException{//запрос вывод таблицы
        List<Teacher_Discipline_View> tds = new ArrayList<>();
        PreparedStatement statement = c.prepareStatement(selectStr);
        ResultSet rs = statement.executeQuery();
         while (rs.next()) {
                Teacher_Discipline_View item = new Teacher_Discipline_View(rs.getInt("id"), rs.getString("Discipline_Teacher"));
                tds.add(item);
            }
            return tds;
    }
    
}
