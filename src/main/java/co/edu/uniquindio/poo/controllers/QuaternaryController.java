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

    /**
     * Maneja el evento de creación de un nuevo deporte. Recoge los datos del nombre, descripción,
     * y nivel de dificultad del deporte desde los campos de texto y el ComboBox, crea una instancia
     * de `Deporte`, y la añade a la lista de deportes.
     *
     * Después de agregar el deporte, cambia la vista a "tertiary.fxml".
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

        try {
            // Cambiar la vista a otra pantalla (si es necesario)
            App.setRoot("tertiary");
            ; // Esto supone que tienes otra vista llamada "secondary.fxml"
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
