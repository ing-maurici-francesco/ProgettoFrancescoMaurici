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

/**
 *
 * @author francesco
 */
public class eliminaServizio implements ICommand{
    
    ConnectToDatabase conn = new DbConnectionSingleton.Connect().connectToDb();
       
        static RepositoryPrototype prototypeRepo = new RepositoryPrototype();
        static Scanner sc = new Scanner(System.in);
        
        public eliminaServizio()
        {
            
        }
    
        public static void execute() throws ParseException, SQLException 
        {
            
            prototypeRepo.setRepository("Servizio");
            
            String scelta = "y";
                                    
            do{   
                String[] parametri = new String[1];
                System.out.println("------------------------------------------");
                System.out.println("Elimina Servizio ");
                System.out.println("------------------------------------------");
                System.out.println("Inserisci nome servizio da eliminare");
                parametri[0] = sc.nextLine();
                prototypeRepo.repo.eliminaEntita(parametri);
                System.out.println("Eliminare un altro servizio ? y/n");
                scelta = sc.nextLine();
            }
            while(scelta.equalsIgnoreCase("y"));
        }
}
