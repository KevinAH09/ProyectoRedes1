package viruss.model;


import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


import java.io.Serializable;
import java.util.List;
import viruss.controller.InicioController;
public class Carta extends ImageView implements Serializable{
    
    private String tipoCarta;
    public int color;
    public int altura;
    public int ancho;
    public Image img;
    
    
    List <Carta> lista;
    
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
                if(this.tipoCarta.equals("Organos"))//-----------------------------------------------------------------------     ORGANOS SOBRE MESA    --------------------------------------------------------
                {
                    if(this.color==1)
                    {
                        if(InicioController.listaMasoJugador.stream().filter(x->x.getColor()==this.color && x.getTipoCarta().equals(this.tipoCarta)).count()>=1)
                        {
                            
                            c=this.color;
                            tipo=this.tipoCarta;
                            
                        }
                    }
                    
                    if(this.color==2)
                    {
                        if(InicioController.listaMasoJugador.stream().filter(x->x.getColor()==this.color && x.getTipoCarta().equals(this.tipoCarta)).count()>=1)
                        {
                            
                            c=this.color;
                            tipo=this.tipoCarta;
                        }
                    }
                    
                    if(this.color==3)
                    {
                        if(InicioController.listaMasoJugador.stream().filter(x->x.getColor()==this.color && x.getTipoCarta().equals(this.tipoCarta)).count()>=1)
                        {
                            
                            c=this.color;
                            tipo=this.tipoCarta;
                        }
                    }
                    
                    if(this.color==4)
                    {
                        if(InicioController.listaMasoJugador.stream().filter(x->x.getColor()==this.color && x.getTipoCarta().equals(this.tipoCarta)).count()>=1)
                        {
                            
                            c=this.color;
                            tipo=this.tipoCarta;
                        }
                    }
                    
//                    if(this.color==)
//                    {
//                        
//                    }
                }
                if(this.tipoCarta.equals("Virus"))//-----------------------------------------------------------------------     VIRUS     --------------------------------------------------------
                {
                    if(this.color==1)
                    {
                        if(InicioController.listaMasoJugador.stream().filter(x->x.getColor()==this.color && x.getTipoCarta().equals(this.tipoCarta)).count()>=1)
                        {
                            
                            c=this.color;
                            tipo=this.tipoCarta;
                            image=new Image("viruss/recursos/rojoinfectado.jpg");
                        }
                    }
                    
                    if(this.color==2)
                    {
                        if(InicioController.listaMasoJugador.stream().filter(x->x.getColor()==this.color && x.getTipoCarta().equals(this.tipoCarta)).count()>=1)
                        {
                            
                            c=this.color;
                            tipo=this.tipoCarta;
                            image=new Image("viruss/recursos/verdeinfectado.jpg");
                        }
                    }
                    
                    if(this.color==3)
                    {
                        if(InicioController.listaMasoJugador.stream().filter(x->x.getColor()==this.color && x.getTipoCarta().equals(this.tipoCarta)).count()>=1)
                        {
                            
                            c=this.color;
                            tipo=this.tipoCarta;
                            image=new Image("viruss/recursos/azulinfectado.jpg");
                        }
                    }
                    
                    if(this.color==4)
                    {
                        if(InicioController.listaMasoJugador.stream().filter(x->x.getColor()==this.color && x.getTipoCarta().equals(this.tipoCarta)).count()>=1)
                        {
                            
                            c=this.color;
                            tipo=this.tipoCarta;
                            image=new Image("viruss/recursos/amarilloinfectado.jpg");
                        }
                    }
                }
                if(this.tipoCarta.equals("Medicinas"))//-----------------------------------------------------------------------     MEDICINA     --------------------------------------------------------
                {
                    if(this.color == 1)
                    {
                        if(InicioController.listaMasoJugador.stream().filter(x->x.getColor()==this.color && x.getTipoCarta().equals(this.tipoCarta)).count()>=1)
                        {
                            c=this.color;
                            tipo=this.tipoCarta;
                        }
                        
                    }
                    
                    if(this.color == 2)
                    {
                        if(InicioController.listaMasoJugador.stream().filter(x->x.getColor()==this.color && x.getTipoCarta().equals(this.tipoCarta)).count()>=1)
                        {
                            c=this.color;
                            tipo=this.tipoCarta;
                        }
                        
                    }
                    
                    if(this.color == 3)
                    {
                        if(InicioController.listaMasoJugador.stream().filter(x->x.getColor()==this.color && x.getTipoCarta().equals(this.tipoCarta)).count()>=1)
                        {
                            c=this.color;
                            tipo=this.tipoCarta;
                        }
                        
                    }
                    
                    if(this.color == 4)
                    {
                        if(InicioController.listaMasoJugador.stream().filter(x->x.getColor()==this.color && x.getTipoCarta().equals(this.tipoCarta)).count()>=1)
                        {
                            c=this.color;
                            tipo=this.tipoCarta;
                        }
                        
                    }
                    
                    
                    
                }
                cont++;
            }
            else if(cont==1){
                if(this.tipoCarta.equals("Organos"))//-----------------------------------------------------------------------     ORGANOS     --------------------------------------------------------
                {
                    if(this.color==1)
                    {
                        
                        for (Carta carta : InicioController.listaMasoJugador) {
                            if(carta.getColor()==c){
                                if(carta.getTipoCarta().equals(tipo))
                                {
                                    InicioController.listaCementerio.add(carta);
                                    InicioController.listaMasoJugador.remove(carta);
                                    InicioController.masoStatico.getChildren().clear();
                                    InicioController.masoStatico.getChildren().addAll(InicioController.listaMasoJugador);
                                    this.setImage(image);
                                    this.setTipoCarta("OrganosVirus");
                                    this.setColor(11);
                                    break;
                                }
                            }
                        }
                    }
                    
                    if(this.color==2)
                    {
                        for (Carta carta : InicioController.listaMasoJugador) {
                            if(carta.getColor()==c){
                                if(carta.getTipoCarta().equals(tipo))
                                {
                                    InicioController.listaCementerio.add(carta);
                                    InicioController.listaMasoJugador.remove(carta);
                                    InicioController.masoStatico.getChildren().clear();
                                    InicioController.masoStatico.getChildren().addAll(InicioController.listaMasoJugador);
                                    this.setImage(image);
                                    this.setTipoCarta("OrganosVirus");
                                    this.setColor(22);
                                    break;
                                }
                            }
                        }
                    }
                    
                    if(this.color==3)
                    {
                        for (Carta carta : InicioController.listaMasoJugador) {
                            if(carta.getColor()==c){
                                if(carta.getTipoCarta().equals(tipo))
                                {
                                    InicioController.listaCementerio.add(carta);
                                    InicioController.listaMasoJugador.remove(carta);
                                    InicioController.masoStatico.getChildren().clear();
                                    InicioController.masoStatico.getChildren().addAll(InicioController.listaMasoJugador);
                                    this.setImage(image);
                                    this.setTipoCarta("OrganosVirus");
                                    this.setColor(33);
                                    break;
                                }
                            }
                        }
                    }
                    
                    if(this.color==4)
                    {
                        for (Carta carta : InicioController.listaMasoJugador) {
                            if(carta.getColor()==c){
                                if(carta.getTipoCarta().equals(tipo))
                                {
                                    InicioController.listaCementerio.add(carta);
                                    InicioController.listaMasoJugador.remove(carta);
                                    InicioController.masoStatico.getChildren().clear();
                                    InicioController.masoStatico.getChildren().addAll(InicioController.listaMasoJugador);
                                    this.setImage(image);
                                    this.setTipoCarta("OrganosVirus");
                                    this.setColor(44);
                                    break;
                                }
                            }
                        }
                    }
                }
                else if(this.tipoCarta.equals("OrganosVirus"))//-----------------------------------------------------------------------     ORGANOS-VIRUS     --------------------------------------------------------
                {
                    if(this.color==11)//CORAZON-VIRUS
                    {
                        for (Carta carta : InicioController.listaMasoJugador) {
                            if(carta.getColor()==c){
                                if(carta.getTipoCarta().equals(tipo))
                                {
                                    InicioController.listaCementerio.add(carta);
                                    InicioController.listaMasoJugador.remove(carta);
                                    InicioController.masoStatico.getChildren().clear();
                                    InicioController.masoStatico.getChildren().addAll(InicioController.listaMasoJugador);
                                    image= new Image("viruss/recursos/CORAZON.jpg");
                                     this.setImage(image);
                                     this.setTipoCarta("Organos");
                                     this.setColor(1);
                                     break;
                                }
                            }
                        }
                    }
                    
                    if(this.color==22)//ESTOMAGO-VIRUS
                    {
                        for (Carta carta : InicioController.listaMasoJugador) {
                            if(carta.getColor()==c){
                                if(carta.getTipoCarta().equals(tipo))
                                {
                                    InicioController.listaCementerio.add(carta);
                                    InicioController.listaMasoJugador.remove(carta);
                                    InicioController.masoStatico.getChildren().clear();
                                    InicioController.masoStatico.getChildren().addAll(InicioController.listaMasoJugador);
                                    image= new Image("viruss/recursos/ESTOMAGO.jpg");
                                     this.setImage(image);
                                     this.setTipoCarta("Organos");
                                     this.setColor(2);
                                     break;
                                }
                            }
                        }
                    }
                    
                    if(this.color==33)//CEREBRO-VIRUS
                    {
                        for (Carta carta : InicioController.listaMasoJugador) {
                            if(carta.getColor()==c){
                                if(carta.getTipoCarta().equals(tipo))
                                {
                                    InicioController.listaCementerio.add(carta);
                                    InicioController.listaMasoJugador.remove(carta);
                                    InicioController.masoStatico.getChildren().clear();
                                    InicioController.masoStatico.getChildren().addAll(InicioController.listaMasoJugador);
                                    image= new Image("viruss/recursos/CEREBRO.jpg");
                                     this.setImage(image);
                                     this.setTipoCarta("Organos");
                                     this.setColor(3);
                                     break;
                                }
                            }
                        }
                    }
                    
                    if(this.color==44)//HUESO-VIRUS
                    {
                        for (Carta carta : InicioController.listaMasoJugador) {
                            if(carta.getColor()==c){
                                if(carta.getTipoCarta().equals(tipo))
                                {
                                    InicioController.listaCementerio.add(carta);
                                    InicioController.listaMasoJugador.remove(carta);
                                    InicioController.masoStatico.getChildren().clear();
                                    InicioController.masoStatico.getChildren().addAll(InicioController.listaMasoJugador);
                                    image= new Image("viruss/recursos/HUESO.jpg");
                                     this.setImage(image);
                                     this.setTipoCarta("Organos");
                                     this.setColor(4);
                                     break;
                                }
                            }
                        }
                    }
                }
//                else if(InicioController.miMesa.)
//                {
//                    System.out.println("hola");
//                }
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
