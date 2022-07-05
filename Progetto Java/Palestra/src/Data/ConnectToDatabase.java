/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


package Data;

import java.sql.*;
/**
 *
 * @author francesco
 */
public class ConnectToDatabase {
    
    public Connection connect()
    {
        Connection conn = null;
        Statement stmt = null;
        try 
        {
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Palestra", "postgres", "franc7Fm" );
           
            conn.setAutoCommit(true);
            
            return conn;
            
        }
        catch (SQLException e)
        {
            System.out.println(e.getClass().getName()+": "+ e.getMessage() );
            System.exit(0);
            return null;
        }
        
    }
}
