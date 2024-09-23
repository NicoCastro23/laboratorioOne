package co.edu.uniquindio.poo.controllers;

import java.io.IOException;
import java.time.LocalDate;

import co.edu.uniquindio.poo.App;
import co.edu.uniquindio.poo.models.SesionEntrenamiento;
import co.edu.uniquindio.poo.models.TipoEstado;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class SesionController {

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

    /**
     * Maneja el evento de creación de una nueva sesión de entrenamiento. Recoge los
     * datos
     * del nombre del deporte, duración, entrenador, y estado de la sesión desde los
     * campos de texto
     * y los controles de la vista, luego los valida y busca el deporte y entrenador
     * en la gestión de deportes.
     *
     * Después de crear la sesión, cambia la vista a "tertiary.fxml".
     *
     * @throws IOException Si ocurre un error al cambiar la vista.
     */
    @FXML
    private void handleCreateSession() {
        LocalDate fechaEntrenamiento = dateField.getValue();
        String nombre = nameSportField.getText();
        int duracion = Integer.parseInt(durationField.getText());
        String entrenador = entrenadorField.getText();
        TipoEstado estado = estadoComboBox.getValue();

        SesionEntrenamiento sesionEntrenamiento = new SesionEntrenamiento(fechaEntrenamiento, duracion, estado,
                App.gestionDeportes.buscarDeporteporNombre(nombre),
                App.gestionDeportes.buscarEntrenadorporNombre(entrenador));

        App.gestionDeportes.agregarSesion(sesionEntrenamiento);

        if (nombre.isEmpty() || duracion < 0 || entrenador.isEmpty()) {
            showAlert("Campos vacíos", "Por favor, complete ambos campos.");
            return;
        }

        System.out.println(
                "Sesion creada: Nombre = " + nombre + ", Duracion = " + duracion + ", Entrenador = " + entrenador
                        + ", Estado = " + estado + ", Fecha del entrenamiento = " + fechaEntrenamiento);

        // Mostrar un mensaje de éxito al usuario
        showAlert("Éxito", "Sesion creada exitosamente.");

        try {
            // Cambiar la vista a otra pantalla (si es necesario)
            App.setRoot("views/menu");
            ; // Esto supone que tienes otra vista llamada "menu.fxml"
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
            // Cambiar la vista a otra pantalla (si es necesario)
            App.setRoot("views/menu");
            ; // Esto supone que tienes otra vista llamada "secondary.fxml"
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
