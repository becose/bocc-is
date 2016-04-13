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
public class familyC {
    methodC mc = new methodC();
    dataC dc = new dataC();
    
    private int family_id;
    private int member_id;
    private int link_id;
    
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
    public void setLI(int iValue){
        this.link_id = iValue;
    }
    public int getLI(){
        return this.link_id;
    }
    public boolean linkFamily(){
        return true;
    }
    public boolean deleteFamily(int iValue){
        return true;
    }
    public boolean findFamily(int iValue){
        return true;
    }
}
