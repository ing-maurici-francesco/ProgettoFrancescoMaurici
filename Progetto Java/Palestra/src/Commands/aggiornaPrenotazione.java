/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Commands;

import Data.ConnectToDatabase;
import Data.DbConnectionSingleton;
import Repository.RepositoryPrototype;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Scanner;
import Model.Prenotazione;

/**
 *
 * @author francesco
 */
public class aggiornaPrenotazione implements ICommand{
    
     ConnectToDatabase conn = new DbConnectionSingleton.Connect().connectToDb();
       
        
        static RepositoryPrototype prototypeRepo = new RepositoryPrototype();
        static Scanner sc = new Scanner(System.in);
        
        public aggiornaPrenotazione()
        {
            
        }
    
    public static void execute() throws ParseException, SQLException {
       
        prototypeRepo.setRepository("Prenotazione");     
        
            System.out.println("------------------------------------------");
            System.out.println("Modifica Prenotazione ");
            System.out.println("------------------------------------------");
            System.out.println("Inserisci nome");
            String nome = sc.nextLine();
            System.out.println("Inserisci cognome ");
            String cognome = sc.nextLine();
            System.out.println("Inserisci nome impianto");
            String impianto = sc.nextLine();
            System.out.println("Inserisci data prenotazione");
            String data = sc.nextLine();
            prototypeRepo.repo.aggiornaEntita(new Prenotazione(nome, cognome, impianto, data));             
    }
    
}
