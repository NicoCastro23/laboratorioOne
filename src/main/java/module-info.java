module co.edu.uniquindio.poo {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.logging;
    requires lombok;
    requires xstream;

    opens co.edu.uniquindio.poo to javafx.fxml;
    opens co.edu.uniquindio.poo.controllers to javafx.fxml;
    opens co.edu.uniquindio.poo.models to xstream;

    exports co.edu.uniquindio.poo.controllers;
    exports co.edu.uniquindio.poo;
    exports co.edu.uniquindio.poo.models;
}
