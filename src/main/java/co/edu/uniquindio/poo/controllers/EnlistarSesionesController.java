package co.edu.uniquindio.poo.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.GridPane;

import java.io.IOException;
import java.util.Optional;

import co.edu.uniquindio.poo.App;
import co.edu.uniquindio.poo.models.GestionDeportes;
import co.edu.uniquindio.poo.models.SesionEntrenamiento;
import co.edu.uniquindio.poo.models.TipoEstado;
import javafx.collections.FXCollections;

public class EnlistarSesionesController {

    @FXML
    private ListView<SesionEntrenamiento> listViewSesiones;

    private GestionDeportes gestionDeportes = App.gestionDeportes; // Deberías obtener esto desde tu clase principal

    @FXML
    private void initialize() {
        // Cargar los elementos en el ListView
        listViewSesiones.setItems(FXCollections.observableArrayList(gestionDeportes.getSesionEntrenamientos()));

        // Aplicar un EventHandler para manejar clics en los elementos de la lista
        listViewSesiones.setOnMouseClicked(event -> {
            if (event.getButton() == MouseButton.PRIMARY && event.getClickCount() == 2) {
                SesionEntrenamiento selectedSesion = listViewSesiones.getSelectionModel().getSelectedItem();
                if (selectedSesion != null) {
                    openEditDialog(selectedSesion);
                }
            }
        });
    }

    private void openEditDialog(SesionEntrenamiento sesion) {
        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.setTitle("Editar Sesión de Entrenamiento");
        dialog.setHeaderText("Modificar los detalles de la sesión de entrenamiento");

        // Crear etiquetas y campos de texto para cada atributo
        Label labelDeporte = new Label("Nombre del Deporte:");
        TextField deporteField = new TextField(sesion.getDeporte().getNombre());

        Label labelEntrenador = new Label("Nombre del Entrenador:");
        TextField entrenadorField = new TextField(sesion.getEntrenador().getNombre());

        // Agregar más campos si es necesario
        Label labelDuracion = new Label("Duración:");
        TextField duracionField = new TextField(String.valueOf(sesion.getDuracion()));

        Label labelEstado = new Label("Estado:");
        ComboBox<TipoEstado> estadoComboBox = new ComboBox<>();
        estadoComboBox.getItems().setAll(TipoEstado.values());
        estadoComboBox.setValue(sesion.getEstado());

        // Configurar el layout del diálogo usando un GridPane
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.add(labelDeporte, 0, 0);
        grid.add(deporteField, 1, 0);
        grid.add(labelEntrenador, 0, 1);
        grid.add(entrenadorField, 1, 1);
        grid.add(labelDuracion, 0, 2);
        grid.add(duracionField, 1, 2);
        grid.add(labelEstado, 0, 3);
        grid.add(estadoComboBox, 1, 3);

        dialog.getDialogPane().setContent(grid);
        dialog.getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);

        // Manejar el resultado del diálogo
        Optional<ButtonType> result = dialog.showAndWait();

        if (result.isPresent() && result.get() == ButtonType.OK) {
            // Actualizar los valores en la sesión de entrenamiento
            sesion.getDeporte().setNombre(deporteField.getText());
            sesion.getEntrenador().setNombre(entrenadorField.getText());
            sesion.setDuracion(Integer.parseInt(duracionField.getText()));
            sesion.setEstado(estadoComboBox.getValue());

            listViewSesiones.refresh(); // Refrescar la lista para mostrar los cambios
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
            App.setRoot("menu");
            ; // Esto supone que tienes otra vista llamada "secondary.fxml"
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleDeleteSession() {
        SesionEntrenamiento selectedSesion = listViewSesiones.getSelectionModel().getSelectedItem();

        if (selectedSesion != null) {
            // Confirmar la eliminación con el usuario
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmar eliminación");
            alert.setHeaderText("Eliminar sesión de entrenamiento");
            alert.setContentText("¿Estás seguro de que deseas eliminar esta sesión?");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.isPresent() && result.get() == ButtonType.OK) {
                // Eliminar la sesión de la lista
                App.gestionDeportes.getSesionEntrenamientos().remove(selectedSesion);
                listViewSesiones.getItems().remove(selectedSesion);
            }
        } else {
            // Mostrar un mensaje si no se ha seleccionado ninguna sesión
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Advertencia");
            alert.setHeaderText("No se ha seleccionado ninguna sesión");
            alert.setContentText("Por favor, selecciona una sesión de la lista antes de intentar eliminarla.");
            alert.showAndWait();
        }
    }
}
