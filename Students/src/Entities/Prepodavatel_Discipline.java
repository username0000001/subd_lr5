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
public class Prepodavatel_Discipline {
    
    private int id;
    private int PrepodavatelId;
    private int DisciplineId;
   private String PrepodName;
   

    public Prepodavatel_Discipline(int id, int PrepodavatelId, int DisciplineId) {
        this.id = id;
        this.PrepodavatelId = PrepodavatelId;
        this.DisciplineId = DisciplineId;
       this.PrepodName=PrepodName;
             
    }

   // @Override
    //public String toString() {
    //    return getFullName();
   // }
public String getPrepodName(){
    return PrepodName;
}
public void set(String PrepodName) {
        this.PrepodName = PrepodName;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

 
    public int getPrepodavatelId() {
        return PrepodavatelId;
    }

    public void setPrepodavatelId(int PrepodavatelId) {
        this.PrepodavatelId = PrepodavatelId;
    }
    
    public int getDisciplineId() {
        return DisciplineId;
    }

    public void setDisciplineId(int DisciplineId) {
        this.DisciplineId = DisciplineId;
    }
            

 public String getFullInfo() {
        return PrepodavatelId + " " + DisciplineId;
    }
 @Override
    public String toString() {
        return Integer.toString(id);
    }
 
    
}
