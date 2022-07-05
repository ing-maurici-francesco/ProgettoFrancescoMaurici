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
import static junit.framework.Assert.assertTrue;
import org.junit.Test;

/**
 *
 * @author francesco
 */
public class ricercaPrenotazioneTest {
    
    public ricercaPrenotazioneTest() {
    }
    
    @Test
     public void testRicercaPrenotazione() throws SQLException  {
       
        RepositoryPrototype prototypeRepo = new RepositoryPrototype();
       
        Statement stmt;
        ConnectToDatabase conn = new ConnectToDatabase();
        Connection c = conn.connect();
        stmt = c.createStatement();
        stmt.executeUpdate("DELETE FROM prenotazione");
       
       Prenotazione prenotazione = new Prenotazione("Daniele", "Giusti", "Campo Basket", "25-06-2022");
       
       prototypeRepo.setRepository("Prenotazione");
       
       prototypeRepo.repo.creaEntita(prenotazione);
       String[] param = new String[2];
       param[0] = "Daniele";
       param[1] = "Giusti";
       var a = prototypeRepo.repo.ricercaEntita(param);
       var d = (Prenotazione) a;
       assertTrue(prenotazione.Nome.equals(d.Nome));
       assertTrue(prenotazione.Cognome.equals(d.Cognome));
     }
}
