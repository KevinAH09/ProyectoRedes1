/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viruss.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import javax.swing.JOptionPane;
import viruss.util.AppContext;
import viruss.util.FlowController;

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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Timeline clock =new Timeline(new KeyFrame(Duration.ZERO, e->{
        DateTimeFormatter format= DateTimeFormatter.ofPattern("HH:mm:ss");
        lHora.setText(LocalDateTime.now().format(format));
        }),new KeyFrame(javafx.util.Duration.seconds(1)));
        clock.setCycleCount(Animation.INDEFINITE);
        clock.play();
        
        Date now = new Date(System.currentTimeMillis());
        SimpleDateFormat date = new SimpleDateFormat("dd-MMM-yyyy");
        lFecha.setText(date.format(now));
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
    private void Ingresar(ActionEvent event) {

//            AppContext.getInstance().set("nick", txtNick.getText());
            FlowController.getInstance().goView("Inicio");
      
        
    }

    @FXML
    private void ingresarRed(ActionEvent event) {
        String name = JOptionPane.showInputDialog("Ingrese la dirección IP del servidor de destino");
        JOptionPane.showMessageDialog(null, "Se ha guardado la IP ");
        AppContext.getInstance().set("ipservidor", name);
  
    }
    
    
}
    

