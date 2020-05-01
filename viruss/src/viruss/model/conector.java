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
    int puerto = 44440;
    ServerSocket server;
    Socket socket;
    DataOutputStream salida;
    DataInputStream entrada;
    public void iniciar() throws IOException
    {
        server = new ServerSocket(puerto);
        socket = new Socket();
        while (true) {            
            servidor();
        }
       
    }
    
    public void servidor(){
        try {
                socket = server.accept();
                entrada = new DataInputStream(socket.getInputStream());
                salida = new DataOutputStream(socket.getOutputStream());
                String mensaje = entrada.readUTF();
                System.out.println(mensaje);
                System.err.println("Adios mundo");
                socket.close();
        } catch (IOException ex) {
            Logger.getLogger(Socket.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
