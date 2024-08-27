package co.edu.uniquindio.poo.controllers;

import java.io.IOException;

import co.edu.uniquindio.poo.App;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class TertiaryController {

    @FXML
    private void handleAddSport() {
        try {
            // Cambiar la vista a otra pantalla (si es necesario)
            App.setRoot("quaternary");
            ; // Esto supone que tienes otra vista llamada "secondary.fxml"
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleAddTrainer() {
        try {
            // Cambiar la vista a otra pantalla (si es necesario)
            App.setRoot("Quinary");
            ; // Esto supone que tienes otra vista llamada "secondary.fxml"
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleAddMember() {
        try {
            // Cambiar la vista a otra pantalla (si es necesario)
            App.setRoot("septenary");
            ; // Esto supone que tienes otra vista llamada "secondary.fxml"
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleAddSession() {
        try {
            // Cambiar la vista a otra pantalla (si es necesario)
            App.setRoot("octonary");
            ; // Esto supone que tienes otra vista llamada "secondary.fxml"
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleManageSessions() {
        try {
            // Cambiar la vista a otra pantalla (si es necesario)
            App.setRoot("nonary");
            ; // Esto supone que tienes otra vista llamada "secondary.fxml"
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
