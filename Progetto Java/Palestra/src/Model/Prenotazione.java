/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author francesco
 */
public class Prenotazione{
    public int Id;
    public String Nome;
    public String Cognome;
    public String Impianto;
    public String Data;    
    
    public Prenotazione (String nome, String cognome, String impianto, String data)
    {
        this.Nome = nome;
        this.Cognome = cognome;
        this.Impianto = impianto;
        this.Data = data; 
    }

    public Prenotazione() {}
    
}
