/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viruss.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import viruss.model.Carta;

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
    private VBox hboxMesaJug3;
    @FXML
    private VBox hboxMesaJug4;
    @FXML
    private HBox hboxMesaJug5;
    @FXML
    private HBox hboxMesaJug6;
    @FXML
    private HBox hboxmaso;
    private List <Carta> lista = new ArrayList();
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        crearCartas();
        Image i = new Image("viruss/recursos/MASO.jpg");
        ImageView p = new ImageView(i);
        p.setFitWidth(100);
        p.setFitHeight(100);
        p.setOnMouseClicked(ke->{
            
            hboxMasoJug.getChildren().add(lista.get(lista.size()-1));
            lista.remove(lista.get(lista.size()-1));
        });
        hboxmaso.getChildren().add(p);
        
        int cont=0;
        for(Carta carta : lista)
        {
            
            if(cont<3)
            {
                hboxMasoJug.getChildren().add(cont, carta);
                cont++;
            }
        }
    }   

    @Override
    public void initialize() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void crearCartas()
    {
        for (int i = 0; i < 68; i++) {//organos
            if (i < 21) {
                if (i < 5) {
                    lista.add(new Carta("viruss/recursos/CORAZON.jpg","Organos", 1, 100, 100));//corazon
                }
                if (i >= 5 && i < 10) {
                    lista.add(new Carta("viruss/recursos/ESTOMAGO.jpg","Organos", 2, 100, 100));//estomago
                }
                if (i >= 10 && i < 15) {
                    lista.add(new Carta("viruss/recursos/CEREBRO.jpg","Organos", 3, 100, 100));//cerebor
                }
                if (i >= 15 && i < 20) {
                    lista.add(new Carta("viruss/recursos/HUESO.jpg","Organos", 4, 100, 100));//hueso
                }
                if (i >= 20 && i < 21) {
                    lista.add(new Carta("viruss/recursos/CUERPO.jpg","Organos", 5, 100, 100));//comodin
                }
            }
            if(i>=21 && i<38)//virus
            {
                if (i < 25) {
                    lista.add(new Carta("viruss/recursos/ROJIVURUS.jpg","Virus", 1, 100, 100));//ROJIVIRUS
                }
                if (i >= 25 && i < 29) {
                    lista.add(new Carta("viruss/recursos/VERDON EL VIRUS.jpg","Virus", 2, 100, 100));//VERDON EL VIRUS
                }
                if (i >= 29 && i < 33) {
                    lista.add(new Carta("viruss/recursos/VIRUBLU.jpg","Virus", 3, 100, 100));//VIRUBLU
                }
                if (i >= 33 && i < 37) {
                    lista.add(new Carta("viruss/recursos/YELLVIRUS.jpg","Virus", 4, 100, 100));//YELLVIRUS
                }
                if (i >= 37 && i < 38) {
                    lista.add(new Carta("viruss/recursos/COVID-19.jpg","Virus", 5, 100, 100));//COVID-19
                }
            }
            if(i>=38 && i<58)//medicinas
            {
                if (i < 42) {
                    lista.add(new Carta("viruss/recursos/BOTIQUIN.jpg","Medicinas", 1, 100, 100));//BOTIQUIN
                }
                if (i >= 42 && i < 46) {
                    lista.add(new Carta("viruss/recursos/VACUNA.jpg","Medicinas", 2, 100, 100));//VACUNA
                }
                if (i >= 46 && i < 50) {
                    lista.add(new Carta("viruss/recursos/ANTISUERO.jpg","Medicinas", 3, 100, 100));//ANTISUERO
                }
                if (i >= 50 && i < 54) {
                    lista.add(new Carta("viruss/recursos/CURITAS.jpg","Medicinas", 4, 100, 100));//CURITAS
                }
                if (i >= 54 && i < 58) {
                    lista.add(new Carta("viruss/recursos/HOSPITAL.jpg","Medicinas", 5, 100, 100));//HOSPITAL
                }
            }
            if(i>=58 && i<58)//tratamientos
            {
                if (i < 60) {
                    lista.add(new Carta("viruss/recursos/TRANSPLANTE.jpg","Tratamientos", 1, 100, 100));//Transplante
                }
                if (i >= 60 && i < 63) {
                    lista.add(new Carta("viruss/recursos/LADRON DE ORGANOS.jpg","Tratamientos", 2, 100, 100));//Ladrón de órganos
                }
                if (i >= 63 && i < 66) {
                    lista.add(new Carta("viruss/recursos/CONTAGIO.jpg","Tratamientos", 3, 100, 100));//Contagio
                }
                if (i >= 66 && i < 67) {
                    lista.add(new Carta("viruss/recursos/GUANTE DE LATEX.jpg","Tratamientos", 4, 100, 100));//Guante de látex
                }
                if (i >= 67 && i < 68) {
                    lista.add(new Carta("viruss/recursos/ERROR MEDICO.jpg","Tratamientos", 5, 100, 100));//Error médico
                }
            }
        }
    }
    
}
