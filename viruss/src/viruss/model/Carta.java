package viruss.model;

import java.io.IOException;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.Alert;
import javafx.util.Duration;

import viruss.controller.InicioController;
import static viruss.controller.InicioController.posJug;
import viruss.util.AppContext;
import viruss.util.FlowController;
import viruss.util.Mensaje;

public class Carta extends ImageView implements Serializable {

    private static final long serialVersionUID = 6529685098267757690L;
    private String tipoCarta;
    public int color;
    public int idcarta;
    public int altura;
    public int ancho;
    public String estado;
    public String img;
    public static Carta CartaAux;
    List<Carta> lista;
    Timeline timeline;
    public Carta CartaAux2;
    public static int cont = 0;
    public Image image;
    public static boolean pasarTurno = false;
    public static Carta cartaverificar;
    List<Carta> listaVerificar;
    List<Carta> listaVerificarCarta;
    List<Carta> listaErrorMedico;
    boolean semaforo;
    boolean band;

    public Carta() {
    }

    public Carta(int id, String tipoCarta, int color, int altura, int ancho) {
        this.idcarta = id;
        this.altura = altura;
        this.ancho = ancho;
        this.tipoCarta = tipoCarta;
        this.color = color;

    }

    public void setImg() {

        if (tipoCarta.equals("Virus")) {

            if (color == 1)//ROJIVIRUS
            {
                this.setImage(new Image("viruss/recursos/ROJIVURUS.jpg"));
            }
            if (color == 2)//VERDON EL VIRUS
            {
                this.setImage(new Image("viruss/recursos/VERDON EL VIRUS.jpg"));
            }
            if (color == 3)//VIRUBLU
            {
                this.setImage(new Image("viruss/recursos/VIRUBLU.jpg"));
            }
            if (color == 4)//YELLVIRUS
            {
                this.setImage(new Image("viruss/recursos/YELLVIRUS.jpg"));
            }
            if (color == 5)//COVID-19
            {
                this.setImage(new Image("viruss/recursos/COVID-19.jpg"));
            }
        }
        if (tipoCarta.equals("Tratamientos")) {
            if (color == 1)//Transplante
            {
                this.setImage(new Image("viruss/recursos/TRANSPLANTE.jpg"));
            }
            if (color == 2)//Ladrón de órganos
            {
                this.setImage(new Image("viruss/recursos/LADRON DE ORGANOS.jpg"));
            }
            if (color == 3)//Contagio
            {
                this.setImage(new Image("viruss/recursos/CONTAGIO.jpg"));
            }
            if (color == 4)//Guante de látex
            {
                this.setImage(new Image("viruss/recursos/GUANTES DE LATEX.jpg"));
            }
            if (color == 5)//Error médico
            {
                this.setImage(new Image("viruss/recursos/ERROR MEDICO.jpg"));
            }
        }
        if (tipoCarta.equals("Organos")) {
            if (color == 1)//corazon
            {
                this.estado = "Estable";
                this.setImage(new Image("viruss/recursos/CORAZON.jpg"));
            }
            if (color == 2)//estomago
            {
                this.estado = "Estable";
                this.setImage(new Image("viruss/recursos/ESTOMAGO.jpg"));
            }
            if (color == 3)//cerebro
            {
                this.estado = "Estable";
                this.setImage(new Image("viruss/recursos/CEREBRO.jpg"));
            }
            if (color == 4)//hueso
            {
                this.estado = "Estable";
                this.setImage(new Image("viruss/recursos/HUESO.jpg"));
            }
            if (color == 5)//comodin
            {
                this.estado = "Estable";
                this.setImage(new Image("viruss/recursos/CUERPO.jpg"));
            }
        }
        if (tipoCarta.equals("Medicinas")) {
            if (color == 1) {
                this.setImage(new Image("viruss/recursos/BOTIQUIN.jpg"));
            }
            if (color == 2) {
                this.setImage(new Image("viruss/recursos/VACUNA.jpg"));
            }
            if (color == 3) {
                this.setImage(new Image("viruss/recursos/ANTISUERO.jpg"));
            }
            if (color == 4) {
                this.setImage(new Image("viruss/recursos/CURITAS.jpg"));
            }
            if (color == 5) {
                this.setImage(new Image("viruss/recursos/HOSPITAL.jpg"));
            }
        }

        if (tipoCarta.equals("OrganosVacuna")) {
            if (color == 1) {
                this.setImage(new Image("viruss/recursos/CORAZONINM.jpg"));
            }
            if (color == 2) {
                this.setImage(new Image("viruss/recursos/ESTOMAGOINM.jpg"));
            }
            if (color == 3) {
                this.setImage(new Image("viruss/recursos/CEREBROINM.jpg"));
            }
            if (color == 4) {
                this.setImage(new Image("viruss/recursos/HUESOINM.jpg"));
            }
        }

        if (tipoCarta.equals("OrganosVirus")) {
            if (color == 11) {
                this.setImage(new Image("viruss/recursos/rojoinfectado.jpg"));
            }
            if (color == 22) {
                this.setImage(new Image("viruss/recursos/verdeinfectado.jpg"));
            }
            if (color == 33) {
                this.setImage(new Image("viruss/recursos/azulinfectado.jpg"));
            }
            if (color == 44) {
                this.setImage(new Image("viruss/recursos/amarilloinfectado.jpg"));
            }
        }
        if (tipoCarta.equals("OrganosInmune")) {
            if (color == 1) {
                this.setImage(new Image("viruss/recursos/CORAZONINM2.jpg"));
            }
            if (color == 2) {
                this.setImage(new Image("viruss/recursos/ESTOMAGOINM2.jpg"));
            }
            if (color == 3) {
                this.setImage(new Image("viruss/recursos/CEREBROINM2.jpg"));
            }
            if (color == 4) {
                this.setImage(new Image("viruss/recursos/HUESOINM2.jpg"));
            }
        }

        this.setFitHeight(195);
        this.setFitWidth(130);
        this.setOnMouseClicked(ke -> {
            if (!InicioController.entrada) {
                if (pasarTurno != true) {
                    try {
                        jugar();

                    } catch (IOException ex) {
                        Logger.getLogger(Carta.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }

            } else {
                if (MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1.stream().anyMatch(x -> x.getIdcarta() == this.getIdcarta())) {
                    System.out.println("Cambiar cartas" + InicioController.posJug);
                    MainServidor.juegoMain.cementerio.add(this);
                    InicioController.basura.getChildren().add(this);
                    InicioController.basura.getChildren().remove(0);
                    for (Carta carta1 : MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1) {

//                        for (Carta carta1 : jugadore.mazo1) {
                        if (this.idcarta == carta1.idcarta) {
                            System.out.println(carta1.idcarta);
                            InicioController.listaCambiarCarta.add(this);
                            MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1.remove(carta1);
                            break;
                        }
//                        }
                    }
                }
            }

        });
    }

    public void jugar() throws IOException {
        System.out.println(MainServidor.juegoMain.jugadores.get(InicioController.posJug).nickname);
        if (cont == 0) {
            boolean bandf = true;
            if (this.tipoCarta.equals("Organos"))//-----------------------------------------------------------------------     ORGANOS SOBRE MESA    --------------------------------------------------------
            {

                if (this.color == 1) {

                    if (MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1.stream().filter(x -> x.getColor() == this.color && x.getTipoCarta().equals(this.tipoCarta)).count() >= 1) {
                        //InicioController.cartaSelec.setImage(this.getImage());
                        InicioController.cartaSelec = this;

                    }
                }

                if (this.color == 2) {
                    if (MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1.stream().filter(x -> x.getColor() == this.color && x.getTipoCarta().equals(this.tipoCarta)).count() >= 1) {
                        InicioController.cartaSelec = this;

                    }
                }

                if (this.color == 3) {
                    if (MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1.stream().filter(x -> x.getColor() == this.color && x.getTipoCarta().equals(this.tipoCarta)).count() >= 1) {
                        InicioController.cartaSelec = this;

                    }
                }

                if (this.color == 4) {
                    if (MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1.stream().filter(x -> x.getColor() == this.color && x.getTipoCarta().equals(this.tipoCarta)).count() >= 1) {
                        InicioController.cartaSelec = this;

                    }
                }

                if (this.color == 5) {
                    if (MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1.stream().filter(x -> x.getColor() == this.color && x.getTipoCarta().equals(this.tipoCarta)).count() >= 1) {
                        InicioController.cartaSelec = this;

                    }
                }

            }
            if (this.tipoCarta.equals("Virus"))//-----------------------------------------------------------------------     VIRUS     --------------------------------------------------------
            {
                if (this.color == 1) {
                    if (MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1.stream().filter(x -> x.getColor() == this.color && x.getTipoCarta().equals(this.tipoCarta)).count() >= 1) {
                        CartaAux = this;
                        //CartaAux.setImage(image);
                    }
                } else if (this.color == 2) {
                    if (MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1.stream().filter(x -> x.getColor() == this.color && x.getTipoCarta().equals(this.tipoCarta)).count() >= 1) {

                        CartaAux = this;

                        //CartaAux.setImage(image);
                    }
                } else if (this.color == 3) {
                    if (MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1.stream().filter(x -> x.getColor() == this.color && x.getTipoCarta().equals(this.tipoCarta)).count() >= 1) {

                        CartaAux = this;

                        //CartaAux.setImage(image);
                    }
                } else if (this.color == 4) {
                    if (MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1.stream().filter(x -> x.getColor() == this.color && x.getTipoCarta().equals(this.tipoCarta)).count() >= 1) {

                        CartaAux = this;

                        //CartaAux.setImage(image);
                    }
                } else if (this.color == 5) {
                    if (MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1.stream().filter(x -> x.getColor() == this.color && x.getTipoCarta().equals(this.tipoCarta)).count() >= 1) {
                        CartaAux = this;
                        //image=new Image("viruss/recursos/amarilloinfectado.jpg");
                        //CartaAux.setImage(image);
                    }
                }

            }
            if (this.tipoCarta.equals("Medicinas"))//-----------------------------------------------------------------------     MEDICINA     --------------------------------------------------------
            {
                if (this.color == 1) {
                    if (MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1.stream().filter(x -> x.getColor() == this.color && x.getTipoCarta().equals(this.tipoCarta)).count() >= 1) {
                        CartaAux = this;
                    }

                } else if (this.color == 2) {
                    if (MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1.stream().filter(x -> x.getColor() == this.color && x.getTipoCarta().equals(this.tipoCarta)).count() >= 1) {
                        CartaAux = this;
                    }

                } else if (this.color == 3) {
                    if (MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1.stream().filter(x -> x.getColor() == this.color && x.getTipoCarta().equals(this.tipoCarta)).count() >= 1) {
                        CartaAux = this;
                    }

                } else if (this.color == 4) {
                    if (MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1.stream().filter(x -> x.getColor() == this.color && x.getTipoCarta().equals(this.tipoCarta)).count() >= 1) {
                        CartaAux = this;
                    }

                } else if (this.color == 5) {
                    if (MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1.stream().filter(x -> x.getColor() == this.color && x.getTipoCarta().equals(this.tipoCarta)).count() >= 1) {
                        CartaAux = this;
                    }
                }
            }

            if (this.tipoCarta.equals("Tratamientos")) {
                if (color == 1)//Transplante
                {
                    if (MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1.stream().filter(x -> x.getColor() == this.color && x.getTipoCarta().equals(this.tipoCarta)).count() >= 1) {
                        CartaAux = this;
                    }
                }
                if (color == 2)//Ladrón de órganos
                {
                    if (MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1.stream().filter(x -> x.getColor() == this.color && x.getTipoCarta().equals(this.tipoCarta)).count() >= 1) {
                        CartaAux = this;
                    }
                }
                if (color == 3)//Contagio
                {
                    if (MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1.stream().filter(x -> x.getColor() == this.color && x.getTipoCarta().equals(this.tipoCarta)).count() >= 1) {
                        CartaAux = this;
                    }
                }
                if (color == 4)//Guante de látex
                {
                    
                    if (Mensaje.showConfirmation("Guante de látex", InicioController.stage, "Desea realizar esta jugada?")) {
                        if (MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1.stream().filter(x -> x.getColor() == this.color && x.getTipoCarta().equals(this.tipoCarta)).count() >= 1) {
                           
                            for (int i = 0; i < MainServidor.juegoMain.jugadores.size(); i++) {
                                if(i!=InicioController.posJug)
                                {
                                    MainServidor.juegoMain.cementerio.addAll(MainServidor.juegoMain.jugadores.get(i).mazo1);
                                    MainServidor.juegoMain.jugadores.get(i).mazo1.clear();
                                }
                            }
                            MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1.remove(this);
                            InicioController.bandaGuanteLatex = false;
                            pasarTurno = true;
                            cargarPartida();
                            //poner bandera desde inicioControler
                        }
                    } else {
                        bandf = false;

                    }

//                    if (MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1.stream().filter(x -> x.getColor() == this.color && x.getTipoCarta().equals(this.tipoCarta)).count() >= 1) {
//                        CartaAux = this;
//                    }
                }
                if (color == 5)//Error médico
                {
                    if (MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1.stream().filter(x -> x.getColor() == this.color && x.getTipoCarta().equals(this.tipoCarta)).count() >= 1) {
                        CartaAux = this;
                    }
                }
            }

            if (!bandf) {
                cont = 0;
            } else {
                cont++;
            }

        } else if (cont == 2) {
            System.out.println("dentro 3 click");
            this.setRotate(0);
            boolean fuera = true; //validacion de solo poder poner virus fuera del maso y de la mesa del jugador
            boolean dentroMedicina = true;//validacion de poder curar los organos de la mesa del jugador
            for (Carta cartas : MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo2) {
                if (cartas.equals(this)) {
                    fuera = false;

                }

            }

            for (Carta cartas : MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1) {
                if (cartas.equals(this)) {
                    fuera = false;
                }

            }
//                
            for (Carta cartass : MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo2) {
                if (cartass.equals(this)) {
                    dentroMedicina = false;
                    //fuera=false;
                }

            }//------------------------------

            if (this.tipoCarta.equals("Organos")) {

                semaforo = true;
                if (CartaAux.color != this.color && !this.tipoCarta.equals("OrganosInmune") && fuera) {
                    for (Jugador jugadore : MainServidor.juegoMain.jugadores) {
                        for (Carta carta1 : jugadore.mazo2) {
                            if (this.idcarta == carta1.idcarta) {
                                cartaverificar = carta1;
                                listaVerificar = jugadore.mazo2;
                                break;
                            }

                        }

                    }

                    for (Carta cartass : MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo2) {
                        if (cartass.color == cartaverificar.color) {
                            semaforo = false;
                            System.out.println("repetida");
                            break;
                        }
                    }

                    for (Carta carta1 : listaVerificar) {
                        if (CartaAux.color == carta1.idcarta) {
                            semaforo = false;
                            System.out.println("repetida");
                            break;
                        }
                    }
                    if (semaforo == true) {
                        System.out.println("entro en semaforo = true");
                        listaVerificar.remove(cartaverificar);
                        listaVerificar.add(CartaAux);
                        MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo2.remove(CartaAux);
                        MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo2.add(cartaverificar);

                        MainServidor.juegoMain.cementerio.add(CartaAux2);
                        MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1.remove(CartaAux2);
                        InicioController.masoStatico.getChildren().clear();
                        InicioController.masoStatico.getChildren().addAll(MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1);

                        cargarPartida();
                        pasarTurno = true;
                    } else {
                        new Mensaje().show(Alert.AlertType.ERROR, "Error de movimiento", "Movimiento invlido, intentelo de nuevo");
                    }
                }

            } else if (this.tipoCarta.equals("OrganosVacuna")) {
                if (!this.tipoCarta.equals("OrganosInmune") && fuera) {
                    for (Jugador jugadore : MainServidor.juegoMain.jugadores) {
                        for (Carta carta1 : jugadore.mazo2) {
                            if (this.idcarta == carta1.idcarta) {
                                jugadore.mazo2.remove(carta1);
                                jugadore.mazo2.add(CartaAux);
                                MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo2.remove(CartaAux);
                                MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo2.add(carta1);

                                cargarPartida();
                                pasarTurno = true;
                                break;
                            }

                        }

                    }

                }
            } else if (this.tipoCarta.equals("OrganosVirus")) {
                if (!this.tipoCarta.equals("OrganosInmune") && fuera) {
                    for (Jugador jugadore : MainServidor.juegoMain.jugadores) {
                        for (Carta carta1 : jugadore.mazo2) {
                            if (this.idcarta == carta1.idcarta) {
                                jugadore.mazo2.remove(carta1);
                                jugadore.mazo2.add(CartaAux);
                                MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo2.remove(CartaAux);
                                MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo2.add(carta1);

                                cargarPartida();
                                pasarTurno = true;
                                break;
                            }

                        }

                    }

                }
            }

            cont = 0;

        } else if (cont == 1) {
            this.setRotate(0);
            boolean fuera = true; //validacion de solo poder poner virus fuera del maso y de la mesa del jugador
            boolean dentroMedicina = true;//validacion de poder curar los organos de la mesa del jugador
            for (Carta cartas : MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo2) {
                if (cartas.equals(this)) {
                    fuera = false;

                }

            }

            for (Carta cartas : MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1) {
                if (cartas.equals(this)) {
                    fuera = false;
                }

            }
//                
            for (Carta cartass : MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo2) {
                if (cartass.equals(this)) {
                    dentroMedicina = false;
                }

            }

            if (this.tipoCarta.equals("Organos"))//-----------------------------------------------------------------------     ORGANOS     --------------------------------------------------------
            {
                if (this.color == 1) {
                    if (this.color == CartaAux.color && CartaAux.tipoCarta.equals("Virus") && this.estado.equals("Estable")) { //-------------------CONTAMINAR ORGANO---------------------------------
                        for (Carta carta : MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1) {
                            if (carta.equals(CartaAux) && fuera) {
                                MainServidor.juegoMain.cementerio.add(CartaAux);
                                MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1.remove(carta);
                                InicioController.masoStatico.getChildren().clear();
                                InicioController.masoStatico.getChildren().addAll(MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1);
                                this.setImage(new Image("viruss/recursos/rojoinfectado.jpg"));
                                this.setTipoCarta("OrganosVirus");
                                this.setColor(11);
                                this.setEstado("Contaminado");
                                pasarTurno = true;
                                break;

                            }
                        }
                    } else if (CartaAux.color == 5 && CartaAux.tipoCarta.equals("Tratamientos")) //------------------------------ TRANSPLANTE-----------------------------------
                    {
                        boolean bandd = true;
                        int jugcoon2 = 0;
                        for (Carta carta : MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1) {
                            if (carta.equals(CartaAux) && fuera) {
                                for (int i = 0; i < MainServidor.juegoMain.jugadores.size(); i++) {

                                    for (Carta carta1 : MainServidor.juegoMain.jugadores.get(i).mazo2) {
                                        if (this.idcarta == carta1.idcarta) {
                                            bandd = false;
                                            listaVerificar = MainServidor.juegoMain.jugadores.get(i).mazo2;
                                            jugcoon2 = i;
                                            break;
                                        }

                                    }
                                }

                            }

                        }
                        if (!bandd) {
                            MainServidor.juegoMain.jugadores.get(jugcoon2).mazo2 = MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo2;
                            MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo2 = listaVerificar;

                            MainServidor.juegoMain.cementerio.add(CartaAux);
                            MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1.remove(CartaAux);
                            cont = 0;
                            cargarPartida();
                            pasarTurno = true;
                        } else {
                            new Mensaje().show(Alert.AlertType.ERROR, "Error de movimiento", "Movimiento inválido, intentelo de nuevo");
                        }
                    } else if (CartaAux.color == 1 && CartaAux.tipoCarta.equals("Tratamientos") && !this.tipoCarta.equals("OrganosInmune")) //------------------------------ TRANSPLANTE-----------------------------------
                    {
                        for (Carta carta : MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1) {
                            if (carta.equals(CartaAux) && !dentroMedicina) {
                                CartaAux2 = CartaAux;
                                CartaAux = this;
                                cont++;
                                break;

                            }
                        }
                    } else if (CartaAux.color == 2 && CartaAux.tipoCarta.equals("Tratamientos") && !this.tipoCarta.equals("OrganosInmune")) //------------------------------ TRANSPLANTE-----------------------------------
                    {
//         
                        Carta carElegida = new Carta();
                        boolean bandCarta = true;
                        for (Carta carta : MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1) {
                            if (carta.equals(CartaAux) && fuera) {

                                for (Jugador jugadore : MainServidor.juegoMain.jugadores) {
                                    for (Carta carta12 : jugadore.mazo2) {
                                        if (this.idcarta == carta12.idcarta) {
                                            carElegida = carta12;
                                            listaVerificarCarta = jugadore.mazo2;
                                        }
                                    }
                                    for (Carta carta2 : MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo2) {
                                        if (carElegida.color == carta2.color) {
                                            bandCarta = false;
                                            break;
                                        }
                                    }

                                }
                            }
                        }
                        if (bandCarta) {
                            MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo2.add(carElegida);
                            listaVerificarCarta.remove(carElegida);
                            MainServidor.juegoMain.cementerio.add(CartaAux);
                            MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1.remove(CartaAux);
                            InicioController.masoStatico.getChildren().clear();
                            InicioController.masoStatico.getChildren().addAll(MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1);
                            cont = 0;
                            pasarTurno = true;
                            cargarPartida();

                        } else {
                            new Mensaje().show(Alert.AlertType.ERROR, "Error de movimiento", "Movimiento inválido, intentelo de nuevo");
                        }

                    } else if (this.color == CartaAux.color && CartaAux.tipoCarta.equals("Medicinas") && this.estado.equals("Estable")) {//------------------- ORGANOS VACUNA --------------------------------
                        for (Carta carta : MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1) {
                            if (carta.equals(CartaAux) && !dentroMedicina) {
                                MainServidor.juegoMain.cementerio.add(CartaAux);
                                MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1.remove(carta);
                                InicioController.masoStatico.getChildren().clear();
                                InicioController.masoStatico.getChildren().addAll(MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1);
                                this.setImage(new Image("viruss/recursos/CORAZONINM.jpg"));
                                this.setTipoCarta("OrganosVacuna");
                                pasarTurno = true;
                                break;

                            }
                        }
                    } else if (CartaAux.color == 5 && CartaAux.tipoCarta.equals("Virus") && this.estado.equals("Estable")) //------------------------------ COVID 19 ATC ORGANO -----------------------------------
                    {
                        for (Carta carta : MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1) {
                            if (carta.equals(CartaAux) && fuera) {
                                MainServidor.juegoMain.cementerio.add(CartaAux);
                                MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1.remove(carta);
                                InicioController.masoStatico.getChildren().clear();
                                InicioController.masoStatico.getChildren().addAll(MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1);
                                this.setImage(new Image("viruss/recursos/rojoinfectado.jpg"));
                                this.setTipoCarta("OrganosVirus");
                                this.setColor(11);
                                this.setEstado("Contaminado");
                                pasarTurno = true;
                                break;

                            }
                        }
                    } else if (CartaAux.color == 5 && CartaAux.tipoCarta.equals("Medicinas") && this.estado.equals("Estable")) //------------------------------ HOSPITAL ORGANO -----------------------------------
                    {
                        for (Carta carta : MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1) {
                            if (carta.equals(CartaAux) && !dentroMedicina) {
                                MainServidor.juegoMain.cementerio.add(CartaAux);
                                MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1.remove(carta);
                                InicioController.masoStatico.getChildren().clear();
                                InicioController.masoStatico.getChildren().addAll(MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1);
                                this.setImage(new Image("viruss/recursos/CORAZONINM.jpg"));
                                this.setTipoCarta("OrganosVacuna");
                                pasarTurno = true;
                                break;

                            }
                        }
                    } else if (CartaAux.color == 5 && CartaAux.tipoCarta.equals("Virus") && this.estado.equals("Contaminado")) //------------------------------ COVID 19 ATC ORGANO -----------------------------------
                    {
                        for (Carta carta : MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1) {
                            if (carta.equals(CartaAux) && fuera) {
                                MainServidor.juegoMain.cementerio.add(CartaAux);
                                MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1.remove(carta);
                                InicioController.masoStatico.getChildren().clear();
                                InicioController.masoStatico.getChildren().addAll(MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1);
                                MainServidor.juegoMain.cementerio.add(this);
                                InicioController.basura.getChildren().add(this);
                                InicioController.basura.getChildren().remove(0);
                                for (Jugador jugadore : MainServidor.juegoMain.jugadores) {
                                    for (Carta carta1 : jugadore.mazo2) {
                                        System.out.println(this.idcarta);
                                        System.out.println(carta1.idcarta);
                                        if (this.idcarta == carta1.idcarta) {
                                            jugadore.mazo2.remove(carta1);
                                            break;
                                        }
                                    }

                                }
                                pasarTurno = true;
                                break;
                            }
                        }
                    }

                } else if (this.color == 2) {
                    if (this.color == CartaAux.color && CartaAux.tipoCarta.equals("Virus") && this.estado.equals("Estable")) {
                        for (Carta carta : MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1) {
                            if (carta.equals(CartaAux) && fuera) {

                                MainServidor.juegoMain.cementerio.add(CartaAux);
                                MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1.remove(carta);
                                InicioController.masoStatico.getChildren().clear();
                                InicioController.masoStatico.getChildren().addAll(MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1);
                                this.setImage(new Image("viruss/recursos/verdeinfectado.jpg"));
                                this.setTipoCarta("OrganosVirus");
                                this.setColor(22);
                                this.setEstado("Contaminado");
                                pasarTurno = true;
                                break;

                            }
                        }
                    } else if (this.color == CartaAux.color && CartaAux.tipoCarta.equals("Medicinas") && this.estado.equals("Estable")) {//------------------- ORGANOS VACUNA --------------------------------
                        for (Carta carta : MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1) {
                            if (carta.equals(CartaAux) && !dentroMedicina) {
                                MainServidor.juegoMain.cementerio.add(CartaAux);
                                MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1.remove(carta);
                                InicioController.masoStatico.getChildren().clear();
                                InicioController.masoStatico.getChildren().addAll(MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1);
                                this.setImage(new Image("viruss/recursos/ESTOMAGOINM.jpg"));
                                this.setTipoCarta("OrganosVacuna");
                                pasarTurno = true;
                                break;

                            }
                        }
                    } else if (CartaAux.color == 5 && CartaAux.tipoCarta.equals("Tratamientos")) //------------------------------ TRANSPLANTE-----------------------------------
                    {
                        boolean bandd = true;
                        int jugcoon2 = 0;
                        for (Carta carta : MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1) {
                            if (carta.equals(CartaAux) && fuera) {
                                for (int i = 0; i < MainServidor.juegoMain.jugadores.size(); i++) {

                                    for (Carta carta1 : MainServidor.juegoMain.jugadores.get(i).mazo2) {
                                        if (this.idcarta == carta1.idcarta) {
                                            bandd = false;
                                            listaVerificar = MainServidor.juegoMain.jugadores.get(i).mazo2;
                                            jugcoon2 = i;
                                            break;
                                        }

                                    }
                                }

                            }

                        }
                        if (!bandd) {
                            MainServidor.juegoMain.jugadores.get(jugcoon2).mazo2 = MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo2;
                            MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo2 = listaVerificar;

                            MainServidor.juegoMain.cementerio.add(CartaAux);
                            MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1.remove(CartaAux);
                            cont = 0;
                            cargarPartida();
                            pasarTurno = true;
                        } else {
                            new Mensaje().show(Alert.AlertType.ERROR, "Error de movimiento", "Movimiento inválido, intentelo de nuevo");
                        }
                    } else if (CartaAux.color == 1 && CartaAux.tipoCarta.equals("Tratamientos") && !this.tipoCarta.equals("OrganosInmune")) //------------------------------ TRASNPLANTE -----------------------------------
                    {
                        for (Carta carta : MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1) {
                            if (carta.equals(CartaAux) && !dentroMedicina) {
                                CartaAux2 = CartaAux;
                                CartaAux = this;
                                cont++;
                                break;

                            }
                        }
                    } else if (CartaAux.color == 2 && CartaAux.tipoCarta.equals("Tratamientos") && !this.tipoCarta.equals("OrganosInmune")) //------------------------------ TRASNPLANTE -----------------------------------
                    {
                        Carta carElegida = new Carta();
                        boolean bandCarta = true;
                        for (Carta carta : MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1) {
                            if (carta.equals(CartaAux) && fuera) {

                                for (Jugador jugadore : MainServidor.juegoMain.jugadores) {
                                    for (Carta carta12 : jugadore.mazo2) {
                                        if (this.idcarta == carta12.idcarta) {
                                            carElegida = carta12;
                                            listaVerificarCarta = jugadore.mazo2;
                                        }
                                    }
                                    for (Carta carta2 : MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo2) {
                                        if (carElegida.color == carta2.color) {
                                            bandCarta = false;
                                            break;
                                        }
                                    }

                                }
                            }
                        }
                        if (bandCarta) {
                            MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo2.add(carElegida);
                            listaVerificarCarta.remove(carElegida);
                            MainServidor.juegoMain.cementerio.add(CartaAux);
                            MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1.remove(CartaAux);
                            InicioController.masoStatico.getChildren().clear();
                            InicioController.masoStatico.getChildren().addAll(MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1);
                            cont = 0;
                            pasarTurno = true;
                            cargarPartida();

                        } else {
                            new Mensaje().show(Alert.AlertType.ERROR, "Error de movimiento", "Movimiento inválido, intentelo de nuevo");
                        }
                    } else if (CartaAux.color == 5 && CartaAux.tipoCarta.equals("Virus") && this.estado.equals("Estable"))//------------------------------ COVID 19 ATC ORGANO -----------------------------------
                    {
                        for (Carta carta : MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1) {
                            if (carta.equals(CartaAux) && fuera) {
                                MainServidor.juegoMain.cementerio.add(CartaAux);
                                MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1.remove(carta);
                                InicioController.masoStatico.getChildren().clear();
                                InicioController.masoStatico.getChildren().addAll(MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1);
                                this.setImage(new Image("viruss/recursos/verdeinfectado.jpg"));
                                this.setTipoCarta("OrganosVirus");
                                this.setColor(22);
                                this.setEstado("Contaminado");
                                pasarTurno = true;
                                break;

                            }
                        }
                    } else if (CartaAux.color == 5 && CartaAux.tipoCarta.equals("Medicinas") && this.estado.equals("Estable")) //------------------------------ HOSPITAL ORGANO -----------------------------------
                    {
                        for (Carta carta : MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1) {
                            if (carta.equals(CartaAux) && !dentroMedicina) {
                                MainServidor.juegoMain.cementerio.add(CartaAux);
                                MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1.remove(carta);
                                InicioController.masoStatico.getChildren().clear();
                                InicioController.masoStatico.getChildren().addAll(MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1);
                                this.setImage(new Image("viruss/recursos/ESTOMAGOINM.jpg"));
                                this.setTipoCarta("OrganosVacuna");
                                pasarTurno = true;
                                break;

                            }
                        }
                    } else if (CartaAux.color == 5 && CartaAux.tipoCarta.equals("Virus") && this.estado.equals("Containado"))//------------------------------ COVID 19 ATC ORGANO -----------------------------------
                    {
                        for (Carta carta : MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1) {
                            if (carta.equals(CartaAux) && fuera) {
                                MainServidor.juegoMain.cementerio.add(CartaAux);
                                MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1.remove(carta);
                                InicioController.masoStatico.getChildren().clear();
                                InicioController.masoStatico.getChildren().addAll(MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1);
                                MainServidor.juegoMain.cementerio.add(this);
                                InicioController.basura.getChildren().add(this);
                                InicioController.basura.getChildren().remove(0);
                                for (Jugador jugadore : MainServidor.juegoMain.jugadores) {
                                    for (Carta carta1 : jugadore.mazo2) {
                                        System.out.println(this.idcarta);
                                        System.out.println(carta1.idcarta);
                                        if (this.idcarta == carta1.idcarta) {
                                            jugadore.mazo2.remove(carta1);
                                            break;
                                        }
                                    }

                                }
                                pasarTurno = true;
                                break;

                            }
                        }
                    }

                } else if (this.color == 3) {
                    if (this.color == CartaAux.color && CartaAux.tipoCarta.equals("Virus") && this.estado.equals("Estable")) {
                        for (Carta carta : MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1) {
                            if (carta.equals(CartaAux) && fuera) {

                                MainServidor.juegoMain.cementerio.add(CartaAux);
                                MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1.remove(carta);
                                InicioController.masoStatico.getChildren().clear();
                                InicioController.masoStatico.getChildren().addAll(MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1);
                                this.setImage(new Image("viruss/recursos/azulinfectado.jpg"));
                                this.setTipoCarta("OrganosVirus");
                                this.setColor(33);
                                this.setEstado("Contaminado");
                                pasarTurno = true;
                                break;
                            }
                        }
                    } else if (this.color == CartaAux.color && CartaAux.tipoCarta.equals("Medicinas") && this.estado.equals("Estable")) {//------------------- ORGANOS VACUNA --------------------------------
                        for (Carta carta : MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1) {
                            if (carta.equals(CartaAux) && !dentroMedicina) {
                                MainServidor.juegoMain.cementerio.add(CartaAux);
                                MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1.remove(carta);
                                InicioController.masoStatico.getChildren().clear();
                                InicioController.masoStatico.getChildren().addAll(MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1);
                                this.setImage(new Image("viruss/recursos/CEREBROINM.jpg"));
                                this.setTipoCarta("OrganosVacuna");
                                pasarTurno = true;
                                break;

                            }
                        }
                    } else if (CartaAux.color == 5 && CartaAux.tipoCarta.equals("Virus") && this.estado.equals("Estable"))//------------------------------ COVID 19 ATC ORGANO -----------------------------------
                    {
                        for (Carta carta : MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1) {
                            if (carta.equals(CartaAux) && fuera) {
                                MainServidor.juegoMain.cementerio.add(CartaAux);
                                MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1.remove(carta);
                                InicioController.masoStatico.getChildren().clear();
                                InicioController.masoStatico.getChildren().addAll(MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1);
                                this.setImage(new Image("viruss/recursos/azulinfectado.jpg"));
                                this.setTipoCarta("OrganosVirus");
                                this.setColor(33);
                                this.setEstado("Contaminado");
                                pasarTurno = true;
                                break;

                            }
                        }
                    } else if (CartaAux.color == 1 && CartaAux.tipoCarta.equals("Tratamientos") && !this.tipoCarta.equals("OrganosInmune")) //------------------------------ TRASPLANTE -----------------------------------
                    {
                        for (Carta carta : MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1) {
                            if (carta.equals(CartaAux) && !dentroMedicina) {
                                CartaAux2 = CartaAux;
                                CartaAux = this;
                                cont++;
                                break;

                            }
                        }
                    } else if (CartaAux.color == 5 && CartaAux.tipoCarta.equals("Tratamientos")) //------------------------------ TRANSPLANTE-----------------------------------
                    {

                        boolean bandd = true;
                        int jugcoon2 = 0;
                        for (Carta carta : MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1) {
                            if (carta.equals(CartaAux) && fuera) {
                                for (int i = 0; i < MainServidor.juegoMain.jugadores.size(); i++) {

                                    for (Carta carta1 : MainServidor.juegoMain.jugadores.get(i).mazo2) {
                                        if (this.idcarta == carta1.idcarta) {
                                            bandd = false;
                                            listaVerificar = MainServidor.juegoMain.jugadores.get(i).mazo2;
                                            jugcoon2 = i;
                                            break;
                                        }

                                    }
                                }

                            }

                        }
                        if (!bandd) {
                            MainServidor.juegoMain.jugadores.get(jugcoon2).mazo2 = MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo2;
                            MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo2 = listaVerificar;

                            MainServidor.juegoMain.cementerio.add(CartaAux);
                            MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1.remove(CartaAux);
                            cont = 0;
                            cargarPartida();
                            pasarTurno = true;
                        } else {
                            new Mensaje().show(Alert.AlertType.ERROR, "Error de movimiento", "Movimiento inválido, intentelo de nuevo");
                        }
                    } else if (CartaAux.color == 2 && CartaAux.tipoCarta.equals("Tratamientos") && !this.tipoCarta.equals("OrganosInmune")) //------------------------------ TRASPLANTE -----------------------------------
                    {
                        Carta carElegida = new Carta();
                        boolean bandCarta = true;
                        for (Carta carta : MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1) {
                            if (carta.equals(CartaAux) && fuera) {

                                for (Jugador jugadore : MainServidor.juegoMain.jugadores) {
                                    for (Carta carta12 : jugadore.mazo2) {
                                        if (this.idcarta == carta12.idcarta) {
                                            carElegida = carta12;
                                            listaVerificarCarta = jugadore.mazo2;
                                        }
                                    }
                                    for (Carta carta2 : MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo2) {
                                        if (carElegida.color == carta2.color) {
                                            bandCarta = false;
                                            break;
                                        }
                                    }

                                }
                            }
                        }
                        if (bandCarta) {
                            MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo2.add(carElegida);
                            listaVerificarCarta.remove(carElegida);
                            MainServidor.juegoMain.cementerio.add(CartaAux);
                            MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1.remove(CartaAux);
                            InicioController.masoStatico.getChildren().clear();
                            InicioController.masoStatico.getChildren().addAll(MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1);
                            cont = 0;
                            pasarTurno = true;
                            cargarPartida();

                        } else {
                            new Mensaje().show(Alert.AlertType.ERROR, "Error de movimiento", "Movimiento inválido, intentelo de nuevo");
                        }
                    } else if (CartaAux.color == 5 && CartaAux.tipoCarta.equals("Medicinas") && this.estado.equals("Estable")) //------------------------------ HOSPITAL ORGANO -----------------------------------
                    {
                        for (Carta carta : MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1) {
                            if (carta.equals(CartaAux) && !dentroMedicina) {
                                MainServidor.juegoMain.cementerio.add(CartaAux);
                                MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1.remove(carta);
                                InicioController.masoStatico.getChildren().clear();
                                InicioController.masoStatico.getChildren().addAll(MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1);
                                this.setImage(new Image("viruss/recursos/CEREBROINM.jpg"));
                                this.setTipoCarta("OrganosVacuna");
                                pasarTurno = true;
                                break;

                            }
                        }
                    } else if (CartaAux.color == 5 && CartaAux.tipoCarta.equals("Virus") && this.estado.equals("Contaminado"))//------------------------------ COVID 19 ATC ORGANO -----------------------------------
                    {
                        for (Carta carta : MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1) {
                            if (carta.equals(CartaAux) && fuera) {
                                MainServidor.juegoMain.cementerio.add(CartaAux);
                                MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1.remove(carta);
                                InicioController.masoStatico.getChildren().clear();
                                InicioController.masoStatico.getChildren().addAll(MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1);
                                MainServidor.juegoMain.cementerio.add(this);
                                InicioController.basura.getChildren().add(this);
                                InicioController.basura.getChildren().remove(0);
                                for (Jugador jugadore : MainServidor.juegoMain.jugadores) {
                                    for (Carta carta1 : jugadore.mazo2) {
                                        System.out.println(this.idcarta);
                                        System.out.println(carta1.idcarta);
                                        if (this.idcarta == carta1.idcarta) {
                                            jugadore.mazo2.remove(carta1);
                                            break;
                                        }
                                    }

                                }
                                pasarTurno = true;
                                break;

                            }
                        }
                    }

                } else if (this.color == 4) {
                    if (this.color == CartaAux.color && CartaAux.tipoCarta.equals("Virus") && this.estado.equals("Estable")) {
                        for (Carta carta : MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1) {
                            if (carta.equals(CartaAux) && fuera) {

                                MainServidor.juegoMain.cementerio.add(CartaAux);
                                MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1.remove(carta);
                                InicioController.masoStatico.getChildren().clear();
                                InicioController.masoStatico.getChildren().addAll(MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1);
                                this.setImage(new Image("viruss/recursos/amarilloinfectado.jpg"));
                                this.setTipoCarta("OrganosVirus");
                                this.setColor(44);
                                this.setEstado("Contaminado");
                                pasarTurno = true;
                                break;

                            }
                        }
                    } else if (this.color == CartaAux.color && CartaAux.tipoCarta.equals("Medicinas") && this.estado.equals("Estable")) {//------------------- ORGANOS VACUNA --------------------------------
                        for (Carta carta : MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1) {
                            if (carta.equals(CartaAux) && !dentroMedicina) {
                                MainServidor.juegoMain.cementerio.add(CartaAux);
                                MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1.remove(carta);
                                InicioController.masoStatico.getChildren().clear();
                                InicioController.masoStatico.getChildren().addAll(MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1);
                                this.setImage(new Image("viruss/recursos/HUESOINM.jpg"));
                                this.setTipoCarta("OrganosVacuna");
                                pasarTurno = true;
                                break;

                            }
                        }

                    } else if (CartaAux.color == 5 && CartaAux.tipoCarta.equals("Virus") && this.estado.equals("Estable"))//------------------------------ COVID 19 ATC ORGANO -----------------------------------
                    {
                        for (Carta carta : MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1) {
                            if (carta.equals(CartaAux) && fuera) {
                                MainServidor.juegoMain.cementerio.add(CartaAux);
                                MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1.remove(carta);
                                InicioController.masoStatico.getChildren().clear();
                                InicioController.masoStatico.getChildren().addAll(MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1);
                                this.setImage(new Image("viruss/recursos/amarilloinfectado.jpg"));
                                this.setTipoCarta("OrganosVirus");
                                this.setColor(44);
                                this.setEstado("Contaminado");
                                pasarTurno = true;
                                break;

                            }
                        }

                    } else if (CartaAux.color == 1 && CartaAux.tipoCarta.equals("Tratamientos") && !this.tipoCarta.equals("OrganosInmune")) //------------------------------ TRANSPLANTE-----------------------------------
                    {
                        for (Carta carta : MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1) {
                            if (carta.equals(CartaAux) && fuera) {
                                CartaAux2 = CartaAux;
                                CartaAux = this;
                                cont++;
                                break;

                            }
                        }
                    } else if (CartaAux.color == 2 && CartaAux.tipoCarta.equals("Tratamientos") && !this.tipoCarta.equals("OrganosInmune")) //------------------------------ TRANSPLANTE-----------------------------------
                    {
                        Carta carElegida = new Carta();
                        boolean bandCarta = true;
                        for (Carta carta : MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1) {
                            if (carta.equals(CartaAux) && fuera) {

                                for (Jugador jugadore : MainServidor.juegoMain.jugadores) {
                                    for (Carta carta12 : jugadore.mazo2) {
                                        if (this.idcarta == carta12.idcarta) {
                                            carElegida = carta12;
                                            listaVerificarCarta = jugadore.mazo2;
                                        }
                                    }
                                    for (Carta carta2 : MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo2) {
                                        if (carElegida.color == carta2.color) {
                                            bandCarta = false;
                                            break;
                                        }
                                    }

                                }
                            }
                        }
                        if (bandCarta) {
                            MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo2.add(carElegida);
                            listaVerificarCarta.remove(carElegida);
                            MainServidor.juegoMain.cementerio.add(CartaAux);
                            MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1.remove(CartaAux);
                            InicioController.masoStatico.getChildren().clear();
                            InicioController.masoStatico.getChildren().addAll(MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1);
                            cont = 0;
                            pasarTurno = true;
                            cargarPartida();

                        } else {
                            new Mensaje().show(Alert.AlertType.ERROR, "Error de movimiento", "Movimiento inválido, intentelo de nuevo");
                        }
                    } else if (CartaAux.color == 5 && CartaAux.tipoCarta.equals("Tratamientos")) //------------------------------ TRANSPLANTE-----------------------------------
                    {
                        boolean bandd = true;
                        int jugcoon2 = 0;
                        for (Carta carta : MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1) {
                            if (carta.equals(CartaAux) && fuera) {
                                for (int i = 0; i < MainServidor.juegoMain.jugadores.size(); i++) {

                                    for (Carta carta1 : MainServidor.juegoMain.jugadores.get(i).mazo2) {
                                        if (this.idcarta == carta1.idcarta) {
                                            bandd = false;
                                            listaVerificar = MainServidor.juegoMain.jugadores.get(i).mazo2;
                                            jugcoon2 = i;
                                            break;
                                        }

                                    }
                                }

                            }

                        }
                        if (!bandd) {
                            MainServidor.juegoMain.jugadores.get(jugcoon2).mazo2 = MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo2;
                            MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo2 = listaVerificar;

                            MainServidor.juegoMain.cementerio.add(CartaAux);
                            MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1.remove(CartaAux);
                            cont = 0;
                            cargarPartida();
                            pasarTurno = true;
                        } else {
                            new Mensaje().show(Alert.AlertType.ERROR, "Error de movimiento", "Movimiento inválido, intentelo de nuevo");
                        }
                    } else if (CartaAux.color == 5 && CartaAux.tipoCarta.equals("Medicinas") && this.estado.equals("Estable")) //------------------------------ HOSPITAL ORGANO -----------------------------------
                    {
                        for (Carta carta : MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1) {
                            if (carta.equals(CartaAux) && !dentroMedicina) {
                                MainServidor.juegoMain.cementerio.add(CartaAux);
                                MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1.remove(carta);
                                InicioController.masoStatico.getChildren().clear();
                                InicioController.masoStatico.getChildren().addAll(MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1);
                                this.setImage(new Image("viruss/recursos/HUESOINM.jpg"));
                                this.setTipoCarta("OrganosVacuna");
                                pasarTurno = true;

                                break;
                            }
                        }

                    }

                } else if (CartaAux.color == 5 && CartaAux.tipoCarta.equals("Virus") && this.estado.equals("Contaminado"))//------------------------------ COVID 19 ATC ORGANO -----------------------------------
                {
                    for (Carta carta : MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1) {
                        if (carta.equals(CartaAux) && fuera) {
                            MainServidor.juegoMain.cementerio.add(CartaAux);
                            MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1.remove(carta);
                            InicioController.masoStatico.getChildren().clear();
                            InicioController.masoStatico.getChildren().addAll(MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1);
                            MainServidor.juegoMain.cementerio.add(this);
                            InicioController.basura.getChildren().add(this);
                            InicioController.basura.getChildren().remove(0);
                            for (Jugador jugadore : MainServidor.juegoMain.jugadores) {
                                for (Carta carta1 : jugadore.mazo2) {
                                    System.out.println(this.idcarta);
                                    System.out.println(carta1.idcarta);
                                    if (this.idcarta == carta1.idcarta) {
                                        jugadore.mazo2.remove(carta1);
                                        break;
                                    }
                                }

                            }
                            pasarTurno = true;
                            break;

                        }
                    }

                }

            } else if (this.tipoCarta.equals("OrganosVirus"))//-----------------------------------------------------------------------     ORGANOS-VIRUS     --------------------------------------------------------
            {
                if (this.color == 11)//CORAZON-VIRUS
                {
                    //--------------- CURAR ORGANOS -----------------
                    if (CartaAux.color == 1 && CartaAux.tipoCarta.equals("Medicinas") && this.estado.equals("Contaminado")) {
                        for (Carta carta : MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1) {
                            if (carta.equals(CartaAux) && !dentroMedicina) {

                                MainServidor.juegoMain.cementerio.add(CartaAux);
                                MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1.remove(carta);
                                InicioController.masoStatico.getChildren().clear();
                                InicioController.masoStatico.getChildren().addAll(MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1);
                                this.setImage(new Image("viruss/recursos/CORAZON.jpg"));
                                this.setTipoCarta("Organos");
                                this.setColor(1);
                                this.setEstado("Estable");
                                pasarTurno = true;
                                break;

                            }
                        }
                    } //--------------  MATAR ORGANOS    -------------------------------------------
                    else if (CartaAux.color == 1 && CartaAux.tipoCarta.equals("Virus") && this.estado.equals("Contaminado")) {
                        for (Carta carta : MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1) {
                            if (carta.equals(CartaAux) && fuera) {
                                MainServidor.juegoMain.cementerio.add(CartaAux);
                                MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1.remove(carta);
                                InicioController.masoStatico.getChildren().clear();
                                InicioController.masoStatico.getChildren().addAll(MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1);
                                this.setTipoCarta("Organos");
                                this.setColor(1);
                                this.setEstado("Estable");
                                this.setImage(new Image("viruss/recursos/CORAZON.jpg"));
                                MainServidor.juegoMain.cementerio.add(this);
                                InicioController.basura.getChildren().add(this);
                                InicioController.basura.getChildren().remove(0);
                                for (Jugador jugadore : MainServidor.juegoMain.jugadores) {

                                    for (Carta carta1 : jugadore.mazo2) {
                                        System.out.println(this.idcarta);
                                        System.out.println(carta1.idcarta);
                                        if (this.idcarta == carta1.idcarta) {
                                            jugadore.mazo2.remove(carta1);
                                            break;
                                        }
                                    }

                                }
                                pasarTurno = true;
                                break;

                            }
                        }
                    } else if (CartaAux.color == 5 && CartaAux.tipoCarta.equals("Medicinas") && this.estado.equals("Contaminado")) //------------------------------ HOSPITAL ORGANO VACUNA-----------------------------------
                    {
                        for (Carta carta : MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1) {
                            if (carta.equals(CartaAux) && !dentroMedicina) {
                                MainServidor.juegoMain.cementerio.add(CartaAux);
                                MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1.remove(carta);
                                InicioController.masoStatico.getChildren().clear();
                                InicioController.masoStatico.getChildren().addAll(MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1);
                                this.setImage(new Image("viruss/recursos/CORAZON.jpg"));
                                this.setTipoCarta("Organos");
                                this.setColor(1);
                                this.setEstado("Estable");
                                pasarTurno = true;
                                break;

                            }
                        }
                    } else if (CartaAux.color == 5 && CartaAux.tipoCarta.equals("Tratamientos")) //------------------------------ TRANSPLANTE-----------------------------------
                    {
                        boolean bandd = true;
                        int jugcoon2 = 0;
                        for (Carta carta : MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1) {
                            if (carta.equals(CartaAux) && fuera) {
                                for (int i = 0; i < MainServidor.juegoMain.jugadores.size(); i++) {

                                    for (Carta carta1 : MainServidor.juegoMain.jugadores.get(i).mazo2) {
                                        if (this.idcarta == carta1.idcarta) {
                                            bandd = false;
                                            listaVerificar = MainServidor.juegoMain.jugadores.get(i).mazo2;
                                            jugcoon2 = i;
                                            break;
                                        }

                                    }
                                }

                            }

                        }
                        if (!bandd) {
                            MainServidor.juegoMain.jugadores.get(jugcoon2).mazo2 = MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo2;
                            MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo2 = listaVerificar;

                            MainServidor.juegoMain.cementerio.add(CartaAux);
                            MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1.remove(CartaAux);
                            cont = 0;
                            cargarPartida();
                            pasarTurno = true;
                        } else {
                            new Mensaje().show(Alert.AlertType.ERROR, "Error de movimiento", "Movimiento inválido, intentelo de nuevo");
                        }
                    } else if (CartaAux.color == 5 && CartaAux.tipoCarta.equals("Virus") && this.estado.equals("Contaminado")) //------------------------------ HOSPITAL ORGANO VACUNA-----------------------------------
                    {
                        for (Carta carta : MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1) {
                            if (carta.equals(CartaAux) && !dentroMedicina) {
                                MainServidor.juegoMain.cementerio.add(CartaAux);
                                MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1.remove(carta);
                                InicioController.masoStatico.getChildren().clear();
                                InicioController.masoStatico.getChildren().addAll(MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1);
                                this.setTipoCarta("Organos");
                                this.setColor(1);
                                this.setEstado("Estable");
                                this.setImage(new Image("viruss/recursos/CORAZON.jpg"));
                                MainServidor.juegoMain.cementerio.add(this);
                                InicioController.basura.getChildren().add(this);
                                InicioController.basura.getChildren().remove(0);
                                for (Jugador jugadore : MainServidor.juegoMain.jugadores) {

                                    for (Carta carta1 : jugadore.mazo2) {
                                        if (this.idcarta == carta1.idcarta) {
                                            jugadore.mazo2.remove(carta1);
                                            break;
                                        }
                                    }

                                }
                                pasarTurno = true;
                                break;

                            }
                        }
                    } else if (CartaAux.color == 1 && CartaAux.tipoCarta.equals("Tratamientos") && !this.tipoCarta.equals("OrganosInmune")) //------------------------------ TRANSPLANTE-----------------------------------
                    {
                        for (Carta carta : MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1) {
                            if (carta.equals(CartaAux) && !dentroMedicina) {
                                CartaAux2 = CartaAux;
                                CartaAux = this;
                                cont++;
                                break;

                            }
                        }
                    } else if (CartaAux.color == 2 && CartaAux.tipoCarta.equals("Tratamientos") && !this.tipoCarta.equals("OrganosInmune")) //------------------------------ TRANSPLANTE-----------------------------------
                    {
                        Carta carElegida = new Carta();
                        boolean bandCarta = true;
                        for (Carta carta : MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1) {
                            if (carta.equals(CartaAux) && fuera) {

                                for (Jugador jugadore : MainServidor.juegoMain.jugadores) {
                                    for (Carta carta12 : jugadore.mazo2) {
                                        if (this.idcarta == carta12.idcarta) {
                                            carElegida = carta12;
                                            listaVerificarCarta = jugadore.mazo2;
                                        }
                                    }
                                    for (Carta carta2 : MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo2) {
                                        if (carElegida.color == carta2.color) {
                                            bandCarta = false;
                                            break;
                                        }
                                    }

                                }
                            }
                        }
                        if (bandCarta) {
                            MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo2.add(carElegida);
                            listaVerificarCarta.remove(carElegida);
                            MainServidor.juegoMain.cementerio.add(CartaAux);
                            MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1.remove(CartaAux);
                            InicioController.masoStatico.getChildren().clear();
                            InicioController.masoStatico.getChildren().addAll(MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1);
                            cont = 0;
                            pasarTurno = true;
                            cargarPartida();

                        } else {
                            new Mensaje().show(Alert.AlertType.ERROR, "Error de movimiento", "Movimiento inválido, intentelo de nuevo");
                        }
                    }

                } else if (this.color == 22)//ESTOMAGO-VIRUS
                {
                    //--------------- CURAR ORGANOS -----------------
                    if (CartaAux.color == 2 && CartaAux.tipoCarta.equals("Medicinas") && this.estado.equals("Contaminado")) {
                        for (Carta carta : MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1) {
                            if (carta.equals(CartaAux) && !dentroMedicina) {

                                MainServidor.juegoMain.cementerio.add(CartaAux);
                                MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1.remove(carta);
                                InicioController.masoStatico.getChildren().clear();
                                InicioController.masoStatico.getChildren().addAll(MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1);
                                this.setImage(new Image("viruss/recursos/ESTOMAGO.jpg"));
                                this.setTipoCarta("Organos");
                                this.setColor(2);
                                this.setEstado("Estable");
                                pasarTurno = true;
                                break;

                            }
                        }
                    } //--------------  MATAR ORGANOS    -------------------------------------------
                    else if (CartaAux.color == 2 && CartaAux.tipoCarta.equals("Virus") && this.estado.equals("Contaminado")) {
                        for (Carta carta : MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1) {
                            if (carta.equals(CartaAux) && fuera) {
                                MainServidor.juegoMain.cementerio.add(CartaAux);
                                MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1.remove(carta);
                                InicioController.masoStatico.getChildren().clear();
                                InicioController.masoStatico.getChildren().addAll(MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1);
                                this.setTipoCarta("Organos");
                                this.setColor(2);
                                this.setEstado("Estable");
                                this.setImage(new Image("viruss/recursos/ESTOMAGO.jpg"));
                                MainServidor.juegoMain.cementerio.add(this);
                                InicioController.basura.getChildren().add(this);
                                InicioController.basura.getChildren().remove(0);
                                for (Jugador jugadore : MainServidor.juegoMain.jugadores) {
                                    for (Carta carta1 : jugadore.mazo2) {
                                        System.out.println(this.idcarta);
                                        System.out.println(carta1.idcarta);
                                        if (this.idcarta == carta1.idcarta) {
                                            jugadore.mazo2.remove(carta1);
                                            break;
                                        }
                                    }

                                }
                                pasarTurno = true;
                                break;

                            }
                        }
                    } else if (CartaAux.color == 5 && CartaAux.tipoCarta.equals("Tratamientos")) //------------------------------ TRANSPLANTE-----------------------------------
                    {
                        boolean bandd = true;
                        int jugcoon2 = 0;
                        for (Carta carta : MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1) {
                            if (carta.equals(CartaAux) && fuera) {
                                for (int i = 0; i < MainServidor.juegoMain.jugadores.size(); i++) {

                                    for (Carta carta1 : MainServidor.juegoMain.jugadores.get(i).mazo2) {
                                        if (this.idcarta == carta1.idcarta) {
                                            bandd = false;
                                            listaVerificar = MainServidor.juegoMain.jugadores.get(i).mazo2;
                                            jugcoon2 = i;
                                            break;
                                        }

                                    }
                                }

                            }

                        }
                        if (!bandd) {
                            MainServidor.juegoMain.jugadores.get(jugcoon2).mazo2 = MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo2;
                            MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo2 = listaVerificar;

                            MainServidor.juegoMain.cementerio.add(CartaAux);
                            MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1.remove(CartaAux);
                            cont = 0;
                            cargarPartida();
                            pasarTurno = true;
                        } else {
                            new Mensaje().show(Alert.AlertType.ERROR, "Error de movimiento", "Movimiento inválido, intentelo de nuevo");
                        }
                    } else if (CartaAux.color == 5 && CartaAux.tipoCarta.equals("Medicinas") && this.estado.equals("Contaminado")) //------------------------------ HOSPITAL ORGANO VACUNA-----------------------------------
                    {
                        for (Carta carta : MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1) {
                            if (carta.equals(CartaAux) && !dentroMedicina) {
                                MainServidor.juegoMain.cementerio.add(CartaAux);
                                MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1.remove(carta);
                                InicioController.masoStatico.getChildren().clear();
                                InicioController.masoStatico.getChildren().addAll(MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1);
                                this.setImage(new Image("viruss/recursos/ESTOMAGO.jpg"));
                                this.setTipoCarta("Organos");
                                this.setColor(2);
                                this.setEstado("Estable");
                                pasarTurno = true;
                                break;

                            }
                        }
                    } else if (CartaAux.color == 5 && CartaAux.tipoCarta.equals("Virus") && this.estado.equals("Contaminado")) {
                        for (Carta carta : MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1) {
                            if (carta.equals(CartaAux) && fuera) {
                                MainServidor.juegoMain.cementerio.add(CartaAux);
                                MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1.remove(carta);
                                InicioController.masoStatico.getChildren().clear();
                                InicioController.masoStatico.getChildren().addAll(MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1);
                                this.setTipoCarta("Organos");
                                this.setColor(2);
                                this.setEstado("Estable");
                                this.setImage(new Image("viruss/recursos/ESTOMAGO.jpg"));
                                MainServidor.juegoMain.cementerio.add(this);
                                InicioController.basura.getChildren().add(this);
                                InicioController.basura.getChildren().remove(0);
                                for (Jugador jugadore : MainServidor.juegoMain.jugadores) {
                                    for (Carta carta1 : jugadore.mazo2) {
                                        if (this.idcarta == carta1.idcarta) {
                                            jugadore.mazo2.remove(carta1);
                                            break;
                                        }
                                    }

                                }
                                pasarTurno = true;
                                break;

                            }
                        }
                    } else if (CartaAux.color == 1 && CartaAux.tipoCarta.equals("Tratamientos") && !this.tipoCarta.equals("OrganosInmune")) //------------------------------ TRANSPLANTE-----------------------------------
                    {
                        for (Carta carta : MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1) {
                            if (carta.equals(CartaAux) && !dentroMedicina) {
                                CartaAux2 = CartaAux;
                                CartaAux = this;
                                cont++;
                                break;

                            }
                        }
                    } else if (CartaAux.color == 2 && CartaAux.tipoCarta.equals("Tratamientos") && !this.tipoCarta.equals("OrganosInmune")) //------------------------------ TRANSPLANTE-----------------------------------
                    {
                        Carta carElegida = new Carta();
                        boolean bandCarta = true;
                        for (Carta carta : MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1) {
                            if (carta.equals(CartaAux) && fuera) {

                                for (Jugador jugadore : MainServidor.juegoMain.jugadores) {
                                    for (Carta carta12 : jugadore.mazo2) {
                                        if (this.idcarta == carta12.idcarta) {
                                            carElegida = carta12;
                                            listaVerificarCarta = jugadore.mazo2;
                                        }
                                    }
                                    for (Carta carta2 : MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo2) {
                                        if (carElegida.color == carta2.color) {
                                            bandCarta = false;
                                            break;
                                        }
                                    }

                                }
                            }
                        }
                        if (bandCarta) {
                            MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo2.add(carElegida);
                            listaVerificarCarta.remove(carElegida);
                            MainServidor.juegoMain.cementerio.add(CartaAux);
                            MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1.remove(CartaAux);
                            InicioController.masoStatico.getChildren().clear();
                            InicioController.masoStatico.getChildren().addAll(MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1);
                            cont = 0;
                            pasarTurno = true;
                            cargarPartida();

                        } else {
                            new Mensaje().show(Alert.AlertType.ERROR, "Error de movimiento", "Movimiento inválido, intentelo de nuevo");
                        }
                    }

                } else if (this.color == 33)//CEREBRO-VIRUS
                {
                    //--------------- CURAR ORGANOS -----------------
                    if (CartaAux.color == 3 && CartaAux.tipoCarta.equals("Medicinas") && this.estado.equals("Contaminado")) {
                        for (Carta carta : MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1) {
                            if (carta.equals(CartaAux) && !dentroMedicina) {

                                MainServidor.juegoMain.cementerio.add(CartaAux);
                                MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1.remove(carta);
                                InicioController.masoStatico.getChildren().clear();
                                InicioController.masoStatico.getChildren().addAll(MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1);
                                this.setImage(new Image("viruss/recursos/CEREBRO.jpg"));
                                this.setTipoCarta("Organos");
                                this.setColor(3);
                                this.setEstado("Estable");
                                pasarTurno = true;
                                break;
                            }
                        }
                    } //--------------  MATAR ORGANOS    -------------------------------------------
                    else if (CartaAux.color == 3 && CartaAux.tipoCarta.equals("Virus") && this.estado.equals("Contaminado")) {
                        for (Carta carta : MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1) {
                            if (carta.equals(CartaAux) && fuera) {
                                MainServidor.juegoMain.cementerio.add(CartaAux);
                                MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1.remove(carta);
                                InicioController.masoStatico.getChildren().clear();
                                InicioController.masoStatico.getChildren().addAll(MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1);
                                this.setTipoCarta("Organos");
                                this.setColor(3);
                                this.setEstado("Estable");
                                this.setImage(new Image("viruss/recursos/CEREBRO.jpg"));
                                MainServidor.juegoMain.cementerio.add(this);
                                InicioController.basura.getChildren().add(this);
                                InicioController.basura.getChildren().remove(0);
                                for (Jugador jugadore : MainServidor.juegoMain.jugadores) {
                                    for (Carta carta1 : jugadore.mazo2) {
                                        System.out.println(this.idcarta);
                                        System.out.println(carta1.idcarta);
                                        if (this.idcarta == carta1.idcarta) {
                                            jugadore.mazo2.remove(carta1);
                                            break;
                                        }
                                    }

                                }
                                pasarTurno = true;
                                break;

                            }
                        }
                    } else if (CartaAux.color == 5 && CartaAux.tipoCarta.equals("Tratamientos")) //------------------------------ TRANSPLANTE-----------------------------------
                    {
                        boolean bandd = true;
                        int jugcoon2 = 0;
                        for (Carta carta : MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1) {
                            if (carta.equals(CartaAux) && fuera) {
                                for (int i = 0; i < MainServidor.juegoMain.jugadores.size(); i++) {

                                    for (Carta carta1 : MainServidor.juegoMain.jugadores.get(i).mazo2) {
                                        if (this.idcarta == carta1.idcarta) {
                                            bandd = false;
                                            listaVerificar = MainServidor.juegoMain.jugadores.get(i).mazo2;
                                            jugcoon2 = i;
                                            break;
                                        }

                                    }
                                }

                            }

                        }
                        if (!bandd) {
                            MainServidor.juegoMain.jugadores.get(jugcoon2).mazo2 = MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo2;
                            MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo2 = listaVerificar;

                            MainServidor.juegoMain.cementerio.add(CartaAux);
                            MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1.remove(CartaAux);
                            cont = 0;
                            cargarPartida();
                            pasarTurno = true;
                        } else {
                            new Mensaje().show(Alert.AlertType.ERROR, "Error de movimiento", "Movimiento inválido, intentelo de nuevo");
                        }
                    } else if (CartaAux.color == 5 && CartaAux.tipoCarta.equals("Medicinas") && this.estado.equals("Contaminado")) //------------------------------ HOSPITAL ORGANO VACUNA-----------------------------------
                    {
                        for (Carta carta : MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1) {
                            if (carta.equals(CartaAux) && !dentroMedicina) {
                                MainServidor.juegoMain.cementerio.add(CartaAux);
                                MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1.remove(carta);
                                InicioController.masoStatico.getChildren().clear();
                                InicioController.masoStatico.getChildren().addAll(MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1);
                                this.setImage(new Image("viruss/recursos/CEREBRO.jpg"));
                                this.setTipoCarta("Organos");
                                this.setColor(3);
                                this.setEstado("Estable");
                                pasarTurno = true;
                                break;

                            }
                        }
                    } else if (CartaAux.color == 5 && CartaAux.tipoCarta.equals("Virus") && this.estado.equals("Contaminado")) {
                        for (Carta carta : MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1) {
                            if (carta.equals(CartaAux) && fuera) {
                                MainServidor.juegoMain.cementerio.add(CartaAux);
                                MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1.remove(carta);
                                InicioController.masoStatico.getChildren().clear();
                                InicioController.masoStatico.getChildren().addAll(MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1);
                                this.setTipoCarta("Organos");
                                this.setColor(3);
                                this.setEstado("Estable");
                                this.setImage(new Image("viruss/recursos/CEREBRO.jpg"));
                                MainServidor.juegoMain.cementerio.add(this);
                                InicioController.basura.getChildren().add(this);
                                InicioController.basura.getChildren().remove(0);
                                for (Jugador jugadore : MainServidor.juegoMain.jugadores) {
                                    for (Carta carta1 : jugadore.mazo2) {
                                        if (this.idcarta == carta1.idcarta) {
                                            jugadore.mazo2.remove(carta1);
                                            break;
                                        }
                                    }

                                }
                                pasarTurno = true;
                                break;

                            }
                        }
                    } else if (CartaAux.color == 1 && CartaAux.tipoCarta.equals("Tratamientos") && !this.tipoCarta.equals("OrganosInmune")) //------------------------------ TRANSPLANTE-----------------------------------
                    {
                        for (Carta carta : MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1) {
                            if (carta.equals(CartaAux) && !dentroMedicina) {
                                CartaAux2 = CartaAux;
                                CartaAux = this;
                                cont++;
                                break;

                            }
                        }
                    } else if (CartaAux.color == 2 && CartaAux.tipoCarta.equals("Tratamientos") && !this.tipoCarta.equals("OrganosInmune")) //------------------------------ TRANSPLANTE-----------------------------------
                    {
                        Carta carElegida = new Carta();
                        boolean bandCarta = true;
                        for (Carta carta : MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1) {
                            if (carta.equals(CartaAux) && fuera) {

                                for (Jugador jugadore : MainServidor.juegoMain.jugadores) {
                                    for (Carta carta12 : jugadore.mazo2) {
                                        if (this.idcarta == carta12.idcarta) {
                                            carElegida = carta12;
                                            listaVerificarCarta = jugadore.mazo2;
                                        }
                                    }
                                    for (Carta carta2 : MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo2) {
                                        if (carElegida.color == carta2.color) {
                                            bandCarta = false;
                                            break;
                                        }
                                    }

                                }
                            }
                        }
                        if (bandCarta) {
                            MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo2.add(carElegida);
                            listaVerificarCarta.remove(carElegida);
                            MainServidor.juegoMain.cementerio.add(CartaAux);
                            MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1.remove(CartaAux);
                            InicioController.masoStatico.getChildren().clear();
                            InicioController.masoStatico.getChildren().addAll(MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1);
                            cont = 0;
                            pasarTurno = true;
                            cargarPartida();

                        } else {
                            new Mensaje().show(Alert.AlertType.ERROR, "Error de movimiento", "Movimiento inválido, intentelo de nuevo");
                        }
                    }

                } else if (this.color == 44)//HUESO-VIRUS
                {
                    //--------------- CURAR ORGANOS -----------------
                    if (CartaAux.color == 4 && CartaAux.tipoCarta.equals("Medicinas") && this.estado.equals("Contaminado")) {
                        for (Carta carta : MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1) {
                            if (carta.equals(CartaAux) && !dentroMedicina) {

                                MainServidor.juegoMain.cementerio.add(CartaAux);
                                MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1.remove(carta);
                                InicioController.masoStatico.getChildren().clear();
                                InicioController.masoStatico.getChildren().addAll(MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1);
                                this.setImage(new Image("viruss/recursos/HUESO.jpg"));
                                this.setTipoCarta("Organos");
                                this.setColor(4);
                                this.setEstado("Estable");
                                pasarTurno = true;
                                break;
                            }
                        }
                    } //--------------  MATAR ORGANOS    -------------------------------------------
                    else if (CartaAux.color == 4 && CartaAux.tipoCarta.equals("Virus") && this.estado.equals("Contaminado")) {
                        for (Carta carta : MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1) {
                            if (carta.equals(CartaAux) && fuera) {
                                MainServidor.juegoMain.cementerio.add(CartaAux);
                                MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1.remove(carta);
                                InicioController.masoStatico.getChildren().clear();
                                InicioController.masoStatico.getChildren().addAll(MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1);
                                this.setTipoCarta("Organos");
                                this.setColor(4);
                                this.setEstado("Estable");
                                this.setImage(new Image("viruss/recursos/HUESO.jpg"));
                                MainServidor.juegoMain.cementerio.add(this);
                                InicioController.basura.getChildren().add(this);
                                InicioController.basura.getChildren().remove(0);
                                for (Jugador jugadore : MainServidor.juegoMain.jugadores) {
                                    for (Carta carta1 : jugadore.mazo2) {
                                        System.out.println(this.idcarta);
                                        System.out.println(carta1.idcarta);
                                        if (this.idcarta == carta1.idcarta) {
                                            jugadore.mazo2.remove(carta1);
                                            break;
                                        }
                                    }

                                }
                                pasarTurno = true;
                                break;

                            }
                        }
                    } else if (CartaAux.color == 5 && CartaAux.tipoCarta.equals("Medicinas") && this.estado.equals("Contaminado")) //------------------------------ HOSPITAL ORGANO VACUNA-----------------------------------
                    {
                        for (Carta carta : MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1) {
                            if (carta.equals(CartaAux) && !dentroMedicina) {
                                MainServidor.juegoMain.cementerio.add(CartaAux);
                                MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1.remove(carta);
                                InicioController.masoStatico.getChildren().clear();
                                InicioController.masoStatico.getChildren().addAll(MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1);
                                this.setImage(new Image("viruss/recursos/HUESO.jpg"));
                                this.setTipoCarta("Organos");
                                this.setColor(4);
                                this.setEstado("Estable");
                                pasarTurno = true;
                                break;

                            }
                        }
                    } else if (CartaAux.color == 5 && CartaAux.tipoCarta.equals("Tratamientos")) //------------------------------ TRANSPLANTE-----------------------------------
                    {
                        boolean bandd = true;
                        int jugcoon2 = 0;
                        for (Carta carta : MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1) {
                            if (carta.equals(CartaAux) && fuera) {
                                for (int i = 0; i < MainServidor.juegoMain.jugadores.size(); i++) {

                                    for (Carta carta1 : MainServidor.juegoMain.jugadores.get(i).mazo2) {
                                        if (this.idcarta == carta1.idcarta) {
                                            bandd = false;
                                            listaVerificar = MainServidor.juegoMain.jugadores.get(i).mazo2;
                                            jugcoon2 = i;
                                            break;
                                        }

                                    }
                                }

                            }

                        }
                        if (!bandd) {
                            MainServidor.juegoMain.jugadores.get(jugcoon2).mazo2 = MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo2;
                            MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo2 = listaVerificar;

                            MainServidor.juegoMain.cementerio.add(CartaAux);
                            MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1.remove(CartaAux);
                            cont = 0;
                            cargarPartida();
                            pasarTurno = true;
                        } else {
                            new Mensaje().show(Alert.AlertType.ERROR, "Error de movimiento", "Movimiento inválido, intentelo de nuevo");
                        }
                    } else if (CartaAux.color == 5 && CartaAux.tipoCarta.equals("Virus") && this.estado.equals("Contaminado")) {
                        for (Carta carta : MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1) {
                            if (carta.equals(CartaAux) && fuera) {
                                MainServidor.juegoMain.cementerio.add(CartaAux);
                                MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1.remove(carta);
                                InicioController.masoStatico.getChildren().clear();
                                InicioController.masoStatico.getChildren().addAll(MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1);
                                this.setTipoCarta("Organos");
                                this.setColor(4);
                                this.setEstado("Estable");
                                this.setImage(new Image("viruss/recursos/HUESO.jpg"));
                                MainServidor.juegoMain.cementerio.add(this);
                                InicioController.basura.getChildren().add(this);
                                InicioController.basura.getChildren().remove(0);
                                for (Jugador jugadore : MainServidor.juegoMain.jugadores) {
                                    for (Carta carta1 : jugadore.mazo2) {
                                        System.out.println(this.idcarta);
                                        System.out.println(carta1.idcarta);
                                        if (this.idcarta == carta1.idcarta) {
                                            jugadore.mazo2.remove(carta1);
                                            break;
                                        }
                                    }

                                }
                                pasarTurno = true;
                                break;

                            }
                        }
                    } else if (CartaAux.color == 1 && CartaAux.tipoCarta.equals("Tratamientos") && !this.tipoCarta.equals("OrganosInmune")) //------------------------------ TRANSPLANTE-----------------------------------
                    {
                        for (Carta carta : MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1) {
                            if (carta.equals(CartaAux) && !dentroMedicina) {
                                CartaAux2 = CartaAux;
                                CartaAux = this;
                                cont++;
                                break;

                            }
                        }
                    }

                } else if (CartaAux.color == 2 && CartaAux.tipoCarta.equals("Tratamientos") && !this.tipoCarta.equals("OrganosInmune")) //------------------------------ TRANSPLANTE-----------------------------------
                {
                    Carta carElegida = new Carta();
                    boolean bandCarta = true;
                    for (Carta carta : MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1) {
                        if (carta.equals(CartaAux) && fuera) {

                            for (Jugador jugadore : MainServidor.juegoMain.jugadores) {
                                for (Carta carta12 : jugadore.mazo2) {
                                    if (this.idcarta == carta12.idcarta) {
                                        carElegida = carta12;
                                        listaVerificarCarta = jugadore.mazo2;
                                    }
                                }
                                for (Carta carta2 : MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo2) {
                                    if (carElegida.color == carta2.color) {
                                        bandCarta = false;
                                        break;
                                    }
                                }

                            }
                        }
                    }
                    if (bandCarta) {
                        MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo2.add(carElegida);
                        listaVerificarCarta.remove(carElegida);
                        MainServidor.juegoMain.cementerio.add(CartaAux);
                        MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1.remove(CartaAux);
                        InicioController.masoStatico.getChildren().clear();
                        InicioController.masoStatico.getChildren().addAll(MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1);
                        cont = 0;
                        pasarTurno = true;
                        cargarPartida();

                    } else {
                        new Mensaje().show(Alert.AlertType.ERROR, "Error de movimiento", "Movimiento inválido, intentelo de nuevo");
                    }
                }

            } else if (this.tipoCarta.equals("OrganosVacuna"))//---------------- ORGANOS INMUNES --------------------------------------------------
            {
                if (this.color == 1) {
                    if (CartaAux.color == 1 && CartaAux.tipoCarta.equals("Medicinas")) {
                        for (Carta carta : MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1) {
                            if (carta.equals(CartaAux) && !dentroMedicina) {
                                MainServidor.juegoMain.cementerio.add(CartaAux);
                                MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1.remove(carta);
                                InicioController.masoStatico.getChildren().clear();
                                InicioController.masoStatico.getChildren().addAll(MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1);
                                this.setImage(new Image("viruss/recursos/CORAZONINM2.jpg"));
                                this.setTipoCarta("OrganosInmune");
                                pasarTurno = true;
                                break;

                            }
                        }
                    } else if (CartaAux.color == 5 && CartaAux.tipoCarta.equals("Tratamientos")) //------------------------------ TRANSPLANTE-----------------------------------
                    {
                        boolean bandd = true;
                        int jugcoon2 = 0;
                        for (Carta carta : MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1) {
                            if (carta.equals(CartaAux) && fuera) {
                                for (int i = 0; i < MainServidor.juegoMain.jugadores.size(); i++) {

                                    for (Carta carta1 : MainServidor.juegoMain.jugadores.get(i).mazo2) {
                                        if (this.idcarta == carta1.idcarta) {
                                            bandd = false;
                                            listaVerificar = MainServidor.juegoMain.jugadores.get(i).mazo2;
                                            jugcoon2 = i;
                                            break;
                                        }

                                    }
                                }

                            }

                        }
                        if (!bandd) {
                            MainServidor.juegoMain.jugadores.get(jugcoon2).mazo2 = MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo2;
                            MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo2 = listaVerificar;

                            MainServidor.juegoMain.cementerio.add(CartaAux);
                            MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1.remove(CartaAux);
                            cont = 0;
                            cargarPartida();
                            pasarTurno = true;
                        } else {
                            new Mensaje().show(Alert.AlertType.ERROR, "Error de movimiento", "Movimiento inválido, intentelo de nuevo");
                        }
                    } else if (CartaAux.color == 1 && CartaAux.tipoCarta.equals("Virus")) { //------------------------------------------------------ DESTRUIR MEDICNINA -------------------------------
                        for (Carta carta : MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1) {
                            if (carta.equals(CartaAux) && fuera) {
                                MainServidor.juegoMain.cementerio.add(CartaAux);
                                MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1.remove(carta);
                                InicioController.masoStatico.getChildren().clear();
                                InicioController.masoStatico.getChildren().addAll(MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1);
                                this.setImage(new Image("viruss/recursos/CORAZON.jpg"));
                                this.setTipoCarta("Organos");
                                pasarTurno = true;
                                break;

                            }
                        }
                    } else if (CartaAux.color == 5 && CartaAux.tipoCarta.equals("Virus"))//------------------------------ COVID 19 ATC ORGANO VACUNA -----------------------------------
                    {
                        for (Carta carta : MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1) {
                            if (carta.equals(CartaAux) && fuera) {
                                MainServidor.juegoMain.cementerio.add(CartaAux);
                                MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1.remove(carta);
                                InicioController.masoStatico.getChildren().clear();
                                InicioController.masoStatico.getChildren().addAll(MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1);
                                this.setImage(new Image("viruss/recursos/CORAZON.jpg"));
                                this.setTipoCarta("Organos");
                                this.setColor(1);
                                this.setEstado("Estable");
                                pasarTurno = true;
                                break;

                            }
                        }
                    } else if (CartaAux.color == 1 && CartaAux.tipoCarta.equals("Tratamientos") && !this.tipoCarta.equals("OrganosInmune")) //------------------------------ TRANSPLANTE-----------------------------------
                    {
                        for (Carta carta : MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1) {
                            if (carta.equals(CartaAux) && !dentroMedicina) {
                                CartaAux2 = CartaAux;
                                CartaAux = this;
                                cont++;
                                break;

                            }
                        }
                    } else if (CartaAux.color == 2 && CartaAux.tipoCarta.equals("Tratamientos") && !this.tipoCarta.equals("OrganosInmune")) //------------------------------ TRANSPLANTE-----------------------------------
                    {
                        Carta carElegida = new Carta();
                        boolean bandCarta = true;
                        for (Carta carta : MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1) {
                            if (carta.equals(CartaAux) && fuera) {

                                for (Jugador jugadore : MainServidor.juegoMain.jugadores) {
                                    for (Carta carta12 : jugadore.mazo2) {
                                        if (this.idcarta == carta12.idcarta) {
                                            carElegida = carta12;
                                            listaVerificarCarta = jugadore.mazo2;
                                        }
                                    }
                                    for (Carta carta2 : MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo2) {
                                        if (carElegida.color == carta2.color) {
                                            bandCarta = false;
                                            break;
                                        }
                                    }

                                }
                            }
                        }
                        if (bandCarta) {
                            MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo2.add(carElegida);
                            listaVerificarCarta.remove(carElegida);
                            MainServidor.juegoMain.cementerio.add(CartaAux);
                            MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1.remove(CartaAux);
                            InicioController.masoStatico.getChildren().clear();
                            InicioController.masoStatico.getChildren().addAll(MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1);
                            cont = 0;
                            pasarTurno = true;
                            cargarPartida();

                        } else {
                            new Mensaje().show(Alert.AlertType.ERROR, "Error de movimiento", "Movimiento inválido, intentelo de nuevo");
                        }
                    }
                } else if (this.color == 2) {
                    if (CartaAux.color == 2 && CartaAux.tipoCarta.equals("Medicinas")) {
                        for (Carta carta : MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1) {
                            if (carta.equals(CartaAux) && !dentroMedicina) {
                                MainServidor.juegoMain.cementerio.add(CartaAux);
                                MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1.remove(carta);
                                InicioController.masoStatico.getChildren().clear();
                                InicioController.masoStatico.getChildren().addAll(MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1);
                                this.setImage(new Image("viruss/recursos/ESTOMAGOINM2.jpg"));
                                this.setTipoCarta("OrganosInmune");
                                pasarTurno = true;
                                break;

                            }
                        }
                    } else if (CartaAux.color == 2 && CartaAux.tipoCarta.equals("Virus")) { //------------------------------------------------------ DESTRUIR MEDICNINA -------------------------------
                        for (Carta carta : MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1) {
                            if (carta.equals(CartaAux) && fuera) {
                                MainServidor.juegoMain.cementerio.add(CartaAux);
                                MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1.remove(carta);
                                InicioController.masoStatico.getChildren().clear();
                                InicioController.masoStatico.getChildren().addAll(MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1);
                                this.setImage(new Image("viruss/recursos/ESTOMAGO.jpg"));
                                this.setTipoCarta("Organos");
                                pasarTurno = true;
                                break;

                            }
                        }
                    } else if (CartaAux.color == 5 && CartaAux.tipoCarta.equals("Tratamientos")) //------------------------------ TRANSPLANTE-----------------------------------
                    {
                        boolean bandd = true;
                        int jugcoon2 = 0;
                        for (Carta carta : MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1) {
                            if (carta.equals(CartaAux) && fuera) {
                                for (int i = 0; i < MainServidor.juegoMain.jugadores.size(); i++) {

                                    for (Carta carta1 : MainServidor.juegoMain.jugadores.get(i).mazo2) {
                                        if (this.idcarta == carta1.idcarta) {
                                            bandd = false;
                                            listaVerificar = MainServidor.juegoMain.jugadores.get(i).mazo2;
                                            jugcoon2 = i;
                                            break;
                                        }

                                    }
                                }

                            }

                        }
                        if (!bandd) {
                            MainServidor.juegoMain.jugadores.get(jugcoon2).mazo2 = MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo2;
                            MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo2 = listaVerificar;

                            MainServidor.juegoMain.cementerio.add(CartaAux);
                            MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1.remove(CartaAux);
                            cont = 0;
                            cargarPartida();
                            pasarTurno = true;
                        } else {
                            new Mensaje().show(Alert.AlertType.ERROR, "Error de movimiento", "Movimiento inválido, intentelo de nuevo");
                        }
                    } else if (CartaAux.color == 5 && CartaAux.tipoCarta.equals("Virus"))//------------------------------ COVID 19 ATC ORGANO VACUNA -----------------------------------
                    {
                        for (Carta carta : MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1) {
                            if (carta.equals(CartaAux) && fuera) {
                                MainServidor.juegoMain.cementerio.add(CartaAux);
                                MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1.remove(carta);
                                InicioController.masoStatico.getChildren().clear();
                                InicioController.masoStatico.getChildren().addAll(MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1);
                                this.setImage(new Image("viruss/recursos/ESTOMAGO.jpg"));
                                this.setTipoCarta("Organos");
                                this.setColor(2);
                                this.setEstado("Estable");
                                pasarTurno = true;
                                break;

                            }
                        }
                    } else if (CartaAux.color == 1 && CartaAux.tipoCarta.equals("Tratamientos") && !this.tipoCarta.equals("OrganosInmune")) //------------------------------ TRANSPLANTE-----------------------------------
                    {
                        for (Carta carta : MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1) {
                            if (carta.equals(CartaAux) && !dentroMedicina) {
                                CartaAux2 = CartaAux;
                                CartaAux = this;
                                cont++;
                                break;

                            }
                        }
                    } else if (CartaAux.color == 2 && CartaAux.tipoCarta.equals("Tratamientos") && !this.tipoCarta.equals("OrganosInmune")) //------------------------------ TRANSPLANTE-----------------------------------
                    {
                        Carta carElegida = new Carta();
                        boolean bandCarta = true;
                        for (Carta carta : MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1) {
                            if (carta.equals(CartaAux) && fuera) {

                                for (Jugador jugadore : MainServidor.juegoMain.jugadores) {
                                    for (Carta carta12 : jugadore.mazo2) {
                                        if (this.idcarta == carta12.idcarta) {
                                            carElegida = carta12;
                                            listaVerificarCarta = jugadore.mazo2;
                                        }
                                    }
                                    for (Carta carta2 : MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo2) {
                                        if (carElegida.color == carta2.color) {
                                            bandCarta = false;
                                            break;
                                        }
                                    }

                                }
                            }
                        }
                        if (bandCarta) {
                            MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo2.add(carElegida);
                            listaVerificarCarta.remove(carElegida);
                            MainServidor.juegoMain.cementerio.add(CartaAux);
                            MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1.remove(CartaAux);
                            InicioController.masoStatico.getChildren().clear();
                            InicioController.masoStatico.getChildren().addAll(MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1);
                            cont = 0;
                            pasarTurno = true;
                            cargarPartida();

                        } else {
                            new Mensaje().show(Alert.AlertType.ERROR, "Error de movimiento", "Movimiento inválido, intentelo de nuevo");
                        }
                    }

                } else if (this.color == 3) {
                    if (CartaAux.color == 3 && CartaAux.tipoCarta.equals("Medicinas")) {
                        for (Carta carta : MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1) {
                            if (carta.equals(CartaAux) && !dentroMedicina) {
                                MainServidor.juegoMain.cementerio.add(CartaAux);
                                MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1.remove(carta);
                                InicioController.masoStatico.getChildren().clear();
                                InicioController.masoStatico.getChildren().addAll(MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1);
                                this.setImage(new Image("viruss/recursos/CEREBROINM2.jpg"));
                                this.setTipoCarta("OrganosInmune");
                                pasarTurno = true;
                                break;

                            }
                        }
                    } else if (CartaAux.color == 3 && CartaAux.tipoCarta.equals("Virus")) { //------------------------------------------------------ DESTRUIR MEDICNINA -------------------------------
                        for (Carta carta : MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1) {
                            if (carta.equals(CartaAux) && fuera) {
                                MainServidor.juegoMain.cementerio.add(CartaAux);
                                MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1.remove(carta);
                                InicioController.masoStatico.getChildren().clear();
                                InicioController.masoStatico.getChildren().addAll(MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1);
                                this.setImage(new Image("viruss/recursos/CEREBRO.jpg"));
                                this.setTipoCarta("Organos");
                                pasarTurno = true;
                                break;

                            }
                        }
                    } else if (CartaAux.color == 5 && CartaAux.tipoCarta.equals("Tratamientos")) //------------------------------ TRANSPLANTE-----------------------------------
                    {
                        boolean bandd = true;
                        int jugcoon2 = 0;
                        for (Carta carta : MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1) {
                            if (carta.equals(CartaAux) && fuera) {
                                for (int i = 0; i < MainServidor.juegoMain.jugadores.size(); i++) {

                                    for (Carta carta1 : MainServidor.juegoMain.jugadores.get(i).mazo2) {
                                        if (this.idcarta == carta1.idcarta) {
                                            bandd = false;
                                            listaVerificar = MainServidor.juegoMain.jugadores.get(i).mazo2;
                                            jugcoon2 = i;
                                            break;
                                        }

                                    }
                                }

                            }

                        }
                        if (!bandd) {
                            MainServidor.juegoMain.jugadores.get(jugcoon2).mazo2 = MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo2;
                            MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo2 = listaVerificar;

                            MainServidor.juegoMain.cementerio.add(CartaAux);
                            MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1.remove(CartaAux);
                            cont = 0;
                            cargarPartida();
                            pasarTurno = true;
                        } else {
                            new Mensaje().show(Alert.AlertType.ERROR, "Error de movimiento", "Movimiento inválido, intentelo de nuevo");
                        }
                    } else if (CartaAux.color == 5 && CartaAux.tipoCarta.equals("Virus"))//------------------------------ COVID 19 ATC ORGANO VACUNA -----------------------------------
                    {
                        for (Carta carta : MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1) {
                            if (carta.equals(CartaAux) && fuera) {
                                MainServidor.juegoMain.cementerio.add(CartaAux);
                                MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1.remove(carta);
                                InicioController.masoStatico.getChildren().clear();
                                InicioController.masoStatico.getChildren().addAll(MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1);
                                this.setImage(new Image("viruss/recursos/CEREBRO.jpg"));
                                this.setTipoCarta("Organos");
                                this.setColor(3);
                                this.setEstado("Estable");
                                pasarTurno = true;
                                break;

                            }
                        }
                    } else if (CartaAux.color == 1 && CartaAux.tipoCarta.equals("Tratamientos") && !this.tipoCarta.equals("OrganosInmune")) //------------------------------ TRANSPLANTE-----------------------------------
                    {
                        for (Carta carta : MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1) {
                            if (carta.equals(CartaAux) && !dentroMedicina) {
                                CartaAux2 = CartaAux;
                                CartaAux = this;
                                cont++;
                                break;

                            }
                        }
                    } else if (CartaAux.color == 2 && CartaAux.tipoCarta.equals("Tratamientos") && !this.tipoCarta.equals("OrganosInmune")) //------------------------------ TRANSPLANTE-----------------------------------
                    {
                        Carta carElegida = new Carta();
                        boolean bandCarta = true;
                        for (Carta carta : MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1) {
                            if (carta.equals(CartaAux) && fuera) {

                                for (Jugador jugadore : MainServidor.juegoMain.jugadores) {
                                    for (Carta carta12 : jugadore.mazo2) {
                                        if (this.idcarta == carta12.idcarta) {
                                            carElegida = carta12;
                                            listaVerificarCarta = jugadore.mazo2;
                                        }
                                    }
                                    for (Carta carta2 : MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo2) {
                                        if (carElegida.color == carta2.color) {
                                            bandCarta = false;
                                            break;
                                        }
                                    }

                                }
                            }
                        }
                        if (bandCarta) {
                            MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo2.add(carElegida);
                            listaVerificarCarta.remove(carElegida);
                            MainServidor.juegoMain.cementerio.add(CartaAux);
                            MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1.remove(CartaAux);
                            InicioController.masoStatico.getChildren().clear();
                            InicioController.masoStatico.getChildren().addAll(MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1);
                            cont = 0;
                            pasarTurno = true;
                            cargarPartida();

                        } else {
                            new Mensaje().show(Alert.AlertType.ERROR, "Error de movimiento", "Movimiento inválido, intentelo de nuevo");
                        }
                    }

                } else if (this.color == 4) {
                    if (CartaAux.color == 4 && CartaAux.tipoCarta.equals("Medicinas")) {
                        for (Carta carta : MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1) {
                            if (carta.equals(CartaAux) && !dentroMedicina) {
                                MainServidor.juegoMain.cementerio.add(CartaAux);
                                MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1.remove(carta);
                                InicioController.masoStatico.getChildren().clear();
                                InicioController.masoStatico.getChildren().addAll(MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1);
                                this.setImage(new Image("viruss/recursos/HUESOINM2.jpg"));
                                this.setTipoCarta("OrganosInmune");
                                pasarTurno = true;
                                break;

                            }
                        }
                    } else if (CartaAux.color == 4 && CartaAux.tipoCarta.equals("Virus")) { //------------------------------------------------------ DESTRUIR MEDICNINA -------------------------------
                        for (Carta carta : MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1) {
                            if (carta.equals(CartaAux) && fuera) {
                                MainServidor.juegoMain.cementerio.add(CartaAux);
                                MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1.remove(carta);
                                InicioController.masoStatico.getChildren().clear();
                                InicioController.masoStatico.getChildren().addAll(MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1);
                                this.setImage(new Image("viruss/recursos/HUESO.jpg"));
                                this.setTipoCarta("Organos");
                                pasarTurno = true;
                                break;

                            }
                        }
                    } else if (CartaAux.color == 5 && CartaAux.tipoCarta.equals("Tratamientos")) //------------------------------ TRANSPLANTE-----------------------------------
                    {
                        boolean bandd = true;
                        int jugcoon2 = 0;
                        for (Carta carta : MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1) {
                            if (carta.equals(CartaAux) && fuera) {
                                for (int i = 0; i < MainServidor.juegoMain.jugadores.size(); i++) {

                                    for (Carta carta1 : MainServidor.juegoMain.jugadores.get(i).mazo2) {
                                        if (this.idcarta == carta1.idcarta) {
                                            bandd = false;
                                            listaVerificar = MainServidor.juegoMain.jugadores.get(i).mazo2;
                                            jugcoon2 = i;
                                            break;
                                        }

                                    }
                                }

                            }

                        }
                        if (!bandd) {
                            MainServidor.juegoMain.jugadores.get(jugcoon2).mazo2 = MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo2;
                            MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo2 = listaVerificar;

                            MainServidor.juegoMain.cementerio.add(CartaAux);
                            MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1.remove(CartaAux);
                            cont = 0;
                            cargarPartida();
                            pasarTurno = true;
                        } else {
                            new Mensaje().show(Alert.AlertType.ERROR, "Error de movimiento", "Movimiento inválido, intentelo de nuevo");
                        }
                    } else if (CartaAux.color == 5 && CartaAux.tipoCarta.equals("Virus"))//------------------------------ COVID 19 ATC ORGANO VACUNA -----------------------------------
                    {
                        for (Carta carta : MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1) {
                            if (carta.equals(CartaAux) && fuera) {
                                MainServidor.juegoMain.cementerio.add(CartaAux);
                                MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1.remove(carta);
                                InicioController.masoStatico.getChildren().clear();
                                InicioController.masoStatico.getChildren().addAll(MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1);
                                this.setImage(new Image("viruss/recursos/HUESO.jpg"));
                                this.setTipoCarta("Organos");
                                this.setColor(4);
                                this.setEstado("Estable");
                                pasarTurno = true;
                                break;

                            }
                        }
                    } else if (CartaAux.color == 1 && CartaAux.tipoCarta.equals("Tratamientos") && !this.tipoCarta.equals("OrganosInmune")) //------------------------------ TRANSPLANTE-----------------------------------
                    {
                        for (Carta carta : MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1) {
                            if (carta.equals(CartaAux) && !dentroMedicina) {
                                CartaAux2 = CartaAux;
                                CartaAux = this;
                                cont++;
                                break;

                            }
                        }
                    } else if (CartaAux.color == 2 && CartaAux.tipoCarta.equals("Tratamientos") && !this.tipoCarta.equals("OrganosInmune")) //------------------------------ TRANSPLANTE-----------------------------------
                    {
                        Carta carElegida = new Carta();
                        boolean bandCarta = true;
                        for (Carta carta : MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1) {
                            if (carta.equals(CartaAux) && fuera) {

                                for (Jugador jugadore : MainServidor.juegoMain.jugadores) {
                                    for (Carta carta12 : jugadore.mazo2) {
                                        if (this.idcarta == carta12.idcarta) {
                                            carElegida = carta12;
                                            listaVerificarCarta = jugadore.mazo2;
                                        }
                                    }
                                    for (Carta carta2 : MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo2) {
                                        if (carElegida.color == carta2.color) {
                                            bandCarta = false;
                                            break;
                                        }
                                    }

                                }
                            }
                        }
                        if (bandCarta) {
                            MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo2.add(carElegida);
                            listaVerificarCarta.remove(carElegida);
                            MainServidor.juegoMain.cementerio.add(CartaAux);
                            MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1.remove(CartaAux);
                            InicioController.masoStatico.getChildren().clear();
                            InicioController.masoStatico.getChildren().addAll(MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1);
                            cont = 0;
                            pasarTurno = true;
                            cargarPartida();

                        } else {
                            new Mensaje().show(Alert.AlertType.ERROR, "Error de movimiento", "Movimiento inválido, intentelo de nuevo");
                        }
                    }

                }

            } else if (this.tipoCarta.equals("OrganosInmune")) {
                System.out.println("holaaaaaaaaaaaaaaaaa");
                if (CartaAux.color == 5 && CartaAux.tipoCarta.equals("Tratamientos")) //------------------------------ TRANSPLANTE-----------------------------------
                {
                    boolean bandd = true;
                    int jugcoon2 = 0;
                    for (Carta carta : MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1) {
                        if (carta.equals(CartaAux) && fuera) {
                            for (int i = 0; i < MainServidor.juegoMain.jugadores.size(); i++) {

                                for (Carta carta1 : MainServidor.juegoMain.jugadores.get(i).mazo2) {
                                    if (this.idcarta == carta1.idcarta) {
                                        bandd = false;
                                        listaVerificar = MainServidor.juegoMain.jugadores.get(i).mazo2;
                                        jugcoon2 = i;
                                        break;
                                    }

                                }
                            }

                        }

                    }
                    if (!bandd) {
                        MainServidor.juegoMain.jugadores.get(jugcoon2).mazo2 = MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo2;
                        MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo2 = listaVerificar;

                        MainServidor.juegoMain.cementerio.add(CartaAux);
                        MainServidor.juegoMain.jugadores.get(InicioController.posJug).mazo1.remove(CartaAux);
                        cont = 0;
                        cargarPartida();
                        pasarTurno = true;
                    } else {
                        new Mensaje().show(Alert.AlertType.ERROR, "Error de movimiento", "Movimiento inválido, intentelo de nuevo");
                    }
                }
            }

            image = null;
            if (cont != 2) {
                cont = 0;
            }

        }
    }

    public void cargarPartida() {

        InicioController.masoStatico.getChildren().clear();//maso del jugador
        InicioController.miMesa.getChildren().clear();//mesa
        InicioController.basura.getChildren().clear();
        InicioController.statichboxMesaJug1.getChildren().clear();
        InicioController.statichboxMesaJug3.getChildren().clear();
        InicioController.statichboxMesaJug4.getChildren().clear();
        InicioController.statichboxMesaJug5.getChildren().clear();
        InicioController.statichboxMesaJug6.getChildren().clear();

        for (int i = 0; i < MainServidor.juegoMain.mazo.size(); i++) {
            MainServidor.juegoMain.mazo.get(i).setImg();
        }

        for (int j = 0; j < MainServidor.juegoMain.jugadores.size(); j++) {
            for (int i = 0; i < MainServidor.juegoMain.jugadores.get(j).mazo1.size(); i++) {
                MainServidor.juegoMain.jugadores.get(j).mazo1.get(i).setImg();

            }
            for (int i = 0; i < MainServidor.juegoMain.jugadores.get(j).mazo2.size(); i++) {
                MainServidor.juegoMain.jugadores.get(j).mazo2.get(i).setImg();

            }
        }

        for (int j = 0; j < MainServidor.juegoMain.jugadores.size(); j++) {

            if (MainServidor.juegoMain.jugadores.get(j).nickname.equals((String) (AppContext.getInstance().get("nick")))) {
                posJug = j;
                InicioController.masoStatico.getChildren().addAll(MainServidor.juegoMain.jugadores.get(j).mazo1);
                InicioController.miMesa.getChildren().addAll(MainServidor.juegoMain.jugadores.get(j).mazo2);
            } else {
                if (InicioController.statichboxMesaJug1.getChildren().isEmpty()) {
                    InicioController.statichboxMesaJug1.getChildren().addAll(MainServidor.juegoMain.jugadores.get(j).mazo2);

                } else if (InicioController.statichboxMesaJug3.getChildren().isEmpty()) {
                    InicioController.statichboxMesaJug3.getChildren().addAll(MainServidor.juegoMain.jugadores.get(j).mazo2);
                } else if (InicioController.statichboxMesaJug4.getChildren().isEmpty()) {
                    InicioController.statichboxMesaJug4.getChildren().addAll(MainServidor.juegoMain.jugadores.get(j).mazo2);
                } else if (InicioController.statichboxMesaJug5.getChildren().isEmpty()) {
                    InicioController.statichboxMesaJug5.getChildren().addAll(MainServidor.juegoMain.jugadores.get(j).mazo2);
                } else if (InicioController.statichboxMesaJug6.getChildren().isEmpty()) {
                    InicioController.statichboxMesaJug6.getChildren().addAll(MainServidor.juegoMain.jugadores.get(j).mazo2);
                }
            }

        }

        if (MainServidor.juegoMain.turno != posJug) {
            for (Carta carta : MainServidor.juegoMain.mazo) {
                carta.setDisable(true);
            }
            InicioController.statichboxMesaJug1.setDisable(true);
            InicioController.miMesa.setDisable(true);
            InicioController.statichboxMesaJug1.setDisable(true);
            InicioController.statichboxMesaJug1.setDisable(true);
            InicioController.statichboxMesaJug1.setDisable(true);
            InicioController.statichboxMesaJug1.setDisable(true);
            InicioController.basura.setDisable(true);
            InicioController.masoStatico.setDisable(true);
        } else {
            for (Carta carta : MainServidor.juegoMain.mazo) {
                carta.setDisable(false);
            }
            InicioController.statichboxMesaJug1.setDisable(false);
            InicioController.miMesa.setDisable(false);
            InicioController.statichboxMesaJug1.setDisable(false);
            InicioController.statichboxMesaJug1.setDisable(false);
            InicioController.statichboxMesaJug1.setDisable(false);
            InicioController.statichboxMesaJug1.setDisable(false);
            InicioController.basura.setDisable(false);
            InicioController.masoStatico.setDisable(false);

        }

    }

    public int getIdcarta() {
        return idcarta;
    }

    public void setIdcarta(int idcarta) {
        this.idcarta = idcarta;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public int getAltura() {
        return altura;
    }

    public void setAncho(int ancho) {
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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Carta{" + "tipoCarta=" + tipoCarta + ", color=" + color + ", estado=" + estado + ", image=" + image + '}';
    }

}
