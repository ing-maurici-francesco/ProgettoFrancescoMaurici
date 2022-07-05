/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import Data.ConnectToDatabase;
import Data.DbConnectionSingleton;
import Model.Prenotazione;
import java.sql.Statement;
import java.util.*;
import java.sql.*;

/**
 *
 * @author francesco
 */
public class PrenotazioneRepository implements IRepository<Prenotazione>  {
    
    List<Prenotazione> listaPrenotazione = new ArrayList<Prenotazione>();
    Statement stmt = null;
    ConnectToDatabase conn;
    
   

    @Override
    public List<Prenotazione> listaEntita() throws SQLException {
        this.conn = new DbConnectionSingleton.Connect().connectToDb();
        Connection c = conn.connect();
        stmt = c.createStatement();
        
        try
        {
            System.out.println("------------------------------------------");
            System.out.println("Lista Prenotazioni ");
            System.out.println("------------------------------------------");
            System.out.println(" ");
        
            var a = stmt.executeQuery(
                    "SELECT * FROM prenotazione"
            );
            ArrayList<Prenotazione> listPrenotazione = new ArrayList<>();
            
            while (a.next())
            {   
                Prenotazione prenotazione = new Prenotazione(a.getString("nome"), a.getString("cognome"), a.getString("impianto"), a.getString("data"));
                listPrenotazione.add(prenotazione);
                
            }
            System.out.println(listPrenotazione);
            c.close();
            return listPrenotazione;
        }
        catch(SQLException e)
        {
            System.out.println("Nessuna prenotazione da mostrare!");
            return null;
        }
    }

    @Override
    public Prenotazione creaEntita(Prenotazione entity) throws SQLException {
        this.conn = new DbConnectionSingleton.Connect().connectToDb();
        Connection c = conn.connect();
        stmt = c.createStatement();
        
        try
        {
            stmt.executeUpdate(
                "INSERT INTO prenotazione VALUES (default,'" + entity.Nome + "','" + entity.Cognome + "','" + entity.Impianto + "','" + entity.Data + "')"
            );
            c.close();
            return entity;   
        }
        catch(SQLException e) { throw e; }    }

    @Override
    public Prenotazione aggiornaEntita(Prenotazione entity) throws SQLException {
        this.conn = new DbConnectionSingleton.Connect().connectToDb();
        Connection c = conn.connect();
        stmt = c.createStatement();
        try{
            stmt.executeUpdate(
                "UPDATE prenotazione SET "
                    + "nome = '" + entity.Nome
                    + "' , cognome = '" + entity.Cognome
                    + "' , data = '" + entity.Data
                    + "' , impianto = '" + entity.Impianto
                    + "' WHERE nome = '" + entity.Nome + "' AND cognome='" + entity.Cognome + "'"
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
                "DELETE FROM prenotazione WHERE impianto='" + chiavi[0] + "' AND data='" + chiavi[1] + "'"
            );
           if(a != 0)
           {
               System.out.println("La prenotazione dell'impianto " + chiavi[0] + " di giorno " + chiavi[1] + " è stata eliminata correttamente \n\n");
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
        return result;     
    }

    @Override
    public Prenotazione ricercaEntita(String[] chiavi) throws SQLException {
        this.conn = new DbConnectionSingleton.Connect().connectToDb();
        Connection c = conn.connect();
        stmt = c.createStatement();
       
           var prenotazione = stmt.executeQuery(
                "SELECT nome, cognome, impianto, data FROM prenotazione WHERE nome='" + chiavi[0] + "' AND cognome = '" + chiavi[1] + "'"
           );
           c.close();
           Prenotazione pren = new Prenotazione();
           while (prenotazione.next()){
            pren.Nome = prenotazione.getString("nome");
            pren.Cognome = prenotazione.getString("cognome");
            pren.Impianto = prenotazione.getString("Impianto");
            pren.Data = prenotazione.getString("data");
            System.out.print(
                    " \n" +
                    "Nome : " + pren.Nome + " " + pren.Cognome + 
                    " \n" + 
                    "Impianto : " + pren.Impianto +
                    " \n" + 
                    "Data : " + pren.Data + " \n");
           }
           return pren;
           }
      
    
    public List<Prenotazione> listaPrenotazioniSocio(String nome, String cognome, ConnectToDatabase conn) throws SQLException 
    {
        Connection c = conn.connect();
        stmt = c.createStatement();
        
        try
        {
            System.out.println("------------------------------------------");
            System.out.println("Lista Prenotazioni dell'utente " + nome + " " + cognome);
            System.out.println("------------------------------------------");
            System.out.println(" ");
        
            var a = stmt.executeQuery(
                    "SELECT * FROM prenotazione WHERE nome = '" + nome + "' AND cognome='" + cognome + "' ORDER BY id ASC"
            );
            ArrayList<Prenotazione> listPrenotazioniSocio = new ArrayList<>();
            while (a.next())
            {   
                Prenotazione prenotazione = new Prenotazione(a.getString("nome"), a.getString("cognome"),  a.getString("impianto"), a.getString(("data")));
                listPrenotazioniSocio.add(prenotazione);
            }
            
            for(int i = 0; i<listPrenotazioniSocio.size(); i++)
                                    {
                                        System.out.println(
                                            listPrenotazioniSocio.get(i).Nome + " " +
                                            listPrenotazioniSocio.get(i).Cognome + " " + 
                                            listPrenotazioniSocio.get(i).Impianto + " " + 
                                            listPrenotazioniSocio.get(i).Data + "\n " 
                                        );
                                    }
            return listPrenotazioniSocio;
        }
        catch(SQLException e)
        {
            System.out.println("Lista Prenotazioni vuota!");
            return null;
        }
    }
    
    public List<Prenotazione> listaPrenotazioniImpianto(String impianto, ConnectToDatabase conn) throws SQLException 
    {
        Connection c = conn.connect();
        stmt = c.createStatement();
        
        try
        {
            System.out.println("------------------------------------------");
            System.out.println("Lista Prenotazioni impianto " + impianto);
            System.out.println("------------------------------------------");
            System.out.println(" ");
        
            var a = stmt.executeQuery(
                    "SELECT * FROM prenotazione WHERE impianto = '" + impianto + "' ORDER BY id ASC"
            );
            ArrayList<Prenotazione> listPrenotazioniImpianto = new ArrayList<>();
            while (a.next())
            {   
                Prenotazione prenotazione = new Prenotazione(a.getString("nome"), a.getString("cognome"),  a.getString("impianto"), a.getString(("data")));
                listPrenotazioniImpianto.add(prenotazione);
            }
            for(int i = 0; i<listPrenotazioniImpianto.size(); i++)
                                    {
                                        System.out.println(
                                            listPrenotazioniImpianto.get(i).Nome + " " +
                                            listPrenotazioniImpianto.get(i).Cognome + " " + 
                                            listPrenotazioniImpianto.get(i).Impianto + " " + 
                                            listPrenotazioniImpianto.get(i).Data + "\n " 
                                        );
                                    }
            return listPrenotazioniImpianto;
        }
        catch(SQLException e)
        {
            System.out.println("Lista Prenotazioni vuota!");
            return null;
        }
    }
    
}
