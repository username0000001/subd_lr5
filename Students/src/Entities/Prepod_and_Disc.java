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
public class Prepod_and_Disc {
    private int id;
    private String P_and_D;
    
   

    public Prepod_and_Disc(int id, String P_and_D ) {
        this.id = id;
        this.P_and_D = P_and_D;
       
        
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

    public String getP_and_D() {
        return P_and_D;
    }

    public void setP_and_D(String P_and_D) {
        this.P_and_D = P_and_D;
    }

    

 public String getFullInfo() {
        return P_and_D + " " + P_and_D;
    }
    @Override
    public String toString() {
        return P_and_D;
    }

    
}
