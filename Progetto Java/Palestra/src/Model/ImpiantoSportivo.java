/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;


/**
 *
 * @author francesco
 */
public class ImpiantoSportivo {
    
    public int Id;
    public String Descrizione;
    public double Prezzo;
    
    public ImpiantoSportivo (String descrizione, double prezzo)
    {
        this.Descrizione = descrizione;
        this.Prezzo = prezzo;
    }

    public ImpiantoSportivo() {}
}
