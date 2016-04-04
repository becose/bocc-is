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
    methodC mc = new methodC();
    
    public Connection connectDB(){
        Connection conn = null;
       
        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:/Users/tommybennett/SysDev/BOCCIS/bocc.db");
            mc.outputBox("Database opened successfully...");
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return conn; 
    }      
}
