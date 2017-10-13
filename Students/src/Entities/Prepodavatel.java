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
public class Prepodavatel  {
    
    private int pid;
    private String Surname;
//    private String Name;
//    private String Patronymic;
    private String Telephone;
    private String Adress;
    private int FacultetId;
   

    public Prepodavatel(int pid, String Surname, 
            String Telephone,String Adress,int FacultetId) {
        this.pid = pid;
        this.Surname=Surname;
//        this.Name = Name;
//        this.Patronymic = Patronymic;
        this.Telephone=Telephone;
        this.Adress=Adress;
        this.FacultetId=FacultetId;
        
    }

   // @Override
    //public String toString() {
    //    return getFullName();
   // }

    public int getId() {
        return pid;
    }

    public void setId(int pid) {
        this.pid = pid;
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
    
     public String getAdress()
    {
        return Adress;
    }
            
    public void setAdress(String Adress)
    {
        this.Adress=Adress;
    }
    
     public int getFacultetId() {
        return FacultetId;
    }

    public void setFacultetId(int FacultetId) {
        this.FacultetId = FacultetId;
    }
 public String getFullInfo() {
        return Surname + " "  + Telephone + " "
                + Adress + " " + FacultetId ;
    }
 @Override
    public String toString() {
        return Surname;
    }
}
