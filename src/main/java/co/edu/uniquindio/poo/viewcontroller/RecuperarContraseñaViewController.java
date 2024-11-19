package co.edu.uniquindio.poo.viewcontroller;

import java.net.URL;
import java.util.LinkedList;
import java.util.Optional;
import java.util.ResourceBundle;

import co.edu.uniquindio.poo.Controller.Personacontroller;
import co.edu.uniquindio.poo.application.App;
import co.edu.uniquindio.poo.model.Persona;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;


public class RecuperarContraseñaViewController {
    App app;
    Personacontroller personacontroller;
    private LinkedList<Persona> listaPersonas = new LinkedList<>();

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="labelPreguntaSeguridad"
    private Label labelPreguntaSeguridad; // Value injected by FXMLLoader

    @FXML // fx:id="btnRecuperarCuenta"
    private Button btnRecuperarCuenta; // Value injected by FXMLLoader

    @FXML // fx:id="textFraseSeguridad"
    private TextField textFraseSeguridad; // Value injected by FXMLLoader

    @FXML // fx:id="txtCorreoElectronico"
    private TextField txtCorreoElectronico; // Value injected by FXMLLoader

    @FXML // fx:id="txtNuevaContraseña"
    private PasswordField txtNuevaContraseña; // Value injected by FXMLLoader

    @FXML // fx:id="txtConfirmarNuevaContraseña"
    private PasswordField txtConfirmarNuevaContraseña; // Value injected by FXMLLoader

    @FXML // fx:id="btnguardarcontraseña"
    private Button btnguardarcontraseña; // Value injected by FXMLLoader

    @FXML
    private Button btnvolver;

    @FXML
    void volver(ActionEvent event) {
        app.openViewPrincipal();
    }
    @FXML
    public void encontrarPreguntaSeguridad(String correo){
        // Encuentra a la persona que coincide con el correo ingresado
        Optional<Persona> personaEncontrada = listaPersonas.stream()
                .filter(persona -> persona.getCorreo().equals(correo))
                .findFirst();
        // Si la persona existe, establece la frase de seguridad en el label
        if (personaEncontrada.isPresent()) {
            mostrarAlerta(AlertType.INFORMATION, "Correo encontrado", "Responde la pregunta de seguridad");
            labelPreguntaSeguridad.setText(personaEncontrada.get().getPreguntaSeguridad());
        } else {
            // Si no se encuentra la persona, muestra un mensaje de alerta
            mostrarAlerta(AlertType.ERROR, "Correo no encontrado", "Este correo no está registrado");
        }
    }

    @FXML
    public void confirmarCorreo(ActionEvent event) {
        String correoIngresado = txtCorreoElectronico.getText();
        if (!correoIngresado.isEmpty()) {
            encontrarPreguntaSeguridad(correoIngresado);
        }else{
            mostrarAlerta(AlertType.ERROR, "Ingrese el correo", "Llene el campo de correo");
        }
    }

    @FXML
    public void guardarContraseña(ActionEvent event) {
        String correo = txtCorreoElectronico.getText();
        String respuesta = textFraseSeguridad.getText();
        String contraseña = txtNuevaContraseña.getText();
        String contraseña2 = txtConfirmarNuevaContraseña.getText();
        boolean validar = Validardatos(correo, respuesta, contraseña, contraseña2);
        if (validar) {
            validar = verificarCorreoYFrase();
            if (validar) {
                if (contraseña.equals(contraseña2)) {
                    mostrarAlerta(AlertType.INFORMATION, "Recuperación de Contraseña", "Se ha actualizado la información correctamente");
                    listaPersonas.stream().filter(persona -> persona.getCorreo().equals(correo)).findFirst().get().setContraseña(contraseña);
                    app.openViewPrincipal();
                }else{
                    mostrarAlerta(AlertType.INFORMATION, "Recuperación de Contraseña", "La contraseña no coincide");
                    txtNuevaContraseña.clear();
                    txtConfirmarNuevaContraseña.clear();
                }
            }
        }
     }

    @FXML
    public boolean verificarCorreoYFrase() {
        String correoIngresado = txtCorreoElectronico.getText();
        String fraseIngresada = textFraseSeguridad.getText();
        // Utiliza la función lambda para verificar si existe coincidencia
        boolean existe = listaPersonas.stream()
                .anyMatch(persona -> persona.getCorreo().equals(correoIngresado) &&
                        persona.getFraseSeguridad().equals(fraseIngresada));
        // Muestra una alerta en función del resultado
        if (existe) {
            mostrarAlerta(AlertType.INFORMATION, "Recuperación de Contraseña", "Correo y frase de seguridad coinciden.");
            return true;
        } else {
            mostrarAlerta(AlertType.ERROR, "Error de Verificación", "Correo o frase de seguridad incorrectos.");
            txtCorreoElectronico.clear();
            textFraseSeguridad.clear();
            txtNuevaContraseña.clear();
            txtConfirmarNuevaContraseña.clear();
            return false;
        }
    }


    // Método para mostrar alertas
    private void mostrarAlerta(AlertType tipo, String titulo, String contenido) {
        Alert alerta = new Alert(tipo);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(contenido);
        alerta.showAndWait();
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert labelPreguntaSeguridad != null : "fx:id=\"labelPreguntaSeguridad\" was not injected: check your FXML file 'RecuperarContraseñaView.fxml'.";
        assert btnRecuperarCuenta != null : "fx:id=\"btnRecuperarCuenta\" was not injected: check your FXML file 'RecuperarContraseñaView.fxml'.";
        assert textFraseSeguridad != null : "fx:id=\"txtFraseSeguridad\" was not injected: check your FXML file 'RecuperarContraseñaView.fxml'.";
        assert txtCorreoElectronico != null : "fx:id=\"txtCorreo\" was not injected: check your FXML file 'RecuperarContraseñaView.fxml'.";
    }
    public void setApp(App app) {
        this.app = app;
        personacontroller = new Personacontroller(app.getConcesionario());
        obtenerpersonas();
    }
    
    public void obtenerpersonas(){
        listaPersonas.addAll(personacontroller.obtenerlistapersonas());
    }

    public boolean Validardatos(String correo, String respuesta,String contraseña, String confirmacioncontraseña){
        if (correo.isEmpty()||respuesta.isEmpty()||contraseña.isEmpty()||confirmacioncontraseña.isEmpty()) {
            mostrarAlerta(AlertType.WARNING, "Datos incompletos", "Rellene los datos correctamente");
            return false;
        }
        return true;
    }
}