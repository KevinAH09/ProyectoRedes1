/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viruss.model;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author colo7
 */
public class cliente {
    ServerSocket server;
    Socket socket;
    String host = "192.168.1.4";
    int puerto = 333;
    DataOutputStream salida;
    DataInputStream entrada;
    public void iniciar() throws IOException
    {

       try {
            socket = new Socket(host,puerto);
            entrada = new DataInputStream(socket.getInputStream());
            salida = new DataOutputStream(socket.getOutputStream());
            salida.writeUTF("HOLAAAAAAAAAAAA");
            socket.close();
        } catch (IOException ex) {
            Logger.getLogger(Socket.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
