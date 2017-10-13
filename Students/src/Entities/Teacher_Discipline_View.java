/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

/**
 *
 * @author user
 */
public class Teacher_Discipline_View {
    private int id;
    private String Info;
    
   

    public Teacher_Discipline_View(int id, String Info ) {
        this.id = id;
        this.Info = Info;
       
        
    }

   // @Override
    //public String toString() {
    //    return getFullName();
   // }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getInfo() {
        return Info;
    }

    public void setInfo(String Info) {
        this.Info = Info;
    }

    

 public String getFullInfo() {
        return Info + " " + Info;
    }
    @Override
    public String toString() {
        return Info;
    }

    
}
