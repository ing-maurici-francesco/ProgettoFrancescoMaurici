/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

/**
 *
 * @author francesco
 */
public class RepositoryPrototype {
    
    public static IRepository repo;
    
    public static void setRepository(String entita)
    {
        switch(entita)
        {
            case "Socio":
                repo = new SocioRepository();
                break;
            case "Attivita":
                repo = new AttivitaRepository();
                break;
            case "Servizio":
                repo = new ServizioRepository();
                break;
            case "ImpiantoSportivo":
                repo = new ImpiantoSportivoRepository();
                break;
            case "Prenotazione":
                repo = new PrenotazioneRepository();
                break;
            case "Iscrizione":
                repo = new IscrizioneRepository();
                break;
            default:
                repo = null;
        }
    }
    
}
