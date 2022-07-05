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
public class ricercaIscrizione implements ICommand{
    
    ConnectToDatabase conn = new DbConnectionSingleton.Connect().connectToDb();
       
        static RepositoryPrototype prototypeRepo = new RepositoryPrototype();
        static Scanner sc = new Scanner(System.in);
        
        public ricercaIscrizione()
        {
            
        }

    public static void execute() throws ParseException, SQLException {
                                   
        prototypeRepo.setRepository("Iscrizione");
        
        String[] parametri = new String[2];
                                    System.out.println("------------------------------------------");
                                    System.out.println("Dettaglio Iscrizione ");
                                    System.out.println("------------------------------------------");
                                    System.out.println(" ");
                                    System.out.println("Inserisci Nome Socio");
                                    parametri[0] = sc.nextLine();
                                    System.out.println("Inserisci Cognome Socio");
                                    parametri[1] = sc.nextLine();
                                    System.out.println("");
                                    prototypeRepo.repo.ricercaEntita(parametri);
                                    
    }
    
}
