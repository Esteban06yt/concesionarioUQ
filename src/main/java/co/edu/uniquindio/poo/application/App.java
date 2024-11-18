package co.edu.uniquindio.poo.application;

import java.io.IOException;
import java.time.LocalDate;

import co.edu.uniquindio.poo.model.Administrador;
import co.edu.uniquindio.poo.model.Cliente;
import co.edu.uniquindio.poo.model.Concesionario;
import co.edu.uniquindio.poo.viewcontroller.InicioViewController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {


    private Stage primaryStage;
    Concesionario concesionario = new Concesionario("Tu Carro UQ");

    @Override
    public void start(Stage primaryStage) throws IOException {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Página principal");
        inicializarData();
        openViewPrincipal();
    }

    public static void main(String[] args) {
        launch(args);
    }

        /**
     * Abre la ventana principal
     */
    public void openViewPrincipal() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("/co/edu/uniquindio/poo/InicioView.fxml"));
            javafx.scene.layout.AnchorPane rootLayout = (javafx.scene.layout.AnchorPane) loader.load();
            InicioViewController primaryController = loader.getController();
            primaryController.setApp(this);

            Scene scene = new Scene(rootLayout);
            primaryStage.setTitle("Concesionario U.Q");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("Error al cargar la vista: " + e.getMessage());
        }
    }

    public void openAdministrador(){
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

    public void openEmpleado(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/poo/EmpleadoView.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Gestiones del Empleado");
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al cargar la vista: " + e.getMessage());
        }
    }

    public void openCliente(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/poo/ClienteView.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Gestiones del Cliente");
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al cargar la vista: " + e.getMessage());
        }
    }
    public void inicializarData() {
        Administrador administrador = new Administrador("Paco", "1234", "paco@gmail.com", "32323232", LocalDate.of(1994, 12, 23), "Paco123", "12345678", "¿Color de pelo?", "negro", "1");
        concesionario.AgregarPersona(administrador);
        Cliente cliente = new Cliente("Pepe", "5678", "pepe@gmail.com", "32323232", LocalDate.of(1999, 10, 13), "pepe123", "12345678", "¿Color de pelo?", "negro");
        concesionario.AgregarPersona(cliente);
    }
    public Concesionario getConcesionario() {
        return concesionario;
    }


}