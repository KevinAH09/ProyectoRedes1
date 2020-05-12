/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viruss.model;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

public class Servidor extends Conexion 
{
    public Servidor() throws IOException{super("servidor");} //Se usa el constructor para servidor de Conexion

    public void startServer()//Método para iniciar el servidor
    {
        try
        {
                System.out.println("Esperando..."); //Esperando conexión
                cs = ss.accept(); //Accept comienza el socket y espera una conexión desde un cliente
                System.out.println("Cliente en línea");
                
                ObjectInputStream inObjeto = new ObjectInputStream( cs.getInputStream());
                Juego lc =(Juego) inObjeto.readObject();          
                System.out.println(cs.getInetAddress().toString());
//                String ip = cs.getInetAddress().toString();
//                ip.replaceAll("/", "");
//                if(MainServidor.juegoMain.jugadores.isEmpty()){
//                    MainServidor.juegoMain = lc;
//                    MainServidor.juegoMain.jugadores.get(0).setIp(ip);
//                }else{
//                    lc.jugadores.get(0).ip=ip;
//                    MainServidor.juegoMain.jugadores.add(lc.jugadores.get(0));                    
//                }
//                for (Jugador object : MainServidor.juegoMain.jugadores) {
//                    System.out.println(object.nickname);
//                }
                System.out.println("Fin de la conexión");
                inObjeto.close();
                cs.close();
                ss.close();//Se finaliza la conexión con el cliente
           
            
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}
