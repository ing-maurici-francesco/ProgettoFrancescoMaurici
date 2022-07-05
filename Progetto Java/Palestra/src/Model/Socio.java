package Model;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author francesco
 */
public class Socio{
    
    public int Id;
    public String Nome;
    public String Cognome; 
    public String Email;
    public int Anno; 
    public String Tessera; 
    
    
    public Socio(String nome, String cognome, String email, int anno, String tessera)
    {
        this.Nome = nome; 
        this.Cognome = cognome;
        this.Email = email;
        this.Anno = anno;
        this.Tessera = tessera;
    }

    public Socio(){}

    }
