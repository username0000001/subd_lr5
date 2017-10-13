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
public class Teacher  {
    
    private int Teacher_id;
    private String Surname;
//    private String Name;
//    private String Patronymic;
    private String Telephone;
    private String Address;
    private int Faculty_id;
   

    public Teacher(int Teacher_id, String Surname, 
            String Telephone,String Address,int Faculty_Id) {
        this.Teacher_id = Teacher_id;
        this.Surname=Surname;
//        this.Name = Name;
//        this.Patronymic = Patronymic;
        this.Telephone=Telephone;
        this.Address=Address;
        this.Faculty_id=Faculty_Id;
        
    }

   

    public int getId() {
        return Teacher_id;
    }

    public void setId(int Teacher_id) {
        this.Teacher_id = Teacher_id;
    }
    public String getSurname()
    {
        return Surname;
    }
            
    public void setSurname(String Surname)
    {
        this.Surname=Surname;
    }

//     public String getName()
//    {
//        return Name;
//    }
//            
//    public void setName(String Name)
//    {
//        this.Name=Name;
//    }
//    
//     public String getPatronymic()
//    {
//        return Patronymic;
//    }
//            
//    public void setPatronymic(String Patronymic)
//    {
//        this.Patronymic=Patronymic;
//    }

    
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
    
     public int getFaculty_id() {
        return Faculty_id;
    }

    public void setFaculty_id(int Faculty_id) {
        this.Faculty_id = Faculty_id;
    }
 public String getFullInfo() {
        return Surname + " "  + Telephone + " "
                + Address + " " + Faculty_id ;
    }
 @Override
    public String toString() {
        return Surname;
    }
}
