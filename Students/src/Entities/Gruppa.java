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
public class Gruppa  {
    
    private int id;
    private String name;
    private int fid;
    
   

    public Gruppa(int id, String name, int fid) {
        this.id = id;
        this.name = name;
        this.fid = fid;
        
        
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
        return name;
    }

    public void setName(String Name) {
        this.name = name;
    }

    public int getFacultetId() {
        return fid;
    }

    public void setFacultetId(int FacultetId) {
        this.fid = fid;
    }

 public String getFullInfo() {
        return name + " " + fid;
    }
@Override
    public String toString() {
        return name;
    }
}
