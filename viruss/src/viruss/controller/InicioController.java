/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viruss.controller;

import java.io.IOException;
import static java.lang.Boolean.FALSE;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.util.Duration;
import viruss.model.Carta;
import viruss.model.Cliente;
import viruss.model.Conexion;
import viruss.model.Jugador;
import viruss.model.MainServidor;
import viruss.model.Servidor;
import viruss.util.AppContext;
import viruss.util.FlowController;

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
    int contMaso = 0;
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
    public String nombre;
    public static int posJug;
    @FXML
    private ImageView cemento;
    public static List<Carta> ListaMesaJugador = new ArrayList();
    @FXML
    private HBox HboxBasura;
    public static HBox basura;
    public static HBox statichboxMesaJug1;
    public static HBox statichboxMesaJug3;
    public static HBox statichboxMesaJug4;
    public static HBox statichboxMesaJug5;
    public static HBox statichboxMesaJug6;
    public static Stage stage;

    Timeline timeline;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        masoStatico = hboxMasoJug;
        miMesa = hboxMesaJug2;
        basura = HboxBasura;
        statichboxMesaJug1 = hboxMesaJug1;
        statichboxMesaJug3 = hboxMesaJug3;
        statichboxMesaJug4 = hboxMesaJug4;
        statichboxMesaJug5 = hboxMesaJug5;
        statichboxMesaJug6 = hboxMesaJug6;
        stage = this.getStage();
        cargarPartida();
        hiloServidor();

    }

    @Override
    public void initialize() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void hiloServidor() {
        timeline = new Timeline(new KeyFrame(Duration.seconds(5), ev -> {
            try {
                if (MainServidor.juegoMain.turno != posJug) {
                    iniciarServidor();

                }
                timeline.stop();
            } catch (IOException ex) {
                Logger.getLogger(InicioController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

    @FXML
    private void actionMasoClick(MouseEvent event) throws IOException {
        
        if (contMaso == 0) {
            contMaso = 1;
            if (MainServidor.juegoMain.mazo.isEmpty() != true) {
                hboxMasoJug.getChildren().add(MainServidor.juegoMain.mazo.get(MainServidor.juegoMain.mazo.size() - 1));
                MainServidor.juegoMain.jugadores.get(posJug).mazo1.add(MainServidor.juegoMain.mazo.get(MainServidor.juegoMain.mazo.size() - 1));
                MainServidor.juegoMain.mazo.remove(MainServidor.juegoMain.mazo.get(MainServidor.juegoMain.mazo.size() - 1));
            } else {

                MainServidor.juegoMain.mazo.addAll(MainServidor.juegoMain.cementerio);
                MainServidor.juegoMain.cementerio.clear();
            }

            iniciarCliente();
            if (MainServidor.juegoMain.turno == MainServidor.juegoMain.jugadores.size() - 1) {
                MainServidor.juegoMain.turno = 0;

            } else {
                MainServidor.juegoMain.turno++;
            }
            hiloServidor();
        }
    }

    @FXML
    private void actionHboxJug(MouseEvent event) throws IOException {
        if (cartaSelec != null) {
            boolean band = true;
            for (Carta carta : MainServidor.juegoMain.jugadores.get(posJug).mazo2) {
                if ((carta.getTipoCarta().equals("OrganosVacuna") && carta.color == cartaSelec.color ) || (carta.getTipoCarta().equals("OrganosInmune") && carta.color == cartaSelec.color)  || (carta.getTipoCarta().equals("OrganosVacuna") && carta.color == cartaSelec.color )) {
                    System.out.println("rico");
                    band = false;
                }
            }
            if (band) {
                MainServidor.juegoMain.jugadores.get(posJug).mazo2.add(InicioController.cartaSelec);
                hboxMesaJug2.getChildren().add(InicioController.cartaSelec);
                MainServidor.juegoMain.jugadores.get(posJug).mazo1.remove(InicioController.cartaSelec);

                iniciarCliente();
                if (MainServidor.juegoMain.turno == MainServidor.juegoMain.jugadores.size() - 1) {
                    MainServidor.juegoMain.turno = 0;

                } else {
                    MainServidor.juegoMain.turno++;
                }
                hiloServidor();
            }

            Carta.cont = 0;
            cartaSelec = null;

        }

    }

    private void iniciarServidor() throws IOException {
        Servidor serv = new Servidor(); //Se crea el servidor
        System.out.println("Iniciando servidor\n");
        serv.startServer(); //Se inicia el servidor

        if (MainServidor.juegoMain.turno != posJug) {
            cargarPartida();
            hiloServidor();
        } else {

            cargarPartida();
        }
    }

    private void iniciarCliente() throws IOException {
        Cliente cli = new Cliente(); //Se crea el cliente
        System.out.println("Iniciando cliente\n");
        cli.startClient(); //Se inicia el cliente
    }

    public void cargarPartida() {
        contMaso = 0;
        nombre = (String) AppContext.getInstance().get("nick");
        hboxMesaJug1.getChildren().clear();
        hboxMesaJug2.getChildren().clear();
        hboxMesaJug3.getChildren().clear();
        hboxMesaJug4.getChildren().clear();
        hboxMesaJug5.getChildren().clear();
        hboxMesaJug6.getChildren().clear();
        hboxmaso.getChildren().clear();
        HboxBasura.getChildren().clear();
        hboxMasoJug.getChildren().clear();

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

            if (MainServidor.juegoMain.jugadores.get(j).nickname.equals(nombre)) {
                posJug = j;
                hboxMasoJug.getChildren().addAll(MainServidor.juegoMain.jugadores.get(j).mazo1);
                hboxMesaJug2.getChildren().addAll(MainServidor.juegoMain.jugadores.get(j).mazo2);
            } else {
                if (hboxMesaJug1.getChildren().isEmpty()) {
                    hboxMesaJug1.getChildren().addAll(MainServidor.juegoMain.jugadores.get(j).mazo2);

                } else if (hboxMesaJug3.getChildren().isEmpty()) {
                    hboxMesaJug3.getChildren().addAll(MainServidor.juegoMain.jugadores.get(j).mazo2);
                } else if (hboxMesaJug4.getChildren().isEmpty()) {
                    hboxMesaJug4.getChildren().addAll(MainServidor.juegoMain.jugadores.get(j).mazo2);
                } else if (hboxMesaJug5.getChildren().isEmpty()) {
                    hboxMesaJug5.getChildren().addAll(MainServidor.juegoMain.jugadores.get(j).mazo2);
                } else if (hboxMesaJug6.getChildren().isEmpty()) {
                    hboxMesaJug6.getChildren().addAll(MainServidor.juegoMain.jugadores.get(j).mazo2);
                }
            }

        }
        System.out.println(posJug);
        System.out.println(MainServidor.juegoMain.turno);
        if (MainServidor.juegoMain.turno != posJug) {
            for (Carta carta : MainServidor.juegoMain.mazo) {
                carta.setDisable(true);
            }
            hboxMesaJug1.setDisable(true);
            hboxMesaJug2.setDisable(true);
            hboxMesaJug3.setDisable(true);
            hboxMesaJug4.setDisable(true);
            hboxMesaJug5.setDisable(true);
            hboxMesaJug6.setDisable(true);
            hboxmaso.setDisable(true);
            HboxBasura.setDisable(true);
            hboxMasoJug.setDisable(true);
        } else {
            for (Carta carta : MainServidor.juegoMain.mazo) {
                carta.setDisable(false);
            }
            hboxMesaJug1.setDisable(false);
            hboxMesaJug2.setDisable(false);
            hboxMesaJug3.setDisable(false);
            hboxMesaJug4.setDisable(false);
            hboxMesaJug5.setDisable(false);
            hboxMesaJug6.setDisable(false);
            hboxmaso.setDisable(false);
            HboxBasura.setDisable(false);
            hboxMasoJug.setDisable(false);

        }

    }

}
