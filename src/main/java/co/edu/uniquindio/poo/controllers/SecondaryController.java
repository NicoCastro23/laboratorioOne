package co.edu.uniquindio.poo.controllers;

import java.io.IOException;

import co.edu.uniquindio.poo.App;
import co.edu.uniquindio.poo.models.Administrador;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class SecondaryController {

    @FXML
    private TextField nameField;

    @FXML
    private TextField idField;

    @FXML
    private void handleCreateAdmin() {
        String name = nameField.getText();
        String id = idField.getText();

        if (name.isEmpty() || id.isEmpty()) {
            showAlert("Campos vacíos", "Por favor, complete ambos campos.");
            return;
        }
        Administrador administrador = new Administrador(name, id);
        App.gestionDeportes.setAdministrador(administrador);

        // Aquí puedes crear el administrador con el nombre y el ID
        System.out.println("Administrador creado: Nombre = " + name + ", ID = " + id);

        // Mostrar un mensaje de éxito al usuario
        showAlert("Éxito", "Administrador creado exitosamente.");

        try {
            // Cambiar la vista a otra pantalla (si es necesario)
            App.setRoot("tertiary");
            ; // Esto supone que tienes otra vista llamada "secondary.fxml"
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}