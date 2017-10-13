/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;


public class Discipline  {
    
     private int Discipline_id;
    private String Discipline_name;
    private Integer Number_of_hours;
 
   

    public Discipline(int Discipline_id,  String Discipline_name, Integer Number_of_hours) {
        this.Discipline_id = Discipline_id;
        this.Discipline_name = Discipline_name;
        this.Number_of_hours=Number_of_hours;
        
    }

   // @OverrDiscipline_ide
    //public String toString() {
    //    return getFullDiscipline_name();
   // }

    public int getId() {
        return Discipline_id;
    }

    public void setId(int Discipline_id) {
        this.Discipline_id = Discipline_id;
    }

    public String getDiscipline_name() {
        return Discipline_name;
    }

    public void setDiscipline_name(String Discipline_name) {
        this.Discipline_name = Discipline_name;
    }

     
    public Integer getNumber_of_hours() {
        return Number_of_hours;
    }

    public void setNumber_of_hours(Integer Number_of_hours) {
        this.Number_of_hours = Number_of_hours;
    }
    
   
    @Override
    public String toString() {
        return Discipline_name;
    }
 
 public String getFullInfo() {
        return Discipline_name + " " + Number_of_hours;
    }
  
}
