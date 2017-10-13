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
    private int Student_id;
    private String Surname;
    private String Telephone;
    private String Address;
    private String Telephone_of_parents;
    private int Group_id;
   

    public Student(int Student_id, String Surname, 
            String Telephone,String Address, String Telephone_of_parents, int Group_id) {
        this.Student_id = Student_id;
        this.Surname=Surname;
        this.Telephone=Telephone;
        this.Address=Address;
        this.Telephone_of_parents=Telephone_of_parents;
        this.Group_id=Group_id;
        
    }

    @Override
    public String toString() {
        return Surname;
    }

    public int getId() {
        return Student_id;
    }

    public void setId(int Student_id) {
        this.Student_id = Student_id;
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
    
     public String getAddress()
    {
        return Address;
    }
            
    public void setAddress(String Address)
    {
        this.Address=Address;
    }
    
    public String getTelephone_of_parents()
    {
        return Telephone_of_parents;
    }
    
    public void setTelephone_of_parents(String Telephone_of_parents)
    {
        this.Telephone_of_parents=Telephone_of_parents;
    }
    
     public int getGroup_id() {
        return Group_id;
    }

    public void setGroup_id(int Group_id) {
        this.Group_id = Group_id;
    }
 public String getFullInfo() {
        return Surname + " "  + Telephone + " "
                + Address + " " + Telephone_of_parents + " " +  Group_id ;
    }
    
}
