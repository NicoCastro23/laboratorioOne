package co.edu.uniquindio.poo.controllers;

import java.io.IOException;

import co.edu.uniquindio.poo.App;
import co.edu.uniquindio.poo.models.Adulto;
import co.edu.uniquindio.poo.models.Deporte;
import co.edu.uniquindio.poo.models.Miembro;
import co.edu.uniquindio.poo.models.NivelDificultad;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class SeptenaryController {
    @FXML
    private TextField nameMemberField;

    @FXML
    private TextField emailField;

    @FXML
    private TextField idField;

    @FXML
    private TextField tipeMenber;

    @FXML
    private void handlecreateMember() {
        String name = nameMemberField.getText();
        String email = emailField.getText();
        String idMember = idField.getText();
        String tipeMember = tipeMenber.getText();

        Miembro miembro = new Adulto(name, email, idMember);

        // Aquí podrías añadir la lógica para crear el deporte en el modelo

        try {
            // Cambiar la vista a otra pantalla (si es necesario)
            App.setRoot("tertiary");
            ; // Esto supone que tienes otra vista llamada "secondary.fxml"
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
