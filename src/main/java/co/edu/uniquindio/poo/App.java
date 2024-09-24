package co.edu.uniquindio.poo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.logging.Level;

import co.edu.uniquindio.poo.models.GestionDeportes;
import co.edu.uniquindio.poo.util.AppLogger;

/**
 * Clase principal que extiende `Application` para iniciar la aplicación JavaFX.
 * Se encarga de cargar la interfaz gráfica y gestionar
 * la instancia de `GestionDeportes`.
 */
public class App extends Application {

    public static GestionDeportes gestionDeportes;
    private static Scene scene;
    private static Stage primaryStage;
    private static Locale currentLocale;

    @Override
    public void start(Stage stage) throws IOException {
        try {
            primaryStage = stage;

            // Establecer el Locale en español
            currentLocale = Locale.of("en", "US");

            // Cargar el ResourceBundle
            ResourceBundle bundle = ResourceBundle.getBundle("co.edu.uniquindio.poo.properties.Mi_Recurso",
                    currentLocale);

            // Inicializar gestionDeportes si es necesario
            gestionDeportes = new GestionDeportes();

            // Cargar el archivo FXML
            URL fxmlLocation = getClass().getResource("/co/edu/uniquindio/poo/view/inicio.fxml");
            System.out.println("FXML Location: " + fxmlLocation);

            if (fxmlLocation == null) {
                throw new RuntimeException(
                        "No se pudo encontrar el archivo FXML en /co/edu/uniquindio/poo/view/inicio.fxml");
            }

            // Cargar el FXML utilizando el ResourceBundle
            FXMLLoader loader = new FXMLLoader(fxmlLocation, bundle);

            // Cargar la escena desde el FXML
            Parent root = loader.load();
            scene = new Scene(root);

            // Añadir la hoja de estilos
            URL cssLocation = getClass().getResource("/co/edu/uniquindio/poo/view/styles.css");
            if (cssLocation != null) {
                scene.getStylesheets().add(cssLocation.toExternalForm());
            } else {
                System.out.println("Hoja de estilos no encontrada en /co/edu/uniquindio/poo/view/styles.css");
            }

            // Configurar y mostrar el stage
            stage.setScene(scene);
            stage.setTitle(bundle.getString("app.title"));
            AppLogger.getLogger().info("Aplicación iniciada correctamente.");
            stage.show();
        } catch (Exception e) {
            // Registrar el error en el log
            AppLogger.getLogger().log(Level.SEVERE, "Error al iniciar la aplicación.", e);
        }
    }

    /**
     * Cambia la raíz de la escena actual a la vista cargada desde un archivo FXML
     * especificado por el parámetro `fxml`.
     *
     * @param fxml El nombre del archivo FXML sin la extensión.
     * @throws IOException Si ocurre un error al cargar el archivo FXML.
     */
    public static void setRoot(String fxml) throws IOException {
        // Cargar el ResourceBundle con el Locale actual
        ResourceBundle bundle = ResourceBundle.getBundle("co.edu.uniquindio.poo.properties.Mi_Recurso", currentLocale);

        // Cargar el archivo FXML
        URL fxmlLocation = App.class.getResource("/co/edu/uniquindio/poo/view/" + fxml + ".fxml");
        System.out.println("Cambiando raíz a: " + fxmlLocation);

        if (fxmlLocation == null) {
            throw new RuntimeException("No se pudo encontrar el archivo FXML: " + fxml + ".fxml");
        }

        FXMLLoader fxmlLoader = new FXMLLoader(fxmlLocation, bundle);
        Parent root = fxmlLoader.load();
        scene.setRoot(root);
    }

    /**
     * Método principal que lanza la aplicación JavaFX.
     */
    public static void main(String[] args) {
        launch();
    }
}