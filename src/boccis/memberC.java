/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boccis;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tommybennett
 */
public class memberC {
    methodC mc = new methodC();
    dataC dc = new dataC();
    
    private int member_id;
    private String member_firstname;
    private String member_middlename;
    private String member_lastname;
    private String member_address;
    private String member_city;
    private String member_state;
    private String member_zipcode;
    private String member_email;
    private String member_homephone;
    private String member_workphone;
    private String member_cellphone;
    private String member_joindate;
    private String member_birthdate;
    private String member_wedding;
    // Need setters and getters
    private String member_baptized;
    private String member_shared;
    private String member_saved;
    private String member_status;
    
    public void setID(int iValue){
        this.member_id = iValue;
    }
    public int getID(){
        return this.member_id;
    }
    public void setFN(String sValue){
        this.member_firstname = sValue;
    }
    public String getFN(){
        return this.member_firstname;
    }
    public void setMN(String sValue){
        this.member_middlename = sValue;
    }
    public String getMN(){
        return this.member_middlename;
    }
    public void setLN(String sValue){
        this.member_lastname = sValue;
    }
    public String getLN(){
        return this.member_lastname;
    }
    public void setSA(String sValue){
        this.member_address = sValue;
    }
    public String getSA(){
        return this.member_address;
    }
    public void setCY(String sValue){
        this.member_city = sValue;
    }
    public String getCY(){
        return this.member_city;
    }
    public void setST(String sValue){
        this.member_state = sValue;
    }
    public String getST(){
        return this.member_state;
    }
    public void setZC(String sValue){
        this.member_zipcode = sValue;
    }
    public String getZC(){
        return this.member_zipcode;
    }
    public void setEM(String sValue){
        this.member_email = sValue;
    }
    public String getEM(){
        return this.member_email;
    }
    public void setHP(String sValue){
        this.member_homephone = sValue;
    }
    public String getHP(){
        return this.member_homephone;
    }
    public void setWP(String sValue){
        this.member_workphone = sValue;
    }
    public String getWP(){
        return this.member_workphone;
    }
    public void setCP(String sValue){
        this.member_cellphone = sValue;
    }
    public String getCP(){
        return this.member_cellphone;
    }
    public void setJD(String sValue){
        this.member_joindate = sValue;
    }
    public String getJD(){
        return this.member_joindate;
    }
    public void setBD(String sValue){
        this.member_birthdate = sValue;
    }
    public String getBD(){
        return this.member_birthdate;
    }
    public void setWD(String sValue){
        this.member_wedding = sValue;
    }
    public String getWD(){
        return this.member_wedding;
    }
    public void setSaved(String sValue){
        this.member_saved = sValue;
    }
    public String getSaved(){
        return this.member_saved;
    }
    public void setBaptized(String sValue){
        this.member_baptized = sValue;
    }
    public String getBaptized(){
        return this.member_baptized;
    }    
    public void setShared(String sValue){
        this.member_shared = sValue;
    }
    public String getShared(){
        return this.member_shared;
    }    
    public String blankValue(){
        return "";
    }  
    public String getMemberInfo(){
        return this.member_id + " : " + this.getFullName();
    }
    public String getFullName(){
        String sValue;
        if(!this.member_firstname.trim().isEmpty() && 
           !this.member_middlename.trim().isEmpty() &&
           !this.member_lastname.trim().isEmpty()){
            sValue = this.member_firstname.trim() + " " + this.member_middlename.trim().substring(0, 1) + " " + this.member_lastname.trim();
        } else {
            sValue = this.member_firstname.trim() + " " + this.member_lastname.trim();
        }
        return sValue;        
    }
    public boolean saveMember(){
        boolean isSaved = false;
        mc.outputBox("Saving Member " + this.getMemberInfo() + "...");
        try {
            Statement stmt;
            dataC dc = new dataC();
            try (Connection conn = dc.connectDB()) {
                stmt = conn.createStatement();
                String sql = "INSERT INTO member_tbl (member_fname,"
                        + "member_mname,member_lname,member_address,"
                        + "member_city,member_state,member_zipcode,member_email,"
                        + "member_hphone,member_wphone,member_cphone,"
                        + "member_dob,member_wed,member_saved,member_baptized,"
                        + "member_shared,member_joined,member_status) "
                        + "VALUES ('"+this.member_firstname
                        + "','"+this.member_middlename+"','"+this.member_lastname
                        + "','"+this.member_address+"','"+this.member_city
                        + "','"+this.member_state+"','"+this.member_zipcode
                        + "','"+this.member_email+"','"+this.member_homephone
                        + "','"+this.member_workphone+"','"+this.member_cellphone
                        + "','"+this.member_birthdate+ "','"+this.member_wedding
                        + "','"+this.member_saved+"','"+this.member_baptized
                        + "','"+this.member_shared+ "','"+this.member_joindate
                        + "','A'"
                        + ");";
                mc.outputBox(sql);
                stmt.executeUpdate(sql);
                isSaved = true;
                mc.outputBox("Member "+ this.getMemberInfo() + " successfully saved...");
            }
            //mc.outputBox("Database closed...");
        } catch (SQLException ex) {
            Logger.getLogger(memberC.class.getName()).log(Level.SEVERE, null, ex);
        }              
        return isSaved;
    }
    public boolean updateMember(int iValue){
        boolean isUpdated = false;
        mc.outputBox("Updating Member : " + this.getMemberInfo());
        try {
            Statement stmt;
            dataC dc = new dataC();
            try (Connection conn = dc.connectDB()) {
                stmt = conn.createStatement();
                String sql = "UPDATE member_tbl SET " +
                        "member_id = " + this.member_id +
                        ", member_fname = '" + this.member_firstname +
                        "', member_mname = '" + this.member_middlename +
                        "', member_lname = '" + this.member_lastname +
                        "', member_address = '" + this.member_address +
                        "', member_city = '" + this.member_city +
                        "', member_state = '" + this.member_state +
                        "', member_zipcode = '" + this.member_zipcode +
                        "', member_email = '" + this.member_email +
                        "', member_hphone = '" + this.member_homephone +
                        "', member_wphone = '" + this.member_workphone +
                        "', member_cphone = '" + this.member_cellphone +
                        "', member_joined = '" + this.member_joindate +
                        "', member_wed = '" + this.member_wedding +
                        "', member_dob = '" + this.member_birthdate +
                        "', member_saved = '" + this.member_saved +
                        "', member_baptized = '" + this.member_baptized +
                        "', member_shared = '" + this.member_shared +                        
                        "', member_status = '" + this.member_status +
                        "' WHERE member_id = " + iValue;
                mc.outputBox(sql);
                stmt.executeUpdate(sql);
                
                mc.outputBox("Member " + this.getMemberInfo() + " successfully updated...");
            }
            //mc.outputBox("Database closed...");
        } catch (SQLException ex) {
            Logger.getLogger(memberC.class.getName()).log(Level.SEVERE, null, ex);
        }               
        return isUpdated;
    }
    public boolean deleteMember(int iValue, String sValue){
        boolean isDeleted = false;
        mc.outputBox("De-Activating/Activating Member : " + this.getMemberInfo());
        try {
            Statement stmt;
            dataC dc = new dataC();
            try (Connection conn = dc.connectDB()) {
                stmt = conn.createStatement();
                String sql = "UPDATE member_tbl SET " +
                        "member_status = '"+ sValue +"'" +
                        " WHERE member_id = " + iValue;
                mc.outputBox(sql);
                stmt.executeUpdate(sql);
                isDeleted = true;
                mc.outputBox("Member " + this.getMemberInfo() + " successfully de-activated/activated...");
            }
            //mc.outputBox("Database closed...");
        } catch (SQLException ex) {
            Logger.getLogger(memberC.class.getName()).log(Level.SEVERE, null, ex);
        }              
        return isDeleted;
    }
    public boolean findMember(int iValue){
        boolean isFound = false;
        try {
            try (Connection conn = dc.connectDB()) {
                Statement stmt = conn.createStatement();
                String sql = "SELECT * FROM member_tbl WHERE member_id="+iValue;
                ResultSet rs = stmt.executeQuery(sql);
                
                this.member_id = rs.getInt("member_id");
                this.member_firstname = rs.getString("member_firstname");
                this.member_middlename = rs.getString("member_middlename");
                this.member_lastname = rs.getString("member_lastname");
                this.member_address = rs.getString("member_address");
                this.member_city = rs.getString("member_city");
                this.member_state = rs.getString("member_state");
                this.member_zipcode = rs.getString("member_zipcode");
                this.member_email = rs.getString("member_email");
                this.member_homephone = rs.getString("member_homephone");
                this.member_workphone = rs.getString("member_workphone");
                this.member_cellphone = rs.getString("member_cellphone");
                this.member_joindate = rs.getString("member_joined");
                this.member_birthdate = rs.getString("member_dob");
                this.member_wedding = rs.getString("member_wed");
                this.member_saved = rs.getString("member_saved");
                this.member_baptized = rs.getString("member_baptized");
                this.member_shared = rs.getString("member_shared");                
                this.member_status = rs.getString("member_status");
                
                mc.outputBox("Member ID: " + iValue + " - " +
                              this.getMemberInfo());
                isFound = true;
                mc.outputBox("Find Member " + this.getMemberInfo() + " query successfully ran...");
            }
            //System.out.println("Database closed...");
        } catch (SQLException ex) {
            Logger.getLogger(memberC.class.getName()).log(Level.SEVERE, null, ex);
        }             
        return isFound;
    }
    public void loadMember(){
        
    }
}
