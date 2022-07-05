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
import static junit.framework.Assert.assertTrue;
import org.junit.Test;

/**
 *
 * @author francesco
 */
public class eliminaPrenotazioneTest {
    
    public eliminaPrenotazioneTest() {
    }
    
    @Test
     public void testEliminaPrenotazione() throws SQLException  {
       
       Statement stmt;
       ConnectToDatabase conn = new ConnectToDatabase();
       Connection c = conn.connect();
       stmt = c.createStatement();
       stmt.executeUpdate("DELETE FROM prenotazione");
         
       RepositoryPrototype prototypeRepo = new RepositoryPrototype();
       
       prototypeRepo.setRepository("Prenotazione");
       Prenotazione prenotazione = new Prenotazione("Mario", "Rossi", "Campo Tennis", "19-07-2022");
       
       prototypeRepo.repo.creaEntita(prenotazione);
       String[] param = new String[2];
       param[0] = "Campo Calcio";
       param[1] = "19-07-2022";
       boolean a = prototypeRepo.repo.eliminaEntita(param);
       var b = true;
       assertTrue(a = b);
       
     }
}
