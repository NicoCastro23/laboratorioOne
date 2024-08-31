package co.edu.uniquindio.poo.controllers;

import java.io.IOException;

import co.edu.uniquindio.poo.App;
import javafx.fxml.FXML;

public class TertiaryController {

     /**
     * Maneja el evento de agregar un deporte. Cambia la vista a la pantalla "quaternary.fxml".
     * 
     * @throws IOException Si ocurre un error al cargar la nueva vista.
     */
    @FXML
    private void handleAddSport() {
        try {
            App.setRoot("quaternary"); 
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * Maneja el evento de agregar un entrenador. Cambia la vista a la pantalla "Quinary.fxml".
     * 
     * @throws IOException Si ocurre un error al cargar la nueva vista.
     */
    @FXML
    private void handleAddTrainer() {
        try {
            App.setRoot("Quinary");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * Maneja el evento de agregar un miembro. Cambia la vista a la pantalla "septenary.fxml".
     * 
     * @throws IOException Si ocurre un error al cargar la nueva vista.
     */
    @FXML
    private void handleAddMember() {
        try {
            App.setRoot("septenary");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * Maneja el evento de agregar una sesión. Cambia la vista a la pantalla "octonary.fxml".
     * 
     * @throws IOException Si ocurre un error al cargar la nueva vista.
     */
    @FXML
    private void handleAddSession() {
        try {
            App.setRoot("octonary");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Maneja el evento de gestionar sesiones. Cambia la vista a la pantalla "nonary.fxml".
     * 
     * @throws IOException Si ocurre un error al cargar la nueva vista.
     */
    @FXML
    private void handleManageSessions() {
        try {
            App.setRoot("nonary");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
