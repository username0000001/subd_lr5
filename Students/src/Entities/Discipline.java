/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;


public class Discipline  {
    
     private int id;
    private String Name;
    private Integer Number_of_hours;
 
   

    public Discipline(int id,  String Name, Integer Number_of_hours) {
        this.id = id;
        this.Name = Name;
        this.Number_of_hours=Number_of_hours;
        
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

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

     
    public Integer getNumber_of_hours() {
        return Number_of_hours;
    }

    public void setNumber_of_hours(Integer Number_of_hours) {
        this.Number_of_hours = Number_of_hours;
    }
    
   
    @Override
    public String toString() {
        return Name;
    }
 
 public String getFullInfo() {
        return Name + " " + Number_of_hours;
    }
  
}
