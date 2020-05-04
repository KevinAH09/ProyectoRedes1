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
            System.out.println(this.color);
            System.out.println(this.tipoCarta);
        });
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
