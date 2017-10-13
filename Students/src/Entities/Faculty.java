package Entities;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author user
 */
public class Faculty {
    
    private int Faculty_id;
    private String Faculty_name;
    private String Dean;
   

    public Faculty(int Faculty_id, String Faculty_name, String Dean) {
        this.Faculty_id = Faculty_id;
        this.Faculty_name = Faculty_name;
        this.Dean = Dean;
        
    }

   // @Override
    //public String toString() {
    //    return getFullFaculty_name();
   // }

    public int getId() {
        return Faculty_id;
    }

    public void setId(int Faculty_id) {
        this.Faculty_id = Faculty_id;
    }

    public String getFaculty_name() {
        return Faculty_name;
    }

    public void setFaculty_name(String Faculty_name) {
        this.Faculty_name = Faculty_name;
    }

    public String getDean() {
        return Dean;
    }

    public void setDean(String Dean) {
        this.Dean = Dean;
    }

 public String getFullInfo() {
        return Faculty_name + " " + Dean;
    }
    @Override
    public String toString() {
        return Faculty_name;
    }

}
