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
public class loginC {
    dataC dc = new dataC();
    methodC mc = new methodC();
    
    private String user_name;
    private char[] user_password;
    //private boolean loginOK = false;
    
    public void setUN(String sValue){
        this.user_name = sValue;
    }
    public void setPW(char[] cValue){
        this.user_password = cValue;
    }
    public String getUN(){
        return this.user_name;
    }
    public String getPW(){
        String sPass = new String(this.user_password);
        return sPass;
    }
    public boolean checkLogin(){
        boolean loginOK = false;
        boolean isFound = false;
        System.out.println("Checking login.....");
        try {
            try (Connection conn = dc.connectDB()) {
                Statement stmt = conn.createStatement();
                String sql = "SELECT * FROM user_tbl WHERE user_name='"+this.user_name+
                                                "' AND user_password='"+this.getPW()+"'";
                                                                       
                ResultSet rs = stmt.executeQuery(sql);
                
                if(rs.next()){
                    loginOK = true;
                    isFound = true;
                    mc.outputBox("Login Succesful...");
                    this.user_name = rs.getString("user_name");
                    this.user_password = rs.getString("user_password").toCharArray();                    
                }                               
            }
            //System.out.println("Database closed...");
        } catch (SQLException ex) {
            Logger.getLogger(memberC.class.getName()).log(Level.SEVERE, null, ex);
        }                     
        return loginOK;
    }
}
