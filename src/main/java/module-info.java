module co.edu.uniquindio.poo {
    requires javafx.controls;
    requires javafx.fxml;
    requires transitive javafx.graphics;

    opens co.edu.uniquindio.poo.application to javafx.fxml;
    exports co.edu.uniquindio.poo.application;
    exports co.edu.uniquindio.poo.controller;
    exports co.edu.uniquindio.poo.model;
    opens co.edu.uniquindio.poo.controller to javafx.fxml;
}