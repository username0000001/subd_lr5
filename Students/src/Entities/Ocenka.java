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
public class Ocenka  {
    
    private int id;
    private String Data;
    private String Name;
    private int StudentId;
    private int Prepodavatel_DiscipleId;
   

    public Ocenka(int id, String Data, String Name, int StudentId, 
            int Prepodavatel_DiscipleId) {
        this.id = id;
        this.Data = Data;
        this.Name = Name;
        this.StudentId=StudentId;
        this.Prepodavatel_DiscipleId=Prepodavatel_DiscipleId;
        
    }

  

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getData() {
        return Data;
    }

    public void setData(String Data) {
        this.Data = Data;
    }

     public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }
    public int getStudentId() {
        return StudentId;
    }

    public void setStudentId(int StudentId) {
        this.StudentId = StudentId;
    }
    
    public int getPrepodavatel_DiscipleId() {
        return Prepodavatel_DiscipleId;
    }

    public void setPrepodavatel_DiscipleId(int Prepodavatel_DiscipleId) {
        this.Prepodavatel_DiscipleId = Prepodavatel_DiscipleId;
    }
            

 public String getFullInfo() {
        return Name + " " + Data + " " + StudentId + " " + Prepodavatel_DiscipleId;
    }
   @Override
    public String toString(){
        return Name;
    }
 
    
}
