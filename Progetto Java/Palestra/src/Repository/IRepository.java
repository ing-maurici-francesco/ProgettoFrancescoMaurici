/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author francesco
 */
public interface IRepository<T> {
 
    public List<T> listaEntita() throws SQLException;
    public T creaEntita(T entity) throws SQLException;
    public T aggiornaEntita(T entity) throws SQLException;
    public boolean eliminaEntita(String[] chiavi) throws SQLException;
    public ResultSet eseguiQuery(String query) throws SQLException;
    public T ricercaEntita(String[] chiavi) throws SQLException;
    
}
