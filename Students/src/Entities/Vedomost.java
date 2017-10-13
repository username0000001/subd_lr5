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
public class Vedomost {
    //private int id;
    private String Fakultet;
    private String Group;
    private String Student;
    private String Discipline;
    private String Prepodavatel;
    private String Data;
    private String Ocenka;
   

    public Vedomost( String Fakultet, String Group,String Student,
            String Discipline,String Prepodavatel, String Data, String Ocenka) {
        //this.id = id;
        this.Fakultet=Fakultet;
        this.Group = Group;
        this.Student = Student;
        this.Discipline=Discipline;
        this.Prepodavatel=Prepodavatel;
        this.Data=Data;
        this.Ocenka=Ocenka;
        
    }

    @Override
    public String toString() {
        return Group;
    }

//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
    public String getFakultet()
    {
        return Fakultet;
    }
            
    public void setFakultet(String Fakultet)
    {
        this.Fakultet=Fakultet;
    }

     public String getGroup()
    {
        return Group;
    }
            
    public void setGroup(String Group)
    {
        this.Group=Group;
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
    
     public String getPrepodavatel()
    {
        return Prepodavatel;
    }
            
    public void setPrepodavatel(String Prepodavatel)
    {
        this.Prepodavatel=Prepodavatel;
    }
    
    public String getData()
    {
        return Data;
    }
    
    public void setData(String Data)
    {
        this.Data=Data;
    }
    
     public String getOcenka() {
        return Ocenka;
    }

    public void setOcenka(String Ocenka) {
        this.Ocenka = Ocenka;
    }
 public String getFullInfo() {
        return Fakultet + " " + Group + " " + Student + " " + Discipline + " "
                + Prepodavatel + " " + Data + " " +  Ocenka ;
    }
    
}
