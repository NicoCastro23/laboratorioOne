module co.edu.uniquindio.poo {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.logging;
    requires lombok;

    opens co.edu.uniquindio.poo to javafx.fxml;
    opens co.edu.uniquindio.poo.controllers to javafx.fxml;

    exports co.edu.uniquindio.poo.controllers;
    exports co.edu.uniquindio.poo;
    exports co.edu.uniquindio.poo.models;
}
