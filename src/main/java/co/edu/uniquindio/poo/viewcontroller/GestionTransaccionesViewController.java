package co.edu.uniquindio.poo.viewcontroller;

/**
 * Sample Skeleton for 'GestionarTransaccionesView.fxml' Controller Class
 */

 import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import co.edu.uniquindio.poo.Controller.Personacontroller;
import co.edu.uniquindio.poo.Controller.TransaccionController;
import co.edu.uniquindio.poo.Controller.VehiculoController;
import co.edu.uniquindio.poo.application.App;
import co.edu.uniquindio.poo.model.Alquiler;
import co.edu.uniquindio.poo.model.Cliente;
import co.edu.uniquindio.poo.model.Empleado;
import co.edu.uniquindio.poo.model.Transaccion;
import co.edu.uniquindio.poo.model.Vehiculo;
import co.edu.uniquindio.poo.model.Venta;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
 import javafx.scene.control.CheckBox;
 import javafx.scene.control.ComboBox;
 import javafx.scene.control.DatePicker;
 import javafx.scene.control.TableColumn;
 import javafx.scene.control.TableView;
 import javafx.scene.control.TextField;
 
 public class GestionTransaccionesViewController {
 
    App app;
    Empleado empleado;
    Personacontroller personacontroller;
    TransaccionController transaccionController;
    VehiculoController vehiculoController;
    ObservableList<Transaccion> listatransacciones = FXCollections.observableArrayList();
    ObservableList<Vehiculo> listavehiculos = FXCollections.observableArrayList();
    ObservableList<Cliente> listaclientes = FXCollections.observableArrayList();
    ObservableList<String> tipotransaccion = FXCollections.observableArrayList("Alquiler", "Venta");
    Transaccion transaccionseleccionada;
    Cliente clienteseleccionado;
    Vehiculo vehiculoseleccionado;

     @FXML // ResourceBundle that was given to the FXMLLoader
     private ResourceBundle resources;
 
     @FXML // URL location of the FXML file that was given to the FXMLLoader
     private URL location;
 
     @FXML // fx:id="txtprecio"
     private TextField txtprecio; // Value injected by FXMLLoader
 
     @FXML // fx:id="columncorreo"
     private TableColumn<Cliente, String> columncorreo; // Value injected by FXMLLoader
 
     @FXML // fx:id="columntipo"
     private TableColumn<Transaccion, String> columntipo; // Value injected by FXMLLoader
 
     @FXML // fx:id="columnidvehiculo"
     private TableColumn<Vehiculo, String> columnidvehiculo; // Value injected by FXMLLoader
 
     @FXML // fx:id="tblvehiculo"
     private TableView<Vehiculo> tblvehiculo; // Value injected by FXMLLoader
 
     @FXML // fx:id="datefecha"
     private DatePicker datefecha; // Value injected by FXMLLoader
 
     @FXML // fx:id="columncliente"
     private TableColumn<Transaccion, String> columncliente; // Value injected by FXMLLoader
 
     @FXML // fx:id="columnmodelo"
     private TableColumn<Vehiculo, String> columnmodelo; // Value injected by FXMLLoader
 
     @FXML // fx:id="datedevolucion"
     private DatePicker datedevolucion; // Value injected by FXMLLoader
 
     @FXML // fx:id="txtid"
     private TextField txtid; // Value injected by FXMLLoader
 
     @FXML // fx:id="btnRegresar"
     private Button btnRegresar; // Value injected by FXMLLoader
 
     @FXML // fx:id="comboboxTipo"
     private ComboBox<String> comboboxTipo; // Value injected by FXMLLoader
 
     @FXML // fx:id="checkgarantia"
     private CheckBox checkgarantia; // Value injected by FXMLLoader
 
     @FXML // fx:id="columngarantia"
     private TableColumn<Transaccion, String> columngarantia; // Value injected by FXMLLoader
 
     @FXML // fx:id="columnprecio"
     private TableColumn<Transaccion, String> columnprecio; // Value injected by FXMLLoader
 
     @FXML // fx:id="columnmarca"
     private TableColumn<Vehiculo, String> columnmarca; // Value injected by FXMLLoader
 
     @FXML // fx:id="tbltransacciones"
     private TableView<Transaccion> tbltransacciones; // Value injected by FXMLLoader
 
     @FXML // fx:id="columnpago"
     private TableColumn<Transaccion, String> columnpago; // Value injected by FXMLLoader
 
     @FXML // fx:id="columncedula"
     private TableColumn<Cliente, String> columncedula; // Value injected by FXMLLoader
 
     @FXML // fx:id="columnid"
     private TableColumn<Transaccion, String> columnid; // Value injected by FXMLLoader
 
     @FXML // fx:id="txtpago"
     private TextField txtpago; // Value injected by FXMLLoader
 
     @FXML // fx:id="columntipovehiculo"
     private TableColumn<Vehiculo, String> columntipovehiculo; // Value injected by FXMLLoader
 
     @FXML // fx:id="btnEliminarTransaccion"
     private Button btnEliminarTransaccion; // Value injected by FXMLLoader
 
     @FXML // fx:id="columntelefono"
     private TableColumn<Cliente, String> columntelefono; // Value injected by FXMLLoader
 
     @FXML // fx:id="columnduracion"
     private TableColumn<Transaccion, String> columnduracion; // Value injected by FXMLLoader
 
     @FXML // fx:id="columnnombre"
     private TableColumn<Cliente, String> columnnombre; // Value injected by FXMLLoader
 
     @FXML // fx:id="btnActualizarTransaccion"
     private Button btnActualizarTransaccion; // Value injected by FXMLLoader
 
     @FXML // fx:id="columnempleado"
     private TableColumn<Transaccion, String> columnempleado; // Value injected by FXMLLoader
 
     @FXML // fx:id="txtalquiler"
     private TextField txtalquiler; // Value injected by FXMLLoader
 
     @FXML // fx:id="btnagregartransaccion"
     private Button btnagregartransaccion; // Value injected by FXMLLoader
 
     @FXML // fx:id="tblcliente"
     private TableView<Cliente> tblcliente; // Value injected by FXMLLoader
 
     @FXML // fx:id="columnvehiculo"
     private TableColumn<Transaccion, String> columnvehiculo; // Value injected by FXMLLoader
 
     @FXML // fx:id="columnfecha"
     private TableColumn<Transaccion, String> columnfecha; // Value injected by FXMLLoader
 
     @FXML // fx:id="columndevolucion"
     private TableColumn<Transaccion, String> columndevolucion; // Value injected by FXMLLoader
 
     
 
     @FXML
     void Regresar(ActionEvent event) {
        app.openEmpleado(empleado);
     }
 
     @FXML
     void EliminarTransaccion(ActionEvent event) {
        Transaccion transaccionselect = tbltransacciones.getSelectionModel().getSelectedItem();
        if (transaccionselect!= null) {
            String resultado = transaccionController.EliminarTransaccion(transaccionselect);
            mostrarmensaje("Eliminar Transaccion", resultado, AlertType.INFORMATION);
            if (resultado.equals("La transaccion se eliminó correctamente")) {
                listatransacciones.remove(transaccionselect);
                empleado.EliminarTransaccion(transaccionselect);
                Limpiarseleccion();
            }else{
                mostrarmensaje("Eliminacion de Transaccion", "Seleccione una transaccion de la tabla",
                AlertType.WARNING);
            }
        }
     }
 
     @FXML
     void ActualizarTransaccion(ActionEvent event) {
        Transaccion transaccionselect = tbltransacciones.getSelectionModel().getSelectedItem();
        String id = txtid.getText();
        LocalDate fecha = datefecha.getValue();
        String precio = txtprecio.getText();
        Cliente cliente = clienteseleccionado;
        Vehiculo vehiculo = vehiculoseleccionado;
        String metodopago = txtpago.getText();
        boolean garantia = checkgarantia.selectedProperty().getValue();
        LocalDate devolucion = datedevolucion.getValue();
        String dalquiler = txtalquiler.getText();
        boolean validar = Validardatos(id, fecha, precio, cliente, empleado, vehiculo, metodopago, garantia, devolucion, dalquiler);
        if (transaccionselect!= null) {
            if (validar) {
                if (comboboxTipo.getSelectionModel().getSelectedItem().equals("Alquiler")) {
                    Alquiler alquiler = new Alquiler(id, fecha, Float.parseFloat(precio), cliente, empleado, vehiculo, devolucion, Integer.parseInt(dalquiler));
                    String respuesta = transaccionController.ActualizarTransaccion(transaccionselect,alquiler);
                    mostrarmensaje("Actualizar Transaccion", respuesta, AlertType.INFORMATION);
                    if (respuesta.equals("La transacción ha sido actualizada")) {
                        listatransacciones.remove(transaccionselect);
                        listatransacciones.add(alquiler);
                        empleado.ActualizarTransaccion(transaccionselect, alquiler);
                        Limpiarseleccion();
                    }
                }else{
                    Venta venta = new Venta(id, fecha, Float.parseFloat(precio), cliente, empleado, vehiculo, metodopago, garantia);
                    String respuesta = transaccionController.ActualizarTransaccion(transaccionselect,venta);
                    mostrarmensaje("Actualizar Transaccion", respuesta, AlertType.INFORMATION);
                    if (respuesta.equals("La transacción ha sido actualizada")) {
                        listatransacciones.remove(transaccionselect);
                        listatransacciones.add(venta);
                        empleado.ActualizarTransaccion(transaccionselect, venta);
                        Limpiarseleccion();
                    }
                }
            }
        }else{
            mostrarmensaje("Actualizacion de Transaccion", "Seleccione una transaccion de la tabla",
                        AlertType.WARNING);
        }

     }
 
     @FXML
     void AgregarTransaccion(ActionEvent event) {
        String id = txtid.getText();
        LocalDate fecha = datefecha.getValue();
        String precio = txtprecio.getText();
        Cliente cliente = clienteseleccionado;
        Vehiculo vehiculo = vehiculoseleccionado;
        String metodopago = txtpago.getText();
        boolean garantia = checkgarantia.selectedProperty().getValue();
        LocalDate devolucion = datedevolucion.getValue();
        String dalquiler = txtalquiler.getText();
        boolean validar = Validardatos(id, fecha, precio, cliente, empleado, vehiculo, metodopago, garantia, devolucion, dalquiler);
        if (validar) {
            if (comboboxTipo.getSelectionModel().getSelectedItem().equals("Alquiler")) {
                Alquiler alquiler = new Alquiler(id, fecha, Float.parseFloat(precio), cliente, empleado, vehiculo, devolucion, Integer.parseInt(dalquiler));
                String respuesta = transaccionController.AgregarTransaccion(alquiler);
                mostrarmensaje("Agregar Transaccion", respuesta, AlertType.INFORMATION);
                if (respuesta.equals("La transaccion se añadió correctamente")) {
                    listatransacciones.add(alquiler);
                    empleado.AgregarTransaccion(alquiler);
                    Limpiarseleccion();
                }
            }else{
                Venta venta = new Venta(id, fecha, Float.parseFloat(precio), cliente, empleado, vehiculo, metodopago, garantia);
                String respuesta = transaccionController.AgregarTransaccion(venta);
                mostrarmensaje("Agregar Transaccion", respuesta, AlertType.INFORMATION);
                if (respuesta.equals("La transaccion se añadió correctamente")) {
                    listatransacciones.add(venta);
                    empleado.AgregarTransaccion(venta);
                    Limpiarseleccion();
                }
            }
        }
     }
 
     @FXML
     void TipoTransaccionAction(ActionEvent event) {
        LimpiarCampos();
        OcultarCampos();
        String seleccion = comboboxTipo.getSelectionModel().getSelectedItem();
        if (seleccion.equals("Alquiler")) {
            datedevolucion.setVisible(true);
            txtalquiler.setVisible(true);
        }
        if (seleccion.equals("Venta")) {
            checkgarantia.setVisible(true);
            txtpago.setVisible(true);
        }
     }
     public void setApp(App app) {
         this.app = app;
         transaccionController = new TransaccionController(app.getConcesionario());
         vehiculoController = new VehiculoController(app.getConcesionario());
         personacontroller = new Personacontroller(app.getConcesionario());
     }

     public void setEmpleado(Empleado empleado) {
         this.empleado = empleado;
         initView();
         
     }
     private void initView() {
        initDataBinding();
        ObtenerTransacciones();
        ObtenerClientes();
        ObtenerVehiculos();
        tblcliente.getItems().clear();
        tblcliente.setItems(listaclientes);
        tbltransacciones.getItems().clear();
        tbltransacciones.setItems(listatransacciones);
        tblvehiculo.getItems().clear();
        tblvehiculo.setItems(listavehiculos);
        OcultarCampos();
        listenerSelectionTransacciones();
        listenerSelectionCliente();
        listenerSelectionVehiculo();
        }

        public void ObtenerTransacciones(){
            listatransacciones.addAll(transaccionController.ObtenerTransaccionesEmpleado(empleado));
        }
        public void ObtenerClientes(){
            listaclientes.addAll(personacontroller.ObtenerClientesEmpleado(empleado));
        }
        public void ObtenerVehiculos(){
            listavehiculos.addAll(vehiculoController.ObtenerVehiculosEmpleado(empleado));
        }

        private void initDataBinding() {
            //Tabla vehiculos
            columnidvehiculo.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getIdVehiculo()));
            columnmarca.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getMarca()));
            columnmodelo.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getModelo()));
            columntipo.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getClass().getSimpleName()));

            //Tabla transacciones
            columnid.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getIdtransaccion()));
            columnfecha.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getFecha().toString()));
            columnprecio.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getPreciototal().toString()));
            columncliente.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCliente().getNombre() + " "+ cellData.getValue().getCliente().getCedula()));
            columnempleado.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getEmpleado().getIdEmpleado()+ " - "+ cellData.getValue().getEmpleado().getNombre()));
            columnvehiculo.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getVehiculo().getIdVehiculo()+ " - " + cellData.getValue().getVehiculo().getMarca()));
            columntipo.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getClass().getSimpleName()));
            columnduracion.setCellValueFactory(cellData -> {
                if (cellData.getValue() instanceof Alquiler) {
                    return new SimpleStringProperty(((Alquiler)cellData.getValue()).getDuracionalquiler().toString());
                }else{
                    return new SimpleStringProperty("N/A");
                }
            });
            columndevolucion.setCellValueFactory(cellData -> {
                if (cellData.getValue() instanceof Alquiler) {
                    return new SimpleStringProperty(((Alquiler)cellData.getValue()).getFechaDevolucion().toString());
                }else{
                    return new SimpleStringProperty("N/A");
                }
            });
            columnpago.setCellValueFactory(cellData -> {
                if (cellData.getValue() instanceof Venta) {
                    return new SimpleStringProperty(((Venta)cellData.getValue()).getMetodopago());
                }else{
                    return new SimpleStringProperty("N/A");
                }
            });
            columngarantia.setCellValueFactory(cellData -> {
                if (cellData.getValue() instanceof Venta) {
                    return new SimpleStringProperty(((Venta)cellData.getValue()).getGarantia().toString());
                }else{
                    return new SimpleStringProperty("N/A");
                }
            });

            //Tabla Clientes
            columnnombre.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombre()));
            columncedula.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCedula()));
            columncorreo.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCorreo()));
            columntelefono.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTelefono()));
            comboboxTipo.setItems(tipotransaccion);
        }

        private void listenerSelectionTransacciones() {
            tbltransacciones.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
                if (newSelection != null && !listatransacciones.isEmpty()) {
                    transaccionseleccionada = newSelection;
                    MostrarInformacionTransaccion(transaccionseleccionada);// Muestra la informacion del vehiculo seleccionado
                }
            });
        }
        private void listenerSelectionCliente() {
            tblcliente.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
                if (newSelection != null && !listaclientes.isEmpty()) {
                    clienteseleccionado = newSelection;
                }
            });
        }

        private void listenerSelectionVehiculo() {
            tblvehiculo.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
                if (newSelection != null && !listavehiculos.isEmpty()) {
                    vehiculoseleccionado = newSelection;
                }
            });
        }


        public void OcultarCampos(){
            txtpago.setVisible(false);
            checkgarantia.setVisible(false);
            datedevolucion.setVisible(false);
            txtalquiler.setVisible(false);
        }

        public void LimpiarCampos(){
            txtpago.clear();
            checkgarantia.setSelected(false);
            datedevolucion.setValue(null);
            txtalquiler.clear();
        }

        public void Limpiarseleccion(){
            LimpiarCampos();
            tbltransacciones.getSelectionModel().clearSelection();
            tblcliente.getSelectionModel().clearSelection();
            tblvehiculo.getSelectionModel().clearSelection();
            txtid.clear();
            datefecha.setValue(null);
            txtprecio.clear();
            comboboxTipo.getSelectionModel().clearSelection();
        }

        public void MostrarInformacionTransaccion(Transaccion transaccion){
            txtid.setText(transaccion.getIdtransaccion());
            datefecha.setValue(transaccion.getFecha());
            txtprecio.setText(transaccion.getPreciototal().toString());
            tblcliente.getSelectionModel().select(transaccion.getCliente());
            tblvehiculo.getSelectionModel().select(transaccion.getVehiculo());
            if (transaccion instanceof Alquiler) {
                comboboxTipo.setValue("Alquiler");
                datedevolucion.setValue(((Alquiler)transaccion).getFechaDevolucion());
                txtalquiler.setText(((Alquiler)transaccion).getFechaDevolucion().toString());
            }else{
                comboboxTipo.setValue("Venta");
                txtpago.setText(((Venta)transaccion).getMetodopago());
                checkgarantia.setSelected(((Venta)transaccion).getGarantia());
            }

        }

        public boolean Validardatos(String idtransaccion, LocalDate fecha, String preciototal, Cliente cliente, Empleado empleado, Vehiculo vehiculo, String metodopago, Boolean garantia, LocalDate fechaDevolucion, String duracionalquiler){
            if (idtransaccion.isEmpty() || fecha == null || preciototal.isEmpty() || cliente == null || empleado == null || vehiculo == null || (metodopago.isEmpty()) && (fechaDevolucion == null || duracionalquiler.isEmpty())) {
                            mostrarmensaje("Error", "Llene todos los datos correctamente", AlertType.WARNING);
                            return false;
            }
            if (!preciototal.isEmpty()) {
                try {
                    Float.parseFloat(preciototal);
                } catch (NumberFormatException e) {
                    mostrarmensaje("Error",  "El valor del precio debe ser númerico",
                            AlertType.WARNING);// Mensaje en caso de no ingresar valor numerico
                    return false;
                }
                
            }
            if (!duracionalquiler.isEmpty()) {// En caso de ser un auto el campo de puertas debe de ser numerico
                try {
                    Integer.parseInt(duracionalquiler);
                } catch (NumberFormatException e) {
                    mostrarmensaje("Error",  "El valor de duracion de alquiler debe ser númerico", AlertType.WARNING);// Mensaje
                                                                                                                            // en
                                                                                                                            // caso
                                                                                                                            // de
                                                                                                                            // no
                                                                                                                            // ingresar
                                                                                                                            // valor
                                                                                                                            // numerico
                    return false;
                }
            }

            return true;
        }
        
        public void mostrarmensaje(String titulo, String contenido, AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(contenido);
        alert.showAndWait();
    }
 
     @FXML // This method is called by the FXMLLoader when initialization is complete
     void initialize() {
         assert txtprecio != null : "fx:id=\"txtprecio\" was not injected: check your FXML file 'GestionarTransaccionesView.fxml'.";
         assert columncorreo != null : "fx:id=\"columncorreo\" was not injected: check your FXML file 'GestionarTransaccionesView.fxml'.";
         assert columntipo != null : "fx:id=\"columntipo\" was not injected: check your FXML file 'GestionarTransaccionesView.fxml'.";
         assert columnidvehiculo != null : "fx:id=\"columnidvehiculo\" was not injected: check your FXML file 'GestionarTransaccionesView.fxml'.";
         assert tblvehiculo != null : "fx:id=\"tblvehiculo\" was not injected: check your FXML file 'GestionarTransaccionesView.fxml'.";
         assert datefecha != null : "fx:id=\"datefecha\" was not injected: check your FXML file 'GestionarTransaccionesView.fxml'.";
         assert columncliente != null : "fx:id=\"columncliente\" was not injected: check your FXML file 'GestionarTransaccionesView.fxml'.";
         assert columnmodelo != null : "fx:id=\"columnmodelo\" was not injected: check your FXML file 'GestionarTransaccionesView.fxml'.";
         assert datedevolucion != null : "fx:id=\"datedevolucion\" was not injected: check your FXML file 'GestionarTransaccionesView.fxml'.";
         assert txtid != null : "fx:id=\"txtid\" was not injected: check your FXML file 'GestionarTransaccionesView.fxml'.";
         assert btnRegresar != null : "fx:id=\"btnRegresar\" was not injected: check your FXML file 'GestionarTransaccionesView.fxml'.";
         assert comboboxTipo != null : "fx:id=\"comboboxTipo\" was not injected: check your FXML file 'GestionarTransaccionesView.fxml'.";
         assert checkgarantia != null : "fx:id=\"checkgarantia\" was not injected: check your FXML file 'GestionarTransaccionesView.fxml'.";
         assert columngarantia != null : "fx:id=\"columngarantia\" was not injected: check your FXML file 'GestionarTransaccionesView.fxml'.";
         assert columnprecio != null : "fx:id=\"columnprecio\" was not injected: check your FXML file 'GestionarTransaccionesView.fxml'.";
         assert columnmarca != null : "fx:id=\"columnmarca\" was not injected: check your FXML file 'GestionarTransaccionesView.fxml'.";
         assert tbltransacciones != null : "fx:id=\"tbltransacciones\" was not injected: check your FXML file 'GestionarTransaccionesView.fxml'.";
         assert columnpago != null : "fx:id=\"columnpago\" was not injected: check your FXML file 'GestionarTransaccionesView.fxml'.";
         assert columncedula != null : "fx:id=\"columncedula\" was not injected: check your FXML file 'GestionarTransaccionesView.fxml'.";
         assert columnid != null : "fx:id=\"columnid\" was not injected: check your FXML file 'GestionarTransaccionesView.fxml'.";
         assert txtpago != null : "fx:id=\"txtpago\" was not injected: check your FXML file 'GestionarTransaccionesView.fxml'.";
         assert columntipovehiculo != null : "fx:id=\"columntipovehiculo\" was not injected: check your FXML file 'GestionarTransaccionesView.fxml'.";
         assert btnEliminarTransaccion != null : "fx:id=\"btnEliminarTransaccion\" was not injected: check your FXML file 'GestionarTransaccionesView.fxml'.";
         assert columntelefono != null : "fx:id=\"columntelefono\" was not injected: check your FXML file 'GestionarTransaccionesView.fxml'.";
         assert columnduracion != null : "fx:id=\"columnduracion\" was not injected: check your FXML file 'GestionarTransaccionesView.fxml'.";
         assert columnnombre != null : "fx:id=\"columnnombre\" was not injected: check your FXML file 'GestionarTransaccionesView.fxml'.";
         assert btnActualizarTransaccion != null : "fx:id=\"btnActualizarTransaccion\" was not injected: check your FXML file 'GestionarTransaccionesView.fxml'.";
         assert columnempleado != null : "fx:id=\"columnempleado\" was not injected: check your FXML file 'GestionarTransaccionesView.fxml'.";
         assert txtalquiler != null : "fx:id=\"txtalquiler\" was not injected: check your FXML file 'GestionarTransaccionesView.fxml'.";
         assert btnagregartransaccion != null : "fx:id=\"btnagregartransaccion\" was not injected: check your FXML file 'GestionarTransaccionesView.fxml'.";
         assert tblcliente != null : "fx:id=\"tblcliente\" was not injected: check your FXML file 'GestionarTransaccionesView.fxml'.";
         assert columnvehiculo != null : "fx:id=\"columnvehiculo\" was not injected: check your FXML file 'GestionarTransaccionesView.fxml'.";
         assert columnfecha != null : "fx:id=\"columnfecha\" was not injected: check your FXML file 'GestionarTransaccionesView.fxml'.";
         assert columndevolucion != null : "fx:id=\"columndevolucion\" was not injected: check your FXML file 'GestionarTransaccionesView.fxml'.";
 
     }
 }
 
