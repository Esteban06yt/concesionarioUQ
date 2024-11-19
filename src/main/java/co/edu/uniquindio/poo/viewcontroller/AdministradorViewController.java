package co.edu.uniquindio.poo.viewcontroller;

/**
 * Sample Skeleton for 'AdministradorView.fxml' Controller Class
 */

 import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import co.edu.uniquindio.poo.Controller.Personacontroller;
import co.edu.uniquindio.poo.application.App;
import co.edu.uniquindio.poo.model.Administrador;
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
 
 public class AdministradorViewController {
    Administrador administrador;
    App app;
    Personacontroller personacontroller;
    ObservableList<Empleado> listaempleados = FXCollections.observableArrayList();
    Empleado empleadoseleccionado;

     @FXML // ResourceBundle that was given to the FXMLLoader
     private ResourceBundle resources;
 
     @FXML // URL location of the FXML file that was given to the FXMLLoader
     private URL location;
 
     @FXML // fx:id="columncorreo"
     private TableColumn<Empleado, String> columncorreo; // Value injected by FXMLLoader
 
     @FXML // fx:id="txtusuario"
     private TextField txtusuario; // Value injected by FXMLLoader
 
     @FXML // fx:id="btnCerrarSesion"
     private Button btnCerrarSesion; // Value injected by FXMLLoader
 
     @FXML // fx:id="txtcedula"
     private TextField txtcedula; // Value injected by FXMLLoader
 
     @FXML // fx:id="txtpregunta"
     private TextField txtpregunta; // Value injected by FXMLLoader
 
     @FXML // fx:id="txtfrase"
     private TextField txtfrase; // Value injected by FXMLLoader
 
     @FXML // fx:id="txtid"
     private TextField txtid; // Value injected by FXMLLoader
 
     @FXML // fx:id="btnEliminarEmpleado"
     private Button btnEliminarEmpleado; // Value injected by FXMLLoader
 
     @FXML // fx:id="txttelefono"
     private TextField txttelefono; // Value injected by FXMLLoader
 
     @FXML // fx:id="txtnombre"
     private TextField txtnombre; // Value injected by FXMLLoader
 
     @FXML // fx:id="tblempleados"
     private TableView<Empleado> tblempleados; // Value injected by FXMLLoader
 
     @FXML // fx:id="columncedula"
     private TableColumn<Empleado, String> columncedula; // Value injected by FXMLLoader
 
     @FXML // fx:id="txtcorreo"
     private TextField txtcorreo; // Value injected by FXMLLoader
 
     @FXML // fx:id="columnid"
     private TableColumn<Empleado, String> columnid; // Value injected by FXMLLoader
 
     @FXML // fx:id="btnAgregarEmpleado"
     private Button btnAgregarEmpleado; // Value injected by FXMLLoader
 
     @FXML // fx:id="columntelefono"
     private TableColumn<Empleado, String> columntelefono; // Value injected by FXMLLoader
 
     @FXML // fx:id="columnnombre"
     private TableColumn<Empleado, String> columnnombre; // Value injected by FXMLLoader
 
     @FXML // fx:id="columnusuario"
     private TableColumn<Empleado, String> columnusuario; // Value injected by FXMLLoader
 
     @FXML // fx:id="columnfrase"
     private TableColumn<Empleado, String> columnfrase; // Value injected by FXMLLoader
 
     @FXML // fx:id="txtcontraseña"
     private TextField txtcontraseña; // Value injected by FXMLLoader
 
     @FXML // fx:id="btnActualizarEmpleado"
     private Button btnActualizarEmpleado; // Value injected by FXMLLoader
 
     @FXML // fx:id="columncontraseña"
     private TableColumn<Empleado, String> columncontraseña; // Value injected by FXMLLoader
 
     @FXML // fx:id="columnfecha"
     private TableColumn<Empleado, String> columnfecha; // Value injected by FXMLLoader
 
     @FXML // fx:id="columnpregunta"
     private TableColumn<Empleado, String> columnpregunta; // Value injected by FXMLLoader
 
     @FXML // fx:id="datenacimiento"
     private DatePicker datenacimiento; // Value injected by FXMLLoader
 
     @FXML
     void cerrarSesion(ActionEvent event) {
        app.openViewPrincipal();
     }
 
     @FXML
     void eliminarEmpleadoAction(ActionEvent event) {
        Empleado empleadoseleccionado = tblempleados.getSelectionModel().getSelectedItem();
        if (empleadoseleccionado != null) {
            String respuesta = personacontroller.EliminarPersona(empleadoseleccionado);
            mostrarmensaje("Eliminar empleado", respuesta, AlertType.INFORMATION);
            if (respuesta.equals("La persona se eliminó correctamente")) {
                listaempleados.remove(empleadoseleccionado);
                administrador.EliminarEmpleado(empleadoseleccionado);
                Vaciarcampos();
            }
        }else{
            mostrarmensaje("Eliminar empleado", "Selecciona un cliente de la tabla", AlertType.WARNING);
        }
     }
 
     @FXML
     void actualizarEmpleadoAction(ActionEvent event) {
        Empleado empleadoseleccionado = tblempleados.getSelectionModel().getSelectedItem();
        String nombre = txtnombre.getText();
        String cedula = txtcedula.getText();
        String correo = txtcorreo.getText();
        String telefono = txttelefono.getText();
        LocalDate nacimiento = datenacimiento.getValue();
        String usuario = txtusuario.getText();
        String contraseña = txtcontraseña.getText();
        String pregunta = txtpregunta.getText();
        String frase = txtfrase.getText();
        String id = txtid.getText();
        boolean valido = Validardatos(nombre, cedula, correo, telefono, nacimiento, usuario, contraseña, pregunta, frase, id);
        if (valido) {
            if (empleadoseleccionado != null) {
                Empleado empleado = new Empleado(nombre, cedula, correo, telefono, nacimiento, usuario, contraseña, pregunta, frase, id);
                String respuesta = personacontroller.ActualizarPersona(empleadoseleccionado, empleado);
                mostrarmensaje("Actualizar empleado", respuesta, AlertType.INFORMATION);
                if (respuesta.equals("La persona ha sido actualizada")) {
                    listaempleados.remove(empleadoseleccionado);
                    listaempleados.add(empleado);
                    administrador.ActualizarEmpleado(empleadoseleccionado, empleado);
                    Vaciarcampos();
                }
            }else{
                mostrarmensaje("Actualizar empleado", "Selecciona un empleado de la tabla", AlertType.WARNING);
            }
     }
    }
     @FXML
     void agregarEmpleadoAction(ActionEvent event) {
        String nombre = txtnombre.getText();
        String cedula = txtcedula.getText();
        String correo = txtcorreo.getText();
        String telefono = txttelefono.getText();
        LocalDate nacimiento = datenacimiento.getValue();
        String usuario = txtusuario.getText();
        String contraseña = txtcontraseña.getText();
        String pregunta = txtpregunta.getText();
        String frase = txtfrase.getText();
        String id = txtid.getText();
        boolean valido = Validardatos(nombre, cedula, correo, telefono, nacimiento, usuario, contraseña, pregunta, frase, id);

        if (valido) {
            Empleado empleado = new Empleado(nombre, cedula, correo, telefono, nacimiento, usuario, contraseña, pregunta, frase, id);
            String respuesta = personacontroller.Agregarpersona(empleado);
            mostrarmensaje("Agregar empleado", respuesta, AlertType.INFORMATION);
            
            if (respuesta.equals("La persona se añadió correctamente")) {
                listaempleados.add(empleado);
                administrador.AgregarEmpleado(empleado);
                Vaciarcampos();
            }
        }
     }

    public void setApp(App app) {
        this.app = app;
        personacontroller = new Personacontroller(app.getConcesionario());

    }
    
    public void setAdministrador(Administrador administrador) {
        this.administrador = administrador;
        initView();// Inicia la información de la tabla
    }
    
    private void initView() {
        initDataBinding();
        ObtenerEmpleados();
        tblempleados.getItems().clear();
        tblempleados.setItems(listaempleados);
        listenerSelection();
        }

    public void ObtenerEmpleados(){
        listaempleados.addAll(personacontroller.ObtenerEmpleadosAdmin(administrador));
    }
 
    private void initDataBinding() {
        columnnombre.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombre()));
        columncedula.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCedula()));
        columncorreo.setCellValueFactory(cellData-> new SimpleStringProperty(cellData.getValue().getCorreo()));
        columntelefono.setCellValueFactory(cellData-> new SimpleStringProperty(cellData.getValue().getTelefono()));
        columnfecha.setCellValueFactory(cellData-> new SimpleStringProperty(cellData.getValue().getFechaNacimiento().toString()));
        columnusuario.setCellValueFactory(cellData-> new SimpleStringProperty(cellData.getValue().getUsuario()));
        columncontraseña.setCellValueFactory(cellData-> new SimpleStringProperty(cellData.getValue().getContraseña()));
        columnfrase.setCellValueFactory(cellData-> new SimpleStringProperty(cellData.getValue().getFraseSeguridad()));
        columnpregunta.setCellValueFactory(cellData-> new SimpleStringProperty(cellData.getValue().getPreguntaSeguridad()));
        columnid.setCellValueFactory(cellData-> new SimpleStringProperty(cellData.getValue().getIdEmpleado()));
    }

    private void listenerSelection() {
        tblempleados.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null && !listaempleados.isEmpty()) {
                empleadoseleccionado = newSelection;
                mostrarInformacionEmpleado(empleadoseleccionado);// Muestra la informacion del empleado seleccionado
            }
        });
    }

    private void mostrarInformacionEmpleado(Empleado empleado) {
        if (empleado != null) {
            txtnombre.setText(empleado.getNombre());
            txtcedula.setText(empleado.getCedula());
            txtcorreo.setText(empleado.getCorreo());
            txttelefono.setText(empleado.getTelefono());
            datenacimiento.setValue(empleado.getFechaNacimiento());
            txtusuario.setText(empleado.getUsuario());
            txtcontraseña.setText(empleado.getContraseña());
            txtpregunta.setText(empleado.getPreguntaSeguridad());
            txtfrase.setText(empleado.getFraseSeguridad());
            txtid.setText(empleado.getIdEmpleado());
        } else {
            Vaciarcampos();
        }
    }

    private void Vaciarcampos(){
        txtnombre.clear();
        txtcedula.clear();
        txtcorreo.clear();
        txttelefono.clear();
        datenacimiento.setValue(null);
        txtusuario.clear();
        txtcontraseña.clear();
        txtpregunta.clear();
        txtfrase.clear();
        txtid.clear();
        tblempleados.getSelectionModel().clearSelection();
    }

    private boolean Validardatos(String nombre, String cedula, String correo, String telefono, LocalDate fechanacimiento,String usuario, String contraseña,String preguntaseguridad,String frase, String id){
        if (nombre.isEmpty()||cedula.isEmpty()||correo.isEmpty()||telefono.isEmpty()||fechanacimiento==null||usuario.isEmpty()||contraseña.isEmpty()||preguntaseguridad.isEmpty()||frase.isEmpty()||id.isEmpty()) {
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
         assert columncorreo != null : "fx:id=\"columncorreo\" was not injected: check your FXML file 'AdministradorView.fxml'.";
         assert txtusuario != null : "fx:id=\"txtusuario\" was not injected: check your FXML file 'AdministradorView.fxml'.";
         assert btnCerrarSesion != null : "fx:id=\"btnCerrarSesion\" was not injected: check your FXML file 'AdministradorView.fxml'.";
         assert txtcedula != null : "fx:id=\"txtcedula\" was not injected: check your FXML file 'AdministradorView.fxml'.";
         assert txtpregunta != null : "fx:id=\"txtpregunta\" was not injected: check your FXML file 'AdministradorView.fxml'.";
         assert txtfrase != null : "fx:id=\"txtfrase\" was not injected: check your FXML file 'AdministradorView.fxml'.";
         assert txtid != null : "fx:id=\"txtid\" was not injected: check your FXML file 'AdministradorView.fxml'.";
         assert btnEliminarEmpleado != null : "fx:id=\"btnEliminarEmpleado\" was not injected: check your FXML file 'AdministradorView.fxml'.";
         assert txttelefono != null : "fx:id=\"txttelefono\" was not injected: check your FXML file 'AdministradorView.fxml'.";
         assert txtnombre != null : "fx:id=\"txtnombre\" was not injected: check your FXML file 'AdministradorView.fxml'.";
         assert tblempleados != null : "fx:id=\"tblempleados\" was not injected: check your FXML file 'AdministradorView.fxml'.";
         assert columncedula != null : "fx:id=\"columncedula\" was not injected: check your FXML file 'AdministradorView.fxml'.";
         assert txtcorreo != null : "fx:id=\"txtcorreo\" was not injected: check your FXML file 'AdministradorView.fxml'.";
         assert columnid != null : "fx:id=\"columnid\" was not injected: check your FXML file 'AdministradorView.fxml'.";
         assert btnAgregarEmpleado != null : "fx:id=\"btnAgregarEmpleado\" was not injected: check your FXML file 'AdministradorView.fxml'.";
         assert columntelefono != null : "fx:id=\"columntelefono\" was not injected: check your FXML file 'AdministradorView.fxml'.";
         assert columnnombre != null : "fx:id=\"columnnombre\" was not injected: check your FXML file 'AdministradorView.fxml'.";
         assert columnusuario != null : "fx:id=\"columnusuario\" was not injected: check your FXML file 'AdministradorView.fxml'.";
         assert columnfrase != null : "fx:id=\"columnfrase\" was not injected: check your FXML file 'AdministradorView.fxml'.";
         assert txtcontraseña != null : "fx:id=\"txtcontraseña\" was not injected: check your FXML file 'AdministradorView.fxml'.";
         assert btnActualizarEmpleado != null : "fx:id=\"btnActualizarEmpleado\" was not injected: check your FXML file 'AdministradorView.fxml'.";
         assert columncontraseña != null : "fx:id=\"columncontraseña\" was not injected: check your FXML file 'AdministradorView.fxml'.";
         assert columnfecha != null : "fx:id=\"columnfecha\" was not injected: check your FXML file 'AdministradorView.fxml'.";
         assert columnpregunta != null : "fx:id=\"columnpregunta\" was not injected: check your FXML file 'AdministradorView.fxml'.";
         assert datenacimiento != null : "fx:id=\"datenacimiento\" was not injected: check your FXML file 'AdministradorView.fxml'.";
 
     }
 }
 