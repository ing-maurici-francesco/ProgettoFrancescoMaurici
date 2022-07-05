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
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author francesco
 */
public class listaPrenotazione implements ICommand{
    
    ConnectToDatabase conn = new DbConnectionSingleton.Connect().connectToDb();
       
        
        static RepositoryPrototype prototypeRepo = new RepositoryPrototype();
        static Scanner sc = new Scanner(System.in);
        
        public listaPrenotazione()
        {
            
        }
    
         public static void execute() throws ParseException, SQLException 
         {
             prototypeRepo.setRepository("Prenotazione");
             
             List<Prenotazione> prenotaz = prototypeRepo.repo.listaEntita();
                                    
                                    for(int i = 0; i<prenotaz.size(); i++)
                                    {
                                        System.out.println(
                                                prenotaz.get(i).Nome + " " + 
                                                prenotaz.get(i).Cognome + " " + 
                                                prenotaz.get(i).Impianto + " " +
                                                prenotaz.get(i).Data +"\n " 
                                        );
                                    }
         }
    
}
