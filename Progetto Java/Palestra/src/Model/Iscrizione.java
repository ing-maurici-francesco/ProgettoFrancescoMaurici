/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;


/**
 *
 * @author francesco
 */
public class Iscrizione{
    public int Id;
    public String Nome;
    public String Cognome;
    public String Data;
    public String Attivita;
    public String Servizio;
    
    
    public Iscrizione(String nome, String cognome, String data, String attivita, String servizio)
    {
        this.Nome = nome; 
        this.Cognome = cognome;
        this.Data = data;
        this.Attivita = attivita;
        this.Servizio = servizio;
    }

    public Iscrizione() {}
   
}
