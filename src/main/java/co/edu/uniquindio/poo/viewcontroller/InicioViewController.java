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
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class InicioViewController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="btnIniciarSesion"
    private Button btnIniciarSesion; // Value injected by FXMLLoader

    @FXML // fx:id="menuBtnYoSoy"
    private MenuButton menuBtnYoSoy; // Value injected by FXMLLoader

    @FXML // fx:id="hyperLinkRecuperarContraseña"
    private Hyperlink hyperLinkRecuperarContraseña; // Value injected by FXMLLoader

    @FXML // fx:id="txtCorreoElectronico"
    private TextField txtCorreoElectronico; // Value injected by FXMLLoader

    @FXML // fx:id="txtContrasenia"
    private PasswordField txtContrasenia; // Value injected by FXMLLoader

    @FXML
    private MenuItem administradorMenuItem;

    @FXML
    private MenuItem empleadoMenuItem;

    @FXML
    private MenuItem clienteMenuItem;

    @FXML
    public void initialize() {
        // Configuración de los ítems del menú
        administradorMenuItem.setOnAction(this::handleSeleccionarAdministrador);
        empleadoMenuItem.setOnAction(this::handleSeleccionarEmpleado);
        clienteMenuItem.setOnAction(this::handleSeleccionarCliente);
    }


    @FXML
    void iniciarSesion(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/poo/ClienteLoginView.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Login de Cliente");
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al cargar la vista: " + e.getMessage());
        }



    }



    @FXML
    void recuperarContraseñaAction(ActionEvent event) {

    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert btnIniciarSesion != null : "fx:id=\"btnIniciarSesion\" was not injected: check your FXML file 'InicioView.fxml'.";
        assert menuBtnYoSoy != null : "fx:id=\"menuBtnYoSoy\" was not injected: check your FXML file 'InicioView.fxml'.";
        assert hyperLinkRecuperarContraseña != null : "fx:id=\"hyperLinkRecuperarContraseña\" was not injected: check your FXML file 'InicioView.fxml'.";
        assert txtCorreoElectronico != null : "fx:id=\"txtCorreoElectronico\" was not injected: check your FXML file 'InicioView.fxml'.";
        assert txtContrasenia != null : "fx:id=\"txtContrasenia\" was not injected: check your FXML file 'InicioView.fxml'.";

    }
}



