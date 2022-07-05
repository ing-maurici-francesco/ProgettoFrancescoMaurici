/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Commands;

import Data.ConnectToDatabase;
import Data.DbConnectionSingleton;
import Model.Socio;
import Repository.RepositoryPrototype;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author francesco
 */
public class listaSocio implements ICommand{
    
    ConnectToDatabase conn = new DbConnectionSingleton.Connect().connectToDb();
    
        static RepositoryPrototype prototypeRepo = new RepositoryPrototype();
        static Scanner sc = new Scanner(System.in);
        
        public listaSocio()
        {
            
        }
    
        public static void execute() throws ParseException, SQLException {
            
            prototypeRepo.setRepository("Socio");
                
                List<Socio> soci = prototypeRepo.repo.listaEntita();
                for(int i = 0; i<soci.size(); i++)
                {
                    System.out.println(
                        soci.get(i).Nome + " " + 
                        soci.get(i).Cognome + " " + 
                        soci.get(i).Anno + " " +
                        soci.get(i).Tessera + " " +
                        soci.get(i).Email + "\n " 
                    );
                }
                                   
        }
    
}
