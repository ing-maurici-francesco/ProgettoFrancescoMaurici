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
public class aggiornaAttivita implements ICommand{
    
     private Attivita attivita;
     ConnectToDatabase conn = new DbConnectionSingleton.Connect().connectToDb();
       
        
        static RepositoryPrototype prototypeRepo = new RepositoryPrototype();
        static Scanner sc = new Scanner(System.in);
        
        public aggiornaAttivita()
        {
            
        }
    
    public static void execute() throws ParseException, SQLException 
    {
        prototypeRepo.setRepository("Attivita");
        
            System.out.println("------------------------------------------");
            System.out.println("Modifica Informazioni Attivita ");
            System.out.println("------------------------------------------");
            System.out.println("Inserisci descrizione attivita");
            String descrizione = sc.nextLine();
            System.out.println("Inserisci prezzo attivita");
            double prezzo = new Scanner(System.in).nextDouble();
            prototypeRepo.repo.aggiornaEntita(new Attivita(descrizione, prezzo));             
        
    }
    
}
