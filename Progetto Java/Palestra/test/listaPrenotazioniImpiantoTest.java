/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */

import Data.ConnectToDatabase;
import Model.Prenotazione;
import Repository.PrenotazioneRepository;
import Repository.RepositoryPrototype;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author francesco
 */
public class listaPrenotazioniImpiantoTest {
    
    public listaPrenotazioniImpiantoTest() {
    }
    
    @Test
public void testListaPrenotazione() throws SQLException  {
   
    PrenotazioneRepository prenotazioneRepo = new PrenotazioneRepository();
    RepositoryPrototype prototypeRepo = new RepositoryPrototype();
    
    Statement stmt;
    ConnectToDatabase conn = new ConnectToDatabase();
    Connection c = conn.connect();
    stmt = c.createStatement();
    stmt.executeUpdate("DELETE FROM prenotazione");
      
    prototypeRepo.setRepository("Prenotazione");
    
       ArrayList<Prenotazione> listPrenotazione = new ArrayList<>();
       Prenotazione prenotazione = new Prenotazione("Mario", "Rossi", "Campo Basket", "19-07-2022");
       Prenotazione prenotazione1 = new Prenotazione("Giuseppe", "Verdi", "Campo Basket", "20-07-2022");
       listPrenotazione.add(prenotazione);
       listPrenotazione.add(prenotazione1);
       prototypeRepo.repo.creaEntita(prenotazione);
       prototypeRepo.repo.creaEntita(prenotazione1);
       
       List<Prenotazione> a = prenotazioneRepo.listaPrenotazioniImpianto("Campo Basket", conn);
       var d = listPrenotazione;
       
       for(int i = 0; i<a.size() && i<d.size(); i++){
       assertEquals(d.get(i).Nome , a.get(i).Nome);
       assertEquals(d.get(i).Cognome , a.get(i).Cognome);
       assertEquals(d.get(i).Impianto , a.get(i).Impianto);
       assertEquals(d.get(i).Data , a.get(i).Data);
       }
     }
}
