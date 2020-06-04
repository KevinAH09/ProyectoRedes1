/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viruss.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
;

import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import javax.swing.JOptionPane;
import viruss.model.Cliente;
import viruss.model.Juego;
import viruss.model.Jugador;
import viruss.model.MainServidor;
import viruss.model.Servidor;
import viruss.util.AppContext;
import viruss.util.FlowController;
import viruss.util.Mensaje;

/**
 * FXML Controller class
 *
 * @author colo7
 */


public class MenuController extends Controller implements Initializable {

    @FXML
    private Label lFecha;
    @FXML
    private Label lHora;
    @FXML
    private Label lCrono;
    @FXML
    private JFXTextField txtNick;
    @FXML
    private JFXButton btnIngresar;
    @FXML
    private AnchorPane scene;
    @FXML
    private JFXButton btnRed;
    @FXML
    private ListView<String> listViewJugadores;
    boolean band = true;
    Timeline t;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Timeline clock = new Timeline(new KeyFrame(Duration.ZERO, e -> {
            DateTimeFormatter format = DateTimeFormatter.ofPattern("HH:mm:ss");
            lHora.setText(LocalDateTime.now().format(format));
        }), new KeyFrame(javafx.util.Duration.seconds(1)));
        clock.setCycleCount(Animation.INDEFINITE);
        clock.play();

        Date now = new Date(System.currentTimeMillis());
        SimpleDateFormat date = new SimpleDateFormat("dd-MMM-yyyy");
        lFecha.setText(date.format(now));
        texto();
//        
//        
//        scene.setOnMouseClicked(new EventHandler<MouseEvent>() {
//            @Override
//            public void handle(MouseEvent mouseEvent) {
//                System.out.println("Mouse clicked X : Y - " + 
//                        mouseEvent.getX() + " : " + mouseEvent.getY());         
////                if(mouseEvent.getButton() == MouseButton.PRIMARY) {
////                    System.out.println("Botón principal");
////                } else if(mouseEvent.getButton() == MouseButton.SECONDARY) {
////                    System.out.println("Botón secundario");
////                }
//            }
//        });

    }

    @Override
    public void initialize() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @FXML
    private void Ingresar(ActionEvent event) throws IOException {
        band = true;
//        AppContext.getInstance().set("nick", txtNick.getText());
        Juego ju = new Juego();
//        Jugador jug = new Jugador();
//        jug.nickname = txtNick.getText();
        Jugador jugador1 = new Jugador("carlos", "1");
        Jugador jugador2 = new Jugador("juan", "2");
        Jugador jugador3 = new Jugador("benito", "3");
        ju.jugadores.add(jugador1);
        ju.jugadores.add(jugador2);
        ju.jugadores.add(jugador3);

        Cliente cli = new Cliente(); //Se crea el cliente
        System.out.println("Iniciando cliente\n");
        cli.startClient(ju); //Se inicia el cliente

        while (band) {
            Servidor serv = new Servidor(); //Se crea el servidor
            System.out.println("Iniciando servidor\n");
            serv.startServer(); //Se inicia el servidor

            for (Jugador j : MainServidor.juegoMain.jugadores) {
                listViewJugadores.getItems().clear();
                listViewJugadores.getItems().add(j.getNickname());
                System.out.println(j.nickname);
            }
            String val = MainServidor.juegoMain.conexion;
            switch (val) {

                case "w":
                    System.out.println("En modo espera de juego");
                    lCrono.setText("Esperando al host");
                    t.play();
                    break;

                case "o":
                    Mensaje.show(Alert.AlertType.ERROR, "Tiempo Fuera", "El tiempo para iniciar el juego llegó al límite y no cumple con la cantidad de jugadores mínimos");
                    band = false;
                    t.stop();
                    lCrono.setText("");
                    break;

                case "l":
                    Mensaje.show(Alert.AlertType.INFORMATION, "Juego por iniciar", "El juego va a iniciar");
                    FlowController.getInstance().goView("Inicio");
                    break;

                default:
                    Mensaje.show(Alert.AlertType.INFORMATION, "Ha ocurrido un error", "Error inesperado");
                    ;
                    break;

            }
        }
    }

    @FXML
    private void ingresarRed(ActionEvent event) {
        String name = JOptionPane.showInputDialog("Ingrese la dirección IP del servidor de destino");
        JOptionPane.showMessageDialog(null, "Se ha guardado la IP ");
        AppContext.getInstance().set("ipservidor", name);

    }

    private void texto() {
        t = new Timeline(
                new KeyFrame(Duration.seconds(0), new KeyValue(lCrono.translateXProperty(), 0)),
                new KeyFrame(Duration.seconds(2), new KeyValue(lCrono.translateXProperty(), 80))
        );
        t.setAutoReverse(true);
        t.setCycleCount(Timeline.INDEFINITE);

    }
}
