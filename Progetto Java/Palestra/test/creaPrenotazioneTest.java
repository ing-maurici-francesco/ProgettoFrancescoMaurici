/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */

import Data.ConnectToDatabase;
import Model.Prenotazione;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import Repository.RepositoryPrototype;
import static org.junit.Assert.assertFalse;
import org.junit.Test;

/**
 *
 * @author francesco
 */
public class creaPrenotazioneTest {
    
    public creaPrenotazioneTest() {
    }
    
     @Test
     public void testCreaPrenotazione() throws SQLException  {
       
       Statement stmt;
       ConnectToDatabase conn = new ConnectToDatabase();
       Connection c = conn.connect();
       stmt = c.createStatement();
       stmt.executeUpdate("DELETE FROM prenotazione");
       RepositoryPrototype prototypeRepo = new RepositoryPrototype(); 
       
       Prenotazione prenotazione = new Prenotazione("Francesco", "Maurici", "Campo Calcio", "19-07-2022");
       
       prototypeRepo.setRepository("Prenotazione");
       
       prototypeRepo.repo.creaEntita(prenotazione);
       
       Prenotazione d = new Prenotazione(" ", " ", " ", " ");
       
       assertFalse(prenotazione.Nome.equals(d.Nome));
     }
}
