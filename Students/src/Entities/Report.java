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
public class Report {
    //private int id;
    private String Faculty;
    private String Name_of_group;
    private String Student;
    private String Discipline;
    private String Teacher;
    private String Data;
    private String Mark;
   

    public Report( String Faculty, String Name_of_group,String Student,
            String Discipline,String Teacher, String Data, String Mark) {
        //this.id = id;
        this.Faculty=Faculty;
        this.Name_of_group = Name_of_group;
        this.Student = Student;
        this.Discipline=Discipline;
        this.Teacher=Teacher;
        this.Data=Data;
        this.Mark=Mark;
        
    }

    @Override
    public String toString() {
        return Name_of_group;
    }

//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
    public String getFaculty()
    {
        return Faculty;
    }
            
    public void setFaculty(String Faculty)
    {
        this.Faculty=Faculty;
    }

     public String getName_of_group()
    {
        return Name_of_group;
    }
            
    public void setName_of_group(String Name_of_group)
    {
        this.Name_of_group=Name_of_group;
    }
    
     public String getStudent()
    {
        return Student;
    }
            
    public void setStudent(String Student)
    {
        this.Student=Student;
    }

    
     public String getDiscipline()
    {
        return Discipline;
    }
            
    public void setDiscipline(String Discipline)
    {
        this.Discipline=Discipline;
    }
    
     public String getTeacher()
    {
        return Teacher;
    }
            
    public void setTeacher(String Teacher)
    {
        this.Teacher=Teacher;
    }
    
    public String getData()
    {
        return Data;
    }
    
    public void setData(String Data)
    {
        this.Data=Data;
    }
    
     public String getMark() {
        return Mark;
    }

    public void setMark(String Mark) {
        this.Mark = Mark;
    }
 public String getFullInfo() {
        return Faculty + " " + Name_of_group + " " + Student + " " + Discipline + " "
                + Teacher + " " + Data + " " +  Mark ;
    }
    
}
