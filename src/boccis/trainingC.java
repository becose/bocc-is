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
public class trainingC {
    methodC mmc = new methodC();
    dataC dc = new dataC();

    private int training_id;
    private int training_member_id;
    private String training_date;
    
    public void setTI(int iValue){
        this.training_id = iValue;
    }
    public int getTI(){
        return this.training_id;
    }
    public void setMI(int iValue){
        this.training_member_id = iValue;
    }
    public int getMI(){
        return this.training_member_id;
    }
    public void setTD(String sValue){
        this.training_date = sValue;
    }
    public String getTD(){
        return this.training_date;
    }
    public boolean saveTraining(){
        boolean isSaved = false;
        //mmc.outputBox("Linking Members ...");
        try {
            Statement stmt;
            try (Connection conn = dc.connectDB()) {
                stmt = conn.createStatement();
                String sql = "INSERT INTO training_tbl (training_member_id,"
                        + "training_date) "
                        + "VALUES ("+this.training_member_id+",'"+this.training_date
                        + "');";
                mmc.outputBox(sql);
                stmt.executeUpdate(sql);
                isSaved = true;
                //mmc.outputBox("Member "+ this.getMemberInfo() + " successfully saved...");
            }
            //mmc.outputBox("Database closed...");
        } catch (SQLException ex) {
            Logger.getLogger(trainingC.class.getName()).log(Level.SEVERE, null, ex);
        }       
       
       return isSaved;
   }
   public ResultSet getTrainingDates() throws SQLException{
        Connection conn;
        Statement stmt;
        ResultSet rs;
        //dataC mdc = new dataC();
        conn = dc.connectDB();
        stmt = conn.createStatement();     
        String sql = "SELECT DISTINCT training_date FROM training_tbl";

        rs = stmt.executeQuery(sql);
      
        return rs;        
   }
   public ResultSet getMembersNeedingClass() throws SQLException{
        Connection conn;
        Statement stmt;
        ResultSet rs;
        //dataC mdc = new dataC();
        conn = dc.connectDB();
        stmt = conn.createStatement();     
        String sql = "SELECT member_id AS MemberID, member_fullname AS Member "
                   + "FROM member_tbl "
                   + "WHERE member_classdate='' OR member_classdate IS NULL";            
        rs = stmt.executeQuery(sql);
      
        return rs;      
    }   
   public ResultSet getClassList4Table() throws SQLException{
        Connection conn;
        Statement stmt;
        ResultSet rs;
        //dataC mdc = new dataC();
        conn = dc.connectDB();
        stmt = conn.createStatement();     
        String sql = "SELECT t.training_member_id AS MemberID, m.member_fullname AS Member "
                   + "FROM training_tbl t "
                   + "JOIN member_tbl m ON t.training_member_id=m.member_id " 
                   + "GROUP BY t.training_date";            
        rs = stmt.executeQuery(sql);
      
        return rs;        
   }       
   public ResultSet getMembersByTrainingDate(String sValue) throws SQLException{
        Connection conn;
        Statement stmt;
        ResultSet rs;
        //dataC mdc = new dataC();
        conn = dc.connectDB();
        stmt = conn.createStatement();     
        String sql = "SELECT t.training_member_id AS MemberID, m.member_fullname AS Member "
                   + "FROM training_tbl t "
                   + "JOIN member_tbl m ON t.training_member_id=m.member_id "
                   + "WHERE training_date='"+sValue+"'";    
        mmc.outputBox(sql);
        rs = stmt.executeQuery(sql);
      
        return rs;            
   }
}
