/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viruss.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
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
    private HBox hboxMesaJug3;
    @FXML
    private HBox hboxMesaJug4;
    @FXML
    private HBox hboxMesaJug5;
    @FXML
    private HBox hboxMesaJug6;
    @FXML
    private HBox hboxmaso;
    private List <Carta> lista = new ArrayList();   
    Carta p = new Carta();
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        crearCartas();
        Image i = new Image("viruss/recursos/MASO.jpg");
        ImageView p = new ImageView(i);
        p.setFitWidth(70);
        p.setFitHeight(100);
        
        
        
        p.setOnMouseClicked(ke->{
            
            hboxMasoJug.getChildren().add(lista.get(lista.size() - 1));
            lista.remove(lista.get(lista.size() - 1));
        });
        hboxmaso.getChildren().add(p);
        
            int cont=0;
            while(cont !=18)
            {
                Random r = new Random();
                int random= r.nextInt(68)+1;
                if (cont < 19) {
                    if (cont < 3) {
                        hboxMesaJug1.getChildren().add(lista.get(lista.size() - 1));
                        lista.remove(lista.get(lista.size() - 1));

                    }
                    if (cont >= 3 && cont < 6) {
                        hboxMesaJug2.getChildren().add(lista.get(lista.size() - 1));
                        lista.remove(lista.get(lista.size() - 1));
                    }
                    if (cont >= 6 && cont < 9) {
                        hboxMesaJug3.getChildren().add(lista.get(lista.size() - 1));
                        lista.remove(lista.get(lista.size() - 1));
                    }
                    if (cont >= 9 && cont < 12) {
                        hboxMesaJug4.getChildren().add(lista.get(lista.size() - 1));
                        lista.remove(lista.get(lista.size() - 1));
                    }
                    if (cont >= 12 && cont < 15) {
                        p= lista.get(lista.size()-1);
                        p.setRotate(180);
                        hboxMesaJug5.getChildren().add(p);
                        lista.remove(lista.get(lista.size() - 1));
                    }
                    if(cont>=15 && cont<18)
                    {
                        p= lista.get(lista.size()-1);
                        p.setRotate(180);
                        hboxMesaJug6.getChildren().add(p);
                        lista.remove(lista.get(lista.size()-1));
                    }
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
                    lista.add(new Carta("viruss/recursos/CORAZON.jpg","Organos", 1, 100, 70));//corazon
                }
                if (i >= 5 && i < 10) {
                    lista.add(new Carta("viruss/recursos/ESTOMAGO.jpg","Organos", 2, 100, 70));//estomago
                }
                if (i >= 10 && i < 15) {
                    lista.add(new Carta("viruss/recursos/CEREBRO.jpg","Organos", 3, 100, 70));//cerebor
                }
                if (i >= 15 && i < 20) {
                    lista.add(new Carta("viruss/recursos/HUESO.jpg","Organos", 4, 100, 70));//hueso
                }
                if (i >= 20 && i < 21) {
                    lista.add(new Carta("viruss/recursos/CUERPO.jpg","Organos", 5, 100, 70));//comodin
                }
            }
            if(i>=21 && i<38)//virus
            {
                if (i < 25) {
                    lista.add(new Carta("viruss/recursos/ROJIVURUS.jpg","Virus", 1, 100, 70));//ROJIVIRUS
                }
                if (i >= 25 && i < 29) {
                    lista.add(new Carta("viruss/recursos/VERDON EL VIRUS.jpg","Virus", 2, 100, 70));//VERDON EL VIRUS
                }
                if (i >= 29 && i < 33) {
                    lista.add(new Carta("viruss/recursos/VIRUBLU.jpg","Virus", 3, 100, 70));//VIRUBLU
                }
                if (i >= 33 && i < 37) {
                    lista.add(new Carta("viruss/recursos/YELLVIRUS.jpg","Virus", 4, 100, 70));//YELLVIRUS
                }
                if (i >= 37 && i < 38) {
                    lista.add(new Carta("viruss/recursos/COVID-19.jpg","Virus", 5, 100, 70));//COVID-19
                }
            }
            if(i>=38 && i<58)//medicinas
            {
                if (i < 42) {
                    lista.add(new Carta("viruss/recursos/BOTIQUIN.jpg","Medicinas", 1, 100, 70));//BOTIQUIN
                }
                if (i >= 42 && i < 46) {
                    lista.add(new Carta("viruss/recursos/VACUNA.jpg","Medicinas", 2, 100, 70));//VACUNA
                }
                if (i >= 46 && i < 50) {
                    lista.add(new Carta("viruss/recursos/ANTISUERO.jpg","Medicinas", 3, 100, 70));//ANTISUERO
                }
                if (i >= 50 && i < 54) {
                    lista.add(new Carta("viruss/recursos/CURITAS.jpg","Medicinas", 4, 100, 70));//CURITAS
                }
                if (i >= 54 && i < 58) {
                    lista.add(new Carta("viruss/recursos/HOSPITAL.jpg","Medicinas", 5, 100, 70));//HOSPITAL
                }
            }
            if(i>=58 && i<58)//tratamientos
            {
                if (i < 60) {
                    lista.add(new Carta("viruss/recursos/TRANSPLANTE.jpg","Tratamientos", 1, 100, 70));//Transplante
                }
                if (i >= 60 && i < 63) {
                    lista.add(new Carta("viruss/recursos/LADRON DE ORGANOS.jpg","Tratamientos", 2, 100, 70));//Ladrón de órganos
                }
                if (i >= 63 && i < 66) {
                    lista.add(new Carta("viruss/recursos/CONTAGIO.jpg","Tratamientos", 3, 100, 70));//Contagio
                }
                if (i >= 66 && i < 67) {
                    lista.add(new Carta("viruss/recursos/GUANTE DE LATEX.jpg","Tratamientos", 4, 100, 70));//Guante de látex
                }
                if (i >= 67 && i < 68) {
                    lista.add(new Carta("viruss/recursos/ERROR MEDICO.jpg","Tratamientos", 5, 100, 70));//Error médico
                }
            }
        }
    }
    
}
