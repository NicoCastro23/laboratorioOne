package co.edu.uniquindio.poo.controllers;

import java.io.IOException;

import co.edu.uniquindio.poo.App;
import javafx.fxml.FXML;

public class MenuController {

    /**
     * Maneja el evento de agregar un deporte. Cambia la vista a la pantalla
     * "sport.fxml".
     * 
     * @throws IOException Si ocurre un error al cargar la nueva vista.
     */
    @FXML
    private void handleAddSport() {
        try {
            App.setRoot("views/sport");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Maneja el evento de agregar un entrenador. Cambia la vista a la pantalla
     * "trainer.fxml".
     * 
     * @throws IOException Si ocurre un error al cargar la nueva vista.
     */
    @FXML
    private void handleAddTrainer() {
        try {
            App.setRoot("views/trainer");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Maneja el evento de agregar un miembro. Cambia la vista a la pantalla
     * "septenary.fxml".
     * 
     * @throws IOException Si ocurre un error al cargar la nueva vista.
     */
    @FXML
    private void handleAddMember() {
        try {
            App.setRoot("views/member");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Maneja el evento de agregar una sesión. Cambia la vista a la pantalla
     * "octonary.fxml".
     * 
     * @throws IOException Si ocurre un error al cargar la nueva vista.
     */
    @FXML
    private void handleAddSession() {
        try {
            App.setRoot("views/sesion");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Maneja el evento de gestionar sesiones. Cambia la vista a la pantalla
     * "enlistarsesionesview.fxml".
     * 
     * @throws IOException Si ocurre un error al cargar la nueva vista.
     */
    @FXML
    private void handleManageSessions() {
        try {
            App.setRoot("views/enlistarsesionesview");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Maneja el evento de salir o volver a la vista anterior. Cambia la vista a
     * "inicio.fxml".
     *
     * @throws IOException Si ocurre un error al cambiar la vista.
     */
    @FXML
    private void handleSalir() {
        try {
            App.setRoot("views/inicio");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
