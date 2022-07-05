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
public class eliminaPrenotazione implements ICommand{
    
    ConnectToDatabase conn = new DbConnectionSingleton.Connect().connectToDb();
       
        static RepositoryPrototype prototypeRepo = new RepositoryPrototype();
        static Scanner sc = new Scanner(System.in);
        
        public eliminaPrenotazione(){}
    
        public static void execute() throws ParseException, SQLException {
            
            prototypeRepo.setRepository("Prenotazione");
            
            String scelta = "y";
                                    
            do{   
                String[] parametri = new String[2];
                System.out.println("------------------------------------------");
                System.out.println("Elimina Prenotazione ");
                System.out.println("------------------------------------------");
                System.out.println("Inserisci nome impianto");
                parametri[0] = sc.nextLine();
                System.out.println("Inserisci data prenotazione");
                parametri[1] = sc.nextLine();
                boolean a = prototypeRepo.repo.eliminaEntita(parametri);
                
                if(a != false)
                {
                    System.out.println("Prenotazione eliminata correttamente! \n");
                }
                
                System.out.println("Eliminare altra Prenotazione? y/n");
                scelta = sc.nextLine();
            }
            while(scelta.equalsIgnoreCase("y"));
        }
    
}
