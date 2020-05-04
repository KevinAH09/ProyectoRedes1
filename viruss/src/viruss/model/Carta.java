package viruss.model;


import javafx.scene.image.Image;
import javafx.scene.image.ImageView;



public class Carta extends ImageView{
    
    private String tipoCarta;
    private int color;
    private int altura;
    private int ancho;
    public Image img;
    static int cont = 0;
    static String tipo = "";
    static int p =0;
    
    public Carta(String img,String tipoCarta,int color,int altura,int ancho){
        this.setFitHeight(altura);
        this.setFitWidth(ancho);
        this.tipoCarta = tipoCarta;
        this.color = color;
        this.img = new Image(img);
        if(tipoCarta.equals("Virus"))
        {
            
            if(color == 1)//ROJIVIRUS
            {
                this.setImage(this.img);
            }
            if(color == 2)//VERDON EL VIRUS
            {
                this.setImage(this.img);
            }
            if(color == 3)//VIRUBLU
            {
                this.setImage(this.img);
            }
            if(color == 4)//YELLVIRUS
            {
                this.setImage(this.img);
            }
            if(color == 5)//COVID-19
            {
                this.setImage(this.img);
            }
        }
        if(tipoCarta.equals("Tratamientos"))
        {
            if(color == 1)//Transplante
            {
                this.setImage(this.img);
            }
            if(color == 2)//Ladrón de órganos
            {
                this.setImage(this.img);
            }
            if(color == 3)//Contagio
            {
                this.setImage(this.img);
            }
            if(color == 4)//Guante de látex
            {
               this.setImage(this.img);
            }
            if(color == 5)//Error médico
            {
                this.setImage(this.img);
            }
        }
        if(tipoCarta.equals("Organos"))
        {
            if(color == 1)//corazon
            {
                this.setImage(this.img);
            }
            if(color == 2)//estomago
            {
                this.setImage(this.img);
            }
            if(color == 3)//cerebro
            {
                this.setImage(this.img);
            }
            if(color == 4)//hueso
            {
                this.setImage(this.img);
            }
            if(color == 5)//comodin
            {
                this.setImage(this.img);
            }
        }
        if(tipoCarta.equals("Medicinas"))
        {
            if(color == 1)
            {
                this.setImage(this.img);
            }
            if(color == 2)
            {
                this.setImage(this.img);
            }
            if(color == 3)
            {
                this.setImage(this.img);
            }
            if(color == 4)
            {
                this.setImage(this.img);
            }
            if(color == 5)
            {
                this.setImage(this.img);
            }
        }
        
        this.setOnMouseClicked(ke->{
            
            
            if(cont == 0)
            {
                tipo=this.tipoCarta;
                p = this.color;
                System.out.println(tipo);
                System.out.println(p);
                cont++;
            }
            else if(cont==1)
            {
                if(this.tipoCarta.equals("Organos"))
                {
                    System.out.println(this.tipoCarta);
                    if(this.color==1)
                    {
                        System.out.println(this.color);
                        System.out.println(tipo);
                        if(tipo.equals("Virus"))
                        {
                            
                            if(p==1)
                            {
                                  System.out.println("hola");
                            }
                        }   
                    }
                }
                
                cont=0;
            }
            
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
