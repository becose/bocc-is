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
    private int link_id;
    private int member_id;
    private int connected_id;
    private int relation_id;
    private String relation_name;
    private String family_date;
    
    public void setFI(int iValue){
        this.family_id = iValue;
    }
    public int getFI(){
        return this.family_id;
    }
    public void setLI(int iValue){
        this.link_id = iValue;
    }
    public int getLI(){
        return this.link_id;
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
    public void setRN(String sValue){
        this.relation_name = sValue;
    }
    public String getRN(){
        return this.relation_name;
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
                        + "family_connected_id,family_relation_id,family_date,"
                        + "family_relation_name) "
                        + "VALUES ("+this.member_id+","+this.connected_id
                        + ","+this.relation_id+",'"+this.family_date
                        +"','"+this.relation_name
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
