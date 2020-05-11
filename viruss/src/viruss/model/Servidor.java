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
                List<Carta> lc =(List<Carta>) inObjeto.readObject();
                System.out.println("Recibo: " + lc.get(0).getAltura() + "" + lc.get(0).getAncho());
                System.out.println("Recibo: " + lc.get(1).getAltura() + "" + lc.get(1).getAncho());             
                System.out.println(cs.getInetAddress().toString());

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
