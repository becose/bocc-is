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
    //familyC fc = new familyC();
    methodC mmc = new methodC();
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
    private String member_classdate;
    
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
    public void setCD(String sValue){
        this.member_classdate = sValue;
    }
    public String getCD(){
        return this.member_classdate;
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
        mmc.outputBox("Saving Member " + this.getMemberInfo() + "...");
        try {
            Statement stmt;
            //dataC dc = new dataC();
            try (Connection conn = dc.connectDB()) {
                stmt = conn.createStatement();
                String sql = "INSERT INTO member_tbl (member_fname,"
                        + "member_mname,member_lname,member_address,"
                        + "member_city,member_state,member_zipcode,member_email,"
                        + "member_hphone,member_wphone,member_cphone,"
                        + "member_dob,member_wed,member_saved,member_baptized,"
                        + "member_shared,member_joined,member_status,member_fullname) "
                        + "VALUES ('"+this.member_firstname
                        + "','"+this.member_middlename+"','"+this.member_lastname
                        + "','"+this.member_address+"','"+this.member_city
                        + "','"+this.member_state+"','"+this.member_zipcode
                        + "','"+this.member_email+"','"+this.member_homephone
                        + "','"+this.member_workphone+"','"+this.member_cellphone
                        + "','"+this.member_birthdate+ "','"+this.member_wedding
                        + "','"+this.member_saved+"','"+this.member_baptized
                        + "','"+this.member_shared+ "','"+this.member_joindate
                        + "','A','"+this.getFullName()
                        + "');";
                //mmc.outputBox(sql);
                stmt.executeUpdate(sql);
                isSaved = true;
                mmc.outputBox("Member "+ this.getMemberInfo() + " successfully saved...");
            }
            //mmc.outputBox("Database closed...");
        } catch (SQLException ex) {
            Logger.getLogger(memberC.class.getName()).log(Level.SEVERE, null, ex);
        }              
        return isSaved;
    }
    public boolean updateMember(int iValue){
        boolean isUpdated = false;
        mmc.outputBox("Updating Member : " + this.getMemberInfo());
        try {
            Statement stmt;
            //dataC dc = new dataC();
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
                        "', member_fullname = '" + this.getFullName() +
                        "', member_classdate = '" + this.member_classdate +
                        "' WHERE member_id = " + iValue;
                //mmc.outputBox(sql);
                stmt.executeUpdate(sql);
                
                mmc.outputBox("Member " + this.getMemberInfo() + " successfully updated...");
            }
            //mmc.outputBox("Database closed...");
        } catch (SQLException ex) {
            Logger.getLogger(memberC.class.getName()).log(Level.SEVERE, null, ex);
        }               
        return isUpdated;
    }
    public boolean deleteMember(int iValue, String sValue){
        boolean isDeleted = false;
        mmc.outputBox("De-Activating/Activating Member : " + this.getMemberInfo());
        try {
            Statement stmt;
            //dataC dc = new dataC();
            try (Connection conn = dc.connectDB()) {
                stmt = conn.createStatement();
                String sql = "UPDATE member_tbl SET " +
                        "member_status = '"+ sValue +"'" +
                        " WHERE member_id = " + iValue;
                //mmc.outputBox(sql);
                stmt.executeUpdate(sql);
                isDeleted = true;
                mmc.outputBox("Member " + this.getMemberInfo() + " successfully de-activated/activated...");
            }
            //mmc.outputBox("Database closed...");
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
                
                this.loadMember(rs);
                
                //mmc.outputBox("Member ID: " + iValue + " - " +
                //              this.getMemberInfo());
                isFound = true;
                mmc.outputBox("Call -> Find Member " + this.getMemberInfo() + " query successfully ran...");
            }
            //System.out.println("Database closed...");
        } catch (SQLException ex) {
            Logger.getLogger(memberC.class.getName()).log(Level.SEVERE, null, ex);
        }             
        return isFound;
    }
    public boolean check4Member(String sFValue, String sMValue, String sLValue){
        boolean isFound = false;
        try {
            try (Connection conn = dc.connectDB()) {
                Statement stmt = conn.createStatement();
                String sql = "SELECT * FROM member_tbl WHERE member_fname='"+sFValue
                        + "' AND member_mname='"+sMValue
                        + "' AND member_lname='"+sLValue+"'";
                ResultSet rs = stmt.executeQuery(sql);
                
                //this.loadMember(rs);
                
                //mmc.outputBox("Member ID: " + iValue + " - " +
                //              this.getMemberInfo());
                int iCount = 0;
                while(rs.next()){
                    iCount++;
                }
                if(iCount>0){
                    isFound = true;
                    mmc.outputBox("Call -> Find Member " + this.getMemberInfo() + " query successfully ran...");                    
                }

            }
            //System.out.println("Database closed...");
        } catch (SQLException ex) {
            Logger.getLogger(memberC.class.getName()).log(Level.SEVERE, null, ex);
        }             
        return isFound;
    }    
    public ResultSet getMembers() throws SQLException{
        Connection conn;
        Statement stmt;
        ResultSet rs;
        //dataC mdc = new dataC();
        conn = dc.connectDB();
        stmt = conn.createStatement();     
        String sql = "SELECT * FROM member_tbl WHERE member_status='A' ORDER BY member_joined";            
        rs = stmt.executeQuery(sql);
      
        return rs;      
    }
    public ResultSet getDeactivedMembers() throws SQLException{
        Connection conn;
        Statement stmt;
        ResultSet rs;
        //dataC mdc = new dataC();
        conn = dc.connectDB();
        stmt = conn.createStatement();     
        String sql = "SELECT * FROM member_tbl WHERE member_status='D'";            
        rs = stmt.executeQuery(sql);
      
        return rs;      
    }    
    public ResultSet getDeactived4Table() throws SQLException{
        Connection conn;
        Statement stmt;
        ResultSet rs;
        //dataC mdc = new dataC();
        conn = dc.connectDB();
        stmt = conn.createStatement();     
        String sql = "SELECT member_id AS MemberID, member_fullname AS Deactivated "
                   + "FROM member_tbl WHERE member_status='D'";            
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
                   + "WHERE member_classdate='' OR member_classdate IS NULL "
                   + "AND member_status='A'";            
        rs = stmt.executeQuery(sql);
      
        return rs;      
    }
    public ResultSet getFamily4Table(int iValue) throws SQLException{
        Connection conn;
        Statement stmt;
        ResultSet rs;
        conn = dc.connectDB();
        stmt = conn.createStatement();     
        String sql = "SELECT f.family_member_id AS MemberID, m.member_fullname AS MemberName, " +
                     "f.family_relation_name as Relation " +
                     "FROM family_tbl f " +
                     "JOIN member_tbl m ON f.family_member_id=m.member_id" +
                     " WHERE f.family_connected_id = " + iValue +
                     " AND member_status='A'";            
        rs = stmt.executeQuery(sql);
        
        return rs;        
    }
    public void loadMember(ResultSet rsValue) throws SQLException{
        this.member_id = rsValue.getInt("member_id");
        this.member_firstname = rsValue.getString("member_fname");
        this.member_middlename = rsValue.getString("member_mname");
        this.member_lastname = rsValue.getString("member_lname");
        this.member_address = rsValue.getString("member_address");
        this.member_city = rsValue.getString("member_city");
        this.member_state = rsValue.getString("member_state");
        this.member_zipcode = rsValue.getString("member_zipcode");
        this.member_email = rsValue.getString("member_email");
        this.member_homephone = rsValue.getString("member_hphone");
        this.member_workphone = rsValue.getString("member_wphone");
        this.member_cellphone = rsValue.getString("member_cphone");
        this.member_joindate = rsValue.getString("member_joined");
        this.member_birthdate = rsValue.getString("member_dob");
        this.member_wedding = rsValue.getString("member_wed");
        this.member_saved = rsValue.getString("member_saved");
        this.member_baptized = rsValue.getString("member_baptized");
        this.member_shared = rsValue.getString("member_shared");                
        this.member_status = rsValue.getString("member_status"); 
    }
    public boolean saveMemberAddress(int iToMI, int iFromMI){
        boolean isUpdated = false;
        mmc.outputBox("Updating Member Address...");
        try {
            Statement stmt;
            //dataC dc = new dataC();
            try (Connection conn = dc.connectDB()) {
                stmt = conn.createStatement();
                String sql = "UPDATE member_tbl SET " +
                        "member_address = '" + this.member_address +
                        "', member_city = '" + this.member_city +
                        "', member_state = '" + this.member_state +
                        "', member_zipcode = '" + this.member_zipcode +
                        "', member_hphone = '" + this.member_homephone +
                        "' WHERE member_id = " + iToMI;
                //mmc.outputBox(sql);
                stmt.executeUpdate(sql);
                
                mmc.outputBox("Member successfully updated...");
            }
            //mmc.outputBox("Database closed...");
        } catch (SQLException ex) {
            Logger.getLogger(memberC.class.getName()).log(Level.SEVERE, null, ex);
        }               
        return isUpdated;
    }    
    public boolean confirmMemberTraining(int iValue){
        boolean isUpdated = false;
        mmc.outputBox("Updating Member : " + this.getMemberInfo());
        try {
            Statement stmt;
            //dataC dc = new dataC();
            try (Connection conn = dc.connectDB()) {
                stmt = conn.createStatement();
                String sql = "UPDATE member_tbl SET " +
                        "member_classdate = '" + this.member_classdate +
                        "' WHERE member_id = " + iValue;
                //mmc.outputBox(sql);
                stmt.executeUpdate(sql);
                
                mmc.outputBox("Member " + this.getMemberInfo() + " successfully updated...");
            }
            //mmc.outputBox("Database closed...");
        } catch (SQLException ex) {
            Logger.getLogger(memberC.class.getName()).log(Level.SEVERE, null, ex);
        }               
        return isUpdated;
    }   
    public boolean confirmMemberBaptism(int iValue){
        boolean isUpdated = false;
        mmc.outputBox("Updating Member : " + this.getMemberInfo());
        try {
            Statement stmt;
            //dataC dc = new dataC();
            try (Connection conn = dc.connectDB()) {
                stmt = conn.createStatement();
                String sql = "UPDATE member_tbl SET " +
                        "member_baptized = 'Y' " +
                        "WHERE member_id = " + iValue;
                //mmc.outputBox(sql);
                stmt.executeUpdate(sql);
                
                mmc.outputBox("Member " + this.getMemberInfo() + " successfully updated...");
            }
            //mmc.outputBox("Database closed...");
        } catch (SQLException ex) {
            Logger.getLogger(memberC.class.getName()).log(Level.SEVERE, null, ex);
        }               
        return isUpdated;        
    }
}
