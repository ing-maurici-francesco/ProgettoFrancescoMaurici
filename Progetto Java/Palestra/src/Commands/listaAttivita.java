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
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author francesco
 */
public class listaAttivita implements ICommand{
    
    ConnectToDatabase conn = new DbConnectionSingleton.Connect().connectToDb();
       
        
        static RepositoryPrototype prototypeRepo = new RepositoryPrototype();
        static Scanner sc = new Scanner(System.in);
        
        public listaAttivita()
        {
            
        }
    
        public static void execute() throws ParseException, SQLException {
            
            prototypeRepo.setRepository("Attivita");                        
            
            List<Attivita> activ = prototypeRepo.repo.listaEntita();
                                    
                                    for(int i = 0; i<activ.size(); i++)
                                    {
                                        System.out.println(
                                            activ.get(i).Descrizione + " " + 
                                            activ.get(i).Prezzo + "\n " 
                                        );
                                    }
        }
    
}
