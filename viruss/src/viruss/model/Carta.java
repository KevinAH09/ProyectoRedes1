package viruss.model;


import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


import java.io.Serializable;
import java.util.List;
import javafx.geometry.Point2D;
import viruss.controller.InicioController;
public class Carta extends ImageView implements Serializable{
    
    private String tipoCarta;
    public int color;
    public int altura;
    public int ancho;
    public Image img;
    public String estado;
    
    public static Carta CartaAux;
    List <Carta> lista;
    
    public static int cont=0;
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
                this.estado = "Estable";
                this.setImage(this.img);
            }
            if(color == 2)//estomago
            {
                this.estado = "Estable";
                this.setImage(this.img);
            }
            if(color == 3)//cerebro
            {
                this.estado = "Estable";
                this.setImage(this.img);
            }
            if(color == 4)//hueso
            {
                this.estado = "Estable";
                this.setImage(this.img);
            }
            if(color == 5)//comodin
            {
                this.estado = "Estable";
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
                        if(MainServidor.juegoMain.jugadores.get(0).mazo1.stream().filter(x->x.getColor()==this.color && x.getTipoCarta().equals(this.tipoCarta)).count()>=1)
                        {
                            InicioController.cartaSelec = this;
                            
                            
                        }
                    }
                    
                    if(this.color==2)
                    {
                        if(MainServidor.juegoMain.jugadores.get(0).mazo1.stream().filter(x->x.getColor()==this.color && x.getTipoCarta().equals(this.tipoCarta)).count()>=1)
                        {
                            InicioController.cartaSelec = this;
                            
                        }
                    }
                    
                    if(this.color==3)
                    {
                        if(MainServidor.juegoMain.jugadores.get(0).mazo1.stream().filter(x->x.getColor()==this.color && x.getTipoCarta().equals(this.tipoCarta)).count()>=1)
                        {
                            InicioController.cartaSelec = this;
                            
                        }
                    }
                    
                    if(this.color==4)
                    {
                        if(MainServidor.juegoMain.jugadores.get(0).mazo1.stream().filter(x->x.getColor()==this.color && x.getTipoCarta().equals(this.tipoCarta)).count()>=1)
                        {
                            InicioController.cartaSelec = this;
                            
                        }
                    }
                    
                    if(this.color==5)
                    {
                        if(MainServidor.juegoMain.jugadores.get(0).mazo1.stream().filter(x->x.getColor()==this.color && x.getTipoCarta().equals(this.tipoCarta)).count()>=1)
                        {
                            InicioController.cartaSelec = this;
                            
                        }
                    }
                    
                    
                }
                if(this.tipoCarta.equals("Virus"))//-----------------------------------------------------------------------     VIRUS     --------------------------------------------------------
                {
                    if(this.color==1)
                    {
                        if(MainServidor.juegoMain.jugadores.get(0).mazo1.stream().filter(x->x.getColor()==this.color && x.getTipoCarta().equals(this.tipoCarta)).count()>=1)
                        {
                            CartaAux=this;
                            image=new Image("viruss/recursos/rojoinfectado.jpg");
                            CartaAux.setImg(image);
                        }
                    }
                    
                    else if(this.color==2)
                    {
                        if(MainServidor.juegoMain.jugadores.get(0).mazo1.stream().filter(x->x.getColor()==this.color && x.getTipoCarta().equals(this.tipoCarta)).count()>=1)
                        {
                            
                            CartaAux=this;
                            image=new Image("viruss/recursos/verdeinfectado.jpg");
                            CartaAux.setImg(image);
                        }
                    }
                    
                    else if(this.color==3)
                    {
                        if(MainServidor.juegoMain.jugadores.get(0).mazo1.stream().filter(x->x.getColor()==this.color && x.getTipoCarta().equals(this.tipoCarta)).count()>=1)
                        {
                            
                            CartaAux=this;
                            image=new Image("viruss/recursos/azulinfectado.jpg");
                            CartaAux.setImg(image);
                        }
                    }
                    
                    else if(this.color==4)
                    {
                        if(MainServidor.juegoMain.jugadores.get(0).mazo1.stream().filter(x->x.getColor()==this.color && x.getTipoCarta().equals(this.tipoCarta)).count()>=1)
                        {
                            
                            CartaAux=this;
                            image=new Image("viruss/recursos/amarilloinfectado.jpg");
                            CartaAux.setImg(image);
                        }
                    }
                }
                if(this.tipoCarta.equals("Medicinas"))//-----------------------------------------------------------------------     MEDICINA     --------------------------------------------------------
                {
                    if(this.color == 1)
                    {
                        if(MainServidor.juegoMain.jugadores.get(0).mazo1.stream().filter(x->x.getColor()==this.color && x.getTipoCarta().equals(this.tipoCarta)).count()>=1)
                        {
                            CartaAux=this;
                        }
                        
                    }
                    
                    else if(this.color == 2)
                    {
                        if(MainServidor.juegoMain.jugadores.get(0).mazo1.stream().filter(x->x.getColor()==this.color && x.getTipoCarta().equals(this.tipoCarta)).count()>=1)
                        {
                            CartaAux=this;
                        }
                        
                    }
                    
                    else if(this.color == 3)
                    {
                        if(MainServidor.juegoMain.jugadores.get(0).mazo1.stream().filter(x->x.getColor()==this.color && x.getTipoCarta().equals(this.tipoCarta)).count()>=1)
                        {
                            CartaAux=this;
                        }
                        
                    }
                    
                    else if(this.color == 4)
                    {
                        if(MainServidor.juegoMain.jugadores.get(0).mazo1.stream().filter(x->x.getColor()==this.color && x.getTipoCarta().equals(this.tipoCarta)).count()>=1)
                        {
                            CartaAux=this;
                        }
                        
                    }
                    
                    
                    
                }
                cont++;
            }
            else if(cont==1){
                boolean fuera=true; //validacion de solo poder poner virus fuera del maso y de la mesa del jugador
                boolean dentroMedicina=true;//validacion de poder curar los organos de la mesa del jugador
                for(Carta cartas : MainServidor.juegoMain.jugadores.get(0).mazo2)
                {
                    if (cartas.equals(this)){
                        fuera=false;
                    }
                    
                }
                
                for(Carta cartass : MainServidor.juegoMain.jugadores.get(0).mazo2)
                {
                    if (cartass.equals(this)){
                        dentroMedicina=false;
                        fuera=false;
                    }
                    
                }
                
                if (this.tipoCarta.equals("Organos"))//-----------------------------------------------------------------------     ORGANOS     --------------------------------------------------------
            {
                   
                if (this.color == 1) {
                    if (this.color == CartaAux.color && CartaAux.tipoCarta.equals("Virus")&&  this.estado.equals("Estable")) { //-------------------CONTAMINAR ORGANO---------------------------------
                        for (Carta carta : MainServidor.juegoMain.jugadores.get(0).mazo1) {
                            if (carta.equals(CartaAux) && fuera) {
                                MainServidor.juegoMain.cementerio.add(CartaAux);
                                //InicioController.listaCementerio.add(CartaAux);
                                MainServidor.juegoMain.jugadores.get(0).mazo1.remove(carta);
                                InicioController.masoStatico.getChildren().clear();
                                InicioController.masoStatico.getChildren().addAll(MainServidor.juegoMain.jugadores.get(0).mazo1);
                                this.setImage(CartaAux.getImg());
                                this.setTipoCarta("OrganosVirus");
                                this.setColor(11);
                                this.setEstado("Contaminado");
                                break;

                            }
                        }
                    }
                    
                    else if (this.color == CartaAux.color && CartaAux.tipoCarta.equals("Medicinas")&&  this.estado.equals("Estable")) {//------------------- ORGANOS VACUNA --------------------------------
                        for (Carta carta : MainServidor.juegoMain.jugadores.get(0).mazo1) {
                            if (carta.equals(CartaAux) && !dentroMedicina) {
                                //InicioController.listaCementerio.add(CartaAux);
                                MainServidor.juegoMain.cementerio.add(CartaAux);
                                MainServidor.juegoMain.jugadores.get(0).mazo1.remove(carta);
                                InicioController.masoStatico.getChildren().clear();
                                InicioController.masoStatico.getChildren().addAll(MainServidor.juegoMain.jugadores.get(0).mazo1);
                                image = new Image("viruss/recursos/CORAZONINM.jpg");
                                CartaAux.setImg(image);
                                this.setImage(CartaAux.getImg());
                                this.setTipoCarta("OrganosVacuna");
                                break;

                            }
                        }
                    }
                    
                } else if (this.color == 2) {
                    if (this.color == CartaAux.color&&  CartaAux.tipoCarta.equals("Virus")&&this.estado.equals("Estable")) {
                        for (Carta carta : MainServidor.juegoMain.jugadores.get(0).mazo1) {
                            if (carta.equals(CartaAux)&& fuera) {

//                                InicioController.listaCementerio.add(CartaAux);
                                MainServidor.juegoMain.cementerio.add(CartaAux);
                                MainServidor.juegoMain.jugadores.get(0).mazo1.remove(carta);
                                InicioController.masoStatico.getChildren().clear();
                                InicioController.masoStatico.getChildren().addAll(MainServidor.juegoMain.jugadores.get(0).mazo1);
                                this.setImage(CartaAux.getImg());
                                this.setTipoCarta("OrganosVirus");
                                this.setColor(22);
                                this.setEstado("Contaminado");
                                break;

                            }
                        }
                    }
                    
                    else if (this.color == CartaAux.color && CartaAux.tipoCarta.equals("Medicinas")&&  this.estado.equals("Estable")) {//------------------- ORGANOS VACUNA --------------------------------
                        for (Carta carta : MainServidor.juegoMain.jugadores.get(0).mazo1) {
                            if (carta.equals(CartaAux) && !dentroMedicina) {
                                //InicioController.listaCementerio.add(CartaAux);
                                MainServidor.juegoMain.cementerio.add(CartaAux);
                                MainServidor.juegoMain.jugadores.get(0).mazo1.remove(carta);
                                InicioController.masoStatico.getChildren().clear();
                                InicioController.masoStatico.getChildren().addAll(MainServidor.juegoMain.jugadores.get(0).mazo1);
                                image = new Image("viruss/recursos/ESTOMAGOINM.jpg");
                                CartaAux.setImg(image);
                                this.setImage(CartaAux.getImg());
                                this.setTipoCarta("OrganosVacuna");
                                break;

                            }
                        }
                    }
                    
                } else if (this.color == 3) {
                    if (this.color == CartaAux.color&& CartaAux.tipoCarta.equals("Virus")&&  this.estado.equals("Estable")) {
                        for (Carta carta : MainServidor.juegoMain.jugadores.get(0).mazo1) {
                            if (carta.equals(CartaAux)&& fuera) {

//                                InicioController.listaCementerio.add(CartaAux);
                                MainServidor.juegoMain.cementerio.add(CartaAux);
                                MainServidor.juegoMain.jugadores.get(0).mazo1.remove(carta);
                                InicioController.masoStatico.getChildren().clear();
                                InicioController.masoStatico.getChildren().addAll(MainServidor.juegoMain.jugadores.get(0).mazo1);
                                this.setImage(CartaAux.getImg());
                                this.setTipoCarta("OrganosVirus");
                                this.setColor(33);
                                this.setEstado("Contaminado");
                                break;
                            }
                        }
                    }
                    
                    else if (this.color == CartaAux.color && CartaAux.tipoCarta.equals("Medicinas")&&  this.estado.equals("Estable")) {//------------------- ORGANOS VACUNA --------------------------------
                        for (Carta carta : MainServidor.juegoMain.jugadores.get(0).mazo1) {
                            if (carta.equals(CartaAux) && !dentroMedicina) {
                                MainServidor.juegoMain.cementerio.add(CartaAux);
                                MainServidor.juegoMain.jugadores.get(0).mazo1.remove(carta);
                                InicioController.masoStatico.getChildren().clear();
                                InicioController.masoStatico.getChildren().addAll(MainServidor.juegoMain.jugadores.get(0).mazo1);
                                image = new Image("viruss/recursos/CEREBROINM.jpg");
                                CartaAux.setImg(image);
                                this.setImage(CartaAux.getImg());
                                this.setTipoCarta("OrganosVacuna");
                                break;

                            }
                        }
                    }
                    
                    
                } else if (this.color == 4) {
                    if (this.color == CartaAux.color&&  CartaAux.tipoCarta.equals("Virus")&& this.estado.equals("Estable")) {
                        for (Carta carta : MainServidor.juegoMain.jugadores.get(0).mazo1) {
                            if (carta.equals(CartaAux)&& fuera) {

                                //InicioController.listaCementerio.add(CartaAux);
                                MainServidor.juegoMain.cementerio.add(CartaAux);
                                MainServidor.juegoMain.jugadores.get(0).mazo1.remove(carta);
                                InicioController.masoStatico.getChildren().clear();
                                InicioController.masoStatico.getChildren().addAll(MainServidor.juegoMain.jugadores.get(0).mazo1);
                                this.setImage(CartaAux.getImg());
                                this.setTipoCarta("OrganosVirus");
                                this.setColor(44);
                                this.setEstado("Contaminado");
                                break;

                            }
                        }
                    }
                    
                    else if (this.color == CartaAux.color && CartaAux.tipoCarta.equals("Medicinas")&&  this.estado.equals("Estable")) {//------------------- ORGANOS VACUNA --------------------------------
                        for (Carta carta : MainServidor.juegoMain.jugadores.get(0).mazo1) {
                            if (carta.equals(CartaAux) && !dentroMedicina) {
                                MainServidor.juegoMain.cementerio.add(CartaAux);
                                MainServidor.juegoMain.jugadores.get(0).mazo1.remove(carta);
                                InicioController.masoStatico.getChildren().clear();
                                InicioController.masoStatico.getChildren().addAll(MainServidor.juegoMain.jugadores.get(0).mazo1);
                                image = new Image("viruss/recursos/HUESOINM.jpg");
                                CartaAux.setImg(image);
                                this.setImage(CartaAux.getImg());
                                this.setTipoCarta("OrganosVacuna");
                                break;

                            }
                        }
                    }
                    
                }
                
                
                
                }
                
                
            
                else if (this.tipoCarta.equals("OrganosVirus"))//-----------------------------------------------------------------------     ORGANOS-VIRUS     --------------------------------------------------------
                {
                    if (this.color == 11)//CORAZON-VIRUS
                    {
                        //--------------- CURAR ORGANOS -----------------
                        if (CartaAux.color==1 && CartaAux.tipoCarta.equals("Medicinas") &&this.estado.equals("Contaminado")) {
                            for (Carta carta : MainServidor.juegoMain.jugadores.get(0).mazo1) {
                                if (carta.equals(CartaAux) && !dentroMedicina) {

                                    MainServidor.juegoMain.cementerio.add(CartaAux);
                                    MainServidor.juegoMain.jugadores.get(0).mazo1.remove(carta);
                                    InicioController.masoStatico.getChildren().clear();
                                    InicioController.masoStatico.getChildren().addAll(MainServidor.juegoMain.jugadores.get(0).mazo1);
                                    image = new Image("viruss/recursos/CORAZON.jpg");
                                    this.setImage(image);
                                    this.setTipoCarta("Organos");
                                    this.setColor(1);
                                    this.setEstado("Estable");
                                    break;

                                }
                            }
                        }
                        
                        //--------------  MATAR ORGANOS    -------------------------------------------
                        
                        else if (CartaAux.color==1 && CartaAux.tipoCarta.equals("Virus") && this.estado.equals("Contaminado")) { 
                            for (Carta carta : MainServidor.juegoMain.jugadores.get(0).mazo1) {
                                if (carta.equals(CartaAux) && fuera) {
                                    MainServidor.juegoMain.cementerio.add(CartaAux);
                                    //InicioController.listaCementerio.add(CartaAux);
                                    MainServidor.juegoMain.jugadores.get(0).mazo1.remove(carta);
                                    InicioController.masoStatico.getChildren().clear();
                                    InicioController.masoStatico.getChildren().addAll(MainServidor.juegoMain.jugadores.get(0).mazo1);
                                    this.setTipoCarta("Organos");
                                    this.setColor(1);
                                    this.setEstado("Estable");
                                    image = new Image("viruss/recursos/CORAZON.jpg");
                                    this.setImage(image);
                                    //InicioController.listaCementerio.add(this);
                                    MainServidor.juegoMain.cementerio.add(this);
                                    InicioController.basura.getChildren().add(this);
                                    InicioController.basura.getChildren().remove(0);
                                    break;

                                }
                            }
                        }
                    
                } else if (this.color == 22)//ESTOMAGO-VIRUS
                {
                    //--------------- CURAR ORGANOS -----------------
                    if (CartaAux.color==2 && CartaAux.tipoCarta.equals("Medicinas")&& this.estado.equals("Contaminado")) {
                        for (Carta carta : MainServidor.juegoMain.jugadores.get(0).mazo1) {
                            if (carta.equals(CartaAux)&& !dentroMedicina) {

                                MainServidor.juegoMain.cementerio.add(CartaAux);
                                MainServidor.juegoMain.jugadores.get(0).mazo1.remove(carta);
                                InicioController.masoStatico.getChildren().clear();
                                InicioController.masoStatico.getChildren().addAll(MainServidor.juegoMain.jugadores.get(0).mazo1);
                                image = new Image("viruss/recursos/ESTOMAGO.jpg");
                                this.setImage(image);
                                this.setTipoCarta("Organos");
                                this.setColor(2);
                                this.setEstado("Estable");
                                break;

                            }
                        }
                    }
                    
                    //--------------  MATAR ORGANOS    -------------------------------------------
                        
                        else if (CartaAux.color==2 && CartaAux.tipoCarta.equals("Virus") && this.estado.equals("Contaminado")) { 
                            for (Carta carta : MainServidor.juegoMain.jugadores.get(0).mazo1) {
                                if (carta.equals(CartaAux) && fuera) {
                                    //InicioController.listaCementerio.add(CartaAux);
                                    MainServidor.juegoMain.cementerio.add(CartaAux);
                                    MainServidor.juegoMain.jugadores.get(0).mazo1.remove(carta);
                                    InicioController.masoStatico.getChildren().clear();
                                    InicioController.masoStatico.getChildren().addAll(MainServidor.juegoMain.jugadores.get(0).mazo1);
                                    this.setTipoCarta("Organos");
                                    this.setColor(2);
                                    this.setEstado("Estable");
                                    image = new Image("viruss/recursos/ESTOMAGO.jpg");
                                    this.setImage(image);
//                                    InicioController.listaCementerio.add(this);
                                    MainServidor.juegoMain.cementerio.add(this);  
                                    InicioController.basura.getChildren().add(this);
                                    InicioController.basura.getChildren().remove(0);
                                    break;

                                }
                            }
                        }
                    
                } else if (this.color == 33)//CEREBRO-VIRUS
                {
                    //--------------- CURAR ORGANOS -----------------
                    if (CartaAux.color==3 && CartaAux.tipoCarta.equals("Medicinas")&& this.estado.equals("Contaminado")) {
                        for (Carta carta : MainServidor.juegoMain.jugadores.get(0).mazo1) {
                            if (carta.equals(CartaAux)&& !dentroMedicina) {

                                MainServidor.juegoMain.cementerio.add(CartaAux);
                                MainServidor.juegoMain.jugadores.get(0).mazo1.remove(carta);
                                InicioController.masoStatico.getChildren().clear();
                                InicioController.masoStatico.getChildren().addAll(MainServidor.juegoMain.jugadores.get(0).mazo1);
                                image = new Image("viruss/recursos/CEREBRO.jpg");
                                this.setImage(image);
                                this.setTipoCarta("Organos");
                                this.setColor(3);
                                this.setEstado("Estable");
                                break;
                            }
                        }
                    }
                    
                    //--------------  MATAR ORGANOS    -------------------------------------------
                        
                        else if (CartaAux.color==3 && CartaAux.tipoCarta.equals("Virus") && this.estado.equals("Contaminado")) { 
                            for (Carta carta : MainServidor.juegoMain.jugadores.get(0).mazo1) {
                                if (carta.equals(CartaAux) && fuera) {
                                    MainServidor.juegoMain.cementerio.add(CartaAux);
                                    //InicioController.listaCementerio.add(CartaAux);
                                    MainServidor.juegoMain.jugadores.get(0).mazo1.remove(carta);
                                    InicioController.masoStatico.getChildren().clear();
                                    InicioController.masoStatico.getChildren().addAll(MainServidor.juegoMain.jugadores.get(0).mazo1);
                                    this.setTipoCarta("Organos");
                                    this.setColor(3);
                                    this.setEstado("Estable");
                                    image = new Image("viruss/recursos/CEREBRO.jpg");
                                    this.setImage(image);
                                    //InicioController.listaCementerio.add(this);
                                    MainServidor.juegoMain.cementerio.add(this);
                                    InicioController.basura.getChildren().add(this);
                                    InicioController.basura.getChildren().remove(0);
                                    break;

                                }
                            }
                        }
                    
                    
                } else if (this.color == 44)//HUESO-VIRUS
                {
                    //--------------- CURAR ORGANOS -----------------
                    if (CartaAux.color==4 && CartaAux.tipoCarta.equals("Medicinas")&& this.estado.equals("Contaminado")) {
                        for (Carta carta : MainServidor.juegoMain.jugadores.get(0).mazo1) {
                            if (carta.equals(CartaAux)&& !dentroMedicina) {

                                MainServidor.juegoMain.cementerio.add(CartaAux);
                                MainServidor.juegoMain.jugadores.get(0).mazo1.remove(carta);
                                InicioController.masoStatico.getChildren().clear();
                                    InicioController.masoStatico.getChildren().addAll(MainServidor.juegoMain.jugadores.get(0).mazo1);
                                    image = new Image("viruss/recursos/HUESO.jpg");
                                    this.setImage(image);
                                    this.setTipoCarta("Organos");
                                    this.setColor(4);
                                    this.setEstado("Estable");
                                    break;
                                }
                            }
                        }
                    //--------------  MATAR ORGANOS    -------------------------------------------
                        
                        else if (CartaAux.color==4 && CartaAux.tipoCarta.equals("Virus") && this.estado.equals("Contaminado")) { 
                            for (Carta carta : MainServidor.juegoMain.jugadores.get(0).mazo1) {
                                if (carta.equals(CartaAux) && fuera) {
                                    //InicioController.listaCementerio.add(CartaAux);
                                    MainServidor.juegoMain.cementerio.add(CartaAux);
                                    MainServidor.juegoMain.jugadores.get(0).mazo1.remove(carta);
                                    InicioController.masoStatico.getChildren().clear();
                                    InicioController.masoStatico.getChildren().addAll(MainServidor.juegoMain.jugadores.get(0).mazo1);
                                    this.setTipoCarta("Organos");
                                    this.setColor(4);
                                    this.setEstado("Estable");
                                    image = new Image("viruss/recursos/HUESO.jpg");
                                    this.setImage(image);
                                    //InicioController.listaCementerio.add(this);
                                    MainServidor.juegoMain.cementerio.add(this);
                                    InicioController.basura.getChildren().add(this);
                                    InicioController.basura.getChildren().remove(0);
                                    break;

                                }
                            }
                        }
                    }
                }
                
                else if(this.tipoCarta.equals("OrganosVacuna"))//---------------- ORGANOS INMUNES --------------------------------------------------
                {
                    if (this.color == 1) {
                        if (CartaAux.color==1 && CartaAux.tipoCarta.equals("Medicinas")) { 
                            for (Carta carta : MainServidor.juegoMain.jugadores.get(0).mazo1) {
                                if (carta.equals(CartaAux) && !dentroMedicina) {
                                    MainServidor.juegoMain.cementerio.add(CartaAux);
                                    MainServidor.juegoMain.jugadores.get(0).mazo1.remove(carta);
                                    InicioController.masoStatico.getChildren().clear();
                                    InicioController.masoStatico.getChildren().addAll(MainServidor.juegoMain.jugadores.get(0).mazo1);
                                    image = new Image("viruss/recursos/CORAZONINM2.jpg");
                                    CartaAux.setImg(image);
                                    this.setImage(CartaAux.getImg());
                                    this.setTipoCarta("OrganosInmune");
                                    break;

                                }
                            }
                        }
                        
                        else if (CartaAux.color==1 && CartaAux.tipoCarta.equals("Virus")) { //------------------------------------------------------ DESTRUIR MEDICNINA -------------------------------
                            for (Carta carta : MainServidor.juegoMain.jugadores.get(0).mazo1) {
                                if (carta.equals(CartaAux) && fuera) {
                                    MainServidor.juegoMain.cementerio.add(CartaAux);
                                    MainServidor.juegoMain.jugadores.get(0).mazo1.remove(carta);
                                    InicioController.masoStatico.getChildren().clear();
                                    InicioController.masoStatico.getChildren().addAll(MainServidor.juegoMain.jugadores.get(0).mazo1);
                                    image = new Image("viruss/recursos/CORAZON.jpg");
                                    CartaAux.setImg(image);
                                    this.setImage(CartaAux.getImg());
                                    this.setTipoCarta("Organos");
                                    break;

                                }
                            }
                        }
                    }
                    
                    else if (this.color == 2) {
                        if (CartaAux.color==2 && CartaAux.tipoCarta.equals("Medicinas")) { 
                            for (Carta carta : MainServidor.juegoMain.jugadores.get(0).mazo1) {
                                if (carta.equals(CartaAux) && !dentroMedicina) {
                                    MainServidor.juegoMain.cementerio.add(CartaAux);
                                    MainServidor.juegoMain.jugadores.get(0).mazo1.remove(carta);
                                    InicioController.masoStatico.getChildren().clear();
                                    InicioController.masoStatico.getChildren().addAll(MainServidor.juegoMain.jugadores.get(0).mazo1);
                                    image = new Image("viruss/recursos/ESTOMAGOINM2.jpg");
                                    CartaAux.setImg(image);
                                    this.setImage(CartaAux.getImg());
                                    this.setTipoCarta("OrganosInmune");
                                    break;

                                }
                            }
                        }
                        
                        else if (CartaAux.color==2 && CartaAux.tipoCarta.equals("Virus")) { //------------------------------------------------------ DESTRUIR MEDICNINA -------------------------------
                            for (Carta carta : MainServidor.juegoMain.jugadores.get(0).mazo1) {
                                if (carta.equals(CartaAux) && fuera) {
                                    MainServidor.juegoMain.cementerio.add(CartaAux);
                                    MainServidor.juegoMain.jugadores.get(0).mazo1.remove(carta);
                                    InicioController.masoStatico.getChildren().clear();
                                    InicioController.masoStatico.getChildren().addAll(MainServidor.juegoMain.jugadores.get(0).mazo1);
                                    image = new Image("viruss/recursos/ESTOMAGO.jpg");
                                    CartaAux.setImg(image);
                                    this.setImage(CartaAux.getImg());
                                    this.setTipoCarta("Organos");
                                    break;

                                }
                            }
                        }
                        
                    }
                    
                    else if (this.color == 3) {
                        if (CartaAux.color==3 && CartaAux.tipoCarta.equals("Medicinas")) { 
                            for (Carta carta : MainServidor.juegoMain.jugadores.get(0).mazo1) {
                                if (carta.equals(CartaAux) && !dentroMedicina) {
                                    MainServidor.juegoMain.cementerio.add(CartaAux);
                                    MainServidor.juegoMain.jugadores.get(0).mazo1.remove(carta);
                                    InicioController.masoStatico.getChildren().clear();
                                    InicioController.masoStatico.getChildren().addAll(MainServidor.juegoMain.jugadores.get(0).mazo1);
                                    image = new Image("viruss/recursos/CEREBROINM2.jpg");
                                    CartaAux.setImg(image);
                                    this.setImage(CartaAux.getImg());
                                    this.setTipoCarta("OrganosInmune");
                                    break;

                                }
                            }
                        }
                        
                      else if (CartaAux.color==3 && CartaAux.tipoCarta.equals("Virus")) { //------------------------------------------------------ DESTRUIR MEDICNINA -------------------------------
                            for (Carta carta : MainServidor.juegoMain.jugadores.get(0).mazo1) {
                                if (carta.equals(CartaAux) && fuera) {
                                    MainServidor.juegoMain.cementerio.add(CartaAux);
                                    MainServidor.juegoMain.jugadores.get(0).mazo1.remove(carta);
                                    InicioController.masoStatico.getChildren().clear();
                                    InicioController.masoStatico.getChildren().addAll(MainServidor.juegoMain.jugadores.get(0).mazo1);
                                    image = new Image("viruss/recursos/CEREBRO.jpg");
                                    CartaAux.setImg(image);
                                    this.setImage(CartaAux.getImg());
                                    this.setTipoCarta("Organos");
                                    break;

                                }
                            }
                        }
                        
                    }
                    
                    
                    else if (this.color == 4) {
                        if (CartaAux.color==4 && CartaAux.tipoCarta.equals("Medicinas")) { 
                            for (Carta carta : MainServidor.juegoMain.jugadores.get(0).mazo1) {
                                if (carta.equals(CartaAux) && !dentroMedicina) {
                                    MainServidor.juegoMain.cementerio.add(CartaAux);
                                    MainServidor.juegoMain.jugadores.get(0).mazo1.remove(carta);
                                    InicioController.masoStatico.getChildren().clear();
                                    InicioController.masoStatico.getChildren().addAll(MainServidor.juegoMain.jugadores.get(0).mazo1);
                                    image = new Image("viruss/recursos/HUESOINM2.jpg");
                                    CartaAux.setImg(image);
                                    this.setImage(CartaAux.getImg());
                                    this.setTipoCarta("OrganosInmune");
                                    break;

                                }
                            }
                        }
                        
                        else if (CartaAux.color==4 && CartaAux.tipoCarta.equals("Virus")) { //------------------------------------------------------ DESTRUIR MEDICNINA -------------------------------
                            for (Carta carta : MainServidor.juegoMain.jugadores.get(0).mazo1) {
                                if (carta.equals(CartaAux) && fuera) {
                                    MainServidor.juegoMain.cementerio.add(CartaAux);
                                    MainServidor.juegoMain.jugadores.get(0).mazo1.remove(carta);
                                    InicioController.masoStatico.getChildren().clear();
                                    InicioController.masoStatico.getChildren().addAll(MainServidor.juegoMain.jugadores.get(0).mazo1);
                                    image = new Image("viruss/recursos/HUESO.jpg");
                                    CartaAux.setImg(image);
                                    this.setImage(CartaAux.getImg());
                                    this.setTipoCarta("Organos");
                                    break;

                                }
                            }
                        }
                        
                    }
                    
                }
                
              

            cont = 0;
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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Carta{" + "tipoCarta=" + tipoCarta + ", color=" + color + ", estado=" + estado + '}';
    }

    
    
    
    
    
    
}
