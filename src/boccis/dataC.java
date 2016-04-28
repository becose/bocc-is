/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boccis;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author tommybennett
 */
public class dataC {
    methodC mmc = new methodC();
    boolean notSuccessful = true;
    String tryLocation = "jdbc:sqlite:C:\\SysDev\\BOCCIS\\bocc.db";
    //String tryLocation = "jdbc:sqlite:/Users/tommybennett/SysDev/BOCCIS/bocc.db";

        public Connection connectDB(){
        Connection conn = null;
        
        //while(notSuccessful){
            try {
                Class.forName("org.sqlite.JDBC");
                conn = DriverManager.getConnection(this.tryLocation);
                mmc.outputBox("Database opened successfully...");
                this.notSuccessful = false;
            } catch (ClassNotFoundException | SQLException e) {
                System.err.println(e.getClass().getName() + ": " + e.getMessage());
                System.exit(0);
            }
        //}
        return conn; 
    }      
}
