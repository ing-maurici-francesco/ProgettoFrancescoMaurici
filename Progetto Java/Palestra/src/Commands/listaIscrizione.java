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
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author francesco
 */
public class listaIscrizione implements ICommand{
    
    ConnectToDatabase conn = new DbConnectionSingleton.Connect().connectToDb();
       
        
        static RepositoryPrototype prototypeRepo = new RepositoryPrototype();
        static Scanner sc = new Scanner(System.in);
        
        public listaIscrizione(){}
    
         public static void execute() throws ParseException, SQLException 
         {
            prototypeRepo.setRepository("Iscrizione");
              List<Iscrizione> iscrizioni = prototypeRepo.repo.listaEntita();
                                    
                                    for(int i = 0; i<iscrizioni.size(); i++)
                                    {
                                        System.out.println(
                                                iscrizioni.get(i).Nome + " " + 
                                                iscrizioni.get(i).Cognome + " " + 
                                                iscrizioni.get(i).Data + " " +
                                                iscrizioni.get(i).Attivita + " " +
                                                iscrizioni.get(i).Servizio + "\n " 
                                        );
                                    }
         }
        
    
}
