package co.edu.uniquindio.poo.viewcontroller;

import java.net.URL;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import co.edu.uniquindio.poo.model.Persona;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class RecuperarContraseñaViewController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="labelPreguntaSeguridad"
    private Label labelPreguntaSeguridad; // Value injected by FXMLLoader

    @FXML // fx:id="btnRecuperarCuenta"
    private Button btnRecuperarCuenta; // Value injected by FXMLLoader

    @FXML // fx:id="txtFraseSeguridad"
    private TextField txtFraseSeguridad; // Value injected by FXMLLoader

    @FXML // fx:id="txtCorreo"
    private TextField txtCorreo; // Value injected by FXMLLoader

    private Collection<Persona> listaPersonas;

    public RecuperarContraseñaViewController() {
        // Constructor sin argumentos requerido por el FXMLLoader
    }

    public void setListaPersonas(List<Persona> listaPersonas) {
        this.listaPersonas = listaPersonas;
    }

    @FXML
    public void encontrarPreguntaSeguridad(){
        String correoIngresado = txtCorreo.getText();
        // Encuentra a la persona que coincide con el correo ingresado
        Optional<Persona> personaEncontrada = listaPersonas.stream()
                .filter(persona -> persona.getCorreo().equals(correoIngresado))
                .findFirst();
        // Si la persona existe, establece la frase de seguridad en el label
        if (personaEncontrada.isPresent()) {
            labelPreguntaSeguridad.setText(personaEncontrada.get().getPreguntaSeguridad());
        } else {
            // Si no se encuentra la persona, muestra un mensaje de alerta
            mostrarAlerta(AlertType.ERROR, "Usuario no encontrado", "No existe una persona con el correo ingresado.");
            labelPreguntaSeguridad.setText(""); // Limpia el label si no se encuentra el correo
        }
    }

    @FXML
    public void verificarCorreoYFrase(ActionEvent event) {
        String correoIngresado = txtCorreo.getText();
        String fraseIngresada = txtFraseSeguridad.getText();
        // Utiliza la función lambda para verificar si existe coincidencia
        boolean existe = listaPersonas.stream()
                .anyMatch(persona -> persona.getCorreo().equals(correoIngresado) &&
                        persona.getFraseSeguridad().equals(fraseIngresada));
        // Muestra una alerta en función del resultado
        if (existe) {
            mostrarAlerta(AlertType.INFORMATION, "Recuperación de Contraseña", "Correo y frase de seguridad coinciden.");
            //Al presionar el Botón Cliente se abre la ventana para el Login del cliente
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/poo/ReestablecerContraseñaView.fxml"));
                Parent root = loader.load();
             Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.setTitle("Reestablecer Contraseña");
                stage.show();
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Error al cargar la vista: " + e.getMessage());
            }
        } else {
            mostrarAlerta(AlertType.ERROR, "Error de Verificación", "Correo o frase de seguridad incorrectos.");
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
        assert txtFraseSeguridad != null : "fx:id=\"txtFraseSeguridad\" was not injected: check your FXML file 'RecuperarContraseñaView.fxml'.";
        assert txtCorreo != null : "fx:id=\"txtCorreo\" was not injected: check your FXML file 'RecuperarContraseñaView.fxml'.";
    }
}