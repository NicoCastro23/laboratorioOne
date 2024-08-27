package co.edu.uniquindio.poo.controllers;

import java.io.IOException;
import java.time.LocalDate;

import co.edu.uniquindio.poo.App;
import co.edu.uniquindio.poo.models.TipoEstado;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class OctonaryController {

    @FXML
    private DatePicker dateField;

    @FXML
    private TextField durationField;

    @FXML
    private TextField nameSportField;

    @FXML
    private TextField entrenadorField;

    @FXML
    private ComboBox<TipoEstado> estadoComboBox;

    @FXML
    private void initialize() {
        // Inicializar ComboBox con los valores de TipoDificultad
        estadoComboBox.getItems().setAll(TipoEstado.values());
    }

    @FXML
    private void handleCreateSession() {
        LocalDate fechaEntrenamiento = dateField.getValue();
        String nombre = nameSportField.getText();
        int duracion = Integer.parseInt(durationField.getText());
        String entrenador = entrenadorField.getText();
        TipoEstado dificultad = estadoComboBox.getValue();

        try {
            // Cambiar la vista a otra pantalla (si es necesario)
            App.setRoot("terciary");
            ; // Esto supone que tienes otra vista llamada "secondary.fxml"
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
