/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Commands;

import Data.ConnectToDatabase;
import Data.DbConnectionSingleton;
import Model.Servizio;
import Repository.RepositoryPrototype;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Scanner;

/**
 *
 * @author francesco
 */
public class creaServizio implements ICommand{
    
    ConnectToDatabase conn = new DbConnectionSingleton.Connect().connectToDb();
       
        
        static RepositoryPrototype prototypeRepo = new RepositoryPrototype();
        static Scanner sc = new Scanner(System.in);
        
        public creaServizio(){}
    
        public static void execute() throws ParseException, SQLException {
            
            prototypeRepo.setRepository("Servizio");
           
                String scelta = "y";
                                    
                do{
                    System.out.println("------------------------------------------");
                    System.out.println("Aggiunta nuovo Servizio ");
                    System.out.println("------------------------------------------");
                    System.out.println(" ");
                    System.out.println("Inserisci nome servizio");
                    String descrizione = sc.nextLine();
                    System.out.println("Inserisci prezzo del servizio");
                    double prezzo = new Scanner(System.in).nextDouble();
                    prototypeRepo.repo.creaEntita(new Servizio(descrizione, prezzo));
                    System.out.println("Inserire Nuovo Servizio ? y/n");
                    scelta = sc.nextLine();
                    }
                while(scelta.equalsIgnoreCase("y"));
                }
            
}
