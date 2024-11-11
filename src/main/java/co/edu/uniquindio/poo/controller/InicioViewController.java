package co.edu.uniquindio.poo.controller; 

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class InicioViewController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="btnAbrirVentanaCliente"
    private Button btnAbrirVentanaCliente; // Value injected by FXMLLoader

    @FXML // fx:id="btnAbrirVentanaEmpleado"
    private Button btnAbrirVentanaEmpleado; // Value injected by FXMLLoader

    @FXML // fx:id="btnAbrirVentanaAdmin"
    private Button btnAbrirVentanaAdmin; // Value injected by FXMLLoader

    @FXML
    void abrirVentanaCliente(ActionEvent event) {
        //Al presionar el Botón Cliente se abre la ventana para el Login del cliente
        
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
    void abrirVentanaEmpleado(ActionEvent event) {

    }

    @FXML
    void abrirVentanaAdmin(ActionEvent event) {

    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert btnAbrirVentanaCliente != null : "fx:id=\"btnAbrirVentanaCliente\" was not injected: check your FXML file 'InicioView.fxml'.";
        assert btnAbrirVentanaEmpleado != null : "fx:id=\"btnAbrirVentanaEmpleado\" was not injected: check your FXML file 'InicioView.fxml'.";
        assert btnAbrirVentanaAdmin != null : "fx:id=\"btnAbrirVentanaAdmin\" was not injected: check your FXML file 'InicioView.fxml'.";

    }
}
