package co.edu.uniquindio.poo.controllers;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import co.edu.uniquindio.poo.App;
import co.edu.uniquindio.poo.util.AppLogger;
import java.util.logging.Level;

public class InicioController {

    @FXML
    private Button startButton;

    /**
     * Maneja el evento de clic en el botón de inicio. Al hacer clic, imprime un
     * mensaje
     * en la consola indicando que la aplicación ha comenzado correctamente, y luego
     * cambia la vista a "loginadmin.fxml".
     *
     * @throws IOException Si ocurre un error al cambiar la vista.
     */
    @FXML
    private void handleStartButton() {
        System.out.println("Inicio aplicacion exitoso");
        try {
            App.setRoot("loginadmin");
            AppLogger.getLogger().info("Navegación a la vista 'incio' exitosa.");
        } catch (IOException e) {
            AppLogger.getLogger().log(Level.SEVERE, "Error al cargar la vista 'inicio'.", e);
            e.printStackTrace();
        }
    }
}
