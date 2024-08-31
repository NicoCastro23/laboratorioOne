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

    /**
     * Maneja el evento de agregar un nuevo entrenador. Recoge los datos del nombre y especialidad
     * del entrenador desde los campos de texto, crea una instancia de `Entrenador`, y la añade
     * a la lista de entrenadores.
     *
     * Después de agregar el entrenador, cambia la vista a "tertiary.fxml".
     *
     * @throws IOException Si ocurre un error al cambiar la vista.
     */
    @FXML
    private void handleAddTrainer() {
        String name = nameTrainerField.getText();
        String especiality = especialityField.getText();

        Entrenador entrenador = new Entrenador(name, especiality, new ArrayList<>());
        App.gestionDeportes.addEntrenador(entrenador);

        try {
            App.setRoot("tertiary");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Maneja el evento de salir o volver a la vista anterior. Cambia la vista a "tertiary.fxml".
     *
     * @throws IOException Si ocurre un error al cambiar la vista.
     */
    @FXML
    private void handleSalir() {
        try {
            App.setRoot("tertiary");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
