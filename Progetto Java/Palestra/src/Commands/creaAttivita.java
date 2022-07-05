/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Commands;

import Data.ConnectToDatabase;
import Data.DbConnectionSingleton;
import Model.Attivita;
import Repository.RepositoryPrototype;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Scanner;

/**
 *
 * @author francesco
 */
public class creaAttivita implements ICommand{
    
        ConnectToDatabase conn = new DbConnectionSingleton.Connect().connectToDb();
       
        static RepositoryPrototype prototypeRepo = new RepositoryPrototype();
        static Scanner sc = new Scanner(System.in);
        
        public creaAttivita()
        {
            
        }
    
        public static void execute() throws ParseException, SQLException {
                                    
            prototypeRepo.setRepository("Attivita");  
            
            String scelta = "y";
                                    
                do{
                    System.out.println("------------------------------------------");
                    System.out.println("Aggiunta nuova Attivita ");
                    System.out.println("------------------------------------------");
                    System.out.println(" ");
                    System.out.println("Inserisci nome attivita");
                    String descrizione = sc.nextLine();
                    System.out.println("Inserisci prezzo dell'attività");
                    double prezzo = new Scanner(System.in).nextDouble();
                    prototypeRepo.repo.creaEntita(new Attivita(descrizione, prezzo));
                    System.out.println("------------------------------------------");
                    System.out.println("Riepilogo Inserimento ");
                    System.out.println("------------------------------------------");
                    System.out.println("\nDescrizione : " + descrizione + "\nPrezzo : " + prezzo + " €\n");
                    
                    System.out.println("Inserire Nuova Attivita ? y/n");
                    scelta = sc.nextLine();
                }
                while(scelta.equalsIgnoreCase("y"));
            
        }
}
