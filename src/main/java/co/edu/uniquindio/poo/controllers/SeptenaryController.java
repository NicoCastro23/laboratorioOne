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
            // Cambiar la vista a otra pantalla (si es necesario)
            App.setRoot("tertiary");
            ; // Esto supone que tienes otra vista llamada "secondary.fxml"
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        miembro.getItems().addAll(listaMiembro);
    }
}
