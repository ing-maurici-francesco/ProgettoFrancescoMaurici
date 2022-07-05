/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */

import Data.ConnectToDatabase;
import Model.Prenotazione;
import Repository.RepositoryPrototype;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author francesco
 */
public class aggiornaPrenotazioneTest {
    
    public aggiornaPrenotazioneTest() {
    }
    
    @Test
     public void testAggiornaPrenotazione() throws SQLException  {
       
       Statement stmt;
       ConnectToDatabase conn = new ConnectToDatabase();
       Connection c = conn.connect();
       stmt = c.createStatement();
       stmt.executeUpdate("DELETE FROM prenotazione");
       RepositoryPrototype prototypeRepo = new RepositoryPrototype(); 
       
       prototypeRepo.setRepository("Prenotazione");
       
       Prenotazione prenotazione = new Prenotazione("Vincenzo", "Zimbone", "Campo Calcio", "19-07-2022");
       prototypeRepo.repo.creaEntita(prenotazione);
       
       Prenotazione aggiornamento = new Prenotazione("Vincenzo", "Zimbone", "Campo Calcio", "27-07-2022");
       prototypeRepo.repo.aggiornaEntita(aggiornamento);
      
       assertTrue(prenotazione.Nome.equals(aggiornamento.Nome));
       assertTrue(prenotazione.Cognome.equals(aggiornamento.Cognome));
       assertTrue(prenotazione.Impianto.equals(aggiornamento.Impianto));
       assertFalse(prenotazione.Data.equals(aggiornamento.Data));
     }
}
