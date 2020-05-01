/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viruss.model;

import java.io.*;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author colo7
 */
public class conector {
    ServerSocket server;
    Socket socket;
    int puerto = 3333;
    DataOutputStream salida;
    DataInputStream entrada;
    
    public void iniciar() throws IOException
    {

       try {
                
                while(true){
                    server = new ServerSocket(puerto);
                    socket = new Socket();
                    socket = server.accept();
                    
                    entrada = new DataInputStream(socket.getInputStream());
                    salida = new DataOutputStream(socket.getOutputStream());
                    String mensaje = entrada.readUTF();
                    System.out.println(mensaje);
                    System.err.println("Adios mundo");
                    
                }
                
        } catch (IOException ex) {
            Logger.getLogger(Socket.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
