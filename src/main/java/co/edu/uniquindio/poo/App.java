package co.edu.uniquindio.poo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

import co.edu.uniquindio.poo.models.GestionDeportes;

/**
 * Clase principal que extiende `Application` para iniciar la aplicación JavaFX.
 * Se encarga de cargar la interfaz gráfica y gestionar
 * la instancia de `GestionDeportes`.
 */
public class App extends Application {

    public static GestionDeportes gestionDeportes;
    private static Scene scene;

    /**
     * Método principal que se ejecuta al iniciar la aplicación.
     * Configura la instancia de `GestionDeportes`
     * 
     * @param stage La ventana principal de la aplicación.
     * @throws IOException Si ocurre un error al cargar el archivo FXML.
     */
    @Override
    public void start(Stage stage) throws IOException {
        gestionDeportes = new GestionDeportes();
        scene = new Scene(loadFXML("inicio"), 640, 480); // Carga la vista `primary.fxml`
        scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm()); // Añadir CSS
        stage.setScene(scene);
        stage.setTitle("Inicio");
        stage.show();
    }

    /**
     * Cambia la raíz de la escena actual a la vista cargada desde un archivo FXML
     * especificado por el parámetro `fxml`.
     *
     * @param fxml El nombre del archivo FXML sin la extensión.
     * @throws IOException Si ocurre un error al cargar el archivo FXML.
     */
    public static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    /**
     * Carga y devuelve un `Parent` desde un archivo FXML.
     * Este método es utilizado para cargar diferentes vistas dentro de la
     * aplicación.
     *
     * @param fxml El nombre del archivo FXML sin la extensión.
     * @return El nodo raíz cargado desde el archivo FXML.
     * @throws IOException Si ocurre un error al cargar el archivo FXML.
     */
    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    /**
     * Método principal que lanza la aplicación JavaFX.
     */
    public static void main(String[] args) {
        launch();
    }

    public static Object gestionDeportes() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'gestionDeportes'");
    }
}