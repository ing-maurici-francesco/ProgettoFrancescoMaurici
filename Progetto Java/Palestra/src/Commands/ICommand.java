/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Commands;

import java.sql.SQLException;
import java.text.ParseException;

/**
 *
 * @author francesco
 */
public interface ICommand {
    
    public static void execute() throws ParseException, SQLException {};
    
}
