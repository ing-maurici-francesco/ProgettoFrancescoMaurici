/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Commands;

import Data.ConnectToDatabase;
import Data.DbConnectionSingleton;
import Model.Prenotazione;
import Repository.RepositoryPrototype;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Scanner;

/**
 *
 * @author francesco
 */
public class creaPrenotazione implements ICommand{
    
    ConnectToDatabase conn = new DbConnectionSingleton.Connect().connectToDb();
       
        
        static RepositoryPrototype prototypeRepo = new RepositoryPrototype();
        static Scanner sc = new Scanner(System.in);
        
        public creaPrenotazione(){}
        
        public static void execute() throws ParseException, SQLException 
        {
            prototypeRepo.setRepository("Prenotazione");

            String scelta = "y";
            
            do{
                System.out.println("------------------------------------------");
                System.out.println("Aggiunta nuova Prenotazione ");
                System.out.println("------------------------------------------");
                System.out.println(" ");
                System.out.println("Inserisci nome ");
                String nome = sc.nextLine();
                System.out.println("Inserisci cognome ");
                String cognome = sc.nextLine();
                System.out.println("Inserisci nome impianto");
                String impianto = sc.nextLine();
                System.out.println("Inserisci data Prenotazione");
                String data = sc.nextLine();
                prototypeRepo.repo.creaEntita(new Prenotazione(nome, cognome, impianto, data));
                
                System.out.println("Inserire Nuova Prenotazione ? y/n");
                scelta = sc.nextLine();
            }
            while(scelta.equalsIgnoreCase("y"));
        }
}
