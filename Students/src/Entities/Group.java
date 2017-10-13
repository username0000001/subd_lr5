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
public class Group  {
    
    private int Group_id;
    private String Group_name;
    private int Faculty_id;
    
   

    public Group(int Group_id, String Group_name, int Faculty_id) {
        this.Group_id = Group_id;
        this.Group_name = Group_name;
        this.Faculty_id = Faculty_id;
        
        
    }

   // @OverrGroup_ide
    //public String toString() {
    //    return getFullName();
   // }

    public int getId() {
        return Group_id;
    }

    public void setId(int Group_id) {
        this.Group_id = Group_id;
    }

    public String getName() {
        return Group_name;
    }

    public void setName(String Name) {
        this.Group_name = Group_name;
    }

    public int getFacultyId() {
        return Faculty_id;
    }

    public void setFacultyId(int FacultyId) {
        this.Faculty_id = Faculty_id;
    }

 public String getFullInfo() {
        return Group_name + " " + Faculty_id;
    }
@Override
    public String toString() {
        return Group_name;
    }
}
