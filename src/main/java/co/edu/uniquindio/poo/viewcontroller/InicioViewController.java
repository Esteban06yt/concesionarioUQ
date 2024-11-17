package co.edu.uniquindio.poo.viewcontroller;

import java.net.URL;
import java.util.Collection;
import java.util.Optional;
import java.util.ResourceBundle;

import co.edu.uniquindio.poo.model.Administrador;
import co.edu.uniquindio.poo.model.Empleado;
import co.edu.uniquindio.poo.model.Persona;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
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

    private Collection<Persona> listaPersonas;


    

    @FXML
    void iniciarSesion(ActionEvent event) {
        String correoIngresado = txtCorreoElectronico.getText();
        String contraseñaIngresada = txtContrasenia.getText();
        // Encuentra a la persona que coincide con el correo ingresado
        Optional<Persona> personaEncontrada = listaPersonas.stream()
                .filter(persona -> persona.getCorreo().equals(correoIngresado))
                .findFirst();
        // Si la persona existe, establece la frase de seguridad en el label
        if (personaEncontrada.isPresent()) {
            Persona persona = personaEncontrada.get();
            if (persona instanceof Administrador && persona.getContraseña().equals(contraseñaIngresada)) {
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/poo/AdminView.fxml"));
                    Parent root = loader.load();
                    Stage stage = new Stage();
                    stage.setScene(new Scene(root));
                    stage.setTitle("Gestion Empleados");
                    stage.show();
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("Error al cargar la vista: " + e.getMessage());
                }
            }
            if (persona instanceof Empleado && persona.getContraseña().equals(contraseñaIngresada)) {
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/poo/EmpleadoView.fxml"));
                    Parent root = loader.load();
                    Stage stage = new Stage();
                    stage.setScene(new Scene(root));
                    stage.setTitle("Gestion Empleados");
                    stage.show();
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("Error al cargar la vista: " + e.getMessage());
                }
            }
        }else {
            // Si no se encuentra la persona, muestra un mensaje de alerta
            mostrarAlerta(AlertType.ERROR, "Usuario no encontrado", "Verifique los datos ingresados.");
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

        // Configuración de los ítems del menú
        administradorMenuItem.setOnAction(this::handleSeleccionarAdministrador);
        empleadoMenuItem.setOnAction(this::handleSeleccionarEmpleado);
        clienteMenuItem.setOnAction(this::handleSeleccionarCliente);

    }

    // Método para mostrar alertas
    private void mostrarAlerta(AlertType tipo, String titulo, String contenido) {
        Alert alerta = new Alert(tipo);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(contenido);
        alerta.showAndWait();
    }
}



