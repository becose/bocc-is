/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boccis;

/**
 *
 * @author tommybennett
 */
public class memberC {
    methodC mc = new methodC();
    dataC dc = new dataC();
    
    private int member_id;
    private String member_fname;
    private String member_mname;
    private String member_lname;
    private String member_address;
    private String member_city;
    private String member_state;
    private String member_zipcode;
    private String member_email;
    private String member_hphone;
    private String member_wphone;
    private String member_cphone;
    private String member_joined;
    private String member_dob;
    
    public void setID(int iValue){
        this.member_id = iValue;
    }
    public int getID(){
        return this.member_id;
    }
    public void setFN(String sValue){
        this.member_fname = sValue;
    }
    public String getFN(){
        return this.member_fname;
    }
    public void setMN(String sValue){
        this.member_mname = sValue;
    }
    public String getMN(){
        return this.member_mname;
    }
    public void setLN(String sValue){
        this.member_lname = sValue;
    }
    public String getLN(){
        return this.member_lname;
    }
    public void setAD(String sValue){
        this.member_address = sValue;
    }
    public String getAD(){
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
        this.member_hphone = sValue;
    }
    public String getHP(){
        return this.member_hphone;
    }
    public void setWP(String sValue){
        this.member_wphone = sValue;
    }
    public String getWP(){
        return this.member_wphone;
    }
    public void setCP(String sValue){
        this.member_cphone = sValue;
    }
    public String getCP(){
        return this.member_cphone;
    }
    public void setJD(String sValue){
        this.member_joined = sValue;
    }
    public String getJD(){
        return this.member_joined;
    }
    public void setBD(String sValue){
        this.member_dob = sValue;
    }
    public String getBD(){
        return this.member_dob;
    }
    public String blankValue(){
        return "";
    }  
    public boolean saveMember(){
        return true;
    }
    public boolean deleteMember(int iValue){
        return true;
    }
    public boolean findMember(int iValue){
        return true;
    }
}
