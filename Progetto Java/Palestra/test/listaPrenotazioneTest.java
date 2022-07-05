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
import java.util.ArrayList;
import org.junit.Test;
import java.util.List;
import static org.junit.Assert.assertEquals;

/**
 *
 * @author francesco
 */
public class listaPrenotazioneTest {
    
    public listaPrenotazioneTest() {
    }
    
@Test
public void testListaPrenotazione() throws SQLException  {
   
    RepositoryPrototype prototypeRepo = new RepositoryPrototype();
    Statement stmt;
    ConnectToDatabase conn = new ConnectToDatabase();
    Connection c = conn.connect();
    stmt = c.createStatement();
    stmt.executeUpdate("DELETE FROM prenotazione");
       
    prototypeRepo.setRepository("Prenotazione");
    
       ArrayList<Prenotazione> listPrenotazione = new ArrayList<>();
       Prenotazione prenotazione = new Prenotazione("Mario", "Rossi", "Campo Calcio", "19-07-2022");
       Prenotazione prenotazione1 = new Prenotazione("Giuseppe", "Verdi", "Campo Tennis", "20-07-2022");
       listPrenotazione.add(prenotazione);
       listPrenotazione.add(prenotazione1);
       prototypeRepo.repo.creaEntita(prenotazione);
       prototypeRepo.repo.creaEntita(prenotazione1);
       
       List<Prenotazione> a = prototypeRepo.repo.listaEntita();
       var d = listPrenotazione;
       
       for(int i = 0; i<a.size() && i<d.size(); i++){
       assertEquals(d.get(i).Nome , a.get(i).Nome);
       assertEquals(d.get(i).Cognome , a.get(i).Cognome);
       assertEquals(d.get(i).Impianto , a.get(i).Impianto);
       assertEquals(d.get(i).Data , a.get(i).Data);
       }
     }
    
}
