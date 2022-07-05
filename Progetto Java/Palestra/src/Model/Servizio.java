/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author francesco
 */
public class Servizio{
    public int Id;
    public double Prezzo;
    public String Descrizione;
    
    public Servizio(String descrizione, double prezzo){
        this.Descrizione = descrizione;
        this.Prezzo = prezzo;  
    }
    
    public Servizio(){}
    
}
