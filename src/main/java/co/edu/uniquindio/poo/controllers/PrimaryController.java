package co.edu.uniquindio.poo.controllers;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import co.edu.uniquindio.poo.App;

public class PrimaryController {

    @FXML
    private Button startButton;

    @FXML
    private void handleStartButton() {
        // Aquí puedes definir la acción que tomará el botón
        System.out.println("Inicio aplicaion exitoso");

        try {
            // Cambiar la vista a otra pantalla (si es necesario)
            App.setRoot("secondary"); // Esto supone que tienes otra vista llamada "secondary.fxml"
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
