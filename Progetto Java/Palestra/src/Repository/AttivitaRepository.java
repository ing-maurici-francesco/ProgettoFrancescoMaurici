/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import Data.ConnectToDatabase;
import Data.DbConnectionSingleton;
import Model.Attivita;
import java.sql.Statement;
import java.util.*;
import java.sql.*;

/**
 *
 * @author francesco
 */
public class AttivitaRepository implements IRepository<Attivita> {
    
    List<Attivita> listaAttivita = new ArrayList<Attivita>();
    Statement stmt = null;
    ConnectToDatabase conn;
    
    @Override
    public List<Attivita> listaEntita() throws SQLException{
        this.conn = new DbConnectionSingleton.Connect().connectToDb();
        Connection c = conn.connect();
        stmt = c.createStatement();
        
        try
        {
            System.out.println("------------------------------------------");
            System.out.println("Lista Attivita ");
            System.out.println("------------------------------------------");
            System.out.println(" ");
        
            var a = stmt.executeQuery(
                    "SELECT * FROM attivita ORDER BY id ASC"
            );
            ArrayList<Attivita> listAttivita = new ArrayList<>();
            while (a.next())
            {   
                Attivita attivita = new Attivita(a.getString("descrizione"), a.getDouble("prezzo"));
                listAttivita.add(attivita);
            }
            c.close();
            return listAttivita;
        }
        catch(SQLException e)
        {
            System.out.println("Lista attivita vuota!");
            return null;
        }
    }

    @Override
    public Attivita creaEntita(Attivita entity) throws SQLException{
        this.conn = new DbConnectionSingleton.Connect().connectToDb();
        
        Connection c = this.conn.connect();
        stmt = c.createStatement();
        
        try
        {
            stmt.executeUpdate(
                "INSERT INTO attivita (id, descrizione, prezzo) VALUES (default,'" + entity.Descrizione + "'," + entity.Prezzo +  ")"
            );
            c.close();
            return entity;   
        }
        catch(SQLException e) {
            throw e;
        }
    }

    @Override
    public Attivita aggiornaEntita(Attivita entity) throws SQLException{
        this.conn = new DbConnectionSingleton.Connect().connectToDb();
        Connection c = conn.connect();
        stmt = c.createStatement();
        try{
            stmt.executeUpdate(
                "UPDATE attivita SET prezzo = " + Double.toString(entity.Prezzo)
                        + " WHERE descrizione = '" + entity.Descrizione + "'"
            );
            c.close();
            return entity;
        }
        catch (SQLException e) { throw e; }
    }

    @Override
    public boolean eliminaEntita(String[] descrizione) throws SQLException{
        this.conn = new DbConnectionSingleton.Connect().connectToDb();
        Connection c = conn.connect();
        stmt = c.createStatement();
        try
        {
           var a = stmt.executeUpdate(
                "DELETE FROM attivita WHERE descrizione = '" + descrizione[0] + "'"
            );
           if(a != 0)
           {
               System.out.println("L'attività " + descrizione[0] + " è stata eliminata correttamente \n\n");
               return true;
           }
        c.close();
        return false;
        }
        catch (SQLException e)  
        { 
            throw e; 
        }    
    }

    @Override
    public Attivita ricercaEntita(String[] chiavi) throws SQLException {
        this.conn = new DbConnectionSingleton.Connect().connectToDb();
        Connection c = conn.connect();
        stmt = c.createStatement();
       
           var attivita = stmt.executeQuery(
                "SELECT id, descrizione, prezzo FROM attivita WHERE descrizione = '" + chiavi[0] +  "'"
        );
           
           Attivita a = new Attivita();
           
           while (attivita.next()){
            a.Id = attivita.getInt("id");
            a.Descrizione = attivita.getString("descrizione");
            a.Prezzo = attivita.getDouble("prezzo");
            System.out.print(
                    " \n" +
                    "Attivita : " + a.Descrizione +
                    " \n" + 
                    "Prezzo : " + a.Prezzo + " \n");
           }
        c.close(); 
        return a;    
    }

    @Override
    public ResultSet eseguiQuery(String query) throws SQLException{
        this.conn = new DbConnectionSingleton.Connect().connectToDb();
        Connection c = conn.connect();
        stmt = c.createStatement();
        var result = stmt.executeQuery(query);
        c.close();
        return result;
    }
   
}
