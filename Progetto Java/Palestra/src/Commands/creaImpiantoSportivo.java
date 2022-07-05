/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Commands;

import Data.ConnectToDatabase;
import Data.DbConnectionSingleton;
import Model.ImpiantoSportivo;
import Repository.RepositoryPrototype;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Scanner;

/**
 *
 * @author francesco
 */
public class creaImpiantoSportivo implements ICommand{
    
    ConnectToDatabase conn = new DbConnectionSingleton.Connect().connectToDb();
       
        
        static RepositoryPrototype prototypeRepo = new RepositoryPrototype();
        static Scanner sc = new Scanner(System.in);
        
        public creaImpiantoSportivo()
        {
            
        }
    
        public static void execute() throws ParseException, SQLException {
            
            prototypeRepo.setRepository("ImpiantoSportivo");
          
            String scelta = "y";   
            
            do{
                System.out.println("------------------------------------------");
                System.out.println("Aggiunta nuovo impianto sportivo ");
                System.out.println("------------------------------------------");
                System.out.println(" ");
                System.out.println("Inserisci nome impianto");
                String nome = sc.nextLine();
                System.out.println("Inserisci prezzo giornaliero dell'impianto");
                double prezzo = new Scanner(System.in).nextDouble();
                prototypeRepo.repo.creaEntita(new ImpiantoSportivo(nome, prezzo));
                System.out.println("Inserire Nuovo Impianto ? y/n");
                scelta = sc.nextLine();
                }
             while(scelta.equalsIgnoreCase("y"));
                                    
        }
    
}
