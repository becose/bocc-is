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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tommybennett
 */
public class baptismC {
    memberC mc = new memberC();
    methodC mmc = new methodC();
    dataC dc = new dataC();

    private int baptism_id;
    private int baptism_member_id;
    private String baptism_date;
    
    public void setBI(int iValue){
        this.baptism_id = iValue;
    }
    public int getBI(){
        return this.baptism_id;
    }
    public void setMI(int iValue){
        this.baptism_member_id = iValue;
    }
    public int getMI(){
        return this.baptism_member_id;
    }
    public void setBD(String sValue){
        this.baptism_date = sValue;
    }
    public String getBD(){
        return this.baptism_date;
    }
    public boolean scheduleBaptism(){
        boolean isSaved = false;
        //mmc.outputBox("Linking Members ...");
        try {
            Statement stmt;
            try (Connection conn = dc.connectDB()) {
                stmt = conn.createStatement();
                String sql = "INSERT INTO baptism_tbl (baptism_member_id,"
                        + "baptism_date) "
                        + "VALUES ("+this.baptism_member_id+",'"+this.baptism_date
                        + "');";
                mmc.outputBox(sql);
                stmt.executeUpdate(sql);
                isSaved = true;
                //mmc.outputBox("Member "+ this.getMemberInfo() + " successfully saved...");
            }
            //mmc.outputBox("Database closed...");
        } catch (SQLException ex) {
            Logger.getLogger(baptismC.class.getName()).log(Level.SEVERE, null, ex);
        }         
        return isSaved;
    }
    public void confirmBaptism(String sValue) throws SQLException{
        mmc.messageBox(sValue);

        ResultSet rs = this.getBaptismByDate(sValue);
        ArrayList<Integer> alMember = new ArrayList<>();
        
        while(rs.next()){
            alMember.add(rs.getInt("MemberID"));
        }
        //mmc.messageBox("Count "+ alMember.size());
        
        for(int iMember : alMember){
            mc.findMember(iMember);
            mc.setCD(sValue);
            mc.confirmMemberBaptism(iMember);
        }        
    }
    public ResultSet getBaptismDates() throws SQLException{
        Connection conn;
        Statement stmt;
        ResultSet rs;
        //dataC mdc = new dataC();
        conn = dc.connectDB();
        stmt = conn.createStatement();     
        String sql = "SELECT DISTINCT baptism_date FROM baptism_tbl";

        rs = stmt.executeQuery(sql);
      
        return rs;          
    }
    public ResultSet getMembersNeedingBaptism() throws SQLException{
        Connection conn;
        Statement stmt;
        ResultSet rs;
        //dataC mdc = new dataC();
        conn = dc.connectDB();
        stmt = conn.createStatement();     
        String sql = "SELECT member_id AS MemberID, member_fullname AS Member "
                   + "FROM member_tbl "
                   + "WHERE member_baptized='N' OR member_baptized IS NULL"; 
        //mmc.outputBox(sql);        
        rs = stmt.executeQuery(sql);
      
        return rs;          
    }
    public ResultSet getBaptismList4Table() throws SQLException{
        Connection conn;
        Statement stmt;
        ResultSet rs;
        //dataC mdc = new dataC();
        conn = dc.connectDB();
        stmt = conn.createStatement();     
        String sql = "SELECT b.baptism_member_id AS MemberID, m.member_fullname AS Member "
                   + "FROM baptism_tbl b "
                   + "JOIN member_tbl m ON b.baptism_member_id=m.member_id " 
                   + "GROUP BY b.baptism_date"; 
        //mmc.outputBox(sql);        
        rs = stmt.executeQuery(sql);
      
        return rs;             
    }
   public ResultSet getBaptismByDate(String sValue) throws SQLException{
        Connection conn;
        Statement stmt;
        ResultSet rs;
        //dataC mdc = new dataC();
        conn = dc.connectDB();
        stmt = conn.createStatement();     
        String sql = "SELECT b.baptism_member_id AS MemberID, m.member_fullname AS Member "
                   + "FROM baptism_tbl b "
                   + "JOIN member_tbl m ON b.baptism_member_id=m.member_id "
                   + "WHERE baptism_date='"+sValue+"'";    
        //mmc.outputBox(sql);
        rs = stmt.executeQuery(sql);
      
        return rs;            
   }    
}
