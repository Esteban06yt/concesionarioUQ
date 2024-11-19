package co.edu.uniquindio.poo.viewcontroller;

/**
 * Sample Skeleton for 'RegistrarClientesView.fxml' Controller Class
 */

 import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import co.edu.uniquindio.poo.Controller.Personacontroller;
import co.edu.uniquindio.poo.application.App;
import co.edu.uniquindio.poo.model.Cliente;
import co.edu.uniquindio.poo.model.Empleado;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
 import javafx.scene.control.DatePicker;
 import javafx.scene.control.TableColumn;
 import javafx.scene.control.TableView;
 import javafx.scene.control.TextField;
 
 public class GestionarClientesViewController {
    Empleado empleado;
    App app;
    Personacontroller personacontroller;
    ObservableList<Cliente> listaclientes = FXCollections.observableArrayList();
    Cliente clienteseleccionado;
 
     @FXML // ResourceBundle that was given to the FXMLLoader
     private ResourceBundle resources;
 
     @FXML // URL location of the FXML file that was given to the FXMLLoader
     private URL location;
 
     @FXML // fx:id="columnFraseSeguridadCliente"
     private TableColumn<Cliente, String> columnFraseSeguridadCliente; // Value injected by FXMLLoader
 
     @FXML // fx:id="txtCorreoCliente"
     private TextField txtCorreoCliente; // Value injected by FXMLLoader
 
     @FXML // fx:id="txtTelefonoCliente"
     private TextField txtTelefonoCliente; // Value injected by FXMLLoader
 
     @FXML // fx:id="columnPreguntaSeguridadCliente"
     private TableColumn<Cliente, String> columnPreguntaSeguridadCliente; // Value injected by FXMLLoader
 
     @FXML // fx:id="btnRegresar"
     private Button btnRegresar; // Value injected by FXMLLoader
 
     @FXML // fx:id="columnUsuarioCliente"
     private TableColumn<Cliente, String> columnUsuarioCliente; // Value injected by FXMLLoader
 
     @FXML // fx:id="txtFraseSeguridadCliente"
     private TextField txtFraseSeguridadCliente; // Value injected by FXMLLoader
 
     @FXML // fx:id="btnActualizarCliente"
     private Button btnActualizarCliente; // Value injected by FXMLLoader
 
     @FXML // fx:id="txtCedulaCliente"
     private TextField txtCedulaCliente; // Value injected by FXMLLoader
 
     @FXML // fx:id="columnNombreCliente"
     private TableColumn<Cliente, String> columnNombreCliente; // Value injected by FXMLLoader
 
     @FXML // fx:id="txtContraseñaCliente"
     private TextField txtContraseñaCliente; // Value injected by FXMLLoader
 
     @FXML // fx:id="tableClientes"
     private TableView<Cliente> tableClientes; // Value injected by FXMLLoader
 
     @FXML // fx:id="columnCedulaCliente"
     private TableColumn<Cliente, String> columnCedulaCliente; // Value injected by FXMLLoader
 
     @FXML // fx:id="columnTelefonoCliente"
     private TableColumn<Cliente, String> columnTelefonoCliente; // Value injected by FXMLLoader
 
     @FXML // fx:id="txtUsuarioCliente"
     private TextField txtUsuarioCliente; // Value injected by FXMLLoader
 
     @FXML // fx:id="btnEliminarCliente"
     private Button btnEliminarCliente; // Value injected by FXMLLoader
 
     @FXML // fx:id="txtNombreCliente"
     private TextField txtNombreCliente; // Value injected by FXMLLoader
 
     @FXML // fx:id="txtPreguntaSeguridadCliente"
     private TextField txtPreguntaSeguridadCliente; // Value injected by FXMLLoader
 
     @FXML // fx:id="columnCorreoCliente"
     private TableColumn<Cliente, String> columnCorreoCliente; // Value injected by FXMLLoader
 
     @FXML // fx:id="columnFechaNacimientoCliente"
     private TableColumn<Cliente, String> columnFechaNacimientoCliente; // Value injected by FXMLLoader
 
     @FXML // fx:id="columnContraseñaCliente"
     private TableColumn<Cliente, String> columnContraseñaCliente; // Value injected by FXMLLoader
 
     @FXML // fx:id="btnAgregarCliente"
     private Button btnAgregarCliente; // Value injected by FXMLLoader
 
     @FXML // fx:id="datenacimiento"
     private DatePicker datenacimiento; // Value injected by FXMLLoader

 
     @FXML
     void Regresar(ActionEvent event) {
        app.openEmpleado(empleado);
     }
 
     @FXML
     void eliminarClienteAction(ActionEvent event) {
        Cliente clienteseleccionado = tableClientes.getSelectionModel().getSelectedItem();
        if (clienteseleccionado != null) {
            String respuesta = personacontroller.EliminarPersona(clienteseleccionado);
            mostrarmensaje("Eliminar Cliente", respuesta, AlertType.INFORMATION);
            if (respuesta.equals("La persona se eliminó correctamente")) {
                listaclientes.remove(clienteseleccionado);
                empleado.EliminarCliente(clienteseleccionado);
                Vaciarcampos();
            }
        }else{
            mostrarmensaje("Eliminar Cliente", "Selecciona un cliente de la tabla", AlertType.WARNING);
        }
     }
 
     @FXML
     void actualizarClienteAction(ActionEvent event) {
        Cliente clienteseleccionado = tableClientes.getSelectionModel().getSelectedItem();
        String nombre = txtNombreCliente.getText();
        String cedula = txtCedulaCliente.getText();
        String correo = txtCorreoCliente.getText();
        String telefono = txtTelefonoCliente.getText();
        LocalDate nacimiento = datenacimiento.getValue();
        String usuario = txtUsuarioCliente.getText();
        String contraseña = txtContraseñaCliente.getText();
        String pregunta = txtPreguntaSeguridadCliente.getText();
        String frase = txtFraseSeguridadCliente.getText();
        boolean valido = Validardatos(nombre, cedula, correo, telefono, nacimiento, usuario, contraseña, pregunta, frase);
        if (valido) {
            if (clienteseleccionado != null) {
                Cliente cliente = new Cliente(nombre, cedula, correo, telefono, nacimiento, usuario, contraseña, pregunta, frase);
                String respuesta = personacontroller.ActualizarPersona(clienteseleccionado, cliente);
                mostrarmensaje("Actualizar Cliente", respuesta, AlertType.INFORMATION);
                if (respuesta.equals("La persona ha sido actualizada")) {
                    listaclientes.remove(clienteseleccionado);
                    listaclientes.add(cliente);
                    empleado.ActualizarCliente(clienteseleccionado, cliente);
                    Vaciarcampos();
                }
            }else{
                mostrarmensaje("Actualizar Cliente", "Selecciona un cliente de la tabla", AlertType.WARNING);
            }
     }
    }

 
     @FXML
     void agregarClienteAction(ActionEvent event) {
        String nombre = txtNombreCliente.getText();
        String cedula = txtCedulaCliente.getText();
        String correo = txtCorreoCliente.getText();
        String telefono = txtTelefonoCliente.getText();
        LocalDate nacimiento = datenacimiento.getValue();
        String usuario = txtUsuarioCliente.getText();
        String contraseña = txtContraseñaCliente.getText();
        String pregunta = txtPreguntaSeguridadCliente.getText();
        String frase = txtFraseSeguridadCliente.getText();
        boolean valido = Validardatos(nombre, cedula, correo, telefono, nacimiento, usuario, contraseña, pregunta, frase);
        if (valido) {
            Cliente cliente = new Cliente(nombre, cedula, correo, telefono, nacimiento, usuario, contraseña, pregunta, frase);
            String respuesta = personacontroller.Agregarpersona(cliente);
            mostrarmensaje("Agregar cliente", respuesta, AlertType.INFORMATION);
            
            if (respuesta.equals("La persona se añadió correctamente")) {
                listaclientes.add(cliente);
                empleado.AgregarCliente(cliente);
                Vaciarcampos();
            }
        }
     }

     public void setApp(App app) {
        this.app = app;
        personacontroller = new Personacontroller(app.getConcesionario());

    }
    
    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
        initView();// Inicia la información de la tabla
    }
    
    private void initView() {
        initDataBinding();
        ObtenerClientes();
        tableClientes.getItems().clear();
        tableClientes.setItems(listaclientes);
        listenerSelection();
        }

    public void ObtenerClientes(){
        listaclientes.addAll(personacontroller.ObtenerClientesEmpleado(empleado));
    }

        private void initDataBinding() {
        columnNombreCliente.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombre()));
        columnCedulaCliente.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCedula()));
        columnCorreoCliente.setCellValueFactory(cellData-> new SimpleStringProperty(cellData.getValue().getCorreo()));
        columnTelefonoCliente.setCellValueFactory(cellData-> new SimpleStringProperty(cellData.getValue().getTelefono()));
        columnFechaNacimientoCliente.setCellValueFactory(cellData-> new SimpleStringProperty(cellData.getValue().getFechaNacimiento().toString()));
        columnUsuarioCliente.setCellValueFactory(cellData-> new SimpleStringProperty(cellData.getValue().getUsuario()));
        columnContraseñaCliente.setCellValueFactory(cellData-> new SimpleStringProperty(cellData.getValue().getContraseña()));
        columnFraseSeguridadCliente.setCellValueFactory(cellData-> new SimpleStringProperty(cellData.getValue().getFraseSeguridad()));
        columnPreguntaSeguridadCliente.setCellValueFactory(cellData-> new SimpleStringProperty(cellData.getValue().getPreguntaSeguridad()));
    }

    private void listenerSelection() {
        tableClientes.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null && !listaclientes.isEmpty()) {
                clienteseleccionado = newSelection;
                mostrarInformacionCliente(clienteseleccionado);
            }
        });
    }

    private void mostrarInformacionCliente(Cliente cliente) {
        if (cliente != null) {
            txtNombreCliente.setText(cliente.getNombre());
            txtCedulaCliente.setText(cliente.getCedula());
            txtCorreoCliente.setText(cliente.getCorreo());
            txtTelefonoCliente.setText(cliente.getTelefono());
            datenacimiento.setValue(cliente.getFechaNacimiento());
            txtUsuarioCliente.setText(cliente.getUsuario());
            txtContraseñaCliente.setText(cliente.getContraseña());
            txtPreguntaSeguridadCliente.setText(cliente.getPreguntaSeguridad());
            txtFraseSeguridadCliente.setText(cliente.getFraseSeguridad());
        } else {
            Vaciarcampos();
        }
    }

    private void Vaciarcampos(){
        txtNombreCliente.clear();
        txtCedulaCliente.clear();
        txtCorreoCliente.clear();
        txtTelefonoCliente.clear();
        datenacimiento.setValue(null);
        txtUsuarioCliente.clear();
        txtContraseñaCliente.clear();
        txtPreguntaSeguridadCliente.clear();
        txtFraseSeguridadCliente.clear();
        tableClientes.getSelectionModel().clearSelection();
    }

        private boolean Validardatos(String nombre, String cedula, String correo, String telefono, LocalDate fechanacimiento,String usuario, String contraseña,String preguntaseguridad,String frase){
        if (nombre.isEmpty()||cedula.isEmpty()||correo.isEmpty()||telefono.isEmpty()||fechanacimiento==null||usuario.isEmpty()||contraseña.isEmpty()||preguntaseguridad.isEmpty()||frase.isEmpty()) {
            mostrarmensaje("Error", "Llene todos los datos correctamente", AlertType.WARNING);
            return false;
        }
        return true;
    }

    /**
     * Muestra un mensaje al usuario
     * 
     * @param titulo
     * @param header
     * @param contenido
     * @param alertType
     */
    public void mostrarmensaje(String titulo,  String contenido, AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(contenido);
        alert.showAndWait();
    }
 
     @FXML // This method is called by the FXMLLoader when initialization is complete
     void initialize() {
         assert columnFraseSeguridadCliente != null : "fx:id=\"columnFraseSeguridadCliente\" was not injected: check your FXML file 'RegistrarClientesView.fxml'.";
         assert txtCorreoCliente != null : "fx:id=\"txtCorreoCliente\" was not injected: check your FXML file 'RegistrarClientesView.fxml'.";
         assert txtTelefonoCliente != null : "fx:id=\"txtTelefonoCliente\" was not injected: check your FXML file 'RegistrarClientesView.fxml'.";
         assert columnPreguntaSeguridadCliente != null : "fx:id=\"columnPreguntaSeguridadCliente\" was not injected: check your FXML file 'RegistrarClientesView.fxml'.";
         assert btnRegresar != null : "fx:id=\"btnCerrarSesion\" was not injected: check your FXML file 'RegistrarClientesView.fxml'.";
         assert columnUsuarioCliente != null : "fx:id=\"columnUsuarioCliente\" was not injected: check your FXML file 'RegistrarClientesView.fxml'.";
         assert txtFraseSeguridadCliente != null : "fx:id=\"txtFraseSeguridadCliente\" was not injected: check your FXML file 'RegistrarClientesView.fxml'.";
         assert btnActualizarCliente != null : "fx:id=\"btnActualizarCliente\" was not injected: check your FXML file 'RegistrarClientesView.fxml'.";
         assert txtCedulaCliente != null : "fx:id=\"txtCedulaCliente\" was not injected: check your FXML file 'RegistrarClientesView.fxml'.";
         assert columnNombreCliente != null : "fx:id=\"columnNombreCliente\" was not injected: check your FXML file 'RegistrarClientesView.fxml'.";
         assert txtContraseñaCliente != null : "fx:id=\"txtContraseñaCliente\" was not injected: check your FXML file 'RegistrarClientesView.fxml'.";
         assert tableClientes != null : "fx:id=\"tableClientes\" was not injected: check your FXML file 'RegistrarClientesView.fxml'.";
         assert columnCedulaCliente != null : "fx:id=\"columnCedulaCliente\" was not injected: check your FXML file 'RegistrarClientesView.fxml'.";
         assert columnTelefonoCliente != null : "fx:id=\"columnTelefonoCliente\" was not injected: check your FXML file 'RegistrarClientesView.fxml'.";
         assert txtUsuarioCliente != null : "fx:id=\"txtUsuarioCliente\" was not injected: check your FXML file 'RegistrarClientesView.fxml'.";
         assert btnEliminarCliente != null : "fx:id=\"btnEliminarCliente\" was not injected: check your FXML file 'RegistrarClientesView.fxml'.";
         assert txtNombreCliente != null : "fx:id=\"txtNombreCliente\" was not injected: check your FXML file 'RegistrarClientesView.fxml'.";
         assert txtPreguntaSeguridadCliente != null : "fx:id=\"txtPreguntaSeguridadCliente\" was not injected: check your FXML file 'RegistrarClientesView.fxml'.";
         assert columnCorreoCliente != null : "fx:id=\"columnCorreoCliente\" was not injected: check your FXML file 'RegistrarClientesView.fxml'.";
         assert columnFechaNacimientoCliente != null : "fx:id=\"columnFechaNacimientoCliente\" was not injected: check your FXML file 'RegistrarClientesView.fxml'.";
         assert columnContraseñaCliente != null : "fx:id=\"columnContraseñaCliente\" was not injected: check your FXML file 'RegistrarClientesView.fxml'.";
         assert btnAgregarCliente != null : "fx:id=\"btnAgregarCliente\" was not injected: check your FXML file 'RegistrarClientesView.fxml'.";
         assert datenacimiento != null : "fx:id=\"datenacimiento\" was not injected: check your FXML file 'RegistrarClientesView.fxml'.";
 
     }
 }
 
