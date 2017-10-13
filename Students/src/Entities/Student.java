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
public class Student {
    private int id;
    private String Surname;
    private String Telephone;
    private String Adress;
    private String Telephone_of_parents;
    private int GruppaId;
   

    public Student(int id, String Surname, 
            String Telephone,String Adress, String Telephone_of_parents, int GruppaId) {
        this.id = id;
        this.Surname=Surname;
        this.Telephone=Telephone;
        this.Adress=Adress;
        this.Telephone_of_parents=Telephone_of_parents;
        this.GruppaId=GruppaId;
        
    }

    @Override
    public String toString() {
        return Surname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getSurname()
    {
        return Surname;
    }
            
    public void setSurname(String Surname)
    {
        this.Surname=Surname;
    }

    
     public String getTelephone()
    {
        return Telephone;
    }
            
    public void setTelephone(String Telephone)
    {
        this.Telephone=Telephone;
    }
    
     public String getAdress()
    {
        return Adress;
    }
            
    public void setAdress(String Adress)
    {
        this.Adress=Adress;
    }
    
    public String getTelephone_of_parents()
    {
        return Telephone_of_parents;
    }
    
    public void setTelephone_of_parents(String Telephone_of_parents)
    {
        this.Telephone_of_parents=Telephone_of_parents;
    }
    
     public int getGruppaId() {
        return GruppaId;
    }

    public void setGruppaId(int GruppaId) {
        this.GruppaId = GruppaId;
    }
 public String getFullInfo() {
        return Surname + " "  + Telephone + " "
                + Adress + " " + Telephone_of_parents + " " +  GruppaId ;
    }
    
}
