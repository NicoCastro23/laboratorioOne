package co.edu.uniquindio.poo.controllers;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.logging.Level;

import co.edu.uniquindio.poo.App;
import co.edu.uniquindio.poo.util.AppLogger;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class MenuController {
    private ResourceBundle bundle;
    private Locale currentLocale;

    @FXML
    private Button addSportButton;
    @FXML
    private Button addTrainerButton;
    @FXML
    private Button addMemberButton;
    @FXML
    private Button addSessionButton;
    @FXML
    private Button manageSessionsButton;
    @FXML
    private Button exitButton;
    @FXML
    private Button changeLanguage;

    @FXML
    private void handleAddSport() {
        try {
            App.setRoot("sport");
            AppLogger.getLogger().info("Navegación a la vista 'sport' exitosa.");
        } catch (IOException e) {
            e.printStackTrace();
            AppLogger.getLogger().log(Level.SEVERE, "Error al cargar la vista 'sport'.", e);
        }
    }

    @FXML
    private void handleAddTrainer() {
        try {
            App.setRoot("trainer");
            AppLogger.getLogger().info("Navegación a la vista 'trainer' exitosa.");
        } catch (IOException e) {
            e.printStackTrace();
            AppLogger.getLogger().log(Level.SEVERE, "Error al cargar la vista 'trainer'.", e);
        }
    }

    @FXML
    private void handleAddMember() {
        try {
            App.setRoot("member");
            AppLogger.getLogger().info("Navegación a la vista 'Member' exitosa.");
        } catch (IOException e) {
            e.printStackTrace();
            AppLogger.getLogger().log(Level.SEVERE, "Error al cargar la vista 'Member'.", e);
        }
    }

    @FXML
    private void handleAddSession() {
        try {
            App.setRoot("sesion");
            AppLogger.getLogger().info("Navegación a la vista 'sesion' exitosa.");
        } catch (IOException e) {
            e.printStackTrace();
            AppLogger.getLogger().log(Level.SEVERE, "Error al cargar la vista 'sesion'.", e);
        }
    }

    @FXML
    private void handleManageSessions() {
        try {
            App.setRoot("enlistarsesionesview");
            AppLogger.getLogger().info("Navegación a la vista 'enlistarsesiones' exitosa.");
        } catch (IOException e) {
            e.printStackTrace();
            AppLogger.getLogger().log(Level.SEVERE, "Error al cargar la vista 'enlistarsesiones'.", e);
        }
    }

    @FXML
    private void handleSalir() {
        try {
            App.setRoot("inicio");
            AppLogger.getLogger().info("Navegación a la vista 'inicio' exitosa.");
        } catch (IOException e) {
            e.printStackTrace();
            AppLogger.getLogger().log(Level.SEVERE, "Error al cargar la vista 'inicio'.", e);
        }
    }

    @FXML
    private void initialize() {
        // Inicializar el Locale y el ResourceBundle
        currentLocale = Locale.of("es", "ES");// O establece el Locale inicial
        loadResourceBundle();
    }

    private void loadResourceBundle() {
        bundle = ResourceBundle.getBundle(
                "co.edu.uniquindio.poo.properties.Mi_Recurso",
                currentLocale);
        updateTexts();
    }

    private void updateTexts() {
        addSportButton.setText(bundle.getString("button.add_sport"));
        addTrainerButton.setText(bundle.getString("button.add_trainer"));
        addMemberButton.setText(bundle.getString("button.add_member"));
        addSessionButton.setText(bundle.getString("button.add_session"));
        manageSessionsButton.setText(bundle.getString("button.manage_sessions"));
        exitButton.setText(bundle.getString("button.exit"));
        changeLanguage.setText(bundle.getString("button.switch_language"));
    }

    @FXML
    private void switchLanguage() {
        if (currentLocale.getLanguage().equals("es")) {
            currentLocale = Locale.of("en", "US");
        } else {
            currentLocale = Locale.of("es", "ES");
        }
        loadResourceBundle();
    }
}
