package co.edu.uniquindio.poo.controllers;

import java.io.IOException;

import co.edu.uniquindio.poo.App;
import co.edu.uniquindio.poo.models.Deporte;
import co.edu.uniquindio.poo.models.NivelDificultad;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class SportController {

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

    /**
     * Maneja el evento de creación de un nuevo deporte. Recoge los datos del
     * nombre, descripción,
     * y nivel de dificultad del deporte desde los campos de texto y el ComboBox,
     * crea una instancia
     * de `Deporte`, y la añade a la lista de deportes.
     *
     * Después de agregar el deporte, cambia la vista a "menu.fxml".
     *
     * @throws IOException Si ocurre un error al cambiar la vista.
     */
    @FXML
    private void handleCreate() {

        String name = nameSportField.getText();
        String description = descriptionField.getText();
        NivelDificultad dificultad = dificultadComboBox.getValue();

        Deporte deporte = new Deporte(name, description, dificultad);
        App.gestionDeportes.addDeporte(deporte);

        if (name.isEmpty() || description.isEmpty()) {
            showAlert("Campos vacíos", "Por favor, complete ambos campos.");
            return;
        }

        // Aquí puedes crear el administrador con el nombre y el ID
        System.out.println(
                "Deporte creado: Nombre = " + name + ", Descripcion = " + description + ", Dificultad = " + dificultad);

        // Mostrar un mensaje de éxito al usuario
        showAlert("Éxito", "Deporte creado exitosamente.");
        try {
            // Cambiar la vista a otra pantalla (si es necesario)
            App.setRoot("views/menu");
            ; // Esto supone que tienes otra vista llamada "secondary.fxml"
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
