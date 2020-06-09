/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viruss.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import viruss.model.Carta;
import viruss.model.Cliente;
import viruss.model.Juego;
import viruss.model.Jugador;
import viruss.model.MainServidor;
import viruss.model.Servidor;

/**
 * FXML Controller class
 *
 * @author colo7
 */
public class InicioController extends Controller implements Initializable {

    @FXML
    private HBox hboxMasoJug;
    @FXML
    private HBox hboxMesaJug1;
    @FXML
    private HBox hboxMesaJug2;
    @FXML
    private HBox hboxMesaJug3;
    @FXML
    private HBox hboxMesaJug4;
    @FXML
    private HBox hboxMesaJug5;
    @FXML
    private HBox hboxMesaJug6;
    @FXML
    private HBox hboxmaso;

    public static HBox masoStatico;
    public static HBox miMesa;
    //public static HBox mesaJugador;

    private List<Carta> lista = new ArrayList();
    static private List<Carta> listaRandom = new ArrayList();
    Carta p = new Carta();
    @FXML
    private ImageView imgMaso;
    @FXML
    private ScrollPane scrollpane;
    public static List<Carta> listaMasoJugador = new ArrayList();
    public static List<Carta> listaCementerio = new ArrayList();
    public static Carta cartaSelec = null;

    @FXML
    private ImageView cemento;
    public static List<Carta> ListaMesaJugador = new ArrayList();
    @FXML
    private HBox HboxBasura;
    public static HBox basura;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
//        try {
//            iniciarServidor();
            cargarPartida();
//        } catch (IOException ex) {
//            Logger.getLogger(InicioController.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }

    @Override
    public void initialize() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void crearCartas() {
        for (int i = 0; i < 68; i++) {//organos
            if (i < 21) {
                if (i < 5) {
                    lista.add(new Carta("viruss/recursos/CORAZON.jpg", "Organos", 1, 195, 130));//corazon
                }
                if (i >= 5 && i < 10) {
                    lista.add(new Carta("viruss/recursos/ESTOMAGO.jpg", "Organos", 2, 195, 130));//estomago
                }
                if (i >= 10 && i < 15) {
                    lista.add(new Carta("viruss/recursos/CEREBRO.jpg", "Organos", 3, 195, 130));//cerebor
                }
                if (i >= 15 && i < 20) {
                    lista.add(new Carta("viruss/recursos/HUESO.jpg", "Organos", 4, 195, 130));//hueso
                }
                if (i >= 20 && i < 21) {
                    lista.add(new Carta("viruss/recursos/CUERPO.jpg", "Organos", 5, 195, 130));//comodin
                }
            }
            if (i >= 21 && i < 38)//virus
            {
                if (i < 25) {
                    lista.add(new Carta("viruss/recursos/ROJIVURUS.jpg", "Virus", 1, 195, 130));//ROJIVIRUS
                }
                if (i >= 25 && i < 29) {
                    lista.add(new Carta("viruss/recursos/VERDON EL VIRUS.jpg", "Virus", 2, 195, 130));//VERDON EL VIRUS
                }
                if (i >= 29 && i < 33) {
                    lista.add(new Carta("viruss/recursos/VIRUBLU.jpg", "Virus", 3, 195, 130));//VIRUBLU
                }
                if (i >= 33 && i < 37) {
                    lista.add(new Carta("viruss/recursos/YELLVIRUS.jpg", "Virus", 4, 195, 130));//YELLVIRUS
                }
                if (i >= 37 && i < 38) {
                    lista.add(new Carta("viruss/recursos/COVID-19.jpg", "Virus", 5, 195, 130));//COVID-19
                }
            }
            if (i >= 38 && i < 58)//medicinas
            {
                if (i < 42) {
                    lista.add(new Carta("viruss/recursos/BOTIQUIN.jpg", "Medicinas", 1, 195, 130));//BOTIQUIN
                }
                if (i >= 42 && i < 46) {
                    lista.add(new Carta("viruss/recursos/VACUNA.jpg", "Medicinas", 2, 195, 130));//VACUNA
                }
                if (i >= 46 && i < 50) {
                    lista.add(new Carta("viruss/recursos/ANTISUERO.jpg", "Medicinas", 3, 195, 130));//ANTISUERO
                }
                if (i >= 50 && i < 54) {
                    lista.add(new Carta("viruss/recursos/CURITAS.jpg", "Medicinas", 4, 195, 130));//CURITAS
                }
                if (i >= 54 && i < 58) {
                    lista.add(new Carta("viruss/recursos/HOSPITAL.jpg", "Medicinas", 5, 195, 130));//HOSPITAL
                }
            }
            if (i >= 58 && i < 69)//tratamientos
            {
                if (i < 60) {
                    lista.add(new Carta("viruss/recursos/TRANSPLANTE.jpg", "Tratamientos", 1, 195, 130));//Transplante
                }
                if (i >= 60 && i < 63) {
                    lista.add(new Carta("viruss/recursos/LADRON DE ORGANOS.jpg", "Tratamientos", 2, 195, 130));//Ladrón de órganos
                }
                if (i >= 63 && i < 66) {
                    lista.add(new Carta("viruss/recursos/CONTAGIO.jpg", "Tratamientos", 3, 195, 130));//Contagio
                }
                if (i >= 66 && i < 67) {
                    lista.add(new Carta("viruss/recursos/GUANTES DE LATEX.jpg", "Tratamientos", 4, 195, 130));//Guante de látex
                }
                if (i >= 67 && i < 68) {
                    lista.add(new Carta("viruss/recursos/ERROR MEDICO.jpg", "Tratamientos", 5, 195, 130));//Error médico
                }
            }
        }
    }

    @FXML
    private void actionMasoClick(MouseEvent event) {
        if (MainServidor.juegoMain.mazo.isEmpty() != true) {
            hboxMasoJug.getChildren().add(MainServidor.juegoMain.mazo.get(MainServidor.juegoMain.mazo.size() - 1));
            MainServidor.juegoMain.jugadores.get(0).mazo1.add(MainServidor.juegoMain.mazo.get(MainServidor.juegoMain.mazo.size() - 1));
            MainServidor.juegoMain.mazo.remove(MainServidor.juegoMain.mazo.get(MainServidor.juegoMain.mazo.size() - 1));
        } else {

            MainServidor.juegoMain.mazo.addAll(MainServidor.juegoMain.cementerio);
            MainServidor.juegoMain.cementerio.clear();
        }
    }

    @FXML
    private void actionHboxJug(MouseEvent event) {
        if (cartaSelec != null) {
            boolean band = true;
            for (Carta carta : MainServidor.juegoMain.jugadores.get(0).mazo2) {
                if (carta.color == cartaSelec.color) {
                    band = false;
                }
            }
            if (band) {
                MainServidor.juegoMain.jugadores.get(0).mazo2.add(InicioController.cartaSelec);
                hboxMesaJug2.getChildren().add(InicioController.cartaSelec);
                MainServidor.juegoMain.jugadores.get(0).mazo1.remove(InicioController.cartaSelec);
            }
            Carta.cont = 0;
            cartaSelec = null;

        }

    }
    
    private void iniciarServidor() throws IOException{
        Servidor serv = new Servidor(); //Se crea el servidor
        System.out.println("Iniciando servidor\n");
        serv.startServer(); //Se inicia el servidor
    }
    private void iniciarCliente(Juego ju) throws IOException{
        Cliente cli = new Cliente(); //Se crea el cliente
        System.out.println("Iniciando cliente\n");
        cli.startClient(ju); //Se inicia el cliente
    }
    private void cargarPartida(){
        hboxMesaJug1.getChildren().clear();
        hboxMesaJug2.getChildren().clear();
        hboxMesaJug3.getChildren().clear();
        hboxMesaJug4.getChildren().clear();
        hboxMesaJug5.getChildren().clear();
        hboxMesaJug6.getChildren().clear();
        hboxmaso.getChildren().clear();
        HboxBasura.getChildren().clear();
        hboxMasoJug.getChildren().clear();
//        for (int i = 0; i < MainServidor.juegoMain.mazo.size(); i++) {
//           MainServidor.juegoMain.mazo.get(i).setImg();
//        }
//        for (int i = 0; i < MainServidor.juegoMain.mazo.size(); i++) {
//            hboxmaso.getChildren().add(MainServidor.juegoMain.mazo.get(i));
//        }
        for (int j = 0; j < MainServidor.juegoMain.jugadores.size(); j++) {
            for (int i = 0; i < MainServidor.juegoMain.jugadores.get(j).mazo1.size(); i++) {
                MainServidor.juegoMain.jugadores.get(j).mazo1.get(i).setImg();
//                if(MainServidor.juegoMain.jugadores.get(j).mazo2.size()<=1){
//                    MainServidor.juegoMain.jugadores.get(j).mazo2.get(i).setImg();
//                }
            }
        }

                    hboxMasoJug.getChildren().addAll(MainServidor.juegoMain.jugadores.get(0).mazo1);
//                    hboxMesaJug1.getChildren().addAll(MainServidor.juegoMain.jugadores.get(0).mazo2);

                    hboxMesaJug1.getChildren().addAll(MainServidor.juegoMain.jugadores.get(1).mazo1);

               
                    hboxMesaJug3.getChildren().addAll(MainServidor.juegoMain.jugadores.get(2).mazo1);

//                    hboxMesaJug4.getChildren().add(MainServidor.juegoMain.jugadores.get(4).mazo1.get(cont));

//                    p = MainServidor.juegoMain.jugadores.get(5).mazo1.get(cont);
//                    p.setRotate(180);
//                    hboxMesaJug5.getChildren().add(p);

//                    p = MainServidor.juegoMain.jugadores.get(1).mazo1.get(cont);
//                    p.setRotate(180);
//                    hboxMesaJug6.getChildren().add(p);

//                cont++;
            }
        }

    

