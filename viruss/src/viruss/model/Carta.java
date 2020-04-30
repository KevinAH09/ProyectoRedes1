
package viruss.model;

import javafx.scene.image.ImageView;



public class Carta extends ImageView{
    
    private String tipoCarta;
    private int color;
    private int altura;
    private int ancho;
    
    public Carta(String tipoCarta,int color,int altura,int ancho){
        this.setFitHeight(altura);
        this.setFitWidth(ancho);
        this.tipoCarta = tipoCarta;
        this.color = color;
        
        if(tipoCarta.equals("Virus"))
        {
            
            if(color == 1)
            {
                //this.setImage("");
            }
            if(color == 2)
            {
                //this.setImage("");
            }
            if(color == 3)
            {
                //this.setImage("");
            }
            if(color == 4)
            {
                //this.setImage("");
            }
            if(color == 5)
            {
                //this.setImage("");
            }
        }
        if(tipoCarta.equals("Tratamientos"))
        {
            if(color == 1)
            {
                //this.setImage("");
            }
            if(color == 2)
            {
                //this.setImage("");
            }
            if(color == 3)
            {
                //this.setImage("");
            }
            if(color == 4)
            {
                //this.setImage("");
            }
            if(color == 5)
            {
                //this.setImage("");
            }
        }
        if(tipoCarta.equals("Organos"))
        {
            if(color == 1)
            {
                //this.setImage("");
            }
            if(color == 2)
            {
                //this.setImage("");
            }
            if(color == 3)
            {
                //this.setImage("");
            }
            if(color == 4)
            {
                //this.setImage("");
            }
            if(color == 5)
            {
                //this.setImage("");
            }
        }
        if(tipoCarta.equals("Medicinas"))
        {
            if(color == 1)
            {
                //this.setImage("");
            }
            if(color == 2)
            {
                //this.setImage("");
            }
            if(color == 3)
            {
                //this.setImage("");
            }
            if(color == 4)
            {
                //this.setImage("");
            }
            if(color == 5)
            {
                //this.setImage("");
            }
        }
        this.setOnMouseClicked(ke->{
            System.out.println("Hola");
        });
    }
    
    public void setAltura(int altura)
    {
        this.altura = altura;
    }
    public void setAncho(int ancho)
    {
        this.ancho = ancho;
    }
    
    
}
