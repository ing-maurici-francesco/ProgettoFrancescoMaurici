/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import Data.ConnectToDatabase;
import Data.DbConnectionSingleton;
import Model.ImpiantoSportivo;
import java.sql.Statement;
import java.util.*;
import java.sql.*;

/**
 *
 * @author francesco
 */
public class ImpiantoSportivoRepository implements IRepository<ImpiantoSportivo> {
 
    List<ImpiantoSportivo> listaImpianti = new ArrayList<ImpiantoSportivo>();
    Statement stmt = null;
    ConnectToDatabase conn;
    
   @Override
    public List<ImpiantoSportivo> listaEntita() throws SQLException{
        this.conn = new DbConnectionSingleton.Connect().connectToDb();
        Connection c = conn.connect();
        stmt = c.createStatement();
        
        try
        {
            System.out.println("------------------------------------------");
            System.out.println("Lista Impianti ");
            System.out.println("------------------------------------------");
            System.out.println(" ");
        
            var a = stmt.executeQuery(
                    "SELECT * FROM impiantosportivo ORDER BY id ASC"
            );
            ArrayList<ImpiantoSportivo> listImpianti = new ArrayList<>();
            while (a.next())
            {   
                ImpiantoSportivo impianto = new ImpiantoSportivo(a.getString("descrizione"), a.getDouble("prezzo"));
                listImpianti.add(impianto);
            }
            return listImpianti;
        }
        catch(SQLException e)
        {
            System.out.println("Lista impianti vuota!");
            return null;
        }
    }

    @Override
    public ImpiantoSportivo creaEntita(ImpiantoSportivo entity) throws SQLException{
        this.conn = new DbConnectionSingleton.Connect().connectToDb();
        
        Connection c = this.conn.connect();
        stmt = c.createStatement();
        
        try
        {
            stmt.executeUpdate(
                "INSERT INTO impiantosportivo (id, descrizione, prezzo) VALUES (default,'" + entity.Descrizione + "'," + entity.Prezzo +  ")"
            );
            c.close();
            return entity;   
        }
        catch(SQLException e) {
            throw e;
        }
        
    }

    @Override
    public ImpiantoSportivo aggiornaEntita(ImpiantoSportivo entity) throws SQLException{
        this.conn = new DbConnectionSingleton.Connect().connectToDb();
        Connection c = conn.connect();
        stmt = c.createStatement();
        try{
            stmt.executeUpdate(
                "UPDATE impiantosportivo SET descrizione = '" + entity.Descrizione
                    + "' , prezzo = " + Double.toString(entity.Prezzo)
                    + "WHERE descrizione = '" + entity.Descrizione + "'"
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
                "DELETE FROM impiantosportivo WHERE descrizione = '" + descrizione[0] + "'"
            );
           if(a != 0)
           {
               System.out.println("L'impianto " + descrizione[0] + " è stato eliminato correttmente \n\n");
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
    public ImpiantoSportivo ricercaEntita(String[] chiavi) throws SQLException {
        this.conn = new DbConnectionSingleton.Connect().connectToDb();
        Connection c = conn.connect();
        stmt = c.createStatement();
       
           var impianto = stmt.executeQuery(
                "SELECT id, descrizione, prezzo FROM impiantosportivo WHERE descrizione = '" + chiavi[0] +  "'"
        );
           
           ImpiantoSportivo a = new ImpiantoSportivo();
           
           while (impianto.next()){
            a.Id = impianto.getInt("id");
            a.Descrizione = impianto.getString("descrizione");
            a.Prezzo = impianto.getDouble("prezzo");
            System.out.print(
                    " \n" +
                    "Impianto : " + a.Descrizione +
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
