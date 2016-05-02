/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boccis;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
/**
 *
 * @author tommybennett
 */

public class methodC {
    private int iClicksFT=0;

    public boolean isValidDirectory(String sValue) {
        File fileDirectory = new File(sValue);
        this.outputBox("DirectoryName: " + sValue + " :Valid = " + fileDirectory.exists());
        return fileDirectory.exists();
    }
    public boolean isValidFileName(String sValue) {
        this.outputBox("FileName: " + sValue + " :Valid = " + sValue.matches("([^\\s]+(\\.(?i)(txt|doc|pdf))$)"));
        return sValue.matches("([^\\s]+(\\.(?i)(txt|doc|pdf))$)");
    }
    public boolean isValidPhoneNumber(String sValue) {
        this.outputBox("PhoneNumber: " + sValue + " :Valid = " + sValue.matches("^(\\d{3}-?\\d{3}-?\\d{4})$"));
        return sValue.matches("^(\\d{3}-?\\d{3}-?\\d{4})$");
    }
    public boolean isValidZipCode(String sValue) {
        this.outputBox("ZipCode: " + sValue + " :Valid = " + sValue.matches("^(\\d{5})$"));
        return sValue.matches("^(\\d{5})$");
    }    
    public boolean isValidWord(String sValue) {
        this.outputBox("Word: " + sValue + " :Valid = " + sValue.matches("[a-zA-Z ]+\\.?"));
        return sValue.matches("[a-zA-Z ]+\\.?");
    }
    public boolean isValidNumber(String sValue) {
        this.outputBox("Number: " + sValue + " :Valid = " + sValue.matches("[0-9 ]+\\.?"));
        return sValue.matches("[0-9 ]+\\.?");
    }    
    public boolean isValidState(String sValue) {
        this.outputBox("State: " + sValue + " :Valid = " + sValue.matches("[a-zA-Z]{2}"));
        return sValue.matches("[a-zA-Z]{2}");
    }
    public boolean isValidCityState(String sValue) {
        this.outputBox("City/State: " + sValue + " :Valid = " + sValue.matches("[a-zA-Z, ]+\\.?"));
        return sValue.matches("[a-zA-Z, ]+\\.?");
    }    
    public boolean isValidEmail(String sValue) {
        this.outputBox("E-mail: " + sValue + " :Valid = " + sValue.matches("^[\\w-_\\.+]*[\\w-_\\.]\\@([ \\w]+\\.)+[\\w]+[\\w]$"));
        return sValue.matches("^[\\w-_\\.+]*[\\w-_\\.]\\@([ \\w]+\\.)+[\\w]+[\\w]$");
    }    
    public boolean isValidPasswordMatch(String sPW1, String sPW2){
        this.outputBox("Password Match :Valid = " + sPW1.trim().equals(sPW2.trim()));
        return sPW1.trim().equals(sPW2.trim());
    }
    public boolean isValidAlphaNumeric(String sValue) {
        this.outputBox("AlphaNumeric: " + sValue + " :Valid = " + sValue.matches("[a-zA-Z0-9 ]+\\.?"));
        return sValue.matches("[a-zA-Z0-9 ]+\\.?");
    }     
    public boolean isValidHostName(String sValue) {
        this.outputBox("HostName: " + sValue + " :Valid = " + sValue.matches("[a-zA-Z0-9. ]+\\.?"));
        return sValue.matches("[a-zA-Z0-9. ]+\\.?");        
    }
    public String padString(String sToPad, int iPadSize, String sPadString) {
        int iCharacterCount=0;
        int iCharDiff=iPadSize-sToPad.length();
        System.out.println("Differnce "+iCharDiff);
        String sTempString="";
        String sPadCharacter = sPadString;
        if(sToPad.length()<iPadSize) {
            while (iCharacterCount<iCharDiff) {
                sTempString = sTempString + sPadCharacter;
                iCharacterCount++;
            }
            System.out.println("Created string: "+sTempString+sToPad);
        }
        return sTempString+sToPad;
    }
    public String returnSubstring(String sValue, int iStartAt, int iLength){
        return sValue.substring(iStartAt, iLength);
    }
    public void messageBox(String sMessage) {
        JOptionPane.showMessageDialog(null,sMessage);
    }
    public void outputBox(String sMessage) {
        System.out.println(sMessage);
    }    
    public String getDateTimeFormatted() {
        // Create an instance of SimpleDateFormat used for formatting
        // the string representation of date (month/day/year)
        DateFormat df = new SimpleDateFormat("MM/dd/yyyy hh:MM:dd a");
        // Get the date today using Calendar object.
        Date today = Calendar.getInstance().getTime();       
        return df.format(today); 
    }
    public String getCurrentDate(){
        Date obDate = new Date();
        SimpleDateFormat obDateFormat = new SimpleDateFormat(
                        "MM/dd/yyyy");
        //this.outputBox("Current Time/Date : "
        //                + obDateFormat.format(obDate.getTime()));
        return obDateFormat.format(obDate.getTime());
    }
    public String int2String(int iValue) {
        return String.valueOf(iValue);
    }
    public int String2int(String sValue) {
        return Integer.valueOf(sValue.trim());
    }
    public String double2String(double dValue){
        return String.valueOf(dValue);
    }
    public double Double2Money(double dValue){
        String str = String.format("%1.2f", dValue);
        return Double.valueOf(str);
    }
    public double String2double(String sValue){
        return Double.valueOf(sValue);
    }
    public String singleLineSpace(){
        return "\n";
    }
    public String doubleLineSpace(){
        return "\n\n";
    }
    public String tripleLineSpace(){
        return "\n\n\n";
    }
    public int clickCountFT() {
        return iClicksFT=2;
    }    
    public static String printHello(){
        return "Hello...";
    }
}
