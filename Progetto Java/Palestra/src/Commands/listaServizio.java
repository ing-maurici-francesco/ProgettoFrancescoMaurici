/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Commands;

/**
 *
 * @author francesco
 */

import Data.ConnectToDatabase;
import Data.DbConnectionSingleton;
import Model.Servizio;
import Repository.RepositoryPrototype;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;
import java.util.Scanner;

public class listaServizio implements ICommand{
    
        ConnectToDatabase conn = new DbConnectionSingleton.Connect().connectToDb();
       
        static RepositoryPrototype prototypeRepo = new RepositoryPrototype();
        static Scanner sc = new Scanner(System.in);
        
        public listaServizio()
        {
            
        }
    
        public static void execute() throws ParseException, SQLException {
            
            prototypeRepo.setRepository("Servizio"); 
            
            List<Servizio> serv = prototypeRepo.repo.listaEntita();
                                    
            for(int i = 0; i<serv.size(); i++)
            {
                System.out.println(
                serv.get(i).Descrizione + " " + 
                serv.get(i).Prezzo + "\n " 
                );
            }
        }
    
}
