package co.edu.uniquindio.poo.controllers;

import java.io.IOException;

import co.edu.uniquindio.poo.App;
import co.edu.uniquindio.poo.models.Entrenador;

import javafx.fxml.FXML;

import javafx.scene.control.TextField;
import java.util.ArrayList;

public class QuinaryController {
    @FXML
    private TextField nameTrainerField;

    @FXML
    private TextField especialityField;

    @FXML
    private void handleAddTrainer() {
        String name = nameTrainerField.getText();
        String especiality = especialityField.getText();

        Entrenador entrenador = new Entrenador(name, especiality, new ArrayList<>());
        App.gestionDeportes.addEntrenador(entrenador);

        try {
            // Cambiar la vista a otra pantalla (si es necesario)
            App.setRoot("tertiary");
            ; // Esto supone que tienes otra vista llamada "secondary.fxml"
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleSalir() {
        try {
            // Cambiar la vista a otra pantalla (si es necesario)
            App.setRoot("tertiary");
            ; // Esto supone que tienes otra vista llamada "secondary.fxml"
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
