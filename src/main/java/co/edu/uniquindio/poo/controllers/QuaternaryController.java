package co.edu.uniquindio.poo.controllers;

import java.io.IOException;

import co.edu.uniquindio.poo.App;
import co.edu.uniquindio.poo.models.Deporte;
import co.edu.uniquindio.poo.models.NivelDificultad;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class QuaternaryController {

    @FXML
    private TextField nameSportField;

    @FXML
    private TextField descriptionField;

    @FXML
    private ComboBox<NivelDificultad> dificultadComboBox;

    @FXML
    private void initialize() {
        dificultadComboBox.getItems().setAll(NivelDificultad.values());
    }

    @FXML
    private void handlecreate() {
        String name = nameSportField.getText();
        String description = descriptionField.getText();
        NivelDificultad dificultad = dificultadComboBox.getValue();

        Deporte deporte = new Deporte(name, description, dificultad);

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
