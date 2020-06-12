/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viruss.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.Initializable;
import javafx.util.Duration;
import static viruss.controller.InicioController.posJug;
import viruss.model.MainServidor;

/**
 * FXML Controller class
 *
 * @author colo7
 */
public class ViewServirdorActivoController extends Controller implements Initializable {
    Timeline timeline;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
         timeline = new Timeline(new KeyFrame(Duration.seconds(5), ev -> {
             this.getStage().close();
             timeline.stop();
        }));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }
      

    @Override
    public void initialize() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
