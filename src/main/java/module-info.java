module co.edu.uniquindio.poo {
    requires javafx.controls;
    requires javafx.fxml;
    requires transitive javafx.graphics;
    requires java.logging;
    requires javafx.base;

    opens co.edu.uniquindio.poo.application to javafx.fxml;
    exports co.edu.uniquindio.poo.application;
    exports co.edu.uniquindio.poo.viewcontroller;
    exports co.edu.uniquindio.poo.model;
    opens co.edu.uniquindio.poo.viewcontroller to javafx.fxml;
}