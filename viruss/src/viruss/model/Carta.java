
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
            
            if(color == 1)//ROJIVIRUS
            {
                //this.setImage("");
            }
            if(color == 2)//VERDON EL VIRUS
            {
                //this.setImage("");
            }
            if(color == 3)//VIRUBLU
            {
                //this.setImage("");
            }
            if(color == 4)//YELLVIRUS
            {
                //this.setImage("");
            }
            if(color == 5)//COVID-19
            {
                //this.setImage("");
            }
        }
        if(tipoCarta.equals("Tratamientos"))
        {
            if(color == 1)//Transplante
            {
                //this.setImage("");
            }
            if(color == 2)//Ladrón de órganos
            {
                //this.setImage("");
            }
            if(color == 3)//Contagio
            {
                //this.setImage("");
            }
            if(color == 4)//Guante de látex
            {
                //this.setImage("");
            }
            if(color == 5)//Error médico
            {
                //this.setImage("");
            }
        }
        if(tipoCarta.equals("Organos"))
        {
            if(color == 1)//corazon
            {
                //this.setImage("");
            }
            if(color == 2)//estomago
            {
                //this.setImage("");
            }
            if(color == 3)//cerebro
            {
                //this.setImage("");
            }
            if(color == 4)//hueso
            {
                //this.setImage("");
            }
            if(color == 5)//comodin
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
