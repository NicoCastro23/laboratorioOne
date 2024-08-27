package co.edu.uniquindio.poo.controllers;

import java.io.IOException;

import co.edu.uniquindio.poo.App;
import co.edu.uniquindio.poo.models.NivelDificultad;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class QuinaryController {
    @FXML
    private TextField nameTrainerField;

    @FXML
    private TextField especialityField;

    @FXML
    private void handleAddTrainer() {
        String name = nameTrainerField.getText();
        String especiality = especialityField.getText();

        // Deporte deporte = new Deporte(name, description, dificultad);

        // Aquí podrías añadir la lógica para crear el deporte en el modelo

        try {
            // Cambiar la vista a otra pantalla (si es necesario)
            App.setRoot("terciary");
            ; // Esto supone que tienes otra vista llamada "secondary.fxml"
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
