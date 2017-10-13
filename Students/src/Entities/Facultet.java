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
public class Facultet {
    
    private int fid;
    private String Name;
    private String Dekan;
   

    public Facultet(int fid, String Name, String Dekan) {
        this.fid = fid;
        this.Name = Name;
        this.Dekan = Dekan;
        
    }

   // @Override
    //public String toString() {
    //    return getFullName();
   // }

    public int getId() {
        return fid;
    }

    public void setId(int fid) {
        this.fid = fid;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getDekan() {
        return Dekan;
    }

    public void setDekan(String Dekan) {
        this.Dekan = Dekan;
    }

 public String getFullInfo() {
        return Name + " " + Dekan;
    }
    @Override
    public String toString() {
        return Name;
    }

}
