package viruss.model;


import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


import java.io.Serializable;
public class Carta extends ImageView implements Serializable{
    
    private String tipoCarta;
    public int color;
    public int altura;
    public int ancho;
    public Image img;
    
    
    static int cont=0;
    static int c;
    static String tipo;
    static Image image;

    public Carta() {
    }
    
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
            
           jugar();
           
        });
    }
    
    public void jugar()
    {
        if(cont ==0)
            {
                if(this.tipoCarta.equals("Virus"))
                {
                    if(this.color==1)
                    {
                        c=this.color;
                        tipo=this.tipoCarta;
                        image=this.img;
                    }
                }
                else if(this.tipoCarta.equals("Medicinas"))
                {
                    if(this.color == 11)
                    {
                        c=this.color;
                        tipo=this.tipoCarta;
                        image=this.img;
                    }
                }
                cont++;
            }
            else if(cont==1){
                if(this.tipoCarta.equals("Organos"))
                {
                    if(this.color==1)
                    {
                        this.setImage(image);
                        this.setTipoCarta("OrganosVirus");
                        this.setColor(11);
                    }
                }
                else if(this.tipoCarta.equals("OrganosVirus"))
                {
                    if(this.color==11)
                    {
                       image= new Image("viruss/recursos/CORAZON.jpg");
                        this.setImage(image);
                        this.setTipoCarta("Organos");
                        this.setColor(1);
                    }
                }
                
                cont=0;
            }
    }
    
    public void setAltura(int altura)
    {
        this.altura = altura;
    }
        public int getAltura() {
        return altura;
    }
    public void setAncho(int ancho)
    {
        this.ancho = ancho;
    }
    public int getAncho() {
        return ancho;
    }

    public String getTipoCarta() {
        return tipoCarta;
    }

    public void setTipoCarta(String tipoCarta) {
        this.tipoCarta = tipoCarta;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public Image getImg() {
        return img;
    }

    public void setImg(Image img) {
        this.img = img;
    }
    
    
    
}
