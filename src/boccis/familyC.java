/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boccis;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tommybennett
 */
public class familyC {
    addressC ac = new addressC();
    memberC mc = new memberC();
    methodC mmc = new methodC();
    //dataC dc = new dataC();
    
    private int family_id;
    private int member_id;
    private int connected_id;
    private int relation_id;
    private String family_date;
    
    public void setFI(int iValue){
        this.family_id = iValue;
    }
    public int getFI(){
        return this.family_id;
    }
    public void setMI(int iValue){
        this.member_id = iValue;
    }
    public int getMI(){
        return this.member_id;
    }
    public void setCI(int iValue){
        this.connected_id = iValue;
    }
    public int getCI(){
        return this.connected_id;
    }
    public void setRI(int iValue){
        this.relation_id = iValue;
    }
    public int getRI(){
        return this.relation_id;
    }
    public void setDT(String sValue){
        this.family_date = sValue;
    }
    public String getDT(){
        return this.family_date;
    }
    public boolean linkFamily(){
        boolean isSaved = false;
        mmc.outputBox("Linking Members ...");
        try {
            Statement stmt;
            dataC dc = new dataC();
            try (Connection conn = dc.connectDB()) {
                stmt = conn.createStatement();
                String sql = "INSERT INTO family_tbl (family_member_id,"
                        + "family_connected_id,family_relation_id,family_date) "
                        + "VALUES ("+this.member_id+","+this.connected_id
                        + ","+this.relation_id+",'"+this.family_date
                        + "');";
                mmc.outputBox(sql);
                stmt.executeUpdate(sql);
                isSaved = true;
                //mmc.outputBox("Member "+ this.getMemberInfo() + " successfully saved...");
            }
            //mmc.outputBox("Database closed...");
        } catch (SQLException ex) {
            Logger.getLogger(familyC.class.getName()).log(Level.SEVERE, null, ex);
        }              
        return isSaved;
    }
    public boolean deleteFamily(int iValue){
        return true;
    }
    public boolean findFamily(int iValue){
        return true;
    }
    public String getMemberName(int iValue){
        mc.findMember(iValue);
        return mc.getFullName();
    }
}
