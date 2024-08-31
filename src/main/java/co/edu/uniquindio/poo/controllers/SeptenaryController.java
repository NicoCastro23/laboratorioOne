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
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

public class SeptenaryController implements Initializable{
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
     * Maneja el evento de creación de un nuevo miembro. Dependiendo del tipo de miembro seleccionado,
     * se crea una instancia de `Adulto` o `Juvenil` y se agrega a la lista de miembros en la instancia de 
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

        if (tipeMember == TipoMiembro.ADULTO){
            Adulto adulto = new Adulto(name, email, idMember);

            App.gestionDeportes.addMiembros(adulto);

        }else{
            Juvenil juvenil = new Juvenil(name, email, idMember);
            App.gestionDeportes.addMiembros(juvenil);
        }

        

        // Aquí podrías añadir la lógica para crear el deporte en el modelo

        try {
            App.setRoot("tertiary");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

     /**
     * Inicializa la vista con los valores necesarios. En este caso, se agregan los tipos de miembro 
     * disponibles al ComboBox `miembro`.
     *
     * @param arg0 URL utilizado para resolver rutas relativas para el objeto raíz, o null si no se proporciona.
     * @param arg1 El ResourceBundle que se utilizará para localizar el objeto raíz, o null si no se proporciona.
     */
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        miembro.getItems().addAll(listaMiembro);
    }
}
