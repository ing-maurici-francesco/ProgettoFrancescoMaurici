/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package palestra;

import Data.ConnectToDatabase;
import Data.DbConnectionSingleton;
import Model.Attivita;
import Model.ImpiantoSportivo;
import Model.Iscrizione;
import Model.Prenotazione;
import Model.Socio;
import Repository.RepositoryPrototype;
import Repository.PrenotazioneRepository;
import java.sql.SQLException;
import java.util.Scanner;
import java.text.ParseException;
import Commands.*;
import Repository.IscrizioneRepository;

/**
 *
 * @author francesco
 */
public class Palestra {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) throws ParseException, SQLException {
    
        ConnectToDatabase conn = new DbConnectionSingleton.Connect().connectToDb();
       
        RepositoryPrototype prototypeRepo = new RepositoryPrototype();
        PrenotazioneRepository prenRepo = new PrenotazioneRepository();
        IscrizioneRepository iscrizioneRepo = new IscrizioneRepository();
        
        try
        {
            System.out.println("Selezionare elemento da gestire");
            System.out.println("1. Utente \n2. Iscrizioni \n3. Attivita \n4. Prenotazioni \n5. Servizi \n6. Impianti Sportivi");
            int utente = new Scanner(System.in).nextInt();
            
            
            switch(utente)
            {
                case 1:
                    
                    System.out.println("Hai scelto gestione utente. Effettua un'operazione");
                    System.out.println("1. Mostra Dati Soci \n2. Mostra informazioni Socio \n3. Registra nuovo Socio \n4. Modifica informazioni Socio \n5. Elimina Socio");
                    int opt1 = new Scanner(System.in).nextInt();
                    Scanner sc = new Scanner(System.in);
                    System.out.println(" ");
                    Socio socio = new Socio();
                    
                    switch(opt1)
                            {
                                case 1:
                                    listaSocio.execute();
                                    break;
                                case 2:
                                    ricercaSocio.execute();
                                    break;
                                case 3:
                                    creaSocio.execute();
                                    break;
                                case 4:
                                    aggiornaSocio.execute();
                                    break;
                                case 5:
                                    eliminaSocio.execute();
                                    break;
                                default:
                                    System.out.println("Hai scelto un'operazione non in lista!");
                                    break;
                    } break;
                    
                case 2:
                    prototypeRepo.setRepository("Iscrizione");
                    System.out.println("Hai scelto gestione iscrizione");
                    System.out.println(" 1. Lista Iscrizioni");
                    System.out.println(" 2. Dettaglio Iscrizione");
                    System.out.println(" 3. Aggiungi Iscrizione");
                    System.out.println(" 4. Modifica Iscrizione");
                    System.out.println(" 5. Elimina Iscrizione");
                    System.out.println(" 6. Visualizza Tutte le Iscrizioni Socio");
                    int iscriz = new Scanner(System.in).nextInt();
                    Scanner sc2 = new Scanner(System.in);
                    Iscrizione iscrizione = new Iscrizione();
                    
                    switch(iscriz)
                            {
                                case 1:
                                    listaIscrizione.execute();
                                    break;
                                case 2:
                                    ricercaIscrizione.execute();
                                    break;
                                case 3:
                                    creaIscrizione.execute();
                                    break;
                                case 4:
                                    aggiornaIscrizione.execute();
                                    break;
                                case 5:
                                    eliminaIscrizione.execute();
                                    break;
                                case 6:
                                    System.out.println("Inserisci Nome Utente");
                                    String nome = sc2.nextLine();
                                    System.out.println("Inserisci Cognome Utente");
                                    String cognome = sc2.nextLine();
                                    iscrizioneRepo.listaIscrizioniSocio(nome, cognome, conn);
                                    break;
                                default:
                                    System.out.println("Hai scelto un'operazione non in lista!");
                                    break;
                            }
                    break;
                    
                case 3:
                    prototypeRepo.setRepository("Attivita");
                    System.out.println("Hai scelto gestione attivita. Effettua un'operazione");
                    System.out.println("1. Mostra Lista Attivita \n2. Mostra informazioni Attivita \n3. Aggiungi nuovo Attivita \n4. Modifica informazioni Attivita \n5. Elimina Attivita");
                    int activity = new Scanner(System.in).nextInt();
                    Scanner sc3 = new Scanner(System.in);
                    System.out.println(" ");
                    Attivita attivita = new Attivita();
                    
                    switch(activity)
                            {
                                case 1:
                                    listaAttivita.execute();
                                    break;
                                case 2:
                                    ricercaAttivita.execute();
                                    break;
                                case 3:
                                    creaAttivita.execute();
                                    break;
                                case 4:
                                    aggiornaAttivita.execute();
                                    break;
                                case 5:
                                    eliminaAttivita.execute();
                                    break;
                                default:
                                    System.out.println("Hai scelto un'operazione non in lista!");
                                    break;
                    } break;
                    
                case 4:
                    prototypeRepo.setRepository("Prenotazione");
                    System.out.println("Hai scelto gestione Prenotazione");
                    System.out.println("1. Lista Prenotazioni \n2. Dettaglio Prenotazione \n3. Aggiungi Prenotazione \n4. Modifica Prenotazione \n5. Elimina Prenotazione \n6. Trova Prenotazione Impianto \n7. Trova Prenotazione per Utente");
                    int prenot = new Scanner(System.in).nextInt();
                    Scanner sc4 = new Scanner(System.in);
                    System.out.println(" ");
                    Prenotazione prenotazione = new Prenotazione();
                    
                    switch(prenot)
                            {
                                case 1:
                                    listaPrenotazione.execute();
                                    break;
                                case 2:
                                    ricercaPrenotazione.execute();
                                    break;
                                case 3:
                                    creaPrenotazione.execute();
                                    break;
                                case 4:
                                    aggiornaPrenotazione.execute();
                                    break;
                                case 5:
                                    eliminaPrenotazione.execute();
                                    break;
                                case 6:
                                    System.out.println("Inserisci Nome Impianto");
                                    String impianto = sc4.nextLine();
                                    prenRepo.listaPrenotazioniImpianto(impianto, conn);
                                    break;
                                case 7:
                                    System.out.println("Inserisci Nome Utente");
                                    String nome = sc4.nextLine();
                                    System.out.println("Inserisci Cognome Utente");
                                    String cognome = sc4.nextLine();
                                    
                                    prenRepo.listaPrenotazioniSocio(nome, cognome, conn);
                                    
                                    break;
                                default:
                                    System.out.println("Hai scelto un'operazione non in lista!");
                                    break;
                            }
                    break;
                case 5:
                    System.out.println(" ");
                    System.out.println("Hai scelto gestione Servizi");
                    System.out.println("1. Lista Servizi \n2. Dettaglio Servizio \n3. Aggiungi Servizio \n4. Modifica Servizio \n5. Elimina Servizio");
                    int serv = new Scanner(System.in).nextInt();
                    Scanner sc5 = new Scanner(System.in);
                    System.out.println(" ");
                    
                    switch(serv)
                            {
                                case 1:
                                    listaServizio.execute();
                                    break;
                                case 2:
                                    ricercaServizio.execute();
                                    break;
                                case 3:
                                    creaServizio.execute();
                                    break;
                                case 4:
                                    aggiornaServizio.execute();
                                    break;
                                case 5:
                                    eliminaServizio.execute();
                                    break;
                                default:
                                    System.out.println("Hai scelto un'operazione non in lista!");
                                    break;
                            }
                    break;
                case 6:
                    System.out.println(" ");
                    System.out.println("Hai scelto gestione Impianti Sportivi");
                    System.out.println("1. Lista Impianti \n2. Dettaglio Impianto \n3. Aggiungi Impianto SPortivo \n4. Modifica Informazioni Impianto \n5. Elimina Impianto");
                    int imp = new Scanner(System.in).nextInt();
                    Scanner sc6 = new Scanner(System.in);
                    System.out.println(" ");
                    ImpiantoSportivo impianto = new ImpiantoSportivo();
                    
                    switch(imp)
                            {
                                case 1:
                                    listaImpiantoSportivo.execute();
                                    break;
                                case 2:
                                    ricercaImpiantoSportivo.execute();
                                    break;
                                case 3:
                                    creaImpiantoSportivo.execute();
                                    break;
                                case 4:
                                    aggiornaImpiantoSportivo.execute();
                                    break;
                                case 5:
                                    eliminaImpiantoSportivo.execute();
                                    break;
                                default:
                                    System.out.println("Hai scelto un'operazione non in lista!");
                                    break;
                            }
                    break;
                default:
                    System.out.println("Hai scelto un'operazione non in lista!");
                    break;
            }
            
        }
       catch (SQLException e)
       {
            System.out.println(e.getMessage());
       }
       
    }
    
}
