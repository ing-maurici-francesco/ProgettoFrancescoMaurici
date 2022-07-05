/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Commands;

import Data.ConnectToDatabase;
import Data.DbConnectionSingleton;
import Model.Iscrizione;
import Repository.RepositoryPrototype;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Scanner;

/**
 *
 * @author francesco
 */
public class aggiornaIscrizione implements ICommand{
    
     ConnectToDatabase conn = new DbConnectionSingleton.Connect().connectToDb();
       
        
        static RepositoryPrototype prototypeRepo = new RepositoryPrototype();
        static Scanner sc = new Scanner(System.in);
        
        public aggiornaIscrizione()
        {
            
        }
    
    public static void execute() throws ParseException, SQLException {
    
        prototypeRepo.setRepository("Iscrizione");
        
            System.out.println("------------------------------------------");
            System.out.println("Modifica Iscrizione ");
            System.out.println("------------------------------------------");
            System.out.println("Inserisci nome socio");
            String nome = sc.nextLine();
            System.out.println("Inserisci cognome socio");
            String cognome = sc.nextLine();
            System.out.println("Inserisci nuova data iscrizione");
            String data = sc.nextLine();
            System.out.println("Inserisci attivita scelta");
            String attivita = sc.nextLine();
            System.out.println("Inserisci servizio scelto");
            String servizio = sc.nextLine();
            prototypeRepo.repo.aggiornaEntita(new Iscrizione(nome, cognome, data, attivita, servizio));
                                
    }
}
