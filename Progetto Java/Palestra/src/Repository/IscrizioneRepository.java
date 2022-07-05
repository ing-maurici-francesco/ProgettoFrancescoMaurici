/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import Data.ConnectToDatabase;
import Data.DbConnectionSingleton;
import Model.Iscrizione;
import java.sql.Statement;
import java.util.*;
import java.sql.*;

/**
 *
 * @author francesco
 */


public class IscrizioneRepository implements IRepository<Iscrizione> {
    
    List<Iscrizione> listaAttivita = new ArrayList<Iscrizione>();
    Statement stmt = null;
    ConnectToDatabase conn;


    @Override
    public List<Iscrizione> listaEntita() throws SQLException {
        this.conn = new DbConnectionSingleton.Connect().connectToDb();
        Connection c = conn.connect();
        stmt = c.createStatement();
        
        try
        {
            System.out.println("------------------------------------------");
            System.out.println("Lista Iscrizioni ");
            System.out.println("------------------------------------------");
            System.out.println(" ");
        
            var a = stmt.executeQuery(
                    "SELECT * FROM iscrizione ORDER BY id ASC"
            );
            ArrayList<Iscrizione> listIscrizioni = new ArrayList<>();
            while (a.next())
            {   
                Iscrizione iscrizione = new Iscrizione(a.getString("nome"), a.getString("cognome"), a.getString("data"), a.getString("attivita"), a.getString("servizio"));
                listIscrizioni.add(iscrizione);
            }
            c.close();
            return listIscrizioni;
        }
        catch(SQLException e)
        {
            System.out.println("Lista attivita vuota!");
            return null;
        }    
    }

    @Override
    public Iscrizione creaEntita(Iscrizione entity) throws SQLException {
        this.conn = new DbConnectionSingleton.Connect().connectToDb();
        Connection c = conn.connect();
        stmt = c.createStatement();
        
        try
        {
            var a = stmt.executeUpdate(
                "INSERT INTO iscrizione (id, nome, cognome, data, attivita, servizio) VALUES (default,'" + entity.Nome + "','" + entity.Cognome + "','" + entity.Data + "','" + entity.Attivita + "','" + entity.Servizio + "')"
            );
            c.close();
            System.out.println("\nRiepilogo iscrizione");
            System.out.println(
                    "\nNome: " + entity.Nome + " " + entity.Cognome +
                    "\nAttivita scelta: " + entity.Attivita +
                    "\nServizio scelto: " + entity.Servizio
            );
            
            return entity;   
        }
        catch(SQLException e) { throw e; }
            }

    @Override
    public Iscrizione aggiornaEntita(Iscrizione entity) throws SQLException {
        this.conn = new DbConnectionSingleton.Connect().connectToDb();
        Connection c = conn.connect();
        stmt = c.createStatement();
        try{
            
            stmt.executeUpdate(
                "UPDATE iscrizione SET "
                    + "nome = '" + entity.Nome
                    + "' , cognome = '" + entity.Cognome
                    + "' , data = '" + entity.Data
                    + "' , attivita = '" + entity.Attivita
                    + "' , servizio = '" + entity.Servizio
                    + "' WHERE nome = '" + entity.Nome + "' AND cognome='" + entity.Cognome + "'"
            );
            c.close();
            return entity;
        }
        catch (SQLException e)  { throw e; }    }

    @Override
    public boolean eliminaEntita(String[] chiavi) throws SQLException {
        this.conn = new DbConnectionSingleton.Connect().connectToDb();
        Connection c = conn.connect();
        stmt = c.createStatement();
        try
        {
           var a = stmt.executeUpdate(
                "DELETE FROM Iscrizione WHERE nome = '" + chiavi[0] + "' AND cognome='" + chiavi[1] + "'"
            );
           if(a != 0)
           {
               System.out.println("Eliminazione dell'iscrizione del socio " + chiavi[0] + " " + chiavi[1] + " avvenuta correttamente\n\n");
               return true;
           }
        c.close(); 
        return false;
        }
        catch (SQLException e)  { throw e; }    }

    @Override
    public ResultSet eseguiQuery(String query) throws SQLException {
        this.conn = new DbConnectionSingleton.Connect().connectToDb();
        Connection c = conn.connect();
        stmt = c.createStatement();
        var result = stmt.executeQuery(query);
        c.close();
        return result;    }

    @Override
    public Iscrizione ricercaEntita(String[] chiavi) throws SQLException {
        this.conn = new DbConnectionSingleton.Connect().connectToDb();
        Connection c = conn.connect();
        stmt = c.createStatement();
       
           var iscrizione = stmt.executeQuery(
                "SELECT id, nome, cognome, data, attivita, servizio FROM iscrizione WHERE nome = '" + chiavi[0] + "' AND cognome = '" + chiavi[1] +  "'"
        );
           c.close(); 
           Iscrizione i = new Iscrizione();
      
           while (iscrizione.next()){
            i.Id = iscrizione.getInt("id");
            i.Nome = iscrizione.getString("nome");
            i.Cognome = iscrizione.getString("cognome");
            i.Data = iscrizione.getString("data");
            i.Servizio = iscrizione.getString("servizio");
            i.Attivita = iscrizione.getString("attivita");
            System.out.print(
                    " \n" +
                    "Id : " + i.Id +
                    " \n" +
                    "Nome : " + i.Nome +
                    " \n" +
                    "Cognome : " + i.Cognome +
                    " \n" +
                    "Data : " + i.Data +
                    " \n" +
                    "Attivita : " + i.Attivita +
                    " \n" + 
                    "Servizio : " + i.Servizio + " \n");
           }
           
        return i;      
    }

    public List<Iscrizione> listaIscrizioniSocio(String nome, String cognome, ConnectToDatabase conn) throws SQLException 
    {
        Connection c = conn.connect();
        stmt = c.createStatement();
        
        try
        {
            System.out.println("------------------------------------------");
            System.out.println("Lista Iscrizioni dell'utente " + nome + " " + cognome);
            System.out.println("------------------------------------------");
            System.out.println(" ");
        
            var a = stmt.executeQuery(
                    "SELECT * FROM iscrizione WHERE nome = '" + nome + "' AND cognome='" + cognome + "' ORDER BY id ASC"
            );
            ArrayList<Iscrizione> listIscrizioniSocio = new ArrayList<>();
            while (a.next())
            {   
                Iscrizione iscrizione = new Iscrizione(a.getString("nome"), a.getString("cognome"), a.getString("data"), a.getString("attivita"),  a.getString("servizio"));
                listIscrizioniSocio.add(iscrizione);
            }
            
            for(int i = 0; i<listIscrizioniSocio.size(); i++)
                                    {
                                        System.out.println(
                                            listIscrizioniSocio.get(i).Nome + " " +
                                            listIscrizioniSocio.get(i).Cognome + " " + 
                                            listIscrizioniSocio.get(i).Data + " " + 
                                            listIscrizioniSocio.get(i).Attivita + " " + 
                                            listIscrizioniSocio.get(i).Servizio + "\n " 
                                        );
                                    }
            return listIscrizioniSocio;
        }
        catch(SQLException e)
        {
            System.out.println("Lista Prenotazioni vuota!");
            return null;
        }
    }
}
