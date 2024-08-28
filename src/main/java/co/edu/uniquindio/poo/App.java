package co.edu.uniquindio.poo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

import co.edu.uniquindio.poo.models.GestionDeportes;

public class App extends Application {

    public static GestionDeportes gestionDeportes;
    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        gestionDeportes = new GestionDeportes();
        scene = new Scene(loadFXML("primary"), 640, 480); // Carga la vista `primary.fxml`
        scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm()); // Añadir CSS
        stage.setScene(scene);
        stage.setTitle("Inicio");
        stage.show();
    }

    public static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

    public static Object gestionDeportes() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'gestionDeportes'");
    }
}