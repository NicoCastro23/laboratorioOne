package co.edu.uniquindio.poo.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.poo.App;
import co.edu.uniquindio.poo.models.Adulto;
import co.edu.uniquindio.poo.models.Juvenil;
import co.edu.uniquindio.poo.models.TipoMiembro;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

public class MemberController implements Initializable {

    @FXML
    ChoiceBox<TipoMiembro> miembro;
    private TipoMiembro[] listaMiembro = {
            TipoMiembro.ADULTO, TipoMiembro.JUVENIL
    };

    @FXML
    private TextField nameMemberField;

    @FXML
    private TextField emailField;

    @FXML
    private TextField idField;

    /**
     * Maneja el evento de creación de un nuevo miembro. Dependiendo del tipo de
     * miembro seleccionado,
     * se crea una instancia de `Adulto` o `Juvenil` y se agrega a la lista de
     * miembros en la instancia de
     * `GestionDeportes`.
     *
     * @throws IOException Si ocurre un error al cambiar la vista.
     */
    @FXML
    private void handlecreateMember() {
        String name = nameMemberField.getText();
        String email = emailField.getText();
        String idMember = idField.getText();
        TipoMiembro tipeMember = miembro.getValue();

        if (tipeMember == TipoMiembro.ADULTO) {
            Adulto adulto = new Adulto(name, email, idMember);

            App.gestionDeportes.addMiembros(adulto);

        } else {
            Juvenil juvenil = new Juvenil(name, email, idMember);
            App.gestionDeportes.addMiembros(juvenil);
        }
        if (name.isEmpty() || email.isEmpty() || idMember.isEmpty()) {
            showAlert("Campos vacíos", "Por favor, complete ambos campos.");
            return;
        }

        System.out.println(
                "Sesion creada: Nombre = " + name + ", Email = " + email + ", Id = " + idMember
                        + ", Tipo de miembro = " + tipeMember);

        // Mostrar un mensaje de éxito al usuario
        showAlert("Éxito", "Miembro creada exitosamente.");
        try {
            App.setRoot("menu");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Inicializa la vista con los valores necesarios. En este caso, se agregan los
     * tipos de miembro
     * disponibles al ComboBox `miembro`.
     *
     * @param arg0 URL utilizado para resolver rutas relativas para el objeto raíz,
     *             o null si no se proporciona.
     * @param arg1 El ResourceBundle que se utilizará para localizar el objeto raíz,
     *             o null si no se proporciona.
     */
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        miembro.getItems().addAll(listaMiembro);
    }

    /**
     * Maneja el evento de salir o volver a la vista anterior. Cambia la vista a
     * "tertiary.fxml".
     *
     * @throws IOException Si ocurre un error al cambiar la vista.
     */
    @FXML
    private void handleSalir() {
        try {
            App.setRoot("menu");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
