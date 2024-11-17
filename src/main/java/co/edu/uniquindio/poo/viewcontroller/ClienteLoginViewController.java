package co.edu.uniquindio.poo.viewcontroller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ClienteLoginViewController{

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="txtCorreoCliente"
    private TextField txtCorreoCliente; // Value injected by FXMLLoader

    @FXML // fx:id="hyperLinkRecuperarContraseña"
    private Hyperlink hyperLinkRecuperarContraseña; // Value injected by FXMLLoader

    @FXML // fx:id="txtContraseñaCliente"
    private PasswordField txtContraseñaCliente; // Value injected by FXMLLoader

    @FXML // fx:id="btnIngresarCliente"
    private Button btnIngresarCliente; // Value injected by FXMLLoader

    @FXML
    void ingresarClienteAction(ActionEvent event) {

    }

    @FXML
    void recuperarContraseñaAction(ActionEvent event) {
        //Al presionar el Botón Cliente se abre la ventana para la ventana de recuperación de cuenta
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/poo/RecuperarContraseñaView.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Recuperación de cuenta");
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al cargar la vista: " + e.getMessage());
        }
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert txtCorreoCliente != null : "fx:id=\"txtCorreoCliente\" was not injected: check your FXML file 'ClienteLoginView.fxml'.";
        assert hyperLinkRecuperarContraseña != null : "fx:id=\"hyperLinkRecuperarContraseña\" was not injected: check your FXML file 'ClienteLoginView.fxml'.";
        assert txtContraseñaCliente != null : "fx:id=\"txtContraseñaCliente\" was not injected: check your FXML file 'ClienteLoginView.fxml'.";
        assert btnIngresarCliente != null : "fx:id=\"btnIngresarCliente\" was not injected: check your FXML file 'ClienteLoginView.fxml'.";
    }
}