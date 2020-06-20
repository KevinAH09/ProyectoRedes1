/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viruss.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
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
    private ListView listViewJugadores;
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

    }

    @Override
    public void initialize() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @FXML
    private void Ingresar(ActionEvent event) throws IOException {
        if (AppContext.getInstance().get("IPSERVIDOR") != null && !txtNick.getText().isEmpty()) {

            band = true;
            AppContext.getInstance().set("nick", txtNick.getText());
            Juego ju = new Juego();
            Jugador jug = new Jugador();
            jug.nickname = txtNick.getText();
            ju.jugadores.add(jug);
            MainServidor.juegoMain = ju;
            Cliente cli = new Cliente(); //Se crea el cliente
            System.out.println("Iniciando cliente\n");
            cli.startClient(); //Se inicia el cliente

            while (band) {
                Servidor serv = new Servidor(); //Se crea el servidor
                System.out.println("Iniciando servidor\n");
                serv.startServer(); //Se inicia el servidor
                String val = MainServidor.juegoMain.conexion;
                listViewJugadores.getItems().clear();
                listViewJugadores.getItems().addAll(FXCollections.observableArrayList(MainServidor.juegoMain.jugadores));
                switch (val) {

                    case "w":
                        System.out.println("En modo espera de juego");
                        lCrono.setText("Esperando al host");
                        break;

                    case "o":
                        Mensaje.show(Alert.AlertType.ERROR, "Tiempo Fuera", "El tiempo para iniciar el juego llegó al límite y no cumple con la cantidad de jugadores mínimos");
                        band = false;
                        lCrono.setText("");
                        break;

                    case "l":
                        band = false;
                        FlowController.getInstance().goView("Inicio");
                        break;

                    default:
                        Mensaje.show(Alert.AlertType.INFORMATION, "Ha ocurrido un error", "Error inesperado");
                        break;

                }
            }
        } else {
            Mensaje.show(Alert.AlertType.ERROR, "ERROR IP", "Ingrese la direccion ip del servidor al que se desea conectar");
        }
    }

    @FXML
    private void ingresarRed(ActionEvent event) {
        String name = JOptionPane.showInputDialog("Ingrese la dirección IP del servidor de destino");
        if (name == null || (name != null && ("".equals(name)))) {
            JOptionPane.showMessageDialog(null, " Ingrese la IP!!!", " ^-^ Campo de IP vacío", JOptionPane.INFORMATION_MESSAGE);

        } else {
            JOptionPane.showMessageDialog(null, "Se ha guardado la IP ", "Confimación de IP", JOptionPane.INFORMATION_MESSAGE);
            AppContext.getInstance().set("IPSERVIDOR", name);
        }
    }

    @FXML
    private void actioonBtnInformacion(ActionEvent event
    ) {
        FlowController.getInstance().goViewInWindowModal("Informacion", this.stage, false);
    }
}
