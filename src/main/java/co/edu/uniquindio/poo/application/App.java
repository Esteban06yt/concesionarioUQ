package co.edu.uniquindio.poo.application;

import java.io.IOException;
import java.time.LocalDate;

import co.edu.uniquindio.poo.model.Administrador;
import co.edu.uniquindio.poo.model.Cliente;
import co.edu.uniquindio.poo.model.Concesionario;
import co.edu.uniquindio.poo.model.Empleado;
import co.edu.uniquindio.poo.model.Estado;
import co.edu.uniquindio.poo.model.MotoElectrico;

import co.edu.uniquindio.poo.model.Transmision;
import co.edu.uniquindio.poo.model.Venta;
import co.edu.uniquindio.poo.viewcontroller.AdministradorViewController;
import co.edu.uniquindio.poo.viewcontroller.ClienteViewController;
import co.edu.uniquindio.poo.viewcontroller.EmpleadoViewController;
import co.edu.uniquindio.poo.viewcontroller.GestionTransaccionesViewController;
import co.edu.uniquindio.poo.viewcontroller.GestionarClientesViewController;
import co.edu.uniquindio.poo.viewcontroller.GestionarVehiculosViewController;
import co.edu.uniquindio.poo.viewcontroller.InicioViewController;
import co.edu.uniquindio.poo.viewcontroller.RecuperarContraseñaViewController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;

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

    public void openAdministrador(Administrador administrador){
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("/co/edu/uniquindio/poo/AdministradorView.fxml"));
            javafx.scene.layout.AnchorPane rootLayout = (javafx.scene.layout.AnchorPane) loader.load();
            AdministradorViewController primaryController = loader.getController();
            primaryController.setApp(this);
            primaryController.setAdministrador(administrador);

            Scene scene = new Scene(rootLayout);
            primaryStage.setTitle("Gestion Empleados");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("Error al cargar la vista: " + e.getMessage());
        }
    }

    public void openEmpleado(Empleado empleado){
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("/co/edu/uniquindio/poo/EmpleadoView.fxml"));
            javafx.scene.layout.AnchorPane rootLayout = (javafx.scene.layout.AnchorPane) loader.load();
            EmpleadoViewController primaryController = loader.getController();
            primaryController.setApp(this);
            primaryController.setEmpleado(empleado);

            Scene scene = new Scene(rootLayout);
            primaryStage.setTitle("Gestiones del Empleado");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("Error al cargar la vista: " + e.getMessage());
        }

    }

    public void openCliente(Cliente cliente){
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("/co/edu/uniquindio/poo/ClienteView.fxml"));
            javafx.scene.layout.AnchorPane rootLayout = (javafx.scene.layout.AnchorPane) loader.load();
            ClienteViewController primaryController = loader.getController();
            primaryController.setApp(this);
            primaryController.setCliente(cliente);

            Scene scene = new Scene(rootLayout);
            primaryStage.setTitle("Gestiones del Cliente");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("Error al cargar la vista: " + e.getMessage());
        }
    }

    public void openRecuperarContraseña(){
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("/co/edu/uniquindio/poo/RecuperarContraseñaView.fxml"));
            javafx.scene.layout.AnchorPane rootLayout = (javafx.scene.layout.AnchorPane) loader.load();
            RecuperarContraseñaViewController primaryController = loader.getController();
            primaryController.setApp(this);

            Scene scene = new Scene(rootLayout);
            primaryStage.setTitle("Recuperar contraseña");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("Error al cargar la vista: " + e.getMessage());
        }
    }

    public void openGestionarClientes(Empleado empleado){
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("/co/edu/uniquindio/poo/GestionarClientesView.fxml"));
            javafx.scene.layout.AnchorPane rootLayout = (javafx.scene.layout.AnchorPane) loader.load();
            GestionarClientesViewController primaryController = loader.getController();
            primaryController.setApp(this);
            primaryController.setEmpleado(empleado);

            Scene scene = new Scene(rootLayout);
            primaryStage.setTitle("Gestionar clientes");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("Error al cargar la vista: " + e.getMessage());
        }
    }

    public void openGestionarVehiculo(Empleado empleado){
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("/co/edu/uniquindio/poo/GestionarVehiculosView.fxml"));
            javafx.scene.layout.AnchorPane rootLayout = (javafx.scene.layout.AnchorPane) loader.load();
            GestionarVehiculosViewController primaryController = loader.getController();
            primaryController.setApp(this);
            primaryController.setEmpleado(empleado);

            Scene scene = new Scene(rootLayout);
            primaryStage.setTitle("Gestionar vehiculos");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("Error al cargar la vista: " + e.getMessage());
        }
    }

    public void openGestionarTransacciones(Empleado empleado){
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("/co/edu/uniquindio/poo/GestionarTransaccionesView.fxml"));
            javafx.scene.layout.AnchorPane rootLayout = (javafx.scene.layout.AnchorPane) loader.load();
            GestionTransaccionesViewController primaryController = loader.getController();
            primaryController.setApp(this);
            primaryController.setEmpleado(empleado);

            Scene scene = new Scene(rootLayout);
            primaryStage.setTitle("Gestionar Transacciones");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("Error al cargar la vista: " + e.getMessage());
        }
    }

    public void inicializarData() {
   
    Cliente cliente = new Cliente("Juan", "1094901954", "Juanito@gmail.com", "546548", LocalDate.of(2004, 2, 12), "Juanito123", "1234", "¿Color de pelo?", "rojo");
    concesionario.AgregarPersona(cliente);
    
    Empleado empleado = new Empleado("Paco", "2135446", "Paco213@gmail.com", "54654564", LocalDate.of(1994, 3, 6), "Paco576", "0000", "¿Comida fav?", "pizza", "54");
    concesionario.AgregarPersona(empleado);
    empleado.AgregarCliente(cliente);

    Administrador administrador = new Administrador("Pedro", "546546", "Pedrosisi@gmail.com", "54664231", LocalDate.of(1990, 5, 23), "Pedritoproxd", "12345678", "¿pais favorito?", "francia", "1");
    concesionario.AgregarPersona(administrador);

    Administrador administrador2 = new Administrador("a", "a", "a", "a", LocalDate.of(1990, 5, 23), "a", "a", "a", "a", "2");
    concesionario.AgregarPersona(administrador2);
    administrador.AgregarEmpleado(empleado);

    MotoElectrico motoElectrico = new MotoElectrico("12", "Yamaha", "2024", 7, 300f, 200f, Transmision.MANUAL, Estado.NUEVO, 3f, 2f);
    concesionario.AgregarVehiculo(motoElectrico);
    empleado.AgregarVehiculo(motoElectrico);
   
    Venta venta = new Venta("54", LocalDate.of(1994, 5, 30), 500000f, cliente, empleado, motoElectrico, "Tarjeta" , true);
    concesionario.AgregarTransaccion(venta);

    }

    public Concesionario getConcesionario() {
        return concesionario;
    }
}