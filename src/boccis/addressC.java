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
public class addressC {
    private String address;
    private String city;
    private String state;
    private String zipcode;
    
    public void setAD(String sValue){
        this.address = sValue;
    }
    public String getAD(){
        return this.address;
    }
    public void setCY(String sValue){
        this.city = sValue;
    }
    public String getCY(){
        return this.city;
    }
    public void setST(String sValue){
        this.state = sValue;
    }
    public String getST(){
        return this.state;
    }
    public void setZC(String sValue){
        this.zipcode = sValue;
    }
    public String getZC(){
        return this.zipcode;
    }
    public String getCompleteAddress(){
        return this.address + "\n"
              +this.city+", "+this.state+" "+this.zipcode;
    }
}
