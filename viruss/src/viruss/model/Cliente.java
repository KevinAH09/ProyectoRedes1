/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viruss.model;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class Cliente extends Conexion
{
    public Cliente() throws IOException{super("cliente");} //Se usa el constructor para cliente de Conexion

    public void startClient(Object objeto) //Método para iniciar el cliente
    {
        try
        {                  
            
            ObjectOutputStream carta1 = new ObjectOutputStream( cs.getOutputStream());
           
            // Se envía el objeto
            carta1.writeObject(objeto);           
            carta1.close();
            cs.close();//Fin de la conexión

        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}
