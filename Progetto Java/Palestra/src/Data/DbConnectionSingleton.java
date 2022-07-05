/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Data;

/**
 *
 * @author francesco
 */
public class DbConnectionSingleton {
    
    public static class Connect
    {
        private static ConnectToDatabase conn = null;  //questa è la mia instanza 
        
        public static ConnectToDatabase connectToDb(){
            if(conn == null)
            {
                conn = new ConnectToDatabase();
            }
            return conn;
        }  
        
    }
    
}
