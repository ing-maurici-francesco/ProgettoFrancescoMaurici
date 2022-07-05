/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import Data.ConnectToDatabase;
import Data.DbConnectionSingleton;
import Model.Socio;
import java.sql.Statement;
import java.util.*;
import java.sql.*;

/**
 *
 * @author francesco
 */
public class SocioRepository implements IRepository<Socio>  {
    
    List<Socio> listaSoci = new ArrayList<Socio>();
    Statement stmt = null;
    ConnectToDatabase conn;

    @Override
    public List listaEntita() throws SQLException {
        this.conn = new DbConnectionSingleton.Connect().connectToDb();
        Connection c = conn.connect();
        stmt = c.createStatement();
        
        try
        {
            System.out.println("------------------------------------------");
            System.out.println("Lista Soci ");
            System.out.println("------------------------------------------");
            System.out.println(" ");
        
            var a = stmt.executeQuery(
                    "SELECT * FROM socio"
            );
            ArrayList<Socio> listSocio = new ArrayList<>();
            while (a.next())
            {
                Socio socio = new Socio(a.getString("nome"), a.getString("cognome"), a.getString("email"), a.getInt("anno"), a.getString("tessera"));
                listSocio.add(socio);
            }
            c.close();
            return listSocio;
        }
        catch(Exception e)
        {
            System.out.println("Lista soci vuota!");
            return null;
        }    }



    @Override
    public Socio creaEntita(Socio entity) throws SQLException {
        this.conn = new DbConnectionSingleton.Connect().connectToDb();
        Connection c = conn.connect();
        stmt = c.createStatement();
        try
        {
            stmt.executeUpdate(
                "INSERT INTO socio (id, nome, cognome, email, anno, tessera) VALUES (default,'"
                        + entity.Nome + "','" 
                        + entity.Cognome + "','" 
                        + entity.Email + "'," 
                        + Integer.toString(entity.Anno) + ",'" 
                        + entity.Tessera + "')"
            );
            c.close();
            return entity;   
        }
        catch(Exception e)
        {
            System.out.println("Attenzione! Non tutti i campi non sono stati compilati correttamente");
            return null;
        }           }

    @Override
    public Socio aggiornaEntita(Socio entity) throws SQLException {
        this.conn = new DbConnectionSingleton.Connect().connectToDb();
        Connection c = conn.connect();
        stmt = c.createStatement();
        try{
            stmt.executeUpdate(
                "UPDATE socio SET nome = '" + entity.Nome 
                    + "', cognome = '" + entity.Cognome + "', anno=" + entity.Anno + ", tessera='" + entity.Tessera + "' WHERE nome = '" + entity.Nome + "' AND cognome='" + entity.Cognome + "'"
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
                "DELETE FROM socio WHERE nome='" + chiavi[0] + "' AND cognome='" + chiavi[1] + "'"
            );
           if(a != 0)
           {
               System.out.println("L'utente " + chiavi[0] + " " + chiavi[1] + " è stato eliminato con successo \n\n");
               return true;
           }
        c.close(); 
        return false;
        }
        catch (SQLException e)  { throw e; }        }

    @Override
    public ResultSet eseguiQuery(String query) throws SQLException {
        this.conn = new DbConnectionSingleton.Connect().connectToDb();
        Connection c = conn.connect();
        stmt = c.createStatement();
        var result = stmt.executeQuery(query);
        c.close();
        return result;     }

    @Override
    public Socio ricercaEntita(String[] chiavi) throws SQLException {
        this.conn = new DbConnectionSingleton.Connect().connectToDb();
        Connection c = conn.connect();
        stmt = c.createStatement();
       
           var id = stmt.executeQuery(
                "SELECT * FROM socio WHERE nome='" + chiavi[0] + "' AND cognome='" + chiavi[1] + "'"
           );
           c.close();        
           Socio socio = new Socio();
           while (id.next()){
            socio.Nome = id.getString("nome");
            socio.Cognome = id.getString("cognome");
            socio.Email = id.getString("email");
            socio.Anno = id.getInt("anno");
            socio.Tessera = id.getString("tessera");
            System.out.print(
                    " \n" +
                    "Socio : " + socio.Nome + " " + socio.Cognome + "\n" +
                    " \n" + 
                    "Email : " + socio.Email + " \n" + 
                    "Anno di nascita : " + socio.Anno + " \n" + 
                    "N° Tessera : " + socio.Tessera + " \n");
           }
           return socio;
    }
}
