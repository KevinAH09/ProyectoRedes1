/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viruss.model;


import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author colo7
 */
public class sokect {
   
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        conector c = new conector();
        try {
           
            c.iniciar();
        } catch (IOException ex) {
            Logger.getLogger(Socket.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

  
    
}
