package co.edu.uniquindio.poo.viewcontroller;

import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;

import co.edu.uniquindio.poo.Controller.Personacontroller;
import co.edu.uniquindio.poo.application.App;
import co.edu.uniquindio.poo.model.Administrador;
import co.edu.uniquindio.poo.model.Cliente;
import co.edu.uniquindio.poo.model.Empleado;
import co.edu.uniquindio.poo.model.Persona;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class InicioViewController {

    private LinkedList<Persona> listaPersonas = new LinkedList<>();
    private Personacontroller personacontroller;
    ObservableList<String> tipopersona = FXCollections.observableArrayList("","Administrador", "Empleado", "Cliente");
    App app;
    
    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="btnIniciarSesion"
    private Button btnIniciarSesion; // Value injected by FXMLLoader

    @FXML // fx:id="comboboxyosoy"
    private ComboBox<String> comboboxyosoy; // Value injected by FXMLLoader

    @FXML // fx:id="hyperLinkRecuperarContraseña"
    private Hyperlink hyperLinkRecuperarContraseña; // Value injected by FXMLLoader

    @FXML // fx:id="txtCorreoElectronico"
    private TextField txtCorreoElectronico; // Value injected by FXMLLoader

    @FXML // fx:id="txtContrasenia"
    private PasswordField txtContrasenia; // Value injected by FXMLLoader

    @FXML
    void iniciarSesion(ActionEvent event) {
        String correoIngresado = txtCorreoElectronico.getText();
        String contraseñaIngresada = txtContrasenia.getText();
        String tipopersona = comboboxyosoy.getSelectionModel().getSelectedItem();
        boolean valido = Validardatos(tipopersona,correoIngresado,contraseñaIngresada);
        if (valido) {
            // Encuentra a la persona que coincide con el correo ingresado
        Persona personaEncontrada = listaPersonas.stream()
                .filter(persona -> persona.getCorreo().equals(correoIngresado) && persona.getContraseña().equals(contraseñaIngresada))
                .findFirst().orElse(null);
        if (personaEncontrada != null) {
            if (personaEncontrada instanceof Administrador && tipopersona.equals("Administrador")) {
                app.openAdministrador((Administrador)personaEncontrada);
                Limpiarseleccion();
            }else if (personaEncontrada instanceof Empleado && tipopersona.equals("Empleado")) {
                app.openEmpleado((Empleado)personaEncontrada);
                Limpiarseleccion();
            }else if (personaEncontrada instanceof Cliente && tipopersona.equals("Cliente")) {
                app.openCliente((Cliente)personaEncontrada);
                Limpiarseleccion();
            }else{
                // Si no se encuentra la persona, muestra un mensaje de alerta
                mostrarAlerta(AlertType.ERROR, "Usuario no encontrado", "Verifique los datos ingresados.");
            }
            
            
        }else {
            // Si no se encuentra la persona, muestra un mensaje de alerta
            mostrarAlerta(AlertType.ERROR, "Usuario no encontrado", "Verifique los datos ingresados.");
        }
        }
    }



    @FXML
    void recuperarContraseñaAction(ActionEvent event) {
        app.openRecuperarContraseña();
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert btnIniciarSesion != null : "fx:id=\"btnIniciarSesion\" was not injected: check your FXML file 'InicioView.fxml'.";
        assert comboboxyosoy != null : "fx:id=\"comboboxyosoy\" was not injected: check your FXML file 'InicioView.fxml'.";
        assert hyperLinkRecuperarContraseña != null : "fx:id=\"hyperLinkRecuperarContraseña\" was not injected: check your FXML file 'InicioView.fxml'.";
        assert txtCorreoElectronico != null : "fx:id=\"txtCorreoElectronico\" was not injected: check your FXML file 'InicioView.fxml'.";
        assert txtContrasenia != null : "fx:id=\"txtContrasenia\" was not injected: check your FXML file 'InicioView.fxml'.";

    /**
     *     // Configuración de los ítems del menú
        administradorMenuItem.setOnAction(this::handleSeleccionarAdministrador);
        empleadoMenuItem.setOnAction(this::handleSeleccionarEmpleado);
        clienteMenuItem.setOnAction(this::handleSeleccionarCliente);
     */

    }

    // Método para mostrar alertas
    private void mostrarAlerta(AlertType tipo, String titulo, String contenido) {
        Alert alerta = new Alert(tipo);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(contenido);
        alerta.showAndWait();
    }

    public void setApp(App app) {
        this.app = app;
        personacontroller = new Personacontroller(app.getConcesionario());
        obtenerpersonas();
        comboboxyosoy.setItems(tipopersona);
        comboboxyosoy.setValue("");
    }

    public void obtenerpersonas(){
        listaPersonas.addAll(personacontroller.obtenerlistapersonas());
    }

    public boolean Validardatos(String tipo, String correo, String contraseña){
        if(tipo.equals("")||correo.isEmpty() || contraseña.isEmpty()){
            mostrarAlerta(AlertType.WARNING, "Datos incompletos", "Rellene los datos correctamente");
            return false;
        }
        return true;
    }
    public void Limpiarseleccion(){
        comboboxyosoy.setValue("");
        txtCorreoElectronico.clear();
        txtContrasenia.clear();
    }
}



