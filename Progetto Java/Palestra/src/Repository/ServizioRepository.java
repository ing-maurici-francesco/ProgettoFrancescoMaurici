/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import Data.ConnectToDatabase;
import Data.DbConnectionSingleton;
import Model.Servizio;
import java.sql.Statement;
import java.util.*;
import java.sql.*;

/**
 *
 * @author francesco
 */

public class ServizioRepository implements IRepository <Servizio>{

    List<Servizio> listaServizio = new ArrayList<Servizio>();
    Statement stmt = null;
    ConnectToDatabase conn;
    
    @Override
    public List<Servizio> listaEntita() throws SQLException {
        this.conn = new DbConnectionSingleton.Connect().connectToDb();
        Connection c = conn.connect();
        stmt = c.createStatement();
        
        try
        {
            System.out.println("------------------------------------------");
            System.out.println("Lista Servizio ");
            System.out.println("------------------------------------------");
            System.out.println(" ");
        
            var a = stmt.executeQuery(
                    "SELECT * FROM servizio ORDER BY id ASC"
            );
            ArrayList<Servizio> listServizi = new ArrayList<>();
            while (a.next())
            {   
                Servizio servizio = new Servizio(a.getString("descrizione"), a.getDouble("prezzo"));
                listServizi.add(servizio);
            }
            c.close();
            return listServizi;
        }
        catch(SQLException e)
        {
            System.out.println("Lista servizio vuota!");
            return null;
        }    }

    @Override
    public Servizio creaEntita(Servizio entity) throws SQLException {
        this.conn = new DbConnectionSingleton.Connect().connectToDb();
        Connection c = this.conn.connect();
        stmt = c.createStatement();
        
        try
        {
            stmt.executeUpdate(
                "INSERT INTO servizio (id, descrizione, prezzo) VALUES (default,'" + entity.Descrizione + "'," + entity.Prezzo +  ")"
            );
            c.close();
            return entity;   
        }
        catch(SQLException e) {
            throw e;
        }    }

    @Override
    public Servizio aggiornaEntita(Servizio entity) throws SQLException {
    this.conn = new DbConnectionSingleton.Connect().connectToDb();
        Connection c = conn.connect();
        stmt = c.createStatement();
        try{
            stmt.executeUpdate(
                "UPDATE servizio SET descrizione = '" + entity.Descrizione
                    + "' , prezzo = " + Double.toString(entity.Prezzo)
                    + "WHERE descrizione = '" + entity.Descrizione + "'"
            );
            c.close();
            return entity;
        }
        catch (SQLException e) { throw e; }    }

    @Override
    public boolean eliminaEntita(String[] chiavi) throws SQLException {
        this.conn = new DbConnectionSingleton.Connect().connectToDb();
        Connection c = conn.connect();
        stmt = c.createStatement();
        try
        {
           var a = stmt.executeUpdate(
                "DELETE FROM servizio WHERE descrizione = '" + chiavi[0] + "'"
            );
           if(a != 0)
           {
               System.out.println("Il servizio " + chiavi[0] + " è stato eliminato correttmente \n\n");
               return true;
           }
        c.close();
        return false;
        }
        catch (SQLException e)  
        { 
            throw e; 
        }        }

    @Override
    public ResultSet eseguiQuery(String query) throws SQLException {
        this.conn = new DbConnectionSingleton.Connect().connectToDb();
        Connection c = conn.connect();
        stmt = c.createStatement();
        var result = stmt.executeQuery(query);
        c.close();
        return result;    }

    @Override
    public Servizio ricercaEntita(String[] chiavi) throws SQLException {
        this.conn = new DbConnectionSingleton.Connect().connectToDb();
        Connection c = conn.connect();
        stmt = c.createStatement();
       
           var servizio = stmt.executeQuery(
                "SELECT id, descrizione, prezzo FROM servizio WHERE descrizione = '" + chiavi[0] +  "'"
        );
           
           Servizio a = new Servizio();
           
           while (servizio.next()){
            a.Id = servizio.getInt("id");
            a.Descrizione = servizio.getString("descrizione");
            a.Prezzo = servizio.getDouble("prezzo");
            System.out.print(
                    " \n" +
                    "servizio : " + a.Descrizione +
                    " \n" + 
                    "Prezzo : " + a.Prezzo + " \n");
           }
        c.close(); 
        return a;        
    } 
}
