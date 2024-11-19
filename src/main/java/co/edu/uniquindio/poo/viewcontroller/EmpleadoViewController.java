package co.edu.uniquindio.poo.viewcontroller;

/**
 * Sample Skeleton for 'EmpleadoView.fxml' Controller Class
 */

 import java.net.URL;
 import java.util.ResourceBundle;

import co.edu.uniquindio.poo.Controller.Personacontroller;
import co.edu.uniquindio.poo.Controller.TransaccionController;
import co.edu.uniquindio.poo.Controller.VehiculoController;
import co.edu.uniquindio.poo.application.App;
import co.edu.uniquindio.poo.model.Cliente;
import co.edu.uniquindio.poo.model.Empleado;
import co.edu.uniquindio.poo.model.Transaccion;
import co.edu.uniquindio.poo.model.Vehiculo;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
 import javafx.scene.control.Button;
 import javafx.scene.control.TableColumn;
 import javafx.scene.control.TableView;
 
 public class EmpleadoViewController {
 
    App app;
    Empleado empleado;
    TransaccionController transaccioncontroller;
    Personacontroller personacontroller;
    VehiculoController vehiculocontroller;
    ObservableList<Transaccion> listatransacciones = FXCollections.observableArrayList();
    ObservableList<Vehiculo> listavehiculos = FXCollections.observableArrayList();
    ObservableList<Cliente> listaclientes = FXCollections.observableArrayList();


     @FXML // ResourceBundle that was given to the FXMLLoader
     private ResourceBundle resources;
 
     @FXML // URL location of the FXML file that was given to the FXMLLoader
     private URL location;
 
     @FXML // fx:id="columncorreo"
     private TableColumn<Cliente, String> columncorreo; // Value injected by FXMLLoader
 
     @FXML // fx:id="btnRegistrarVehiculo"
     private Button btnRegistrarVehiculo; // Value injected by FXMLLoader
 
     @FXML // fx:id="columnfechanacimiento"
     private TableColumn<Cliente, String> columnfechanacimiento; // Value injected by FXMLLoader
 
     @FXML // fx:id="columncambios"
     private TableColumn<Vehiculo, String> columncambios; // Value injected by FXMLLoader
 
     @FXML // fx:id="columntipo"
     private TableColumn<Vehiculo, String> columntipo; // Value injected by FXMLLoader
 
     @FXML // fx:id="columnidvehiculo"
     private TableColumn<Vehiculo, String> columnidvehiculo; // Value injected by FXMLLoader
 
     @FXML // fx:id="btnCerrarSesion"
     private Button btnCerrarSesion; // Value injected by FXMLLoader
 
     @FXML // fx:id="columntransmision"
     private TableColumn<Vehiculo, String> columntransmision; // Value injected by FXMLLoader
 
     @FXML // fx:id="btnGestionarVenta"
     private Button btnGestionarVenta; // Value injected by FXMLLoader
 
     @FXML // fx:id="columncliente"
     private TableColumn<Transaccion, String> columncliente; // Value injected by FXMLLoader
 
     @FXML // fx:id="columnmodelo"
     private TableColumn<Vehiculo, String> columnmodelo; // Value injected by FXMLLoader
 
     @FXML // fx:id="columnidtransaccion"
     private TableColumn<Transaccion, String> columnidtransaccion; // Value injected by FXMLLoader
 
     @FXML // fx:id="btntablavehiculos"
     private Button btntablavehiculos; // Value injected by FXMLLoader
 
     @FXML // fx:id="columnmarca"
     private TableColumn<Vehiculo, String> columnmarca; // Value injected by FXMLLoader
 
     @FXML // fx:id="columnprecio"
     private TableColumn<Transaccion, String> columnprecio; // Value injected by FXMLLoader
 
     @FXML // fx:id="columncilindraje"
     private TableColumn<Vehiculo, String> columncilindraje; // Value injected by FXMLLoader
 
     @FXML // fx:id="columnvelocidad"
     private TableColumn<Vehiculo, String> columnvelocidad; // Value injected by FXMLLoader
 
     @FXML // fx:id="tbltransacciones"
     private TableView<Transaccion> tbltransacciones; // Value injected by FXMLLoader
 
     @FXML // fx:id="columncedula"
     private TableColumn<Cliente, String> columncedula; // Value injected by FXMLLoader
 
     @FXML // fx:id="btnRegistrarCliente"
     private Button btnRegistrarCliente; // Value injected by FXMLLoader
 
     @FXML // fx:id="columnEstado"
     private TableColumn<Vehiculo, String> columnEstado; // Value injected by FXMLLoader
 
     @FXML // fx:id="columntelefono"
     private TableColumn<Cliente, String> columntelefono; // Value injected by FXMLLoader
 
     @FXML // fx:id="columnnombre"
     private TableColumn<Cliente, String> columnnombre; // Value injected by FXMLLoader
 
     @FXML // fx:id="columnusuario"
     private TableColumn<Cliente, String> columnusuario; // Value injected by FXMLLoader
 
     @FXML // fx:id="columnEmpleado"
     private TableColumn<Transaccion, String> columnEmpleado; // Value injected by FXMLLoader
 
     @FXML // fx:id="columnfrase"
     private TableColumn<Cliente, String> columnfrase; // Value injected by FXMLLoader
 
     @FXML // fx:id="columntipotransaccion"
     private TableColumn<Transaccion, String> columntipotransaccion; // Value injected by FXMLLoader
 
     @FXML // fx:id="tblclientes"
     private TableView<Cliente> tblclientes; // Value injected by FXMLLoader
 
     @FXML // fx:id="tblvehiculos"
     private TableView<Vehiculo> tblvehiculos; // Value injected by FXMLLoader
 
     @FXML // fx:id="btntablatransacciones"
     private Button btntablatransacciones; // Value injected by FXMLLoader
 
     @FXML // fx:id="columnVehiculo"
     private TableColumn<Transaccion, String> columnVehiculo; // Value injected by FXMLLoader
 
     @FXML // fx:id="columncontraseña"
     private TableColumn<Cliente, String> columncontraseña; // Value injected by FXMLLoader
 
     @FXML // fx:id="columnfecha"
     private TableColumn<Transaccion, String> columnfecha; // Value injected by FXMLLoader
 
     @FXML // fx:id="btntablaclientes"
     private Button btntablaclientes; // Value injected by FXMLLoader
 
     @FXML // fx:id="columnpregunta"
     private TableColumn<Cliente, String> columnpregunta; // Value injected by FXMLLoader

 
     @FXML
     void GestionarVehiculoAction(ActionEvent event) {
        app.openGestionarVehiculo(empleado);
     }
 
     @FXML
     void gestionarVentaAction(ActionEvent event) {
        app.openGestionarTransacciones(empleado);
     }
 
     @FXML
     void GestionarClienteAction(ActionEvent event) {
        app.openGestionarClientes(empleado);
     }
 
     @FXML
     void MostrarTablaVehiculos(ActionEvent event) {
        OcultarTablas();
        tblvehiculos.setVisible(true);
     }
 
     @FXML
     void MostrarTablaTransacciones(ActionEvent event) {
        OcultarTablas();
        tbltransacciones.setVisible(true);
     }
 
     @FXML
     void MostrarTablaClientes(ActionEvent event) {
        OcultarTablas();
        tblclientes.setVisible(true);
     }
 
     @FXML
     void cerrarSesion(ActionEvent event) {
        app.openViewPrincipal();
     }
     public void setApp(App app) {
         this.app = app;
         transaccioncontroller = new TransaccionController(app.getConcesionario());
         vehiculocontroller = new VehiculoController(app.getConcesionario());
         personacontroller = new Personacontroller(app.getConcesionario());
     }

     public void setEmpleado(Empleado empleado) {
         this.empleado = empleado;
         initView();// Inicia la información de la tabla
     }

     private void initView() {
        initDataBinding();
        ObtenerTransacciones();
        ObtenerClientes();
        ObtenerVehiculos();
        tblclientes.getItems().clear();
        tblclientes.setItems(listaclientes);
        tbltransacciones.getItems().clear();
        tbltransacciones.setItems(listatransacciones);
        tblvehiculos.getItems().clear();
        tblvehiculos.setItems(listavehiculos);
        OcultarTablas();
        }
        
        public void ObtenerTransacciones(){
            listatransacciones.addAll(transaccioncontroller.ObtenerTransaccionesEmpleado(empleado));
        }
        public void ObtenerClientes(){
            listaclientes.addAll(personacontroller.ObtenerClientesEmpleado(empleado));
        }
        public void ObtenerVehiculos(){
            listavehiculos.addAll(vehiculocontroller.ObtenerVehiculosEmpleado(empleado));
        }
 
        private void OcultarTablas(){
            tblclientes.setVisible(false);
            tbltransacciones.setVisible(false);
            tblvehiculos.setVisible(false);
        }

        private void initDataBinding() {
            //Tabla vehiculos
            columnidvehiculo.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getIdVehiculo()));
            columnmarca.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getMarca()));
            columnmodelo.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getModelo()));
            columncambios.setCellValueFactory(cellData-> new SimpleStringProperty(cellData.getValue().getCambios().toString()));
            columnvelocidad.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getVelocidadMaxima().toString()));
            columncilindraje.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCilindraje().toString()));
            columntransmision.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTransmision().toString()));
            columnEstado.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getEstado().toString()));
            columntipo.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getClass().getSimpleName()));

            //Tabla transacciones
            columnidtransaccion.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getIdtransaccion()));
            columnfecha.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getFecha().toString()));
            columnprecio.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getPreciototal().toString()));
            columncliente.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCliente().getNombre() + " "+ cellData.getValue().getCliente().getCedula()));
            columnEmpleado.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getEmpleado().getIdEmpleado()+ " - "+ cellData.getValue().getEmpleado().getNombre()));
            columnVehiculo.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getVehiculo().getIdVehiculo()+ " - " + cellData.getValue().getVehiculo().getMarca()));
            columntipotransaccion.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getClass().getSimpleName()));

            //Tabla Clientes
            columnnombre.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombre()));
            columncedula.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCedula()));
            columncorreo.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCorreo()));
            columntelefono.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTelefono()));
            columnfechanacimiento.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getFechaNacimiento().toString()));
            columnusuario.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getUsuario()));
            columncontraseña.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getContraseña()));
            columnpregunta.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getPreguntaSeguridad()));
            columnfrase.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getFraseSeguridad()));
        }

     @FXML // This method is called by the FXMLLoader when initialization is complete
     void initialize() {
         assert columncorreo != null : "fx:id=\"columncorreo\" was not injected: check your FXML file 'EmpleadoView.fxml'.";
         assert btnRegistrarVehiculo != null : "fx:id=\"btnRegistrarVehiculo\" was not injected: check your FXML file 'EmpleadoView.fxml'.";
         assert columnfechanacimiento != null : "fx:id=\"columnfechanacimiento\" was not injected: check your FXML file 'EmpleadoView.fxml'.";
         assert columncambios != null : "fx:id=\"columncambios\" was not injected: check your FXML file 'EmpleadoView.fxml'.";
         assert columntipo != null : "fx:id=\"columntipo\" was not injected: check your FXML file 'EmpleadoView.fxml'.";
         assert columnidvehiculo != null : "fx:id=\"columnidvehiculo\" was not injected: check your FXML file 'EmpleadoView.fxml'.";
         assert btnCerrarSesion != null : "fx:id=\"btnCerrarSesion\" was not injected: check your FXML file 'EmpleadoView.fxml'.";
         assert columntransmision != null : "fx:id=\"columntransmision\" was not injected: check your FXML file 'EmpleadoView.fxml'.";
         assert btnGestionarVenta != null : "fx:id=\"btnGestionarVenta\" was not injected: check your FXML file 'EmpleadoView.fxml'.";
         assert columncliente != null : "fx:id=\"columncliente\" was not injected: check your FXML file 'EmpleadoView.fxml'.";
         assert columnmodelo != null : "fx:id=\"columnmodelo\" was not injected: check your FXML file 'EmpleadoView.fxml'.";
         assert columnidtransaccion != null : "fx:id=\"columnidtransaccion\" was not injected: check your FXML file 'EmpleadoView.fxml'.";
         assert btntablavehiculos != null : "fx:id=\"btntablavehiculos\" was not injected: check your FXML file 'EmpleadoView.fxml'.";
         assert columnmarca != null : "fx:id=\"columnmarca\" was not injected: check your FXML file 'EmpleadoView.fxml'.";
         assert columnprecio != null : "fx:id=\"columnprecio\" was not injected: check your FXML file 'EmpleadoView.fxml'.";
         assert columncilindraje != null : "fx:id=\"columncilindraje\" was not injected: check your FXML file 'EmpleadoView.fxml'.";
         assert columnvelocidad != null : "fx:id=\"columnvelocidad\" was not injected: check your FXML file 'EmpleadoView.fxml'.";
         assert tbltransacciones != null : "fx:id=\"tbltransacciones\" was not injected: check your FXML file 'EmpleadoView.fxml'.";
         assert columncedula != null : "fx:id=\"columncedula\" was not injected: check your FXML file 'EmpleadoView.fxml'.";
         assert btnRegistrarCliente != null : "fx:id=\"btnRegistrarCliente\" was not injected: check your FXML file 'EmpleadoView.fxml'.";
         assert columnEstado != null : "fx:id=\"columnEstado\" was not injected: check your FXML file 'EmpleadoView.fxml'.";
         assert columntelefono != null : "fx:id=\"columntelefono\" was not injected: check your FXML file 'EmpleadoView.fxml'.";
         assert columnnombre != null : "fx:id=\"columnnombre\" was not injected: check your FXML file 'EmpleadoView.fxml'.";
         assert columnusuario != null : "fx:id=\"columnusuario\" was not injected: check your FXML file 'EmpleadoView.fxml'.";
         assert columnEmpleado != null : "fx:id=\"columnEmpleado\" was not injected: check your FXML file 'EmpleadoView.fxml'.";
         assert columnfrase != null : "fx:id=\"columnfrase\" was not injected: check your FXML file 'EmpleadoView.fxml'.";
         assert columntipotransaccion != null : "fx:id=\"columntipotransaccion\" was not injected: check your FXML file 'EmpleadoView.fxml'.";
         assert tblclientes != null : "fx:id=\"tblclientes\" was not injected: check your FXML file 'EmpleadoView.fxml'.";
         assert tblvehiculos != null : "fx:id=\"tblvehiculos\" was not injected: check your FXML file 'EmpleadoView.fxml'.";
         assert btntablatransacciones != null : "fx:id=\"btntablatransacciones\" was not injected: check your FXML file 'EmpleadoView.fxml'.";
         assert columnVehiculo != null : "fx:id=\"columnVehiculo\" was not injected: check your FXML file 'EmpleadoView.fxml'.";
         assert columncontraseña != null : "fx:id=\"columncontraseña\" was not injected: check your FXML file 'EmpleadoView.fxml'.";
         assert columnfecha != null : "fx:id=\"columnfecha\" was not injected: check your FXML file 'EmpleadoView.fxml'.";
         assert btntablaclientes != null : "fx:id=\"btntablaclientes\" was not injected: check your FXML file 'EmpleadoView.fxml'.";
         assert columnpregunta != null : "fx:id=\"columnpregunta\" was not injected: check your FXML file 'EmpleadoView.fxml'.";
 
     }
 }
 
