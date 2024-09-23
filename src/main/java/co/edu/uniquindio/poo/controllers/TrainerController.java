package co.edu.uniquindio.poo.controllers;

import java.io.IOException;

import co.edu.uniquindio.poo.App;
import co.edu.uniquindio.poo.models.Entrenador;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import java.util.ArrayList;

public class TrainerController {
    @FXML
    private TextField nameTrainerField;

    @FXML
    private TextField especialityField;

    /**
     * Maneja el evento de agregar un nuevo entrenador. Recoge los datos del nombre
     * y especialidad
     * del entrenador desde los campos de texto, crea una instancia de `Entrenador`,
     * y la añade
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

        if (name.isEmpty() || especiality.isEmpty()) {
            showAlert("Campos vacíos", "Por favor, complete ambos campos.");
            return;
        }

        Entrenador entrenador = new Entrenador(name, especiality, new ArrayList<>());
        App.gestionDeportes.addEntrenador(entrenador);

        // Aquí puedes crear el administrador con el nombre y el ID
        System.out.println(
                "Deporte creado: Nombre = " + name + ", Descripcion = " + especiality);

        // Mostrar un mensaje de éxito al usuario
        showAlert("Éxito", "Entrenador creado exitosamente.");

        try {
            App.setRoot("views/menu");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Maneja el evento de salir o volver a la vista anterior. Cambia la vista a
     * "menu.fxml".
     *
     * @throws IOException Si ocurre un error al cambiar la vista.
     */
    @FXML
    private void handleSalir() {
        try {
            App.setRoot("views/menu");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Muestra una alerta informativa al usuario con el título y mensaje
     * especificados.
     *
     * @param title   El título de la alerta.
     * @param message El mensaje de la alerta.
     */
    private void showAlert(String title, String message) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

}
