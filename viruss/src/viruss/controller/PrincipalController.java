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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;
import jdk.nashorn.internal.runtime.ListAdapter;
import viruss.model.Carta;
import viruss.util.FlowController;

/**
 * FXML Controller class
 *
 * @author colo7
 */
public class PrincipalController extends Controller implements Initializable {

    @FXML
    private BorderPane borPane;
    List <Carta>lista = new ArrayList();
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        crearCartas();
        
        
    }    

    public void crearCartas()
    {
        for (int i = 0; i < 68; i++) {//organos
            if (i < 21) {
                if (i < 5) {
                    lista.add(new Carta("Organos", 1, 50, 50));//corazon
                }
                if (i >= 5 && i < 10) {
                    lista.add(new Carta("Organos", 2, 50, 50));//estomago
                }
                if (i >= 10 && i < 15) {
                    lista.add(new Carta("Organos", 3, 50, 50));//cerebor
                }
                if (i >= 15 && i < 20) {
                    lista.add(new Carta("Organos", 4, 50, 50));//hueso
                }
                if (i >= 20 && i < 21) {
                    lista.add(new Carta("Organos", 5, 50, 50));//comodin
                }
            }
            if(i>=21 && i<38)//virus
            {
                if (i < 25) {
                    lista.add(new Carta("Virus", 1, 50, 50));//ROJIVIRUS
                }
                if (i >= 25 && i < 29) {
                    lista.add(new Carta("Virus", 2, 50, 50));//VERDON EL VIRUS
                }
                if (i >= 29 && i < 33) {
                    lista.add(new Carta("Virus", 3, 50, 50));//VIRUBLU
                }
                if (i >= 33 && i < 37) {
                    lista.add(new Carta("Virus", 4, 50, 50));//YELLVIRUS
                }
                if (i >= 37 && i < 38) {
                    lista.add(new Carta("Virus", 5, 50, 50));//COVID-19
                }
            }
            if(i>=38 && i<58)//medicinas
            {
                if (i < 42) {
                    lista.add(new Carta("Medicinas", 1, 50, 50));
                }
                if (i >= 42 && i < 46) {
                    lista.add(new Carta("Medicinas", 2, 50, 50));
                }
                if (i >= 46 && i < 50) {
                    lista.add(new Carta("Medicinas", 3, 50, 50));
                }
                if (i >= 50 && i < 54) {
                    lista.add(new Carta("Medicinas", 4, 50, 50));
                }
                if (i >= 54 && i < 58) {
                    lista.add(new Carta("Medicinas", 5, 50, 50));
                }
            }
            if(i>=58 && i<58)//tratamientos
            {
                if (i < 60) {
                    lista.add(new Carta("Tratamientos", 1, 50, 50));//Transplante
                }
                if (i >= 60 && i < 63) {
                    lista.add(new Carta("Tratamientos", 2, 50, 50));//Ladrón de órganos
                }
                if (i >= 63 && i < 66) {
                    lista.add(new Carta("Tratamientos", 3, 50, 50));//Contagio
                }
                if (i >= 66 && i < 67) {
                    lista.add(new Carta("Tratamientos", 4, 50, 50));//Guante de látex
                }
                if (i >= 67 && i < 68) {
                    lista.add(new Carta("Tratamientos", 5, 50, 50));//Error médico
                }
            }
        }
    }
    @Override
    public void initialize() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @FXML
    private void actionSiguiente(ActionEvent event) {
        
    }
    
}
