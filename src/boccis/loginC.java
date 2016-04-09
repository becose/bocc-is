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
    
    private String sUsername;
    private String sPassword;
    //private boolean loginOK = false;
    
    public void setUN(String sValue){
        this.sUsername = sValue;
    }
    public void setPW(String sValue){
        this.sPassword = sValue;
    }
    public boolean checkLogin(){
        boolean loginOK = false;
        boolean isFound = false;
        try {
            try (Connection conn = dc.connectDB()) {
                Statement stmt = conn.createStatement();
                String sql = "SELECT * FROM user_tbl WHERE user_name='"+this.sUsername+
                                                "' AND user_password='"+this.sPassword+"'";
                                                                       
                ResultSet rs = stmt.executeQuery(sql);
                
                rs.next();
                //this.member_id = rs.getInt("member_id");
                //this.member_firstname = rs.getString("member_firstname");
                
                loginOK = true;
                mc.outputBox("Login Succesful...");
            }
            //System.out.println("Database closed...");
        } catch (SQLException ex) {
            Logger.getLogger(memberC.class.getName()).log(Level.SEVERE, null, ex);
        }                     
        return loginOK;
    }
}
