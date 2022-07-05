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
import java.util.Scanner;

/**
 *
 * @author francesco
 */
public class aggiornaSocio implements ICommand{

    ConnectToDatabase conn = new DbConnectionSingleton.Connect().connectToDb();
       
        
        static RepositoryPrototype prototypeRepo = new RepositoryPrototype();
        static Scanner sc = new Scanner(System.in);
        
        public aggiornaSocio()
        {
            
        }
    
    public static void execute() throws ParseException, SQLException {
        
        prototypeRepo.setRepository("Socio");                   
        
            System.out.println("------------------------------------------");
            System.out.println("Modifica Utente ");
            System.out.println("------------------------------------------");
            System.out.println("Inserisci nome socio");
            String nome = sc.nextLine();
            System.out.println("Inserisci cognome socio");
            String cognome = sc.nextLine();
            System.out.println("Inserisci email socio");
            String email = sc.nextLine();
            System.out.println("Inserisci anno di nascita socio");
            int anno = new Scanner(System.in).nextInt();
            System.out.println("Inserisci numero tessera socio");
            String tessera = sc.nextLine();
            prototypeRepo.repo.aggiornaEntita(new Socio(nome, cognome, email, anno, tessera));
        }
       
}
