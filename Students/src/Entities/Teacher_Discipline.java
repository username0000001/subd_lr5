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
public class Teacher_Discipline {
    
    private int Teacher_Discipline_id;
    private int Teacher_id;
     //private String Teacher_name;
    private int Discipline_id;
  
   

    public Teacher_Discipline(int Teacher_Discipline_id, int Teacher_id,int Discipline_id) {
        this.Teacher_Discipline_id = Teacher_Discipline_id;
        this.Teacher_id = Teacher_id;
     
       //this.Teacher_name=Teacher_name;
          this.Discipline_id = Discipline_id;
             
    }

   // @OverrTeacher_Discipline_ide
    //public String toString() {
    //    return getFullName();
   // }
//public String getTeacher_name(){
//    return Teacher_name;
//}
//public void set(String Teacher_name) {
//        this.Teacher_name = Teacher_name;
//    }
    public int getId() {
        return Teacher_Discipline_id;
    }

    public void setId(int Teacher_Discipline_id) {
        this.Teacher_Discipline_id = Teacher_Discipline_id;
    }

 
    public int getTeacher_id() {
        return Teacher_id;
    }

    public void setTeacher_id(int Teacher_id) {
        this.Teacher_id = Teacher_id;
    }
    
    public int getDiscipline_id() {
        return Discipline_id;
    }

    public void setDiscipline_id(int Discipline_id) {
        this.Discipline_id = Discipline_id;
    }
            

 public String getFullInfo() {
        return Teacher_Discipline_id + " " + Discipline_id;
    }
 @Override
    public String toString() {
        return Integer.toString(Teacher_Discipline_id);
    }
 
    
}
