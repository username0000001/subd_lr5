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
public class Mark  {
    
    private int Mark_id;
    private String Data;
    private String Mark;
    private int Student_id;
    private int Teacher_Discipline_id;
   

    public Mark(int Mark_id, String Data, String Mark, int Student_id, 
            int Teacher_Discipline_id) {
        this.Mark_id = Mark_id;
        this.Data = Data;
        this.Mark = Mark;
        this.Student_id=Student_id;
        this.Teacher_Discipline_id=Teacher_Discipline_id;
        
    }

  

    public int getId() {
        return Mark_id;
    }

    public void setId(int Mark_id) {
        this.Mark_id = Mark_id;
    }

    public String getData() {
        return Data;
    }

    public void setData(String Data) {
        this.Data = Data;
    }

     public String getMark() {
        return Mark;
    }

    public void setMark(String Mark) {
        this.Mark = Mark;
    }
    public int getStudent_id() {
        return Student_id;
    }

    public void setStudent_id(int Student_id) {
        this.Student_id = Student_id;
    }
    
    public int getTeacher_Discipline_id() {
        return Teacher_Discipline_id;
    }

    public void setTeacher_Discipline_id(int Teacher_Discipline_id) {
        this.Teacher_Discipline_id = Teacher_Discipline_id;
    }
            

 public String getFullInfo() {
        return Mark + " " + Data + " " + Student_id + " " + Teacher_Discipline_id;
    }
   @Override
    public String toString(){
        return Mark;
    }
 
    
}
