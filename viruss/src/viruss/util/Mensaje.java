/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viruss.util;

import clinicauna.controller.PrincipalController;
import java.util.Optional;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.image.ImageView;
import javafx.stage.Window;

/**
 *
 * @author Kevin
 */
public class Mensaje {

    public static void show(Alert.AlertType tipo, String titulo, String mensaje) {

        Alert alert = new Alert(tipo);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        if (!PrincipalController.idioma) {
            alert.getButtonTypes().set(0, new ButtonType("OK", ButtonBar.ButtonData.OK_DONE));
        } else {
            System.out.println("skljf");
            alert.getButtonTypes().set(0, new ButtonType("Aceptar", ButtonBar.ButtonData.OK_DONE));
        }
        alert.show();
    }

    public static void showImage(Alert.AlertType tipo, String titulo, String mensaje) {
////        ImageView image = new ImageView("juegoPreguntados/resources/ciencia.png");
//        image.setFitHeight(100);
//        image.setFitWidth(100);
//        image.setPreserveRatio(true);
//        Alert alert = new Alert(tipo);
//        alert.setTitle(titulo);
//        alert.setHeaderText(null);
//        alert.setContentText(mensaje);
//        alert.setGraphic(image);
//        alert.show();
    }

    public static void showModal(Alert.AlertType tipo, String titulo, Window padre, String mensaje) {
        Alert alert = new Alert(tipo);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.initOwner(padre);
        alert.setContentText(mensaje);
        if (!PrincipalController.idioma) {
            alert.getButtonTypes().set(0, new ButtonType("OK", ButtonBar.ButtonData.OK_DONE));
        } else {
            alert.getButtonTypes().set(0, new ButtonType("Aceptar", ButtonBar.ButtonData.OK_DONE));
        }
        alert.showAndWait();
    }

    public static Boolean showConfirmation(String titulo, Window padre, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, mensaje, new ButtonType("OK", ButtonBar.ButtonData.YES), new ButtonType("Cancel", ButtonBar.ButtonData.NO));
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.initOwner(padre);
        alert.setContentText(mensaje);
        if (!PrincipalController.idioma) {
            alert.getButtonTypes().set(0, new ButtonType("OK", ButtonBar.ButtonData.YES));
            alert.getButtonTypes().set(1, new ButtonType("Cancel", ButtonBar.ButtonData.NO));
        } else {
            alert.getButtonTypes().set(0, new ButtonType("Aceptar", ButtonBar.ButtonData.YES));
            alert.getButtonTypes().set(1, new ButtonType("Cancelar", ButtonBar.ButtonData.NO));
        }

        Optional<ButtonType> result = alert.showAndWait();
        return result.get().getButtonData() == ButtonBar.ButtonData.YES;
    }
}
