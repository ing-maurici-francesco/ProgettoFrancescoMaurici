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
public class aggiornaImpiantoSportivo implements ICommand{
    
     ConnectToDatabase conn = new DbConnectionSingleton.Connect().connectToDb();
       
        
        static RepositoryPrototype prototypeRepo = new RepositoryPrototype();
        static Scanner sc = new Scanner(System.in);
        
        public aggiornaImpiantoSportivo()
        {
            
        }
    
    public static void execute() throws ParseException, SQLException 
    {
        prototypeRepo.setRepository("ImpiantoSportivo");
        
            System.out.println("------------------------------------------");
            System.out.println("Modifica Informazioni impianto ");
            System.out.println("------------------------------------------");
            System.out.println("Inserisci descrizione Impianto");
            String descrizione = sc.nextLine();
            System.out.println("Inserisci prezzo impianto");
            double prezzo = new Scanner(System.in).nextDouble();
            prototypeRepo.repo.aggiornaEntita(new ImpiantoSportivo(descrizione, prezzo));             
        
    }
    
}
