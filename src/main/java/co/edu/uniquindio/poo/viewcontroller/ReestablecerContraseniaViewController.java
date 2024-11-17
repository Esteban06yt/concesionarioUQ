package co.edu.uniquindio.poo.viewcontroller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;

public class ReestablecerContraseniaViewController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="txtConfirmarContraseña"
    private PasswordField txtConfirmarContraseña; // Value injected by FXMLLoader

    @FXML // fx:id="btnActualizarContraseña"
    private Button btnActualizarContraseña; // Value injected by FXMLLoader

    @FXML // fx:id="txtNuevaContraseña"
    private PasswordField txtNuevaContraseña; // Value injected by FXMLLoader

    @FXML
    void actualizarContraseña(ActionEvent event) {
        PasswordField contraseñaNueva = txtNuevaContraseña;
        PasswordField confirmarContraseña = txtConfirmarContraseña;
        if (contraseñaNueva.equals(confirmarContraseña)){
            // Configurar el setContraseña del cliente
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/poo/ClienteLoginView.fxml"));
                Parent root = loader.load();
             Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.setTitle("Login de cliente");
                stage.show();

            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Error al cargar la vista: " + e.getMessage());
            }
        }
     }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert txtConfirmarContraseña != null : "fx:id=\"txtConfirmarContraseña\" was not injected: check your FXML file 'ReestablecerContraseñaView.fxml'.";
        assert btnActualizarContraseña != null : "fx:id=\"btnActualizarContraseña\" was not injected: check your FXML file 'ReestablecerContraseñaView.fxml'.";
        assert txtNuevaContraseña != null : "fx:id=\"txtNuevaContraseña\" was not injected: check your FXML file 'ReestablecerContraseñaView.fxml'.";
    }
}