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

    public void startClient() //Método para iniciar el cliente
    {
        try
        {        
//          //Se recibe un objeto
            int x=0;
            int y=0;
            List<Carta> res =new ArrayList();
           for(int i=0;i<2;i++){
                Carta cart=new Carta();
                cart.setAltura(150+x);
                cart.setAncho(50+y);
                res.add(cart);
                x+=50;
                y+=75;
            }
            
            //FLUJO DE salida para objetos
            ObjectOutputStream carta1 = new ObjectOutputStream( cs.getOutputStream());
           
            // Se envía el objeto
            carta1.writeObject(res);           
            carta1.close();
            cs.close();//Fin de la conexión

        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}
